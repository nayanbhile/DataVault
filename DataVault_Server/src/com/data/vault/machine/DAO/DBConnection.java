package com.data.vault.machine.DAO;
import com.data.vault.machine.exceptions.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
private DBConnection(){}
public static Connection getConnection() throws SException
{
Connection connection = null;
try
{
System.out.println("DBConnection: Connecting...");
Class.forName("com.mysql.cj.jdbc.Driver");
System.out.println("DBConnection: Getting connection");
connection = DriverManager.getConnection("jdbc:mysql://3.110.207.18:3306/test","root","Gaurav28@");
System.out.println("DBConnection: Connected"+connection);
}catch(ClassNotFoundException | SQLException exception)
{
throw new SException(exception.getMessage());
}
return connection;
}//method ends
}//class ends