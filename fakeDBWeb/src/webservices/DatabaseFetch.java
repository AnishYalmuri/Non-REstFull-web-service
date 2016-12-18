package webservices;

import java.sql.*;
import java.sql.DriverManager;

public class DatabaseFetch {
	
	public String findSailorRecordInDB(String sailorInfo){
		String sailorDetails="";
		//String[] sailorInfoArray=sailorInfo.split("%");
		try{
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/sailboat","root","anishys91");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  
		//sailorDetails+=getQueryWhereCondition(sailorInfo);
		ResultSet rs=stmt.executeQuery("select * from SailorDetails where "+getQueryWhereCondition(sailorInfo) );  
		while(rs.next())  
		sailorDetails+=rs.getString(3)+"- "+rs.getString(2)+"-"+rs.getString(4)+"-"+rs.getInt(5)+"-"+rs.getInt(6)+"-"+
		rs.getString(8)+"-"+rs.getString(7)+"-"+rs.getString(9)+"&";  
		con.close();  
		}catch(Exception e){ System.out.println(e);} 
		return sailorDetails;
	}
	
	public String getQueryWhereCondition(String sailorInfo){
		String query="";
		String[] sailorInfoArray=sailorInfo.split("%");
		if(!sailorInfoArray[0].equals(""))
			query+="FirstName='"+sailorInfoArray[0]+"' and ";
		if(!sailorInfoArray[1].equals(""))
			query+="LastName='"+sailorInfoArray[1]+"' and ";
		if(!sailorInfoArray[2].equals(""))
			query+="BoatType='"+sailorInfoArray[2]+"' and ";
		if(!sailorInfoArray[3].equals(""))
			query+="BoatLength='"+sailorInfoArray[3]+"' and ";
		if(!sailorInfoArray[4].equals(""))
			query+="BuildYear='"+sailorInfoArray[4]+"' and ";
		if(!sailorInfoArray[5].equals(""))
			query+="MotorType='"+sailorInfoArray[5]+"' and ";
		if(!sailorInfoArray[6].equals(""))
			query+="slipFeePaid='"+sailorInfoArray[6]+"' and ";
		/*if(sailorInfoArray[7]!="")
			query+="MooredSlip='"+sailorInfoArray[7]+"' and";*/
		query=query.substring(0,query.length()-4);
		System.out.println("query"+query);
		//query+=sailorInfoArray[0]+sailorInfoArray[1]+sailorInfoArray[2]+sailorInfoArray[3]+sailorInfoArray[4]+
			//	sailorInfoArray[5]+sailorInfoArray[6]+sailorInfoArray[6];
		return query;
	}

}
