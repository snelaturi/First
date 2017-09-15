package com.test.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Queue;

public class ConsecutiveNos {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		int num =15;
		int count =0;
		int sum = 0;
		int j=2;
		for(int i=1;i<=(num+1)/2;i++) {
			sum = sum+i;
			if(sum == num ) {
				count++;
			}
		}
		
		System.out.println("count =" + count);
		 
		
		/*Integer num = 15;
        Queue<Integer> queue = new LinkedList<>();
        int j=1;
        int sum = 0;
        int count = 0;
        queue.add(j);
        sum = j;
        while(j<=((num+1)/2)) {
               if(sum == num){
                     count++;
                     j++;
                     System.out.println(queue.toString());
                     queue.add(j);
                     sum = sum + j;
               }else if(sum < num){
                     j++;
                     queue.add(j);
                     sum = sum + j;
               }else {
                     sum = sum - queue.poll();
               }
        }
        System.out.println("count = " + count);
*/
		
		
		// 1. load the driver class
		Class.forName("driver class");
		// 2. get the Connection obect
		Connection con = DriverManager.getConnection("", "", "");
		// 3. get the any statement
		String query = "select * from employee where empid=? and enmName=?";
		// Statement stmnt = con.createStatement();

		PreparedStatement pstmnt = con.prepareStatement(query);
		pstmnt.setInt(0, 100);

		// 4. execute the query`
		ResultSet rs = pstmnt.executeQuery(query);
		while (rs.next()) {
			// rs.get
		}

		// 5. close the connection object
		con.close();
		
		
	}

}
