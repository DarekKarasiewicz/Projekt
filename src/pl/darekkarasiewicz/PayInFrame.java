package pl.darekkarasiewicz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PayInFrame {
    private Account account =new Account();
    private JFrame frame= new JFrame();
    private JLabel tekst=new JLabel();
    private JLabel saldo=new JLabel();
    private JLabel error=new JLabel();
    private JTextField textField= new JTextField();
    private JButton button=new JButton("Back");
    private JButton wplac=new JButton("wplac");

    public PayInFrame(Account account) {
        frame.getContentPane().setBackground(Color.cyan);
        this.account=account;
        frame.add(tekst);
        frame.add(textField);
        frame.add(button);
        frame.add(wplac);
        frame.add(error);
        frame.add(saldo);
        saldo.setBounds(50,200,400,100);
        error.setBounds(50,200,400,100);
        tekst.setBounds(100,50,100,100);
        textField.setBounds(200,50,100,50);
        wplac.setBounds(200,120,100,50);
        button.setBounds(150,300,100,40);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLocationRelativeTo(null);
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\darek\\IdeaProjects\\Projekt\\grafika\\icon.png"));
            frame.setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        wplac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                int suma=account.getBalance();
                if (Integer.parseInt(textField.getText())>0){
                    account.setBalance(suma+Integer.parseInt(textField.getText()));
                    error.setText(String.format("Saldo po wpłacie : %d",account.getBalance()));
                }
                else{
                    textField.setText(null);
                    JOptionPane.showMessageDialog(null,"Nie można wpłacić kwoty ponieżej 0","Error",JOptionPane.ERROR_MESSAGE);

                }}catch (NumberFormatException a){
                    textField.setText(null);
                    JOptionPane.showMessageDialog(null, "Kwota musi być liczbą", "error", JOptionPane.ERROR_MESSAGE);
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
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
