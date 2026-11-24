package id.ac.unud.perpustakaan.Security;
import id.ac.unud.perpustakaan.Model.Pengguna;
import id.ac.unud.perpustakaan.Model.StatusAnggota;
import id.ac.unud.perpustakaan.Repository.PenggunaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
/** Menghubungkan Spring Security dengan tabel pengguna di database. */
@Service
public class PenggunaDetailsService implements UserDetailsService {
 
    private final PenggunaRepository penggunaRepository;
 
    public PenggunaDetailsService(PenggunaRepository penggunaRepository) {
        this.penggunaRepository = penggunaRepository;
    }
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Pengguna p = penggunaRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Pengguna tidak ditemukan"));
 
        return User.withUsername(p.getUsername())
                .password(p.getPasswordHash())
                .roles(p.getPeran().name())
                .disabled(p.getStatus() == StatusAnggota.NONAKTIF)
                .build();
    }
}
