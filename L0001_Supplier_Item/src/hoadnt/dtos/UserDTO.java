/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoadnt.dtos;

/**
 *
 * @author winnh
 */
public class UserDTO {
    String userID;
    String password;

    public UserDTO(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public UserDTO() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
