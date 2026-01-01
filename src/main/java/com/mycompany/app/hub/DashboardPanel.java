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

        
        btnDash.setFont(myFont.deriveFont(Font.PLAIN, 20f));
        
        
    } catch (FontFormatException e) {
        System.err.println("The font file is corrupted or not a valid TTF.");
        e.printStackTrace();
    } catch (IOException e) {
        System.err.println("Could not load the font file. Check the path!");
        e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnDash = new RoundedButton("Quiz Game",30);
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 204));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("Welcome Mango, Graham!");

        jLabel6.setText("Description");

        jLabel7.setText("January 1, 2020");

        jLabel8.setText("12:00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 2363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(775, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(21, 21, 21))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(737, 400));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(255, 204, 204));
        jPanel8.setLayout(new java.awt.GridLayout(1, 4, 20, 0));

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Group 2 (1).png"))); // NOI18N
        jLabel3.setVerifyInputWhenFocusTarget(false);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel3.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        btnDash.setBackground(new java.awt.Color(187, 114, 195));
        btnDash.setFont(new java.awt.Font("STFangsong", 1, 24)); // NOI18N
        btnDash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard.png"))); // NOI18N
        btnDash.setText("Dashboard");
        btnDash.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDash.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDash.setIconTextGap(20);
        btnDash.addActionListener(this::btnDashActionPerformed);
        jPanel3.add(btnDash, java.awt.BorderLayout.PAGE_END);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("jLabel4");
        jPanel7.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        jLabel5.setText("jLabel5");
        jPanel7.add(jLabel5, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(153, 255, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(153, 255, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(102, 0, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel6);

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel9.setBackground(new java.awt.Color(255, 51, 51));
        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 0, 20, 0));
        jPanel9.setPreferredSize(new java.awt.Dimension(915, 50));

        jLabel2.setText("Our Collections");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(3083, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashActionPerformed
        
    }//GEN-LAST:event_btnDashActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDash;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
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
