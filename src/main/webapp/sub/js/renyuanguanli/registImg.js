$(function (){
    var publicContent={url:'../../registimg'};
   // $(".submit").click(function () {
       $(".regist_from").submit(function (e) {
       var flag = true;
       var ref = $(this).find("[required=required],[required=true]");
       $(ref).each(function () {
           if ($(this).val() == '') {
               alert("请认真填写登记消息。");
               $(this).focus();
               e.preventDefault();
               flag = false;
               return false;
           } else {
               return true;
           }
           //	此代码用于判断是否填写字段，
       });
if(flag){
       var farm = new FormData(document.getElementById("bike"));
       // 获取bike的表单字段
       $.ajax({
           url: publicContent.url,
           type: "POST",
           data: farm,
           dataType: "JSON",
           // async: false,
           //是否异步进行
           // cache: true,
           //是否读取缓存
           contentType: false,// jQuery不要去设置Content-Type请求头
           processData: false,//jQuery不要去处理发送的数据
           success: function (obj) {
               var flag = obj.flag;
               if (flag == "success") {
                   location.href = "renyuanxinxiguanli.html";
               } else {
                   alert(obj.data);
               }

           }
       });
   }
   })

})
