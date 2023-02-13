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
public class NhanVien {
    protected String MS, HoTen;
    protected String NVL;
     static int LCB = 1390000;

    public NhanVien() {
        MS = " ";
        HoTen = " ";
        NVL = " ";
    }

    public NhanVien(String MS, String HoTen, String NVL) {
        this.MS = MS;
        this.HoTen = HoTen;
        this.NVL = NVL;
    }

    private double tinhLuong(){
        return NhanVien.getLCB() ;
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
/**
     * @return the NVL
     */
    public String getNVL() {
        return NVL;
    }

    /**
     * @param NVL the NVL to set
     */
    public void setNVL(String NVL) {
        this.NVL = NVL;
    }

    /**
     * @return the LCB
     */
    public static int getLCB() {
        return LCB;
    }

    /**
     * @param aLCB the LCB to set
     */
    public static void setLCB(int aLCB) {
        LCB = aLCB;
    }
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("Nhập MS:");
        this.MS = sc.nextLine();
        System.out.println("Nhập Họ tên:");
        this.HoTen = sc.nextLine();
        System.out.println("Nhập năm làm việc :");
        this.NVL = sc.nextLine();
    }
    
    public String toString(){
        return this.MS + " - " + this.HoTen + " - " + this.NVL + " - " + this.tinhLuong()+ "\n";
    }

    
}
