package id.ac.unud.perpustakaan.Model;

public enum  StatusAnggota {
    AKTIF("Aktif"),
    NONAKTIF("Non-Aktif");

    private final String label ;

    StatusAnggota(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
