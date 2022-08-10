var searchObj={}
var publicContent={url:'../../findUser',
    deurl:'../../deleteUser'
};
$(document).ready(function (){
    findUserList("",1,"");

    $("#search").click(function (){
        var name=$("#findUserByName").val();
        var department=$("#findUserByDeptN").val();
        findUserList(name,1,department);
    })
    $(".fa-step-backward").click(function(){
        if(searchObj.startPage==1){
            alert("当前已经是第一页")
        }else{
            findUserList(searchObj.name,1,searchObj.department);
        }
    })
    $(".fa-chevron-left").click(function(){
        if(searchObj.startPage==1){
            alert("当前已经是第一页")
        }else{
            findUserList(searchObj.name,searchObj.startPage-1,searchObj.department);
        }
    })
    $(".fa-chevron-right").click(function(){
        if(searchObj.startPage==searchObj.pages){
            alert("当前已经是最后一页")
        }else{
            findUserList(searchObj.name,searchObj.startPage+1,searchObj.department);
        }
    })
    $(".fa-step-forward").click(function(){
        if(searchObj.startPage==searchObj.pages){
            alert("当前已经是最后一页")
        }else{
            findUserList(searchObj.name,searchObj.pages,searchObj.department);
        }
    })
    $(".NUM .pages").change(function(){
        findUserList(searchObj.name,parseInt($(this).val()),searchObj.department);
    })



})
function findUserList(name,startPage,department){
    searchObj.department=department;
    searchObj.name=name;
    searchObj.startPage=startPage;
    var param="department="+department+"&regname="+name+"&startPage="+startPage+"&pageSize=10";

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
                    }else{
                        upload+="<img src='http://localhost:8080/WS_Administration/upload/"+user[i].upload+"' alt=''style='height:20px;width: 75px' class='imgShow'/>"
                    }
                    html+="<tr>"+
                        "<td className='a13 xd'><input id='"+user[i].id+""+user[i].phone+"' type='checkbox' name='checkbox' value='checkbox'onclick='deleteUser(\""+user[i].id+"\","+user[i].phone+")'/></td>"+
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
                        "<td className='a13'><div style='width: 50px;height: 60px;float: left;line-height: 60px;color: #4F9000' onclick='userDetail(\""+user[i].id+"\")'>查看</div>"+
                        "<div style='width: 50px;height: 60px;float:left;line-height: 60px;color: #4F9000' onclick='updateUser("+user[i].id+")'>修改</div></td>"+
                        "</tr>"
                }
                $(".userInfo").html(html);
                var total=obj.page.total;
                $(".totals").text(total);
                searchObj.pages=parseInt(total/10);
                if(total%10!=0){
                    searchObj.pages++;
                }
                $(".totalpage .pages").text(searchObj.pages);
                var optionhtml="";
                for(var i=1;i<=searchObj.pages;i++){
                    if(searchObj.startPage==i){
                        optionhtml+="<option  value='"+i+"' selected>"+i+"</option>"
                    }else{
                        optionhtml+="<option  value='"+i+"'>"+i+"</option>"
                    }
                }
                $(".NUM .pages").html(optionhtml);
            }else{
                alert(obj.data);
            }
        }
    })
}
function deleteUser(id,phone){

     var className=(id+phone).toString();
     console.log("classname:"+className)
    if(document.getElementById(className).checked) {
        $(".deleUser").click(function (){
            var param="phone="+phone+"&id="+id;
            $.ajax({
                url:publicContent.deurl,
                type:"post",
                data:param,
                success:function(msg){
                    var obj=JSON.parse(msg);
                    if(obj.flag=="success"){
                        findUserList("",1,"");
                    }else{
                        alert(obj.data);
                    }
                }
            })
        })
    }
}
function userDetail(id,phone){
    location.href = "renyuanxinxiguanlichakan.html";
}
function updateUser(id){
    localStorage.setItem("id",id)
    location.href = "renyuanxinxiguanlixinzeng.html";
}