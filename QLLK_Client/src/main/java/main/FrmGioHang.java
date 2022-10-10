/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.CTHoaDon_DAO;
import dao.HoaDonBanHang_DAO;
import dao.JasperReports_dao;
import dao.KhachHang_DAO;
import dao.LinhKien_DAO;
import dao.NhanVien_dao;
import dao.TaiKhoan_DAO;
import entity.CT_HoaDon;
import entity.HoaDonBanHang;
import entity.KhachHang;
import entity.LinhKien;
import entity.NhanVien;
import entity.TaiKhoan;
import java.rmi.Naming;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static main.FrmBanHang.dfBh_Model;
import static main.FrmBanHang.dfGh_Model;
import static main.FrmBanHang.dsLK;
import static main.FrmBanHang.dstt;
import static main.FrmHoaDon.jTable_HD1;

import static main.Login_form.tk;

/**
 *
 * @author HP
 */
public class FrmGioHang extends javax.swing.JPanel {

    KhachHang kh;
    KhachHang_DAO khDao;
    NhanVien_dao nvDao;
    LinhKien_DAO lkDao;

    HoaDonBanHang_DAO hdDao;
    CTHoaDon_DAO ctDao;
    JasperReports_dao jspDao;

    /**
     * Creates new form FrmGioHang
     */
    public FrmGioHang() {
        initComponents();
//        kh= new KhachHang();
        try {
            String urlLK = "rmi://192.168.1.3:6881/lkDao";
            lkDao = (LinhKien_DAO) Naming.lookup(urlLK);
            String urlKh = "//192.168.1.3:6881/khDao";
            khDao = (KhachHang_DAO) Naming.lookup(urlKh);
            String urlNv = "rmi://192.168.1.3:6881/nvDao";
            nvDao = (NhanVien_dao) Naming.lookup(urlNv);

            String urlHd = "rmi://192.168.1.3:6881/hdbhDao";
            hdDao = (HoaDonBanHang_DAO) Naming.lookup(urlHd);
            String urlCthd = "rmi://192.168.1.3:6881/ctDao";
            ctDao = (CTHoaDon_DAO) Naming.lookup(urlCthd);
            String urlCrpt = "rmi://192.168.1.3:6881/jspDao";
            jspDao = (JasperReports_dao) Naming.lookup(urlCrpt);

        } catch (Exception e) {
            e.printStackTrace();
        }
        upNV();
        noEdit();
    }

    /**
     * Hủy đơn hàng
     */
    public void huyDon(int r) {
        String maLK = dstt.get(r).getMaLK();
//        lay ma dslk
        int index = -1;
        for (LinhKien ds : dsLK) {
            if (ds.getMaLK() == maLK) {
                index = dsLK.indexOf(ds);
                break;
            }
        }
        int soLuong = Integer.parseInt(dfGh_Model.getValueAt(r, 4).toString());
        int soLuongTonTrenTable = Integer.parseInt(dfBh_Model.getValueAt(index, 6).toString());
        int soLuongTon = soLuongTonTrenTable + soLuong;
        System.out.println(soLuongTon);
        dstt.get(r).setSoLuongTon(soLuongTon);
        dfBh_Model.setValueAt(soLuongTon, index, 6);
        // TODO add your handling code here:
        // xóa trên table model
        dfGh_Model.removeRow(r);
        // xóa trên ArrayList
        dstt.remove(r);
    }

