package ms.controller;

import ms.entity.Staff;
import ms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Raymond on 2018/11/25.
 */
@Controller("selfController")
public class SelfController {

    @Autowired
    private StaffService staffService;

    //      /toLogin.do
    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
    //      /login.do
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account =request.getParameter("account");
        String password = request.getParameter("password");

        Staff staff = staffService.login(account,password);
        System.out.println("selfController "+staff);
        if(staff==null){
            response.sendRedirect("toLogin.do");
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("USER",staff);
            response.sendRedirect("main.do");
        }
    }
    //      /logout.do
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("USER", null);
        response.sendRedirect("toLogin.do");
    }
    //      /main.do
    public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
    //      /self/info.do
    public void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../info.jsp").forward(request,response);
    }
    //      /self/toChangePassword.do
    public void toChangePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../change_password.jsp").forward(request,response);
    }
    //      /self/changePassword.do
    public void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passwordOld = request.getParameter("passwordOld");
        String passwordNew = request.getParameter("passwordNew");
        System.out.println(passwordOld+ " " + passwordNew);
        HttpSession session = request.getSession();
        Staff staff = (Staff)session.getAttribute("USER");
        if(!staff.getPassword().equals(passwordOld)){
            response.sendRedirect("toChangePassword.do");
        }else{
            staffService.changePassword(staff.getId(),passwordNew);
            //response.sendRedirect("../logout.do");
            response.getWriter().print("<script type=\"text/javascript\">parent.location.href=\"../logout.do\"</script>");
        }
    }
}