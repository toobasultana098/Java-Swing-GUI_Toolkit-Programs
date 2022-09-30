package p2;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


class Save implements ActionListener{
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4;
	JComboBox cb;
	JRadioButton rb1,rb2;
	JButton b1;
	Save(){
		f=new JFrame();
        f.setLayout(null);
        f.setSize(1200, 800);
        f.setTitle("Employee Register Form");
        
        l1=new JLabel("Employee Registration Form");
        l1.setFont(new Font("arial",1,50));
        l1.setBounds(10,10,800,60);
        f.add(l1);
        
        l2=new JLabel("Emp Number");
        l2.setFont(new Font("arial",1,30));
        l2.setBounds(10,90,400,50);
        f.add(l2);

        t1=new JTextField();
        t1.setFont(new Font("arial",1,30));
        t1.setBounds(450,90,300,50);
        f.add(t1);
        
        l3=new JLabel("Emp Name");
        l3.setFont(new Font("arial",1,30));
        l3.setBounds(10,150,400,50);
        f.add(l3);
        
        t2=new JTextField();
        t2.setFont(new Font("arial",1,30));
        t2.setBounds(450,150,300,50);
        f.add(t2);
        
        l4=new JLabel("Job");
        l4.setFont(new Font("arial",1,30));
        l4.setBounds(10,210,400,50);
        f.add(l4);
        
        String job[] ={"PRESIDENT","MANAGER","SALESMAN","CLERK","ANALYST"};
        cb=new JComboBox(job);
        cb.setFont(new Font("arial",1,30));
        cb.setBounds(450,210,300,50);
        f.add(cb);

        l5=new JLabel("Dept No.");
        l5.setFont(new Font("arial",1,30));
        l5.setBounds(10,270,400,50);
        f.add(l5);

        t3=new JTextField();
        t3.setFont(new Font("arial",1,30));
        t3.setBounds(450,270,300,50);
        f.add(t3);
        
        l6=new JLabel("Mobile no.");
        l6.setFont(new Font("arial",1,30));
        l6.setBounds(10,330,400,50);
        f.add(l6);

        t4=new JTextField();
        t4.setFont(new Font("arial",1,30));
        t4.setBounds(450,330,300,50);
        f.add(t4);
        
        l7=new JLabel("Gender");
        l7.setFont(new Font("arial",1,30));
        l7.setBounds(10,390,400,50);
        f.add(l7);

        rb1=new JRadioButton("M");
        rb1.setFont(new Font("arial",1,30));
        rb1.setBounds(450,390,100,50);
        f.add(rb1);

        rb2=new JRadioButton("F");
        rb2.setFont(new Font("arial",1,30));
        rb2.setBounds(600,390,300,50);
        f.add(rb2);
        
            
        
        b1=new JButton("Register");
        b1.setFont(new Font("arial",1,30));
        b1.setBounds(300,450,200,50);
        b1.addActionListener(this);
        f.add(b1);
        
        
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		Regn r1 = new Regn();
		while(true) {
			String g = null;
			String k=null;
			int a=Integer.parseInt(t1.getText());
			int d=Integer.parseInt(t3.getText());
			k=t4.getText();
			String h= t2.getText();
			String c=""+cb.getItemAt(cb.getSelectedIndex());
			if(rb1.isSelected()) {
				g=rb1.getText();
			}
			else if(rb2.isSelected()) {
				g=rb2.getText();
			}
			boolean b=r1.saveRecord(a,h,c,d,k,g);
			if(b)
			{
				System.out.println("Data Saved...");
			}
			else {
				System.out.println("Problem in Data Saved...");
			}
			break;			
		}
	}
}

class Show{
	
