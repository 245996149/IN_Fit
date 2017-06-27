<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>数据详情</title>

    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${pageContext.request.contextPath}/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${pageContext.request.contextPath}/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script language="javascript" type="text/javascript"
            src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script language="javascript" type="text/javascript"
            src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

    <script type="text/javascript">

        //网页加载后执行函数
        window.onload = function () {

            //判断是否为微信内核
            if (isWeixin()) {
                //是微信打开

                var url = location.href;
                $.post(
                    "getWeChatInfo.do",
                    {
                        "url": url
                    },
                    function (res) {

                        wx.config({
                            debug: false,
                            appId: res.appid,
                            timestamp: res.timestamp,
                            nonceStr: res.nonceStr,
                            signature: res.signature,
                            jsApiList: ['checkJsApi', 'onMenuShareTimeline',
                                'onMenuShareAppMessage', 'onMenuShareQQ', 'onMenuShareWeibo',
                                'hideMenuItems', 'showMenuItems', 'hideAllNonBaseMenuItem',
                                'showAllNonBaseMenuItem', 'translateVoice', 'startRecord',
                                'stopRecord', 'onRecordEnd', 'playVoice', 'pauseVoice',
                                'stopVoice', 'uploadVoice', 'downloadVoice', 'chooseImage',
                                'previewImage', 'uploadImage', 'downloadImage',
                                'getNetworkType', 'openLocation', 'getLocation',
                                'hideOptionMenu', 'showOptionMenu', 'closeWindow',
                                'scanQRCode', 'chooseWXPay', 'openProductSpecificView',
                                'addCard', 'chooseCard', 'openCard']
                        });

                        wx.ready(function () {

                            wx.hideAllNonBaseMenuItem();

                        });
                    })

            }

        }

        //这个函数用来判断当前浏览器是否微信内置浏览器，是微信返回true，不是微信返回false
        function isWeixin() {
            var WxObj = window.navigator.userAgent.toLowerCase();
            if (WxObj.match(/microMessenger/i) == 'micromessenger') {
                return true;
            } else {
                return false;
            }
        }

    </script>

