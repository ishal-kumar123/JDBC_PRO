package org.example.Entity;

public class LibraryUser {
    private int user_id;
    private String user_name;
    private String book_name;
    public LibraryUser(){

    }

    public LibraryUser(int user_id,String user_name,String book_name){
        this.user_id=user_id;
        this.user_name=user_name;
        this.book_name=book_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
}