package gpn.service;

import java.util.ArrayList;
import java.util.List;

import gpn.contract.Claim;
import gpn.contract.SessionUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    private Integer id;
    private String domainName;
    private String email;
    private List<Claim> claims;

    private final String pass = "$2a$10$ixlPY3AAd4ty1l6E2IsQ9OFZi2ba9ZQE0bP7RFcGIWNhyFrrT3YUi";

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        SessionUser sessionUser = new SessionUser(username, pass, new ArrayList<>());
//        sessionUser.setId(Long.valueOf(id));
        sessionUser.setEmail(email);
        sessionUser.setDomainName(domainName);
        sessionUser.setClaims(claims);
        return sessionUser;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
