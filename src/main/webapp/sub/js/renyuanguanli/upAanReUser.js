var publicContent={urlUpdate:'../../updateUser',
    urlFindUserById:"../../findUserById",
    urlregist:'../../regist'
};
$(function (){
    var id=localStorage.getItem("id");
    console.log("id=",id)
    var param="id="+id;
    if(id==""||id==null){
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
            upload=encodeURIComponent(upload);
            var psw=$("#password").val();
            var password=md5(psw);
            var parma="phone="+phone+"&regname="+regname+"&sex="+sex+"&age="+age+ "&wsid="+wsid+"&deptId="+deptId+
                "&department="+department+"&address="+address+"&upload="+upload+"&password="+password;
            $.ajax({
                url:publicContent.urlregist,
                type:"post",
                data:parma,
                async: false,
                //是否异步进行
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

    }else{
        $.ajax({
            url:publicContent.urlFindUserById,
            type:"post",
            data:param,
            success:function(msg){
                var obj=JSON.parse(msg);
                if(obj.flag=="success"){
                    for (var i=0;i<obj.data.length;i++){
                        $("#id").val(id);
                        $("#regtime").val(obj.data[i].regtime);
                        $("#phone").val(obj.data[i].phone);
                        $("#regname").val(obj.data[i].regname);
                        $("#sex").val(obj.data[i].sex);
                        $("#age").val(obj.data[i].age);
                        $("#wsid").val(obj.data[i].wsid);
                        $("#deptId").val(obj.data[i].deptId);
                        $("#department").val(obj.data[i].department);
                        $("#address").val(obj.data[i].address);
                        $(".uploadShow").attr("src","http://localhost:8080/WS_Administration/upload/"+obj.data[i].upload+"");
                        $("#password").val(obj.data[i].password);
                    }
                }else{
                    alert(obj.data);
                }
            }
        })

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
            upload=encodeURIComponent(upload);
            var psw=$("#password").val();
            var password=md5(psw);
            var parma="phone="+phone+"&regname="+regname+"&sex="+sex+"&age="+age+ "&wsid="+wsid+"&deptId="+deptId+
                "&department="+department+"&address="+address+"&upload="+upload+"&password="+password+"&id="+id;
            $.ajax({
                url:publicContent.urlUpdate,
                type:"post",
                data:parma,
                success:function(msg){
                    var obj=JSON.parse(msg);
                    if(obj.flag=="success"){
                        localStorage.setItem("id","");
                        location.href = "renyuanxinxiguanli.html";
                    }else{
                        alert(obj.data);
                    }
                }
            })
        })
    }

    $("#upload").change(function(){
        var file=this.files[0];
        var fileReader=new FileReader();
        fileReader.onload=function(event){
            var imgUrl=event.target.result;
            $(".uploadShow").attr("src",imgUrl);
        }
        fileReader.readAsDataURL(file);
    })

$(".cancal").click(function (){
    localStorage.setItem("id","");
    location.href = "renyuanxinxiguanli.html";
})
})
