//package com.wushang.Servlet.user;
//
//import com.alibaba.fastjson.JSON;
//import com.wushang.Service.user.userService;
//import com.wushang.bean.Result;
//import com.wushang.bean.userInformation;
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.*;
//import java.util.Calendar;
//import java.util.Iterator;
//import java.util.List;
//
//@WebServlet(name = "registServlet", value = "/registimg")
//public class registServletBak extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter pw=response.getWriter();
//        String callback = request.getParameter("callback");
//        System.out.println("callback:"+callback);
//        boolean flag = true;
////        Result result=new Result("fail",null,null);
//
//        Calendar now = Calendar.getInstance();
//        String tempPath = request.getSession().getServletContext().getRealPath("/upload/");
//        File file = new File(tempPath);
//        if(!file.exists()){
//            file.mkdir();
//        }
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        List items = null;
//        try {
//            items = upload.parseRequest(request);
//        } catch (FileUploadException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        byte data[] = new byte[1024];
//        int i = 0;
//        userInformation bean=new userInformation();
//        if (items != null)
//            for (Iterator iterator = items.iterator(); iterator.hasNext();) {
////            	items.iterator()主要是为用户提供了一种遍历其内部元素的方式，iterator.hasNext()判断是否有下一个元素
//                FileItem item = (FileItem) iterator.next();
//                System.out.println("item"+item);
//                //指针下移，返回该指针所指向的元素
//                if(item.isFormField()){
//                    //开始遍历表单的值
//                    System.out.println("表单名："+item.getFieldName()+"表单值："+new String(item.getString("utf-8")));
//                    if ("department".equals(item.getFieldName())) {
//                        bean.setDepartment(new String(item.getString("UTF-8")));
//                    }else if("regname".equals(item.getFieldName())) {
//                        bean.setRegname(new String(item.getString("UTF-8")));
//                    }else if("phone".equals(item.getFieldName())) {
//                        bean.setPhone(new String(item.getString("UTF-8")));
////                    } else if ("wsid".equals(item.getFieldName())) {
////                        bean.setWsid(new String(item.getString("UTF-8")));
////                    }else if ("age".equals(item.getFieldName())) {
////                        bean.setAge(new String(item.getString("UTF-8")));
//                    }
//                    else if ("password".equals(item.getFieldName())) {
//                        bean.setPassword(new String(item.getString("UTF-8")));
//                    }else if ("regtime".equals(item.getFieldName())) {
//                        bean.setRegtime(new String(item.getString("UTF-8")));
//                    }else if ("address".equals(item.getFieldName())) {
//                        bean.setAddress(new String(item.getString("UTF-8")));
//                    }
////                    else if("deptId".equals(item.getFieldName())) {
//////                        bean.setDeptId(new String(item.getString("UTF-8")));
//////                    }
//                   else if("sex".equals(item.getFieldName())) {
//                        bean.setSex(new String(item.getString("UTF-8")));
//                    }
//                }else{
//                    String fileName = item.getName().substring(item.getName().lastIndexOf(File.separator) + 1,item.getName().length());
//                    //得到用户上传文件的路径(在这里只保留文件名部分)
//                    System.out.println(fileName);
//                    if(fileName.indexOf("jpg")>1||fileName.indexOf("png")>1||fileName.indexOf("jpeg")>1||fileName.indexOf("JPG")>1||fileName.indexOf("PNG")>1||fileName.indexOf("JPEG")>1){
//                        //判断文件格式，是否上传图片,indexOf判断是否符合,如果没有则返回-1；
//                        InputStream inputStream=item.getInputStream();
//                        //获取item中的上传文件的输入流
//                        OutputStream outputStream = new FileOutputStream(tempPath+"//"+bean.getPhone()+fileName);
//                        //创建一个文件输出流
//                        while ((i = inputStream.read(data)) != -1) {
//                            //循环将输入流读入到缓冲区当中，(i=inputStream.read(data))>0就表示inputStream里面还有数据
//                            //而read()方法在读的时候是每次读取8个二进制位，这8个0或1就是我们所谓的一个byte（字节）,一个复杂字符（比如汉字）所占字节往往大于1，将图片编码读取
//                            outputStream.write(data, 0, i);
//                            //输出流将缓冲区的数据写入到指定的目录中去
//                        }
//                        inputStream.close();
//                        outputStream.close();
//                        //关闭输入输出流
//                        bean.setUpload(bean.getPhone()+fileName);
//                    }else{
//                        //上传格式错误
//                        flag = false;
////                        result.setFlag("typeError");
//                        System.out.println("因格式原因上传失败");
//                    }
//
//                }
//
//            }
//
//        Result result=userService.registUser(bean);
////        pw.append(JSON.toJSONString(result));
////        pw.close();
//        if(callback!=null){
//            pw.print(callback+"("+JSON.toJSONString(result)+")");
//        }else{
//            pw.append(JSON.toJSONString(result));
//        }
//        pw.flush();
//        pw.close();
//
//
//    }
//}
