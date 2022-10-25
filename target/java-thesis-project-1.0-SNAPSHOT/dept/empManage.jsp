<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>部门管理</title>
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
    <style>
        #ul>li:hover{
            background-color: #5b6ddc;
        }


    </style>
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
                        <img src="../images/default-head.jpg" alt="" style="float: right" class="am-circle am-fr" width="15%" >
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
                                <a href="empSalary.jsp" id="emp">
                                    <span class="am-icon-puzzle-piece"></span>
                                    员工工资管理
                                </a>
                            </li>
                            <li>
                                <a href="empAdd.jsp">
                                    <span class="am-icon-puzzle-piece"></span>
                                    加入新员工
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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">员工管理</strong> / <small>Employee Manage</small></div>
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

        </div>
      </div>

      <div class="am-g">
        <div class="am-u-sm-12">
        	<!-- form  action的默认值是浏览器地址栏 -->
<!--           <form action="#abc" class="am-form"> -->
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
                <tr>

                  <th class="table-id">ID</th>
                  <th class="table-id">姓名</th>
                  <th class="table-id">年龄</th>
                  <th class="table-id">爱好</th>
                  <th class="table-id">简介 </th>
                  <th class="table-id">性别</th>
                  <th class="table-title">入职日期</th>
                  <th class="table-author am-hide-sm-only">所在部门</th>
                  <th class="table-set">操作</th>
                </tr>
              </thead>
              <tbody>
              		<tr>

	                  <td class="table-id">${sessionScope.empList[0].id}</td>
	                  <td class="table-id">${sessionScope.empList[0].employeeName}</td>
	                  <td class="table-id">${sessionScope.empList[0].employeeAge}</td>
	                  <td class="table-id like">${sessionScope.empList[0].employeeHobby}</td>
	                  <td class="table-id Brief">${sessionScope.empList[0].employeeBrief}</td>
	                  <td class="table-id">${sessionScope.empList[0].employeeSex}</td>
	                  <td class="table-title">${sessionScope.empList[0].employeeDate}</td>
	                  <td class="table-author am-hide-sm-only">${sessionScope.empList[0].employeeDept}</td>
                    <td>
                      <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                          <a href="empModify.jsp" class="am-btn am-btn-default am-btn-xs am-text-secondary">
                              <span class="am-icon-pencil-square-o"></span> 编辑
                          </a>
                          <!-- button默认类型是submit -->
                          <button type="button" onclick="crmDelete()" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
                              <span class="am-icon-trash-o"></span> 删除
                          </button>
                        </div>
                      </div>
                    </td>
                  </tr>
                    <tr>

                        <td class="table-id ">${sessionScope.empList[1].id}</td>
                        <td class="table-id ">${sessionScope.empList[1].employeeName}</td>
                        <td class="table-id ">${sessionScope.empList[1].employeeAge}</td>
                        <td class="table-id like">${sessionScope.empList[1].employeeHobby}</td>
                        <td class="table-id Brief">${sessionScope.empList[1].employeeBrief}</td>
                        <td class="table-id ">${sessionScope.empList[1].employeeSex}</td>
                        <td class="table-title">${sessionScope.empList[1].employeeDate}</td>
                        <td class="table-author am-hide-sm-only">${sessionScope.empList[1].employeeDept}</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <a href="empModify.jsp" class="am-btn am-btn-default am-btn-xs am-text-secondary">
                                        <span class="am-icon-pencil-square-o"></span> 编辑
                                    </a>
                                    <!-- button默认类型是submit -->
                                    <button type="button" onclick="crmDelete()" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
                                        <span class="am-icon-trash-o"></span> 删除
                                    </button>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>

                        <td class="table-id">${sessionScope.empList[2].id}</td>
                        <td class="table-id">${sessionScope.empList[2].employeeName}</td>
                        <td class="table-id">${sessionScope.empList[2].employeeAge}</td>
                        <td class="table-id like">${sessionScope.empList[2].employeeHobby}</td>
                        <td class="table-id Brief">${sessionScope.empList[2].employeeBrief}</td>
                        <td class="table-id">${sessionScope.empList[2].employeeSex}</td>
                        <td class="table-title">${sessionScope.empList[2].employeeDate}</td>
                        <td class="table-author am-hide-sm-only">${sessionScope.empList[2].employeeDept}</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <a href="empModify.jsp" class="am-btn am-btn-default am-btn-xs am-text-secondary">
                                        <span class="am-icon-pencil-square-o"></span> 编辑
                                    </a>
                                    <!-- button默认类型是submit -->
                                    <button type="button" onclick="crmDelete()" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
                                        <span class="am-icon-trash-o"></span> 删除
                                    </button>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>

                        <td class="table-id">${sessionScope.empList[3].id}</td>
                        <td class="table-id">${sessionScope.empList[3].employeeName}</td>
                        <td class="table-id">${sessionScope.empList[3].employeeAge}</td>
                        <td class="table-id like">${sessionScope.empList[3].employeeHobby}</td>
                        <td class="table-id Brief">${sessionScope.empList[3].employeeBrief}</td>
                        <td class="table-id">${sessionScope.empList[3].employeeSex}</td>
                        <td class="table-title">${sessionScope.empList[3].employeeDate}</td>
                        <td class="table-author am-hide-sm-only">${sessionScope.empList[3].employeeDept}</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <a href="empModify.jsp" class="am-btn am-btn-default am-btn-xs am-text-secondary">
                                        <span class="am-icon-pencil-square-o"></span> 编辑
                                    </a>
                                    <!-- button默认类型是submit -->
                                    <button type="button" onclick="crmDelete()" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
                                        <span class="am-icon-trash-o"></span> 删除
                                    </button>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>

                        <td class="table-id">${sessionScope.empList[4].id}</td>
                        <td class="table-id">${sessionScope.empList[4].employeeName}</td>
                        <td class="table-id">${sessionScope.empList[4].employeeAge}</td>
                        <td class="table-id like">${sessionScope.empList[4].employeeHobby}</td>
                        <td class="table-id Brief">${sessionScope.empList[4].employeeBrief}</td>
                        <td class="table-id">${sessionScope.empList[4].employeeSex}</td>
                        <td class="table-title">${sessionScope.empList[4].employeeDate}</td>
                        <td class="table-author am-hide-sm-only">${sessionScope.empList[4].employeeDept}</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <a href="empModify.jsp" class="am-btn am-btn-default am-btn-xs am-text-secondary">
                                        <span class="am-icon-pencil-square-o"></span> 编辑
                                    </a>
                                    <!-- button默认类型是submit -->
                                    <button type="button" onclick="crmDelete()" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
                                        <span class="am-icon-trash-o"></span> 删除
                                    </button>
                                </div>
                            </div>
                        </td>
                    </tr>
              </tbody>
                <script>
                    var brief = document.querySelectorAll('.Brief');


                    for (let i = 0; i < brief.length; i++) {

                        brief[i].style.cursor='pointer'

                        brief[i].innerHTML=brief[i].innerHTML==''?brief[i].innerHTML:brief[i].innerHTML.substring(0,5)+"..."

                    }

                </script>
            </table>
            <div class="am-cf">
              <div class="am-fr">




                <ul class="am-pagination" id="ul" >

                </ul>



                  <script>
                      var num = `${sessionScope.empPage.pages}`
                      var pageNum = `${sessionScope.empPage.pageNum}`
                      var count = `${sessionScope.empPage.size}`
                      var is = `${sessionScope.empPage.isLastPage}`
                      console.log(is)
                      var tbody = document.querySelector('tbody')
                      console.log(tbody.children)
                      //排他思想 如果等于true 说明已经是最后一页 拿到count count是这个页有多少数据
                      //把其他干掉 留下count行
                      if (is == 'true') {
                          for (let i = 0; i < tbody.children.length; i++) {
                              tbody.children[i].style.display = 'none';
                          }
                          for (let i = 0; i < count; i++) {
                              tbody.children[i].style.display = 'table-row';
                          }
                      }
                      console.log(pageNum)
                      console.log(num)
                      var ul = document.getElementById("ul")
                      var arr = []
                      //根据有多少页动态创建页数按钮
                      for (let i = 0; i < num; i++) {

                          arr[i] = document.createElement("li");
                          arr[i].setAttribute('style', 'margin: 0 10px;color:#000;cursor: pointer;width:40px;height:40px;line-height:40px;text-align:center;display: inline-block;border:1px solid skyblue')
                          arr[i].setAttribute('pageNum', i + 1)
                          arr[i].setAttribute('class', 'sp')
                          arr[i].innerHTML = (i + 1).toString()
                          ul.appendChild(arr[i])
                      }
                      var list = document.querySelectorAll('.sp');
                      console.log(arr)
                      console.log(list)

                      for (let i = 0; i < list.length; i++) {

                          if (list[i].getAttribute('pagenum') == pageNum) {
                              list[i].setAttribute('style', 'margin: 0 10px;color:#000;cursor: pointer;width:40px;height:40px;line-height:40px;text-align:center;background-color:skyblue;display: inline-block')
                          }
                      }
                      //根据当前点的第几页然后发ajax给服务端获取数据展示数据到页面
                      window.onload = function () {
                          for (let i = 0; i < list.length; i++) {
                              list[i].onclick = function () {

                                  $.get('/java_thesis_project/empLimitServlet', {
                                      pageNum: this.getAttribute('pagenum'),
                                      pageSize: 5
                                  }, function () {
                                      location.reload();
                                  })
                              }

                          }

                      }
                  </script>
              </div>
            </div>
            <p>当前页:<span
                    style="color: skyblue;font-size: 20px;font-weight: 700">${sessionScope.empPage.pageNum}</span>,共有<span
                    style="color: skyblue;font-size: 20px;font-weight: 700">${sessionScope.empPage.total}</span>条数据，共有<span
                    style="color: skyblue;font-size: 20px;font-weight: 700">${sessionScope.empPage.pages}</span>页
            </p>
        </div>
      </div>
    </div>



  </div>
  <!-- content end -->
</div>

<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>


    
    
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


    <script>
        $('#emp').click(function () {
            $.get('/java_thesis_project/empLimitServlet',{pageNum:1,pageSize:5},function () {

            })
        })
    </script>

</body>
</html>
