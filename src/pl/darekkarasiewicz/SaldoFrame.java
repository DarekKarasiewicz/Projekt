package pl.darekkarasiewicz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaldoFrame {
    private  Account account;
    private JFrame salodFrame= new JFrame();
    private JLabel tekst=new JLabel();
    private JLabel saldo=new JLabel();
    private JButton button=new JButton("Back");

    public SaldoFrame(Account account) {
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
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salodFrame.dispose();
                MainWindow mainWindow= new MainWindow(account);
            }
        });salodFrame.setVisible(true);
    }
}
