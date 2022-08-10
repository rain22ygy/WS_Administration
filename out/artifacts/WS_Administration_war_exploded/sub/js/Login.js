$(document).ready(function (){
    var publicContent={url:'../../login'
    };

    $(".login").click(function (){
        var phone=$(".a06").val();
        // var regname=$(".a03").val();
        var password=$(".a04").val();
        // var param="phone="+phone+"&regname="+regname+"&password="+password;
        var param="phone="+phone+"&password="+password;
        // alert("param:"+param)
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