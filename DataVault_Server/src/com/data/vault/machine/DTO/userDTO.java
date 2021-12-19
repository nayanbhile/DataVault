package com.data.vault.machine.DTO;
import com.data.vault.machine.interfaces.dto.*;
import java.util.*;

public class userDTO implements userDTOInterface
{
int userID;
String loginID;
String password;
String IPAddress;
String name;
List<String> frnds;

public userDTO()
{
this.userID=-1;
this.loginID="";
this.password="";
this.IPAddress="";
this.name="";
this.frnds=new LinkedList<>();
}

public void setUserID(int userID)
{
this.userID=userID;
}
public int getUserID()
{
return this.userID;
}


public void setLoginID(String loginID)
{
this.loginID=loginID;
}
public String getLoginID()
{
return this.loginID;
}

public void setPassword(String password)
{
this.password=password;
}
public String getPassword()
{
return this.password;
}

public void setIPAddress(String IP)
{
this.IPAddress=IP;
}
public String getIPAddress()
{
return this.IPAddress;
}

public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}

public void setFrnList(List<String> frnds)
{
for(int i=0;i<frnds.size();i++)
{
this.frnds.add(frnds.get(i));
}
}
public List<String> getFrnList()
{
return this.frnds;
}

public int hashCode()
{
return this.userID;
}
public int compareTo(userDTOInterface user)
{
return this.userID-user.getUserID();
}

}