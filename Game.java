import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
public class Game implements ActionListener{
	
Random random = new Random();
JFrame frame = new JFrame();
JPanel title = new JPanel();
JPanel button_panel = new JPanel();
JLabel text = new JLabel();
JButton[] buttons = new JButton[9];
boolean player1_turn;
Font chalkduster;

	
Game(){
		
try {
chalkduster = Font.createFont(Font.TRUETYPE_FONT, new File("Chalkduster.ttf")).deriveFont(50f);
GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Chalkduster.ttf")));
			
}catch(IOException | FontFormatException e)  {
			
}
		
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(800, 800);
frame.getContentPane().setBackground(new Color(51,45,40));	
frame.setLayout(new BorderLayout());
frame.setVisible(true);
	
text.setBackground(new Color(51,45,40));
text.setForeground(new Color(255, 255, 255));
text.setFont(chalkduster);
text.setHorizontalAlignment(JLabel.CENTER);
text.setText("Tic-Tac-Toe");
text.setOpaque(true);
	
title.setLayout(new BorderLayout());
title.setBounds(0, 0, 800, 100);
	
button_panel.setLayout(new GridLayout(3, 3));
button_panel.setBackground(new Color(51,45,40));
	
for(int i = 0; i < 9; i++) {
buttons[i] = new JButton();
button_panel.add(buttons[i]);
buttons[i].setFont(new Font("chalkduster", Font.BOLD, 120)); 
buttons[i].setBackground(new Color(51,45,40));	
buttons[i].setFocusable(false);
buttons[i].setBorder(BorderFactory.createEtchedBorder());
buttons[i].addActionListener(this);
}
	
title.add(text);
frame.add(title, BorderLayout.NORTH);
frame.add(button_panel);	
Turn();
}
	
@Override
public void actionPerformed(ActionEvent e) {
		
for(int i=0;i<9;i++) {
if(e.getSource()==buttons[i]) {
if(player1_turn) {
if(buttons[i].getText()=="") {
buttons[i].setForeground(new Color(255,255,255));
buttons[i].setBackground(new Color(47,33,27));	
buttons[i].setText("X");
player1_turn=false;
text.setText("O turn");
check();
}
}

else {
if(buttons[i].getText()=="") {
buttons[i].setForeground(new Color(255,255,255));
buttons[i].setBackground(new Color(47,33,27));	
buttons[i].setText("O");
player1_turn=true;
text.setText("X turn");
check();
}
}
}			
}
}
	
public void Turn() {

try {
Thread.sleep(2000);	
}catch(InterruptedException e) {
e.printStackTrace();
}
	
if(random.nextInt(2) == 0) {
player1_turn = true;
text.setText("X turn");
	
}else {
		
player1_turn = false;
text.setText("O turn");
}
		
}
	
public void check() {
if(
(buttons[0].getText() == "X") && 
(buttons[1].getText() == "X") && 
(buttons[2].getText() == "X")) {
xWins(0, 1, 2);	
}
		
if(
				
(buttons[3].getText() == "X") && 
(buttons[4].getText() == "X") && 
(buttons[5].getText() == "X")) {
xWins(3, 4, 5);	
}
		
if(
(buttons[6].getText() == "X") && 
(buttons[7].getText() == "X") && 
(buttons[8].getText() == "X")) {
xWins(6, 7, 8);	
}
		
if(
				
(buttons[0].getText() == "X") && 
(buttons[3].getText() == "X") && 
(buttons[6].getText() == "X")) {
xWins(0, 3, 6);	
}
		
if(
(buttons[1].getText() == "X") && 
(buttons[4].getText() == "X") && 
(buttons[7].getText() == "X")) {
xWins(1, 4, 7);	
}
		
if(
(buttons[2].getText() == "X") && 
(buttons[5].getText() == "X") && 
(buttons[8].getText() == "X")) {
xWins(2, 5, 8);	
}

if(
(buttons[0].getText() == "X") && 
(buttons[4].getText() == "X") && 
(buttons[8].getText() == "X")) {
xWins(0, 4, 8);	
}

if(
(buttons[2].getText() == "X") && 
(buttons[4].getText() == "X") && 
(buttons[6].getText() == "X")) {
xWins(2, 4, 6);	
}

if(
(buttons[0].getText() == "O") && 
(buttons[1].getText() == "O") && 
(buttons[2].getText() == "O")) {
oWins(0, 1, 2);	
}

if(
(buttons[3].getText() == "O") && 
(buttons[4].getText() == "O") && 
(buttons[5].getText() == "O")) {
oWins(3, 4, 5);	
}
				
if(
(buttons[6].getText() == "O") && 
(buttons[7].getText() == "O") && 
(buttons[8].getText() == "O")) {
oWins(6, 7, 8);	
}

if(
(buttons[0].getText() == "O") && 
(buttons[3].getText() == "O") && 
(buttons[6].getText() == "O")) {
oWins(0, 3, 6);	
}

if(
(buttons[1].getText() == "O") && 
(buttons[4].getText() == "O") && 
(buttons[7].getText() == "O")) {
oWins(1, 4, 7);	
}
				
if(
(buttons[2].getText() == "O") && 
(buttons[5].getText() == "O") && 
(buttons[8].getText() == "O")) {
oWins(2, 5, 8);	
}

if(
(buttons[0].getText() == "O") && 
(buttons[4].getText() == "O") && 
(buttons[8].getText() == "O")) {
oWins(0, 4, 8);	
}
				
if(
(buttons[2].getText() == "O") && 
(buttons[4].getText() == "O") && 
(buttons[6].getText() == "O")) {
oWins(2, 4, 6);	
}
}

public void xWins(int a, int b, int c) {
	
buttons[a].setBackground(new Color(193, 255, 207));
buttons[b].setBackground(new Color(193, 255, 207));
buttons[c].setBackground(new Color(193, 255, 207));
	
for(int i=0; i<9; i++) {
buttons[i].setEnabled(false);	
}
text.setText("X wins");
}

public void oWins(int a, int b, int c) {
	
buttons[a].setBackground(new Color(193, 255, 207));
buttons[b].setBackground(new Color(193, 255, 207));
buttons[c].setBackground(new Color(193, 255, 207));
	
for(int i=0; i<9; i++) {
buttons[i].setEnabled(false);	
}
text.setText("O wins");
}
}
