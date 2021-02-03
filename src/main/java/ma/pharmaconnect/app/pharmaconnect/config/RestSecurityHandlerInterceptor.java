package ma.pharmaconnect.app.pharmaconnect.config;

import lombok.extern.slf4j.Slf4j;
import ma.pharmaconnect.app.pharmaconnect.model.Client;
import ma.pharmaconnect.app.pharmaconnect.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class RestSecurityHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    private ClientService clientService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws IOException {

        if (httpServletRequest.getRequestURL().toString().contains("/clients")) {
            return true;
        }

        String username = httpServletRequest.getHeader("username");
        Client client = clientService.getByUsername(username);
        String password = httpServletRequest.getHeader("password");

        if (client != null) {
            boolean matchedPassword = passwordEncoder.matches(password, client.getPassword());
            if (matchedPassword) {
                return true;
            } else {
                httpServletResponse.setStatus(401);
                httpServletResponse.getWriter().write("password of " + username + " is not correct.");
                httpServletResponse.getWriter().flush();
                return false;
            }
        } else {
            httpServletResponse.setStatus(401);
            httpServletResponse.getWriter().write(username + " not found in our system.");
            httpServletResponse.getWriter().flush();
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
    }

}
