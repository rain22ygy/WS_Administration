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

@WebServlet(name = "updatePasswordByPhoneServlet", value = "/updatePasswordByPhone")
public class updatePasswordByPhoneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String phone =request.getParameter("phone");
        String password=request.getParameter("password");
        password= Md5Password.getHash("yuan"+password+"guangyu","MD5");
        userInformation bean=new userInformation();
        bean.setPhone(phone);
        bean.setPassword(password);
        Result result= userService.updatePasswordByPhone(bean);
        PrintWriter pw=response.getWriter();
        pw.append(JSON.toJSONString(result));
        pw.flush();
        pw.close();

    }
}
