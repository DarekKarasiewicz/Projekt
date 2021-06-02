package pl.darekkarasiewicz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Blik {
    Random random=new Random();
    int a=random.nextInt(8)+1;
    int b=random.nextInt(8)+1;
    int c=random.nextInt(8)+1;
    int d=random.nextInt(8)+1;
    int e=random.nextInt(8)+1;
    int f=random.nextInt(8)+1;
    JLabel blikCode= new JLabel();
    JLabel label= new JLabel();
    JFrame frame = new JFrame();
    JButton button=new JButton("Back");
    public Blik(Account account) {
        label.setText("Twój kod blick to : ");
        label.setBounds(90,10,150,40);
        blikCode.setText(String.format("%d%d%d-%d%d%d",a,b,c,d,e,f));
        blikCode.setBounds(115,40,100,40);
        blikCode.getFont();
        button.setBounds(90,100,100,40);
        frame.add(label);
        frame.add(button);
        frame.add(blikCode);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(300,200);
        frame.setLocationRelativeTo(null);
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
