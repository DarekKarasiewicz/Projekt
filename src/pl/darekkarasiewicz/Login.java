package pl.darekkarasiewicz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login  {
    private int a=4;
    private Account[] konta;
    private JFrame window1 =new JFrame("Login");
    private JPasswordField password= new JPasswordField();
    JLabel labelPass = new JLabel();
    JLabel labelerror = new JLabel();
    JButton loginButton= new JButton("Login");
    public Login(Account[] konta) {
        this.konta=konta;
        password.setBounds(100,50,165,25);
        labelPass.setBounds(15,50,80,25);
        labelPass.setText("Pin");
        labelerror.setBounds(125,75,70,50);
        labelerror.setText(String.format("Error"));
        labelerror.getBorder();
        labelerror.setBackground(Color.red);
        labelerror.setVisible(false);
        loginButton.setBounds(105,125,70,30);
        window1.setLayout(null);
        window1.setSize(300,200);
        window1.setLocationRelativeTo(null);
        window1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window1.add(labelerror);
        window1.add(labelPass);
        window1.add(password);
        window1.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (a>=-1){
                for (Account account : konta) {
                    if (Integer.parseInt(String.valueOf(password.getPassword()))==account.getPin()) {
                            window1.dispose();
                            MainWindow mainWindow= new MainWindow(account);
                    }
                    else if (Integer.parseInt(String.valueOf(password.getPassword()))!=account.getPin()){
                            labelerror.setVisible(true);
                            a-=1;
                    }

                }


                }
            else {
                window1.dispose();
                }}
        });window1.setVisible(true);
    }


}
