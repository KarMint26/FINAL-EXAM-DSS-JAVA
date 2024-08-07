/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.sipsmea.panel;

import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sipsmea.database;
import utils.TableFunc;

/**
 *
 * @author karel
 */
public class NilaiBobot extends javax.swing.JPanel {

    public Statement st; // memberikan statement perintah sql, select insert delete
    public ResultSet rs; // membaca data di dalam db, membaca record di db
    Connection cn = database.connectDb();

    /**
     * Creates new form NilaiBobot
     */
    public NilaiBobot() {
        initComponents();
        refreshTable();

        TableFunc.centeringRow(tbBobot);
    }

    private void refreshTable() {
        try {
            DefaultTableModel m = (DefaultTableModel) tbBobot.getModel();

            String q = "SELECT * FROM users";
            Statement s = cn.createStatement();
            ResultSet r = s.executeQuery(q);
            m.getDataVector().removeAllElements();
            while (r.next()) {
                double rating = r.getDouble("w1");
                double dayaTampung = r.getDouble("w2");
                double aksesJalan = r.getDouble("w3");
                double peminat = r.getDouble("w4");
                double jarak = r.getDouble("w5");
                Object[] data = {rating, dayaTampung, aksesJalan, peminat, jarak};
                m.addRow(data);
            }

        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBobot = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbRating = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbDayaTampung = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbPeminat = new javax.swing.JComboBox<>();
        cbJarak = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbAksesJalan1 = new javax.swing.JComboBox<>();
        btnSimpanBobot = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 249, 244));

        jLabel1.setFont(new java.awt.Font("Liberation Sans Narrow", 1, 18)); // NOI18N
        jLabel1.setText("NILAI BOBOT");

        tbBobot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Rating", "Daya Tampung", "Akses Jalan", "Peminat", "Jarak"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbBobot.setRowHeight(35);
        tbBobot.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tbBobot.setShowGrid(true);
        jScrollPane1.setViewportView(tbBobot);

        jLabel2.setText("Masukan Nilai Bobot Kriteria");

        jLabel3.setText("Bobot Rating");

        cbRating.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sangat Tidak Penting (1)", "Tidak Penting (2)", "Cukup Penting (3)", "Penting (4)", "Sangat Penting (5)" }));

        jLabel4.setText("Bobot Daya Tampung");

        cbDayaTampung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sangat Tidak Penting (1)", "Tidak Penting (2)", "Cukup Penting (3)", "Penting (4)", "Sangat Penting (5)" }));

        jLabel5.setText("Bobot Akses Jalan");

        jLabel6.setText("Bobot Peminat");

        cbPeminat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sangat Tidak Penting (1)", "Tidak Penting (2)", "Cukup Penting (3)", "Penting (4)", "Sangat Penting (5)" }));

        cbJarak.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sangat Tidak Penting (1)", "Tidak Penting (2)", "Cukup Penting (3)", "Penting (4)", "Sangat Penting (5)" }));

        jLabel7.setText("Bobot Jarak");

        cbAksesJalan1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sangat Tidak Penting (1)", "Tidak Penting (2)", "Cukup Penting (3)", "Penting (4)", "Sangat Penting (5)" }));

        btnSimpanBobot.setBackground(new java.awt.Color(182, 0, 99));
        btnSimpanBobot.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnSimpanBobot.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpanBobot.setText("SIMPAN");
        btnSimpanBobot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimpanBobotMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(200, 200, 200))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(101, 101, 101))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(51, 51, 51)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbRating, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbDayaTampung, 0, 1, Short.MAX_VALUE))
                                .addGap(14, 14, 14)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(cbAksesJalan1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbPeminat, 0, 1, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(cbJarak, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSimpanBobot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(233, 233, 233))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbJarak, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbRating, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbAksesJalan1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnSimpanBobot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbDayaTampung, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbPeminat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70))
        );
    }// </editor-fold>//GEN-END:initComponents

    private double hitungBobot(int choose, int w1, int w2, int w3, int w4, int w5) {
        double result = (double) choose / (w1 + w2 + w3 + w4 + w5);
        DecimalFormat df = new DecimalFormat("#.#####"); // Format dengan 4 angka di belakang koma
        return Double.parseDouble(df.format(result));
    }

    private void btnSimpanBobotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanBobotMouseClicked
        try {
            int w1 = cbRating.getSelectedIndex() + 1;
            int w2 = cbDayaTampung.getSelectedIndex() + 1;
            int w3 = cbAksesJalan1.getSelectedIndex() + 1;
            int w4 = cbPeminat.getSelectedIndex() + 1;
            int w5 = cbJarak.getSelectedIndex() + 1;

            String sql = "UPDATE users SET w1=?, w2=?, w3=?, w4=?, w5=? WHERE id=?";
            PreparedStatement stmt = cn.prepareStatement(sql);

            stmt.setDouble(1, hitungBobot(w1, w1, w2, w3, w4, w5));
            stmt.setDouble(2, hitungBobot(w2, w1, w2, w3, w4, w5));
            stmt.setDouble(3, hitungBobot(w3, w1, w2, w3, w4, w5));
            stmt.setDouble(4, hitungBobot(w4, w1, w2, w3, w4, w5));
            stmt.setDouble(5, hitungBobot(w5, w1, w2, w3, w4, w5));
            stmt.setInt(6, 1);

            int rowsUpdated = stmt.executeUpdate();

            stmt.close();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data bobot berhasil diperbarui.", "Sukses",
                        JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
                TableFunc.setMinMax();
                TableFunc.setNormalisasi();
                TableFunc.setHasilSpk();
            } else {
                JOptionPane.showMessageDialog(null, "Gagal memperbarui data bobot.", "Gagal", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSimpanBobotMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpanBobot;
    private javax.swing.JComboBox<String> cbAksesJalan1;
    private javax.swing.JComboBox<String> cbDayaTampung;
    private javax.swing.JComboBox<String> cbJarak;
    private javax.swing.JComboBox<String> cbPeminat;
    private javax.swing.JComboBox<String> cbRating;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbBobot;
    // End of variables declaration//GEN-END:variables
}
