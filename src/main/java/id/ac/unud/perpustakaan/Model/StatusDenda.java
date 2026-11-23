package id.ac.unud.perpustakaan.Model;

public enum StatusDenda {
    BELUM("Belum Lunas"),
    LUNAS("Lunas");

    private final String label;

    StatusDenda(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}