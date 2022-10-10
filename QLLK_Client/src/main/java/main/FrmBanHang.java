/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.LinhKien_DAO;
import java.rmi.Naming;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.LoaiLinhKien_DAO;
import entity.LinhKien;
import entity.LoaiLinhKien;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static main.FrmGioHang.jTable_HD;

/**
 *
 * @author HP
 */
public class FrmBanHang extends javax.swing.JPanel {

    LinhKien_DAO lkDao;
    LoaiLinhKien_DAO llkDao;

    public static DefaultTableModel dfBh_Model;
    public static DefaultTableModel dfGh_Model;
    public static List<LinhKien> dsLK;
    private String maSPClick = "";
    private int soLuongTon = 0;
    public static ArrayList<LinhKien> dstt = null;

    public FrmBanHang() {
        initComponents();

        dsLK = new ArrayList<LinhKien>();
        dstt = new ArrayList<LinhKien>();
        try {
            String urlLK = "rmi://192.168.1.3:6881/lkDao";
            lkDao = (LinhKien_DAO) Naming.lookup(urlLK);
            String urlLLK = "rmi://192.168.1.3:6881/llkdao";
            llkDao = (LoaiLinhKien_DAO) Naming.lookup(urlLLK);
        } catch (Exception e) {
        }
        upTableLk();
    }

