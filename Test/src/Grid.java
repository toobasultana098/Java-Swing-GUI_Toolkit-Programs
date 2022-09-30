import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Game implements ActionListener{
	JFrame f;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	int z=0;
	Game(){
		f=new JFrame();
        f.setLayout(null);
        f.setSize(800, 1000);
        f.setTitle("Tic-Tac-Toe");
        
        b1=new JButton("1");
		b1.setBounds(10,10,50,50);
		b1.addActionListener(this);
		f.add(b1); 
		
		b2=new JButton("2");
		b2.setBounds(60,10,50,50);
		b2.addActionListener(this);
		f.add(b2); 
		
		b3=new JButton("3");
		b3.setBounds(110,10,50,50);
		b3.addActionListener(this);
		f.add(b3); 
		
		b4=new JButton("4");
		b4.setBounds(10,60,50,50);
		b4.addActionListener(this);
		f.add(b4); 
		
		b5=new JButton("5");
		b5.setBounds(60,60,50,50);
		b5.addActionListener(this);
		f.add(b5); 
		
		b6=new JButton("6");
		b6.setBounds(110,60,50,50);
		b6.addActionListener(this);
		f.add(b6); 
		
		b7=new JButton("7");
		b7.setBounds(10,110,50,50);
		b7.addActionListener(this);
		f.add(b7); 
        
		b8=new JButton("8");
		b8.setBounds(60,110,50,50);
		b8.addActionListener(this);
		f.add(b8); 
		
		b9=new JButton("9");
		b9.setBounds(110,110,50,50);
		b9.addActionListener(this);
		f.add(b9); 
		
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		String op=e.getActionCommand();
		
		char ch;
		if(z%2==0) {
			ch='X';
			z++;
		}
		else {
			ch='O';
			z++;
		}
		switch(op) {
		case "1"  : 
			b1.setText(""+ch); 
			break;
		case "2" :
			b2.setText(""+ch);
			break;
		case "3"  : 
			b3.setText(""+ch); 
			break;
		case "4" :
			b4.setText(""+ch);
			break;
		case "5"  : 
			b5.setText(""+ch); 
			break;
		case "6" :
			b6.setText(""+ch);
			break;
		case "7"  : 
			b7.setText(""+ch); 
			break;
		case "8" :
			b8.setText(""+ch);
			break;
		case "9"  : 
			b9.setText(""+ch); 
			break;
		}
		if(b1.getText().compareTo(b2.getText())==0 && b2.getText().compareTo(b3.getText())==0) {
			JOptionPane.showMessageDialog(null,"Winner");
		}
		else if(b4.getText().compareTo(b5.getText())==0 && b5.getText().compareTo(b6.getText())==0) {
			JOptionPane.showMessageDialog(null,"Winner");
		}
		else if(b7.getText().compareTo(b8.getText())==0 && b8.getText().compareTo(b9.getText())==0) {
			JOptionPane.showMessageDialog(null,"Winner");
		}
		else if(b1.getText().compareTo(b4.getText())==0 && b4.getText().compareTo(b7.getText())==0) {
			JOptionPane.showMessageDialog(null,"Winner");
		}
		else if(b2.getText().compareTo(b5.getText())==0 && b5.getText().compareTo(b8.getText())==0) {
			JOptionPane.showMessageDialog(null,"Winner");
		}
		else if(b3.getText().compareTo(b6.getText())==0 && b6.getText().compareTo(b9.getText())==0) {
			JOptionPane.showMessageDialog(null,"Winner");
		}
		else if(b1.getText().compareTo(b5.getText())==0 && b5.getText().compareTo(b9.getText())==0) {
			JOptionPane.showMessageDialog(null,"Winner");
		}
		else if(b3.getText().compareTo(b5.getText())==0 && b5.getText().compareTo(b7.getText())==0) {
			JOptionPane.showMessageDialog(null,"Winner");
		}
	}
}

public class Grid {
	public static void main(String args[]) {
		new Game();
	}
}