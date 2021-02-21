package ma.pharmaconnect.app.pharmaconnect.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RegisterConfig implements WebMvcConfigurer {
    @Autowired
    private RestSecurityHandlerInterceptor restSecurityHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(restSecurityHandlerInterceptor).addPathPatterns("/api/**");
    }
}
