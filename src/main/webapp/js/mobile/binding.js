var wait = 60;

function countDown(o) {
    if (wait == 0) {
        $("#getCode").removeAttr("disabled");
        $("#getCode").text("获取验证码");
        wait = 60;
    } else {
        $("#getCode").attr("disabled", true);
        $("#getCode").text("重新发送" + wait);
        wait--;
        setTimeout(function () {
            countDown(o)
        }, 1000);
    }
}

function check_phone() {

    var input = $("#inputUserPhone").val();

    // 判断userName的值符合手机号的正则表达式
    var phoneReg = /^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\d{8}$/;

    if (!input.match(phoneReg)) {

        $("#phone-group").addClass("has-error has-feedback");
        $("#phone-group-span").addClass("glyphicon glyphicon-remove");
        $("#getCode").attr("disabled", true);
        return false;

    }

    $("#phone-group").removeClass("has-error");
    $("#phone-group-span").removeClass("glyphicon-remove");
    $("#phone-group").addClass("has-success");
    $("#phone-group-span").addClass("glyphicon-ok");
    $("#getCode").removeAttr("disabled");

}

function check_pass() {

    var pass = $("#inputPassword").val();
    var regStr = /^\S{8,30}$/;

    if (!pass.match(regStr)) {

        alert("密码位数必须大于8位");
        return false;

    }

    var phone = $("#inputUserPhone").val();
    var code = $("#inputVerificationCode").val();

    $.post(
        "checkCode.do",
        {
            "phone": phone,
            "code": code,
            "password": pass
        },
        function (res) {
            if (res.success) {

                window.location.href = "/IN_Fit/view/toTable.do";

            } else {
                alert(res.message);
                return false;
            }
        }
    )

}

function check_pass_ago() {

    var pass = $("#inputPassword").val();
    var passAgo = $("#inputPasswordAgo").val();

    if (pass != passAgo) {

        $("#inputPasswordAgo-group").addClass("has-error has-feedback");
        $("#inputPasswordAgo-group-span").addClass("glyphicon glyphicon-remove");
        $("#login_button").attr("disabled", true);
        return false;

    }

    $("#inputPasswordAgo-group").removeClass("has-error");
    $("#inputPasswordAgo-group-span").removeClass("glyphicon-remove");
    $("#inputPasswordAgo-group").addClass("has-success");
    $("#inputPasswordAgo-group-span").addClass("glyphicon-ok");
    $("#login_button").removeAttr("disabled");

}


