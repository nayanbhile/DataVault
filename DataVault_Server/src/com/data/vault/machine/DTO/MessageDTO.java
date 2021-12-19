
package com.data.vault.machine.DTO;


public class MessageDTO 
{
    private String message;
    private String senderID;
    private String receiverID;
    
    public MessageDTO()
    {
    message="";
    senderID="";
    receiverID="";
    }
    
    public void setMessage(String message)
    {
        this.message=message;
    }
    public String getMessage()
    {
        return this.message;
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
