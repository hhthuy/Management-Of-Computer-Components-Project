/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.NhanVien_dao;
import dao.TaiKhoan_DAO;
import entity.NhanVien;
import entity.TaiKhoan;
import java.rmi.Naming;
import javax.swing.JOptionPane;

import static main.Login_form.tk;

/**
 *
 * @author HP
 */
public class FrmTTTK extends javax.swing.JPanel {

    NhanVien_dao nvDao;
    TaiKhoan_DAO tkDao;
    public FrmTTTK() {
        initComponents();
        try {
            String urlNv = "rmi://192.168.1.3:6881/nvDao";
            nvDao = (NhanVien_dao) Naming.lookup(urlNv);
            
            String urlTk = "rmi://192.168.1.3:6881/tkDao";
            tkDao = (TaiKhoan_DAO) Naming.lookup(urlTk);
        } catch (Exception e) {
        }
        upTTNv();
    }
    
    public void upTTNv(){
        try {
            NhanVien nv = nvDao.getNV(tk.getNhanVien().getMaNv());
            System.out.println("thong tin nv"+nv);
        jt_tt_ma.setText(nv.getMaNv());
        jt_tt_ten.setText(nv.getTenNv());
        jt_tt_cv.setText(nv.getChucVu());
        jt_tt_date.setText(nv.getNgaySinh().toString());
        jt_tt_luong.setText(nv.getLuong().toString());
        jc_tt_gt.addItem(nv.getGioTinh());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //kiem tra du lieu vao
    public boolean checkValu(){
       String mkCu = txtMKCu.getText();
       String mkMoi2 = txtMKMoi2.getText();
       String mkMoi = txtMKMoi.getText();
        if(!tk.getMatKhau().equals(mkCu)){
             JOptionPane.showMessageDialog(this, "Mật khẩu cũ không chính xác. Xin hãy nhập lại!!");
             return false;
        }
        else if(mkMoi.length()==0 || mkMoi2.length() == 0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mật khẩu mới!!");
           return false;
        }
      else if(!mkMoi.equals(mkMoi2)){
       
           JOptionPane.showMessageDialog(this, "Nhập lại mật khẩu mới không trùng nhau!!");
           return false;
       }
      else if ( !mkMoi.matches("^[a-z0-9_-]{6,18}$")) {
		JOptionPane.showMessageDialog(this, "Mật khẩu 6-18 ký tự và không chứa ký tự đặc biệt");
		return false;
         }
       
       return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_tt = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jt_tt_ma = new javax.swing.JTextField();
        jt_tt_ten = new javax.swing.JTextField();
        jt_tt_cv = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jt_tt_date = new javax.swing.JTextField();
        jt_tt_luong = new javax.swing.JTextField();
        jc_tt_gt = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jlb_hethong = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMKMoi2 = new javax.swing.JTextField();
        txtMKMoi = new javax.swing.JTextField();
        txtMKCu = new javax.swing.JTextField();
        btnXacNhan = new javax.swing.JButton();

        jp_tt.setBackground(new java.awt.Color(255, 255, 255));
        jp_tt.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(90, 103, 121), null), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(90, 103, 121));
        jLabel18.setText("THÔNG TIN TÀI KHOẢN");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Mã:");

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Tên:");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Chức Vụ:");

        jt_tt_ma.setBackground(new java.awt.Color(255, 255, 255));
        jt_tt_ma.setForeground(new java.awt.Color(0, 0, 0));

        jt_tt_ten.setBackground(new java.awt.Color(255, 255, 255));
        jt_tt_ten.setForeground(new java.awt.Color(0, 0, 0));

        jt_tt_cv.setBackground(new java.awt.Color(255, 255, 255));
        jt_tt_cv.setForeground(new java.awt.Color(0, 0, 0));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Ngày Sinh:");

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Giới Tính:");

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Lương:");

