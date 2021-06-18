package pl.darekkarasiewicz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SaldoFrame {
    private  Account account;
    private JFrame salodFrame= new JFrame();
    private JLabel tekst=new JLabel();
    private JLabel saldo=new JLabel();
    private JButton button=new JButton("Back");
    private Account [] konta;

    public SaldoFrame(Account account , Account[] konta) {
        this.konta=konta;
        salodFrame.getContentPane().setBackground(Color.cyan);
        this.account=account;
        saldo.setText(String.valueOf(account.getBalance()));
        saldo.setBounds(200,50,100,100);
        tekst.setText("Twoje stan konta to :");
        tekst.setBounds(60,50,150,100);
        salodFrame.add(tekst);
        salodFrame.add(saldo);
        salodFrame.add(button);
        button.setBounds(150,300,100,40);
        salodFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        salodFrame.setSize(420,420);
        salodFrame.setLayout(null);
        salodFrame.setLocationRelativeTo(null);
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\darek\\IdeaProjects\\Projekt\\grafika\\icon.png"));
            salodFrame.setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salodFrame.dispose();
                MainWindow mainWindow= new MainWindow(account,konta);
            }
        });
        salodFrame.setResizable(false);
        salodFrame.setVisible(true);
    }
}
