package ms.global;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Raymond on 2018/11/24.
 */
public class DispatcherServlet extends GenericServlet {

    //    加载配置文件
    private ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        System.out.println("request.getServletPath:====" + request.getServletPath());
        //        /toLogin.do
        //        /department/list.do
        String path = request.getServletPath().substring(1);
        String beanName;
        String methodName;
        int index = path.indexOf("/");
        System.out.println("index=========== "+index);
        if (index != -1){
            //            departmentController
            beanName = path.substring(0,index) + "Controller";
            //            list
            methodName = path.substring(index + 1,path.indexOf(".do"));
        }else {
            beanName = "selfController";
            //           toLogin
            methodName = path.substring(0,path.indexOf(".do"));
        }
        System.out.println(beanName+","+methodName);
        Object object = context.getBean(beanName);
        System.out.println(object);
        try {
            Method method = object.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            System.out.println(method);
            method.invoke(object,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
