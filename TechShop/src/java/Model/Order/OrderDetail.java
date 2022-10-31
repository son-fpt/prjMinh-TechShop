/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Order;

import Model.Product.Product;


public class OrderDetail {
    private int oid;
    private String pid;
    private int quantity;
    private double price;
    private Product p;

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public OrderDetail() {
    }

    public OrderDetail(int oid, String pid, int quantity, double price) {
        this.oid = oid;
        this.pid = pid;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "oid:"+oid+"\n"+
                "pid:"+pid+"\n"+
                "quantity:"+quantity+"\n"+
                "price:"+price+"\n"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
