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
public class ItemDTO {
    String code;
    String name;
    String supCode;
    float price;
    String unit;
    boolean supplying;

    public ItemDTO(String code, String name, String supCode, float price, String unit, boolean supplying) {
        this.code = code;
        this.name = name;
        this.supCode = supCode;
        this.price = price;
        this.unit = unit;
        this.supplying = supplying;
    }
    public ItemDTO(){
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

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean isSupplying() {
        return supplying;
    }

    public void setSupplying(boolean supplying) {
        this.supplying = supplying;
    }
    
}
