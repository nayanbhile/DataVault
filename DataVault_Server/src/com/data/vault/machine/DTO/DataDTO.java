
package com.data.vault.machine.DTO;


public class DataDTO 
{
    private String dataID;
    private String senderID;
    private String receiverID;
    private String fileName;
    public double fileLength;
    
    public DataDTO()
    {
    this.dataID="";
    this.senderID="";
    this.receiverID="";
    this.fileName="";
    this.fileLength=0;
    }
    
    public DataDTO(String dataID, String senderID, String receiverID, String fileName, int fileLength)
    {
    this.dataID=dataID;
    this.senderID=senderID;
    this.receiverID=receiverID;
    this.fileLength=fileLength;
    this.fileName=fileName;
    }
    
    public void setDataID(String dataID)
    {
        this.dataID=dataID;
    }
    public String getDataID()
    {
        return this.dataID;
    }
    
    public void setFileLength(double length)
    {
        this.fileLength=length;
    }
    
    public double getFileLength()
    {
        return this.fileLength;
    }
    
    public void setFileName(String name)
    {
        this.fileName=name;
    }
    
    public String getFileName()
    {
        return this.fileName;
    }
    
    public void setSenderID(String senderID)
    {
        this.senderID=senderID;
    }
    public String getSenderID()
    {
        return this.senderID;
    }
    
    public void setReceiverID(String receiverID)
    {
        this.receiverID=receiverID;
    }
    public String getReceiverID()
    {
        return this.receiverID;
    }
    
}
