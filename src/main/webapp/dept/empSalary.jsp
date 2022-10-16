<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin table Examples</title>
    <meta name="description" content="这是一个 table 页面">
    <meta name="keywords" content="table">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="icon" type="image/png" href="../images/logo.webp">
    <link rel="apple-touch-icon-precomposed" href="../amazeui/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="../amazeui/css/amazeui.min.css" />
    <link rel="stylesheet" href="../amazeui/css/admin.css">

    <script src="../static/js/jquery-3.5.1.js"></script>
    <script src="../amazeui/js/amazeui.js"></script>
    <script src="../amazeui/js/app.js"></script>
    <script type="text/javascript">
        function crmDelete(id)
        {
            $('#my-confirm').modal({
                relatedTarget: this,
                onConfirm: function(options) {

                },
                onCancel: function() {
                    alert('算求，不弄了');
                }
            });
        }

    </script>
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
                    <span class="am-icon-users"></span> 管理员:<strong style="color: #000;font-weight: 700;">${sessionScope.loginName}</strong> <span class="am-icon-caret-down"></span>
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


    <!-- content start -->
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-cf am-padding am-padding-bottom-0">
                <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">员工工资管理</strong> / <small>Employee Manage</small></div>
            </div>

            <hr>

            <div class="am-g">
                <div class="am-u-sm-12 am-u-md-6">
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">

                        </div>
                    </div>
                </div>
                <div class="am-u-sm-12 am-u-md-5">
                    <div class="am-input-group am-input-group-sm">
                        <input type="text" class="am-form-field">
                        <span class="am-input-group-btn">
              <button class="am-btn am-btn-default" type="button">搜索</button>
            </span>
                    </div>
                </div>
            </div>

            <div class="am-g">
                <div class="am-u-sm-12">
                    <!-- form  action的默认值是浏览器地址栏 -->
                    <!--           <form action="#abc" class="am-form"> -->
                    <table class="am-table am-table-striped am-table-hover table-main">
                        <thead>
                        <tr>
                            <th class="table-check">
                                <input type="checkbox" />
                            </th>
                            <th class="table-id">ID</th>
                            <th class="table-id">姓名</th>
                            <th class="table-id">年龄</th>
                            <th class="table-id">爱好</th>
                            <th class="table-id">简介</th>
                            <th class="table-id">性别</th>
                            <th class="table-title">入职日期</th>
                            <th class="table-author am-hide-sm-only">所在部门</th>
                            <th class="table-set">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th class="table-check">
                                <input type="checkbox" />
                            </th>
                            <td class="table-id">ID</td>
                            <td class="table-id">姓名</td>
                            <td class="table-id">年龄</td>
                            <td class="table-id">爱好</td>
                            <td class="table-id">简介</td>
                            <td class="table-id">性别</td>
                            <td class="table-title">入职日期</td>
                            <td class="table-author am-hide-sm-only">所在部门</td>
                            <td>
                                <div class="am-btn-toolbar">
                                    <div class="am-btn-group am-btn-group-xs">
                                        <a href="empModify.jsp" class="am-btn am-btn-default am-btn-xs am-text-secondary">
                                            <span class="am-icon-pencil-square-o"></span> 编辑
                                        </a>
                                        <!-- button默认类型是submit -->
                                        <button type="button" onclick="crmDelete(11)" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
                                            <span class="am-icon-trash-o"></span> 删除
                                        </button>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="am-cf">
                        <div class="am-fr">
                            <ul class="am-pagination">
                                <li class="am-disabled"><a href="#">«</a></li>
                                <li class="am-active"><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li><a href="#">»</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <footer>
            <hr>
            <p class="am-padding-left">&copy; 2017 Designed by yxq</p>
        </footer>

    </div>
    <!-- content end -->
</div>

<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

<footer>
    <hr>
    <p class="am-padding-left">&copy; 2017 Designed by yxq</p>
</footer>


<!--     删除模态框 -->
<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">用户删除</div>
        <div class="am-modal-bd">
            你，确定要删除这条记录吗？
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>确定</span>
        </div>
    </div>
</div>
<!--     删除模态框 -->




</body>
</html>
