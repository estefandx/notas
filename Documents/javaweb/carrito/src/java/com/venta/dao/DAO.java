/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    
    private Connection cn;
    
    public Connection getCn() {
        return cn;
    }
    
    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public void conectar() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
           // cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/compras?zeroDateTimeBehavior=convertToNull");
           cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/compras?user=root&password=");
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
    
    public void cerrar() throws Exception {
        
        try {
            if (cn != null) {
                if (cn.isClosed() == false) {
                    cn.close();
                }
            }
            
        } catch (SQLException e) {
            throw e;
        }
        
    }
    
}
