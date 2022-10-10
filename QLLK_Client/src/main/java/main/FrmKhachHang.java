/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.KhachHang_DAO;
import entity.KhachHang;
import entity.LinhKien;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class FrmKhachHang extends javax.swing.JPanel {

    KhachHang_DAO khDao;
    List<KhachHang> dsKh;
    DefaultTableModel dfKh_Model;

    public FrmKhachHang() {
        initComponents();
        dsKh = new ArrayList<KhachHang>();
        try {
            String urlKh = "//192.168.1.3:6881/khDao";
            khDao = (KhachHang_DAO) Naming.lookup(urlKh);
        } catch (Exception e) {
        }
        jTextField_maLK.setEditable(false);
        upTableKh();
    }

    public void reload() {
        dsKh.removeAll(dsKh);
        xoaModel();
        upTableKh();
    }

    private void xoaRongTexf() {
       
        jTextField_nhasx.setText("");
        jTextField_tenLK.setText("");

        jTextField_tinhtrang.setText("");
    }

    public void upTableKh() {
        dfKh_Model = (DefaultTableModel) jTable_LK.getModel();

        try {

            dsKh = khDao.getAllKH();
            for (KhachHang kh : dsKh) {
                dfKh_Model.addRow(new Object[]{
                    kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getDiaChi()
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xoaModel() {
        DefaultTableModel del = (DefaultTableModel) jTable_LK.getModel();
        del.getDataVector().removeAllElements();
    }

    public boolean kiemtradata() {
        String maLk = jTextField_maLK.getText().trim();
        String tenlk = jTextField_tenLK.getText().trim();
        String diaChi = jTextField_tinhtrang.getText().trim();

        String sdt = jTextField_nhasx.getText().trim();
        if (!(tenlk.length() > 0)) {
            JOptionPane.showMessageDialog(this, "Tên Khách Hàng phải là chữ");
            return false;
        }
        if (!(diaChi.length() > 0)) {
            JOptionPane.showMessageDialog(this, "Địa Chỉ phải là chữ");
            return false;
        }
        if (sdt.length() <= 0 ) {
		JOptionPane.showMessageDialog(this, "Hãy nhập số điện thoại");			
		return false;
            }
            else if(!sdt.matches("^[0-9]{10}")){
                JOptionPane.showMessageDialog(this, "Số điện thoại có 10 chữ số ");			
		return false;
            }

        return true;

    }

    private KhachHang restTexf() {
        KhachHang kh = null;
        String maKH = jTextField_maLK.getText().toString();
        String sdt = jTextField_nhasx.getText().toString();
        String tenlk = jTextField_tenLK.getText().toString();
        String diaChi = jTextField_tinhtrang.getText().toString();
        kh = new KhachHang(tenlk, diaChi, sdt);
        return kh;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_LK = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_maLK = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_tenLK = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_tinhtrang = new javax.swing.JTextField();
        jTextField_nhasx = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_LK = new javax.swing.JTable();
        jButton_addLK = new javax.swing.JButton();
        jButton_xoaLK = new javax.swing.JButton();
        jButton_suaLK = new javax.swing.JButton();
        jButton_luuLK = new javax.swing.JButton();

        jp_LK.setBackground(new java.awt.Color(242, 242, 242));
        jp_LK.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(90, 103, 121), null), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(90, 103, 121));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quản Lý Khách Hàng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Mã Khách Hàng:");

        jTextField_maLK.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_maLK.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tên Khách Hàng:");

        jTextField_tenLK.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_tenLK.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Địa Chỉ:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Số Điện Thoại :");

        jTextField_tinhtrang.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_tinhtrang.setForeground(new java.awt.Color(0, 0, 0));

        jTextField_nhasx.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_nhasx.setForeground(new java.awt.Color(0, 0, 0));

        jTable_LK.setBackground(new java.awt.Color(255, 255, 255));
        jTable_LK.setForeground(new java.awt.Color(0, 0, 0));
        jTable_LK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Địa Chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_LK.setRowHeight(30);
        jTable_LK.setShowGrid(true);
        jTable_LK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_LKMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_LK);

        jButton_addLK.setBackground(new java.awt.Color(0, 123, 255));
        jButton_addLK.setForeground(new java.awt.Color(255, 255, 255));
        jButton_addLK.setText("Thêm ");
        jButton_addLK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addLKActionPerformed(evt);
            }
        });

        jButton_xoaLK.setBackground(new java.awt.Color(255, 102, 102));
        jButton_xoaLK.setForeground(new java.awt.Color(255, 255, 255));
        jButton_xoaLK.setText("Xóa ");
        jButton_xoaLK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_xoaLKActionPerformed(evt);
            }
        });

        jButton_suaLK.setBackground(new java.awt.Color(23, 162, 184));
        jButton_suaLK.setForeground(new java.awt.Color(255, 255, 255));
        jButton_suaLK.setText(" Sửa TT");
        jButton_suaLK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_suaLKsuaLKActionPerformed(evt);
            }
        });

        jButton_luuLK.setBackground(new java.awt.Color(40, 167, 69));
        jButton_luuLK.setForeground(new java.awt.Color(255, 255, 255));
        jButton_luuLK.setText("Lưu");
        jButton_luuLK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_luuLKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_LKLayout = new javax.swing.GroupLayout(jp_LK);
        jp_LK.setLayout(jp_LKLayout);
        jp_LKLayout.setHorizontalGroup(
            jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_LKLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_LKLayout.createSequentialGroup()
                        .addComponent(jButton_addLK)
                        .addGap(43, 43, 43)
                        .addComponent(jButton_luuLK)
                        .addGap(36, 36, 36)
                        .addComponent(jButton_suaLK)
                        .addGap(35, 35, 35)
                        .addComponent(jButton_xoaLK))
                    .addGroup(jp_LKLayout.createSequentialGroup()
                        .addGroup(jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_LKLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(46, 46, 46)
                                .addComponent(jTextField_maLK, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jp_LKLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jTextField_tinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(58, 58, 58)
                        .addGroup(jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(40, 40, 40)
                        .addGroup(jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_tenLK, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                            .addComponent(jTextField_nhasx))))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_LKLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(jp_LKLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jp_LKLayout.setVerticalGroup(
            jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_LKLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_maLK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_tenLK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(59, 59, 59)
                .addGroup(jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_tinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_nhasx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(37, 37, 37)
                .addGroup(jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_addLK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_suaLK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_luuLK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_xoaLK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1106, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jp_LK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jp_LK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_LKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_LKMouseClicked
        // TODO add your handling code here:
        int r = jTable_LK.getSelectedRow();
        jTextField_maLK.setText(dfKh_Model.getValueAt(r, 0).toString());
        jTextField_tenLK.setText(dfKh_Model.getValueAt(r, 1).toString());
        jTextField_nhasx.setText(dfKh_Model.getValueAt(r, 2).toString());
        jTextField_tinhtrang.setText(dfKh_Model.getValueAt(r, 3).toString());

    }//GEN-LAST:event_jTable_LKMouseClicked

    private void jButton_addLKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addLKActionPerformed

        xoaRongTexf();
    }//GEN-LAST:event_jButton_addLKActionPerformed

    private void jButton_xoaLKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_xoaLKActionPerformed
        // TODO add your handling code here:
        try {
            int r = jTable_LK.getSelectedRow();
            String id = dfKh_Model.getValueAt(r, 0).toString();
            if (r != -1) {
                int tb = JOptionPane.showConfirmDialog(null, "Bạn  chắc chắn muốn xóa dòng này không?", "Detele", JOptionPane.YES_NO_OPTION);
                if (tb == JOptionPane.YES_OPTION) {
                    dfKh_Model.removeRow(r);
                    khDao.xoaKH(id);
                    dsKh.removeAll(dsKh);
                    xoaRongTexf();
                    xoaModel();
                    upTableKh();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xóa!");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton_xoaLKActionPerformed

    private void jButton_suaLKsuaLKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_suaLKsuaLKActionPerformed
        // TODO add your handling code here:
        try {
            int r = jTable_LK.getSelectedRow();
            jTextField_maLK.setEnabled(false);
            if (r != -1) {
                if (kiemtradata()) {
                    int tb = JOptionPane.showConfirmDialog(null, "Bạn có chắc sửa dòng này?", "Cảnh Báo!",
                            JOptionPane.YES_NO_OPTION);
                    if (tb == JOptionPane.YES_OPTION) {
                        //String maS=dflk_Model.getValueAt(r, 0).toString();
//                                        String maLk = jTextField_maLK.getText().trim();
//                                        String tenllk = jComboBox_llk.getSelectedItem().toString();// tên loaijlinh kiện
//                                        String baohanh = jcb_baohanh.getSelectedItem().toString();
//                                        int soluong = Integer.parseInt(jtex_soluong.getText().trim());
//                                        String tenlk = jTextField_tenLK.getText().trim();
//                                        String tinhtrang = jTextField_tinhtrang.getText().trim();
//                                        String nhasx = jTextField_nhasx.getText().trim();
//                                        double dongia = Double.parseDouble(jTextField_dongia.getText().trim());
//                                        LoaiLinhKien llk = llk_dao.getLoaiLinhKienTheoTenLK(tenllk);
//                                        KhachHang kh = restTexf();
                        String maKH = jTextField_maLK.getText().toString();
                        String sdt = jTextField_nhasx.getText().toString();
                        String tenlk = jTextField_tenLK.getText().toString();
                        String diaChi = jTextField_tinhtrang.getText().toString();
                        KhachHang kh = new KhachHang(maKH, tenlk, diaChi, sdt);
                        if (khDao.updateKH(kh)) {
                            xoaRongTexf();
                            dfKh_Model.setRowCount(0);
                            dsKh = khDao.getAllKH();
                            for (KhachHang khs : dsKh) {
                                dfKh_Model.addRow(new Object[]{
                                    khs.getMaKH(), khs.getTenKH(), khs.getSdt(), khs.getDiaChi()
                                });
                            }
                            dsKh.removeAll(dsKh);
                            xoaRongTexf();
                            xoaModel();
                            upTableKh();
                            JOptionPane.showMessageDialog(this, "Cập nhật danh sách thành công");
                            jTextField_maLK.setEnabled(true);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_suaLKsuaLKActionPerformed

    private void jButton_luuLKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_luuLKActionPerformed
        // TODO add your handling code here:
        try {
            if (kiemtradata()) {
                KhachHang kh = restTexf();
                if (khDao.themKH(kh)) {
                    dfKh_Model.addRow(new Object[]{
                        kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getDiaChi()
                    });
                    dsKh.removeAll(dsKh);
                    xoaRongTexf();
                    xoaModel();
                    upTableKh();
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Mã linh kiện đã có vui lòng nhập lại ");

                }

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton_luuLKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_addLK;
    private javax.swing.JButton jButton_luuLK;
    private javax.swing.JButton jButton_suaLK;
    private javax.swing.JButton jButton_xoaLK;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_LK;
    public javax.swing.JTextField jTextField_maLK;
    public javax.swing.JTextField jTextField_nhasx;
    public javax.swing.JTextField jTextField_tenLK;
    public javax.swing.JTextField jTextField_tinhtrang;
    private javax.swing.JPanel jp_LK;
    // End of variables declaration//GEN-END:variables
}
