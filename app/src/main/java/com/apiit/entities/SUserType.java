//package com.manuja.shoppingapp.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "user_type")
//public class SUserType {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//    @Column(name = "user_type")
//    private String userType;
//    @OneToOne (mappedBy = "userType")
//    private  User user;
//    public SUserType() {
//    }
//
//    @Override
//    public String toString() {
//        return "SUserType{" +
//                "id=" + id +
//                ", userType='" + userType + '\'' +
//                '}';
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getUserType() {
//        return userType;
//    }
//
//    public void setUserType(String userType) {
//        this.userType = userType;
//    }
//}
