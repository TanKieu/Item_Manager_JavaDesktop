/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoadnt.daos;

import hoadnt.dtos.ItemDTO;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author winnh
 */
public class ItemDao {
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url="jdbc:sqlserver://SE141107\\SQLEXPRESS:1433; databaseName= ItemManagement;user=sa; password=123";
    
    public static Connection openConnection()throws Exception{
        Class.forName(driver);
        return (Connection) DriverManager.getConnection(url);
    }
    public static List<ItemDTO> getAllItem()throws Exception{
        List<ItemDTO> list= new ArrayList<>();
        try(Connection c = openConnection(); Statement sm = c.createStatement();){
            ResultSet rs=sm.executeQuery("Select itemCode, itemName, unit, price, supplying, supCode From tblItems");
            while(rs.next()){
                String code= rs.getString("itemCode");
                String name= rs.getString("itemName");
                String unit= rs.getString("unit");
                String supCode=rs.getString("supCode");
                float price= rs.getFloat("price");
                boolean supply=rs.getBoolean("supplying");
                ItemDTO i= new ItemDTO(code, name, supCode, price, unit, supply);
                list.add(i);
            }
        }
        return list;
    }
    public static int insert(ItemDTO i) throws Exception{
        String sql =" Insert tblItems Values(?,?,?,?,?,?)";
        try(Connection c=openConnection(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1, i.getCode());
            ps.setString(2, i.getName());
            ps.setString(3, i.getUnit());
            ps.setString(4, String.valueOf(i.getPrice()));
            ps.setString(5,String.valueOf(i.isSupplying()));
            ps.setString(6, i.getSupCode());
            return ps.executeUpdate();
        }
    }
    public static int update(ItemDTO i)throws Exception{
        String sql="Update tblItems set itemName=?, unit=?, price=?, supplying=?, supCode=? where itemCode=?";
        try(Connection c=openConnection();PreparedStatement ps= c.prepareStatement(sql)){
            ps.setString(1, i.getName());
            ps.setString(2, i.getUnit());
            ps.setFloat(3, i.getPrice());
            ps.setBoolean(4, i.isSupplying());
            ps.setString(5, i.getSupCode());
            ps.setString(6, i.getCode());
            return ps.executeUpdate();
        }
    }
    public static int delete(String code) throws Exception{
        String sql="Delete From tblItems Where itemCode=?";
        try(Connection c= openConnection(); PreparedStatement ps= c.prepareStatement(sql)){
            ps.setString(1, code);
            return ps.executeUpdate();
        }
    }
    public static String getItemByCode(String code) throws Exception{
        String sql="Select itemName from tblItems where itemCode=?";
        String itemName="";
        try(Connection c= openConnection(); PreparedStatement sm= c.prepareStatement(sql);){
            sm.setString(1, code);
            ResultSet re= sm.executeQuery();
            while(re.next()){
                itemName=re.getString("itemName");
            }
        }
        return itemName;
    }
    public static boolean checkKey(String supCode) throws Exception{
        List<String> supCodeList= new ArrayList<>();
        try(Connection c= openConnection(); PreparedStatement sm=c.prepareStatement("Select [supCode] from tblSuppliers");){
            ResultSet rs= sm.executeQuery();
            while(rs.next()){
                String supplierCode=rs.getString("supCode");
                supCodeList.add(supplierCode);
            }
        }
        for(String code : supCodeList){
            if(supCode.equals(code)) return true;
        }
        return false;
    }
}
