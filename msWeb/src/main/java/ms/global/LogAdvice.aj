package ms.global;

import ms.entity.Log;
import ms.entity.Staff;
import ms.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Raymond on 2018/11/25.
 */
@Component
@Aspect
public class LogAdvice {
    @Autowired
    private LogService logService;

    @AfterReturning("execution(* ms.controller.*.*(..)) && !execution(* ms.controller.SelfController.*(..)) && !execution(* ms.controller.*.to*(..))")
    public void operationLog(JoinPoint joinPoint){
        Log log = new Log();
        log.setModule(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request =(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        Staff staff =(Staff)obj;
        log.setOperator(staff.getAccount());
        log.setResult("成功");
        logService.addOperationLog(log);
    }
    @AfterThrowing(throwing ="e",pointcut ="execution(* ms.controller.*.*(..)) && !execution(* ms.controller.SelfController.*(..))")
    public void systemLog(JoinPoint joinPoint,Throwable e){
        Log log = new Log();
        log.setModule(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request =(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        Staff staff =(Staff)obj;
        log.setOperator(staff.getAccount());
        log.setResult(e.getClass().getSimpleName());
        logService.addSystemLog(log);
    }

    @After("execution(* ms.controller.SelfController.login(..))")
    public void loginLog(JoinPoint joinPoint){
        log(joinPoint);
    }

    @Before("execution(* ms.controller.SelfController.logout(..))")
    public void logoutLog(JoinPoint joinPoint){
        log(joinPoint);
    }

    private void log(JoinPoint joinPoint){
        Log log = new Log();
        log.setModule(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request =(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        if(obj==null){
            log.setOperator(request.getParameter("account"));
            log.setResult("失败");
        }else {
            Staff staff = (Staff) obj;
            log.setOperator(staff.getAccount());
            log.setResult("成功");
        }
        logService.addLoginLog(log);
    }
}
