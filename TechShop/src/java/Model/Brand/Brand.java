/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Brand;

public class Brand {
    private String id;
    private String name;
    private String des;

    public Brand() {
    }

    public Brand(String id, String name, String des) {
        this.id = id;
        this.name = name;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Brand{" + "id=" + id + ", name=" + name + ", des=" + des + '}';
    }

    
    
    
}
