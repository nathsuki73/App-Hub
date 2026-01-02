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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
        initCustomFont();
        
        CreateMessage();
        CreateMessage();
        CreateMessage();
        CreateMessage();
        CreateMessage();
    }

    
     class RoundedButton extends JButton {
        private int radius;
        private Color normalColor = new Color (84,16,103);
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

        txtSearchText.setFont(myFont.deriveFont(Font.PLAIN ,16f));
        txtSearchText.setForeground(new java.awt.Color(150, 150, 150));
        txtSearchText.setText("Ask anything...");
        
        
        
    } catch (FontFormatException e) {
        System.err.println("The font file is corrupted or not a valid TTF.");
        e.printStackTrace();
    } catch (IOException e) {
        System.err.println("Could not load the font file. Check the path!");
        e.printStackTrace();
    }
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageContainer = new javax.swing.JPanel();
        jPanel1 = new RoundedPanel(40);
        txtSearchText = new javax.swing.JTextField();
        jButton1 = new RoundedButton("", 40);

        setBackground(new java.awt.Color(52, 8, 69));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(52, 8, 69));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setBackground(new java.awt.Color(52, 8, 69));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 600));
        jScrollPane1.setViewportView(messageContainer);

        messageContainer.setBackground(new java.awt.Color(52, 8, 69));
        messageContainer.setMaximumSize(new java.awt.Dimension(100, 100));
        messageContainer.setMinimumSize(new java.awt.Dimension(100, 100));
        messageContainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageContainerMouseClicked(evt);
            }
        });
        messageContainer.setLayout(new javax.swing.BoxLayout(messageContainer, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(messageContainer);

        jPanel2.add(jScrollPane1, new java.awt.GridBagConstraints());

        jPanel1.setBackground(new java.awt.Color(84, 16, 103));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 60));
        jPanel1.setLayout(new java.awt.BorderLayout(20, 0));

        txtSearchText.setBackground(new java.awt.Color(84, 16, 103));
        txtSearchText.setForeground(new java.awt.Color(255, 255, 255));
        txtSearchText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtSearchText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchTextFocusLost(evt);
            }
        });
        jPanel1.add(txtSearchText, java.awt.BorderLayout.CENTER);

        jButton1.setBackground(new java.awt.Color(84, 16, 103));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Group 14.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setPreferredSize(new java.awt.Dimension(40, 40));
        jPanel1.add(jButton1, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(26, 0, 0, 0);
        jPanel2.add(jPanel1, gridBagConstraints);

        add(jPanel2, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.requestFocusInWindow();
    }//GEN-LAST:event_formMouseClicked

    private void txtSearchTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchTextFocusLost
        if (txtSearchText.getText().isEmpty()) {
            // Change back to a dim color for the placeholder
            txtSearchText.setForeground(new java.awt.Color(150, 150, 150));
            txtSearchText.setText("Ask anything...");
        }
    }//GEN-LAST:event_txtSearchTextFocusLost

    private void txtSearchTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchTextFocusGained
        if (txtSearchText.getText().equals("Ask anything...")) {
            txtSearchText.setText("");
            // Change to a bright color for actual typing
            txtSearchText.setForeground(java.awt.Color.WHITE);
        }
    }//GEN-LAST:event_txtSearchTextFocusGained

    private void messageContainerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageContainerMouseClicked
                this.requestFocusInWindow();

    }//GEN-LAST:event_messageContainerMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel messageContainer;
    private javax.swing.JTextField txtSearchText;
    // End of variables declaration//GEN-END:variables
}
