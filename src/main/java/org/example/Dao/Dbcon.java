package org.example.Dao;

import org.example.Entity.Customer;

import java.sql.*;

public class Dbcon {
    private static String url = "jdbc:mysql://localhost:3306/customer";
    private static String user = "root";
    private static String password = "bishal123@";
    private static Connection connection = null;

    public static void connecToDB() {
        try {
            connection= DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public <customer> int insert( Customer customer ){
        String sql = "insert into customerdata values(?,?,?)";
        try {

            PreparedStatement prt =connection.prepareStatement(sql);
            prt.setInt(1,customer.getAc_no());
            prt.setString(2, customer.getName());
            prt.setString(3, customer.getBranch());
            return prt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void DisplayAll(){

        String sql = "select * from customerdata";
        try {
            Statement stm =connection.createStatement();
            ResultSet rs =stm.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getInt(1) + "|" + rs.getString(2) + "|"+rs.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean deleteByid(int ac_id){

        try {
            PreparedStatement prt =connection.prepareStatement("delete from customerdata where id=?");
            prt.setInt(1,ac_id);
            if(prt.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public int update( Customer customer){
        String sql= "update customerdata set name =?,branch=? where ac_no = ?";
        try {
            PreparedStatement prt =connection.prepareStatement(sql);
            prt.setString(1,customer.getName());
            prt.setString(2,customer.getBranch());
            prt.setInt(3,customer.getAc_no());
            return prt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void getByid(int ac_id) {
        connecToDb();
        try {
            PreparedStatement prt=connection.prepareStatement("select * from customerdata where ac_no =?");
            prt.setInt(1,ac_id);
            ResultSet rt=prt.executeQuery();
            if(rt.next()){
                System.out.println(rt.getInt(1) +" |"+ rt.getString(2)+"|"+rt.getString(3));
            }else{
                System.out.println("Data not Exist");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void connecToDb() {

    }
}