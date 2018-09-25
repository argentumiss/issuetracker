/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.axmor.user;

/**
 *
 * @author Alice
 */
public class User {
    String username;
    String salt;
    String hashedPassword;
    
    public User (String uname, String s, String hpwd) {
        username = uname;
        salt = s;
        hashedPassword = hpwd;
    }

    public String getUsername() {
        return username;
    }
    
    public String getSalt() {
        return salt;
    }
    
    public String getHashedPassword() {
        return hashedPassword;
    }
}
