import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class mainMenu{
    
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, startButtonLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90); //size and family of font
    Font startFont = new Font("Times New Roman", Font.PLAIN, 40);
    JButton startButton,choice1,choice2,choice3,choice4;
    JTextArea mainTextArea;
    int playerHP;
    String weapon;

    TitleScreenHandler tsHandler = new TitleScreenHandler();

    public static void main(String[] args){
        new mainMenu();
    }
    public mainMenu(){
        //setting screen
        window = new JFrame();
        window.setSize(1280,720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this is important for close the screen window!
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true); //means to appear screen
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,1050,120);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("TEXT(GUI) ADVENTURE");
        titleNameLabel.setForeground(Color.white); //text color
        titleNameLabel.setFont(titleFont);
        
        //start box position
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(500, 450, 200, 100);
        startButtonPanel.setBackground(Color.black);
        
        //start text and button
        startButton = new JButton("START");
        startButton.setBackground(Color.blue); //background
        startButton.setForeground(Color.white); //text color
        startButton.setFont(startFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false); //means grid inside the box, false means = clean

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }
    public void GameScreen(){

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(250,100, 800, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("Di depanmu ada lolicon,dia memiliki 50 HP, dan 3 ATK, apa yang akan kamu lakukan?");
        mainTextArea.setBounds(250,100,790,250); //position
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(startFont);
        mainTextArea.setLineWrap(true); //portal change screen,can be locked automatically
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(400,350,500,300);
        choiceButtonPanel.setBackground(Color.blue);
        choiceButtonPanel.setLayout(new GridLayout(2,2)); //box layout
        con.add(choiceButtonPanel);

        choice1 = new JButton("Attack"); 
        choice1.setBackground(Color.darkGray);
        choice1.setForeground(Color.white);
        choice1.setFont(startFont);
        choiceButtonPanel.add(choice1);
        choice1.setFocusPainted(false); //means grind inside the box, false means = clean
        
        choice2 = new JButton("Special Skill");
        choice2.setBackground(Color.blue);
        choice2.setForeground(Color.white);
        choice2.setFont(startFont);
        choiceButtonPanel.add(choice2);
        choice2.setFocusPainted(false); //means grind inside the box, false means = clean
        
        choice3 = new JButton("Leave");
        choice3.setBackground(Color.red);
        choice3.setForeground(Color.white);
        choice3.setFont(startFont);
        choiceButtonPanel.add(choice3);
        choice3.setFocusPainted(false); //means grind inside the box, false means = clean
        
        choice4 = new JButton("Call Police");
        choice4.setBackground(Color.MAGENTA);
        choice4.setForeground(Color.white);
        choice4.setFont(startFont);
        choiceButtonPanel.add(choice4);
        choice4.setFocusPainted(false); //means grind inside the box, false means = clean

        playerPanel = new JPanel();
        playerPanel.setBounds(250, 15,800,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setFont(startFont);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(startFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(startFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(startFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(startFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);
        
        playerSetup();
    }
    public void playerSetup(){
        playerHP = 100;
        weapon = "Knife";
        weaponLabelName.setText(weapon); //how to display String
        hpLabelNumber.setText("" + playerHP);
    }
    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            GameScreen();

        }
    }
}