package com.wushang.Service.user;

import com.alibaba.fastjson.JSON;
import com.wushang.Dao.user.userDao;
import com.wushang.bean.Page;
import com.wushang.bean.Result;
import com.wushang.bean.userInformation;


import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

public class userService {
    public static Result  login(userInformation user){
        Result result=new Result("fail",null,null);
        List<HashMap<String, Object>> list=userDao.findUserByPhAndPaw(user);
        System.out.println("findUserByPhoneAndPaw"+list);
        if(list!=null&&list.size()>0){
            for(HashMap<String,Object> map:list){
                String mpaw=map.get("password").toString();
                String upaw=user.getPassword();
                String mph=map.get("phone").toString();
                String upho=user.getPhone();
                if(mpaw==upaw&&mph==upho){
                    result.setFlag("success");
                }else{
                    result.setData("小样");
                }
            }
                 result.setFlag("success");
        }else{
            list=userDao.findUserByPhone(user);
            System.out.println("findUserByPhone"+list);
           if(list!=null&&list.size()>0){
                result.setData("密码错误");
           }else{
               result.setData("用户不存在");
           }
        }
        return result;
    }
    public static Result findUser(userInformation user, Page page){
        Result result=new Result("fail",null,null);
        List<HashMap<String, Object>> list= userDao.findUser(user,page);
            System.out.println("list"+list);
            int startPage=page.getStartPage();
            Integer total=userDao.findUserTotal(user);
            page.setTotal(total);
            page.setPageSize(10);
            page.setStartPage(startPage);
            result.setPage(page);
            result.setFlag("success");
            result.setData(list);
//        System.out.println(page+"list:"+list);
            System.out.println(JSON.toJSONString(page));
        return result;
    }
    public static Result registUser(userInformation user,byte[] b2,String tempPath){
        Result result=new Result("fail",null,null);
        List<HashMap<String, Object>> list=userDao.findUserByPhone(user);
        System.out.println("判断用户是否已经存在："+list);
        if(list!=null&&list.size()>0){
              result.setData("该用户已存在");
        }else{
            int reResult=userDao.registUser(user);
            if(reResult>0){
                result.setFlag("success");
                OutputStream out2 = null;
                try {
                    out2 = new FileOutputStream(tempPath+"//"+user.getUpload());
                    out2.write(b2);
                    out2.flush();
                    out2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("注册结果"+reResult);
            }
        }
        return result;
    }
    public static Result deleteUser(userInformation bean){
        Result result= new Result("fail",null,null);
        List<HashMap<String, Object>> list=userDao.findUserById(bean);
        if(list!=null&&list.size()>0){
            if(userDao.deleteUser(bean)>0){
                result.setFlag("success");
                System.out.println("删除成功");
            }else {
                result.setData("删除失败，请稍后重试");
            }
        }else{
            result.setData("该用户不存在");
        }
        return result;
    }
    public static Result updateUserById(userInformation bean,byte[] b2,String tempPath){
        Result result= new Result("fail",null,null);
        List<HashMap<String, Object>> list=userDao.findUserByPhone(bean);
        for (HashMap<String,Object> map:list){
             if(Integer.parseInt(map.get("id").toString())==bean.getId()){
                 if(userDao.updateUserById(bean)>0){
                     result.setFlag("success");
                     OutputStream out2 = null;
                     try {
                         out2 = new FileOutputStream(tempPath+"//"+bean.getUpload());
                         out2.write(b2);
                         out2.flush();
                         out2.close();
                     } catch (Exception e) {
                         e.printStackTrace();
                     }

                     System.out.println("修改成功");
                 }else {
                     result.setData("修改失败，请稍后重试");
                 }
             }else{
                 result.setData("该用户已存在");
             }
        }

        return result;
    }
    public static Result findUserById(userInformation bean){
        Result result= new Result("fail",null,null);
        List<HashMap<String, Object>> list=userDao.findUserById(bean);
        if(list!=null&&list.size()>0){
            result.setFlag("success");
            result.setData(list);
        }else{
            result.setData("该用户不存在");
        }
        return result;
    }
    public static Result updatePasswordByPhone(userInformation bean){
        Result result= new Result("fail",null,null);
        List<HashMap<String, Object>> list=userDao.findUserByPhone(bean);
        if(list!=null&&list.size()>0){
            int updateResult=userDao.updatePasswordByPhone(bean);
            if(updateResult>0){
                result.setFlag("success");
                result.setData("修改成功");
            }
        }else {
            result.setData("该用户不存在");
        }
        return result;
    }

}
