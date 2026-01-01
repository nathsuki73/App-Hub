/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.app.hub;

import java.awt.Color;
import java.awt.Container;
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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gio Andrew Briones
 */
public class quizSummary extends javax.swing.JPanel {

    /**
     * Creates new form quizSummary
     */
    public quizSummary() {
        initComponents();
        lblPreviews.add(lbl1);
        lblPreviews.add(lbl2);
        lblPreviews.add(lbl3);
        lblPreviews.add(lbl4);
        lblPreviews.add(lbl5);
        lblPreviews.add(lbl6);
        lblPreviews.add(lbl7);
        lblPreviews.add(lbl8);
        lblPreviews.add(lbl9);
        lblPreviews.add(lbl10);
        lblPreviews.add(lbl11);
        lblPreviews.add(lbl12);
        lblPreviews.add(lbl13);
        lblPreviews.add(lbl14);
        lblPreviews.add(lbl15);
        lblPreviews.add(lbl16);
        lblPreviews.add(lbl17);
        initCustomFont();
    }
    public ArrayList<JLabel> lblPreviews = new ArrayList<JLabel>();
    
    public void setResults(String remarks, int score, ArrayList<Color> preview)
    {
        lblRemarks.setText("Remarks: " + remarks);
        lblScore.setText("Total Score: " + (Integer.toString(score)) + " / 17");
        for (int i = 0; i < lblPreviews.size(); i++)
        {
            JLabel lbl = lblPreviews.get(i);
            Color currentPrev = preview.get(i);
            lbl.setOpaque(true);
            lbl.setBackground(currentPrev);
            if (currentPrev == Color.GREEN)
            {
                lbl.setForeground(Color.GRAY);
            }
        }
    }
    
    class RoundedButton extends JButton 
    {
        private int radius;
        private Color normalColor = new Color (187, 114, 195);
        private Color hoverColor = Color.WHITE;
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
                    setForeground(normalColor);
                }
                
