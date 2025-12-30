package com.mycompany.app.hub;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.JPanel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Tan
 */
public class SignupForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SignupForm.class.getName());

    LoginSecurity login = new LoginSecurity();
    /**
     * Creates new form NewJFrame
     */
    public SignupForm() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        initCustomFont();
        initCustomizations();
        jPanel1.requestFocusInWindow();
    }
    
    public void initCustomizations() {
        txtFirstName.setForeground(new java.awt.Color(150, 150, 150));
        txtFirstName.setText("First Name");
        
        txtLastName.setForeground(new java.awt.Color(150, 150, 150));
        txtLastName.setText("Last Name");
        
        txtEmail.setForeground(new java.awt.Color(150, 150, 150));
        txtEmail.setText("Email");
        
        
        txtPassConfirm.setEchoChar((char)0); // Stop showing dots for the placeholder text
        txtPassConfirm.setForeground(new java.awt.Color(150, 150, 150));
        txtPassConfirm.setText("Confirm your Password");
        
        txtPass.setEchoChar((char)0); // Stop showing dots for the placeholder text
        txtPass.setForeground(new java.awt.Color(150, 150, 150));
        txtPass.setText("Enter your Password");
    }
    

    public void initCustomFont() {
    try {
        InputStream is = getClass().getResourceAsStream("/fonts/inter.ttf"); 
        if (is == null) {
            throw new IOException("Font file not found in resources folder!");
        }

        Color customPurple = new Color(132,81,138);
        Font myFont = Font.createFont(Font.TRUETYPE_FONT, is);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(myFont);

        jLabel1.setFont(myFont.deriveFont(Font.BOLD ,38f));
        
        jLabel4.setFont(myFont.deriveFont(Font.PLAIN ,12f));
        jLabel4.setForeground(customPurple);
        
        
        txtFirstName.setFont(myFont.deriveFont(Font.PLAIN, 16f));
        txtLastName.setFont(myFont.deriveFont(Font.PLAIN, 16f));
        txtEmail.setFont(myFont.deriveFont(Font.PLAIN, 16f));
        
        
        jButton1.setFont(myFont.deriveFont(Font.PLAIN, 20f));
        
        txtPassConfirm.setFont(myFont.deriveFont(Font.PLAIN, 16f));
        txtPass.setFont(myFont.deriveFont(Font.PLAIN, 16f));
        jCheckBox1.setFont(myFont.deriveFont(Font.PLAIN, 12f));
        jLabel2.setFont(myFont.deriveFont(Font.PLAIN, 12f));
        jLabel2.setForeground(Color.RED);

        jComboBox1.setFont(myFont.deriveFont(Font.PLAIN, 12f));
        
        
    } catch (FontFormatException e) {
        System.err.println("The font file is corrupted or not a valid TTF.");
        e.printStackTrace();
    } catch (IOException e) {
        System.err.println("Could not load the font file. Check the path!");
        e.printStackTrace();
    }
}
    
    class RoundedPanel extends JPanel {
    private int radius;

    public RoundedPanel(int radius) {
        this.radius = radius;
        setOpaque(false); // important!
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.dispose();
        super.paintComponent(g);
    }
}
    
    class RoundedButton extends JButton {
    private int radius;
    private Color normalColor = new Color(187, 114, 195); // RGB(187, 114, 195)
    private Color hoverColor = Color.WHITE;
    private Color originalTextColor;

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        this.originalTextColor = Color.WHITE; // Default text color
        
        // Remove default styling
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        
        // Initial colors
        setBackground(normalColor);
        setForeground(originalTextColor);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { 
                setBackground(hoverColor); 
                setForeground(normalColor); // Flip text color to purple so it's visible on white
            }
            @Override
            public void mouseExited(MouseEvent e) { 
                setBackground(normalColor); 
                setForeground(originalTextColor); // Return to white text
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Paint the rounded background
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        
        g2.dispose();
        
        // Paint the text/icon over our custom background
        super.paintComponent(g);
    }
}
    
    class jPanelGradient extends JPanel {
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Define three colors
        Color color1 = new Color(33, 5, 53);  // green
        Color color2 = new Color(104, 38, 108);  // orange
        Color color3 = new Color(105, 97, 165);      // black

        // Fractions define position of each color (0.0 - 1.0)
        float[] fractions = {0.0f, 0.5f, 1.0f};
        Color[] colors = {color1, color2, color3};

        LinearGradientPaint lgp = new LinearGradientPaint(
                0, 0,            // start point (top-left)
                width, height/2, // end point (diagonal)
                fractions,
                colors
        );

        g2d.setPaint(lgp);
        g2d.fillRect(0, 0, width, height);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new jPanelGradient();
        jPanel2 = new RoundedPanel(50);
        jLabel1 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jButton1 = new RoundedButton("Login", 20);
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtPassConfirm = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        txtPass = new javax.swing.JPasswordField();
        jPanel7 = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(251, 194, 255));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel1.setText("Sign Up");

        txtFirstName.setBackground(new java.awt.Color(251, 194, 255));
        txtFirstName.setForeground(new java.awt.Color(0, 0, 0));
        txtFirstName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFirstNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFirstNameFocusLost(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(187, 114, 195));
        jButton1.setText("Signup");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        txtPassConfirm.setBackground(new java.awt.Color(251, 194, 255));
        txtPassConfirm.setBorder(null);
        txtPassConfirm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassConfirmFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassConfirmFocusLost(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(251, 194, 255));
        jCheckBox1.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox1.setText("Show Password");
        jCheckBox1.setBorder(null);
        jCheckBox1.setContentAreaFilled(false);
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox1.addActionListener(this::jCheckBox1ActionPerformed);

        jLabel4.setText("Log In? Click Here");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        txtLastName.setBackground(new java.awt.Color(251, 194, 255));
        txtLastName.setForeground(new java.awt.Color(0, 0, 0));
        txtLastName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLastNameFocusLost(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(100, 1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        txtPass.setBackground(new java.awt.Color(251, 194, 255));
        txtPass.setBorder(null);
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassFocusLost(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(100, 1));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        txtEmail.setBackground(new java.awt.Color(251, 194, 255));
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setForeground(new java.awt.Color(0, 0, 0));
        jPanel9.setPreferredSize(new java.awt.Dimension(100, 1));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jComboBox1.setBackground(new java.awt.Color(251, 194, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Access Level", "Admin", "User", "Guest" }));
        jComboBox1.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                            .addComponent(txtPassConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(68, 68, 68)
                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtPassConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 82, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        jPanel1.add(jPanel2, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        jPanel2.requestFocusInWindow();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setForeground(new Color(132,81,138));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setForeground(Color.WHITE);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        LoginForm main = new LoginForm();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        if (new String(txtPassConfirm.getPassword()).equals("Confirm your Password")) {
        } else {
                if (!jCheckBox1.isSelected()) {
                txtPassConfirm.setEchoChar('•');
            } else {
                txtPassConfirm.setEchoChar((char)0);
            }
        }
        
        if (new String(txtPass.getPassword()).equals("Enter your Password")) {
        } else {
                if (!jCheckBox1.isSelected()) {
                txtPass.setEchoChar('•');
            } else {
                txtPass.setEchoChar((char)0);
            }
        }
        
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void txtPassConfirmFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassConfirmFocusLost
        // Get the password as a char array
        char[] password = txtPassConfirm.getPassword();

        // Check if the array length is 0 (empty field)
        if (password.length == 0) {
            // Reset the placeholder look
            txtPassConfirm.setEchoChar((char)0); // Stop showing dots for the placeholder text
            txtPassConfirm.setForeground(new java.awt.Color(150, 150, 150));
            txtPassConfirm.setText("Confirm your Password");
        }
    }//GEN-LAST:event_txtPassConfirmFocusLost

    private void txtPassConfirmFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassConfirmFocusGained
        String currentText = new String(txtPassConfirm.getPassword());

        if (currentText.equals("Confirm your Password")) {
            txtPassConfirm.setText("");
            txtPassConfirm.setForeground(java.awt.Color.BLACK);

            if (!jCheckBox1.isSelected()) {
                txtPassConfirm.setEchoChar('•');
            } else {
                txtPassConfirm.setEchoChar((char)0);
            }
        }
    }//GEN-LAST:event_txtPassConfirmFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // 1. Get values from fields
        String fName = txtFirstName.getText().trim();
        String lName = txtLastName.getText().trim();
        String email = txtEmail.getText().trim();

        // Retrieve passwords as Strings for comparison
        String pass = new String(txtPass.getPassword());
        String confirmPass = new String(txtPassConfirm.getPassword());

        // 2. Get Access Level from ComboBox
        String selectedLevel = jComboBox1.getSelectedItem().toString();
        int accessLevel = selectedLevel.equals("Admin") ? 0 : selectedLevel.equals("User") ? 1 : 2;

        // 3. Validation Logic
        String errorMsg = "<html>";
        boolean hasError = false;

        // Empty Field Check
        if (fName.equals("First Name") || email.equals("Enter your email") || pass.equals("Enter your Password") || confirmPass.equals("Confirm your Password") ) {
            errorMsg += "• Please fill all fields<br>";
            hasError = true;
        }

        
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!email.equals("Enter your email") && !email.matches(emailPattern)) {
            errorMsg += "• Please enter a valid email address<br>";
            hasError = true;
}

        // Password Match Check
        if (!pass.equals(confirmPass)) {
            errorMsg += "• Passwords do not match<br>";
            hasError = true;
        }

        // 1. Check for Length (8+ characters)
        if (pass.length() < 8) {
            errorMsg += "• Password must be at least 8 characters long<br>";
            hasError = true;
        }

        // 2. Check for Uppercase letter
        if (!pass.matches(".*[A-Z].*")) {
            errorMsg += "• Include at least one uppercase letter (A-Z)<br>";
            hasError = true;
        }

        // 3. Check for Lowercase letter
        if (!pass.matches(".*[a-z].*")) {
            errorMsg += "• Include at least one lowercase letter (a-z)<br>";
            hasError = true;
        }

        // 4. Check for Number
        if (!pass.matches(".*[0-9].*")) {
            errorMsg += "• Include at least one number (0-9)<br>";
            hasError = true;
        }

        // 4. Output Result
        if (hasError) {
            errorMsg += "</html>";
            jLabel2.setForeground(java.awt.Color.RED);
            jLabel2.setText(errorMsg);
        } else {
            // Success: Save user to your LoginSecurity instance
            login.signup(fName, lName, email, pass, accessLevel);

            jLabel2.setForeground(new java.awt.Color(0, 150, 0));
            jLabel2.setText("<html>Registration Successful!<br>Opening Login...</html>");

            // 1. Create the timer object first
            javax.swing.Timer timer = new javax.swing.Timer(2000, e -> {
                this.dispose();
                new LoginForm().setVisible(true);
            });

            // 2. DISABLE repeating so it only runs once
            timer.setRepeats(false);

            // 3. Start it
            timer.start();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtFirstNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFirstNameFocusLost
        if (txtFirstName.getText().isEmpty()) {
            // Change back to a dim color for the placeholder
            txtFirstName.setForeground(new java.awt.Color(150, 150, 150));
            txtFirstName.setText("First Name");
        }
    }//GEN-LAST:event_txtFirstNameFocusLost

    private void txtFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFirstNameFocusGained
        if (txtFirstName.getText().equals("First Name")) {
            txtFirstName.setText("");
            // Change to a bright color for actual typing
            txtFirstName.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_txtFirstNameFocusGained

    private void txtLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLastNameFocusGained
        if (txtLastName.getText().equals("Last Name")) {
            txtLastName.setText("");
            // Change to a bright color for actual typing
            txtLastName.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_txtLastNameFocusGained

    private void txtLastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLastNameFocusLost
        if (txtLastName.getText().isEmpty()) {
            // Change back to a dim color for the placeholder
            txtLastName.setForeground(new java.awt.Color(150, 150, 150));
            txtLastName.setText("Last Name");
        }
    }//GEN-LAST:event_txtLastNameFocusLost

    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusGained
        String currentText = new String(txtPass.getPassword());

        if (currentText.equals("Enter your Password")) {
            txtPass.setText("");
            txtPass.setForeground(java.awt.Color.BLACK);

            if (!jCheckBox1.isSelected()) {
                txtPass.setEchoChar('•');
            } else {
                txtPass.setEchoChar((char)0);
            }
        }
    }//GEN-LAST:event_txtPassFocusGained

    private void txtPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusLost
        // Get the password as a char array
        char[] password = txtPass.getPassword();

        // Check if the array length is 0 (empty field)
        if (password.length == 0) {
            // Reset the placeholder look
            txtPass.setEchoChar((char)0); // Stop showing dots for the placeholder text
            txtPass.setForeground(new java.awt.Color(150, 150, 150));
            txtPass.setText("Enter your Password");
        }
    }//GEN-LAST:event_txtPassFocusLost

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        if (txtEmail.getText().equals("Email")) {
            txtEmail.setText("");
            // Change to a bright color for actual typing
            txtEmail.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (txtEmail.getText().isEmpty()) {
            // Change back to a dim color for the placeholder
            txtEmail.setForeground(new java.awt.Color(150, 150, 150));
            txtEmail.setText("Email");
        }
    }//GEN-LAST:event_txtEmailFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new SignupForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPassConfirm;
    // End of variables declaration//GEN-END:variables
}
