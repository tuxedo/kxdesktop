 var registerEmailField = new Ext.form.TextField(
{
	allowBlank: false,	
	blankText:'必须输入Email',
	maxLength:30,
	maxLengthText:'Email的长度不能超过30个字符',
	vtype:'email',
	vtypeText:'Email的格式不对，应输入这样的格式：abc@126.com',
	name : 'email',
	id:'email', 
	fieldLabel : '您的Email'
});
var registerPasswordField = new Ext.form.TextField(
{
	allowBlank: false,	
	blankText:'必须输入密码',
	name : 'password',
	fieldLabel : '设置开心网密码',
	inputType : 'password'
});
function validatePassword(value)
{
	if(registerPasswordField.getValue() == "")
		return true;
	if(value == registerPasswordField.getValue())
	{
		return true;
	}
	else
	{
		return false;
	}
}
var registerRePasswordField = new Ext.form.TextField(
{
	fieldLabel : '再输入一遍密码',
	inputType : 'password',
	validator:validatePassword,
	invalidText:'两次输入的密码必须一致'
 

});

var registerLoginFieldSet = new Ext.form.FieldSet(
{
	title : '用于登录的信息',
	autoHeight : true,
	border : true,
	layout : 'form',
	items :
	[ registerEmailField, registerPasswordField, registerRePasswordField ]
});

var registerValidationCodeFieldSet = new Ext.form.FieldSet(
{

	title : '校验',
	autoHeight : true,
	border : true,
	layout : 'form',
	defaultType : 'textfield',
	items :
	[
	{	allowBlank:false,
		blankText:'必须输入校验码',
		name : 'validationCode',
		fieldLabel : '请输入校验码'
	}, validationCodeImageFieldSet1 ]
});

var leftPanel = new Ext.Panel(
{
	layout : 'form',
	columnWidth : .4,
	items :
	[ registerLoginFieldSet, registerValidationCodeFieldSet ]
});

// ///////////////个人信息///////////////////////////

var registerNameField = new Ext.form.TextField(
{
	allowBlank:false,
	blankText:'必须输入姓名',
	minLength:6,
	maxLength:20, 
	name : 'name',
	fieldLabel : '您的姓名',
	anchor : '85%'
})

var sexStore = new Ext.data.Store(
{
	proxy : new Ext.data.HttpProxy(
	{
		url : 'sex.action'
	}),
	reader : new Ext.data.ArrayReader(
	{},
	[
	{
		name : 'id'
	},
	{
		name : 'name'
	} ])
});
sexStore.load();
var sexField = new Ext.form.ComboBox(
{
	allowBlank: false,	
	blankText:'必须选择性别',
	name : 'sex',
	store : sexStore,
	fieldLabel : '性别',
	mode : 'remote',
	triggerAction : 'all',
	valueField : 'id',
	displayField : 'name',
	hiddenName : "sexId",
	minListWidth : 220,
	anchor : '85%',
	readOnly : true
});

var birthdayField = new Ext.form.DateField(
{
	allowBlank: false,	
	blankText:'必须输入出生日期',
	name : 'birthday',
	fieldLabel : '出生日期',
	format : 'Y-m-d',
	anchor : '85%'
});


var selectMenu;
var cityHiddenField = new Ext.form.Hidden(
{
	name : 'cityId'
});
var cityField = new Ext.form.TriggerField(
		{
			allowBlank: false,	
			blankText:'必须输入居住城市',
			fieldLabel : '居住城市',
			anchor : '85%',
			readOnly : true,
			onTriggerClick : function()
			{
				//  如果用户未选择省或市时，这时menu并未销毁。在这里应销毁menu
			if (selectMenu != undefined)
				selectMenu.destroy();
			selectMenu = new Ext.menu.Menu(
			{

			})
			this.menu = selectMenu;
			this.menu.show(this.el);

			Ext.Ajax
					.request(
					{
						url : 'provinces.action',
						success : function(response)
						{

							selectMenu
									.add(new Ext.Panel(
											{
												id : 'provinceCity',
												width : '520px',
												border : false,
												buttons :
												[
												{
													text : '关闭',
													handler : function()
													{
														selectMenu.destroy();
													}
												} ],
												items :
												[
														new Ext.Panel(
																{
																	border : false,
																	style : 'margin-left:20px;margin-top:20px;margin-bottom:20px',
																	html : response.responseText
																})]

											}))
						}
					});
		}
		});

