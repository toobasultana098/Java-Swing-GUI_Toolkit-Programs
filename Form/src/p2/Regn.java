package p2;
import java.sql.*;
import java.util.ArrayList;

public class Regn {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Regn()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");  
			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	public boolean saveRecord(int empno,String empname,String job,int deptno,String mobileno,String gender)
	{
		boolean b=false;
		String sql="INSERT INTO emp(empno,empname,job,deptno,mobileno,gender)VALUES(?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, empno);
			ps.setString(2, empname);
			ps.setString(3, job);
			ps.setInt(4, deptno);
			ps.setString(5, mobileno);
			ps.setString(6, gender);
			int n=ps.executeUpdate();
			if(n>0)
				b=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public ArrayList<employee> getRecords(){
		ArrayList<employee> arr=new ArrayList<employee>();
		employee e1;
		String sql="SELECT * FROM emp";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				e1=new employee();
				e1.setEmpno(rs.getInt(1));
				e1.setEmpname(rs.getString(2));
				e1.setJob(rs.getString(3));
				e1.setDeptno(rs.getInt(4));
				e1.setMobileno(rs.getString(5));
				e1.setGender(rs.getString(6));
				arr.add(e1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	public employee search(int empno){
		employee e1=null;
		String sql="SELECT * FROM emp where empno=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, empno);
			rs=ps.executeQuery();
			if(rs.next())
			{
				e1=new employee();
				e1.setEmpno(rs.getInt(1));
				e1.setEmpname(rs.getString(2));
				e1.setJob(rs.getString(3));
				e1.setDeptno(rs.getInt(4));
				e1.setMobileno(rs.getString(5));
				e1.setGender(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return e1;
	}
	public void updateRecorde(int empno,String empname,String job,int deptno,String mobileno,String gender) {
		String sql ="UPDATE emp  Set empname=?, job =? ,deptno=?, mobileno =? ,gender=? where empno=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, empname);
			ps.setString(2, job);
			ps.setInt(3, deptno);
			ps.setString(4, mobileno);
			ps.setString(5, gender);
			ps.setInt(6, empno);
			int n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteRecord(int empno)
	{
		String sql="DELETE FROM emp where empno=?";
		try {
		ps=con.prepareStatement(sql);
		ps.setInt(1, empno);
		int n=ps.executeUpdate();
		}catch(Exception e) {
		}
	}
	public ArrayList<employee> desgn() {
		ArrayList<employee> arr=new ArrayList<employee>();
		employee e1 = null;
		String sql = "select DISTINCT job from emp";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				e1=new employee();
				e1.setJob(rs.getString(1));
				arr.add(e1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	public ArrayList<employee> list(String job){
		ArrayList<employee> arr=new ArrayList<employee>();
		employee e1;
		String sql="SELECT * FROM emp where job=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, job);
			rs=ps.executeQuery();
			while(rs.next())
			{
				e1=new employee();
				e1.setEmpno(rs.getInt(1));
				e1.setEmpname(rs.getString(2));
				e1.setJob(rs.getString(3));
				e1.setDeptno(rs.getInt(4));
				e1.setMobileno(rs.getString(5));
				e1.setGender(rs.getString(6));
				arr.add(e1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
}
