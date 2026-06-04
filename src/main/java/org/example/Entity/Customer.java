package org.example.Entity;

public class Customer {
    private int ac_no;
    private String name;
    private String branch;
    public Customer(){

    }

    public Customer(int ac_no, String name, String branch) {
        this.ac_no=ac_no;
        this.name=name;
        this.branch=branch;
    }

    public int getAc_no() {
        return ac_no;
    }

    public void setAc_no(int ac_no) {
        this.ac_no = ac_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

}