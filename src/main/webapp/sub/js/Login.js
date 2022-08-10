$(document).ready(function (){
    var publicContent={url:'../../login'
    };

    $(".login").click(function (){
        var phone=$(".a06").val();
        var password=$(".a04").val();
        password=md5(password);
        // var vcode=$("#vcode").val();
        // var param="phone="+phone+"&password="+password+"&vcode="+vcode;
        var param="phone="+phone+"&password="+password;
        $.ajax({
            url:publicContent.url,
            type:"post",
            data:param,
            success:function(msg){
                var obj=JSON.parse(msg);
                if(obj.flag=="success"){
                    location.href="index.html";
                }else{
                    alert(obj.data);
                }
            }
        })
    })

})