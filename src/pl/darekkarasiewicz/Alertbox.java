package pl.darekkarasiewicz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alertbox {
    private int a=2;
    private  Account account;
    private  JLabel label= new JLabel();
    private JButton button = new JButton("OK");
    private JFrame alertBox= new JFrame();
    private JLabel labelerror = new JLabel();

    JPasswordField pin = new JPasswordField();
    public Alertbox(Account account) {
        this.account=account;
        labelerror.setText(String.format("Error"));
        label.setText("Wprowadz ponownie pin: ");
        label.setBounds(70,20,200,25);
        labelerror.setBounds(125,75,70,50);
        labelerror.setVisible(false);
        pin.setBounds(50,50,200,25);
        button.setBounds(105,125,70,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                if(a>0){
                if (Integer.parseInt(String.valueOf(pin.getPassword()))==(account.getPin())){
                    PayOutFrame payOutFrame =new PayOutFrame(account);
                    alertBox.dispose();
                }
                else {
                    labelerror.setVisible(true);
                    a-=1;
                }}
                else{
                    alertBox.dispose();
                    MainWindow mainWindow = new MainWindow(account);
                };}catch (NumberFormatException a){
                    JOptionPane.showMessageDialog(null,"Nr lub pin muszą być liczbą","error",JOptionPane.ERROR_MESSAGE);}
        }
        }
        );

        alertBox.add(labelerror);
        alertBox.setLayout(null);
        alertBox.add(label);
        alertBox.add(button);
        alertBox.add(pin);
        alertBox.setResizable(false);
        alertBox.setSize(300,200);
        alertBox.setLocationRelativeTo(null);
        alertBox.setVisible(true);

    }
}
