/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoadnt.daos;

import hoadnt.dtos.ItemDTO;
import hoadnt.dtos.SuppplierDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author winnh
 */
public class SupplierDao {
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://SE141107\\SQLEXPRESS:1433; databaseName=ItemManagement;user=sa; password=123";

    public static Connection openConnection() throws Exception {
        Class.forName(driver);
        return (Connection) DriverManager.getConnection(url);
    }
    public static List<SuppplierDTO> getAllSupplier() throws Exception {
        List<SuppplierDTO> list = new ArrayList();
        try ( Connection c = openConnection();  Statement sm = c.createStatement();) {
            ResultSet rs = sm.executeQuery("Select supCode, supName, address, collaborating from tblSuppliers ");
            while(rs.next()){
                String code=rs.getString("supCode");
                String name= rs.getString("supName");
                String adress=rs.getString("address");
                boolean col= rs.getBoolean("collaborating");
                SuppplierDTO sup= new SuppplierDTO(code, name, adress, col);
                list.add(sup);
            }
            return list;

        }
    }
    public static String getSupCodeByName(String name)throws Exception{
        String code="";
        try(Connection c= openConnection();PreparedStatement ps= c.prepareStatement("Select supCode From tblSuppliers where supName=?");){
            ps.setString(1, name);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                code = rs.getString("supCode");
            }
        } 
        return code;
    }
    public static String getSupByCode(String code) throws Exception{
        String sql="Select supName from tblSuppliers where supCode=?";
        String supName="";
        try(Connection c= openConnection(); PreparedStatement sm= c.prepareStatement(sql);){
            sm.setString(1, code);
            ResultSet rs= sm.executeQuery();
            if(rs.next()){
                supName=rs.getString("supName");
            }
            return supName;
        }
    }
    public static int insert(SuppplierDTO s) throws Exception{
        String sql="Insert tblSuppliers Values(?,?,?,?)";
        try(Connection c= openConnection(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1, s.getCode());
            ps.setString(2, s.getName());
            ps.setString(3, s.getAddress());
            ps.setString(4, String.valueOf(s.isColloborate()));
            return ps.executeUpdate();
        }
                
    }
    public static int update(SuppplierDTO s) throws Exception{
        String sql="Update tblSuppliers set SupName=?, address=?, collaborating=? where SupCode=?";
        try(Connection c= openConnection(); PreparedStatement ps= c.prepareStatement(sql)){
            ps.setString(1, s.getName());
            ps.setString(2, s.getAddress());
            ps.setString(3, String.valueOf(s.isColloborate()));
            ps.setString(4, s.getCode());
            return ps.executeUpdate();
        }
    }
    public static int delete(String code) throws Exception{
        String sql="Delete From tblSuppliers where SupCode=?";
        try(Connection c=openConnection(); PreparedStatement ps= c.prepareStatement(sql)){
            ps.setString(1, code);
            return ps.executeUpdate();
        }
    }
    public static boolean checkSupplying (String code) throws Exception{
        List<ItemDTO> itemList= new ArrayList<>();
        itemList = ItemDao.getAllItem();
        int count=0;
        for(ItemDTO i: itemList){
            if(i.getSupCode().equals(code)){
                count++;
            }
        }
        if(count==0) return false;
        else return true;
    }
    public static void checkCollaborating()throws Exception{
        List<ItemDTO> itemList= new ArrayList<>();
        itemList= ItemDao.getAllItem();
        List<SuppplierDTO> suppList= new ArrayList<>();
        suppList= getAllSupplier();
        String sql="Update tblSuppliers set collaborating=? where supCode=?";
        try{
            for(SuppplierDTO sup: suppList){
                int count=0;
                boolean clb;
                for(ItemDTO i: itemList){
                    if(i.getSupCode().equals(sup.getCode()) && i.isSupplying()==true){
                        count++;
                    }
                }
                if(count>0){
                    clb=true;
                    sup.setColloborate(clb);
                }
                else {
                    clb=false;
                    sup.setColloborate(clb);
                }
                try(Connection c= openConnection(); PreparedStatement ps= c.prepareStatement(sql)){
                    ps.setString(1, String.valueOf(clb));
                    ps.setString(2, sup.getCode());
                    ps.executeUpdate();
                }
            }
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
        
}
