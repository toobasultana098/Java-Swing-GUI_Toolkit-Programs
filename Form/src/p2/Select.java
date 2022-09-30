package p2;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


class Desgn implements ItemListener{
	JFrame f;
	JLabel l1;
	JComboBox<String> c1;
	JButton b1;
	Desgn(){
		Regn r1 = new Regn();
		ArrayList<employee> arr=r1.desgn();
		
		f=new JFrame();
	    f.setLayout(null);
	    f.setSize(1200, 800);
	    f.setTitle("Select Designation....");
	    
	    l1=new JLabel("Select Designation");
        l1.setFont(new Font("arial",1,50));
        l1.setBounds(10,10,800,60);
        f.add(l1);
        
        c1=new JComboBox<String>();
        for(int i=0;i<arr.size();i++)
 		{
 			employee e1 = (employee)arr.get(i);
 			c1.addItem((String)e1.getJob());
 		}
        c1.setFont(new Font("arial",1,30));
        c1.setBounds(500,10,300,50);
        c1.addItemListener(this);
        f.add(c1);
        
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}
        
    public void itemStateChanged(ItemEvent e) {
    	JFrame f1;
		JTable table;
		f1=new JFrame();
	    f1.setSize(1200, 600);
    	Regn r1 = new Regn();
    	String c=""+c1.getItemAt(c1.getSelectedIndex());
    	ArrayList<employee> arr=r1.list(c);
    	DefaultTableModel tm;
		Object[] ob1=new Object[6];
		ob1[0]="Empno";
		ob1[1]="Empname";
		ob1[2]="Job";
		ob1[3]="Deptno";
		ob1[4]="Mobileno";
		ob1[5]="Gender";
		tm=new DefaultTableModel(ob1,0);
 		for(int i=0;i<arr.size();i++)
 		{
 			employee e1 = (employee)arr.get(i);
 			tm.addRow(
 				new Object[] {
 					e1.getEmpno(),
 					e1.getEmpname(),
 					e1.getJob(),
 					e1.getDeptno(),
					e1.getMobileno(),
 					e1.getGender()
 				}
 			);
		}
 		table =new JTable();
	    table.setBounds(30,40,200,300);  
	    table.setModel(tm);
	    JScrollPane sp=new JScrollPane(table);
		f1.add(sp);
		f1.setVisible(true);
    }    
}
	
public class Select {
	public static void main(String args[]) {
		new Desgn();
	}
}