	Show(){
		JFrame f1;
		JTable table;
		f1=new JFrame();
	    f1.setSize(1200, 600);
			
	    Regn r1 = new Regn();
	       
		DefaultTableModel tm;
		Object[] ob1=new Object[6];
		ob1[0]="Empno";
		ob1[1]="Empname";
		ob1[2]="Job";
		ob1[3]="Deptno";
		ob1[4]="Mobileno";
		ob1[5]="Gender";
		tm=new DefaultTableModel(ob1,0);
		ArrayList<employee> arr=r1.getRecords();
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
		
		//f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f1.setVisible(true);
	}
}

class Search implements ActionListener{
	JFrame f;
	JLabel l1;
	JTextField t1;
	JButton b1;
	JTable table;
	Search(){
		f=new JFrame();
        f.setLayout(null);
        f.setSize(1200, 800);
        f.setTitle("Searching...");
        
        l1=new JLabel("Enter Emp no.");
        l1.setFont(new Font("arial",1,30));
        l1.setBounds(10,10,400,50);
        f.add(l1);

        t1=new JTextField();
        t1.setFont(new Font("arial",1,30));
        t1.setBounds(450,10,300,50);
        f.add(t1);
        
        b1=new JButton("Search");
        b1.setFont(new Font("arial",1,30));
        b1.setBounds(300,90,200,50);
        b1.addActionListener(this);
        f.add(b1);
        
        
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		int n= Integer.parseInt(t1.getText());
		Regn r1 = new Regn();
		employee e1=r1.search(n);
		
 		if(e1==null){
 			System.out.println("Not Found");
 		}
 		else {
 			JFrame f1;
 			JTable table;
 			f1=new JFrame();
 		    f1.setSize(1200, 600);
 		    
 			DefaultTableModel tm;
			Object[] ob1=new Object[6];
			ob1[0]="Empno";
			ob1[1]="Empname";
			ob1[2]="Job";
			ob1[3]="Deptno";
			ob1[4]="Mobileno";
			ob1[5]="Gender";
			tm=new DefaultTableModel(ob1,0);
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
 	 		table =new JTable();
 		    table.setBounds(30,40,200,300);  
 		    table.setModel(tm);
 		    table.setBounds(30,200,200,300);   
 		    JScrollPane sp=new JScrollPane(table);
 			f1.add(sp);
 			
 			//f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		    f1.setVisible(true);
 		}
 	}		
}

class Update implements ActionListener{
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4;
	JComboBox cb;
	JRadioButton rb1,rb2;
	JButton b1;
	Update(){
		f=new JFrame();
        f.setLayout(null);
        f.setSize(1200, 800);
        f.setTitle("Update");
        
        l1=new JLabel("UPDATE");
        l1.setFont(new Font("arial",1,50));
        l1.setBounds(10,10,800,60);
        f.add(l1);
        
        l2=new JLabel("Emp Number");
        l2.setFont(new Font("arial",1,30));
        l2.setBounds(10,90,400,50);
        f.add(l2);

        t1=new JTextField();
        t1.setFont(new Font("arial",1,30));
        t1.setBounds(450,90,300,50);
        f.add(t1);
        
        l3=new JLabel("Emp Name");
        l3.setFont(new Font("arial",1,30));
        l3.setBounds(10,150,400,50);
        f.add(l3);
        
        t2=new JTextField();
        t2.setFont(new Font("arial",1,30));
        t2.setBounds(450,150,300,50);
        f.add(t2);
        
        l4=new JLabel("Job");
        l4.setFont(new Font("arial",1,30));
        l4.setBounds(10,210,400,50);
        f.add(l4);
        
        String job[] ={"PRESIDENT","MANAGER","SALESMAN","CLERK","ANALYST"};
        cb=new JComboBox(job);
        cb.setFont(new Font("arial",1,30));
        cb.setBounds(450,210,300,50);
        f.add(cb);

        l5=new JLabel("Dept No.");
        l5.setFont(new Font("arial",1,30));
        l5.setBounds(10,270,400,50);
        f.add(l5);

        t3=new JTextField();
        t3.setFont(new Font("arial",1,30));
        t3.setBounds(450,270,300,50);
        f.add(t3);
        
        l6=new JLabel("Mobile no.");
        l6.setFont(new Font("arial",1,30));
        l6.setBounds(10,330,400,50);
        f.add(l6);

        t4=new JTextField();
        t4.setFont(new Font("arial",1,30));
        t4.setBounds(450,330,300,50);
        f.add(t4);
        
        l7=new JLabel("Gender");
        l7.setFont(new Font("arial",1,30));
        l7.setBounds(10,390,400,50);
        f.add(l7);

        rb1=new JRadioButton("M");
        rb1.setFont(new Font("arial",1,30));
        rb1.setBounds(450,390,100,50);
        f.add(rb1);

        rb2=new JRadioButton("F");
        rb2.setFont(new Font("arial",1,30));
        rb2.setBounds(600,390,300,50);
        f.add(rb2);
        
            
        
        b1=new JButton("Update");
        b1.setFont(new Font("arial",1,30));
        b1.setBounds(300,450,200,50);
        b1.addActionListener(this);
        f.add(b1);
        
        
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		Regn r1 = new Regn();
			String g = null;
			String k=null;
			int a=Integer.parseInt(t1.getText());
			int d=Integer.parseInt(t3.getText());
			k=t4.getText();
			String h= t2.getText();
			String c=""+cb.getItemAt(cb.getSelectedIndex());
			if(rb1.isSelected()) {
				g=rb1.getText();
			}
			else if(rb2.isSelected()) {
				g=rb2.getText();
			}
			r1.updateRecorde(a,h,c,d,k,g);
	}
}


