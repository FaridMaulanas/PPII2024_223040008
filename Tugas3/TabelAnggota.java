import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TabelAnggota extends JTable {
    private DefaultTableModel model;

    public TabelAnggota() {
        model = new DefaultTableModel(new String[]{"Nama", "Email", "Telepon", "Paket", "Durasi", "Umur"}, 0);
        setModel(model);
    }

    public void tambahAnggota(Anggota anggota) {
        model.addRow(new Object[]{
                anggota.getNama(),
                anggota.getEmail(),
                anggota.getTelepon(),
                anggota.getPaket(),
                anggota.getDurasi(),
                anggota.getUmur()
        });
    }
}