</head>
<body>
<div class="row">
    <div class="col-md-12 col-xs-12 col-lg-12">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>数据名</th>
                <th>数据值</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>测量时间</td>
                <td><fmt:formatDate value="${user_data.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
            <tr>
                <td>2</td>
                <td>体重</td>
                <td>${user_data.weight}</td>
            </tr>
            <tr>
                <td>3</td>
                <td>身高</td>
                <td>${user_data.height}</td>
            </tr>
            <tr>
                <td>4</td>
                <td>腰高</td>
                <td>${user_data.highWaist}</td>
            </tr>
            <tr>
                <td>5</td>
                <td>足踝高</td>
                <td>${user_data.ankleHigh}</td>
            </tr>
            <tr>
                <td>6</td>
                <td>膝盖高</td>
                <td>${user_data.kneeHigh}</td>
            </tr>
            <tr>
                <td>7</td>
                <td>裆高</td>
                <td>${user_data.doesHigh}</td>
            </tr>
            <tr>
                <td>8</td>
                <td>臀高</td>
                <td>${user_data.hipHigh}</td>
            </tr>
            <%--<tr>--%>
                <%--<td>9</td>--%>
                <%--<td>脚长</td>--%>
                <%--<td>${user_data.feetLong}</td>--%>
            <%--</tr>--%>
            <tr>
                <td>9</td>
                <td>后背长</td>
                <td>${user_data.backLength}</td>
            </tr>
            <tr>
                <td>10</td>
                <td>前腰节长</td>
                <td>${user_data.frontWaistLength}</td>
            </tr>
            <tr>
                <td>11</td>
                <td>前胸长</td>
                <td>${user_data.chestLong}</td>
            </tr>
            <%--<tr>--%>
                <%--<td>13</td>--%>
                <%--<td>胸宽</td>--%>
                <%--<td>${user_data.chestWidth}</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>14</td>--%>
                <%--<td>背宽</td>--%>
                <%--<td>${user_data.backWidth}</td>--%>
            <%--</tr>--%>
            <tr>
                <td>12</td>
                <td>肩长</td>
                <td>${user_data.shoulderLength}</td>
            </tr>
            <tr>
                <td>13</td>
                <td>臀腰长</td>
                <td>${user_data.hipWaistLong}</td>
            </tr>
            <%--<tr>--%>
                <%--<td>14</td>--%>
                <%--<td>大腿内长</td>--%>
                <%--<td>${user_data.theThighInsideLong}</td>--%>
            <%--</tr>--%>
            <tr>
                <td>14</td>
                <td>臂长</td>
                <td>${user_data.armLength}</td>
            </tr>
            <tr>
                <td>15</td>
                <td>上臂长</td>
                <td>${user_data.upperArmLength}</td>
            </tr>
            <%--<tr>--%>
                <%--<td>20</td>--%>
                <%--<td>躯干长度</td>--%>
                <%--<td>${user_data.lengthOfTheTrunk}</td>--%>
            <%--</tr>--%>
            <tr>
                <td>16</td>
                <td>裆总长</td>
                <td>${user_data.forkLength}</td>
            </tr>
            <tr>
                <td>17</td>
                <td>头围</td>
                <td>${user_data.headCircumference}</td>
            </tr>
            <tr>
                <td>18</td>
                <td>颈围</td>
                <td>${user_data.neckCircumference}</td>
            </tr>
            <%--<tr>--%>
                <%--<td></td>--%>
                <%--<td>上胸围</td>--%>
                <%--<td>${user_data.onTheChest}</td>--%>
            <%--</tr>--%>
            <tr>
                <td>19</td>
                <td>胸围</td>
                <td>${user_data.theChest}</td>
            </tr>
            <%--<tr>--%>
                <%--<td>26</td>--%>
                <%--<td>下胸围</td>--%>
                <%--<td>${user_data.underTheChest}</td>--%>
            <%--</tr>--%>
            <tr>
                <td>20</td>
                <td>上腰围净中腰</td>
                <td>${user_data.onTheWaistWaistInTheNet}</td>
            </tr>
            <tr>
                <td>21</td>
                <td>中腰围</td>
                <td>${user_data.inTheWaist}</td>
            </tr>
            <tr>
                <td>22</td>
                <td>裤腰围</td>
                <td>${user_data.waistbandIsSurrounded}</td>
            </tr>
            <tr>
                <td>23</td>
                <td>臀围</td>
                <td>${user_data.hipCircumference}</td>
            </tr>
            <tr>
                <td>24</td>
                <td>大腿围</td>
                <td>${user_data.thighCircumference}</td>
            </tr>
            <tr>
                <td>25</td>
                <td>大腿中围</td>
                <td>${user_data.inTheThighCircumference}</td>
            </tr>
            <tr>
                <td>26</td>
                <td>膝围</td>
                <td>${user_data.kneeCircumference}</td>
            </tr>
            <tr>
                <td>27</td>
                <td>足踝围</td>
                <td>${user_data.ankleCircumference}</td>
            </tr>
            <%--<tr>--%>
                <%--<td>35</td>--%>
                <%--<td>足跟围</td>--%>
                <%--<td>${user_data.heelsCircumference}</td>--%>
            <%--</tr>--%>
            <tr>
                <td>28</td>
                <td>臂根围</td>
                <td>${user_data.armRhizosphere}</td>
            </tr>
            <tr>
                <td>29</td>
                <td>上臂围</td>
                <td>${user_data.upperArmCircumference}</td>
            </tr>
            <tr>
                <td>30</td>
                <td>肘围</td>
                <td>${user_data.elbowCircumference}</td>
            </tr>
            <tr>
                <td>31</td>
                <td>腕围</td>
                <td>${user_data.wristCircumference}</td>
            </tr>
            <%--<tr>--%>
                <%--<td>40</td>--%>
                <%--<td>下摆围</td>--%>
                <%--<td>${user_data.hemCircumference}</td>--%>
            <%--</tr>--%>
            <tr>
                <td>32</td>
                <td>脚口</td>
                <td>${user_data.footMouth}</td>
            </tr>
            <tr>
                <td>33</td>
                <td>前衣长</td>
                <td>${user_data.beforeTheLength}</td>
            </tr>
            <tr>
                <td>34</td>
                <td>后衣长</td>
                <td>${user_data.afterTheLength}</td>
            </tr>
            <tr>
                <td>35</td>
                <td>袖长</td>
                <td>${user_data.sleeveLength}</td>
            </tr>
            <tr>
                <td>36</td>
                <td>裤长</td>
                <td>${user_data.length}</td>
            </tr>
            <tr>
                <td>37</td>
                <td>直裆</td>
                <td>${user_data.straightCrotch}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>


</body>
</html>
