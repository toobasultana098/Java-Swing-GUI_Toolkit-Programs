import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

class Jtree2{
	JFrame f;
	JTree tree;
	Jtree2(){
		f=new JFrame();
        f.setLayout(new BorderLayout());
        f.setSize(800, 600);
        DefaultMutableTreeNode computer=new DefaultMutableTreeNode("Computer");  
        DefaultMutableTreeNode hardware=new DefaultMutableTreeNode("Hardware");  
        DefaultMutableTreeNode software=new DefaultMutableTreeNode("Software");  
        computer.add(hardware);  
        computer.add(software); 
        DefaultMutableTreeNode input=new DefaultMutableTreeNode("Input"); 
        DefaultMutableTreeNode output=new DefaultMutableTreeNode("Output"); 
        hardware.add(input);
        hardware.add(output);
        DefaultMutableTreeNode keyboard=new DefaultMutableTreeNode("keyboard"); 
        DefaultMutableTreeNode mouse=new DefaultMutableTreeNode("Mouse");
        DefaultMutableTreeNode monitor=new DefaultMutableTreeNode("Monitor"); 
        DefaultMutableTreeNode printer=new DefaultMutableTreeNode("Printer");
        input.add(keyboard);
        input.add(mouse);
        output.add(monitor);
        output.add(printer);
        DefaultMutableTreeNode system=new DefaultMutableTreeNode("System");  
        DefaultMutableTreeNode app=new DefaultMutableTreeNode("Application");
        software.add(system);
        software.add(app);
        DefaultMutableTreeNode windows=new DefaultMutableTreeNode("Windows"); 
        DefaultMutableTreeNode DOS=new DefaultMutableTreeNode("DOS");
        DefaultMutableTreeNode word=new DefaultMutableTreeNode("Word"); 
        DefaultMutableTreeNode excel=new DefaultMutableTreeNode("Excel");
        system.add(windows);
        system.add(DOS);
        app.add(word);
        app.add(excel);
        tree=new JTree(computer);  
        f.add(tree);  
        f.setSize(200,200);  
        f.setVisible(true);
	}
}

public class Tree1 {
	public static void main(String args[]) {
		new Jtree2();
	}
}
