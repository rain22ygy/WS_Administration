var publicContent={url:'../../regist'};
$(function (){

    $(".submit").click(function () {
        var phone=$("#phone").val();
        var regname=$("#regname").val();
        var sex=$("#sex").val();
        var age=$("#age").val();
        var wsid=$("#wsid").val();
        var deptId=$("#deptId").val();
        var department=$("#department").val();
        var address=$("#address").val();
        var upload=$(".uploadShow").attr("src");
        // upload=encodeURIComponent(upload);
        var psw=$("#password").val();
        var password=md5(psw);
        var parma="phone="+phone+"&regname="+regname+"&sex="+sex+"&age="+age+ "&wsid="+wsid+"&deptId="+deptId+
            "&department="+department+"&address="+address+"&upload="+upload+"&password="+password;
        $.ajax({
            url:publicContent.url,
            type:"post",
            data:parma,
            success:function(msg){
               var obj=JSON.parse(msg);
                if(obj.flag=="success"){
                    location.href = "renyuanxinxiguanli.html";
                }else{
                    alert(obj.data);
                }
            }
        })
    })

    $("#upload").change(function(){
        var file=this.files[0];
        var fileReader=new FileReader();
        fileReader.onload=function(event){
            var imgUrl=event.target.result;
            $(".uploadShow").attr("src",imgUrl);
        }
        fileReader.readAsDataURL(file);
    })

})
