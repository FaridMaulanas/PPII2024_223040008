import controller.MahasiswaController;
import java.util.List;
import javax.swing.*;
import model.Mahasiswa;
import model.MahasiswaMapper;
import model.MyBatisUtil;
import view.MahasiswaView;

public class Main {
    public static void main(String[] args) {
       
        MyBatisUtil.initializeDatabase();

    
        List<Mahasiswa> mahasiswaList = MahasiswaMapper.getAllMahasiswa();

     
        MahasiswaView view = new MahasiswaView(mahasiswaList);

     
        MahasiswaController controller = new MahasiswaController(view);

        
view.setAddButtonListener(e -> {
    String nim = JOptionPane.showInputDialog(view, "Masukkan NIM:");
    String nama = JOptionPane.showInputDialog(view, "Masukkan Nama:");
    String jurusan = JOptionPane.showInputDialog(view, "Masukkan Jurusan:");
    String email = JOptionPane.showInputDialog(view, "Masukkan Email:");
    String alamat = JOptionPane.showInputDialog(view, "Masukkan Alamat:");

    if (nim != null && nama != null && jurusan != null && email != null && alamat != null) {
        Mahasiswa mahasiswa = new Mahasiswa(nim, nama, jurusan, email, alamat);
        controller.addMahasiswa(mahasiswa);

        // Alert bahwa data berhasil ditambahkan
        JOptionPane.showMessageDialog(view, "Data Mahasiswa berhasil ditambahkan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
    }
});


view.setUpdateButtonListener(e -> {
    int selectedRow = view.getSelectedRow();
    if (selectedRow >= 0) {
        Mahasiswa mahasiswa = view.getMahasiswaFromTable(selectedRow);
        String nama = JOptionPane.showInputDialog(view, "Ubah Nama:", mahasiswa.getNama());
        String jurusan = JOptionPane.showInputDialog(view, "Ubah Jurusan:", mahasiswa.getJurusan());
        String email = JOptionPane.showInputDialog(view, "Ubah Email:", mahasiswa.getEmail());
        String alamat = JOptionPane.showInputDialog(view, "Ubah Alamat:", mahasiswa.getAlamat());

        if (nama != null && jurusan != null && email != null && alamat != null) {
            mahasiswa.setNama(nama);
            mahasiswa.setJurusan(jurusan);
            mahasiswa.setEmail(email);
            mahasiswa.setAlamat(alamat);
            controller.updateMahasiswa(mahasiswa);
            view.updateMahasiswaInTable(selectedRow, mahasiswa);

           
            JOptionPane.showMessageDialog(view, "Data Mahasiswa berhasil diupdate!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(view, "Pilih data yang ingin diupdate.");
    }
});


        view.setDeleteButtonListener(e -> {
            int selectedRow = view.getSelectedRow();
            if (selectedRow >= 0) {
                Mahasiswa mahasiswa = view.getMahasiswaFromTable(selectedRow);
                int confirm = JOptionPane.showConfirmDialog(view, "Yakin ingin menghapus mahasiswa dengan NIM " + mahasiswa.getNim() + "?");
                if (confirm == JOptionPane.YES_OPTION) {
                    controller.deleteMahasiswa(mahasiswa.getNim());
                    view.removeMahasiswaFromTable(selectedRow);
                }
            } else {
                JOptionPane.showMessageDialog(view, "Pilih data yang ingin dihapus.");
            }
        });

        SwingUtilities.invokeLater(() -> view.setVisible(true));
    }
}
