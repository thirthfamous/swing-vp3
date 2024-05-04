package com.example.vp3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main {

    public Main() {
        Connection conn = null;

        JFrame jFrame = new JFrame("Aplikasi Hello World");
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nama");
        tableModel.addColumn("NIM");

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mahasiswaku?" +
                                               "user=root&password=farhan123");
            String query = "SELECT * FROM mahasiswa";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String nama = rs.getString(2);
                String nim = rs.getString(3);

                tableModel.addRow(new Object[]{id, nama, nim});
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
 
        JTable table = new JTable(tableModel);
        JScrollPane pane = new JScrollPane(table);

        jFrame.setContentPane(pane);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setVisible(true);
        jFrame.setBounds(3, 4, 300, 400);
    }

    public static void main(String[] args) {
        new Main();
    }

}