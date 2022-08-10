// $(function(){
//     var publicContent={url:'../../regist'
//     };
//     $(".submit").click(function(){
//         <!--regname,phone,sex,age,wsid,upload,regtime,department,password,address-->
//         var regname=$("#regname").val();
//         var sex="female";
//         if($(".genderMale").prop("checked")){
//             sex="Male";
//         }
//         var phone=$("#phone").val();
//         var age=$("#age").val();
//         var wsid=$("#wsid").val();
//         var regtime=$("#regtime").val();
//         var department=$("#department").val();
//         var password=$("#password").val();
//         var address=$("#address").val();
//         var upload=$("#upload").val();
//         var deptId=$("#deptId").val();
//         var param="regname="+regname+"&sex="+sex+"&age="+age+"&wsid="+wsid+
//         "&upload="+upload+"&phone="+phone+"&regtime="+regtime+"&department="
//             +department+"&password="+password+"$address="+address+"deptId="+deptId;
//         alert("param:"+param);
//         $.ajax({
//             url:publicContent.url,
//             type:"post",
//             data:param,
//             dataType:"JSON",
//             async: false,
//             //是否异步进行
//             cache: true,
//             //是否读取缓存
//             contentType:false,// jQuery不要去设置Content-Type请求头
//             processData:false,//jQuery不要去处理发送的数据
//             success:function(msg){
//                 var obj=msg;
//                 if(obj.flag=="success"){
//                     location.href="renyuanxinxiguanli.html";
//                 }else{
//                     alert(obj.data);
//                 }
//             }
//         })
//     })
// })
(function(){
    var publicContent={url:'../../regist'};
    $("#bike").submit(function(e){
        // if(flag){
            var farm=new FormData(document.getElementById("bike"));
            alert(JSON.stringify(farm)+"哈哈"+farm)
            // 获取bike的表单字段
            $.ajax({
                url:publicContent.url,
                type:"POST",
                // data:$('#bike').serialize(),
                // serialize() 方法通过序列化表单值，创建 URL 编码文本字符串
                data:farm,
                dataType:"JSON",
                async: false,
                //是否异步进行
                cache: true,
                //是否读取缓存
                contentType:false,// jQuery不要去设置Content-Type请求头
                processData:false,//jQuery不要去处理发送的数据
                success:function(data){
                    $('.loading_div').fadeOut();
                    //慢慢展现出来
                    var message=data.flag;
                    switch (message) {
                        case 'hasRegisted':
                            dialog('登记提示','您已经登记','我知道了','');
                            break;
                        case 'typeError':
                            dialog('报名失败','图片格式错误，只支持png,jpg','我知道了','');
                            break;
                        default:
                            dialog('提交成功','恭喜您登记成功','我知道了','');
                            break;
                    }
                },
                error:function(e){
                    $('.loading_div').fadeOut();
                    dialog('提交失败','请检查网络','我知道了','');
                }
            });
        // }


    });


})();


