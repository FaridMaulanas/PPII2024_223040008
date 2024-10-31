public class Anggota {
    private String nama, email, telepon, paket, durasi;
    private int umur;

    public Anggota(String nama, String email, String telepon, String paket, String durasi, int umur) {
        this.nama = nama;
        this.email = email;
        this.telepon = telepon;
        this.paket = paket;
        this.durasi = durasi;
        this.umur = umur;
    }

    public String getNama() { return nama; }
    public String getEmail() { return email; }
    public String getTelepon() { return telepon; }
    public String getPaket() { return paket; }
    public String getDurasi() { return durasi; }
    public int getUmur() { return umur; }
}
