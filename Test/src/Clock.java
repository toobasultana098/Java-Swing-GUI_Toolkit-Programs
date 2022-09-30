import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Calendar;

class Digital{
	JFrame f;
	JLabel l1,l2;
	SimpleDateFormat t1;
	String time;
	Digital(){
		f=new JFrame();
        f.setLayout(null);
        f.setSize(500,300);
        f.setTitle("Digital Clock");
        
        
        t1=new SimpleDateFormat("hh:mm:ss");
        
        l2=new JLabel("Digital Clock");
		l2.setBounds(10,10,400,100);
		l2.setFont(new Font("arial",1,50));
		f.add(l2);
        
        l1=new JLabel();
		l1.setBounds(110,110,300,100);
		l1.setFont(new Font("arial",1,30));
		f.add(l1);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        while(true) {
        	time=t1.format(Calendar.getInstance().getTime());
        	l1.setText(time);
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
	}
}


public class Clock {
    public static void main(String args[]){
        new Digital();
    }
}