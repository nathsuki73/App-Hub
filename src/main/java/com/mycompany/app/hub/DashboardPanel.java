/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.app.hub;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
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
 * @author segov
 */
public class DashboardPanel extends javax.swing.JPanel {

    /**
     * Creates new form DashboardPanel
     */
    public DashboardPanel() {
        initComponents();
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        initCustomFont();
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
        jLabel1.setFont(myFont.deriveFont(Font.BOLD ,32f));
        jLabel6.setFont(myFont.deriveFont(Font.PLAIN ,24f));
        jLabel9.setFont(myFont.deriveFont(Font.BOLD ,72f));
        jLabel10.setFont(myFont.deriveFont(Font.PLAIN ,24f));
        jLabel2.setFont(myFont.deriveFont(Font.BOLD ,24f));

        jLabel4.setFont(myFont.deriveFont(Font.BOLD ,18f));
        jLabel7.setFont(myFont.deriveFont(Font.BOLD ,18f));
        jLabel12.setFont(myFont.deriveFont(Font.BOLD ,18f));
        jLabel15.setFont(myFont.deriveFont(Font.BOLD ,18f));
        
        jLabel5.setFont(myFont.deriveFont(Font.PLAIN ,12f));
        jLabel8.setFont(myFont.deriveFont(Font.PLAIN ,12f));
        jLabel13.setFont(myFont.deriveFont(Font.PLAIN ,12f));
        jLabel16.setFont(myFont.deriveFont(Font.PLAIN ,12f));
        
        
        jLabel5.setText(
    "<html>" +
    "Talks back instantly, never sleeps,<br>" +
    "and somehow always has an opinion.<br>" +
    "Use responsibly." +
    "</html>"
);
        jLabel8.setText(
    "<html>" +
    "Lift heavy numbers, drop weak guesses.<br>" +
    "Your brain may sweat.<br>" +
    "No refunds for wrong answers." +
    "</html>"
);
        jLabel13.setText(
    "<html>" +
    "Important data,<br>" +
    "aggressively visualized.<br>" +
    "If it looks smart, it probably is." +
    "</html>"
);
        jLabel16.setText(
    "<html>" +
    "Meet the legends, gremlins,<br>" +
    "and caffeine-powered humans<br>" +
    "behind this masterpiece." +
    "</html>"
);
        
        
        jLabel3.setFont(myFont.deriveFont(Font.PLAIN ,24f));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);

        
        btnDash.setFont(myFont.deriveFont(Font.PLAIN, 20f));
        btnDash1.setFont(myFont.deriveFont(Font.PLAIN, 20f));
        btnDash2.setFont(myFont.deriveFont(Font.PLAIN, 20f));
        btnDash3.setFont(myFont.deriveFont(Font.PLAIN, 20f));
        
        
    } catch (FontFormatException e) {
        System.err.println("The font file is corrupted or not a valid TTF.");
        e.printStackTrace();
    } catch (IOException e) {
        System.err.println("Could not load the font file. Check the path!");
        e.printStackTrace();
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

        jPanel1 = new RoundedPanel(50);
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new RoundedPanel(50);
        jLabel3 = new javax.swing.JLabel();
        btnDash = new RoundedButton("Quiz Game",30);
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new RoundedPanel(50);
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnDash1 = new RoundedButton("Quiz Game",30);
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new RoundedPanel(50);
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnDash2 = new RoundedButton("Quiz Game",30);
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new RoundedPanel(50);
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnDash3 = new RoundedButton("Quiz Game",30);
        jLabel17 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 0, 102));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(84, 16, 103));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome Mango, Graham!");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Description");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("00:00");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("January 1, 2020");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(549, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(57, 57, 57))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(737, 400));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(102, 0, 102));
        jPanel8.setLayout(new java.awt.GridLayout(1, 4, 20, 0));

        jPanel3.setBackground(new java.awt.Color(52, 8, 69));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Group 6.png"))); // NOI18N
        jLabel3.setVerifyInputWhenFocusTarget(false);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel3.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        btnDash.setBackground(new java.awt.Color(187, 114, 195));
        btnDash.setFont(new java.awt.Font("STFangsong", 1, 24)); // NOI18N
        btnDash.setText("Start");
        btnDash.setBorder(null);
        btnDash.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDash.setIconTextGap(20);
        btnDash.setPreferredSize(new java.awt.Dimension(48, 43));
        btnDash.addActionListener(this::btnDashActionPerformed);
        jPanel3.add(btnDash, java.awt.BorderLayout.PAGE_END);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel4.setBackground(new java.awt.Color(52, 8, 69));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("The Digital Yapper 67");
        jLabel4.setOpaque(true);
        jPanel7.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        jLabel5.setBackground(new java.awt.Color(52, 8, 69));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Description");
        jLabel5.setOpaque(true);
        jLabel5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel7.add(jLabel5, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(84, 16, 103));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel7.setBackground(new java.awt.Color(84, 16, 103));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Math Brain Gym");
        jLabel7.setOpaque(true);
        jPanel10.add(jLabel7, java.awt.BorderLayout.PAGE_START);

        jLabel8.setBackground(new java.awt.Color(84, 16, 103));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Description");
        jLabel8.setOpaque(true);
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel10.add(jLabel8, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel10, java.awt.BorderLayout.CENTER);

        btnDash1.setBackground(new java.awt.Color(187, 114, 195));
        btnDash1.setFont(new java.awt.Font("STFangsong", 1, 24)); // NOI18N
        btnDash1.setText("Start");
        btnDash1.setBorder(null);
        btnDash1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDash1.setIconTextGap(20);
        btnDash1.setPreferredSize(new java.awt.Dimension(48, 43));
        btnDash1.addActionListener(this::btnDash1ActionPerformed);
        jPanel4.add(btnDash1, java.awt.BorderLayout.PAGE_END);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Group 2 (1).png"))); // NOI18N
        jLabel11.setVerifyInputWhenFocusTarget(false);
        jLabel11.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel4.add(jLabel11, java.awt.BorderLayout.PAGE_START);

        jPanel8.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(52, 8, 69));
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel12.setBackground(new java.awt.Color(52, 8, 69));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fancy Squiggly Lines");
        jLabel12.setOpaque(true);
        jPanel11.add(jLabel12, java.awt.BorderLayout.PAGE_START);

        jLabel13.setBackground(new java.awt.Color(52, 8, 69));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Description");
        jLabel13.setOpaque(true);
        jLabel13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel11.add(jLabel13, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel11, java.awt.BorderLayout.CENTER);

        btnDash2.setBackground(new java.awt.Color(187, 114, 195));
        btnDash2.setFont(new java.awt.Font("STFangsong", 1, 24)); // NOI18N
        btnDash2.setText("Start");
        btnDash2.setBorder(null);
        btnDash2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDash2.setIconTextGap(20);
        btnDash2.setPreferredSize(new java.awt.Dimension(48, 43));
        btnDash2.addActionListener(this::btnDash2ActionPerformed);
        jPanel5.add(btnDash2, java.awt.BorderLayout.PAGE_END);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Group 7.png"))); // NOI18N
        jLabel14.setVerifyInputWhenFocusTarget(false);
        jLabel14.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel5.add(jLabel14, java.awt.BorderLayout.PAGE_START);

        jPanel8.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(84, 16, 103));
        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel12.setLayout(new java.awt.BorderLayout());

        jLabel15.setBackground(new java.awt.Color(84, 16, 103));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Credit");
        jLabel15.setOpaque(true);
        jPanel12.add(jLabel15, java.awt.BorderLayout.PAGE_START);

        jLabel16.setBackground(new java.awt.Color(84, 16, 103));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Description");
        jLabel16.setOpaque(true);
        jLabel16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel12.add(jLabel16, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel12, java.awt.BorderLayout.CENTER);

        btnDash3.setBackground(new java.awt.Color(187, 114, 195));
        btnDash3.setFont(new java.awt.Font("STFangsong", 1, 24)); // NOI18N
        btnDash3.setText("Start");
        btnDash3.setBorder(null);
        btnDash3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDash3.setIconTextGap(20);
        btnDash3.setPreferredSize(new java.awt.Dimension(48, 43));
        btnDash3.addActionListener(this::btnDash3ActionPerformed);
        jPanel6.add(btnDash3, java.awt.BorderLayout.PAGE_END);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Group 8 (1).png"))); // NOI18N
        jLabel17.setVerifyInputWhenFocusTarget(false);
        jLabel17.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel6.add(jLabel17, java.awt.BorderLayout.PAGE_START);

        jPanel8.add(jPanel6);

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel9.setBackground(new java.awt.Color(102, 0, 102));
        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 0, 20, 0));
        jPanel9.setPreferredSize(new java.awt.Dimension(915, 70));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Our Collections");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(765, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashActionPerformed
        
    }//GEN-LAST:event_btnDashActionPerformed

    private void btnDash1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDash1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDash1ActionPerformed

    private void btnDash2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDash2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDash2ActionPerformed

    private void btnDash3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDash3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDash3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDash;
    public javax.swing.JButton btnDash1;
    public javax.swing.JButton btnDash2;
    public javax.swing.JButton btnDash3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
