package pl.darekkarasiewicz;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

public class MainWindow  {
    LocalDate localDate= LocalDate.now();

    JLabel data = new JLabel();
    Account account1;
    JFrame window2 =new JFrame("Welcome");
    JLabel account=new JLabel();
    JButton saldoButton =new JButton("Saldo");
    JButton payIn =new JButton("Wpłać");
    JButton payOut =new JButton("Wypłać");
    JButton blik= new JButton("Blik");
    JButton exit= new JButton("Wyjście");
    public MainWindow(Account account1) {
        int month=localDate.getMonthValue();
        int year=localDate.getYear();
        int day=localDate.getDayOfMonth();
        data.setText(String.format("%d-%d-%d",day,month,year));
        this.account1=account1;
        int nr=account1.getNumber();
        account.setText(String.format("Twoje konto to:%d",nr));
        data.setBounds(175,-40,100,100);
        account.setBounds(140,-20,100,100);
        saldoButton.setBounds(70,100,100,40);
        payIn.setBounds(70,200,100,40);
        payOut.setBounds(70,300,100,40);
        blik.setBounds(240,100,100,40);
        exit.setBounds(240,300,100,40);
        window2.add(account);
        window2.add(data);
        window2.add(blik);
        window2.add(payIn);
        window2.add(payOut);
        window2.add(saldoButton);
        window2.add(exit);

        blik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window2.dispose();
                Blik blik= new Blik(account1);
            }
        });

        payOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window2.dispose();
                Alertbox alertbox= new Alertbox(account1);
            }
        });
        payIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window2.dispose();
                PayInFrame payInFrame =new PayInFrame(account1);
            }
        });
        saldoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window2.dispose();
                SaldoFrame saldoFrame= new SaldoFrame(account1);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window2.dispose();
            }
        });

        window2.setSize(420,420);
        window2.setLayout(null);
        window2.setLocationRelativeTo(null);
        window2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window2.setVisible(true);
    }
}
