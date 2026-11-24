package id.ac.unud.perpustakaan.Util;

import org.springframework.security.core.Authentication;
 
public final class Keamanan {
 
    private Keamanan() {
    }
 
    public static boolean isAdmin(Authentication authentication) {
        return punyaPeran(authentication, "ROLE_ADMIN");
    }
 
    public static boolean isMahasiswa(Authentication authentication) {
        return punyaPeran(authentication, "ROLE_MAHASISWA");
    }
 
    private static boolean punyaPeran(Authentication authentication, String peran) {
        return authentication != null && authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals(peran));
    }
}
