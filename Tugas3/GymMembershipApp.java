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

       
        formPendaftaran = new FormPendaftaran();
        tabelAnggota = new TabelAnggota();

        
        add(formPendaftaran, BorderLayout.NORTH);
        add(new JScrollPane(tabelAnggota), BorderLayout.CENTER);

        // Tombol buat submit dan clear
        JPanel panelTombol = new JPanel();
        JButton btnSubmit = new JButton("Daftar");
        JButton btnClear = new JButton("Bersihkan");
        panelTombol.add(btnSubmit);
        panelTombol.add(btnClear);
        add(panelTombol, BorderLayout.SOUTH);

       
        btnSubmit.addActionListener(e -> {
            Anggota anggotaBaru = formPendaftaran.getDataAnggota();
            tabelAnggota.tambahAnggota(anggotaBaru);
            formPendaftaran.bersihkanForm();
        });

       
        btnClear.addActionListener(e -> formPendaftaran.bersihkanForm());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GymMembershipApp app = new GymMembershipApp();
            app.setVisible(true);
        });
    }
}
