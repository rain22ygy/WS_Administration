package com.wushang.Servlet.user;

import com.alibaba.fastjson.JSON;
import com.wushang.Service.user.userService;
import com.wushang.bean.Page;
import com.wushang.bean.Result;
import com.wushang.bean.userInformation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "findUserServlet", value = "/findUser")
public class findUserServlet extends HttpServlet {
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

        String regname =request.getParameter("regname");
        String department =request.getParameter("department");
        int startPage =Integer.parseInt(request.getParameter("startPage"));
        System.out.println("regname:"+regname);
        System.out.println("startPage:"+startPage);
        System.out.println("department:"+department);
        userInformation user=new userInformation();
        user.setRegname(regname);
        user.setDepartment(department);
        Page page=new Page();
        page.setStartPage(startPage);

        PrintWriter pw=response.getWriter();
        Result result= userService.findUser(user,page);
        if(callback!=null){
            pw.print(callback+"("+JSON.toJSONString(result)+")");
        }else{
            pw.append(JSON.toJSONString(result));
        }
        pw.flush();
        pw.close();
    }
}
