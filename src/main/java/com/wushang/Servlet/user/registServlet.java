package com.wushang.Servlet.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wushang.Service.user.userService;
import com.wushang.bean.Result;
import com.wushang.bean.userInformation;
import com.wushang.until.ImgBase64;
import com.wushang.until.Md5Password;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import sun.misc.BASE64Decoder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "registServlet", value = "/regist")
public class registServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String callback = request.getParameter("callback");
        System.out.println("callback:"+callback);

        String tempPath = request.getSession().getServletContext().getRealPath("/upload/");
        File file = new File(tempPath);
        if(!file.exists()){
            file.mkdir();
        }

        PrintWriter pw=response.getWriter();
        String regname =request.getParameter("regname");
        String phone =request.getParameter("phone");
//        String deptId =request.getParameter("deptId");
        String sex =request.getParameter("sex");
//        String age =request.getParameter("age");
        String department=request.getParameter("department");
//        String wsid =request.getParameter("wsid");


        int wsid=0;
            try {
                wsid=Integer.parseInt(request.getParameter("wsid"));
            }catch (Exception e){
                wsid=0;
            }
        int age=0;
        try {
            age=Integer.parseInt(request.getParameter("age"));
        }catch (Exception e){
            age=0;
        }

        int deptId=0;
        try {
            deptId= Integer.parseInt(request.getParameter("deptId"));
        }catch (Exception e){
            deptId=0;
        }
        String password=request.getParameter("password");
        password= Md5Password.getHash("yuan"+password+"guangyu","MD5");
        String address=request.getParameter("address");
        String upload=request.getParameter("upload");
        byte[] imgB2= ImgBase64.ImgBase64(upload);
        System.out.println(imgB2);
        String imgFilePath2 = phone+".jpg";//新生成的图片

            userInformation bean=new userInformation();
            bean.setPhone(phone);
            bean.setSex(sex);
            bean.setAddress(address);
            bean.setDepartment(department);
            bean.setAge(age);
            bean.setRegname(regname);
            bean.setWsid(wsid);
            bean.setPassword(password);
            bean.setDeptId(deptId);
            bean.setUpload(imgFilePath2);

        Result result=userService.registUser(bean,imgB2,tempPath);
        if(callback!=null){
            pw.print(callback+"("+JSON.toJSONString(result)+")");
        }else{
            pw.append(JSON.toJSONString(result));
        }
        pw.flush();
        pw.close();
    }
}
