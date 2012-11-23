var loginEmailField = new Ext.form.TextField(
{
	allowBlank: false,	
	blankText:'必须输入Email',
	maxLength:30,
	maxLengthText:'Email的长度不能超过30个字符',
	vtype:'email',
	vtypeText:'Email的格式不对，应输入这样的格式：abc@126.com',
	fieldLabel : '您的Email',
    name:'email',
	anchor : '90%'
});
var loginPasswordField = new Ext.form.TextField(
{
	fieldLabel : '密码',
	inputType : 'password',
	name:'password',
	anchor : '90%'
});
var loginValidationCodeField = new Ext.form.TextField(
{
	allowBlank:false,
	blankText:'必须输入校验码',
	fieldLabel : '校验码',
	name:'validationCode',
	anchor : '90%'
});

function loginOnClick()
{

	loginForm.getForm().submit(
	{
		success : function(form, action)
		{
		    showInfoDialog(action.result.msg);
		    eval(unescape(action.result.script));
		    bLogin = true;
		    document.title="开心网欢迎" + loginEmailField.getValue();
		    welcomeMsg="欢迎" + loginEmailField.getValue();
		    loginEmailField.setValue("");
		    loginPasswordField.setValue("");
		    loginValidationCodeField.setValue("");
		    loginStateCombobox.setValue("");
			login.hide();
		},
		failure : function(form, action)
		{
			if(action.result != undefined)
				showErrorDialog(action.result.msg);

		}
	});

}

var btnLogin = new Ext.Button(
{
	name : 'login',
	text : '登录',
	handler : loginOnClick
});
var btnLoginRegister = new Ext.Button(
{
	name : 'loginregister',
	text : '注册',
	handler : function()
	{
		register.show();
	}
});

validationCodeImageFieldSet = new Ext.form.FieldSet(
		{
			xtype : 'column',
			border : false,
			style : 'margin-top:10px',
			items :
			[
					{
						xtype : 'label',
						html : '<a href="#" onclick="refreshValidationCodeImage()"><img src="validationCode" id="vcImg" onclick="src=\'validationCode?\' + new Date().getMilliseconds();" id="xyz"/></a>'
					},
					{
						xtype : 'label',
						style : 'margin-left:10px',
						html : '<a href="#" onclick="refreshValidationCodeImage()">换一张</a>'
					} ]
		});

var loginStateData = [
                ['0', '不自动登录'],
                ['1', '在一天内自动登录'],
                ['2','在一周内自动登录'],
                ['3', '在一个月内自动登录'],
                ['4', '在一年内自动登录']
                ];
var loginStateStore = new Ext.data.SimpleStore(
		{
			fields:['id', 'value'],
			data:loginStateData			
		}		
);
var loginStateCombobox = new Ext.form.ComboBox(
		{
			
			fieldLabel:'登录状态',
			store:loginStateStore,
			mode:'local',
			value:'0',
			triggerAction:'all',
			valueField:'id',
			displayField:'value',
			hiddenName : "loginStateId",
			readOnly:true,
			anchor : '90%'
		}		
);
var loginForm = new Ext.form.FormPanel(
{

	frame : true,
	labelAlign : 'right',
	labelWidth : 70,
	url : 'login.action',
	align : 'center',
	defaultType : 'textfield',
	items :
	[ loginEmailField, loginPasswordField, loginValidationCodeField,
			validationCodeImageFieldSet2,loginStateCombobox  ]
});
var login = new Ext.Window(
{
	title : '用户登录',
	layout : 'fit',
	modal : true,
	width : 300,
	height : 265,
	closeAction : 'hide',
	resizable : false,
	closable : false,
	buttons :
	[ btnLogin, btnLoginRegister ],
	items :
	[ loginForm ]
});
