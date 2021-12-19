package datavaultui;

import java.net.*;
import java.io.*;

public class DataVaultUI {
    
    private static Socket socket;
    private static OutputStream os;
    private static InputStream is;
    

    public static void connectToServer()
    {
    try
    {
    socket=new Socket("3.110.207.18",5500);
    os=socket.getOutputStream();
    is=socket.getInputStream();
    }
    catch(IOException e)
    {}
    }
    
    public static void main(String[] args) 
    {   
        connectToServer();
        new datavaultui.LoginFrame(socket, is, os).setVisible(true);
    }
    
    
}
