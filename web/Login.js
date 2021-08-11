$(function () {
    $("#user01").blur(function () {
        var username = this.value;
        $.getJSON("LoginServlet?action=exitsUsername&username=" + username, function (data) {
            if (data.existusername&&username.length>0) {
                $("p").html("用户名可用"+username.length)
                return true
            } else {
                $("p").html("用户名不可用")
                return false
            }
        })
    })

    $("form").submit(function () {
            var username = $("#user01").value
            var passwords = $("#psw").value
            var checkcode = $("#checkcode").value
            var tellphone=$("#telph").value
                  alert(username.length)
        if(username.length>0){
            return true
        }else {
            return false
        }
        }
    )
    //发送ajax请求验证电话是否可用
      $("#telph").blur(function () {
          var tellphone=this.value
        $.getJSON("LoginServlet?action=exitsTelphone&tellphone="+tellphone,function (datas) {
            if(datas.existtellphone&tellphone.length>0){
                $("#telp").html("电话可用")
                return true
            }else {
                $("#telp").html("电话不可用")
                return false
            }
        })

        })

    $("img").click(function () {//验证码的刷新
        this.src="http://localhost:8088/Learnpro/kaptcha.jpg?d="+new Date()

    })


})