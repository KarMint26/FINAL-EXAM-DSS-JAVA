/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import sipsmea.database;

/**
 *
 * @author karel
 */
public class TableFunc {

    public static Statement st; // memberikan statement perintah sql, select insert delete
    public static ResultSet rs; // membaca data di dalam db, membaca record di db
    public static Connection cn = database.connectDb();

    public static void centerHeaderTable(JTable t) {
        TableCellRenderer rendererFromHeader = t.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        JTableHeader header = t.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
    }

    public static void centeringRow(JTable j) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < j.getColumnCount(); i++) {
            j.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        centerHeaderTable(j);
    }
    
    public static void setHasilSpk() {
        try {
            double w1 = 0;
            double w2 = 0;
            double w3 = 0;
            double w4 = 0;
            double w5 = 0;

            String selectBobotSql = "SELECT * FROM users WHERE id = 1";
            try (PreparedStatement bobotStmt = cn.prepareStatement(selectBobotSql); 
                    ResultSet bobotRs = bobotStmt.executeQuery()) {

                if (bobotRs.next()) {
                    w1 = bobotRs.getDouble("w1");
                    w2 = bobotRs.getDouble("w2");
                    w3 = bobotRs.getDouble("w3");
                    w4 = bobotRs.getDouble("w4");
                    w5 = bobotRs.getDouble("w5");

                } else {
                    System.out.println("Data bobot tidak ditemukan (id=1).");
                }

                String selectNormalisasiSql = "SELECT * FROM normalisasi";
                try (PreparedStatement normalisasiStmt = cn.prepareStatement(selectNormalisasiSql);
                        ResultSet normalisasiRs = normalisasiStmt.executeQuery()) {

                    while (normalisasiRs.next()) {
                        int id = normalisasiRs.getInt("id");
                        String nama = normalisasiRs.getString("nama_tempat_pkl");
                        double nRating = normalisasiRs.getDouble("rating");
                        double nDayaTampung = normalisasiRs.getDouble("daya_tampung");
                        double nAksesJalan = normalisasiRs.getDouble("akses_jalan");
                        double nPeminat = normalisasiRs.getDouble("peminat");
                        double nJarak = normalisasiRs.getDouble("jarak");

                        double hasilSpk = (nRating * w1) + (nDayaTampung * w2)
                                + (nAksesJalan * w3) + (nPeminat * w4) + (nJarak * w5);

                        String updateSql = "UPDATE hasil_spk SET hasil=?, nama_tempat_pkl=? WHERE id=?";
                        try (PreparedStatement updateStmt = cn.prepareStatement(updateSql)) {
                            updateStmt.setDouble(1, hasilSpk);
                            updateStmt.setString(2, nama);
                            updateStmt.setInt(3, id);
                            updateStmt.executeUpdate();
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setNormalisasi() {
        try {
            String selectMinMaxSql = "SELECT * FROM minmax WHERE id = 1";
            try (PreparedStatement minMaxStmt = cn.prepareStatement(selectMinMaxSql); ResultSet minMaxRs = minMaxStmt.executeQuery()) {

                if (minMaxRs.next()) {
                    double ratingMax = minMaxRs.getDouble("rating");
                    double dayaTampungMax = minMaxRs.getDouble("daya_tampung");
                    double aksesJalanMax = minMaxRs.getDouble("akses_jalan");
                    double peminatMin = minMaxRs.getDouble("peminat");
                    double jarakMin = minMaxRs.getDouble("jarak");

                    String selectPilihanSql = "SELECT * FROM pilihan";
                    try (PreparedStatement pilihanStmt = cn.prepareStatement(selectPilihanSql); ResultSet pilihanRs = pilihanStmt.executeQuery()) {

                        while (pilihanRs.next()) {
                            int id = pilihanRs.getInt("id");
                            String nama = pilihanRs.getString("nama_tempat_pkl");
                            double rating = pilihanRs.getDouble("rating");
                            double dayaTampung = pilihanRs.getDouble("daya_tampung");
                            double aksesJalan = pilihanRs.getDouble("akses_jalan");
                            double peminat = pilihanRs.getDouble("peminat");
                            double jarak = pilihanRs.getDouble("jarak");

                            double normalisasiRating = rating / ratingMax;
                            double normalisasiDayaTampung = dayaTampung / dayaTampungMax;
                            double normalisasiAksesJalan = aksesJalan / aksesJalanMax;
                            double normalisasiPeminat = peminatMin / peminat; // Peminat menggunakan min
                            double normalisasiJarak = jarakMin / jarak; // Jarak menggunakan min

                            String updateSql = "UPDATE normalisasi SET rating=?, "
                                    + "daya_tampung=?, akses_jalan=?, peminat=?, jarak=?, nama_tempat_pkl=? WHERE id=?";
                            try (PreparedStatement updateStmt = cn.prepareStatement(updateSql)) {
                                updateStmt.setDouble(1, normalisasiRating);
                                updateStmt.setDouble(2, normalisasiDayaTampung);
                                updateStmt.setDouble(3, normalisasiAksesJalan);
                                updateStmt.setDouble(4, normalisasiPeminat);
                                updateStmt.setDouble(5, normalisasiJarak);
                                updateStmt.setString(6, nama);
                                updateStmt.setInt(7, id);
                                updateStmt.executeUpdate();
                            }
                        }
                    }
                } else {
                    System.out.println("Data minmax tidak ditemukan (id=1).");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setMinMax() {
        try {
            String selectSql = "SELECT MAX(rating) as max_rating, MAX(daya_tampung) as max_daya_tampung, "
                    + "MAX(akses_jalan) as max_akses_jalan, MIN(peminat) as min_peminat, MIN(jarak) as min_jarak "
                    + "FROM pilihan";

            try (PreparedStatement selectStmt = cn.prepareStatement(selectSql); ResultSet rs = selectStmt.executeQuery()) {

                if (rs.next()) {
                    int ratingMax = rs.getInt("max_rating");
                    int dayaTampungMax = rs.getInt("max_daya_tampung");
                    int aksesJalanMax = rs.getInt("max_akses_jalan");
                    int peminatMin = rs.getInt("min_peminat");
                    int jarakMin = rs.getInt("min_jarak");

                    String updateSql = "UPDATE minmax SET rating=?, daya_tampung=?, "
                            + "akses_jalan=?, peminat=?, jarak=? WHERE id=1";
                    try (PreparedStatement updateStmt = cn.prepareStatement(updateSql)) {
                        updateStmt.setInt(1, ratingMax);
                        updateStmt.setInt(2, dayaTampungMax);
                        updateStmt.setInt(3, aksesJalanMax);
                        updateStmt.setInt(4, peminatMin);
                        updateStmt.setInt(5, jarakMin);

                        int rowsUpdated = updateStmt.executeUpdate();
                        if (rowsUpdated > 0) {
                            System.out.println("Tabel minmax berhasil diupdate.");
                        } else {
                            System.out.println("Tidak ada baris yang diupdate di tabel minmax.");
                            // Ini mungkin terjadi jika tidak ada baris dengan id=1
                        }
                    }
                } else {
                    System.out.println("Tabel pilihan kosong.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
