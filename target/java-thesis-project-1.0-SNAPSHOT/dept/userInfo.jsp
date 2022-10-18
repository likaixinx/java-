<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html class="no-js">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>个人信息</title>
    <meta name="keywords" content="user">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="../images/logo.webp">
    <link rel="apple-touch-icon-precomposed" href="../amazeui/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="../amazeui/css/amazeui.min.css" />
    <link rel="stylesheet" href="../amazeui/css/admin.css">
    <link rel="stylesheet" href="../amazeui/plugin/amazeui.cropper.css">
    <link rel="stylesheet" href="../amazeui/plugin/custom_up_img.css">
    <link rel="stylesheet" href="../css/default.css">
    <script src="../static/js/jquery-3.5.1.js"></script>
    <script src="../amazeui/js/amazeui.js"></script>
    <script src="../amazeui/js/app.js"></script>
    <script src="../amazeui/plugin/cropper.min.js" charset="utf-8"></script>
    <script src="../amazeui/plugin/custom_up_img.js" charset="utf-8"></script>
</head>

<body>
       <header class="am-topbar am-topbar-inverse admin-header">
        <div class="am-topbar-brand">
            <strong>ITANY-MIS</strong> <small>后台管理</small>
        </div>
           <span id="box" style="width: 320px;position: absolute;left: 550px;color: #000;font-size: 18px;font-weight: bold;line-height:50px"></span>
           <script>
               let box = document.getElementById('box')

               //不足十位补零
               let addZero = val => val < 10 ? '0' + val : val

               //把阿拉伯数字的星期转化为中国汉字的星期 // 星期映射表
               let trans = val => {
                   let obj = {
                       0: '日',
                       1: '一',
                       2: '二',
                       3: '三',
                       4: '四',
                       5: '五',
                       6: '六'
                   }
                   return obj[val]
               }
               setTime ()
               //获取时间的方法
               function setTime() {
                   let time = new Date();
                   let year = time.getFullYear(); // 获取年
                   let month = time.getMonth() + 1; // 获取月（是从0到11，所以我们要给他加1）
                   let date = time.getDate(); // 获取日
                   let day = time.getDay(); // 获取星期几(0是星期日)
                   let hour = time.getHours(); // 获取小时
                   let min = time.getMinutes(); // 获取分钟
                   let sec = time.getSeconds(); // 获取秒

                   let value = year + '年' + addZero(month) + '月' + addZero(date) + '日 星期' + trans(day) + ' '+addZero(hour) +
                       '时' + addZero(min) + '分' + addZero(sec) + '秒'
                   // 把所有的时间拼接到一起
                   box.innerText = value
                   // console.log(value)
                   // 把拼接好的时间插入到页面

               }
               // 让定时器每间隔一秒就执行一次setTime这个方法（这是实现时钟的核心）
               setInterval(setTime, 1000)
           </script>
        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>
        <div class="am-collapse am-topbar-collapse" id="topbar-collapse" >
            <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
                <li class="am-hide-sm-only">
                  <a href="javascript:;">
                        <img src="../images/default-head.jpg" alt="" class="am-circle am-fr" width="15%" >
                  </a>
                </li>
                <li class="am-dropdown" data-am-dropdown>
                    <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                        <span class="am-icon-users"></span> 管理员:<strong style="color: #000;font-weight: 700;">${sessionScope.loginName}</strong><span class="am-icon-caret-down"></span>
                    </a>
                    <ul class="am-dropdown-content">
                        <li><a href="userInfo.jsp"><span class="am-icon-user"></span> 个人资料</a></li>
                        <li><a href="" class="exit"><span class="am-icon-power-off"></span> 退出</a></li>
                        <script>
                            $('.exit').click(function () {
                                $.get('/java_thesis_project/exitServlet',{},function () {
                                    location.href='../login.jsp'
                                })
                            })

                        </script>
                    </ul>
                </li>
                <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"></a></li>
            </ul>
        </div>
    </header>
    <div class="am-cf admin-main">
        <!-- 左侧导航开始 start -->
        <div class="admin-sidebar am-offcanvas overflow-hidden" id="admin-offcanvas">
            <div class="am-offcanvas-bar admin-offcanvas-bar">
                <ul class="am-list admin-sidebar-list">
                    <li>
                        <a href="index.html">
                            <span class="am-icon-home"></span>
                            首页
                        </a>
                    </li>
                    <li class="admin-parent">
                        <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}">
                          <span class="am-icon-file"></span> 
                          企业管理 
                          <span class="am-icon-angle-right am-fr am-margin-right"></span>
                        </a>
                        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
                            <li>
                              <a href="deptManage.jsp" class="am-cf">
                                <span class="am-icon-check"></span> 
                                部门管理
                                <span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span>
                              </a>
                            </li>
                            <li>
                              <a href="empManage.jsp">
                                <span class="am-icon-puzzle-piece"></span> 
                                员工管理
                              </a>
                            </li>
                            <li>
                                <a href="empAdd.jsp">
                                    <span class="am-icon-puzzle-piece"></span>
                                    加入新员工
                                </a>
                            </li>
                            <li>
                                <a href="empSalary.jsp">
                                    <span class="am-icon-puzzle-piece"></span>
                                    员工工资管理
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="admin-parent">
                        <a class="am-cf" data-am-collapse="{target: '#userInfo'}">
                          <span class="am-icon-cog"></span> 
                          设置
                          <span class="am-icon-angle-right am-fr am-margin-right"></span>
                        </a>
                        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="userInfo">
                            <li>
                              <a href="userInfo.jsp" class="am-cf">
                                <span class="am-icon-check"></span> 
                                个人信息
                              </a>
                            </li>
                        </ul>
                    </li>

                </ul>
                <div class="am-panel am-panel-default admin-sidebar-panel">
                    <div class="am-panel-bd">
                        <p><span class="am-icon-bookmark"></span> 公告</p>
                        <p>2017年5月30日 10:13:44 </p>
                        <hr>
                        <p>暂无系统公告</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- 左侧导航结束 -->


        <div class="admin-content">
            <div class="admin-content-body">
                <div class="am-cf am-padding am-padding-bottom-0">
                    <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人信息</strong> / <small>Personal Information</small></div>
                </div>
                <hr/>

                <div class="am-g">
                    

                    <div class="am-u-sm-12 am-u-md-6 am-u-md-push-6">
                        <div class="am-panel am-panel-default">
                            <div class="am-panel-bd">
                                <div class="am-g">
                                    <div class="am-u-md-12">
                                        <img class="am-img-circle am-img-thumbnail" src="../images/default-head.jpg" alt="" />
                                        <form class="am-form">
                                            <div class="am-form-group">
                                                <input type="file" id="user-pic" class="display-none">
                                                <!-- <p class="am-form-help">请选择要上传的文件..</p> -->
                                                <a id="showUpDlgBtn" class="am-btn am-btn-primary am-btn-block" style="background: #0e90d2;">头像修改</a>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>



                    <div class="am-u-sm-12 am-u-md-6 am-u-md-pull-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <div class="am-u-sm-11">
                                    <input type="text" id="user-name" placeholder="姓名 / Name">
                                    <small>输入你的名字，让我们记住你。</small>
                                </div>
                            </div>
                            <div class="am-form-group">
                                <div class="am-u-sm-11">
                                    <input type="email" id="user-email" placeholder="输入你的电子邮件 / Email">
                                    <small>邮箱你懂得..</small>
                                </div>
                            </div>
                            <div class="am-form-group">
                                <div class="am-u-sm-11">
                                    <input type="tel" id="user-phone" placeholder="输入你的电话号码 / Telephone">
                                </div>
                            </div>
                            <div class="am-form-group">
                                <div class="am-u-sm-11">
                                    <input type="number" pattern="[0-9]*" id="user-QQ" placeholder="输入你的QQ号码">
                                </div>
                            </div>
                            <div class="am-form-group">
                                <div class="am-u-sm-11">
                                    <input type="text" id="user-weibo" placeholder="输入你的微博 / Twitter">
                                </div>
                            </div>
                            <div class="am-form-group">
                                <div class="am-u-sm-11">
                                    <textarea class="" rows="5" id="user-intro" placeholder="输入个人简介" style="resize: none"></textarea>
                                    <small>250字以内写出你的一生..</small>
                                </div>
                            </div>
                            <div class="am-form-group">
                                <div class="am-u-sm-11 am-u-sm-push-3">
                                    <button type="button" class="am-btn am-btn-primary" style="background: #0e90d2;">保存修改</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
        <!-- content end -->
    </div>
    <a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>






    <!--图片上传框-->
    <div class="am-modal am-modal-no-btn up-frame-bj " tabindex="-1" id="updateHeadDlg">
      <div class="am-modal-dialog up-frame-parent up-frame-radius">
        <div class="am-modal-hd up-frame-header">
           <label>修改头像</label>
          <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-bd  up-frame-body">
          <div class="am-g am-fl">
            <div class="am-form-group am-form-file">
              <div class="am-fl">
                <button type="button" class="am-btn am-btn-default am-btn-sm">
                  <i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
              </div>
              <input type="file" id="inputImage">
            </div>
          </div>
          <div class="am-g am-fl" >
            <div class="up-pre-before up-frame-radius">
                <img alt="" src="" id="image" >
            </div>
            <div class="up-pre-after up-frame-radius">
            </div>
          </div>
          <div class="am-g am-fl">
            <div class="up-control-btns">
                <span class="am-icon-rotate-left"  onclick="rotateimgleft()"></span>
                <span class="am-icon-rotate-right" onclick="rotateimgright()"></span>
                <span class="am-icon-check" id="up-btn-ok" url="admin/user/upload.action"></span>
            </div>
          </div>
          
        </div>
      </div>
    </div>





</body>

</html>