// 在provinces.jsp页面中调用的获得指定省的所有市的方法
var citiesPanel;
function cities(provinceId, provinceName)
{
	selectMenu.remove(citiesPanel, true);
	Ext.Ajax.request(
	{
		url : 'cities.action?provinceId=' + provinceId,
		success : function(response)
		{

			if (response.responseText == "empty")
			{
			
				cityField.setValue(provinceName);
				cityHiddenField.setValue(provinceId);

				selectMenu.destroy();
			} else
			{
				citiesPanel = new Ext.Panel(
				{
					id : 'citiesPanel',
					border : false,
					style : 'margin-left:20px;margin-top:30px',
					html : response.responseText
				});
				selectMenu.get('provinceCity').setHeight(200);
				selectMenu.get('provinceCity').add(citiesPanel);
			}

		}
	});

}
function cityOnClick(cityId, cityName)
{
	cityField.setValue(cityName);
	cityHiddenField.setValue(cityId);
	selectMenu.destroy();
}

var statusStore = new Ext.data.Store(
{
	proxy : new Ext.data.HttpProxy(
	{
		url : 'status.action'
	}),
	reader : new Ext.data.ArrayReader(
	{},
	[
	{
		name : 'id'
	},
	{
		name : 'name'
	} ])
});
statusStore.load();
var statusField = new Ext.form.ComboBox(
{
	allowBlank: false,	
	blankText:'必须输入目前身份',
	name : 'status',
	store : statusStore,
	fieldLabel : '目前身份',
	mode : 'remote',
	triggerAction : 'all',
	valueField : 'id',
	displayField : 'name',
	hiddenName : 'statusId',
	minListWidth : 220,
	anchor : '85%',
	readOnly : true
});

var companyField = new Ext.form.TextField(
{
	maxLength:30,
	maxLengthText:'工作单位的长度不能超过30个字符',

	name : 'company',
	fieldLabel : '工作单位',
	anchor : '85%'

});
var rightFieldSet = new Ext.form.FieldSet(
{
	title : '个人信息',
	columnWidth : .52,
	height : 237,
	style : 'margin-left:20px',
	items :
	[
	{
		defaultType : 'textfield',
		layout : 'form',
		items :
		[ registerNameField, sexField, birthdayField, cityField, statusField,
				companyField, cityHiddenField ]
	} ]
});
// //////////////////////////////////////////////////
var registerForm = new Ext.form.FormPanel(
{
	labelAlign : 'right',
	labelWidth : 100,
	url : 'register.action',
	frame : true,
	items :
	[
	{
		layout : 'column',
		items :
		[ leftPanel, rightFieldSet ]
	} ]
});
var register = new Ext.Window(
{
	title : '用户注册',
	layout : 'fit',
	modal : true,
	width : 650,
	height : 340,
	closeAction : 'hide',
	resizable : false,
	items :
	[ registerForm ],
	buttons :
	[
	{
		text : '注册',
		handler : registerOnClick
	} ]

});
Ext.QuickTips.init();
function registerOnClick()
{
	
	registerForm.getForm().submit(
	{
		success : function(form, action)
		{
  		    showInfoDialog(action.result.msg);  			
			register.hide();
		},
		failure : function(form, action)
		{
			if(action.result != undefined)
			    showErrorDialog(action.result.msg);

		}
	});


}
function sexCallback(r, options, success)
{
	var i = 0;
	if (success)
	{
		sexFieldSet.get("sexBoy").boxLabel = 'a';
	}
}

register.on('beforeshow', function()
{
	registerEmailField.setValue('');
})
