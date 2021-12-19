package com.data.vault.machine.interfaces.dto;
import java.util.*;

public interface userDTOInterface extends Comparable<userDTOInterface>,java.io.Serializable 
{
public int getUserID();
public void setUserID(int userID);

public void setLoginID(String loginID);
public String getLoginID();

public void setPassword(String password);
public String getPassword();

public void setIPAddress(String IP);
public String getIPAddress();

public void setName(String name);
public String getName();

public void setFrnList(List<String> frnds);
public List<String> getFrnList();



}