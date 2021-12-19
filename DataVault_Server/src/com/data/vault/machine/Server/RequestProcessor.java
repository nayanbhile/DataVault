/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.vault.machine.Server;

import com.data.vault.machine.DAO.*;
import com.data.vault.machine.DTO.*;
import com.data.vault.machine.interfaces.dao.*;
import com.data.vault.machine.interfaces.dto.*;
import java.io.*;
import java.net.*;

public class RequestProcessor extends Thread 
{
 
    
    
    
private Socket socket;
String loginID;
InputStream is;
OutputStream os;


public DVModel model;

RequestProcessor(Socket socket, DVModel model)
{
    try
    {
        this.socket=socket;
        this.is=this.socket.getInputStream();
        this.os=this.socket.getOutputStream();
        this.model=model;
        start();
    }
    catch(IOException e)
    {
        System.out.println(e.getMessage());
    }
}
public void run()
{
try
{
// NEW CLIENT TRIES TO CONNECT
    


int bytesToReceive=0;
byte tmp[];
byte header[];
byte ack[];

int bytesReadCount=0;
int i,j,k;
i=0;
j=0;
    
int userID=-1;
String IPAddress="";
userDAOInterface userDAO=new userDAO();
userDTOInterface userDTO;
        

String actionHeader="";

while(!actionHeader.equals("Logout"))
{
    //System.out.println("While loop chalaaaaaaaaaaaaaaaaaaaaa");
    
    i=0;
    j=0;
    bytesToReceive=20;
    tmp=new byte[bytesToReceive];
    header=new byte[bytesToReceive];
    while(j<bytesToReceive)
    {
    System.out.println("Waiting for Action Header");
    bytesReadCount=this.is.read(tmp);
    System.out.println("Bytes read count: "+bytesReadCount);
    System.out.println("TMP: "+tmp);
    
    if(bytesReadCount==-1) continue;
    for(k=0;k<bytesReadCount;k++)
    {
    header[i]=tmp[k];
    //System.out.println("i: "+i+"----------"+header[i]);
    i++;
    }
    //System.out.println("J: "+j+"----------");

    j+=bytesReadCount;
    }
    
    //System.out.println("For loop ended./......");
    
    i=0;
    StringBuffer sb=new StringBuffer();
    while(i<bytesReadCount)
    {
    sb.append((char)header[i]);
    //System.out.println("i: "+i+"----------"+(char)header[i]);
    i++;
    }
    actionHeader=sb.toString().trim();
    System.out.println("Action Received: "+actionHeader);
    
    if(actionHeader.equals("Login"))
    {
        String password;
        
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();
        
        // START RECEIVING DETAILS OF THE USER FROM CLIENT
        // loginID receiving....
        i=0;
        j=0;
        bytesToReceive=60;
        tmp=new byte[bytesToReceive];
        header=new byte[bytesToReceive];
        while(j<bytesToReceive)
        {
        bytesReadCount=this.is.read(tmp);
        if(bytesReadCount==-1) continue;
        for(k=0;k<bytesReadCount;k++)
        {
        header[i]=tmp[k];
        i++;
        }
        j+=bytesReadCount;
        }
        i=0;
        sb=new StringBuffer();
        while(i<bytesToReceive)
        {
        sb.append((char)header[i]);
        i++;
        }
        this.loginID=sb.toString().trim();
        System.out.println("LoginID Received: "+this.loginID);
        
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();
        
        // PASSWORD RECEIVING
        i=0;
        j=0;
        bytesToReceive=60;
        tmp=new byte[bytesToReceive];
        header=new byte[bytesToReceive];
        while(j<bytesToReceive)
        {
        bytesReadCount=this.is.read(tmp);
        if(bytesReadCount==-1) continue;
        for(k=0;k<bytesReadCount;k++)
        {
        header[i]=tmp[k];
        i++;
        }
        j+=bytesReadCount;
        }
        i=0;
        sb=new StringBuffer();
        while(i<bytesToReceive)
        {
        sb.append((char)header[i]);
        i++;
        }
        password=sb.toString().trim();
        System.out.println("Password Received: "+password);
        
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();
        
        
        boolean result;
        //result=userDAO.authenticateUser(this.loginID,password);
        
        result=this.model.userExists(this.loginID);
        
        if(result)
        {
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();
        
        
        /*
        // SEND BACK FRIEND LIST 
        userDTO=userDAO.getByLoginID(this.loginID);
        userDTOInterface[] friendList=userDAO.getFriends(userDTO.getUserID());
        int totalFriends= friendList.length;
        
        // sending back size of friend list
        
        tmp=new byte[10];
        i=0;
        k=totalFriends;
        while(k>0)
        {
        tmp[i]=(byte)(k%10);
        k=k/10;
        i++;
        }
        while(i<60)
        {
        header[i]=(byte)32;
        i++;
        }
        this.os.write(tmp,0,60);
        this.os.flush();
        // size of friendlist sent
        ack=new byte[1];
        this.is.read(ack);
        // received acknowledgement
        // SENDING FRIENDS' DATA ONE BY ONE IN THE LOOOP
        int z=0;
        int r=0;
        String tmpLoginID,tmpName;
        while(z<totalFriends)
        {
            tmp=new byte[120];
            tmpLoginID=friendList[i].getLoginID();
            tmpName=friendList[i].getName();
            i=0;
            k=tmpName.length();
            r=0;
            while(r<k)
            {
            tmp[i]=(byte)tmpName.charAt(r);
            i++;
            r++;
            }
            tmp[i]=(byte)',';
            i++;
            k=tmpLoginID.length();
            r=0;
            while(r<k)
            {
            tmp[i]=(byte)tmpName.charAt(r);
            i++;
            r++;
            }
            while(i<120)
            {
            tmp[i]=(byte)32;
            i++;
            }
            this.os.write(tmp,0,120);
            this.os.flush();
            ack=new byte[1];
            this.is.read(ack);
            // data of one friend sent
            z++;
        }
        // DATA OF FRIEND LIST SENT
        */
        
        }
        else
        {
        ack=new byte[1];
        ack[0]=0;
        this.os.write(ack,0,1);
        this.os.flush();
        }
        // SERVER SENT BACK TO LISTENING FOR ACTION HEADER

        actionHeader="";
    }
    if(actionHeader.equals("Register"))
    {
        System.out.println("Register part got executed...");
        
        String password;
        String name;
        
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();
        
        System.out.println("ACK Sent");
        
        // START RECEIVING DETAILS OF THE NEW USER FROM CLIENT
        // loginID receiving....
        i=0;
        j=0;
        bytesToReceive=60;
        tmp=new byte[bytesToReceive];
        header=new byte[bytesToReceive];
        while(j<bytesToReceive)
        {
        bytesReadCount=this.is.read(tmp);
        System.out.println("Login ID ehile loop challlllllllllaaaaaaaaaa: bytes read count- "+bytesReadCount);
        if(bytesReadCount==-1) continue;
        for(k=0;k<bytesReadCount;k++)
        {
        header[i]=tmp[k];
        System.out.println("i-> "+i+"   Header(i)-> "+header[i]);
        i++;
        }
        j+=bytesReadCount;
        }
        i=0;
        sb=new StringBuffer();
        while(i<bytesToReceive)
        {
        sb.append((char)header[i]);
        System.out.println(i+". Header appended to StringBuffer-> "+(char)header[i]);
        i++;
        }
        loginID=sb.toString().trim();
        System.out.println("LoginID Received: "+loginID);
        
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();
        
        // PASSWORD RECEIVING
        i=0;
        j=0;
        bytesToReceive=60;
        tmp=new byte[bytesToReceive];
        header=new byte[bytesToReceive];
        while(j<bytesToReceive)
        {
        bytesReadCount=this.is.read(tmp);
        if(bytesReadCount==-1) continue;
        for(k=0;k<bytesReadCount;k++)
        {
        header[i]=tmp[k];
        i++;
        }
        j+=bytesReadCount;
        }
        i=0;
        sb=new StringBuffer();
        while(i<bytesToReceive)
        {
        sb.append((char)header[i]);
        i++;
        }
        password=sb.toString().trim();
        System.out.println("Password Received: "+password);
        
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();
        
        // RECEIVING THE NAME OF THE USER
        i=0;
        j=0;
        bytesToReceive=60;
        tmp=new byte[bytesToReceive];
        header=new byte[bytesToReceive];
        while(j<bytesToReceive)
        {
        bytesReadCount=this.is.read(tmp);
        if(bytesReadCount==-1) continue;
        for(k=0;k<bytesReadCount;k++)
        {
        header[i]=tmp[k];
        i++;
        }
        j+=bytesReadCount;
        }
        i=0;
        sb=new StringBuffer();
        while(i<bytesToReceive)
        {
        sb.append((char)header[i]);
        i++;
        }
        name=sb.toString().trim();
        System.out.println("Name Received: "+name);
        
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();
        // NAME RECEIVED
        // ALL DETAILS ARE RECEIVED
        
        
        
        if(false) // userDAO.loginIDExists(loginID)
        {
            ack=new byte[1];
            ack[0]=0;
            this.os.write(ack,0,1);
            this.os.flush();
        }
        else
        {
            
            // ADDING THE USER TO THE DATABASE
            
            userDTO newUser=new userDTO();
            newUser.setLoginID(loginID);
            newUser.setPassword(password);
            newUser.setName(name);
            
            this.model.addUser(newUser);
            
            // userDAO.add(newUser);
            
            ack=new byte[1];
            ack[0]=1;
            this.os.write(ack,0,1);
            this.os.flush();
        }
        actionHeader="";
    }
    
    if(actionHeader=="Send Message")
    {
        
        
        
        actionHeader="";
    }
    
    if(actionHeader=="Receive Message")
    {
        
        
        
        
        actionHeader="";    
    }
    
    if(actionHeader.equals("Send Data"))
    {
        System.out.println("Send Data part got executed...");
        
        String receiverID, fileName;
        int fileLength;
        
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();
        
        System.out.println("ACK Sent");
        
        // START RECEIVING FILE ATTRIBUTES OF DataDTO
        
        // Receiver ID receiving....
        i=0;
        j=0;
        bytesToReceive=60;
        tmp=new byte[bytesToReceive];
        header=new byte[bytesToReceive];
        while(j<bytesToReceive)
        {
        bytesReadCount=this.is.read(tmp);
        if(bytesReadCount==-1) continue;
        for(k=0;k<bytesReadCount;k++)
        {
        header[i]=tmp[k];
        i++;
        }
        j+=bytesReadCount;
        }
        i=0;
        sb=new StringBuffer();
        while(i<bytesToReceive)
        {
        sb.append((char)header[i]);
        i++;
        }
        receiverID=sb.toString().trim();
        System.out.println("Sender's ID Received: "+receiverID);
        
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();
        
        // File name receiving....
        i=0;
        j=0;
        bytesToReceive=60;
        tmp=new byte[bytesToReceive];
        header=new byte[bytesToReceive];
        while(j<bytesToReceive)
        {
        bytesReadCount=this.is.read(tmp);
        if(bytesReadCount==-1) continue;
        for(k=0;k<bytesReadCount;k++)
        {
        header[i]=tmp[k];
        i++;
        }
        j+=bytesReadCount;
        }
        i=0;
        sb=new StringBuffer();
        while(i<bytesToReceive)
        {
        sb.append((char)header[i]);
        i++;
        }
        fileName=sb.toString().trim();
        System.out.println("File Name Received: "+fileName);
        
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();
        
        // File Length receiving....
        i=0;
        j=0;
        bytesToReceive=60;
        tmp=new byte[bytesToReceive];
        header=new byte[bytesToReceive];
        while(j<bytesToReceive)
        {
        bytesReadCount=this.is.read(tmp);
        if(bytesReadCount==-1) continue;
        for(k=0;k<bytesReadCount;k++)
        {
        header[i]=tmp[k];
        i++;
        }
        j+=bytesReadCount;
        }
        i=0;
        sb=new StringBuffer();
        while(i<bytesToReceive)
        {
        sb.append((char)header[i]);
        i++;
        }
        fileLength=Integer.valueOf(sb.toString().trim());
        System.out.println("File Length Received: "+fileLength);
        
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();
        
        System.out.println("Preparing DataDTO Object for the file");
        
        int fileID=this.model.lastGeneratedDataID++;
        System.out.println("File Data received: \nFileID: "+fileID+"\nSender Name: "+this.loginID+"\nReceiver Name: "+receiverID+"\nFile Length: "+fileLength);
        DataDTO data= new DataDTO(String.valueOf(fileID), this.loginID, receiverID, fileName, fileLength);
        System.out.println("Preparing to receive file");
        
        Boolean response=this.receiveFile(fileLength,fileID);
        if(response)
        {
            this.model.dataPendingList.add(data);
            System.out.println("File received at the server zzzzzzzzz");
        }
        else
        {
            System.out.println("Error receiving file");
        }
        
        
        
        actionHeader="";
    }
    
    if(actionHeader.equals("Receive Data"))
    {
        System.out.println("Receive Data part got executed...");
        
        String fileName;
        double fileLength;
        String fileID;
        
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();
        
        System.out.println("ACK Sent");
        
        DataDTO dataDTO= this.model.getDataByReceiverID(this.loginID);
        if(dataDTO==null) 
        {
            ack=new byte[1];
            ack[0]=0;
            this.os.write(ack,0,1);
            this.os.flush();
            actionHeader="";
            continue;
        }
        
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();

        fileName=dataDTO.getFileName();
        fileLength=dataDTO.getFileLength();
        fileID= dataDTO.getDataID();
        
        Boolean response;
        response= sendString(60,fileName);
        if(response==true) System.out.println("File Name Sent: "+fileName);
        else 
        {
            actionHeader="";
            continue;
        }
        
        response= sendString(60,String.valueOf(fileLength));
        if(response==true) System.out.println("File Length Sent: "+fileLength);
        if(!response)
        {
            actionHeader="";
            continue;
        }
        
        System.out.println("Preparing the file to be sent");
        
        File f= new File(fileID+".dvf");
        response= this.sendFile(fileLength,f);
        if(response)
        {
            String msg = "File sent! \nFile name: "+f.getName()+"\nFile length: "+f.length();
            System.out.println(msg);
            this.model.removeFromDataPendingList(dataDTO);
            actionHeader="";
            return;
        }
        
        actionHeader="";
    
    }
    
    if(actionHeader.equals("Logout"))
    {
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();
    }
}




/*
while(true)
{
while(j<bytesToReceive)
{
bytesReadCount=this.is.read(tmp);
if(bytesReadCount==-1) continue;
for(k=0;k<bytesReadCount;k++)
{
header[i]=tmp[k];
i++;
}
j+=bytesReadCount;
}
bytesReadCount=0;
int numberOfChunks=0;
i=0;
j=1;
while(header[i]!=',')
{
numberOfChunks+=(header[i]*j);
j=j*10;
i++;
bytesReadCount++;
}
int sizeOfChunks=0;
i=0;
j=1;
while(header[i]!=',')
{
sizeOfChunks+=(header[i]*j);
j=j*10;
i++;
bytesReadCount++;
}
int reciverId=0;
i=0;
j=1;
while(header[i]!=',')
{
reciverId+=(header[i]*j);
j=j*10;
i++;
bytesReadCount++;
}
sb=new StringBuffer();
while(i<=1023-bytesReadCount)
{
sb.append((char)header[i]);
i++;
}
String fileName=sb.toString().trim();
System.out.println("Reciving file : "+fileName+", receiver ID : "+reciverId);

bytesToReceive=(numberOfChunks*sizeOfChunks)+numberOfChunks-1;
byte bytes[]=new byte[bytesToReceive];
while(j<bytesToReceive)
{
bytesReadCount=this.is.read(tmp);
if(bytesReadCount==-1) continue;
for(k=0;k<bytesReadCount;k++)
{
bytes[i]=tmp[k];
i++;
}
j+=bytesReadCount;
}
boolean isActive=userDAO.isFrndActive(reciverId);
String reciverIP=userDAO.getReceiverIP(reciverId);
if(isActive)
{

for(int l=0;l<numberOfChunks-1;l++)
{

this.os.write(bytes,l*sizeOfChunks,sizeOfChunks*l+sizeOfChunks);
this.os.flush();

}
}





byte ack[]=new byte[1];
ack[0]=1;
this.os.write(ack,0,1);
this.os.flush();
int chunkSize=4096;
bytes=new byte[chunkSize];
i=0;
long m;
m=0;
while(m<bytesToReceive)
{
bytesReadCount=this.is.read(bytes);
if(bytesReadCount==-1) continue;
this.os.write(bytes,0,bytesReadCount);
this.os.flush();
m+=bytesReadCount;
}

this.os.close();
}
*/
}catch(Exception e)
{}
}    
    private Boolean receiveFile(double lengthOfFile, int fileID)
    {
        try
        {
            int bytesReadCount=0;
         //   System.out.println("Saving file location: "+this.model.fileSource+String.valueOf(fileID));
            File file=new File(String.valueOf(fileID)+".dvf");
            if(file.exists()) file.delete();
            FileOutputStream fos=new FileOutputStream(file);
            byte ack[]=new byte[1];
            ack[0]=1;
            int chunkSize=16384;
            byte bytes[]=new byte[chunkSize];
            int i=0;
            long m;
            m=0;
            System.out.println("Just before the while loop");
            while(m<lengthOfFile)
            {
            bytesReadCount=this.is.read(bytes);
            if(bytesReadCount==-1) continue;
            System.out.println(m+"--------"+bytesReadCount);
            fos.write(bytes,0,bytesReadCount);
            fos.flush();
            m+=bytesReadCount;
            }
            System.out.println("While looop ended");
            fos.close();
            
            if(file.length()==lengthOfFile)
            {
                System.out.println("Success");
                this.sendAck(1);
                System.out.println("ACK Sent");
                return true;
            }
            else
            {
                System.out.println("Failed");
                this.sendAck(0);
                System.out.println("ACK Sent");
                return false;
            }
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
         return false;
    }
    
    private Boolean sendFile(double fileLength, File f)
    {
        Boolean response;
        try
        {
        System.out.println("Send file me aayaaaaaa");
        FileInputStream fis=new FileInputStream(f);
        int chunkSize=16384;
        int bytesReadCount=0;
        byte bytes[]=new byte[chunkSize];
        int j=0;
        System.out.println("Just before file sending loop");
        while(j<fileLength)
        {
        bytesReadCount=fis.read(bytes);
        System.out.println(j+"--------"+bytesReadCount);
        this.os.write(bytes,0,bytesReadCount);
        this.os.flush();
        j+=bytesReadCount;
        System.out.println("Remaining: "+(fileLength-j));
        System.out.println(j+"--------"+bytesReadCount);
        }
        System.out.println("While loop ended");
        fis.close();
        response=this.receiveAck();
        return response;
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    private void sendAck(int ack)
    {
        try
        {
        byte tmp[]=new byte[1];
        tmp[0]=(byte)ack;
        this.os.write(tmp,0,1);
        this.os.flush();
        
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    private Boolean receiveAck()
    {
        try
        {
        //System.out.println("Receive ack got executed...");
        byte tmp[]=new byte[1];
        this.is.read(tmp);
        //System.out.println("TMP at receiving ACK: "+tmp[0]);
        if(tmp[0]==1) return true;
        else return false;
        }
        catch(IOException e){}
        return false;
    }
    
    private Boolean sendString(int totalBytesToSend, String dataToSend)
    {
        System.out.println("Sending String: "+dataToSend);

        try
        {
        byte tmp[]=new byte[totalBytesToSend];
        byte ack[]=new byte[1];
        int i=0;
        int k=dataToSend.length();
        int r=0;
        while(r<k)
        {
        tmp[i]=(byte)dataToSend.charAt(r);
        i++;
        r++;
        }
        while(i<totalBytesToSend)
        {
        tmp[i]=(byte)32;
        i++;
        }
        this.os.write(tmp,0,totalBytesToSend);
        this.os.flush();
        
        System.out.println("Sent String: "+dataToSend);
        
        ack=new byte[1];
        this.is.read(ack);
        
        System.out.println("Ack for sending string received as "+ack[0]);
        
        if(ack[0]==1)
        {
            System.out.println("Returning True for ACK");
            return true;
        }
        else
        {
            System.out.println("Returning false for ACK");
            return false;
        }
        
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        return false; 
    }
    
}
