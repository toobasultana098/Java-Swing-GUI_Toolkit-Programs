package p1;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	public static void menu()
	{
		System.out.println("0...Exit\n1...New\n2...show all\n3...search\n4...update\n5...delete");
	}
	public static void main(String[] args) {
		connect c1=new connect();
		Scanner in=new Scanner(System.in);
		int roll,marks,ch;
		String name;
		char ans='\u0000';
		while(true)
		{
			menu();
			ch=in.nextInt();
			switch(ch)
			{
				case 0: 
					System.exit(0);
					break;
			 	case 1:do {
			 		System.out.println("Enter Roll");
			 		roll=in.nextInt();
			 		System.out.println("Enter Name");
			 		name=in.next();
			 		System.out.println("Enter Marks");
			 		marks=in.nextInt();
			 		boolean b=c1.saveRecord(roll, name, marks);
			 		if(b)
					{
						System.out.println("Data Saved...");
					}
					else {
						System.out.println("Problem in Data Saved...");
					}
			 		System.out.println("Press y to cont...");
			 		ans=in.next().charAt(0);
			 	}while(ans=='y');
			 	break;
			 	case 2: 
			 		ArrayList<student> arr=c1.getRecords();
			 		System.out.println("Roll\tName\tMarks");
			 		for(int i=0;i<arr.size();i++)
			 		{
						student s1=(student)arr.get(i);
		 				System.out.println(s1.getRoll()+"\t"+s1.getName()+"\t"+s1.getMarks());
		 			}
			 		break;
			 	case 3:
			 		System.out.println("Enter Roll");
			 		roll=in.nextInt();
			 		student s1=c1.search(roll);
			 		if(s1==null)
			 		{
			 			System.out.println("Not Found");
			 		}
			 		else {
			 			System.out.println("Roll\tName\tMarks");
			 			System.out.println(s1.getRoll()+"\t"+s1.getName()+"\t"+s1.getMarks());
			 		}
			 		break;
			 	case 4: 
			 		System.out.println("Enter Roll");
			 		roll=in.nextInt();
			 		System.out.println("Enter New Name");
			 		name=in.next();
			 		System.out.println("Enter New Marks");
			 		marks=in.nextInt();
			 		c1.updateRecorde(roll, name, marks);
			 		break;
			 	case 5 :
			 		System.out.println("Enter Roll");
			 		roll=in.nextInt();
			 		c1.deleteRecord(roll);
			 		break;
			}
		}
	}
}
