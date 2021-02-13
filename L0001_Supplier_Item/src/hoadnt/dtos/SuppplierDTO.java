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
public class SuppplierDTO {
    String code;
    String name;
    String address;
    boolean colloborate;

    public SuppplierDTO(String code, String name, String address, boolean colloborate) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.colloborate = colloborate;
    }
    public SuppplierDTO(){
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isColloborate() {
        return colloborate;
    }

    public void setColloborate(boolean colloborate) {
        this.colloborate = colloborate;
    }
    
}
