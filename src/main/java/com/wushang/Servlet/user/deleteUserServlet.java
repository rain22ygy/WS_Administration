package com.wushang.Servlet.user;

import com.alibaba.fastjson.JSON;
import com.wushang.Service.user.userService;
import com.wushang.bean.Result;
import com.wushang.bean.userInformation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "deleteServlet", value = "/deleteUser")
public class deleteUserServlet extends HttpServlet {
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

        String phone =request.getParameter("phone");
        int id =Integer.parseInt(request.getParameter("id"));
        System.out.println("phone:"+phone);
        System.out.println("id:"+id);
        userInformation bean=new userInformation();
        bean.setPhone(phone);
        bean.setId(id);
        PrintWriter pw=response.getWriter();
        Result result= userService.deleteUser(bean);
        if(callback!=null){
            pw.print(callback+"("+JSON.toJSONString(result)+")");
        }else{
            pw.append(JSON.toJSONString(result));
        }
        pw.flush();
        pw.close();
    }
}
