<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://nokiaguy.blogjava.net/tag" prefix="myTag"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="../script/resources/css/ext-all.css" />
<link rel="stylesheet" type="text/css"
	href="../script/resources/css/ext-patch.css" />
<link rel="stylesheet" type="text/css" href="../css/desktop.css" />

<!-- GC -->
<!-- LIBS -->
<script type="text/javascript" src="../script/ext-base.js"></script>
<!-- ENDLIBS -->
<script type="text/javascript" src="../script/ext-all.js"></script>
<script type="text/javascript" src="../script/locale/ext-lang-zh_CN.js"></script>

<!--   引用模拟操作系统桌面的脚本文件 -->
<script type="text/javascript" src="../script/desktop/StartMenu.js"></script>
<script type="text/javascript" src="../script/desktop/TaskBar.js"></script>
<script type="text/javascript" src="../script/desktop/Desktop.js"></script>
<script type="text/javascript" src="../script/desktop/App.js"></script>
<script type="text/javascript" src="../script/desktop/Module.js"></script>
<script type="text/javascript" src="../script/kxw/kxdesktop.js"></script>
<script type="text/javascript" src="../script/kxw/control_panel.js"></script>
<script type="text/javascript" src="../script/kxw/variable.js"></script>
<script type="text/javascript" src="../script/kxw/desktop_icons.js"></script>
<script type="text/javascript" src="../script/kxw/common.js"></script>
<script type="text/javascript" src="../script/kxw/login.js"></script>
<script type="text/javascript" src="../script/kxw/register.js"></script>


<title>开心网欢迎${email}</title>
</head>
<body scroll="no">

<div
	style="width: 100%; height: 100%; position: absolute; z-index: -1; top: 0px;">

</div>

<div id="x-desktop">

<dl id="x-shortcuts">
	<s:action name="allDesktopIcons" />
</dl>
</div>

<script type="text/javascript">
	Ext.BLANK_IMAGE_URL = "../script/resources/images/default/s.gif";
	Ext.onReady( function()
	{
		try
		{
			createDesktopIconsObject();
			showDesktopIcons();
		} catch (e)
		{
		}
	});
</script>

<myTag:login />

<div id="ux-taskbar">
<div id="ux-taskbar-start"></div>
<div id="ux-taskbuttons-panel"></div>
<div class="x-clear"></div>
</div>


</body>
</html>