    /**
     * đọc dử liệu lên table
     *
     */
    public void upTableLk() {
        dfBh_Model = (DefaultTableModel) jTable_home.getModel();
        try {
            dsLK = lkDao.getAllLK();
            for (LinhKien lk : dsLK) {
                dfBh_Model.addRow(new Object[]{
                    lk.getMaLK(), lk.getTenLK(), lk.getNhaSx(), lk.getTinhTrang(), lk.getBaoHanh(), lk.getLoaiLinhKien().getTenLoaiLK(), lk.getSoLuongTon(), lk.getDonGia()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * xóa model table
     *
     */
    public void xoaModel() {
        DefaultTableModel del = (DefaultTableModel) jTable_home.getModel();
        del.getDataVector().removeAllElements();
    }

    /**
     * xóa model table
     *
     */
    public int vitriLK(LinhKien lk) {
        int i = -1;
        if (dstt.contains(lk)) {
            return dstt.indexOf(lk);
        }
        return i;
    }

    /**
     * tai lại danh sách
     */
    public void reload() {
        dsLK.removeAll(dsLK);
        xoaModel();
        upTableLk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_home = new javax.swing.JPanel();
        jt_sl = new javax.swing.JTextField();
        jlb_sl = new javax.swing.JLabel();
        jp_search = new javax.swing.JPanel();
        jScrollPane_home = new javax.swing.JScrollPane();
        jTable_home = new javax.swing.JTable();
        jb_mua = new javax.swing.JButton();
        jButton_tk = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jp_home.setBackground(new java.awt.Color(255, 255, 255));

        jt_sl.setBackground(new java.awt.Color(255, 255, 255));
        jt_sl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jt_sl.setForeground(new java.awt.Color(51, 51, 51));
        jt_sl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jt_sl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(90, 103, 121)));
        jt_sl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_slActionPerformed(evt);
            }
        });

        jlb_sl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlb_sl.setForeground(new java.awt.Color(0, 0, 0));
        jlb_sl.setText("Số Lượng:");

        jp_search.setBackground(new java.awt.Color(255, 255, 255));
        jp_search.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(90, 103, 121), null), "Danh Sách Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jTable_home.setBackground(new java.awt.Color(255, 255, 255));
        jTable_home.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTable_home.setForeground(new java.awt.Color(0, 0, 0));
        jTable_home.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Linh Kiện", "Tên Linh Kiện", "Nhà Sản Xuất", "Tình Trạng", "Bảo Hành ", "Loại Linh Kiện", "Số Lượng Tồn", "Đơn Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_home.setGridColor(new java.awt.Color(255, 255, 255));
        jTable_home.setRowHeight(35);
        jTable_home.setSelectionBackground(new java.awt.Color(90, 103, 121));
        jTable_home.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_homeMouseClicked(evt);
            }
        });
        jScrollPane_home.setViewportView(jTable_home);

        javax.swing.GroupLayout jp_searchLayout = new javax.swing.GroupLayout(jp_search);
        jp_search.setLayout(jp_searchLayout);
        jp_searchLayout.setHorizontalGroup(
            jp_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_home)
        );
        jp_searchLayout.setVerticalGroup(
            jp_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_searchLayout.createSequentialGroup()
                .addComponent(jScrollPane_home, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        jb_mua.setBackground(new java.awt.Color(40, 189, 139));
        jb_mua.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jb_mua.setForeground(new java.awt.Color(255, 255, 255));
        jb_mua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sent.png"))); // NOI18N
        jb_mua.setText("Đặt Hàng");
        jb_mua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_muaActionPerformed(evt);
            }
        });

        jButton_tk.setBackground(new java.awt.Color(255, 255, 255));
        jButton_tk.setForeground(new java.awt.Color(0, 0, 0));
        jButton_tk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        jButton_tk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_tkMouseClicked(evt);
            }
        });
        jButton_tk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_tkActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jTextField1.setText("Tìm Sản Phẩm");
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(90, 103, 121)));
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        jButton4.setContentAreaFilled(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus.png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jp_homeLayout = new javax.swing.GroupLayout(jp_home);
        jp_home.setLayout(jp_homeLayout);
        jp_homeLayout.setHorizontalGroup(
            jp_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_homeLayout.createSequentialGroup()
                .addGroup(jp_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_homeLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jb_mua, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_homeLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_tk, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                        .addComponent(jlb_sl, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jt_sl, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(6, 6, 6)))
                .addGap(56, 56, 56))
        );
        jp_homeLayout.setVerticalGroup(
            jp_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_homeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_homeLayout.createSequentialGroup()
                        .addComponent(jp_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addGroup(jp_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlb_sl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jp_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jt_sl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jp_homeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jp_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_homeLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jButton_tk))
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59)
                .addComponent(jb_mua, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1126, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jp_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jp_home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jt_slActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_slActionPerformed

    }//GEN-LAST:event_jt_slActionPerformed

    private void jTable_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_homeMouseClicked
        // TODO add your handling code here:
        int r = jTable_home.getSelectedRow();
        //        //jTextField_maLK.setText(dfModel.getValueAt(r, 0).toString());
        jt_sl.setText(dfBh_Model.getValueAt(r, 6).toString());
        maSPClick = jTable_home.getValueAt(r, 0).toString();

    }//GEN-LAST:event_jTable_homeMouseClicked

    private void jb_muaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_muaActionPerformed

        try {
            dfGh_Model = (DefaultTableModel) jTable_HD.getModel();
            int r = jTable_home.getSelectedRow();
            soLuongTon = Integer.parseInt(dfBh_Model.getValueAt(r, 6).toString());
            String malk = (dfBh_Model.getValueAt(r, 0).toString());
            String ten = (dfBh_Model.getValueAt(r, 1).toString());
            String nhsx = (dfBh_Model.getValueAt(r, 2).toString());
            String tinhtrang = (dfBh_Model.getValueAt(r, 3).toString());
            String baohanh = (dfBh_Model.getValueAt(r, 4).toString());
            String llk = (dfBh_Model.getValueAt(r, 5).toString());
            LoaiLinhKien llks = null;
            llks = llkDao.getLoaiLinhKienTheoTenLK(llk);
            int soluong = 0;
            double dongia = 0;
            try {
                soluong = Integer.parseInt(jt_sl.getText());
                dongia = Double.parseDouble(dfBh_Model.getValueAt(r, 7).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (soluong <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng mua phải lớn hơn số lương trong kho!");
                return;
            }
            double thanhtien = soluong * dongia;
            LinhKien lk = new LinhKien(malk, ten, nhsx, tinhtrang, baohanh, llks, soluong, dongia);
            int vitri = vitriLK(lk);
            System.out.println(vitri);
            if (soLuongTon < lk.getSoLuongTon()) {
                JOptionPane.showMessageDialog(this, "số lượng phải nhọ hơn hoặc bằng số lượng tồn");
                return;
            }
            if (vitri > -1) {
                Integer sl = dstt.get(vitri).getSoLuongTon() + lk.getSoLuongTon();
                dstt.get(vitri).setSoLuongTon(sl);

                dfGh_Model.setValueAt(sl, vitri, 4);
            } else {
                try {
                    dstt.add(lk);
                } catch (Exception e) {
                    System.out.println("loi");
                    e.printStackTrace();
                }
                dfGh_Model.addRow(new Object[]{
                    lk.getTenLK(), lk.getLoaiLinhKien().getTenLoaiLK(), lk.getTinhTrang(), lk.getNhaSx(), soluong, lk.getDonGia(), lk.getBaoHanh(), thanhtien
                });
            }
            soLuongTon -= lk.getSoLuongTon();
            dfBh_Model.setValueAt(soLuongTon, r, 6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jb_muaActionPerformed

    private void jButton_tkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_tkMouseClicked
        try {
            xoaModel();
            String text = jTextField1.getText().trim().toLowerCase();
            dsLK = lkDao.searchTenOrMa(text);
            for (LinhKien lk : dsLK) {
                dfBh_Model.addRow(new Object[]{
                    lk.getMaLK(), lk.getTenLK(), lk.getNhaSx(), lk.getTinhTrang(), lk.getBaoHanh(), lk.getLoaiLinhKien().getTenLoaiLK(), lk.getSoLuongTon(), lk.getDonGia()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_tkMouseClicked

    private void jButton_tkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_tkActionPerformed


    }//GEN-LAST:event_jButton_tkActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        try {
            xoaModel();
            String text = jTextField1.getText().trim().toLowerCase();
            dsLK = lkDao.searchTenOrMa(text);
            if (!dsLK.isEmpty()) {
                for (LinhKien lk : dsLK) {
                    dfBh_Model.addRow(new Object[]{
                        lk.getMaLK(), lk.getTenLK(), lk.getNhaSx(), lk.getTinhTrang(), lk.getBaoHanh(), lk.getLoaiLinhKien().getTenLoaiLK(), lk.getSoLuongTon(), lk.getDonGia()});
                }
            } else {
                JOptionPane.showMessageDialog(null, "Không Tìm Thấy Sản Phẩm có mã" + text + " !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1FocusGained

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        if (jt_sl.getText().equals("1")) {
            jButton5.setEnabled(false);
        } else {
            int minus = 0;
            int sl = Integer.parseInt(jt_sl.getText().toString());
            if (sl - 1 > 0) {
                minus = sl - 1;
                jt_sl.setText(String.valueOf(minus));
                jButton5.setEnabled(true);
            }

        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked

        int plus = 0;
        int sl = Integer.parseInt(jt_sl.getText().toString());
        plus = sl + 1;
        jt_sl.setText(String.valueOf(plus));
    }//GEN-LAST:event_jButton4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton_tk;
    public static javax.swing.JScrollPane jScrollPane_home;
    public static javax.swing.JTable jTable_home;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jb_mua;
    private javax.swing.JLabel jlb_sl;
    private javax.swing.JPanel jp_home;
    private javax.swing.JPanel jp_search;
    private javax.swing.JTextField jt_sl;
    // End of variables declaration//GEN-END:variables
}
