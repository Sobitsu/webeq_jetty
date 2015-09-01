/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sobit.webeq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="users")

public class Users {
	 @Id
     @GeneratedValue
     @Column(name="id")
     int id;

     @Column(name="user")
     String user;

     @Column(name="password")
     String password;

     @Column(name="fio")
     String fio;

     @Column(name="podraz")
     Integer podraz;
     
     @Column(name="filial")
     Integer filial;
	
     @Column(name="role")
     Integer role;
	
  public int getid() {
         return id;
  }

  public void setid(int id) {
         this.id = id;
  }
        
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getPodraz() {
        return podraz;
    }

    public void setPodraz(Integer podraz) {
        this.podraz = podraz;
    }

    public Integer getFilial() {
        return filial;
    }

    public void setFilial(Integer filial) {
        this.filial = filial;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

       
}
