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
public class NhanVienVP extends NhanVien {
    private int SoNgCong ;
    private double TroCap ;
    
    public NhanVienVP() {
        super();
        SoNgCong = 1;
        TroCap = 1000000;
    }

    public NhanVienVP(String MS, String HoTen, String NVL,int SoNgCong ,double TroCap) {
        super(MS,HoTen,NVL);
        this.SoNgCong = SoNgCong;
        this.TroCap = TroCap;
    }

    /**
     * @return the SoNgCong
     */
    public int getSoNgCong() {
        return SoNgCong;
    }

    /**
     * @param SoNgCong the SoNgCong to set
     */
    public void setSoNgCong(int SoNgCong) {
        this.SoNgCong = SoNgCong;
    }

    /**
     * @return the TroCap
     */
    public double getTroCap() {
        return TroCap;
    }

    /**
     * @param TroCap the TroCap to set
     */
    public void setTroCap(double TroCap) {
        this.TroCap = TroCap;
    }
    public double tinhLuong(){
        return NhanVien.LCB + SoNgCong * 100000 + TroCap;
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
        System.out.println("Nhập số ngày công :");
        this.SoNgCong = sc.nextInt();
        System.out.println("Nhập trợ cấp:");
        this.TroCap = sc.nextDouble();
    }
    @Override
    public String toString(){
        return this.MS + " - " + this.HoTen + " - " + this.NVL + " - " + this.SoNgCong + " - " + this.TroCap + " - " + this.tinhLuong() + "\n";
    }
}
