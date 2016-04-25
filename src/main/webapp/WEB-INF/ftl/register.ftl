<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>防诈骗系统 - 注册</title>
    <meta name="keywords" content="防诈骗系统">
    <meta name="description" content="防诈骗系统">

    <link href="${basePath}/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${basePath}/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">
    <link href="${basePath}/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${basePath}/css/animate.css" rel="stylesheet">
    <link href="${basePath}/css/style.css?v=2.2.0" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div>
            <div>

                <h6 class="logo-name">防诈骗系统</h6>

            </div>
            <h3>欢迎注册新账户 </h3>
	                <div class="form-group">
	                    <input type="text" id="phone" class="form-control" placeholder="请输入手机号" required="required">
	                </div>
	                <div class="form-group">
	                    <input type="text" id="username" class="form-control" placeholder="请输入用户名"  required="required">
	                </div>
	                <div class="form-group">
	                    <input type="password" id="password1" class="form-control" placeholder="请输入密码"  required="required">
	                </div>
	                <div class="form-group">
	                    <input type="password" id="password2" class="form-control" placeholder="请再次输入密码"  required="required">
	                </div>
	                <div class="form-group text-left">
	                    <div class="checkbox i-checks">
	                        <label class="no-padding">
	                            <input type="checkbox"><i></i> 我同意注册协议</label>
	                    </div>
	                </div>
	                <button type="submit" id="register" class="btn btn-primary block full-width m-b">注 册</button>
	
	                <p class="text-muted text-center"><small>已经有账户了？</small><a href="login">点此登录</a>
	                </p>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="${basePath}/js/jquery-2.1.1.min.js"></script>
    <script src="${basePath}/js/bootstrap.min.js?v=3.4.0"></script>
    <!-- iCheck -->
    <script src="${basePath}/js/plugins/iCheck/icheck.min.js"></script>
    
    <script>
        $(document).ready(function () {
        	
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
            $("#register").on("click",function(){
                   $.ajax({
                        type: "post",
                        dataType: "json",
                        url: "register",
                        data:{
                          phone:$("#phone").val(),
                          username:$("#username").val(),
                          password1:$("#password1").val(),
                          password2:$("#password2").val()
                        },
                        success: function (data) {
                            if(data != ""){
                               alert(data.message);
                               if(data.status == 0){
                                 window.location.href = $("#basePath").html()+"/login";   
                               }
                            }
                        }
                       });
            
            });
        });
    </script>


</body>

</html>
