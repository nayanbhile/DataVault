
package com.data.vault.machine.Server;

import com.data.vault.machine.DAO.*;
import com.data.vault.machine.DTO.*;
import com.data.vault.machine.interfaces.dao.*;
import com.data.vault.machine.interfaces.dto.*;
import java.io.*;
import java.net.*;
import java.util.*;


public class DVModel 
{
    List<userDTOInterface> userList;
    List<String> activeUserIDList;
    List<MessageDTO> messagePendingList;
    List<DataDTO> dataPendingList;
    
    String fileSource=System.getProperty("user.dir")+File.separator+"store"+File.separator;
    
    int lastGeneratedDataID, lastGeneratedMessageID;
    
    public DVModel()
    {
        this.userList=new ArrayList<>();
        this.activeUserIDList=new ArrayList<>();
        this.messagePendingList=new ArrayList<>();
        this.dataPendingList=new ArrayList<>();
        
        this.lastGeneratedDataID=10001;
        this.lastGeneratedMessageID=1000001;
    }
    
    public void addUser(userDTOInterface user)
    {
        if(!this.userExists(user)) this.userList.add(user);
    }
    
    
    public void removeUserByID(String loginID)
    {
        int x=0;
        int listLength=this.userList.size();
        while(x<listLength)
        {
            if(this.userList.get(x).getLoginID().equals(loginID)) this.userList.remove(x) ;
            x++;
        }
        
    }
    
    public Boolean userExists(String loginID)
    {
        int x=0;
        int listLength=this.userList.size();
        while(x<listLength)
        {
            if(this.userList.get(x).getLoginID().equals(loginID)) return true;
            x++;
        }
        return false;
    }
    
    public Boolean userExists(userDTOInterface user)
    {
        int x=0;
        int listLength=this.userList.size();
        while(x<listLength)
        {
            if(this.userList.get(x).getLoginID().equals(user.getLoginID())) return true;
            x++;
        }
        return false;
    }
    
    public userDTOInterface getUserByID(String loginID)
    {
        int x=0;
        int listLength=this.userList.size();
        while(x<listLength)
        {
            if(this.userList.get(x).getLoginID().equals(loginID)) return this.userList.get(x);
            x++;
        }
        return null;
    }
    
    public void addActiveUser(String userLoginID)
    {
        
    }
    
    public void removeActiveUser(String userLoginID)
    {
        
    }
    
    public Boolean isUserActive(String userLoginID)
    {
        int x=0;
        int listLength=this.activeUserIDList.size();
        while(x<listLength)
        {
            if(this.activeUserIDList.get(x).equals(userLoginID)) return true;
            x++;
        }
        return false;
    }
    
    public void addToDataPendingList(DataDTO data)
    {
        this.dataPendingList.add(data);
    }
    
    public void removeFromDataPendingList(int index)
    {
        this.dataPendingList.remove(index);
    }
    
    public void removeFromDataPendingList(DataDTO data)
    {
        this.dataPendingList.remove(data);
    }
    
    public DataDTO getDataByReceiverID(String receiverID)
    {
        int x=0;
        int listLength=this.dataPendingList.size();
        if(listLength==0) return null;
        while(x<listLength)
        {
            if(this.dataPendingList.get(x).getReceiverID().equals(receiverID)) return this.dataPendingList.get(x);
            x++;
        }
        return null;
    }
    
    
    public DataDTO getUserData(String userLoginID)
    {
        int x=0;
        int listLength=this.dataPendingList.size();
        
        
        
        return null;
    }
}
