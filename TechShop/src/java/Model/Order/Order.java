/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Order;

import java.sql.Date;
import java.util.ArrayList;

public class Order {
    private int oid;
    private Date date;
    private String mail;
    private double totalmoney;
    private boolean status;
    private ArrayList<OrderDetail> od;

    public Order() {
    }

    public Order(int oid, Date date, String mail, double totalmoney, boolean status, ArrayList<OrderDetail> od) {
        this.oid = oid;
        this.date = date;
        this.mail = mail;
        this.totalmoney = totalmoney;
        this.status = status;
        this.od = od;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
            this.totalmoney += totalmoney;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public ArrayList<OrderDetail> getOd() {
        return od;
    }

    public void setOd(ArrayList<OrderDetail> od) {
        this.od = od;
    }

    @Override
    public String toString() {
        return "mail "+mail+"\n"+
                "date "+date+"\n"+
                "money "+totalmoney+"\n"+
                "oid "+oid+"\n"+
                status; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

}
