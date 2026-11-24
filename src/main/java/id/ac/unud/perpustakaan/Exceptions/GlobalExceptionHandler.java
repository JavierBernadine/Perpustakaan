package id.ac.unud.perpustakaan.Exceptions;

 
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
@ControllerAdvice
public class GlobalExceptionHandler {
 
    @ExceptionHandler(BisnisException.class)
    public String tanganiBisnis(BisnisException e, RedirectAttributes ra) {
        ra.addFlashAttribute("galat", e.getMessage());
        return "redirect:/dashboard";
    }
}
