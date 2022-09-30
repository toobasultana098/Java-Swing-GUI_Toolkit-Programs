//Clone of NotePad

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Note implements ActionListener{
	JFrame f;
	JMenuBar mb;
	JMenu m1,m2,m3 ;
	JMenuItem i1,i2,i3,i4,i5,i6,i7,i8;
	TextArea t;
	Note(){
		f=new JFrame();
        f.setLayout(null);
        f.setSize(800, 500);
        f.setTitle("Notes");
        
        mb = new JMenuBar();
		f.add(mb);
		f.setJMenuBar(mb);  
        
		m1=new JMenu("File");
		mb.add(m1);
		
		i1 = new JMenuItem("New File");
		m1.add(i1);
		i2 = new JMenuItem("Open");
		m1.add(i2);
		i3 = new JMenuItem("Save");
		m1.add(i3);
	
		
		m2=new JMenu("Edit");
		mb.add(m2);
		
		i4 = new JMenuItem("Copy");
		i4.addActionListener(this);
		m2.add(i4);
		i5 = new JMenuItem("Paste");
		m2.add(i5);
		i6 = new JMenuItem("Cut");
		m2.add(i6);
		i7 = new JMenuItem("Delete");
		m2.add(i7);
		
		
		m3=new JMenu("View");
		mb.add(m3);
		
		i8 = new JMenuItem("Zoom");
		m3.add(i8);
		
		
		
		t=new TextArea();
		t.setBounds(0,0,790,440);
		f.add(t);
		
		
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String op=e.getActionCommand();
		if(op.compareTo("Copy")==0) {

		}
		if(op.compareTo("Paste")==0) {
			t.setText(paste());
		}
		
	}
	private String paste() {
		// TODO Auto-generated method stub
		return null;
	}
	private String copy() {
		// TODO Auto-generated method stub
		return null;
	}
}


public class Notes {
	public static void main(String args[]) {
		new Note();
	}
}
