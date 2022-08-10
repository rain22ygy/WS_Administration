package com.wushang.Servlet.user;

import com.alibaba.fastjson.JSON;
import com.wushang.Service.user.userService;
import com.wushang.bean.Result;
import com.wushang.bean.userInformation;
import com.wushang.until.Md5Password;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginByPPServlet", value = "/login")
public class loginByPPServlet extends HttpServlet {
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
        PrintWriter pw=response.getWriter();


        String phone =request.getParameter("phone");
        String password =request.getParameter("password");
//        password= Md5Password.getHash(password,"MD5");
        password= Md5Password.getHash("yuan"+password+"guangyu","MD5");


        System.out.println("paw:"+password);
        System.out.println("phone："+phone);

        userInformation user=new userInformation();
        user.setPhone(phone);
        user.setPassword(password);

        Result result= userService.login(user);

        HttpSession session= request.getSession();
        session.setAttribute("loginFilter",phone);

        if(callback!=null){
            pw.print(callback+"("+ JSON.toJSONString(result)+")");
        }else{
            pw.append(JSON.toJSONString(result));
        }
        pw.flush();
        pw.close();
    }
}
