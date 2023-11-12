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
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90); //size and family of font
    Font startFont = new Font("Times New Roman", Font.PLAIN, 35);
    JButton startButton,choice1,choice2,choice3,choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

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

        mainTextArea = new JTextArea("this is how to make area text!");
        mainTextArea.setBounds(250,100,790,250); //position
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(startFont);
        mainTextArea.setLineWrap(true); //portal change screen,can be locked automatically
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(400,350,500,300);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1)); //box layout
        con.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1"); 
        choice1.setBackground(Color.darkGray);
        choice1.setForeground(Color.white);
        choice1.setFont(startFont);
        choiceButtonPanel.add(choice1);
        choice1.setFocusPainted(false); //means grind inside the box, false means = clean
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.blue);
        choice2.setForeground(Color.white);
        choice2.setFont(startFont);
        choiceButtonPanel.add(choice2);
        choice2.setFocusPainted(false); //means grind inside the box, false means = clean
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.red);
        choice3.setForeground(Color.white);
        choice3.setFont(startFont);
        choiceButtonPanel.add(choice3);
        choice3.setFocusPainted(false); //means grind inside the box, false means = clean
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.MAGENTA);
        choice4.setForeground(Color.white);
        choice4.setFont(startFont);
        choiceButtonPanel.add(choice4);
        choice4.setFocusPainted(false); //means grind inside the box, false means = clean
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");

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
        playerHP = 15;
        monsterHP = 20;
        weapon = "Knife";
        weaponLabelName.setText(weapon); //how to display String
        hpLabelNumber.setText("" + playerHP);

        townGate();
    }

    public void townGate(){
        position = "townGate";
        mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat do you do?");
        choice1.setText("Talk to the Guard");
        choice2.setText("Attack the Guard");
        choice3.setText("Leave");
        choice4.setText("");

    }

    public void talkGuard(){
        position = "talkGuard";
        mainTextArea.setText("Guard: Hello Stranger. I have never seen your face. \nI'm sorry but we cannot let a stranger enter our town.");
        choice1.setText("Continue");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void attackGuard(){
        position = "attackGuard";
        mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe Guard Fought back and hit you hard.\n(You receive 3 damage)");
        playerHP -= 3;
        hpLabelNumber.setText(""+ playerHP);
        choice1.setText("Back to Town Gate");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void crossRoad(){
        position = "crossRoad";
        mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to the town.");
        choice1.setText("Go North");
        choice2.setText("Go East");
        choice3.setText("Go South");
        choice4.setText("Go West");
    }
    
    public void north(){
        position = "north";
        mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside. \n\n(Your HP is recovered by 2)");
        playerHP += 2;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText("Go South");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void east(){
        position = "east";
        mainTextArea.setText("You walked into a forest and found a Long Sword\n\n(You Obatined a Long Sword)");
        weapon = "Long Sword";
        weaponLabelName.setText(weapon);
        choice1.setText("Go West");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void west(){
        position = "west";

        mainTextArea.setText("You encounter a goblin!");
        choice1.setText("Fight");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void fight(){
        position = "fight";
        mainTextArea.setText("Monster HP: " + monsterHP + "\n\nWhat do you do?");
        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void playerAttack(){
        position = "playerAttack";

        int playerDamage = 0;

        if(weapon.equals("Knife")){
            playerDamage = new java.util.Random().nextInt(5);//5 its max means 0,1,2,3,4 like a array its not 1,2,3
        } else if (weapon.equals("Long Sword")){
            playerDamage = new java.util.Random().nextInt(8);// 0,1,2,3,4,5,6,7
        }

        mainTextArea.setText("You Attacked the monster and gave " + playerDamage + " damage!");
        monsterHP -= playerDamage;
        choice1.setText("Continue");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void monsterAttack(){
        position = "monsterAttack";

        int monsterDamage = 0;
        monsterDamage = new java.util.Random().nextInt(6); //0,1,2,3,4
        mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");

        playerHP -= monsterDamage;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText("Continue");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }

    public void win(){
        position = "win";
        mainTextArea.setText("You Defeated the monster\n\nThe monster dropped a ring!\n\n(You Obtained a Silver Ring)");

        silverRing = 1;
        choice1.setText("Go East");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }

    public void lose(){
        position = "lose";
        mainTextArea.setText("You are dead!\n\n<GAME OVER>");

        choice1.setText("Restart The Game!");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }

    public void ending(){
        position = "ending";
        mainTextArea.setText("Guard: Oh you killed that goblin!?\nThank you so much. You are true hero!\nWelcome to our town!\n\n<THE END>");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }

    public void restart(){
        position = "restart";
        mainTextArea.setText("You Are Dead!\n\n<GAME OVER>");
        choice1.setText("Try Again");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }

    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            GameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand(); //means yourChoice will take what you click of choice1,choice2,choice3,choice4

            switch (position) {
                case "townGate":
                    switch (yourChoice) {
                        case "c1":
                            if (silverRing == 1) {
                                ending();
                            } else {
                                talkGuard();
                            }
                            break;
                        case "c2":
                            attackGuard();
                            break;
                        case "c3":
                            crossRoad();
                            break;
                    }
                        break;
                    case "talkGuard" :
                        switch (yourChoice) {
                            case "c1":
                                townGate();
                                break;
                        }
                        break;
                    case "attackGuard":
                        switch (yourChoice) {
                            case "c1":
                                townGate();
                                break;
                        }
                        break;
                    case "crossRoad":
                        switch (yourChoice) {
                            case "c1":
                                north();
                                break;
                            case "c2":
                                east();
                                break;
                            case "c3":
                                townGate();
                                break;
                            case "c4":
                                west();
                                break;
                        }
                        break;
                    case "north":
                        switch (yourChoice) {
                            case "c1":
                                crossRoad();                                
                                break;
                        }
                    case "east":
                        switch (yourChoice) {
                            case "c1":
                                crossRoad();
                                break;
                        }
                        break;
                    case "west":
                        switch (yourChoice) {
                            case "c1":
                                fight();
                                break;
                            case "c2":
                                crossRoad();
                                break;
                        }
                        break;
                    case "fight":
                        switch(yourChoice){
                            case "c1":
                                playerAttack();
                                break;
                            case "c2":
                                crossRoad();
                                break;
                        }
                        break;
                    case "playerAttack":
                        switch (yourChoice) {
                            case "c1":
                                if(monsterHP<1){
                                    win();
                                } else {
                                    monsterAttack();
                                }
                                break;
                        }
                        break;
                    case "monsterAttack":
                        switch (yourChoice) {
                            case "c1":
                                if(playerHP<1){
                                    //lose();
                                    switch (yourChoice) {
                                        case "c1":
                                            restart();
                                            break;
                                    }
                                } else {
                                    fight();
                                }
                                break;
                        }
                        break;
                    case "win":
                        switch (yourChoice) {
                            case "c1":
                                crossRoad();
                                break;
                        }
                        break;
                    case "restart":
                        switch (yourChoice) {
                            case "c1":
                                new mainMenu();
                                break;
                        }
            }
        }
    }
}