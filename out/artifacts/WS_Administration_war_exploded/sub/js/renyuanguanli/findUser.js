var searchObj={}
$(document).ready(function (){
    findUser("",1,"")
    $("#search").click(function (){
        var value=$("#findUserByNameAndDept").val();
        alert(value)
        findUser(value,1,value)
    })

})
function findUser(name,startPage,department){
    searchObj.department=department;
    searchObj.name=name;
    searchObj.startPage=startPage;
    var param="department="+department+"&regname="+name+"&startPage="+startPage+"&pageSize=10";
    var publicContent={url:'../../findUser'
    };
    $.ajax({
        url:publicContent.url,
        type:"post",
        data:param,
        success:function(msg){
            var obj=JSON.parse(msg);
            var user=obj.data;
            if(obj.flag=="success"){
                var html="";
                for(var i=0;i<obj.data.length;i++){
                    // regname,phone,sex,age,wsid,upload,regtime,department,password,address
                    var upload=user[i].upload;
                    if(upload==""||upload==null){
                        upload="用户没有上传图片"
                    }
                    html+="<tr>"+
                        "<td className='a13 xd'><input type='checkbox' name='checkbox' value='checkbox'/></td>"+
                        "<td>"+user[i].id+"</td>"+
                        "<td>"+user[i].regname+"</td>"+
                        "<td>"+user[i].phone+"</td>"+
                        "<td>"+user[i].sex+"</td>"+
                        "<td>"+user[i].age+"</td>"+
                        "<td>"+user[i].wsid+"</td>"+
                        "<td>"+upload+"</td>"+
                        "<td>"+user[i].regtime+"</td>"+
                        "<td>"+user[i].deptId+"</td>"+
                        "<td>"+user[i].department+"</td>"+
                        "<td>"+user[i].address+"</td>"+
                        "<td className='a13'><a href='renyuanxinxiguanlichakan.html'>查看</a>" +"&nbsp;"+
                        "<a href='renyuanxinxiguanlixinzeng.html'>修改</a></td>"+
                        "</tr>"
                }
                $(".userInfo").html(html);
            }else{
                alert(obj.data);
            }
        }
    })
}