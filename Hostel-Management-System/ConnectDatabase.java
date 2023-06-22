//import java.sql.*;
//
//public class ConnectDatabase{
///*
//* 1. import the package
//* 2. -Load the JDBC Driver
//	 - Register the driver
//* 3. Establish the connection
//* 4. Create the statement
//* 5. Execute the query
//* 6. Process the result
//* 7. Close the connection and the statements
//*/
//	
//	public static void main(String[] args) {
//		try {
//			ConnectDatabase obj = new ConnectDatabase("D181904337");
//			//System.out.println(obj.getStudentName());
//			//obj.sentComplain("No problem in my room, Just for testing purpose");
//			//System.out.println(obj.getComplainCount());
//			//obj.giveStudentCharges(2000, 100);
//			obj.updateAdminIdPass("admin", "admin");
//			obj.closeConnection();
//			
//		}catch(Exception e) {e.printStackTrace();}
//	}
//	
//	Connection con;
//	Statement st;
//	PreparedStatement pst;
//	String ID;
//	String[] complainArr, nameArr, timeArr;
////	Just put the constructor and call the methods under a try..catch{} block
//	public ConnectDatabase(String id) throws SQLException {
//		this.ID = id;
//		
//		String url = "jdbc:mysql://localhost:3306/testdb";
//		String user = "root";
//		String pass = "root";
//		con = DriverManager.getConnection(url, user, pass);
//		
//		int count = getComplainCount();
//		if(count>0) {complainArr = new String[count]; nameArr = new String[count]; timeArr = new String[count];}
//		else {complainArr = new String[1]; nameArr = new String[1]; timeArr = new String[1];}
//	}
//	public ConnectDatabase() throws SQLException {
//		String url = "jdbc:mysql://localhost:3306/testdb";
//		String user = "root";
//		String pass = "root";
//		con = DriverManager.getConnection(url, user, pass);
//		
//		int count = getComplainCount();
//		if(count>0) {complainArr = new String[count]; nameArr = new String[count]; timeArr = new String[count];}
//		else {complainArr = new String[1]; nameArr = new String[1]; timeArr = new String[1];}
//	}
//	
//	public void closeConnection() throws SQLException {
//		if(pst!=null) pst.close();
//		if(st!=null) st.close();
//		con.close();
//		
//	}
//	public void deleteStudentRecord() throws SQLException{
//		String query = "DELETE FROM admission where ID=\""+ID+"\";";
//		pst = con.prepareStatement(query);
//		pst.executeUpdate();
//	}
//	public void deleteStudentRecord(String customID) throws SQLException{
//		String query = "DELETE FROM admission where ID=\""+customID+"\";";
//		pst = con.prepareStatement(query);
//		pst.executeUpdate();
//	}
//	
//	public String getStudentName(String id) throws SQLException {
//		String query = "select NAME from admission where ID=\""+id+"\";";
//		st = con.createStatement();
//		ResultSet nameData = st.executeQuery(query);
//		if(!nameData.next()) {return "";}
////		nameData.next();
//		String name = nameData.getString(1);
//		
//		return name;
//	}
//	public String getStudentName() throws SQLException {
//		String query = "select NAME from admission where ID=\""+ID+"\";";
//		st = con.createStatement();
//		ResultSet nameData = st.executeQuery(query);
//		if(!nameData.next()) {return "";}
////		nameData.next();
//		String name = nameData.getString(1);
//		
//		return name;
//	}
//	public String getFathersName() throws SQLException {
//		String query = "select `FATHER'S NAME` from admission where ID=\""+ID+"\";";
//		st = con.createStatement();
//		ResultSet fnameData = st.executeQuery(query);
//		if(!fnameData.next()) {return "";}
////		nameData.next();
//		String fname = fnameData.getString(1);
//		
//		return fname;
//	}
//	
//	public String getStudentEdu() throws SQLException {
//		String query = "select DEPT,SEMESTER from admission where ID=\""+ID+"\";";
//		st = con.createStatement();
//		ResultSet eduData = st.executeQuery(query);
//		if(!eduData.next()) {return "";}
////		nameData.next();
//		String branch = eduData.getString(1);
//		String sem = eduData.getString(2);
//		
//		return branch+sem;
//	}
//	
//	public String getStudentMealCharge() throws SQLException {
//		String query = "select * from charge_details where ID=\""+ID+"\";";
//		st = con.createStatement();
//		ResultSet nameData = st.executeQuery(query);
//		nameData.next();
//		int charge = nameData.getInt(3);
//		
//		return String.valueOf(charge);
//	}
//	
//	public String getStudentExtraCharge() throws SQLException {
//		String query = "select * from charge_details where ID=\""+ID+"\";";
//		st = con.createStatement();
//		ResultSet nameData = st.executeQuery(query);
//		nameData.next();
//		int charge = nameData.getInt(4);
//		
//		return String.valueOf(charge);
//	}
//	public void giveStudentCharges(int meal, int other) throws SQLException {
//		int newMealChrg = Integer.valueOf(getStudentMealCharge()) - meal;
//		int newOtherChrg = Integer.valueOf(getStudentExtraCharge()) - other;
//		
//		String query = "UPDATE `charge_details` SET `MEAL_CHARGES`="+newMealChrg
//				+", `OTHER_CHARGES`="+newOtherChrg+" WHERE `ID`=\""+ID+"\";";
//		pst = con.prepareStatement(query);
//		System.out.println(pst.executeUpdate());
//	}
//	
//	public void sentComplain(String complain) throws SQLException {
//		String query = "insert into complain_box values(?, ?, CURRENT_TIMESTAMP);";
//		pst = con.prepareStatement(query);
//		pst.setString(1, ID);
//		pst.setString(2, complain);
//		System.out.println(pst.executeUpdate()+" rows effected!");
//	}
//	
//	public String[] getComplainArr() throws SQLException{
//		String query = "select MSG from complain_box order by TIMESTAMP DESC;";
//		st = con.createStatement();
//		ResultSet msgData = st.executeQuery(query);
//		if(complainArr.length<=1) { complainArr[0]="No Complains!"; return complainArr;}
//		
//		int i=0;
//		while(msgData.next()) {
//			complainArr[i] = msgData.getString(1);
//			i++;
//		}
//		
//		return complainArr;
//	}
//	
//	public String[] getcomplainerNameArr() throws SQLException{
//		String query = "select ID from complain_box order by TIMESTAMP DESC;";
//		st = con.createStatement();
//		ResultSet msgData = st.executeQuery(query);
//		if(nameArr.length<=1) { nameArr[0]="- - -"; return nameArr;}
//		
//		int i=0;
//		while(msgData.next()) {
//			nameArr[i] = getStudentName(msgData.getString(1));
//			i++;
//		}
//		
//		return nameArr;
//	}
//	
//	public String[] getComplainTimeArr() throws SQLException{
//		String query = "select TIMESTAMP from complain_box order by TIMESTAMP DESC;";
//		st = con.createStatement();
//		ResultSet msgData = st.executeQuery(query);
//		if(timeArr.length<=1) { timeArr[0]="- - -"; return timeArr;}
//		
//		int i=0;
//		while(msgData.next()) {
//			timeArr[i] = String.valueOf(msgData.getDate(1));
//			i++;
//		}
//		
//		return timeArr;
//	}
//	
//	private int getComplainCount() throws SQLException {
//		String query = "select MSG from complain_box order by TIMESTAMP DESC;";
//		st = con.createStatement();
//		ResultSet msgData = st.executeQuery(query);
//		int count=0;
//		while(msgData.next()) count++;
//		
//		return count;
//	}
//	
//	public void deleteAllFromTable(String tableName) throws SQLException {
//		pst = con.prepareStatement("DELETE FROM "+tableName+";");
//		pst.executeUpdate();
//	}
//	
//	public void updateAdminIdPass(String uname, String pass) throws SQLException {
//		deleteAllFromTable("super_login");
//		pst = con.prepareStatement("INSERT INTO super_login VALUES(?, ?);");
//		pst.setString(1, uname);
//		pst.setString(2, pass);
//		pst.executeUpdate();
//	}
//	
//	public void registerStudent(String[] data) throws SQLException {
//		String query ="INSERT INTO admission (`ID`, `NAME`, `DEPT`, `SEMESTER`, "
//				+ "`FATHER'S NAME`, `MOTHER'S NAME`, `CAST`, `ADDRESS`, `PINCODE`,"
//				+ " `DISTRICT`, `PHONE NO`, `DOB`, `BLOOD GROUP`, `Parent No`)"
//				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);" ;
//		pst = con.prepareStatement(query);
//		pst.setString(1, data[0]); 
//		pst.setString(2, data[1]); 
//		pst.setString(3, data[2]); 
//		pst.setString(4, data[3]); 
//		pst.setString(5, data[4]); 
//		pst.setString(6, data[5]); 
//		pst.setString(7, data[6]); 
//		pst.setString(8, data[7]); 
//		pst.setString(9, data[8]); 
//		pst.setString(10, data[9]);
//		pst.setString(11, data[10]);
//		pst.setString(12, data[11]);
//		pst.setString(13, data[12]);
//		pst.setString(14, data[13]);
//		
//		System.out.println(pst.executeUpdate());
//	}
//	
//	public void studentPasswordRegister(String id, String pass, String ques, String ans) throws SQLException {
//		String insertQuery = "INSERT INTO border_login (`ID`, `PASS`,`QUESTION`,`ANSWER`) values (?,?,?,?)";
//		pst = con.prepareStatement(insertQuery);
//		pst.setString(1, id);
//		pst.setString(2, pass);
//		pst.setString(3, ques);
//		pst.setString(4, ans);
//
//		pst.executeUpdate();
//	}
//	
//	public boolean signIn(String type, String userName, String password) throws SQLException {
//		//returns true if given credentials are matched, else false
//		String query = "select * from testdb."+type+" where ID='"+userName
//		+"' and PASS='"+password+"'";
//		
//		st = con.createStatement();
//		ResultSet data = st.executeQuery(query);
//		
//		return data.next();
//	}
//	
//	public String getStudentPassword(String id, String ques, String ans) throws SQLException {
//		String query = "select PASS from border_login "
//				+ "where QUESTION=\""+ques+"\" and ANSWER=\""+ans
//				+"\" and ID=\""+id+"\"";
//		st = con.createStatement();
//		ResultSet result = st.executeQuery(query);
//		if(result.next()) return result.getString(1);
//		
//		return "";
//	}
//}