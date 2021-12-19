package com.data.vault.machine.DAO;
import com.data.vault.machine.DTO.*;
import com.data.vault.machine.exceptions.*;
import com.data.vault.machine.interfaces.dao.*;
import com.data.vault.machine.interfaces.dto.*;
import java.util.*;
import java.sql.*;

public class userDAO implements userDAOInterface
{
public void add(userDTOInterface userDTO) throws SException
{
try
{

String loginId=userDTO.getLoginID();

Connection connection = DBConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement = connection.prepareStatement("select login_id from user_info where login_id = ?");
preparedStatement.setString(1, loginId);
ResultSet resultSet;
resultSet = preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new SException("Login ID exists : " + loginId + " exists");
}
resultSet.close();
preparedStatement.close();

preparedStatement = connection.prepareStatement("insert into user_info (login_id,password,name) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1,loginId);
preparedStatement.setString(2,userDTO.getPassword());
preparedStatement.setString(3,userDTO.getName());

preparedStatement.executeUpdate();
resultSet = preparedStatement.getGeneratedKeys();
resultSet.next();
int id = resultSet.getInt(1);
resultSet.close();
preparedStatement.close();
connection.close();
userDTO.setUserID(id);
}catch(Exception e)
{
System.out.println(e);
}
}

public void delete(int userID) throws SException
{

try
{
Connection connection = DBConnection.getConnection();
PreparedStatement preparedStatement;
ResultSet resultSet;
preparedStatement = connection.prepareStatement("select * from user_info where login_id = ?");
preparedStatement.setInt(1,userID);
resultSet = preparedStatement.executeQuery();
if(resultSet.next() == false) 
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new SException("Invalid user ID : " + userID);
}
resultSet.close();
preparedStatement.close();

preparedStatement = connection.prepareStatement("delete from user_info where user_id = ?");
preparedStatement.setInt(1,userID);
preparedStatement.executeUpdate();
connection.close();
}catch(SQLException SQLexception)
{
throw new SException(SQLexception.getMessage());
}
}

public userDTOInterface getByUserID(int userID) throws SException
{

try
{
Connection connection = DBConnection.getConnection();
PreparedStatement preparedStatement;
ResultSet resultSet;
preparedStatement = connection.prepareStatement("select * from user_info where userID = ?");
preparedStatement.setInt(1,userID);
resultSet = preparedStatement.executeQuery();
if(resultSet.next() == false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new SException("invalid userID : " + userID);
}
userDTOInterface user1;
user1=new userDTO();
user1.setUserID(userID);
user1.setLoginID(resultSet.getString("login_id").trim());
user1.setName(resultSet.getString("name").trim());
user1.setPassword(resultSet.getString("password").trim());
resultSet.close();
preparedStatement.close();
connection.close();
return user1;
}catch(SQLException SQLexception)
{
throw new SException(SQLexception.getMessage());
}
}


public userDTOInterface getByLoginID(String loginID) throws SException
{

try
{
Connection connection = DBConnection.getConnection();
PreparedStatement preparedStatement;
ResultSet resultSet;
preparedStatement = connection.prepareStatement("select * from user_info where login_id = ?");
preparedStatement.setString(1,loginID);
resultSet = preparedStatement.executeQuery();
if(resultSet.next() == false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new SException("invalid loginID : " + loginID);
}
userDTOInterface user1;
user1=new userDTO();
user1.setLoginID(loginID);
user1.setName(resultSet.getString("name").trim());
user1.setPassword(resultSet.getString("password").trim());
resultSet.close();
preparedStatement.close();
connection.close();
return user1;
}catch(SQLException SQLexception)
{
throw new SException(SQLexception.getMessage());
}
}

public boolean userIDExists(int userID) throws SException
{

try
{
Boolean exists;
Connection connection = DBConnection.getConnection();
PreparedStatement preparedStatement;
ResultSet resultSet;
preparedStatement = connection.prepareStatement("select user_id from user_info where user_id = ?");
preparedStatement.setInt(1,userID);
resultSet = preparedStatement.executeQuery();
exists = resultSet.next();
resultSet.close();
preparedStatement.close();
connection.close();
return exists;
}catch(SQLException SQLexception)
{
throw new SException(SQLexception.getMessage());
}
}

