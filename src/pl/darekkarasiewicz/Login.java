package pl.darekkarasiewicz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class Login {
    private int a = 4;
    private Account[] konta;
    private JFrame window1 = new JFrame("Login");
    private JTextField nr = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JLabel labelPass = new JLabel();
    private JLabel labelnr = new JLabel();
    private JLabel labelerror = new JLabel();
    private JButton loginButton = new JButton("Login");

    public Login(Account[] konta) {
        this.konta = konta;
        labelnr.setBounds(15, 30, 80, 25);
        nr.setBounds(100, 30, 165, 25);
        password.setBounds(100, 60, 165, 25);
        labelPass.setBounds(15, 60, 80, 25);
        labelPass.setText("Pin");
        labelnr.setText("Nr.");
        labelerror.setBounds(125, 75, 70, 50);
        labelerror.setText(String.format("Error"));
        labelerror.getBorder();
        labelerror.setBackground(Color.red);
        labelerror.setVisible(false);
        loginButton.setBounds(105, 125, 70, 30);
        window1.setLayout(null);
        window1.setSize(300, 200);
        window1.setLocationRelativeTo(null);
        window1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window1.add(labelerror);
        window1.add(labelnr);
        window1.add(nr);
        window1.add(labelPass);
        window1.add(password);
        window1.add(loginButton);
        window1.setResizable(false);

        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\darek\\IdeaProjects\\Projekt\\grafika\\icon.png"));
            window1.setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    HashSet<String> bans = new HashSet<>();
                    File file = new File("C:\\Users\\darek\\IdeaProjects\\Projekt\\Ban.txt");
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        bans.add(scanner.nextLine());
                    }
                    for (String ban : bans) {
                        if (Integer.parseInt(ban) == Integer.parseInt(nr.getText())){
                        JOptionPane.showMessageDialog(null,"Zbanowany","error",JOptionPane.ERROR_MESSAGE);
                        window1.dispose();
                        a=2;
                        }

                    }

                    if (a >= 3) {
                            for (Account account : konta) {
                                if (account.getNumber() == Integer.parseInt(nr.getText())) {
                                    Account account1 = account;
                                    if (Integer.parseInt(String.valueOf(password.getPassword())) == account1.getPin()) {
                                        window1.dispose();
                                        MainWindow mainWindow = new MainWindow(account);
                                    } else if (Integer.parseInt(String.valueOf(password.getPassword())) != account1.getPin()) {
                                        labelerror.setVisible(true);
                                        a -= 1;
                                    }

                                }
                            }
                    } else {
                        //bans.add(nr.getText());
                        FileWriter fileWriter = new FileWriter("C:\\Users\\darek\\IdeaProjects\\Projekt\\Ban.txt");
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        for (String ban : bans) {
                            bufferedWriter.write(ban+"\n");
                        }
                        bufferedWriter.write(nr.getText());
                        bufferedWriter.close();
                        window1.dispose();
                    }
                }
                catch (NumberFormatException | FileNotFoundException a) {
                    JOptionPane.showMessageDialog(null, "Nr lub pin muszą być liczbą", "error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        window1.setVisible(true);
    }


}
