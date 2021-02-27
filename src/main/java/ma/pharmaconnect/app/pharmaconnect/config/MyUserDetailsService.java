package ma.pharmaconnect.app.pharmaconnect.config;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.User;
import ma.pharmaconnect.app.pharmaconnect.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class MyUserDetailsService  implements UserDetailsService {
   private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("user not exist %s ", userName)));
        Collection<SimpleGrantedAuthority> roles = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()));;
        return new   org.springframework.security.core.userdetails.User(user.getUsername(),  user.getPassword(), roles);
    }
}
