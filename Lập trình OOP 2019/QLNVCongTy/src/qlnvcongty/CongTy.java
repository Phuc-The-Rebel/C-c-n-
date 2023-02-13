/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnvcongty;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CongTy {
    private  ArrayList<NhanVienVP> dsnvvp ;
    private  ArrayList<NhanVienSX> dsnvsx ;
    private  ArrayList<NhanVienQL> dsnvql ;
    
    public CongTy(){
        dsnvvp = new ArrayList<NhanVienVP>();
        dsnvsx = new ArrayList<NhanVienSX>();
        dsnvql = new ArrayList<NhanVienQL>();
    }
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------");
        System.out.println("Nhap so luong nhan vien văn phòng:");
        int nvp = sc.nextInt();
        for(int i = 0; i < nvp ; i++)
        {
            NhanVienVP nvvp = new NhanVienVP();
            System.out.println("Nhap thong tin Nhan vien van phong" + (i+1));
            nvvp.nhap();
            dsnvvp.add(nvvp);           
        }
        System.out.println("----------------------");
        System.out.println("Nhap so luong nhan vien sản xuất:");
        int nsx = sc.nextInt();
        for(int i = 0; i < nsx ; i++)
        {
            NhanVienSX nvsx = new NhanVienSX();
            System.out.println("Nhap thong tin Nhan vien san xuat" + (i+1));
            nvsx.nhap();
            dsnvsx.add(nvsx);           
        }
        System.out.println("----------------------");
        System.out.println("Nhap so luong nhan vien Quản lý:");
        int nql = sc.nextInt();
        for(int i = 0; i < nql ; i++)
        {
            NhanVienQL nvql = new NhanVienQL();
            System.out.println("Nhap thong tin Nhan vien quan ly " + (i+1));
            nvql.nhap();
            dsnvql.add(nvql);           
        }
    }
    public void Xuat(){
        for (NhanVienVP nvp : dsnvvp)
        {
            System.out.println(dsnvvp);
            System.out.println("******************************");
        }
        for (NhanVienSX nsx : dsnvsx)
        {
            System.out.println(dsnvsx);
            System.out.println("******************************");
        }
        for (NhanVienQL nql : dsnvql)
        {
            System.out.println(dsnvql);
            System.out.println("******************************");
        }
    }
    public double tinhTong(){
        double TongVP = 0;
        double TongSX = 0;
        double TongQL = 0;
        double TongALL;
        for (int i = 0; i < dsnvvp.size() ; i ++)
        {
            TongVP = TongVP + dsnvvp.get(i).tinhLuong();
        }
        
        for (int i = 0; i < dsnvsx.size() ; i ++)
        {
            TongSX = TongSX + dsnvsx.get(i).tinhLuong();
        }
        for (int i = 0; i < dsnvql.size() ; i ++)
        {
            TongQL = TongQL + dsnvvp.get(i).tinhLuong();
        }
        return TongALL = TongVP + TongSX + TongQL;
    }
}
