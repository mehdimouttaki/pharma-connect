package ma.pharmaconnect.app.pharmaconnect.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.pharmaconnect.app.pharmaconnect.model.User;
import ma.pharmaconnect.app.pharmaconnect.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class RestSecurityHandlerInterceptor implements HandlerInterceptor {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws IOException {

        List<String> authorizedUrls = new ArrayList<>(
                Arrays.asList(
                        "/api/clients",
                        "/api/login"
                )
        );
        String toCheck = httpServletRequest.getRequestURI();
        Optional<String> isExist = authorizedUrls.stream()
                .filter(toCheck::endsWith)
                .findFirst();

        if (isExist.isPresent()) {
            return true;
        }

        String username = httpServletRequest.getHeader("username");
        User user = userService.getByUsername(username);
        String password = httpServletRequest.getHeader("password");

        if (user != null) {
            boolean matchedPassword = passwordEncoder.matches(password, user.getPassword());
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

}
