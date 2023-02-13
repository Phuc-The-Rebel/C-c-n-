/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnvcongty;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class NhanVienSX extends NhanVien{
    private int SoSP ;
  
    
    public NhanVienSX() {
        super();
        SoSP = 1;
    }

    public NhanVienSX(String MS, String HoTen, String NVL,int SP) {
        super(MS,HoTen,NVL);
        this.SoSP = SoSP;
    }

    /**
     * @return the SoSP
     */
    public int getSoSP() {
        return SoSP;
    }

    /**
     * @param SoSP the SoSP to set
     */
    public void setSoSP(int SoSP) {
        this.SoSP = SoSP;
    }
    
    public double tinhLuong(){
        return NhanVien.LCB + SoSP * 2000;
    }   
    @Override
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("Nhập MS:");
        this.MS = sc.nextLine();
        System.out.println("Nhập Họ tên:");
        this.HoTen = sc.nextLine();
        System.out.println("Nhập năm làm việc :");
        this.NVL = sc.nextLine();
        System.out.println("Nhập số sản phẩm :");
        this.SoSP = sc.nextInt();
       
    }
    @Override
    public String toString(){
        return this.MS + " - " + this.HoTen + " - " + this.NVL + " - " + this.SoSP + " - " + this.tinhLuong()+ "\n";

    }

    
}
