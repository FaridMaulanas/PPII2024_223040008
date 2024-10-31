import javax.swing.*;
import java.awt.*;

public class FormPendaftaran extends JPanel {
    private JTextField txtNama, txtEmail, txtTelepon;
    private JTextArea txtAlamat;
    private JRadioButton rbBasic, rbPremium, rbVIP;
    private JCheckBox cbPersonalTraining, cbKelasGrup;
    private JComboBox<String> cbDurasi;
    private JList<String> listMinat;
    private JSlider sliderKebugaran;
    private JSpinner spinnerUmur;

    public FormPendaftaran() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Buwat margin di antara komponen
        gbc.fill = GridBagConstraints.HORIZONTAL; // biar komponen memperluas secara horizontal

        // Baris pertama: Nama
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nama:"), gbc);

        gbc.gridx = 1;
        txtNama = new JTextField(20);
        add(txtNama, gbc);

        // Baris kedua: Email
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        txtEmail = new JTextField(20);
        add(txtEmail, gbc);

        // Baris ketiga: Telepon
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Telepon:"), gbc);

        gbc.gridx = 1;
        txtTelepon = new JTextField(20);
        add(txtTelepon, gbc);

        // Baris keempat: Alamat
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Alamat:"), gbc);

        gbc.gridx = 1;
        txtAlamat = new JTextArea(3, 20);
        add(new JScrollPane(txtAlamat), gbc);

        // Baris kelima: Paket Keanggotaan
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Paket Keanggotaan:"), gbc);

        gbc.gridx = 1;
        JPanel panelPaket = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        rbBasic = new JRadioButton("Basic");
        rbPremium = new JRadioButton("Premium");
        rbVIP = new JRadioButton("VIP");
        ButtonGroup grupPaket = new ButtonGroup();
        grupPaket.add(rbBasic);
        grupPaket.add(rbPremium);
        grupPaket.add(rbVIP);
        panelPaket.add(rbBasic);
        panelPaket.add(rbPremium);
        panelPaket.add(rbVIP);
        add(panelPaket, gbc);

        // Baris keenam: Layanan Tambahan
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Layanan Tambahan:"), gbc);

        gbc.gridx = 1;
        JPanel panelLayanan = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        cbPersonalTraining = new JCheckBox("Personal Training");
        cbKelasGrup = new JCheckBox("Kelas Grup");
        panelLayanan.add(cbPersonalTraining);
        panelLayanan.add(cbKelasGrup);
        add(panelLayanan, gbc);

        // Baris ketujuh: Durasi Keanggotaan
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Durasi Keanggotaan:"), gbc);

        gbc.gridx = 1;
        cbDurasi = new JComboBox<>(new String[]{"1 Bulan", "3 Bulan", "6 Bulan", "1 Tahun"});
        add(cbDurasi, gbc);

        // Baris kedelapan: Minat
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(new JLabel("Minat:"), gbc);

        gbc.gridx = 1;
        listMinat = new JList<>(new String[]{"Yoga", "Angkat Beban", "Kardio", "CrossFit"});
        listMinat.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(listMinat), gbc);

        // Baris kesembilan: Tingkat Kebugaran
        gbc.gridx = 0;
        gbc.gridy = 8;
        add(new JLabel("Tingkat Kebugaran:"), gbc);

        gbc.gridx = 1;
        sliderKebugaran = new JSlider(1, 10);
        sliderKebugaran.setMajorTickSpacing(1);
        sliderKebugaran.setPaintTicks(true);
        sliderKebugaran.setPaintLabels(true);
        add(sliderKebugaran, gbc);

        // Baris kesepuluh: Umur
        gbc.gridx = 0;
        gbc.gridy = 9;
        add(new JLabel("Umur:"), gbc);

        gbc.gridx = 1;
        spinnerUmur = new JSpinner(new SpinnerNumberModel(18, 10, 100, 1));
        add(spinnerUmur, gbc);
    }

    // Mendapatkan data dari form untuk ditambahkan ke tabel
    public Anggota getDataAnggota() {
        String nama = txtNama.getText();
        String email = txtEmail.getText();
        String telepon = txtTelepon.getText();
        String alamat = txtAlamat.getText();
        String paket = rbBasic.isSelected() ? "Basic" : rbPremium.isSelected() ? "Premium" : "VIP";
        String durasi = (String) cbDurasi.getSelectedItem();
        int umur = (Integer) spinnerUmur.getValue();

        return new Anggota(nama, email, telepon, paket, durasi, umur);
    }

    // Membersihkan form input
    public void bersihkanForm() {
        txtNama.setText("");
        txtEmail.setText("");
        txtTelepon.setText("");
        txtAlamat.setText("");
        rbBasic.setSelected(false);
        rbPremium.setSelected(false);
        rbVIP.setSelected(false);
        cbPersonalTraining.setSelected(false);
        cbKelasGrup.setSelected(false);
        cbDurasi.setSelectedIndex(0);
        listMinat.clearSelection();
        sliderKebugaran.setValue(1);
        spinnerUmur.setValue(18);
    }
}
