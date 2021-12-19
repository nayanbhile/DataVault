
package datavaultui;
import javax.swing.JOptionPane;
import java.net.*;
import java.io.*;

public class RegistrationFrame extends javax.swing.JFrame {
    
    Socket socket;
    InputStream is;
    OutputStream os;
    
   
    public RegistrationFrame() {
        initComponents();
    }
    
    public RegistrationFrame(Socket socket, InputStream is, OutputStream os) 
    {
        this.socket=socket;
        this.is=is;
        this.os=os;
        
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registrationNavPanel = new javax.swing.JPanel();
        DataVaultLogo = new javax.swing.JLabel();
        registrationNavBGIcon = new javax.swing.JLabel();
        registrationFormPanel = new javax.swing.JPanel();
        registrationNameLabel = new javax.swing.JLabel();
        registrationMailLabel = new javax.swing.JLabel();
        registrationPhoneLabel = new javax.swing.JLabel();
        registrationVPasswordLabel = new javax.swing.JLabel();
        registrationUsernameLabel = new javax.swing.JLabel();
        registrationPasswordLabel = new javax.swing.JLabel();
        registrationNameTextField = new javax.swing.JTextField();
        registrationPhoneTextField = new javax.swing.JTextField();
        registrationMailTextField = new javax.swing.JTextField();
        registrationUsernameTextField = new javax.swing.JTextField();
        registrationPasswordPasswordField = new javax.swing.JPasswordField();
        registrationVPasswordPasswordField = new javax.swing.JPasswordField();
        registrationLoginButton = new javax.swing.JButton();
        registrationRegisterButton = new javax.swing.JButton();
        registerJoinUsLabel = new javax.swing.JLabel();
        registrationFormBGIcon = new javax.swing.JLabel();
        registrationBGIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registrationNavPanel.setBackground(new java.awt.Color(0, 51, 102));
        registrationNavPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataVaultLogo.setFont(new java.awt.Font("Segoe Script", 0, 48)); // NOI18N
        DataVaultLogo.setForeground(new java.awt.Color(255, 102, 153));
        DataVaultLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DataVaultLogo.setText("DataVault");
        registrationNavPanel.add(DataVaultLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 360, 50));

        registrationNavBGIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/NavBG.png"))); // NOI18N
        registrationNavPanel.add(registrationNavBGIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(registrationNavPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        registrationFormPanel.setBackground(new java.awt.Color(255, 255, 255));
        registrationFormPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        registrationFormPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registrationNameLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        registrationNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrationNameLabel.setText("Full Name");
        registrationFormPanel.add(registrationNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 60, 112, 28));

        registrationMailLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        registrationMailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrationMailLabel.setText("E-Mail");
        registrationFormPanel.add(registrationMailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 112, 28));

        registrationPhoneLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        registrationPhoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrationPhoneLabel.setText("Phone No. ");
        registrationFormPanel.add(registrationPhoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 140, 112, 28));

        registrationVPasswordLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        registrationVPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrationVPasswordLabel.setText("Verify Password");
        registrationFormPanel.add(registrationVPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 254, 150, 28));

        registrationUsernameLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        registrationUsernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrationUsernameLabel.setText("Username");
        registrationFormPanel.add(registrationUsernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 100, 112, 28));

        registrationPasswordLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        registrationPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrationPasswordLabel.setText("Password");
        registrationFormPanel.add(registrationPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 215, 112, 28));

        registrationNameTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        registrationNameTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 153), new java.awt.Color(153, 153, 153)));
        registrationNameTextField.setOpaque(false);
        registrationNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationNameTextFieldActionPerformed(evt);
            }
        });
        registrationFormPanel.add(registrationNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 60, 170, -1));

        registrationPhoneTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        registrationPhoneTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 153), new java.awt.Color(153, 153, 153)));
        registrationPhoneTextField.setOpaque(false);
        registrationPhoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationPhoneTextFieldActionPerformed(evt);
            }
        });
        registrationFormPanel.add(registrationPhoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 140, 170, -1));

        registrationMailTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        registrationMailTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 153), new java.awt.Color(153, 153, 153)));
        registrationMailTextField.setOpaque(false);
        registrationMailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationMailTextFieldActionPerformed(evt);
            }
        });
        registrationFormPanel.add(registrationMailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 180, 170, -1));

        registrationUsernameTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        registrationUsernameTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 153), new java.awt.Color(153, 153, 153)));
        registrationUsernameTextField.setOpaque(false);
        registrationUsernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationUsernameTextFieldActionPerformed(evt);
            }
        });
        registrationFormPanel.add(registrationUsernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 100, 170, -1));

        registrationPasswordPasswordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        registrationPasswordPasswordField.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 153), new java.awt.Color(153, 153, 153)));
        registrationPasswordPasswordField.setOpaque(false);
        registrationPasswordPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationPasswordPasswordFieldActionPerformed(evt);
            }
        });
        registrationFormPanel.add(registrationPasswordPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 215, 170, -1));

        registrationVPasswordPasswordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        registrationVPasswordPasswordField.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 153), new java.awt.Color(153, 153, 153)));
        registrationVPasswordPasswordField.setOpaque(false);
        registrationFormPanel.add(registrationVPasswordPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 254, 170, -1));

        registrationLoginButton.setBackground(new java.awt.Color(0, 51, 102));
        registrationLoginButton.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        registrationLoginButton.setForeground(new java.awt.Color(204, 204, 204));
        registrationLoginButton.setText("Go to LogIn");
        registrationLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationLoginButtonActionPerformed(evt);
            }
        });
        registrationFormPanel.add(registrationLoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 318, 109, 40));

        registrationRegisterButton.setBackground(new java.awt.Color(0, 51, 102));
        registrationRegisterButton.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        registrationRegisterButton.setForeground(new java.awt.Color(204, 204, 204));
        registrationRegisterButton.setText("Register!!");
        registrationRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationRegisterButtonActionPerformed(evt);
            }
        });
        registrationFormPanel.add(registrationRegisterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 318, 109, 40));

        registerJoinUsLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 30)); // NOI18N
        registerJoinUsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerJoinUsLabel.setText("JOIN US");
        registrationFormPanel.add(registerJoinUsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        registrationFormBGIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG2.png"))); // NOI18N
        registrationFormPanel.add(registrationFormBGIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 400));

        getContentPane().add(registrationFormPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 510, 400));

        registrationBGIcon.setBackground(new java.awt.Color(255, 51, 255));
        registrationBGIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG1.png"))); // NOI18N
        getContentPane().add(registrationBGIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrationNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationNameTextFieldActionPerformed
        
    }//GEN-LAST:event_registrationNameTextFieldActionPerformed

    private void registrationPhoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationPhoneTextFieldActionPerformed
       
    }//GEN-LAST:event_registrationPhoneTextFieldActionPerformed

    private void registrationMailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationMailTextFieldActionPerformed
        
    }//GEN-LAST:event_registrationMailTextFieldActionPerformed

    private void registrationUsernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationUsernameTextFieldActionPerformed
        
    }//GEN-LAST:event_registrationUsernameTextFieldActionPerformed

    private void registrationPasswordPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationPasswordPasswordFieldActionPerformed
            
    }//GEN-LAST:event_registrationPasswordPasswordFieldActionPerformed

    private void registrationRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationRegisterButtonActionPerformed
        String name ; 
        String mail ;
        String phone ;
        String username ;
        String password ;
        String vpassword ; 
        
        name = this.registrationNameTextField.getText() ; 
        mail = this.registrationMailTextField.getText();
        phone = this.registrationPhoneTextField.getText() ;
        username = this.registrationUsernameTextField.getText() ;
        password = this.registrationPasswordPasswordField.getText() ;
        vpassword = this.registrationVPasswordPasswordField.getText() ;
        //if (!this.strComp(password,vpassword))
        if (name.length()==0 || mail.length()==0 || phone.length()==0 || username.length()==0 || password.length()==0 || vpassword.length()==0)
        {
            String msg = "ALERT!! All the fields are mandatory";
            JOptionPane.showMessageDialog(null,msg);
            this.setVisible(true);
            
        } 
        else
        {
            System.out.println(name);
            System.out.println(mail);
            System.out.println(phone);
            System.out.println(username);
            System.out.println(password);
            System.out.println(vpassword);
            if (password.equals(vpassword))
            {
                Boolean response;
                // SENDING INFO TO THE SERVER
                // SENDING ACTION HEADER
                response = sendString(20,"Register");
                if(response==true) System.out.println("Register part got executed...");
                if(response!=true)
                {
                String msg = "Registration Unsuccessful !!!";
                JOptionPane.showMessageDialog(null,msg);
                return;
                }
                
                response = sendString(60,username);
                if(!response)
                {
                String msg = "Registration Unsuccessful at username!!!";
                JOptionPane.showMessageDialog(null,msg);
                return;
                }
                
                response= sendString(60,password);
                if(!response)
                {
                String msg = "Registration Unsuccessful at Password!!!";
                JOptionPane.showMessageDialog(null,msg);
                return;
                }
                
                response= sendString(60,name);
                if(!response)
                {
                String msg = "Registration Unsuccessful at name!!!";
                JOptionPane.showMessageDialog(null,msg);
                return;
                }
                
                System.out.println("Sent name, waiting to receive ack");
                
                response=receiveAck();
                
                if(response==false)
                {
                String msg = "Registration Unsuccessful !!!";
                JOptionPane.showMessageDialog(null,msg);
                return;
                }
                
                String msg = "Registration Successful !!!";
                JOptionPane.showMessageDialog(null,msg);
                this.setVisible(true);
                new datavaultui.LoginFrame(this.socket, this.is, this.os).setVisible(true);
                this.setVisible(false);
            }
            else
            {
            String msg = "Password does not match";
            JOptionPane.showMessageDialog(null,msg);
            this.setVisible(true);
            }
        }
        
       
      
    }//GEN-LAST:event_registrationRegisterButtonActionPerformed

    private void registrationLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationLoginButtonActionPerformed
        new datavaultui.LoginFrame(this.socket, this.is, this.os).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_registrationLoginButtonActionPerformed
    
    
  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DataVaultLogo;
    private javax.swing.JLabel registerJoinUsLabel;
    private javax.swing.JLabel registrationBGIcon;
    private javax.swing.JLabel registrationFormBGIcon;
    private javax.swing.JPanel registrationFormPanel;
    private javax.swing.JButton registrationLoginButton;
    private javax.swing.JLabel registrationMailLabel;
    private javax.swing.JTextField registrationMailTextField;
    private javax.swing.JLabel registrationNameLabel;
    private javax.swing.JTextField registrationNameTextField;
    private javax.swing.JLabel registrationNavBGIcon;
    private javax.swing.JPanel registrationNavPanel;
    private javax.swing.JLabel registrationPasswordLabel;
    private javax.swing.JPasswordField registrationPasswordPasswordField;
    private javax.swing.JLabel registrationPhoneLabel;
    private javax.swing.JTextField registrationPhoneTextField;
    private javax.swing.JButton registrationRegisterButton;
    private javax.swing.JLabel registrationUsernameLabel;
    private javax.swing.JTextField registrationUsernameTextField;
    private javax.swing.JLabel registrationVPasswordLabel;
    private javax.swing.JPasswordField registrationVPasswordPasswordField;
    // End of variables declaration//GEN-END:variables
    
    
    public boolean strComp(String x,String y)
    {
    Integer a = x.compareTo(y) ;
    if(a==0) {
        return true ; 
    }else {
    return false ;
    }
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
    private void sendAck(int ack)
    {
        try
        {
        byte tmp[]=new byte[1];
        tmp[0]=tmp[ack];
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
        System.out.println("Receive ack got executed...");
        byte tmp[]=new byte[1];
        this.is.read(tmp);
        System.out.println("TMP at receiving ACK: "+tmp[0]);
        if(tmp[0]==1) return true;
        else return false;
        }
        catch(IOException e){}
        return false;
    }
    
}