class Delete implements ActionListener{
	JFrame f;
	JLabel l1;
	JTextField t1;
	JButton b1;
	Delete(){
		f=new JFrame();
        f.setLayout(null);
        f.setSize(1200, 800);
        f.setTitle("Searching...");
        
        l1=new JLabel("Enter Emp no.");
        l1.setFont(new Font("arial",1,30));
        l1.setBounds(10,10,400,50);
        f.add(l1);

        t1=new JTextField();
        t1.setFont(new Font("arial",1,30));
        t1.setBounds(450,10,300,50);
        f.add(t1);
        
        b1=new JButton("Delete");
        b1.setFont(new Font("arial",1,30));
        b1.setBounds(300,90,200,50);
        b1.addActionListener(this);
        f.add(b1);
        
        
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		int n= Integer.parseInt(t1.getText());
		Regn r1 = new Regn();
		r1.deleteRecord(n);
	}
}


class Emp implements ActionListener{	
	JFrame f;
	JMenuBar mb;    
	JMenu master;    
	JMenuItem add, show, search, update, delete;    
	Emp(){
		f=new JFrame();
        f.setLayout(null);
        f.setSize(1200, 800);
        f.setTitle("Employee");
        
        add=new JMenuItem("Add New");
        show=new JMenuItem("Show All");    
        search=new JMenuItem("Search");
        update=new JMenuItem("Update");
        delete=new JMenuItem("Delete");
        
        add.addActionListener(this);    
        show.addActionListener(this);    
        search.addActionListener(this);    
        update.addActionListener(this);  
        delete.addActionListener(this);  
        
        mb=new JMenuBar();    
        master=new JMenu("Master"); 
        
        master.add(add);
        master.add(show);
        master.add(search);
        master.add(update);
        master.add(delete);
        
        mb.add(master);
        f.add(mb);
        f.setJMenuBar(mb);  
        
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add) {
			new Save();
		}
		if(e.getSource()==show) {
			new Show();
		}
		if(e.getSource()==search) {
			new Search();
		}
		if(e.getSource()==update)   {
			new Update();
		}
		if(e.getSource()==delete)   {
			new Delete();
		}
	}
}
public class Application {
	public static void main(String args[]) {
		new Emp();
	}
}
