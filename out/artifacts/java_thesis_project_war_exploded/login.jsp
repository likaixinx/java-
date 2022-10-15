
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" href="./static/css/login-style.css">
    <link rel="stylesheet" href="./static/css/alert.css">
    <script src="static/js/jquery-3.5.1.js"></script>
    <link rel="icon" type="image/png" href="./images/logo.webp">
    <script src="static/js/gt.js"></script>

    <script src="./static/js/alert.js"></script>
    <style>

        body{
            /* 初始化 取消内外边距 */
            margin: 0;
            padding: 0;
            /* 100%的窗口高度 */
            height: 100vh;
            /* 弹性布局 水平+垂直居中 */
            display: flex;
            justify-content: center;
            align-items: center;
            /* 渐变背景 */
            background: linear-gradient(125deg,#2c3e50,#27ae60,#2980b9,#e74c3c,#8e44ad);
            /* 指定背景图像的大小 */
            background-size: 500%;
            /* 执行动画方法 : 动画名 时长 线性的 无限次播放 */
            animation: bgAnimation 15s linear infinite;
        }


        /* 定义动画 */
        @keyframes bgAnimation{
            0%{
                background-position: 0% 50%;
            }
            50%{
                background-position: 100% 50%;
            }
            100%{
                background-position: 0% 50%;
            }
        }

    </style>
</head>

<body>

<h1 style="position: absolute;left: 39%;top: 6%">${sessionScope.msg}</h1>
<div class="loginBox">
    <h2 style="color: black;">欢迎来到员工信息管理系统</h2>
    <h2 style="color: black;">管理员请登录</h2>

        <div class="item">

            <input autocomplete="off" type="text"
                   id="username"   tabindex="1" name="username" required  maxlength="6">

            <label for="" style="color: black;font-weight: 700">账号</label>
        </div>
        <div class="item">

            <input autocomplete="off" type="password"
                   id="pwd" tabindex="2" required maxlength="16" name="pwd">
            <label for="" style="color: black;font-weight: 700">密码</label>
        </div>

        <div class="item">

            <input autocomplete="off" type="password"
                   id="yzm" tabindex="3" class="form-control" name="yzm" maxlength="4" required  style="margin-bottom: 10px" >

            <label for="" style="color: black;font-weight: 700">验证码</label>

            <script>

            </script>
            <img src="verification" id="verification"> <span style="color: black">看不清？点击图片换一张</span>
            <script>
                document.querySelector("#verification").onclick=function () {

                    document.querySelector("#verification").src="verification?"+new Date();
                }
            </script>
        </div>

        <center>
            <button class="btn" id="submit" style="color: black;font-weight: 700">登录

            </button></center>


        <script>


            document.getElementById('submit').onclick=function () {
               var username=document.getElementById('username').value

                var pwd=document.getElementById('pwd').value

                var yzm=document.getElementById('yzm').value


                if (username==''|| pwd==''||yzm==''){
                    new $Msg({
                        content:'请输入完整！',
                        type:"defeated",
                    })
                    return
                }

                    var xml=new XMLHttpRequest();
                    //发送post请求
                    xml.onreadystatechange=function (){
                        if (xml.readyState==4) {
                            if (xml.status==200){
                                console.log(xml.responseText)

                                if(xml.responseText=='验证码输入错误'){
                                    new $Msg({
                                        content:xml.responseText,
                                        type:"defeated",
                                    })
                                }else if(xml.responseText=='账号或密码输入错误'){
                                    new $Msg({
                                        content:xml.responseText,
                                        type:"defeated",
                                    })
                                    document.querySelector("#verification").src="verification?"+new Date();


                                }else {

                                    location.href="/java_thesis_project/dept/deptManage.html"
                                }
                            }
                        }
                    };
                    xml.open('post','loginServlet',true);
                    xml.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
                    xml.send("username="+username+"&pwd="+pwd+"&yzm="+yzm);

            }
        </script>



    <br>
    <a href="register.html" style="color: #000;font-size: 18px;font-weight: 700" id="register">没有账号?点击注册</a>

    <a href="forget.html" style="color: #000;margin-left: 70px;font-weight: 700;font-size: 18px" id="forget">忘记密码？</a>
</div>
</body>

</html>