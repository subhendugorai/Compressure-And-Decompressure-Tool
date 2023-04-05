package GUI;

import comp_decomp.compressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    AppFrame() {
        //compress Button.
        compressButton = new JButton("select file to compress");
        compressButton.setBounds(90,120,180,30);
        compressButton.addActionListener(this);

        //decompress button.
        decompressButton = new JButton("select file to decompress");
        decompressButton.setBounds(290,120,180,30);
        decompressButton.addActionListener(this);

//        JPanel panal = new JPanel();
//        panal.add(compressButton);
//       panal.add(decompressButton);
        this.add(compressButton);
        this.add(decompressButton);
        this.setTitle("Welcome to Compressor & Decompressor Tool");
        this.setSize(600, 400);
        this.getContentPane().setBackground(Color.green);
    //    this.setLocation(200,200);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton) {
            JFileChooser fileChooser=new JFileChooser();
            int response= fileChooser.showSaveDialog(null);
            if(response == fileChooser.APPROVE_OPTION) {
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try {
                    compressor.compressIt(file);
                } catch (Exception se) {
                    JOptionPane.showMessageDialog(null,se.toString());
                }
            }

        }

        if(e.getSource()==decompressButton) {
            JFileChooser fileChooser=new JFileChooser();
            int response= fileChooser.showSaveDialog(null);
            if(response == fileChooser.APPROVE_OPTION) {
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try {
                    compressor.compressIt(file);
                } catch (Exception se) {
                    JOptionPane.showMessageDialog(null,se.toString());
                }
            }
        }
    }
}