package ru.zakharov.enterprise.filter;

import javax.servlet.*;
import java.io.IOException;

public class UTFFilter implements Filter {
    private String encoding;

    private boolean forceEncoding;


    public final void init(FilterConfig filterConfig) {
        String encod = filterConfig.getInitParameter("encoding");
        if (encod != null) encoding = encod;
        String forceEncod = filterConfig.getInitParameter("forceEncoding");
        if (forceEncod != null) forceEncoding = Boolean.parseBoolean(forceEncod);

    }

    public final void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (this.encoding != null &&
                (this.forceEncoding || request.getCharacterEncoding() == null)) {
            request.setCharacterEncoding(this.encoding);
            if (this.forceEncoding) response.setCharacterEncoding(this.encoding);
        }
        filterChain.doFilter(request, response);
    }

    public void destroy() {

    }
}
