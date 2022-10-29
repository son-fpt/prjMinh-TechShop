/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Product;

import Model.Brand.Brand;
import Model.Category.Category;
import Model.Technology.Technology;

public class Product {
    private String id;
    private String name;
    private String image;
    private Brand brand;
    private Technology tech;
    private Category cate;
    private int size;
    private double price;
    private String des;

    public Product() {
        
    }

    public Product(String id, String name, String image, Brand brand, Technology tech, Category cate, int size, double price, String des) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.brand = brand;
        this.tech = tech;
        this.cate = cate;
        this.size = size;
        this.price = price;
        this.des = des;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Technology getTech() {
        return tech;
    }

    public void setTech(Technology tech) {
        this.tech = tech;
    }

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    

    
}
