package org.example.Dao;

import org.example.Entity.LibraryUser;

import java.sql.*;;

public class Dblibrary {
    private static String url = "jdbc:mysql://localhost:3306/library";
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

    public int insert( LibraryUser library){
        String sql = "insert into libraryuser values(?,?,?)";
        try {

            PreparedStatement prt =connection.prepareStatement(sql);
            prt.setInt(1,library.getUser_id());
            prt.setString(2, library.getUser_name());
            prt.setString(3, library.getBook_name());
            return prt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void DisplayAll(){

        String sql = "select * from libraryuser";
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
    public boolean deleteByid(int user_id){

        try {
            PreparedStatement prt =connection.prepareStatement("delete from libraryuser where user_id=?");
            prt.setInt(1,user_id);
            if(prt.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public int update( LibraryUser library){
        String sql= "update libraryuser set name =?,book_name=? where id = ?";
        try {
            PreparedStatement prt =connection.prepareStatement(sql);
            prt.setString(1,library.getUser_name());
            prt.setString(2,library.getBook_name());
            prt.setInt(3,library.getUser_id());
            return prt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void getByid(int user_id) {
        connecToDb();
        try {
            PreparedStatement prt=connection.prepareStatement("select * from libraryuser where user_id =?");
            prt.setInt(1,user_id);
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