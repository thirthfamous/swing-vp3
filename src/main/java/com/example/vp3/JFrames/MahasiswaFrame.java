package com.example.vp3.JFrames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MahasiswaFrame {
    public MahasiswaFrame() throws IOException {
        Connection conn = null;

        JFrame jFrame = new JFrame("Aplikasi Hello World");
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nama");

        tableModel.addRow(new Object[] { 1, "bulbasaur" });
        tableModel.addRow(new Object[] { 2, "squirtle" });
        tableModel.addRow(new Object[] { 3, "charmander" });

        JTable table = new JTable(tableModel);
        JLabel pokemonLabel = new JLabel("");

        String path = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/1.png";
        System.out.println("Get Image from " + path);
        URL url = new URL(path);
        BufferedImage image = ImageIO.read(url);        
        JLabel pokemonImagelaLabel = new JLabel(new ImageIcon(image));

        JScrollPane pane = new JScrollPane(table);

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                // int col = table.columnAtPoint(evt.getPoint());
                if (row >= 0) {
                    String pokemonName = table.getValueAt(row, 1).toString();
                    pokemonLabel.setText(pokemonName);            
                }   
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(true);
        panel.add(pane);
        panel.add(pokemonLabel);
        panel.add(pokemonImagelaLabel);

        jFrame.getContentPane().add(BorderLayout.CENTER, panel);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(3);
        jFrame.setVisible(true);
        jFrame.setBounds(3, 4, 300, 400);
    }
}
