//弹出自定义提示窗口
var showAlert= function(msg, url){
    //弹框存在
    if ( $("#alert_box").length > 0) {
        $('#pop_box_msg').html(msg);
    } else {
        var alertHtml = '<div id="alert_box">'
            +       '<div class="cover"  id="cover_alert"  onclick="closeAlert()"></div>'
            +       '<div class="pop_box" id="pop_box_alert" onclick="closeAlert()">'
            +           '<div class="pop_img">'
            +               '<img src="/assets/images/img/pop_top.png">'
            +           '</div>'
            +           '<div class="pop_center">'
            +               '<span id="pop_box_msg">' + msg + '</span>'
            +           '</div>'
            +           '<div class="pop_img">'
            +               '<img src="/assets/images/img/pop_bottom.png">'
            +           '</div>'
            +       '</div>'
            +   '</div>';
        $("body").append(alertHtml);
    }
    $("#alert_box").show();
    if(url){
        setTimeout(function(){
            window.location.href = url + '?id=' + 10000*Math.random();
        } , 2000 );
    }else{
        setTimeout("$('#alert_box').hide();" , 2000);
    }
}

//重定义alert
window.alert=showAlert;

//点击遮罩关闭
function closeAlert(){
    $("#alert_box").hide();
}

//验证表单
function check()
{
    var username = $.trim($("#username").val());
    if (username.length < 1) {
        alert('用户名不能为空！');
        return false;
    }
    var sex = $('input[name="sex"]:checked').val();
    if (sex.length < 1) {
        alert('性别不能为空！');
        return false;
    }
    alert('提交成功！');
    return true;
}