

MyDesktop = new Ext.app.App( {
	init : function() {
		Ext.QuickTips.init();
	},

	getModules : function() {
		return [ new ControlPanelWindow(), new DesktopIconsWindow() ];
	},
  
	// 配置开始菜单
	getStartConfig : function() {
		return {
			title :'开心菜单',
			iconCls :'user',
			toolItems : [ {
				text :'注销',
				iconCls :'logout',
				handler : function() {
					if (bLogin == false) return;
					if (myDesktop != undefined)
						myDesktop.closeAll();
					Ext.Ajax.request(
					{
						url : 'logout.action'});
					
									 
					bLogin = false;	
					loginStateCombobox.setValue("0");
					login.show();
					refreshValidationCodeImage2();
					
				},
				scope :this
			} ]
		};
	}   
});



