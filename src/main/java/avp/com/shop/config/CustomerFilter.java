package avp.com.shop.config;

import javax.servlet.*;
import java.io.IOException;

public class CustomerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("Greeting from filter!");
    }

    @Override
    public void destroy() {
    }
}
