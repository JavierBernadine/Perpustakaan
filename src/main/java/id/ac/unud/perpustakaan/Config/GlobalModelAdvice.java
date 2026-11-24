package id.ac.unud.perpustakaan.Config;

import id.ac.unud.perpustakaan.Model.Peran;
import id.ac.unud.perpustakaan.Repository.PenggunaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
 
import java.security.Principal;
 
/** Menyediakan data pengguna yang sedang login ke semua halaman (dipakai oleh menu navigasi). */
@ControllerAdvice
public class GlobalModelAdvice {
 
    private final PenggunaRepository penggunaRepository;
 
    public GlobalModelAdvice(PenggunaRepository penggunaRepository) {
        this.penggunaRepository = penggunaRepository;
    }
 
    @ModelAttribute
    public void tambahDataPengguna(Model model, Principal principal) {
        if (principal == null) {
            return;
        }
        penggunaRepository.findByUsername(principal.getName()).ifPresent(p -> {
            model.addAttribute("penggunaLogin", p);
            model.addAttribute("adalahAdmin", p.getPeran() == Peran.ADMIN);
            model.addAttribute("adalahMahasiswa", p.getPeran() == Peran.MAHASISWA);
        });
    }
}
