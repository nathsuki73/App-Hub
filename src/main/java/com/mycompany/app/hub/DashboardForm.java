/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.app.hub;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
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
import javax.swing.SwingConstants;

/**
 *
 * @author Tan
 */
public class DashboardForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DashboardForm.class.getName());

    /**
     * Creates new form DashboardForm
     */
    public DashboardForm() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        currentPanel = jPanel6;
        initCustomFont();
        
        jLabel3.setText("Dashboard");
        DashboardPanel data = new DashboardPanel();
        switchPanel(data);
        currentPanel = data;
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

        jLabel3.setFont(myFont.deriveFont(Font.PLAIN ,24f));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);

        
        btnChatbot.setFont(myFont.deriveFont(Font.PLAIN, 20f));
        btnCredits.setFont(myFont.deriveFont(Font.PLAIN, 20f));
        btnDash.setFont(myFont.deriveFont(Font.PLAIN, 20f));
        btnQuiz.setFont(myFont.deriveFont(Font.PLAIN, 20f));
        btnData.setFont(myFont.deriveFont(Font.PLAIN, 20f));
        btnExit.setFont(myFont.deriveFont(Font.PLAIN, 20f));
        btnLogout.setFont(myFont.deriveFont(Font.PLAIN, 20f));
        
        
    } catch (FontFormatException e) {
        System.err.println("The font file is corrupted or not a valid TTF.");
        e.printStackTrace();
    } catch (IOException e) {
        System.err.println("Could not load the font file. Check the path!");
        e.printStackTrace();
    }
}
    
    
    
    
    public JPanel currentPanel;
    public void switchPanel(JPanel pnlAdd)
    {
        jPanel4.remove(currentPanel);
        jPanel4.add(pnlAdd);
        currentPanel = pnlAdd;
        jPanel4.revalidate();
        jPanel4.repaint();
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
    
    class RoundedPanel extends JPanel 
    {
        private int radius;
        
        public RoundedPanel(int radius)
        {
            this.radius = radius;
            setOpaque(false);
        }
        
        @Override
        protected void paintComponent(Graphics g)
        {
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
//        private Color normalColor = new Color (187, 114, 195);
        private Color hoverColor  = new Color (90,31,97);
//        private Color hoverColor = Color.WHITE;
        private Color normalColor = new Color (187, 114, 195);

        private Color originalTextColor;
        
        public RoundedButton(String text, int radius)
        {
            super(text);
            this.radius = radius;
            this.originalTextColor = Color.WHITE;
            
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setOpaque(false);
            
            setBackground(normalColor);
            setForeground(originalTextColor);
            
            addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mouseEntered(MouseEvent e)
                {
                    if (!isEnabled()) return;
                    setBackground(hoverColor);
                }
                
                @Override
                public void mouseExited(MouseEvent e)
                {
                    if (!isEnabled()) return;
                    setBackground(normalColor);
                }
            });
        }
        
        public RoundedButton(String text, int radius, Color color)
        {
            super(text);
            normalColor = color;
            this.radius = radius;
            this.originalTextColor = Color.WHITE;
            
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setOpaque(false);
            
            setBackground(normalColor);
            setForeground(originalTextColor);
            
            addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mouseEntered(MouseEvent e)
                {
                    if (!isEnabled()) return;
                    setBackground(hoverColor);
                }
                
                @Override
                public void mouseExited(MouseEvent e)
                {
                    if (!isEnabled()) return;
                    setBackground(normalColor);
                }
            });
        }
        
        @Override
        protected void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            if (!isEnabled())
            {
                g2.setColor(Color.LIGHT_GRAY);
            }
            else
            {
                g2.setColor(getBackground());
            }
            //g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            
            g2.dispose();
            
            super.paintComponent(g);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new jPanelGradient();
        jPanel3 = new RoundedPanel(50);
        btnQuiz = new RoundedButton("Quiz Game",30);
        btnData = new RoundedButton("Data Charts",30);
        btnLogout = new RoundedButton("Quiz Game",30);
        btnDash = new RoundedButton("Quiz Game",30);
        btnChatbot = new RoundedButton("Quiz Game",30);
        btnCredits = new RoundedButton("Data Charts",30);
        btnExit = new RoundedButton("Exit",30, new Color(255,102,128));
        jPanel4 = new RoundedPanel(50);
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new RoundedPanel(50);
        jLabel3 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(204, 0, 204));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel1.setLayout(new java.awt.BorderLayout(20, 20));

        jPanel3.setBackground(new java.awt.Color(251, 194, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(250, 0));

        btnQuiz.setBackground(new java.awt.Color(187, 114, 195));
        btnQuiz.setFont(new java.awt.Font("STFangsong", 1, 24)); // NOI18N
        btnQuiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SVGRepo_iconCarrier.png"))); // NOI18N
        btnQuiz.setText("Quiz Game");
        btnQuiz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuiz.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuiz.setIconTextGap(20);
        btnQuiz.addActionListener(this::btnQuizActionPerformed);

        btnData.setBackground(new java.awt.Color(187, 114, 195));
        btnData.setFont(new java.awt.Font("STFangsong", 1, 24)); // NOI18N
        btnData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame (7).png"))); // NOI18N
        btnData.setText(" Data Charts");
        btnData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnData.setIconTextGap(20);
        btnData.addActionListener(this::btnDataActionPerformed);

        btnLogout.setBackground(new java.awt.Color(187, 114, 195));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame (9).png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogout.setIconTextGap(20);
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        btnDash.setBackground(new java.awt.Color(187, 114, 195));
        btnDash.setFont(new java.awt.Font("STFangsong", 1, 24)); // NOI18N
        btnDash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard.png"))); // NOI18N
        btnDash.setText("Dashboard");
        btnDash.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDash.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDash.setIconTextGap(20);
        btnDash.addActionListener(this::btnDashActionPerformed);

        btnChatbot.setBackground(new java.awt.Color(187, 114, 195));
        btnChatbot.setFont(new java.awt.Font("STFangsong", 1, 24)); // NOI18N
        btnChatbot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame (6).png"))); // NOI18N
        btnChatbot.setText("ChatBot");
        btnChatbot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChatbot.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnChatbot.setIconTextGap(20);
        btnChatbot.addActionListener(this::btnChatbotActionPerformed);

        btnCredits.setBackground(new java.awt.Color(187, 114, 195));
        btnCredits.setFont(new java.awt.Font("STFangsong", 1, 24)); // NOI18N
        btnCredits.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame (8).png"))); // NOI18N
        btnCredits.setText("Credits");
        btnCredits.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCredits.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCredits.setIconTextGap(20);
        btnCredits.addActionListener(this::btnCreditsActionPerformed);

        btnExit.setBackground(new java.awt.Color(255, 102, 128));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame (10).png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExit.setIconTextGap(20);
        btnExit.addActionListener(this::btnExitActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChatbot, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDash, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnData, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnDash, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChatbot, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnData, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.WEST);

        jPanel4.setBackground(new java.awt.Color(102, 0, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel4.setLayout(new java.awt.BorderLayout(20, 20));

        jPanel6.setBackground(new java.awt.Color(255, 102, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 791, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(90, 31, 97));
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 24, 0, 20));
        jPanel5.setPreferredSize(new java.awt.Dimension(1101, 50));
        jPanel5.setLayout(new java.awt.BorderLayout(20, 0));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dashboard");
        jPanel5.add(jLabel3, java.awt.BorderLayout.CENTER);

        jToggleButton1.setBackground(new java.awt.Color(90, 31, 97));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu.png"))); // NOI18N
        jToggleButton1.setBorder(null);
        jToggleButton1.setBorderPainted(false);
        jToggleButton1.setContentAreaFilled(false);
        jToggleButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButton1.setFocusPainted(false);
        jToggleButton1.setMaximumSize(new java.awt.Dimension(30, 30));
        jToggleButton1.setMinimumSize(new java.awt.Dimension(30, 30));
        jToggleButton1.setPreferredSize(new java.awt.Dimension(30, 30));
        jToggleButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/menu.png"))); // NOI18N
        jToggleButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/menu.png"))); // NOI18N
        jToggleButton1.addActionListener(this::jToggleButton1ActionPerformed);
        jPanel5.add(jToggleButton1, java.awt.BorderLayout.LINE_START);

        jPanel1.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuizActionPerformed
        jLabel3.setText("Quiz");
        
// TODO add your handling code here:
        //quizPanel quiz = new quizPanel();
        //switchPanel(quiz);
        //currentPanel = quiz;
        quizMainPanel quizMain = new quizMainPanel();
        switchPanel(quizMain);
        currentPanel = quizMain;
    }//GEN-LAST:event_btnQuizActionPerformed

    private void btnDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataActionPerformed
        jLabel3.setText("Data Visualization");
        
// TODO add your handling code here:
        DataVisualization data = new DataVisualization();
        switchPanel(data);
        currentPanel = data;
    }//GEN-LAST:event_btnDataActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        LoginForm frm = new LoginForm();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashActionPerformed
        jLabel3.setText("Dashboard");
        DashboardPanel data = new DashboardPanel();
        switchPanel(data);
        currentPanel = data;
    }//GEN-LAST:event_btnDashActionPerformed

    private void btnChatbotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatbotActionPerformed
        jLabel3.setText("Chatbot");

    }//GEN-LAST:event_btnChatbotActionPerformed

    private void btnCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreditsActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
// 1. Show the Confirm Dialog
    int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this, 
            "Are you sure you want to exit the quiz?", 
            "Confirm Exit", 
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE
    );

    // 2. Check the user's choice
    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        System.exit(0);
    }    }//GEN-LAST:event_btnExitActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected()) {
            jPanel3.setVisible(false);
        } else {
            jPanel3.setVisible(true);

        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new DashboardForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnChatbot;
    private javax.swing.JButton btnCredits;
    public javax.swing.JButton btnDash;
    private javax.swing.JButton btnData;
    public javax.swing.JButton btnExit;
    public javax.swing.JButton btnLogout;
    public javax.swing.JButton btnQuiz;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
