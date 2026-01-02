/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.app.hub;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author segov
 */
public class ChatbotPanel extends javax.swing.JPanel {

    /**
     * Creates new form ChatbotPanel
     */
    public ChatbotPanel() {
        initComponents();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(5);
        CreateMessage();
        CreateMessage();
        CreateMessage();
        CreateMessage();
        CreateMessage();
    }

    
    private void CreateMessage() {
        
        
    // 1. Create the main container for this specific message
    // GridLayout(rows, columns) -> 2 rows, 1 column
    JPanel messageWrapper = new JPanel(new java.awt.GridLayout(2, 1, 0, 5)); 
    messageWrapper.setOpaque(false); // Make wrapper transparent
    // This tells the layout: "Stay 300 wide, but only as tall as your content"
    messageWrapper.setMaximumSize(new Dimension(300, 50));
    messageWrapper.setAlignmentX(Component.LEFT_ALIGNMENT); // Keeps it pinned to the left
    // 2. First Row: The Sender/Time Label
    JLabel lblName = new JLabel("User Name");
    ImageIcon icon = new ImageIcon(getClass().getResource("/bot.png"));
    lblName.setIcon(icon);
    
    // 3. Second Row: The Message Bubble (RoundedPanel)
    // We give the RoundedPanel its own layout to center the text inside it
    RoundedPanel pnlMessage = new RoundedPanel(20); 
    pnlMessage.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 10));
    pnlMessage.setBackground(new Color(84,16,103)); // Light green bubble
    //    [84,16,103]
    // [102,0,102]
    
    
    String text = "wrap dynamically based on the variable!";

    
    // Define the max width for the text portion
    // 1. Create a dummy label to get the default font metrics
    JLabel tempLabel = new JLabel();
    FontMetrics metrics = tempLabel.getFontMetrics(tempLabel.getFont());

    // 2. Calculate total pixel width of the raw string
    int textPixelWidth = metrics.stringWidth(text);

    // 3. Define your logic for dynamicWidth
    // Example: If text is wider than 400px, wrap it at 400px. Otherwise, fit to text.
    int maxWidth = 500;
    int dynamicWidth = Math.min(textPixelWidth, maxWidth);
    JLabel lblContent = new JLabel("<html><body style='width: " + dynamicWidth + "px'>" + text + "</body></html>");
    pnlMessage.add(lblContent);

    // 4. Add components to the wrapper
    messageWrapper.add(lblName);   // Row 1
    messageWrapper.add(pnlMessage); // Row 2
    
    messageWrapper.setMaximumSize(new Dimension(dynamicWidth + 180, messageWrapper.getPreferredSize().height + 50));    // 5. Add the wrapper to your main scrollable container (the one we discussed earlier)
    messageWrapper.setAlignmentX(Component.LEFT_ALIGNMENT);
    
    lblContent.setForeground(Color.WHITE);
    lblName.setForeground(Color.WHITE);

    messageContainer.add(messageWrapper);
    messageContainer.add(javax.swing.Box.createVerticalStrut(10));
    
    try {
        InputStream is = getClass().getResourceAsStream("/fonts/inter.ttf"); 
        if (is == null) {
            throw new IOException("Font file not found in resources folder!");
        }

        Color customPurple = new Color(132,81,138);
        Font myFont = Font.createFont(Font.TRUETYPE_FONT, is);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(myFont);
        
        lblName.setFont(myFont.deriveFont(Font.PLAIN, 20f));
        lblContent.setFont(myFont.deriveFont(Font.PLAIN, 16f));
        
        
    } catch (FontFormatException e) {
        System.err.println("The font file is corrupted or not a valid TTF.");
        e.printStackTrace();
    } catch (IOException e) {
        System.err.println("Could not load the font file. Check the path!");
        e.printStackTrace();
    }
    
    
    
    
    // Refresh UI
    messageContainer.revalidate();
    messageContainer.repaint();
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        messageContainer = new javax.swing.JPanel();

        setBackground(new java.awt.Color(52, 8, 69));
        setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setBackground(new java.awt.Color(52, 8, 69));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 600));
        jScrollPane1.setViewportView(messageContainer);

        messageContainer.setBackground(new java.awt.Color(52, 8, 69));
        messageContainer.setMaximumSize(new java.awt.Dimension(100, 100));
        messageContainer.setMinimumSize(new java.awt.Dimension(100, 100));
        messageContainer.setLayout(new javax.swing.BoxLayout(messageContainer, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(messageContainer);

        add(jScrollPane1, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel messageContainer;
    // End of variables declaration//GEN-END:variables
}
