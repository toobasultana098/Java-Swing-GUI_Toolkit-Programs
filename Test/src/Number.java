import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Combo implements ItemListener{
    JFrame f;
    JLabel l1,l2;
    JComboBox <String>c1;
    int n;
    Combo(){
        f=new JFrame();
        f.setLayout(null);
        f.setSize(800, 1000);
        f.setTitle("Number Selector");

        l1=new JLabel("Select a number. ");
        l1.setFont(new Font("arial",1,30));
        l1.setBounds(10,10,350,50);
        f.add(l1);

        c1=new JComboBox<String>();
        for(int i=1;i<=100;i++){
            c1.addItem(""+i);
        }
        c1.setFont(new Font("arial",1,30));
        c1.setBounds(400,10,350,50);
        c1.addItemListener(this);
        f.add(c1);
        
        
        
        

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		n=Integer.parseInt((String)c1.getSelectedItem());
		
		int x=100,y=10,w=300,h=50;
		for(int i=1;i<=10;i++)
		{
			JLabel lbl=new JLabel(n+"  x  "+i+"   =    "+(n*i));
			lbl.setBounds(x, y, w, h);
			f.add(lbl);
			y+=50;
		}
		
	}
}

public class Number {
    public static void main(String args[]){
        new Combo();
    }
}
