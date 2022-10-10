/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.LinhKien_DAO;
import dao.LoaiLinhKien_DAO;
import entity.LinhKien;
import entity.LoaiLinhKien;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class FrmLinhKien extends javax.swing.JPanel {

    LinhKien_DAO lkDao;
    LoaiLinhKien_DAO llk_dao;
    DefaultTableModel dfLK_Model;
    List<LinhKien> dsLK;
    

    /**
     * Creates new form FrmLinhKien
     */
    public FrmLinhKien() {
        initComponents();
        dsLK = new ArrayList<LinhKien>();
        try {
            String url = "rmi://192.168.1.3:6881/lkDao";
            lkDao = (LinhKien_DAO) Naming.lookup(url);
            String urlLLK = "rmi://192.168.1.3:6881/llkdao";
            llk_dao=(LoaiLinhKien_DAO) Naming.lookup(urlLLK);
        } catch (Exception e) {
        }
        upTableLk();
        upJC();
        jTextField_maLK.setEditable(false);

    }
    
   public void reload(){
       dsLK.removeAll(dsLK);
       xoaModel();
       upTableLk();
    }

    public void upTableLk() {
        dfLK_Model = (DefaultTableModel) jTable_LK.getModel();

        try {

            dsLK = lkDao.getAllLK();
            for (LinhKien lk : dsLK) {
                dfLK_Model.addRow(new Object[]{
                    lk.getMaLK(), lk.getTenLK(), lk.getNhaSx(), lk.getTinhTrang(), lk.getBaoHanh(), lk.getLoaiLinhKien().getTenLoaiLK(), lk.getSoLuongTon(), lk.getDonGia()});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void xoaModel() {
        DefaultTableModel del = (DefaultTableModel) jTable_LK.getModel();
        del.getDataVector().removeAllElements();
    }
    
    private void xoaRongTexf() {
      
        
        jtex_soluong.setText("");
       
        jTextField_tenLK.setText("");
        jTextField_dongia.setText("");
       jTextField_tenLK1.setText("");
    }
    
    public boolean kiemtradata() {String maLk = jTextField_maLK.getText().trim();
        String tenlk = jTextField_tenLK.getText().trim();
        String tinhtrang = jTextField_tenLK1.getText().trim();
        
        String sl = jtex_soluong.getText().trim();
        String dongia = jTextField_dongia.getText().trim();
        String baohanh = jcb_baohanh.getSelectedItem().toString().trim();
        String llk = jComboBox_llk.getSelectedItem().toString().trim();
        
        if (!(tenlk.length() > 0)) {
            JOptionPane.showMessageDialog(this, "Tên linh kiện phải là chữ");
            return false;
        }
        if (!(tinhtrang.length() > 0 )) {
            JOptionPane.showMessageDialog(this, "Tình  phải là chữ");
            return false;
        }
        if (sl.length() > 0) {
            try {
                int x = Integer.parseInt(sl);
                if (x <= 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng phải nhập số nguyên dương");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Số lượng phải nhập số nguyên dương");
                return false;
            }
        }
        if (dongia.length() > 0) {
            try {
                double y = Double.parseDouble(dongia);
                if (y < 0) {
                    JOptionPane.showMessageDialog(this, "Đơn giá phải lơn hơn 0 ");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Đơn giá phải nhập số");
                return false;
            }
        }
        return true;

    }
    
    private LinhKien restTexf() {
        LoaiLinhKien llk =null;
        LinhKien lk = null;
            String maLk = jTextField_maLK.getText().toString();
        String tenllk = jComboBox_llk.getSelectedItem().toString();// tên loaijlinh kiện
        String baohanh = jcb_baohanh.getSelectedItem().toString();
        int soluong = Integer.parseInt(jtex_soluong.getText());
        String tenlk = jTextField_tenLK.getText().toString();
        String tinhtrang = jTextField_tenLK1.getText().toString();
        String nhasx = jComboBox_llk1.getSelectedItem().toString();
        double dongia = Double.parseDouble(jTextField_dongia.getText());
        try {
            llk = llk_dao.getLoaiLinhKienTheoTenLK(tenllk);
        } catch (Exception e) {
        }
         lk = new LinhKien( tenlk, nhasx, tinhtrang, baohanh, soluong, dongia);
         lk.setLoaiLinhKien(llk);
         return lk;


    }
    
    public void upJC() {
        try {
            List<LoaiLinhKien> dsLLK = llk_dao.getAllLLK();
        for (LoaiLinhKien llk : dsLLK) {
            jComboBox_llk.addItem(llk.getTenLoaiLK());
        }
        } catch (Exception e) {
        }

        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_LK = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_maLK = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcb_baohanh = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField_tenLK = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtex_soluong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox_llk = new javax.swing.JComboBox<>();
        jTextField_dongia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_LK = new javax.swing.JTable();
        jButton_addLK = new javax.swing.JButton();
        jButton_xoaLK = new javax.swing.JButton();
        jButton_suaLK = new javax.swing.JButton();
        jButton_luuLK = new javax.swing.JButton();
        jComboBox_llk1 = new javax.swing.JComboBox<>();
        jTextField_tenLK1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jp_LK.setBackground(new java.awt.Color(242, 242, 242));
        jp_LK.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(90, 103, 121), null), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(90, 103, 121));
        jLabel2.setText("QUẢN LÝ LINH KIỆN");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mã Linh Kiện:");

        jTextField_maLK.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_maLK.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Bảo Hành:");

        jcb_baohanh.setBackground(new java.awt.Color(255, 255, 255));
        jcb_baohanh.setForeground(new java.awt.Color(0, 0, 0));
        jcb_baohanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12 Tháng", "24 Tháng", "36 Tháng" }));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tên Linh Kiện:");

        jTextField_tenLK.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_tenLK.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Số Lượng Tồn :");

        jtex_soluong.setBackground(new java.awt.Color(255, 255, 255));
        jtex_soluong.setForeground(new java.awt.Color(0, 0, 0));
        jtex_soluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtex_soluongActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Loại  Linh Kiện:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Đơn Giá:");

        jComboBox_llk.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_llk.setForeground(new java.awt.Color(0, 0, 0));

        jTextField_dongia.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_dongia.setForeground(new java.awt.Color(0, 0, 0));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Nhà Sản Xuất:");

        jTable_LK.setBackground(new java.awt.Color(255, 255, 255));
        jTable_LK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Linh Kiện", "Tên Linh Kiện", "Nhà Sản Xuất", "Tình Trạng", "Bảo Hành", "Loại Linh Kiện", "Số Lượng Tồn", "Đơn Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
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
        jButton_addLK.setText("Thêm");
        jButton_addLK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addLKActionPerformed(evt);
            }
        });

        jButton_xoaLK.setBackground(new java.awt.Color(255, 102, 102));
        jButton_xoaLK.setForeground(new java.awt.Color(255, 255, 255));
        jButton_xoaLK.setText("Xóa");
        jButton_xoaLK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_xoaLKActionPerformed(evt);
            }
        });

        jButton_suaLK.setBackground(new java.awt.Color(23, 162, 184));
        jButton_suaLK.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jButton_suaLK.setForeground(new java.awt.Color(255, 255, 255));
        jButton_suaLK.setText(" Sửa TT ");
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

        jComboBox_llk1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_llk1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox_llk1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACER", "HP", "" }));

        jTextField_tenLK1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_tenLK1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Tình Trạng:");

        javax.swing.GroupLayout jp_LKLayout = new javax.swing.GroupLayout(jp_LK);
        jp_LK.setLayout(jp_LKLayout);
        jp_LKLayout.setHorizontalGroup(
            jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_LKLayout.createSequentialGroup()
                .addGap(472, 472, 472)
                .addComponent(jLabel2))
            .addGroup(jp_LKLayout.createSequentialGroup()
                .addGap(594, 594, 594)
                .addComponent(jButton_addLK)
                .addGap(42, 42, 42)
                .addComponent(jButton_luuLK)
                .addGap(33, 33, 33)
                .addComponent(jButton_suaLK)
                .addGap(30, 30, 30)
                .addComponent(jButton_xoaLK))
            .addGroup(jp_LKLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jp_LKLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(69, 69, 69)
                .addGroup(jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_maLK, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_baohanh, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtex_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_llk, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addGap(73, 73, 73)
                .addGroup(jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_tenLK, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_tenLK1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_llk1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jp_LKLayout.setVerticalGroup(
            jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_LKLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_maLK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(jp_LKLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jTextField_tenLK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jcb_baohanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(jp_LKLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jTextField_tenLK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jtex_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addGroup(jp_LKLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jComboBox_llk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox_llk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addGroup(jp_LKLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jTextField_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jp_LKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_addLK, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton_luuLK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_suaLK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_xoaLK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1132, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jp_LK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jp_LK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtex_soluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtex_soluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtex_soluongActionPerformed

    private void jTable_LKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_LKMouseClicked
        // TODO add your handling code here:
                int r = jTable_LK.getSelectedRow();
                jTextField_maLK.setText(dfLK_Model.getValueAt(r, 0).toString());
                jTextField_tenLK.setText(dfLK_Model.getValueAt(r, 1).toString());
                jComboBox_llk1.setSelectedItem(dfLK_Model.getValueAt(r, 2).toString());
                jTextField_tenLK1.setText(dfLK_Model.getValueAt(r, 3).toString());
                jcb_baohanh.setSelectedItem(dfLK_Model.getValueAt(r, 4).toString());
                jComboBox_llk.setSelectedItem(dfLK_Model.getValueAt(r, 5).toString());
                jtex_soluong.setText(dfLK_Model.getValueAt(r, 6).toString());
                jTextField_dongia.setText(dfLK_Model.getValueAt(r, 7).toString());
    }//GEN-LAST:event_jTable_LKMouseClicked

    private void jButton_addLKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addLKActionPerformed

                xoaRongTexf();
    }//GEN-LAST:event_jButton_addLKActionPerformed

    private void jButton_xoaLKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_xoaLKActionPerformed
        // TODO add your handling code here:
               try {
             int r = jTable_LK.getSelectedRow();
                String id = dfLK_Model.getValueAt(r, 0).toString();
                if (r != -1) {
                    int tb = JOptionPane.showConfirmDialog(null, "Bạn  chắc chắn muốn xóa dòng này không?", "Detele", JOptionPane.YES_NO_OPTION);
                    if (tb == JOptionPane.YES_OPTION) {
                        dfLK_Model.removeRow(r);
                        lkDao.xoaLK(id);
                        dsLK.removeAll(dsLK);
                        xoaRongTexf();
                        xoaModel();
                        upTableLk();
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
                            String maLk = jTextField_maLK.getText().trim();
                            String tenllk = jComboBox_llk.getSelectedItem().toString();// tên loaijlinh kiện
                            String baohanh = jcb_baohanh.getSelectedItem().toString();
                            int soluong = Integer.parseInt(jtex_soluong.getText().trim());
                            String tenlk = jTextField_tenLK.getText().trim();
                            String tinhtrang = jTextField_tenLK1.getText().trim();
                            String nhasx = jComboBox_llk1.getSelectedItem().toString();
                            double dongia = Double.parseDouble(jTextField_dongia.getText().trim());
                            LoaiLinhKien llk = llk_dao.getLoaiLinhKienTheoTenLK(tenllk);
                            LinhKien lk = new LinhKien(maLk, tenlk, nhasx, tinhtrang, baohanh, llk, soluong, dongia);
                            
                            if (lkDao.update(lk)) {
        
                                xoaRongTexf();
                                dfLK_Model.setRowCount(0);
        
                                dsLK = lkDao.getAllLK();
                                for (LinhKien lik : dsLK) {
                                    dfLK_Model.addRow(new Object[]{
                                        lik.getMaLK(),
                                        lik.getTenLK(), lik.getNhaSx(),
                                        lik.getTinhTrang(), lik.getBaoHanh(),
                                        lik.getLoaiLinhKien().getTenLoaiLK(),
                                        lik.getSoLuongTon(), lik.getDonGia()});
        
                                }
                                dsLK.removeAll(dsLK);
                                xoaRongTexf();
                                xoaModel();
                                upTableLk();
                                upJC();
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
                    LinhKien lk = restTexf();
                    if (lkDao.themLK(lk)) {
                        dfLK_Model.addRow(new Object[]{
                            lk.getMaLK(), lk.getTenLK(), lk.getNhaSx(), lk.getTinhTrang(), lk.getBaoHanh(),
                            lk.getLoaiLinhKien().getTenLoaiLK(), lk.getSoLuongTon(), lk.getDonGia()});
                        dsLK.removeAll(dsLK);
                        xoaRongTexf();
                        xoaModel();
                        upTableLk();
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
    public javax.swing.JComboBox<Object> jComboBox_llk;
    public javax.swing.JComboBox<Object> jComboBox_llk1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_LK;
    public javax.swing.JTextField jTextField_dongia;
    public javax.swing.JTextField jTextField_maLK;
    public javax.swing.JTextField jTextField_tenLK;
    public javax.swing.JTextField jTextField_tenLK1;
    public javax.swing.JComboBox<String> jcb_baohanh;
    private javax.swing.JPanel jp_LK;
    public javax.swing.JTextField jtex_soluong;
    // End of variables declaration//GEN-END:variables
}
