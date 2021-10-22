package gpn.controller;


import gpn.contract.SessionUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {
    /**
     * Получить фейковые данные по графикам
     *
     * @return фейковые данные по графикам
     */
    @GetMapping("/testjwt")
    public ResponseEntity<?> getFakeResult(@AuthenticationPrincipal SessionUser sUser) {
        try {
            System.out.println("User: " + sUser.getUsername());
            System.out.println("DomainName: " + sUser.getDomainName());
            System.out.println("User email: " + sUser.getEmail());
            return ResponseEntity.ok(String.format("succes connect: user: %s,\nDomainName: %s,\nemail: %s", sUser.getUsername(), sUser.getDomainName(), sUser.getEmail()));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
