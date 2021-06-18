package pl.darekkarasiewicz;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class MainWindow  {
    private  LocalDate localDate= LocalDate.now();

    private  JLabel data = new JLabel();
    private Account account1;
    private Account [] konta;
    private JFrame window2 =new JFrame("Welcome");
    private JLabel account=new JLabel();
    private JButton saldoButton =new JButton("Saldo");
    private JButton payIn =new JButton("Wpłać");
    private JButton payOut =new JButton("Wypłać");
    private JButton blik= new JButton("Blik");
    private JButton paySomone= new JButton("Przelew");
    private JButton exit= new JButton("Wyjście");
    public MainWindow(Account account1 , Account[] konta) {
        this.konta=konta;
        try {
            window2.getContentPane().setBackground(Color.cyan);
            AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(new File("C:\\Users\\darek\\IdeaProjects\\Projekt\\elevatorMusic.wav").getAbsoluteFile());
            Clip clip =AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

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
        paySomone.setBounds(240,200,100,40);
        window2.add(account);
        window2.add(data);
        window2.add(blik);
        window2.add(payIn);
        window2.add(payOut);
        window2.add(saldoButton);
        window2.add(exit);
        window2.add(paySomone);
            try {
                BufferedImage image = ImageIO.read(new File("C:\\Users\\darek\\IdeaProjects\\Projekt\\grafika\\icon.png"));
                window2.setIconImage(image);
            } catch (IOException e) {
                e.printStackTrace();
            }


        blik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window2.dispose();
                Blik blik= new Blik(account1,konta);
                clip.stop();

            }
        });
            paySomone.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    window2.dispose();
                    PaySomeone paySomeone= new PaySomeone(account1,konta);
                    clip.stop();

                }
            });
        payOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window2.dispose();
                Alertbox alertbox= new Alertbox(account1,konta);
                clip.stop();
            }
        });
        payIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window2.dispose();
                PayInFrame payInFrame =new PayInFrame(account1,konta);
                clip.stop();
            }
        });
        saldoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window2.dispose();
                SaldoFrame saldoFrame= new SaldoFrame(account1,konta);
                clip.stop();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window2.dispose();
                clip.stop();
            }
        });

        window2.setSize(420,420);
        window2.setLayout(null);
        window2.setLocationRelativeTo(null);
        window2.setResizable(false);
        window2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window2.setVisible(true);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
