package dao;

import db.MySqlConnection;
import model.Biodata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BiodataDao {
    private static final Logger logger = Logger.getLogger(BiodataDao.class.getName());
    private final Connection connection;

    public BiodataDao() {
        this.connection = MySqlConnection.getConnection();
        if (connection == null) {
            logger.log(Level.SEVERE, "Failed to establish database connection.");
        }
    }

    // Menambahkan data biodata baru
    public void addBiodata(Biodata biodata) {
        String query = "INSERT INTO biodata (nama, alamat) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, biodata.getNama());
            statement.setString(2, biodata.getAlamat());
            statement.executeUpdate();
            logger.log(Level.INFO, "Data biodata berhasil ditambahkan!");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Gagal menambahkan data biodata!", e);
        }
    }

    // Mengambil semua data biodata
    public List<Biodata> getAllBiodata() {
        List<Biodata> biodataList = new ArrayList<>();
        String query = "SELECT * FROM biodata";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Biodata biodata = new Biodata();
                biodata.setId(resultSet.getString("id"));
                biodata.setNama(resultSet.getString("nama"));
                biodata.setAlamat(resultSet.getString("alamat"));
                biodataList.add(biodata);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Gagal mengambil data biodata!", e);
        }
        return biodataList;
    }

    // Memperbarui data biodata
    public void updateBiodata(Biodata biodata) {
        String query = "UPDATE biodata SET nama = ?, alamat = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, biodata.getNama());
            statement.setString(2, biodata.getAlamat());
            statement.setString(3, biodata.getId());
            statement.executeUpdate();
            logger.log(Level.INFO, "Data biodata berhasil diperbarui!");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Gagal memperbarui data biodata!", e);
        }
    }

    // Menghapus data biodata berdasarkan ID
    public void deleteBiodata(String id) {
        String query = "DELETE FROM biodata WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.executeUpdate();
            logger.log(Level.INFO, "Data biodata berhasil dihapus!");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Gagal menghapus data biodata!", e);
        }
    }
}
