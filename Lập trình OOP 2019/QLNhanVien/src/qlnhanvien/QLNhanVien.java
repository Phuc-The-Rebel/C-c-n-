/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien;

/**
 *
 * @author Admin
 */
public class QLNhanVien {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DSNV_ArrayList alist = new DSNV_ArrayList();
        NhanVien anv = new NhanVien("nv100","Adolf Hitler",27);
        alist.Nhap();
        System.out.println("Xuat");
        alist.Xuat();
        System.out.println("Them 1:");
        alist.Them(anv);
        alist.Xuat();
        System.out.println("Xoa 1:");
        alist.Xoa(1);
        alist.Xuat();
    }
    
}
