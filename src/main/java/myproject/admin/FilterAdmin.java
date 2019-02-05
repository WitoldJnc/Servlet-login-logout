package myproject.admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class FilterAdmin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest)req).getSession();
        if(session.getAttribute("user") == null){
            ((HttpServletResponse)res).sendRedirect("/");
        }else {
            filterChain.doFilter(req, res);
        }

    }

    @Override
    public void destroy() {

    }
}
