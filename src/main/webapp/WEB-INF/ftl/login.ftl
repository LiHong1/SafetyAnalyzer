<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>登录</title>
    <meta name="keywords" content="防诈骗系统">
    <meta name="description" content="防诈骗系统">

    <link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <!-- <link href="font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet"> -->

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=2.2.0" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h6 class="logo-name">欢迎登录防诈骗系统</h6>

            </div>

            <form class="m-t" role="form" action="/login" method="post">
                <div class="form-group">
                    <input id="username" type="text" name="username" class="form-control" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input id="password" type="password" name="password" class="form-control" placeholder="密码" required="">
                    <#if error??>
                        <div><span style="color:red">${error.errorCode.message}</span></div>
                    </#if>
                </div>
                <button id="submit" type="submit" class="btn btn-primary block full-width m-b">登 录</button>


                <p class="text-muted text-center"> <a href="login.html#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>
                </p>

            </form>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/bootstrap.min.js?v=3.4.0"></script>

    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script><!--统计代码，可删除-->

</body>

</html>
