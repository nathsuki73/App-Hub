/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.app.hub;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

/**
 *
 * @author Gio Andrew Briones
 */
public class quizPanel extends javax.swing.JPanel {

    /**
     * Creates new form quizPanel
     */
    public quizPanel() {
        initComponents();
        generateButtonGroup();
        //Collections.shuffle(quiz);
        showQuestion(currentIndex);
        t.start();
        updateTimer();
        allButtons = new JRadioButton[]{opt1, opt2, opt3, opt4};
    }
    
    private ButtonGroup grp = new ButtonGroup();
    private JRadioButton selectedButton = null;
    private JRadioButton[] allButtons;
    private int selectedOption = 0;
    private int currentIndex = 0;
    private int timeRemain = 11;
    private int score = 0;
    private Timer t = new Timer(1000, e -> updateTimer());
    private ArrayList<Color> preview = new ArrayList<>();
    
    private void generateButtonGroup()
    {
        grp.add(opt1);
        grp.add(opt2);
        grp.add(opt3);
        grp.add(opt4);
    }
    
    class quizQuestions {
        String questionText;
        String[] options;
        int correctAnswer;
        
        public quizQuestions(String text, String[] opt, int answer)
        {
            questionText = text;
            options = opt;
            correctAnswer = answer;
        }
    }
    
    public void showQuestion(int index)
    {
        quizQuestions q = quiz.get(index);
        lblQuestion.setText(q.questionText);
        opt1.setText(q.options[0]);
        opt2.setText(q.options[1]);
        opt3.setText(q.options[2]);
        opt4.setText(q.options[3]);
        grp.clearSelection();
        timeRemain = 10;
        lblTimer.setText("Time Left: " + timeRemain);
        t.restart();
        nextBtn.setEnabled(false);
        
    }
    
    private void MsgAlert(String msg, int icon, String title)
    {
        JOptionPane opt = new JOptionPane();
        opt.setMessage(msg);
        opt.setMessageType(icon);
        JDialog dialog = opt.createDialog(this, title);
        dialog.setVisible(true);
                
    }
    
    private ArrayList<quizQuestions> quiz = new ArrayList<>(List.of(
        new quizQuestions("What is 15 + 27?", new String[]{"32", "42", "45", "38"}, 1),
        new quizQuestions("What is 12 x 8?", new String[]{"86", "94", "96", "102"}, 2),
        new quizQuestions("What is 144 / 12?", new String[]{"10", "11", "12", "13"}, 2),
        new quizQuestions("What is 9 x 7?", new String[]{"63", "56", "72", "64"}, 0),
        new quizQuestions("What is 150 - 85?", new String[]{"75", "65", "55", "45"}, 1),
        new quizQuestions("What is 5 cubed (5^3)?", new String[]{"15", "25", "125", "75"}, 2),
        new quizQuestions("What is the square root of 81?", new String[]{"7", "8", "9", "10"}, 2),
        new quizQuestions("What is 20% of 200?", new String[]{"20", "40", "50", "30"}, 1),
        new quizQuestions("What is 11 + 11 + 11?", new String[]{"22", "33", "44", "11"}, 1),
        new quizQuestions("What is 72 / 9?", new String[]{"6", "7", "8", "9"}, 2),
        new quizQuestions("What is 13 x 3?", new String[]{"36", "39", "42", "33"}, 1),
        new quizQuestions("What is 500 / 25?", new String[]{"20", "25", "15", "10"}, 0),
        new quizQuestions("What is 17 + 19?", new String[]{"34", "36", "38", "32"}, 1),
        new quizQuestions("What is 100 - 37?", new String[]{"63", "73", "53", "67"}, 0),
        new quizQuestions("What is 8 x 6?", new String[]{"42", "46", "48", "54"}, 2),
        new quizQuestions("What is 10 x 10 x 10?", new String[]{"100", "1,000", "10,000", "1,000,000"}, 1),
        new quizQuestions("What is 1/2 + 1/4?", new String[]{"1/2", "3/4", "1/4", "1/6"}, 1)
    ));
    
    private void updateTimer()
    {
        timeRemain--;
        lblTimer.setText("Time Left: " + timeRemain);
        
        if (timeRemain <= 0)
        {
            t.stop();
            MsgAlert("Your Time is Up!", JOptionPane.ERROR_MESSAGE, "Time's Up!");
            currentIndex++;
            showQuestion(currentIndex);
            t.restart();
            timeRemain = 11;
        }
        
    }
    
    class RoundedButton extends JButton {
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
    
