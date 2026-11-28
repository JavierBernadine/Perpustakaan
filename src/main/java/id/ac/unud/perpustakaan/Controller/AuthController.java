package id.ac.unud.perpustakaan.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import id.ac.unud.perpustakaan.Util.Keamanan;
 
@Controller
public class AuthController {
 
    @GetMapping("/")
    public String beranda() {
        return "beranda";
    }
 
    @GetMapping("/login")
    public String login() {
        return "login1";
    }
 
   
    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication) {
        return Keamanan.isAdmin(authentication)
                ? "redirect:/admin/dashboard"
                : "redirect:/mahasiswa/dashboard";
    }
}