    /**
     * Lay du lieu nhan vien đang online
     */
    public void upNV() {
        try {

//            TaiKhoan tk = tkDao.getTrangThai();
            System.out.println("tk" + tk);
            NhanVien nv = nvDao.getNV(tk.getNhanVien().getMaNv());
            System.out.println("nv" + nv);
            jTextField_tnv.setText(nv.getTenNv());
            jTextField_mnv.setText(nv.getMaNv());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * không được chỉnh sua
     */
    public void noEdit() {
        jTextField_tnv.setEditable(false);
        jTextField_mnv.setEditable(false);
        jTextField_maKH.setEditable(false);
        jTextField_sdt.setEditable(false);
        jTextField_tenKH.setEditable(false);
        jTextField_diachi.setEditable(false);
    }

    /**
     * Thêm một hoa đơn mới
     */
    private HoaDonBanHang resTexfHD(KhachHang kh, NhanVien nv) {
        long millis = System.currentTimeMillis();
        Date ngaylap = new Date(millis);
        return new HoaDonBanHang(ngaylap, nv, kh);
    }

    /**
     * xóa model table giỏ hàng
     */
    public void xoaModelGh() {
        DefaultTableModel del = (DefaultTableModel) jTable_HD.getModel();
        del.getDataVector().removeAllElements();
        dfGh_Model.setRowCount(0);

    }

    /**
     * xóa model table hoas donw
     */
    public void xoaModelHD() {
        DefaultTableModel del = (DefaultTableModel) jTable_HD1.getModel();
        del.getDataVector().removeAllElements();
    }

    /**
     * Xóa rổng các textf
     */
    public void xoaRogTef() {

        jTextField_maKH.setText("");
        jTextField_sdt.setText("");
        jTextField_tenKH.setText("");
        jTextField_diachi.setText("");
        dfGh_Model.setRowCount(0);
    }

    /**
     * Kiểm tra dữ liệu trước khi thanh toán
     */
    public boolean ktdl() {
        if (jTable_HD.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(jTable_HD, "Không có sản phẩm để thanh toán");
            return false;
        }
        String maKh = jTextField_maKH.getText().trim();
        String tenKh = jTextField_tenKH.getText().trim();
        String sdt = jTextField_sdt.getText().trim();
        String diaChi = jTextField_diachi.getText().trim();
        if (maKh.length() == 0) {
            JOptionPane.showMessageDialog(jTable_HD, "Thêm khách hàng để thanh toán");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_HD = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField_tnv = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField_mnv = new javax.swing.JTextField();
        jTextField_sdt = new javax.swing.JTextField();
        jTextField_tenKH = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_HD = new javax.swing.JTable();
        btnTT = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jTextField_diachi = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField_maKH = new javax.swing.JTextField();
        jb_xoa = new javax.swing.JButton();
        jTextField_tnv1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jp_HD.setBackground(new java.awt.Color(255, 255, 255));
        jp_HD.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(90, 103, 121), null), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jp_HD.setPreferredSize(new java.awt.Dimension(1132, 640));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(90, 103, 121));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("GIỎ HÀNG");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Tên Nhân Viên:");

        jTextField_tnv.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_tnv.setForeground(new java.awt.Color(0, 0, 0));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Mã Nhân Viên:");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Số Điện Thoại:");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Tên Khách Hàng :");

        jTextField_mnv.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_mnv.setForeground(new java.awt.Color(0, 0, 0));

        jTextField_sdt.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_sdt.setForeground(new java.awt.Color(0, 0, 0));

        jTextField_tenKH.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_tenKH.setForeground(new java.awt.Color(0, 0, 0));

        jTable_HD.setBackground(new java.awt.Color(255, 255, 255));
        jTable_HD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable_HD.setForeground(new java.awt.Color(0, 0, 0));
        jTable_HD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Linh Kiện", "Loại Linh Kiện", "Nhà Sản Xuất", "Tình Trạng", "Số Lượng", "Đơn Giá", "Bảo Hành ", "Thành Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_HD.setRowHeight(30);
        jTable_HD.setShowGrid(true);
        jScrollPane2.setViewportView(jTable_HD);

        btnTT.setBackground(new java.awt.Color(40, 189, 139));
        btnTT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTT.setForeground(new java.awt.Color(255, 255, 255));
        btnTT.setIcon(new javax.swing.ImageIcon("D:\\DT_JavaPhanTan\\QLLK_Clinet\\icon\\cash-on-delivery.png")); // NOI18N
        btnTT.setText("Thanh Toán");
        btnTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTTActionPerformed(evt);
            }
        });

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Địa Chỉ:");

        jTextField_diachi.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_diachi.setForeground(new java.awt.Color(0, 0, 0));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Mã KH");

        jTextField_maKH.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_maKH.setForeground(new java.awt.Color(0, 0, 0));

        jb_xoa.setBackground(new java.awt.Color(255, 102, 102));
        jb_xoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jb_xoa.setForeground(new java.awt.Color(255, 255, 255));
        jb_xoa.setText("Xóa Sản Phẩm");
        jb_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_xoaActionPerformed(evt);
            }
        });

        jTextField_tnv1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_tnv1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_tnv1.setForeground(new java.awt.Color(90, 103, 121));
        jTextField_tnv1.setText("Tìm Kiếm Khách Hàng");
        jTextField_tnv1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(90, 103, 121)));
        jTextField_tnv1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_tnv1FocusGained(evt);
            }
        });
        jTextField_tnv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_tnv1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\DT_JavaPhanTan\\QLLK_Clinet\\icon\\search (4).png")); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(90, 103, 121)));

        javax.swing.GroupLayout jp_HDLayout = new javax.swing.GroupLayout(jp_HD);
        jp_HD.setLayout(jp_HDLayout);
        jp_HDLayout.setHorizontalGroup(
            jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_HDLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_HDLayout.createSequentialGroup()
                        .addComponent(jb_xoa)
                        .addGap(63, 63, 63)
                        .addComponent(btnTT)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_HDLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1087, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
            .addGroup(jp_HDLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_HDLayout.createSequentialGroup()
                        .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel27)
                                .addComponent(jLabel14)))
                        .addGap(60, 60, 60)
                        .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_mnv, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jTextField_tnv, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                    .addComponent(jTextField_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_HDLayout.createSequentialGroup()
                        .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_tenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(jTextField_diachi)))
                    .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_HDLayout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jp_HDLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(0, 0, 0)
                            .addComponent(jTextField_tnv1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_HDLayout.setVerticalGroup(
            jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_HDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_tnv1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_HDLayout.createSequentialGroup()
                        .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField_tnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextField_mnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)))
                    .addGroup(jp_HDLayout.createSequentialGroup()
                        .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextField_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jTextField_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jTextField_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jp_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1132, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jp_HD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jp_HD, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTTActionPerformed
        if (ktdl()) {
            if (dstt.size() > 0) {
                try {
                    NhanVien nv = nvDao.getNV(jTextField_mnv.getText());
                    KhachHang kh = khDao.getKH(jTextField_maKH.getText());
                    HoaDonBanHang hdMoiThem = null;
                    try {
                        HoaDonBanHang hd = resTexfHD(kh, nv);
                        hdDao.themHD(hd);
                        System.out.println("THEM HD");
                        hdMoiThem = hdDao.getHoaDonMoiNhat();
                        System.out.println("LAY HD MOI THEM");
                        //tao cthd
                        List<CT_HoaDon> listCTHD = new ArrayList<CT_HoaDon>();
                        for (int i = 0; i < dstt.size(); i++) {
                            int sl = dstt.get(i).getSoLuongTon();
                            double donGia = dstt.get(i).getDonGia();
                            //lay lk
                            LinhKien lks = lkDao.getLinhKien(dstt.get(i).getMaLK());

                            CT_HoaDon cthd = new CT_HoaDon(hdMoiThem, lks, donGia, sl);
                            listCTHD.add(cthd);

                            //cap nhat lai so luong
                            lks.setSoLuongTon(lks.getSoLuongTon() - sl);

                            lkDao.update(lks);

                        }

                        for (int i = 0; i < listCTHD.size(); i++) {
                            ctDao.themCthd(listCTHD.get(i));
                            System.out.println("THEM CTHD");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }

                    JOptionPane.showMessageDialog(null, "Đang Tạo Hóa Đơn.....!");
                    jspDao.printBill(hdMoiThem.getMaHD());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
        dstt.removeAll(dstt);
        xoaModelGh();
        xoaModelHD();
        xoaRogTef();

    }//GEN-LAST:event_btnTTActionPerformed

    private void jb_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_xoaActionPerformed
        int r = jTable_HD.getSelectedRow();
        huyDon(r);
    }//GEN-LAST:event_jb_xoaActionPerformed

    private void jTextField_tnv1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_tnv1FocusGained
        jTextField_tnv1.setText(" ");
    }//GEN-LAST:event_jTextField_tnv1FocusGained

    private void jTextField_tnv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_tnv1ActionPerformed
        try {

            String text = jTextField_tnv1.getText().trim();
            KhachHang kh = khDao.getKH(text);
            if (kh != null) {
                jTextField_tenKH.setText(kh.getTenKH());
                jTextField_sdt.setText(String.valueOf(kh.getSdt()));
                jTextField_diachi.setText(kh.getDiaChi());
                jTextField_maKH.setText(kh.getMaKH());
            } else {
                JOptionPane.showMessageDialog(null, "Không Tìm Thấy Khách Hàng có mã" + text + " !");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTextField_tnv1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable_HD;
    private javax.swing.JTextField jTextField_diachi;
    private javax.swing.JTextField jTextField_maKH;
    private javax.swing.JTextField jTextField_mnv;
    private javax.swing.JTextField jTextField_sdt;
    private javax.swing.JTextField jTextField_tenKH;
    private javax.swing.JTextField jTextField_tnv;
    private javax.swing.JTextField jTextField_tnv1;
    private javax.swing.JButton jb_xoa;
    private javax.swing.JPanel jp_HD;
    // End of variables declaration//GEN-END:variables
}
