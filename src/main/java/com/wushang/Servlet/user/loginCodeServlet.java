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

@WebServlet(name = "loginServlet", value = "/loginCode")
public class loginCodeServlet extends HttpServlet {
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
        Result result=new Result("fail",null,null);


        String phone =request.getParameter("phone");
        String password =request.getParameter("password");
        password= Md5Password.getHash("yuan"+password+"guangyu","MD5");
        String vcode=request.getParameter("vcode");

        HttpSession session= request.getSession();
        String rvcode=(String) session.getAttribute("rvcode");


        System.out.println("paw:"+password);
        System.out.println("phone"+phone);
        System.out.println("vcode:"+vcode+";;;"+"rvcode:"+rvcode);

        userInformation user=new userInformation();
        user.setPhone(phone);
        user.setPassword(password);

        session.setAttribute("loginFilter",phone);

        if(vcode.equalsIgnoreCase(rvcode)){
             result=userService.login(user);
        }else{
            result.setData("验证码错误");
        }
//        pw.append(JSON.toJSONString(result));
//        pw.close();
        if(callback!=null){
            pw.print(callback+"("+JSON.toJSONString(result)+")");
        }else{
            pw.append(JSON.toJSONString(result));
        }
        pw.flush();
        pw.close();

    }
}
