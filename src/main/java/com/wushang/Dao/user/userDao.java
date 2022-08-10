package com.wushang.Dao.user;

import com.wushang.bean.Page;
import com.wushang.bean.userInformation;

import java.util.HashMap;
import java.util.List;

import static com.wushang.until.DBConnectionMysql.executeQuery;
import static com.wushang.until.DBConnectionMysql.executeUpdate;

public class userDao {
   public static List<HashMap<String, Object>> findUserByNameAndPhone(userInformation user){
      String sql="select id,regname,phone,sex,age,wsid,upload,regtime,department,password,address,deptId from ws_User where status=1 and  phone='"+user.getPhone()+"' and regname='"+user.getRegname()+"'";
      return executeQuery(sql);
      //判断是否已经存在
   }
   public static List<HashMap<String, Object>> findUserByPhAndPaw(userInformation user){
      String sql="select id,regname,phone,sex,age,wsid,upload,regtime,department,password,address,deptId from ws_User where status=1 and  phone='"+user.getPhone()+"' and password='"+user.getPassword()+"'";
      return executeQuery(sql);
      //判断是否满足登录条件
   }
   public static List<HashMap<String, Object>> findUserByPhone(userInformation user){
      String sql="select id,regname,phone,sex,age,wsid,upload,regtime,department,password,address,deptId from ws_User where status=1 and phone='"+user.getPhone()+"'";
      return executeQuery(sql);
      //判断密码是否错误
   }
   public static List<HashMap<String, Object>> findUser(userInformation user, Page page){
      String sql="select id,regname,phone,sex,age,wsid,upload,regtime,department,address,deptId from ws_User WHERE status=1 and (regname like '%"+user.getRegname()+"%' and department like '%"+user.getDepartment()+"%') LIMIT "+(page.getStartPage()-1)*10+",10";
      System.out.println(sql);
      return executeQuery(sql);
      //查找没有被删除的User
   }
   public static int findUserTotal(userInformation user){
      int total=0;
      String sql="select count(*) as total from ws_User WHERE status=1 and (regname like '%"+user.getRegname()+"%' and department like '%"+user.getDepartment()+"%')";
      List<HashMap<String, Object>> list=executeQuery(sql);
      if(list!=null&&list.size()>0){
          for (HashMap<String,Object> map :list){
             total=Integer.parseInt(map.get("total").toString());
          }
      }
      return total;
   }
   public static int  registUser(userInformation bean){
      String sql="INSERT INTO ws_User (`regname`, `phone`, `deptId`,`sex`,`age`, `department`, `wsid`, `upload`, `regtime`, `password`, `address`,`status`) VALUES ('" + bean.getRegname() + "', '" + bean.getPhone() + "','" + bean.getDeptId() + "', '" + bean.getSex() + "', '" + bean.getAge() + "', '" + bean.getDepartment() + "', '" + bean.getWsid() + "', '" + bean.getUpload() + "', now(), '" + bean.getPassword() + "', '" + bean.getAddress() + "',1)";
      System.out.println(sql);
      return executeUpdate(sql);
   }
   public static List<HashMap<String, Object>> findUserById(userInformation user){
      String sql="select id,regname,phone,sex,age,wsid,upload,regtime,department,password,address,deptId from ws_User where status=1 and id='"+user.getId()+"'";
      return executeQuery(sql);
      //判断密码是否错误
   }
   public static int deleteUser(userInformation bean){
      String sql="update ws_User set status = 0  where phone='"+bean.getPhone()+"' and id='"+bean.getId()+"'";
      return  executeUpdate(sql);
//      将已经删除的人状态改为0
   }
   public static int updateUserById(userInformation bean){
      String sql=" update ws_User set  regname='"+bean.getRegname()+"' ,phone='"+bean.getPhone()+"', sex='"+bean.getSex()+"' ,age='"+bean.getAge()+"',wsid='"+bean.getWsid()+"' ,upload='"+bean.getUpload()+"' ,department='"+bean.getDepartment()+"' ,password='"+bean.getPassword()+"',address='"+bean.getAddress()+"' ,deptId='"+bean.getDeptId()+"'  where id='"+bean.getId()+"' and status=1";
      return  executeUpdate(sql);
   }

   public static int updatePasswordByPhone(userInformation bean){
      String sql=" update ws_User set password='"+bean.getPassword()+"'  where phone='"+bean.getPhone()+"' and status=1";
      return  executeUpdate(sql);
   }

}
