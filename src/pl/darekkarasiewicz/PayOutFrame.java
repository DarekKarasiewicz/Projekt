package pl.darekkarasiewicz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayOutFrame {
    Account account;
    JFrame frame= new JFrame();
    JLabel tekst=new JLabel();
    JLabel error=new JLabel();
    JTextField textField= new JTextField();
    JButton button=new JButton("Back");
    JButton wyplac=new JButton("Wypłać");
    public PayOutFrame(Account account) {
        frame.add(tekst);
        frame.add(textField);
        frame.add(button);
        frame.add(wyplac);
        frame.add(error);
        error.setBounds(50,200,400,100);
        tekst.setBounds(100,50,100,100);
        textField.setBounds(200,50,100,50);
        button.setBounds(150,300,100,40);
        wyplac.setBounds(200,120,100,50);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLocationRelativeTo(null);
        wyplac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(textField.getText())<0){
                    error.setText("nie można wypłacić kwoty poniżej 0 ");
                    error.setVisible(true);
                }
                else if (account.getBalance()>Integer.parseInt(textField.getText())){
                    int suma =account.getBalance();
                    account.setBalance(suma-Integer.parseInt(textField.getText()));
                }
                else {
                    error.setText(String.format("nie można wypłacić takiej kwoty maksymalna kwota to : %d",account.getBalance()));
                    error.setVisible(true);
                }
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
