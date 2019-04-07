package ms.global;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Raymond on 2018/11/24.
 */
public class CharacterEncodingFilter implements Filter {
    private String encoding = "UTF-8";
    public void destroy() {
        encoding = null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("loading......");
        if (config.getInitParameter("Encoding") != null)
            encoding = config.getInitParameter("Encoding");
    }

}
