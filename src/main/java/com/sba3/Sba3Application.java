package com.sba3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sba3.model.Customer;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class Sba3Application {

	public static void main(String[] args) {
		SpringApplication.run(Sba3Application.class, args);
	}
	@RequestMapping(value="/getCustomers", method=RequestMethod.GET)
	public List<Customer> getUsers(){
	List<Customer> user=new ArrayList<>();
		try
	    {
	      // create our mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/sba3?useSSL=false";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "admin");
	      
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM customers";

	      // create the java statement
	      Statement st = conn.createStatement();
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      
	      // iterate through the java resultset
	      while (rs.next())
	      {
	        int id = rs.getInt("id");
	        String name = rs.getString("name");
	        String doj = rs.getString("doj");
	        String city = rs.getString("city");
	        String contact=rs.getString("contact");
	        
	        // print the results
	       user.add(new Customer(id,name,doj,city,contact));
	        System.out.format("%d, %s, %s, %s,%s\n", id,name,doj,city,contact);
	      }
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
		return user;
	}
	}