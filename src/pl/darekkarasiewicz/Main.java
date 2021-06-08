package pl.darekkarasiewicz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        Account nr1= new Account(1111,1,2000);
        Account nr2= new Account(2222,2,3000);
        Account nr3= new Account(3333,3,5000);
        Account [] konta = new Account[]{nr1,nr2,nr3};
        Login login= new Login(konta);
        //MainWindow mainWindow =new MainWindow(1);
    }
}
