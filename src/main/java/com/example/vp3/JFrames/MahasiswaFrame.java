package com.example.vp3.JFrames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MahasiswaFrame {
    public MahasiswaFrame() {
        Connection conn = null;

        JFrame jFrame = new JFrame("Aplikasi Hello World");
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nama");

        tableModel.addRow(new Object[] { 1, "Bulbasaur" });
        tableModel.addRow(new Object[] { 2, "Squirtle" });
        tableModel.addRow(new Object[] { 3, "Charmander" });

        JTable table = new JTable(tableModel);
        JLabel pokemonLabel = new JLabel("");
        JScrollPane pane = new JScrollPane(table);

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                // int col = table.columnAtPoint(evt.getPoint());
                if (row >= 0) {
                    pokemonLabel.setText(table.getValueAt(row, 1).toString());
                }   
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(true);
        panel.add(pane);
        panel.add(pokemonLabel);

        jFrame.getContentPane().add(BorderLayout.CENTER, panel);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(3);
        jFrame.setVisible(true);
        jFrame.setBounds(3, 4, 300, 400);
    }
}
