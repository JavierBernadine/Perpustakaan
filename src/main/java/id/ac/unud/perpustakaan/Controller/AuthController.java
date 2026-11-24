package id.ac.unud.perpustakaan.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class AuthController {

    @GetMapping("/")
    public String home() {
        return "beranda";
    }

    @GetMapping ("/login1")
    public String login(){
        return "login";
    }

}
