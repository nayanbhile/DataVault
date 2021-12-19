
package datavaultui;

import java.net.*;
import java.io.*;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class MainFrame extends javax.swing.JFrame 
{
    
    Socket socket;
    InputStream is;
    OutputStream os;
    String receivingUserID="sajal";
    
    public MainFrame() {
        initComponents();
    }
    
    public MainFrame(Socket socket, InputStream is, OutputStream os) 
    {
        this.socket=socket;
        this.is=is;
        this.os=os;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainNavPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        mainNavBGIcon = new javax.swing.JLabel();
        mainSidePanel = new javax.swing.JPanel();
        mainUsersLabel = new javax.swing.JLabel();
        mainSearchUserTextField = new javax.swing.JTextField();
        mainSearchUserButton = new javax.swing.JButton();
        mainSidePanelSeparator = new javax.swing.JSeparator();
        mainChatPanel = new javax.swing.JPanel();
        mainChattingFriendLabel = new javax.swing.JLabel();
        mainSendMessageTextField = new javax.swing.JTextField();
        mainSendMessageButton = new javax.swing.JButton();
        mainChatSeparator = new javax.swing.JSeparator();
        mainRecieveFileButton = new javax.swing.JButton();
        mainRecievedFilePathTextField = new javax.swing.JTextField();
        mainProgressBarStatusLabel = new javax.swing.JLabel();
        mainSendFileButton = new javax.swing.JButton();
        mainSelectFilePathTextField = new javax.swing.JTextField();
        mainSeparator = new javax.swing.JSeparator();
        mainBottomPanel = new javax.swing.JPanel();
        mainSelectFilePathButton = new javax.swing.JButton();
        mainSaveFilePathButton = new javax.swing.JButton();
        mainProgressBar = new javax.swing.JProgressBar();
        mainBGIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainNavPanel.setBackground(new java.awt.Color(204, 255, 51));
        mainNavPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(22, 24, 24));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-add-friend-64.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setOpaque(false);
        mainNavPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 80, 70));

        logoutButton.setBackground(new java.awt.Color(22, 24, 24));
        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-logout-58.png"))); // NOI18N
        logoutButton.setBorder(null);
        logoutButton.setOpaque(false);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        mainNavPanel.add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 70));

        mainNavBGIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/NavBG.png"))); // NOI18N
        mainNavBGIcon.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 102), null));
        mainNavPanel.add(mainNavBGIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        getContentPane().add(mainNavPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mainSidePanel.setBackground(new java.awt.Color(0, 102, 153));
        mainSidePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 102), null));
        mainSidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainUsersLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        mainUsersLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainUsersLabel.setText("USERS");
        mainSidePanel.add(mainUsersLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, 150, 31));

        mainSearchUserTextField.setBackground(new java.awt.Color(0, 51, 102));
        mainSearchUserTextField.setForeground(new java.awt.Color(204, 204, 204));
        mainSearchUserTextField.setText("Search here ...");
        mainSearchUserTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 102), new java.awt.Color(153, 153, 153)));
        mainSearchUserTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainSearchUserTextFieldActionPerformed(evt);
            }
        });
        mainSidePanel.add(mainSearchUserTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, -1));

        mainSearchUserButton.setBackground(new java.awt.Color(22, 24, 24));
        mainSearchUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-search-24.png"))); // NOI18N
        mainSearchUserButton.setBorder(null);
        mainSearchUserButton.setOpaque(false);
        mainSidePanel.add(mainSearchUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 30, 20));
        mainSidePanel.add(mainSidePanelSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 230, 10));

        getContentPane().add(mainSidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 230, 460));

        mainChatPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainChatPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 153), new java.awt.Color(153, 153, 153)));
        mainChatPanel.setOpaque(false);
        mainChatPanel.setLayout(null);

        mainChattingFriendLabel.setBackground(new java.awt.Color(0, 51, 102));
        mainChattingFriendLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        mainChattingFriendLabel.setForeground(new java.awt.Color(204, 204, 204));
        mainChattingFriendLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainChattingFriendLabel.setOpaque(true);
        mainChatPanel.add(mainChattingFriendLabel);
        mainChattingFriendLabel.setBounds(2, 2, 586, 26);

        mainSendMessageTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mainSendMessageTextField.setText("Send Message ...");
        mainSendMessageTextField.setBorder(null);
        mainSendMessageTextField.setDoubleBuffered(true);
        mainSendMessageTextField.setOpaque(false);
        mainSendMessageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainSendMessageTextFieldActionPerformed(evt);
            }
        });
        mainChatPanel.add(mainSendMessageTextField);
        mainSendMessageTextField.setBounds(2, 198, 550, 30);

        mainSendMessageButton.setBackground(new java.awt.Color(255, 255, 255));
        mainSendMessageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-paper-plane-message-30.png"))); // NOI18N
        mainSendMessageButton.setBorder(null);
        mainSendMessageButton.setDoubleBuffered(true);
        mainSendMessageButton.setOpaque(false);
        mainChatPanel.add(mainSendMessageButton);
        mainSendMessageButton.setBounds(558, 198, 30, 30);

        mainChatSeparator.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 153), new java.awt.Color(153, 153, 153)));
        mainChatPanel.add(mainChatSeparator);
        mainChatSeparator.setBounds(0, 190, 590, 10);

        getContentPane().add(mainChatPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 590, 230));

        mainRecieveFileButton.setBackground(new java.awt.Color(22, 24, 24));
        mainRecieveFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-download-from-cloud-50.png"))); // NOI18N
        mainRecieveFileButton.setBorder(null);
        mainRecieveFileButton.setOpaque(false);
        mainRecieveFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainRecieveFileButtonActionPerformed(evt);
            }
        });
        getContentPane().add(mainRecieveFileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 100, 60));
        getContentPane().add(mainRecievedFilePathTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 230, -1));

        mainProgressBarStatusLabel.setText("Progress Bar Status...");
        getContentPane().add(mainProgressBarStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 493, 270, 20));

        mainSendFileButton.setBackground(new java.awt.Color(24, 24, 24));
        mainSendFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-upload-to-cloud-50.png"))); // NOI18N
        mainSendFileButton.setBorder(null);
        mainSendFileButton.setOpaque(false);
        mainSendFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainSendFileButtonActionPerformed(evt);
            }
        });
        getContentPane().add(mainSendFileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 100, 50));
        getContentPane().add(mainSelectFilePathTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 230, -1));

        mainSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(mainSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 10, 170));

        mainBottomPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainBottomPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainSelectFilePathButton.setBackground(new java.awt.Color(22, 24, 24));
        mainSelectFilePathButton.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        mainSelectFilePathButton.setForeground(new java.awt.Color(0, 51, 102));
        mainSelectFilePathButton.setText("Select File");
        mainSelectFilePathButton.setBorder(null);
        mainSelectFilePathButton.setOpaque(false);
        mainSelectFilePathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainSelectFilePathButtonActionPerformed(evt);
            }
        });
        mainBottomPanel.add(mainSelectFilePathButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 80, 20));

        mainSaveFilePathButton.setBackground(new java.awt.Color(22, 24, 24));
        mainSaveFilePathButton.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        mainSaveFilePathButton.setForeground(new java.awt.Color(0, 51, 102));
        mainSaveFilePathButton.setText("Save File");
        mainSaveFilePathButton.setBorder(null);
        mainSaveFilePathButton.setOpaque(false);
        mainSaveFilePathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainSaveFilePathButtonActionPerformed(evt);
            }
        });
        mainBottomPanel.add(mainSaveFilePathButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 80, 20));

        mainProgressBar.setBackground(new java.awt.Color(242, 242, 240));
        mainProgressBar.setValue(2);
        mainProgressBar.setOpaque(true);
        mainProgressBar.setStringPainted(true);
        mainBottomPanel.add(mainProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 444, 610, 20));

        mainBGIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mainBG2.png"))); // NOI18N
        mainBottomPanel.add(mainBGIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 460));

        getContentPane().add(mainBottomPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 610, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainSearchUserTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainSearchUserTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainSearchUserTextFieldActionPerformed

    private void mainSaveFilePathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainSaveFilePathButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainSaveFilePathButtonActionPerformed

    private void mainSelectFilePathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainSelectFilePathButtonActionPerformed
       JFileChooser chooser = new JFileChooser();
       chooser.showOpenDialog(null);
       File f = chooser.getSelectedFile();
       String filename = f.getAbsolutePath();
       mainSelectFilePathTextField.setText(filename);
    }//GEN-LAST:event_mainSelectFilePathButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
                
        Boolean response= this.sendString(20,"Logout");
        if(!response) return;
        
        this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void mainSendFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainSendFileButtonActionPerformed
        
        File f = new File(mainSelectFilePathTextField.getText());
        String fileName=f.getName();
        System.out.println("Preparing file: "+fileName);
        long fileLength=f.length();
        
        long progressBarFactor=(fileLength)/100;
        int progressBarStatus=0;
        this.mainProgressBarStatusLabel.setText("Preparing file to be sent: "+fileName);
        this.mainProgressBar.setValue(0);
        int i=0;
        while(i<fileLength)
        {
            if(i%progressBarFactor==0) 
            {
                progressBarStatus++;
                this.mainProgressBar.setValue(progressBarStatus);
            }
            i++;
        }
        this.mainProgressBar.setValue(100);
        this.mainProgressBarStatusLabel.setText(fileName);
        
        Boolean response = sendString(20,"Send Data");
        if(response==true) System.out.println("Send Data part got executed...");

        response = sendString(60,this.receivingUserID);
        if(response==true) System.out.println("Receiving user's ID sent");
        if(!response)
        {
        String msg = "File not sent!";
        JOptionPane.showMessageDialog(null,msg);
        return;
        }
        
        response= sendString(60,fileName);
        if(response==true) System.out.println("File Name Sent: "+fileName);
        if(!response)
        {
        String msg = "File not sent!";
        JOptionPane.showMessageDialog(null,msg);
        return;
        }
        
        response= sendString(60,String.valueOf(fileLength));
        if(response==true) System.out.println("File Length Sent: "+fileLength);
        if(!response)
        {
        String msg = "File not sent!";
        JOptionPane.showMessageDialog(null,msg);
        return;
        }
        
        System.out.println("Preparing the file to be sent");
        
        response= this.sendFile(fileLength,f);
        if(response)
        {
        String msg = "File sent! \nFile name: "+f.getName()+"\nFile length: "+f.length();
        JOptionPane.showMessageDialog(null,msg);
        return;
        }
        else
        {
        String msg = "Error sending file! \nFile name: "+f.getName()+"\nFile length: "+f.length();
        JOptionPane.showMessageDialog(null,msg);
        return;
        }

    }//GEN-LAST:event_mainSendFileButtonActionPerformed

    private void mainSendMessageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainSendMessageTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainSendMessageTextFieldActionPerformed

    private void mainRecieveFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainRecieveFileButtonActionPerformed

        try
        {
        int i,j,bytesToReceive, bytesReadCount,k;
        byte tmp[], header[], ack[];
        String fileName;
        double fileLength;
        StringBuffer sb;
        Boolean response = sendString(20,"Receive Data");
        if(response==true) System.out.println("Receive Data part got executed...");
        
        // RECEIVE RESPONSE TO KNOW WHETHER A FILE IS PENDING TO BE DOWNLOADED OR NOT
        
        ack=new byte[1];
        this.is.read(ack);
        
        if(ack[0]==0)
        {
            String msg = "No files available to download";
            JOptionPane.showMessageDialog(null,msg);
            return;
        }
        
        // SO, THE FILE EXISTS TO BE DOWNLOADED
        // RECEIVING THE HEADERS
        System.out.println("Some files are available to download");
        // RECEIVING FILE NAME
        // File name receiving....
        i=0;
        j=0;
        bytesToReceive=60;
        tmp=new byte[bytesToReceive];
        header=new byte[bytesToReceive];
        while(j<bytesToReceive)
        {
        System.out.println("Receiving file name: while loop chalaa");
        bytesReadCount=this.is.read(tmp);
        System.out.println("Receiving file name: Bytes read count"+bytesReadCount);
        if(bytesReadCount==-1) continue;
        for(k=0;k<bytesReadCount;k++)
        {
        header[i]=tmp[k];
        i++;
        }
        j+=bytesReadCount;
        System.out.println("Receiving file name: Pending bytes:"+(bytesToReceive-j));
        }
        System.out.println("Receiving file name: while loop khatam");
        i=0;
        sb=new StringBuffer();
        while(i<bytesToReceive)
        {
        sb.append((char)header[i]);
        i++;
        }
        fileName=sb.toString().trim();
        System.out.println("File Name received: "+fileName);
        
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();
        
        // RECEIVING FILE LENGTH
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
        fileLength=Double.valueOf(sb.toString().trim());
        System.out.println("File Length Received: "+fileLength);
        
        ack=new byte[1];
        ack[0]=1;
        this.os.write(ack,0,1);
        this.os.flush();
        
        response=this.receiveFile(fileLength,fileName);
        if(response)
        {
            System.out.println("File received at the server zzzzzzzzz");
        }
        else
        {
            System.out.println("Error receiving file");
        }
        
        
        
        
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_mainRecieveFileButtonActionPerformed
    
    public static void main(String args[]) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel mainBGIcon;
    private javax.swing.JPanel mainBottomPanel;
    private javax.swing.JPanel mainChatPanel;
    private javax.swing.JSeparator mainChatSeparator;
    private javax.swing.JLabel mainChattingFriendLabel;
    private javax.swing.JLabel mainNavBGIcon;
    private javax.swing.JPanel mainNavPanel;
    public javax.swing.JProgressBar mainProgressBar;
    private javax.swing.JLabel mainProgressBarStatusLabel;
    private javax.swing.JButton mainRecieveFileButton;
    private javax.swing.JTextField mainRecievedFilePathTextField;
    private javax.swing.JButton mainSaveFilePathButton;
    private javax.swing.JButton mainSearchUserButton;
    private javax.swing.JTextField mainSearchUserTextField;
    private javax.swing.JButton mainSelectFilePathButton;
    private javax.swing.JTextField mainSelectFilePathTextField;
    private javax.swing.JButton mainSendFileButton;
    private javax.swing.JButton mainSendMessageButton;
    private javax.swing.JTextField mainSendMessageTextField;
    private javax.swing.JSeparator mainSeparator;
    private javax.swing.JPanel mainSidePanel;
    private javax.swing.JSeparator mainSidePanelSeparator;
    private javax.swing.JLabel mainUsersLabel;
    // End of variables declaration//GEN-END:variables



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
        catch(IOException e){
        System.out.println(e.getMessage());
        }
        return false;
    }
    
    private Boolean sendFile(double fileLength, File f)
    {
        Boolean response;
        try
        {
            int progressBarStatus=0;
            String fileName= this.mainProgressBarStatusLabel.getText();
            this.mainProgressBarStatusLabel.setText("Sending file: "+fileName);
            this.mainProgressBar.setValue(progressBarStatus);
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
                this.mainProgressBar.setValue(progressBarStatus++);
            }
            this.mainProgressBarStatusLabel.setText("Sent file: "+fileName);
            this.mainProgressBar.setValue(100);
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
    
    private Boolean receiveFile(double lengthOfFile, String fileName)
    {
        try
        {
            int bytesReadCount=0;
         //   System.out.println("Saving file location: "+this.model.fileSource+String.valueOf(fileID));
            File file=new File(fileName);
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

}
