package pl.darekkarasiewicz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Blik {
    private Random random=new Random();
    private  int a=random.nextInt(8)+1;
    private  int b=random.nextInt(8)+1;
    private int c=random.nextInt(8)+1;
    private  int d=random.nextInt(8)+1;
    private int e=random.nextInt(8)+1;
    private int f=random.nextInt(8)+1;
    private JLabel blikCode= new JLabel();
    private JLabel label= new JLabel();
    private JFrame frame = new JFrame();
    private JButton button=new JButton("Back");
    private Account [] konta;
    public Blik(Account account , Account[] konta) {
        this.konta=konta;
        frame.getContentPane().setBackground(Color.orange);
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
                MainWindow mainWindow= new MainWindow(account,konta);
            }
        });
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\darek\\IdeaProjects\\Projekt\\grafika\\icon.png"));
            frame.setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
