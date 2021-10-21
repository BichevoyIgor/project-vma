package gpn.util;
import java.io.Serializable;

public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String username;
    private String domainName;
    private String email;

    //need default constructor for JSON Parsing
    public JwtRequest() {
    }

    public JwtRequest(String username, String domainName, String email) {
        this.setUsername(username);
        this.setDomainName(domainName);
        this.setEmail(email);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}