package p1;
import java.sql.*;
import java.util.ArrayList;
public class connect {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	public boolean saveRecord(int roll,String name,int marks)
	{
		boolean b=false;
		String sql="INSERT INTO student(roll,name,marks)VALUES(?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, roll);
			ps.setString(2, name);
			ps.setInt(3, marks);
			int n=ps.executeUpdate();
			if(n>0)
				b=true;
		} catch (SQLException e) {

		}
		return b;
	}
	public ArrayList<student> getRecords(){
		ArrayList<student> arr=new ArrayList<student>();
		student s1;
		String sql="SELECT * FROM student";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				s1=new student();
				s1.setRoll(rs.getInt(1));
				s1.setName(rs.getString(2));
				s1.setMarks(rs.getInt(3));
				arr.add(s1);
			}
		} catch (SQLException e) {
		}
		return arr;
	}
	public student search(int roll){
		student s1=null;
		String sql="SELECT * FROM student where roll=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, roll);
			rs=ps.executeQuery();
			if(rs.next())
			{
					s1=new student();
					s1.setRoll(rs.getInt(1));
					s1.setName(rs.getString(2));
					s1.setMarks(rs.getInt(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s1;
	}
	public void deleteRecord(int roll)
	{
		String sql="DELETE FROM student where roll=?";
		try {
		ps=con.prepareStatement(sql);
		ps.setInt(1, roll);
		int n=ps.executeUpdate();
		}catch(Exception e) {
		}
	}
	public void updateRecorde(int roll,String name,int marks) {
		String sql ="UPDATE student  Set marks =? ,name=? where roll=?";
		try {
		ps=con.prepareStatement(sql);
		ps.setInt(1, marks);
		ps.setString(2, name);
		ps.setInt(3, roll);
		int n=ps.executeUpdate();
		}catch(Exception e) {
		}
	}
}
