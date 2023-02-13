/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DSNV_ArrayList {
    private ArrayList<NhanVien> dsnv;
    public DSNV_ArrayList() {
        dsnv = new ArrayList<NhanVien>();
    }
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong nhan vien:");
        int n = sc.nextInt();
        for(int i = 0; i < n ; i++)
        {
            NhanVien nv = new NhanVien();
            System.out.println("Nhap thong tin Nhan vien" + (i+1));
            nv.Nhap();
            dsnv.add(nv);           
        }
    }
    public void Xuat(){
        for (NhanVien nv : dsnv)
        {
            System.out.println(nv);
        }
    }
    public void Them(NhanVien nv){
       dsnv.add(nv);
   }
    public void Xoa(int index ){
        dsnv.remove(index);
    }
    public void XoaAll(){
        dsnv.clear();
    }
}
