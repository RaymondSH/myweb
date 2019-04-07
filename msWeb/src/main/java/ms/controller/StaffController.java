package ms.controller;

import ms.entity.Department;
import ms.entity.Staff;
import ms.service.DepartmentService;
import ms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Raymond on 2018/11/25.
 */
@Controller("staffController")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> list = staffService.getAll();
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("/staff_list.jsp").forward(request,response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.getAll();
        request.setAttribute("DLIST",list);
        request.getRequestDispatcher("/staff_add.jsp").forward(request,response);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String IDCard = request.getParameter("IDCard");
        String info =request.getParameter("info");

        Integer departmentId = Integer.parseInt(request.getParameter("department_id"));

        System.out.println(request.getParameter("department_id"));
        Staff staff = new Staff();
        staff.setInfo(info);
        staff.setIDCard(IDCard);
        staff.setAccount(account);
        staff.setName(name);
        staff.setDepartmentId(departmentId);
        System.out.println(staff);
        staff.setSex(sex);

        staffService.add(staff);
        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.getById(id);
        request.setAttribute("OBJ",staff);
        List<Department> list = departmentService.getAll();
        request.setAttribute("DLIST",list);
        request.getRequestDispatcher("../staff_edit.jsp").forward(request,response);
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String IDCard = request.getParameter("IDCard");
        String info =request.getParameter("info");


        Integer departmentId = Integer.parseInt(request.getParameter("department_id"));

        Staff staff = staffService.getById(id);
        staff.setInfo(info);
        staff.setIDCard(IDCard);
        staff.setDepartmentId(departmentId);
        staff.setAccount(account);
        staff.setName(name);
        staff.setSex(sex);

        staffService.edit(staff);
        response.sendRedirect("list.do");
    }
    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        staffService.remove(id);
        response.sendRedirect("list.do");
    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.getById(id);
        request.setAttribute("OBJ",staff);
        request.getRequestDispatcher("../staff_detail.jsp").forward(request,response);
    }
}

