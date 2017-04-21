<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8">
    <title>iview example</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <link rel="stylesheet" type="text/css" href="http://unpkg.com/iview/dist/styles/iview.css">
    <script type="text/javascript" src="http://v1.vuejs.org/js/vue.min.js"></script>
    <script type="text/javascript" src="http://unpkg.com/iview/dist/iview.min.js"></script>
</head>
<body>
<div id="app">
    <i-button @click="show">Click me!</i-button>
    <Modal :visible.sync="visible" title="Welcome">欢迎使用 iView</Modal>
</div>
<script>
    new Vue({
        el: '#app',
        data: {
            visible: false
        },
        methods: {
            show: function () {
                /* this.visible = true; */
                alert(000);
                $.post('${pageContext.request.contextPath}/userController/showUser.do',
                 		{
                        	id:0,
                        }, function(result) {
                        console.log(result);
                        alert(result);
                        
                        },'html');
            }
        }
    })
  </script>
</body>
</html>
