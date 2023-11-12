import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class game{
    JFrame screen;
    Container con;
    JPanel title,sbPanel;
    JLabel tName;
    JButton sButton;
    public static void main(String[] args){
        new game();
    }
    public game(){
        //screen setting
        screen = new JFrame();
        screen.setSize(720, 480);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.getContentPane().setBackground(Color.black);
        screen.setLayout(null);
        screen.setVisible(true);
        con = screen.getContentPane();

        //title
        title = new JPanel();
        title.setBounds(250, 50, 200, 100);
        title.setBackground(Color.blue);      
        con.add(title);
        //titleName
        tName = new JLabel();
        tName.setBounds(250, 50, 200, 100);
        tName.setBackground(Color.black);
        tName.setForeground(Color.white);
        tName.setText("TEXT ADVENTURE");
        title.add(tName);

        //start button
        sbPanel = new JPanel();
        sbPanel.setBounds(250,200,200,100);
        sbPanel.setBackground(Color.red);
        con.add(sbPanel);
        //name start Button
        sButton = new JButton();
        sButton.setBounds(250,200,200,100);
        sButton.setBackground(Color.black);
        sButton.setForeground(Color.white);
        sButton.setText("Mulai Game!");
        sButton.setFocusable(false);
        sbPanel.add(sButton);

    }
}