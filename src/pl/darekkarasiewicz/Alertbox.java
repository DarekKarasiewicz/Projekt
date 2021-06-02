package pl.darekkarasiewicz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alertbox {
    Account account;
    JLabel label= new JLabel();
    JButton button = new JButton("OK");
    JFrame alertBox= new JFrame();
    JPasswordField pin = new JPasswordField();
    public Alertbox(Account account) {
        this.account=account;
        label.setText("Wprowadz ponownie pin: ");
        label.setBounds(70,20,200,25);
        pin.setBounds(50,50,200,25);
        button.setBounds(105,125,70,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(String.valueOf(pin.getPassword()))==(account.getPin())){
                    PayOutFrame payOutFrame =new PayOutFrame(account);
                    alertBox.dispose();
                }else{
                    alertBox.dispose();
                    MainWindow mainWindow = new MainWindow(account);
                };
            }
        }
        );


        alertBox.setLayout(null);
        alertBox.add(label);
        alertBox.add(button);
        alertBox.add(pin);
        alertBox.setSize(300,200);
        alertBox.setLocationRelativeTo(null);
        alertBox.setVisible(true);

    }
}
