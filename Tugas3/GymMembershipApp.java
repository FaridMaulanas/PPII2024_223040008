import javax.swing.*;
import java.awt.*;

public class GymMembershipApp extends JFrame {
    private FormPendaftaran formPendaftaran;
    private TabelAnggota tabelAnggota;

    public GymMembershipApp() {
        setTitle("Pendaftaran Gym Membership");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Inisialisasi form pendaftaran dan tabel anggota
        formPendaftaran = new FormPendaftaran();
        tabelAnggota = new TabelAnggota();

        // Tambahkan panel input dan tabel ke tampilan utama
        add(formPendaftaran, BorderLayout.NORTH);
        add(new JScrollPane(tabelAnggota), BorderLayout.CENTER);

        // Tombol untuk submit dan clear
        JPanel panelTombol = new JPanel();
        JButton btnSubmit = new JButton("Daftar");
        JButton btnClear = new JButton("Bersihkan");
        panelTombol.add(btnSubmit);
        panelTombol.add(btnClear);
        add(panelTombol, BorderLayout.SOUTH);

        // Aksi Tombol Submit
        btnSubmit.addActionListener(e -> {
            Anggota anggotaBaru = formPendaftaran.getDataAnggota();
            tabelAnggota.tambahAnggota(anggotaBaru);
            formPendaftaran.bersihkanForm();
        });

        // Aksi Tombol Clear
        btnClear.addActionListener(e -> formPendaftaran.bersihkanForm());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GymMembershipApp app = new GymMembershipApp();
            app.setVisible(true);
        });
    }
}
