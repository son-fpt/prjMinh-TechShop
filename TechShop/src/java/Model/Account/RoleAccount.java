/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Account;

public class RoleAccount {
    private String email;
    private Role r = new Role();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getR() {
        return r;
    }

    public void setR(Role r) {
        this.r = r;
    }
    
}
