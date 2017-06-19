<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>绑定手机号</title>

    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/mobile/binding.js"></script>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${pageContext.request.contextPath}/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/sign_in.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${pageContext.request.contextPath}/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <%--<form class="form-signin">--%>
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <h2 class="form-signin-heading">绑定您的手机号</h2>
            <div class="form-group" id="phone-group">
                <label for="inputUserPhone" class="sr-only">手机号</label>
                <input type="number" id="inputUserPhone" class="form-control" placeholder="手机号" required autofocus
                       oninput="check_phone()" pattern="[0-9]*">
                <span class="form-control-feedback" aria-hidden="true" id="phone-group-span"></span>
            </div>
            <br>
            <div class="row">
                <div class="col-xs-6 col-md-6" style="padding-left: 0;">
                    <label for="inputVerificationCode" class="sr-only">验证码</label>
                    <input type="number" id="inputVerificationCode" class="form-control" placeholder="验证码" required
                           readonly pattern="[0-9]*">
                </div>
                <div class="col-xs-6 col-md-6">
                    <button class="btn btn-lg btn-primary btn-block" id="getCode" disabled="disabled">获取验证码</button>
                </div>
            </div>
            <br>
            <label for="inputPassword" class="sr-only">密码</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="密码" required readonly>
            <br>
            <div class="form-group" id="inputPasswordAgo-group">
                <label for="inputPasswordAgo" class="sr-only">再一次输入密码</label>
                <input type="password" id="inputPasswordAgo" class="form-control" placeholder="再一次输入密码" required
                       oninput="check_pass_ago()" readonly>
                <span class="form-control-feedback" aria-hidden="true" id="inputPasswordAgo-group-span"></span>
            </div>
            <button id="login_button" class="btn btn-lg btn-primary btn-block" disabled="disabled" onclick="check_pass();">绑&nbsp;定</button>

        </div>
        <div class="col-md-4"></div>
    </div>

</div>

<script type="text/javascript">

    $('#getCode').on('click', function () {

        $("#inputVerificationCode").removeAttr("readonly");
        $("#inputPassword").removeAttr("readonly");
        $("#inputPasswordAgo").removeAttr("readonly");

        var phone = $("#inputUserPhone").val();

        $.post(
            "getCode.do",
            {"phone": phone},
            function (res) {
                if (!res.success) {
                    alert(res.message);
                } else {
                    countDown(this);
                }
            }
        );

    });

</script>

</body>
</html>
