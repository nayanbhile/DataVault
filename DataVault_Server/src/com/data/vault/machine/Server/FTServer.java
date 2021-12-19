
package com.data.vault.machine.Server;

import java.net.ServerSocket;
import java.net.Socket;

public class FTServer 
{
 
private ServerSocket serverSocket;
public DVModel model;

public FTServer()
{
try
{
model=new DVModel();
serverSocket=new ServerSocket(5500);
startListening();
}catch(Exception e)
{
System.out.println(e); //remove after 
}
}

private void startListening()
{
try
{
Socket socket;
RequestProcessor requestProcessor;
while(true)
{
System.out.println("Server is ready to accept request on port: 5500");
socket=serverSocket.accept();
requestProcessor=new RequestProcessor(socket, model);
}
}catch(Exception e)
{
System.out.println(e);
}
}
   
    
    
    
}