        jt_tt_date.setBackground(new java.awt.Color(255, 255, 255));
        jt_tt_date.setForeground(new java.awt.Color(0, 0, 0));

        jt_tt_luong.setBackground(new java.awt.Color(255, 255, 255));
        jt_tt_luong.setForeground(new java.awt.Color(0, 0, 0));

        jc_tt_gt.setBackground(new java.awt.Color(255, 255, 255));
        jc_tt_gt.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator1.setBackground(new java.awt.Color(90, 103, 121));
        jSeparator1.setForeground(new java.awt.Color(90, 103, 121));

        jlb_hethong.setBackground(new java.awt.Color(255, 255, 255));
        jlb_hethong.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlb_hethong.setForeground(new java.awt.Color(90, 103, 121));
        jlb_hethong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_hethong.setText("ĐỔI MẬT KHẨU");

        jLabel2.setText("Mật khẩu cũ:");

        jLabel3.setText("Mật khẩu mới:");

        jLabel4.setText("Nhập lại mật khẩu mới:");

        btnXacNhan.setBackground(new java.awt.Color(21, 151, 229));
        btnXacNhan.setForeground(java.awt.Color.white);
        btnXacNhan.setText("Xách nhân");
        btnXacNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_ttLayout = new javax.swing.GroupLayout(jp_tt);
        jp_tt.setLayout(jp_ttLayout);
        jp_ttLayout.setHorizontalGroup(
            jp_ttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_ttLayout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addGroup(jp_ttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(43, 43, 43)
                .addGroup(jp_ttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jt_tt_ma, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jt_tt_ten)
                    .addComponent(jt_tt_cv))
                .addGap(101, 101, 101)
                .addGroup(jp_ttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22))
                .addGap(41, 41, 41)
                .addGroup(jp_ttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jt_tt_date)
                    .addComponent(jt_tt_luong)
                    .addComponent(jc_tt_gt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(163, 163, 163))
            .addComponent(jlb_hethong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_ttLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jp_ttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_ttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_ttLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(593, 593, 593))
                        .addGroup(jp_ttLayout.createSequentialGroup()
                            .addGroup(jp_ttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMKCu, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                                .addComponent(txtMKMoi)
                                .addComponent(txtMKMoi2))
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_ttLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(425, 425, 425))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_ttLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_ttLayout.createSequentialGroup()
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(496, 496, 496))))
        );
        jp_ttLayout.setVerticalGroup(
            jp_ttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_ttLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addGroup(jp_ttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addGroup(jp_ttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jt_tt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22)
                        .addComponent(jt_tt_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(jp_ttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jt_tt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jc_tt_gt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jp_ttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jt_tt_cv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jt_tt_luong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlb_hethong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(txtMKCu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMKMoi2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jp_tt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jp_tt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 24, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        //doi mat khau

        String mkMoi = txtMKMoi.getText();
        if(checkValu()){
            try {
                tk.setMatKhau(mkMoi);
                tkDao.capNhatTrangThai(tk);
                JOptionPane.showMessageDialog(this, "Cập nhật mật khẩu thành công!!");
                txtMKCu.setText("");
                txtMKMoi.setText("");
                txtMKMoi2.setText("");
            } catch (Exception e) {
            }
            

        }
    }//GEN-LAST:event_btnXacNhanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jc_tt_gt;
    private javax.swing.JLabel jlb_hethong;
    private javax.swing.JPanel jp_tt;
    private javax.swing.JTextField jt_tt_cv;
    private javax.swing.JTextField jt_tt_date;
    private javax.swing.JTextField jt_tt_luong;
    private javax.swing.JTextField jt_tt_ma;
    private javax.swing.JTextField jt_tt_ten;
    private javax.swing.JTextField txtMKCu;
    private javax.swing.JTextField txtMKMoi;
    private javax.swing.JTextField txtMKMoi2;
    // End of variables declaration//GEN-END:variables
}