public boolean loginIDExists(String loginID) throws SException
{
System.out.println("LoginIDExists wala part chala");
try
{
Boolean exists;
Connection connection = DBConnection.getConnection();
PreparedStatement preparedStatement;
ResultSet resultSet;
System.out.println("LoginIDExists: Preparing Statement");
preparedStatement = connection.prepareStatement("select login_id from user_info where login_id = ?");
preparedStatement.setString(1,loginID);
System.out.println("LoginIDExists: Executing query");
resultSet = preparedStatement.executeQuery();
exists = resultSet.next();
System.out.println("LoginIDExists: Received result as "+exists);
resultSet.close();
preparedStatement.close();
connection.close();
return exists;
}catch(SQLException SQLexception)
{
throw new SException(SQLexception.getMessage());
}
}

public userDTOInterface[] getFriends(int userID) throws SException
{

try
{
Connection connection = DBConnection.getConnection();
PreparedStatement preparedStatement;
ResultSet resultSet;
preparedStatement = connection.prepareStatement("select count(*) from friends where friend_1 = ? OR friend_2 = ?");
preparedStatement.setInt(1,userID);
preparedStatement.setInt(2,userID);
resultSet = preparedStatement.executeQuery();
if(resultSet.next() == false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new SException("invalid userID : " + userID);
}
int num = resultSet.getInt(1);
userDTOInterface[] array = new userDTOInterface[num];
preparedStatement.close();
resultSet.close();
preparedStatement = connection.prepareStatement("SELECT CASE WHEN friend_1= user_id THEN friend_2 WHEN friend_2 = user_id THEN friend_1 END AS Friends FROM friends;");
resultSet = preparedStatement.executeQuery();
if(resultSet.next() == false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new SException("invalid userID : " + userID);
}
int i=0;
while(resultSet.next() == true){
array[i].setUserID(userID);
array[i].setLoginID(resultSet.getString("login_id").trim());
array[i].setName(resultSet.getString("name").trim());
array[i].setPassword(resultSet.getString("password").trim());
i++;
}
resultSet.close();
preparedStatement.close();
connection.close();
return array;
}catch(SQLException SQLexception)
{
throw new SException(SQLexception.getMessage());
}
}


public boolean authenticateUser(String loginID,String password) throws SException
{
try{
Connection connection = DBConnection.getConnection();
PreparedStatement preparedStatement;
ResultSet resultSet;
preparedStatement = connection.prepareStatement("select login_id from user_info where login_id = ?");
preparedStatement.setString(1,loginID);
resultSet = preparedStatement.executeQuery();
if(resultSet.next() == false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new SException("invalid loginID : " + loginID);
}
resultSet.close();
preparedStatement.close();
preparedStatement = connection.prepareStatement("select password from user_info where login_id = ?");
preparedStatement.setString(1,loginID);
resultSet = preparedStatement.executeQuery();
String dbPassword=resultSet.getString("password").trim();
if(dbPassword==password) return true;
}catch(SQLException e)
{
e.printStackTrace();
}
return false;
}

public int getCount() throws SException
{
try
{
Connection connection = DBConnection.getConnection();
Statement statement;
ResultSet resultSet;
statement = connection.createStatement();
resultSet = statement.executeQuery("select count(*) as cnt from user_info");
resultSet.next();
int count = resultSet.getInt("count");
resultSet.close();
statement.close();
connection.close();
return count;
}catch(SQLException SQLexception)
{
throw new SException(SQLexception.getMessage());
}
}

public boolean isFrndActive(int userID) throws SException
{

try
{
Connection connection = DBConnection.getConnection();
PreparedStatement preparedStatement;
ResultSet resultSet;
preparedStatement = connection.prepareStatement("select * from activity where user_id = ?");
preparedStatement.setInt(1,userID);
resultSet = preparedStatement.executeQuery();
if(resultSet.next() == false)
{
resultSet.close();
preparedStatement.close();
connection.close();
return false;
}
resultSet.close();
preparedStatement.close();
connection.close();
return true;
}catch(SQLException SQLexception)
{
throw new SException(SQLexception.getMessage());
}
}

public String getReceiverIP(int userID) throws SException
{

try
{
Connection connection = DBConnection.getConnection();
PreparedStatement preparedStatement;
ResultSet resultSet;
preparedStatement = connection.prepareStatement("select ip_address from activity where user_id = ?");
preparedStatement.setInt(1,userID);
resultSet = preparedStatement.executeQuery();
if(resultSet.next() == false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new SException("invalid userID : " + userID);
}
String ip = resultSet.getString(1);
resultSet.close();
preparedStatement.close();
connection.close();
return ip;
}catch(SQLException SQLexception)
{
throw new SException(SQLexception.getMessage());
}
}

}