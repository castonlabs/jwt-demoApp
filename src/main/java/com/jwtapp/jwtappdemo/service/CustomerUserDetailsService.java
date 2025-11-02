import com.jwtapp.jwtappdemo.model.AppUser;
import com.jwtapp.jwtappdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found" + username));
        return new User(
                appUser.getUserName(),
                appUser.getPassword(),
                getAuthority(appUser)

        );
    }

    private Collection<? extends GrantedAuthority> getAuthority(AppUser appUser) {
        GrantedAuthority authority = new SimpleGrantedAuthority(appUser.getRole().name());
        return List.of(authority);
    }
}