    private void goToSummary()
    {
        quizSummary summary = new quizSummary();
        Container parent = this.getParent();
        parent.remove(this);
        parent.add(summary);
        parent.revalidate();
        parent.repaint();
        
        if (score <= 17 && score >= 14)
        {
            summary.setResults("Excellent!", score, preview);
        }
        else if (score < 14 && score >= 10)
        {
            summary.setResults("Very Good!", score, preview);
        }
        else if (score < 10 && score > 6)
        {
            summary.setResults("Fair", score, preview);
        }
        else if (score < 6 && score >= 0)
        {
            summary.setResults("Failed", score, preview);
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

        lblQuestion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        opt1 = new javax.swing.JRadioButton();
        opt2 = new javax.swing.JRadioButton();
        opt3 = new javax.swing.JRadioButton();
        opt4 = new javax.swing.JRadioButton();
        submitBtn = new RoundedButton("SUBMIT ANSWER", 30);
        lblTimer = new javax.swing.JLabel();
        nextBtn = new RoundedButton("NEXT QUESTION", 30);

        setBackground(new java.awt.Color(102, 0, 102));
        setPreferredSize(new java.awt.Dimension(831, 536));

        lblQuestion.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblQuestion.setForeground(new java.awt.Color(204, 204, 255));
        lblQuestion.setText("This is a sample question");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 72)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("Math Quiz");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 56)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setText("QUESTION:");

        opt1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        opt1.setForeground(new java.awt.Color(204, 204, 255));
        opt1.setText("Option 1");
        opt1.setContentAreaFilled(false);

        opt2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        opt2.setForeground(new java.awt.Color(204, 204, 255));
        opt2.setText("Option 1");
        opt2.setContentAreaFilled(false);

        opt3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        opt3.setForeground(new java.awt.Color(204, 204, 255));
        opt3.setText("Option 1");
        opt3.setContentAreaFilled(false);

        opt4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        opt4.setForeground(new java.awt.Color(204, 204, 255));
        opt4.setText("Option 1");
        opt4.setContentAreaFilled(false);

        submitBtn.setBackground(new java.awt.Color(204, 0, 204));
        submitBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(204, 204, 255));
        submitBtn.setText("SUBMIT ANSWER");
        submitBtn.setBorder(null);
        submitBtn.setBorderPainted(false);
        submitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitBtn.addActionListener(this::submitBtnActionPerformed);

        lblTimer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(153, 153, 153));
        lblTimer.setText("Time Left:");

        nextBtn.setBackground(new java.awt.Color(204, 0, 204));
        nextBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        nextBtn.setForeground(new java.awt.Color(204, 204, 255));
        nextBtn.setText("NEXT QUESTION");
        nextBtn.setBorder(null);
        nextBtn.setBorderPainted(false);
        nextBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextBtn.addActionListener(this::nextBtnActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(opt1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(opt3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(opt2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(opt4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(lblQuestion)))
                .addGap(142, 142, 142)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opt1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opt3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opt2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opt4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // TODO add your handling code here:
        if (currentIndex == 16)
        {
            goToSummary();
        }
        
        for (JRadioButton j : allButtons)
        {
            j.setOpaque(false);
        }
        //selectedButton.setOpaque(false);
        submitBtn.setEnabled(true);
        nextBtn.setEnabled(false);
        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);
        currentIndex++;
        showQuestion(currentIndex);
        selectedButton = null;
    }//GEN-LAST:event_nextBtnActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        quizQuestions q = quiz.get(currentIndex);
        selectedButton = null;
        selectedOption = -1;

        if(!opt1.isSelected() && !opt2.isSelected() && !opt3.isSelected() && !opt4.isSelected())
        {
            for (JRadioButton j : allButtons)
            {
                j.setOpaque(true);
                j.setEnabled(false);
                j.setBackground(Color.RED);
            }
            preview.add(Color.RED);
            submitBtn.setEnabled(false);
            nextBtn.setEnabled(true);
            return;
        }

        if (opt1.isSelected())
        {
            selectedButton = opt1;
        }
        else if (opt2.isSelected())
        {
            selectedButton = opt2;
        }
        else if (opt3.isSelected())
        {
            selectedButton = opt3;
        }
        else if (opt4.isSelected())
        {
            selectedButton = opt4;
        }

        if (selectedButton == opt1)
        {
            selectedOption = 0;
        }
        else if (selectedButton == opt2)
        {
            selectedOption = 1;
        }
        else if (selectedButton == opt3)
        {
            selectedOption = 2;
        }
        else if (selectedButton == opt4)
        {
            selectedOption = 3;
        }

        if (selectedOption == q.correctAnswer)
        {
            t.stop();
            score++;
            selectedButton.setOpaque(true);
            selectedButton.setBackground(Color.GREEN);
            preview.add(Color.GREEN);
            //MsgAlert("Your Answer is Correct", JOptionPane.INFORMATION_MESSAGE, "Correct");
        }
        else
        {
            t.stop();
            selectedButton.setOpaque(true);
            selectedButton.setBackground(Color.RED);
            preview.add(Color.RED);
            //MsgAlert("Your Answer is Incorrect", JOptionPane.ERROR_MESSAGE, "Incorrect");
        }

        opt1.setEnabled(false);
        opt2.setEnabled(false);
        opt3.setEnabled(false);
        opt4.setEnabled(false);
        submitBtn.setEnabled(false);
        nextBtn.setEnabled(true);
    }//GEN-LAST:event_submitBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JButton nextBtn;
    private javax.swing.JRadioButton opt1;
    private javax.swing.JRadioButton opt2;
    private javax.swing.JRadioButton opt3;
    private javax.swing.JRadioButton opt4;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}

