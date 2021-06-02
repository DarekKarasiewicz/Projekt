package pl.darekkarasiewicz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayInFrame {
    Account account =new Account();
    JFrame frame= new JFrame();
    JLabel tekst=new JLabel();
    JTextField textField= new JTextField();
    JButton button=new JButton("Back");
    JButton wplac=new JButton("wplac");

    public PayInFrame(Account account) {
        this.account=account;
        frame.add(tekst);
        frame.add(textField);
        frame.add(button);
        frame.add(wplac);
        tekst.setBounds(100,50,100,100);
        textField.setBounds(200,50,100,50);
        wplac.setBounds(200,120,100,50);
        button.setBounds(150,300,100,40);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLocationRelativeTo(null);
        wplac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int suma=account.getBalance();
                account.setBalance(suma+Integer.parseInt(textField.getText()));
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MainWindow mainWindow= new MainWindow(account);
            }
        });

        frame.setVisible(true);
    }
}
