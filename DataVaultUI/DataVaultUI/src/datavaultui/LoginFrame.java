
package datavaultui;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author vibhor
 */
public class LoginFrame extends javax.swing.JFrame {
    
    Socket socket;
    InputStream is;
    OutputStream os;
    
    public LoginFrame() {
        initComponents();
    }
    
    public LoginFrame(Socket socket, InputStream is, OutputStream os) {
        this.socket=socket;
        this.is=is;
        this.os=os;
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginNavPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        loginNavBGIcon = new javax.swing.JLabel();
        loginFormPanel = new javax.swing.JPanel();
        loginFormNavLabel = new javax.swing.JLabel();
        loginFormUserIconl = new javax.swing.JLabel();
        loginPasswordLabel = new javax.swing.JLabel();
        loginUsernameLabel = new javax.swing.JLabel();
        loginUsernameTextField = new javax.swing.JTextField();
        loginPasswordPasswordField = new javax.swing.JPasswordField();
        loginLoginButton = new javax.swing.JButton();
        loginForgotPasswordButton = new javax.swing.JButton();
        loginRegisterHereButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        loginBGIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginNavPanel.setBackground(new java.awt.Color(0, 51, 102));
        loginNavPanel.setForeground(java.awt.Color.white);
        loginNavPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe Script", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DataVault");
        loginNavPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 360, 50));

        loginNavBGIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/NavBG.png"))); // NOI18N
        loginNavPanel.add(loginNavBGIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(loginNavPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, -1));

        loginFormPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        loginFormPanel.setForeground(new java.awt.Color(0, 102, 153));
        loginFormPanel.setOpaque(false);
        loginFormPanel.setPreferredSize(new java.awt.Dimension(508, 381));
        loginFormPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginFormNavLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        loginFormNavLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginFormNavLabel.setText("Get In !");
        loginFormPanel.add(loginFormNavLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 1, 131, 51));

        loginFormUserIconl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-user-64.png"))); // NOI18N
        loginFormPanel.add(loginFormUserIconl, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 125, -1, -1));

        loginPasswordLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        loginPasswordLabel.setText("Password");
        loginFormPanel.add(loginPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 179, -1, -1));

        loginUsernameLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        loginUsernameLabel.setText("Username");
        loginFormPanel.add(loginUsernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 102, -1, -1));

        loginUsernameTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        loginUsernameTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 153), new java.awt.Color(153, 153, 153)));
        loginUsernameTextField.setOpaque(false);
        loginUsernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUsernameTextFieldActionPerformed(evt);
            }
        });
        loginFormPanel.add(loginUsernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 103, 158, -1));

        loginPasswordPasswordField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        loginPasswordPasswordField.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 153), new java.awt.Color(153, 153, 153)));
        loginPasswordPasswordField.setOpaque(false);
        loginPasswordPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginPasswordPasswordFieldActionPerformed(evt);
            }
        });
        loginFormPanel.add(loginPasswordPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 179, 158, -1));

        loginLoginButton.setBackground(new java.awt.Color(0, 51, 102));
        loginLoginButton.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        loginLoginButton.setForeground(new java.awt.Color(204, 204, 204));
        loginLoginButton.setText("LogIn");
        loginLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginLoginButtonActionPerformed(evt);
            }
        });
        loginFormPanel.add(loginLoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 252, 101, 42));

        loginForgotPasswordButton.setBackground(new java.awt.Color(204, 0, 204));
        loginForgotPasswordButton.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        loginForgotPasswordButton.setForeground(new java.awt.Color(0, 51, 102));
        loginForgotPasswordButton.setText("forgot password ?");
        loginForgotPasswordButton.setBorder(null);
        loginForgotPasswordButton.setOpaque(false);
        loginForgotPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginForgotPasswordButtonActionPerformed(evt);
            }
        });
        loginFormPanel.add(loginForgotPasswordButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 325, -1, -1));

        loginRegisterHereButton.setBackground(new java.awt.Color(204, 0, 204));
        loginRegisterHereButton.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        loginRegisterHereButton.setForeground(new java.awt.Color(0, 51, 102));
        loginRegisterHereButton.setText("Register Here :)");
        loginRegisterHereButton.setBorder(null);
        loginRegisterHereButton.setOpaque(false);
        loginRegisterHereButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginRegisterHereButtonActionPerformed(evt);
            }
        });
        loginFormPanel.add(loginRegisterHereButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 325, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG2(Login).png"))); // NOI18N
        loginFormPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 497, 382));

        getContentPane().add(loginFormPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 109, 497, 382));

        loginBGIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG3.png"))); // NOI18N
        getContentPane().add(loginBGIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, -1, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginUsernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginUsernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUsernameTextFieldActionPerformed

    private void loginPasswordPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginPasswordPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginPasswordPasswordFieldActionPerformed

    private void loginForgotPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginForgotPasswordButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginForgotPasswordButtonActionPerformed

    private void loginRegisterHereButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginRegisterHereButtonActionPerformed
        new datavaultui.RegistrationFrame(this.socket, this.is, this.os).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_loginRegisterHereButtonActionPerformed

    private void loginLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginLoginButtonActionPerformed
        String username ; 
        String password ; 
        Boolean response;
        
        username = this.loginUsernameTextField.getText();
        password = this.loginPasswordPasswordField.getText();
        
        
        if(username.length()== 0 || password.length() == 0){
            String msg = "ALERT!! All the fields are mandatory";
            JOptionPane.showMessageDialog(null,msg);
            this.setVisible(true);
        }
        else
        {
            System.out.println(username);
            System.out.println(password);
            
            response = sendString(20,"Login");
            if(response==true) System.out.println("Login part got executed...");
            if(response!=true)
            {
            String msg = "Login Unsuccessful !!!";
            JOptionPane.showMessageDialog(null,msg);
            return;
            }

            response = sendString(60,username);
            if(!response)
            {
            String msg = "Login Unsuccessful at username!!!";
            JOptionPane.showMessageDialog(null,msg);
            return;
            }

            response= sendString(60,password);
            if(!response)
            {
            String msg = "Login Unsuccessful at Password!!!";
            JOptionPane.showMessageDialog(null,msg);
            return;
            }
            
            response=this.receiveAck();
            
            if(response)
            {
            String msg = "Authentication Done !";
            JOptionPane.showMessageDialog(null,msg);
            this.setVisible(true);
            new datavaultui.MainFrame(this.socket, this.is, this.os).setVisible(true);
            this.setVisible(false);
            }
            else
            {
            String msg = "Authentication Unsuccessful !!!";
            JOptionPane.showMessageDialog(null,msg);
            }
        }
    }//GEN-LAST:event_loginLoginButtonActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel loginBGIcon;
    private javax.swing.JButton loginForgotPasswordButton;
    private javax.swing.JLabel loginFormNavLabel;
    private javax.swing.JPanel loginFormPanel;
    private javax.swing.JLabel loginFormUserIconl;
    private javax.swing.JButton loginLoginButton;
    private javax.swing.JLabel loginNavBGIcon;
    private javax.swing.JPanel loginNavPanel;
    private javax.swing.JLabel loginPasswordLabel;
    private javax.swing.JPasswordField loginPasswordPasswordField;
    private javax.swing.JButton loginRegisterHereButton;
    private javax.swing.JLabel loginUsernameLabel;
    private javax.swing.JTextField loginUsernameTextField;
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
