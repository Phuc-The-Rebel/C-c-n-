/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class NhanVien {

    private String MS, HoTen;
    private int SNC;
    private char XL;
    private static long LgNgay = 200000;

    public NhanVien() {
        MS = " ";
        HoTen = " ";
        SNC = 0;
        XL = 'C';
    }

    public NhanVien(String MS, String HoTen, int SNC) {
        this.MS = MS;
        this.HoTen = HoTen;
        this.SNC = SNC;
        this.XL = this.tinhXL();
    }

    private char tinhXL() {
        if (this.getSNC() > 26) {
            return 'A';
        } else if (this.getSNC() >= 22 && this.getSNC() <= 26) {
            return 'B';
        } else {
            return 'C';
        }
    }

    /**
     * @return the MS
     */
    public String getMS() {
        return MS;
    }

    /**
     * @param MS the MS to set
     */
    public void setMS(String MS) {
        this.MS = MS;
    }

    /**
     * @return the HoTen
     */
    public String getHoTen() {
        return HoTen;
    }

    /**
     * @param HoTen the HoTen to set
     */
    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    /**
     * @return the SNC
     */
    public int getSNC() {
        return SNC;
    }

    /**
     * @param SNC the SNC to set
     */
    public void setSNC(int SNC) {
        this.SNC = SNC;
    }

    /**
     * @return the XL
     */
    public char getXL() {
        return this.XL;
    }

    /**
     * @param XL the XL to set
     */
    public void setXL(char XL) {
        this.XL = XL;
    }

    /**
     * @return the LgNgay
     */
    public long getLgNgay() {
        return LgNgay;
    }

    /**
     * @param aLgNgay the LgNgay to set
     */
    public static void setLgNgay(long aLgNgay) {
        LgNgay = aLgNgay;
    }
    @Override 
    public String toString(){
        return this.MS + " - " + this.HoTen + " - " + this.SNC + " - " + this.tinhXL();
    }
    public long tinhLg(){
        return NhanVien.LgNgay * this.SNC;
    }
    public double tinhThuong(){
        switch (this.XL) {
            case 'A':
                return this.tinhLg() * 0.05 ;
            case 'B':
                return this.tinhLg() * 0.02;
            default:
                return 0;
        }
    }
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập MS:");
        this.MS = sc.nextLine();
        System.out.println("Nhập Họ tên:");
        this.HoTen = sc.nextLine();
        System.out.println("Nhập số ngày công :");
        this.SNC = sc.nextInt();
    }
    
}

