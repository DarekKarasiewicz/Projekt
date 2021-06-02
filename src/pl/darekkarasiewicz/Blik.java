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
    JFrame frame = new JFrame();
    JButton button=new JButton("Back");
    public Blik(Account account) {
        blikCode.setText(String.format("%d%d%d-%d%d%d",a,b,c,d,e,f));
        blikCode.setBounds(115,30,100,40);
        blikCode.getFont();
        button.setBounds(90,100,100,40);
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
