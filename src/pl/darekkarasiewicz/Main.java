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
        Account nr4= new Account(4444,4,2000);
        Account nr5= new Account(5555,5,2000);
        Account nr6= new Account(6666,6,2000);
        Account nr7= new Account(7777,7,2000);
        Account [] konta = new Account[]{nr1,nr2,nr3,nr4,nr5,nr6,nr7};
        Login login= new Login(konta);
        //MainWindow mainWindow =new MainWindow(1);
    }
}
