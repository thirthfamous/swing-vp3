package com.example.vp3.JFrames;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateMahasiswaFrame {
    public CreateMahasiswaFrame() {
        JFrame newFrame = new JFrame("Create Mahasiswa");
        JLabel label = new JLabel("Hello new frame");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(true);
        panel.add(label);

        newFrame.getContentPane().add(BorderLayout.CENTER, panel);
        newFrame.pack();
        newFrame.setVisible(true);
        newFrame.setBounds(3, 4, 300, 400);
    }
}