                @Override
                public void mouseExited(MouseEvent e)
                {
                    if (!isEnabled()) return;
                    setBackground(normalColor);
                    setForeground(originalTextColor);
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
    
    public void initCustomFont()
    {
       try
       {
           InputStream is = getClass().getResourceAsStream("/fonts/inter.ttf");
           if (is == null)
           {
               throw new IOException("Font file not found in resources folder!");
           }
           
           Color customPurple = new Color(132, 81, 138);
           Font myFont = Font.createFont(Font.TRUETYPE_FONT, is);
           
           GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
           ge.registerFont(myFont);
           
           jLabel2.setFont(myFont.deriveFont(Font.BOLD, 72f));
           lblRemarks.setFont(myFont.deriveFont(Font.PLAIN, 36f));
           lblScore.setFont(myFont.deriveFont(Font.PLAIN, 36f));
           lblQuestion2.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl1.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl2.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl3.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl4.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl5.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl6.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl7.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl8.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl9.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl10.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl11.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl12.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl13.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl14.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl15.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl16.setFont(myFont.deriveFont(Font.BOLD, 36f));
           lbl17.setFont(myFont.deriveFont(Font.BOLD, 36f));
       }
       catch (FontFormatException e)
       {
           System.err.println("The font file is corrupted or not a valid TTF.");
           e.printStackTrace();
       }
       catch (IOException e)
       {
           System.err.println("Could not load the font file. Check the path!");
           e.printStackTrace();
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

        jPanel1 = new RoundedPanel(20);
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        lbl12 = new javax.swing.JLabel();
        lbl13 = new javax.swing.JLabel();
        lbl14 = new javax.swing.JLabel();
        lbl15 = new javax.swing.JLabel();
        lbl16 = new javax.swing.JLabel();
        lbl17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblRemarks = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        lblQuestion2 = new javax.swing.JLabel();
        lblQuestion18 = new javax.swing.JLabel();
        exitBtn = new RoundedButton("EXIT", 30);

        setBackground(new java.awt.Color(102, 0, 102));

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

        lbl1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl1.setForeground(new java.awt.Color(204, 204, 255));
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setText("1");

        lbl2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl2.setForeground(new java.awt.Color(204, 204, 255));
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2.setText("2");

        lbl3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl3.setForeground(new java.awt.Color(204, 204, 255));
        lbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl3.setText("3");

        lbl4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl4.setForeground(new java.awt.Color(204, 204, 255));
        lbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl4.setText("4");

        lbl5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl5.setForeground(new java.awt.Color(204, 204, 255));
        lbl5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl5.setText("5");

        lbl6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl6.setForeground(new java.awt.Color(204, 204, 255));
        lbl6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl6.setText("6");

        lbl7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl7.setForeground(new java.awt.Color(204, 204, 255));
        lbl7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl7.setText("7");

        lbl8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl8.setForeground(new java.awt.Color(204, 204, 255));
        lbl8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl8.setText("8");

        lbl9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl9.setForeground(new java.awt.Color(204, 204, 255));
        lbl9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl9.setText("9");

        lbl10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl10.setForeground(new java.awt.Color(204, 204, 255));
        lbl10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl10.setText("10");

        lbl11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl11.setForeground(new java.awt.Color(204, 204, 255));
        lbl11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl11.setText("11");

        lbl12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl12.setForeground(new java.awt.Color(204, 204, 255));
        lbl12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl12.setText("12");

        lbl13.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl13.setForeground(new java.awt.Color(204, 204, 255));
        lbl13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl13.setText("13");

        lbl14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl14.setForeground(new java.awt.Color(204, 204, 255));
        lbl14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl14.setText("14");

        lbl15.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl15.setForeground(new java.awt.Color(204, 204, 255));
        lbl15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl15.setText("15");

        lbl16.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl16.setForeground(new java.awt.Color(204, 204, 255));
        lbl16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl16.setText("16");

        lbl17.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl17.setForeground(new java.awt.Color(204, 204, 255));
        lbl17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl17.setText("17");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl1)
                    .addComponent(lbl2)
                    .addComponent(lbl3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl4)
                    .addComponent(lbl5)
                    .addComponent(lbl6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl7)
                    .addComponent(lbl8)
                    .addComponent(lbl9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl10)
                    .addComponent(lbl11)
                    .addComponent(lbl12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl14)
                        .addComponent(lbl15))
                    .addComponent(lbl13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl16)
                    .addComponent(lbl17))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 72)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("Quiz Summary");

        lblRemarks.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblRemarks.setForeground(new java.awt.Color(204, 204, 255));
        lblRemarks.setText("Remarks: ??");

        lblScore.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblScore.setForeground(new java.awt.Color(204, 204, 255));
        lblScore.setText("Total Score: ?? / 17");

        lblQuestion2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblQuestion2.setForeground(new java.awt.Color(204, 204, 255));
        lblQuestion2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblQuestion2.setText("Answers Preview");

        lblQuestion18.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblQuestion18.setForeground(new java.awt.Color(204, 204, 255));
        lblQuestion18.setText("Leaderboard");

        exitBtn.setBackground(new java.awt.Color(204, 0, 204));
        exitBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        exitBtn.setForeground(new java.awt.Color(204, 204, 255));
        exitBtn.setText("EXIT");
        exitBtn.setBorder(null);
        exitBtn.setBorderPainted(false);
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.addActionListener(this::exitBtnActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRemarks, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblQuestion2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(269, 269, 269)
                                .addComponent(lblQuestion18)))
                        .addContainerGap(356, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(lblScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRemarks)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestion2)
                    .addComponent(lblQuestion18))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
    // 1. Get the existing Dashboard window
    DashboardForm dash = (DashboardForm) javax.swing.SwingUtilities.getWindowAncestor(this);
    
    if (dash != null) {
        // 2. IMPORTANT: Tell the dashboard that 'this' is the panel it needs to remove
        dash.currentPanel = this; 
        
        // 3. Switch back to your main dashboard subpanel (jPanel4)
        dash.switchPanel(dash.jPanel4); 
    }

    }//GEN-LAST:event_exitBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl13;
    private javax.swing.JLabel lbl14;
    private javax.swing.JLabel lbl15;
    private javax.swing.JLabel lbl16;
    private javax.swing.JLabel lbl17;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JLabel lblQuestion18;
    private javax.swing.JLabel lblQuestion2;
    private javax.swing.JLabel lblRemarks;
    private javax.swing.JLabel lblScore;
    // End of variables declaration//GEN-END:variables
}
