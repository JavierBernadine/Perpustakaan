package id.ac.unud.perpustakaan.Model;

public enum StatusPeminjaman {
    DIAJUKAN("Diajukan"),
    DITOLAK("Ditolak"),
    DISETUJUI("Disetujui"),
    DIKEMBALIKAN("Dikembalikan"),
    DIPINJAM("DIPINJAM");

    private final String label;

    StatusPeminjaman(String label) {
        this.label = label ;
    } 

    public String getLabel(){
        return label;
    }

    
}
