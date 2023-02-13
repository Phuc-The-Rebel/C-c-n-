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
public class NhanVienQL extends NhanVien{
    private double HSChucVu ;
    private double Thuong ;
    
    public NhanVienQL() {
        super();
        HSChucVu = 1;
        Thuong = 1;
    }

    public NhanVienQL(String MS, String HoTen, String NVL,double HSChucVu  ,double Thuong) {
        super(MS,HoTen,NVL);
        this.HSChucVu  = HSChucVu ;
        this.Thuong = Thuong;
    }

    /**
     * @return the HSChucVu
     */
    public double getHSChucVu() {
        return HSChucVu;
    }

    /**
     * @param HSChucVu the HSChucVu to set
     */
    public void setHSChucVu(double HSChucVu) {
        this.HSChucVu = HSChucVu;
    }

    /**
     * @return the Thuong
     */
    public double getThuong() {
        return Thuong;
    }

    /**
     * @param Thuong the Thuong to set
     */
    public void setThuong(double Thuong) {
        this.Thuong = Thuong;
    }
    
    public double tinhLuong(){
        return NhanVien.LCB * HSChucVu + Thuong;
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
        System.out.println("Nhập hệ số chức vụ :");
        this.HSChucVu = sc.nextDouble();
        System.out.println("Nhập thưởng:");
        this.Thuong = sc.nextDouble();
    }
    @Override
    public String toString(){
        return this.MS + " - " + this.HoTen + " - " + this.NVL + " - " + this.HSChucVu + " - " + this.Thuong  + " - " + this.tinhLuong()+ "\n";
    }
}
