/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Nico
 */
public class Calculator extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Calculator.class.getName());

    private Operation operator;
    private Integer result = 0;
    private boolean clearFlag = false;
    private Integer lastValue = 0;
    
            
    public Calculator() {
        initComponents();
        inputDisplay.setText("0");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        signSwitchButton = new javax.swing.JButton();
        historyDisplay = new javax.swing.JTextField();
        fourButton = new javax.swing.JButton();
        oneButton = new javax.swing.JButton();
        fiveButton = new javax.swing.JButton();
        zeroButton = new javax.swing.JButton();
        twoButton = new javax.swing.JButton();
        sixButton = new javax.swing.JButton();
        pointButton = new javax.swing.JButton();
        threeButton = new javax.swing.JButton();
        sevenButton = new javax.swing.JButton();
        multButton = new javax.swing.JButton();
        eightButton = new javax.swing.JButton();
        nineButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        clearAllButton = new javax.swing.JButton();
        minusButton = new javax.swing.JButton();
        plusButton = new javax.swing.JButton();
        divisionButton = new javax.swing.JButton();
        inputDisplay = new javax.swing.JTextField();
        equalButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(650, 200));

        signSwitchButton.setText("+/-");

        historyDisplay.setEditable(false);
        historyDisplay.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        historyDisplay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        historyDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyDisplayActionPerformed(evt);
            }
        });

        fourButton.setText("4");
        fourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourButtonActionPerformed(evt);
            }
        });

        oneButton.setText("1");
        oneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneButtonActionPerformed(evt);
            }
        });

        fiveButton.setText("5");
        fiveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveButtonActionPerformed(evt);
            }
        });

        zeroButton.setText("0");
        zeroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroButtonActionPerformed(evt);
            }
        });

        twoButton.setText("2");
        twoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoButtonActionPerformed(evt);
            }
        });

        sixButton.setText("6");
        sixButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sixButtonActionPerformed(evt);
            }
        });

        pointButton.setText(".");
        pointButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pointButtonActionPerformed(evt);
            }
        });

        threeButton.setText("3");
        threeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeButtonActionPerformed(evt);
            }
        });

        sevenButton.setText("7");
        sevenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sevenButtonActionPerformed(evt);
            }
        });

        multButton.setText("x");
        multButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multButtonActionPerformed(evt);
            }
        });

        eightButton.setText("8");
        eightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightButtonActionPerformed(evt);
            }
        });

        nineButton.setText("9");
        nineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nineButtonActionPerformed(evt);
            }
        });

        clearButton.setText("C");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        clearAllButton.setText("C/A");
        clearAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllButtonActionPerformed(evt);
            }
        });

        minusButton.setText("-");
        minusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusButtonActionPerformed(evt);
            }
        });

        plusButton.setText("+");
        plusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusButtonActionPerformed(evt);
            }
        });

        divisionButton.setText("/");
        divisionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divisionButtonActionPerformed(evt);
            }
        });

        inputDisplay.setEditable(false);
        inputDisplay.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        inputDisplay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inputDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDisplayActionPerformed(evt);
            }
        });

        equalButton.setText("=");
        equalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equalButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(historyDisplay)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fourButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(signSwitchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sevenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sixButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(zeroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pointButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(twoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(threeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(eightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(minusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(plusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(multButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(equalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(clearAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(divisionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(inputDisplay))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(historyDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(inputDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearAllButton)
                    .addComponent(clearButton)
                    .addComponent(divisionButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sevenButton)
                            .addComponent(eightButton)
                            .addComponent(nineButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fourButton)
                                .addGap(18, 18, 18)
                                .addComponent(oneButton)
                                .addGap(18, 18, 18)
                                .addComponent(signSwitchButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fiveButton)
                                    .addComponent(sixButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(twoButton)
                                    .addComponent(threeButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(zeroButton)
                                    .addComponent(pointButton)
                                    .addComponent(equalButton)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(multButton)
                        .addGap(18, 18, 18)
                        .addComponent(minusButton)
                        .addGap(18, 18, 18)
                        .addComponent(plusButton)
                        .addGap(41, 41, 41)))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pointButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pointButtonActionPerformed
        
    }//GEN-LAST:event_pointButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        inputDisplay.setText("0");
        operator = null;
        clearFlag = false;
        alreadySet = false;
    }//GEN-LAST:event_clearButtonActionPerformed

    private void clearAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAllButtonActionPerformed
        historyDisplay.setText("");
        inputDisplay.setText("0");
        operator = null;
        result = 0;
        clearFlag = false;
        alreadySet = false;

    }//GEN-LAST:event_clearAllButtonActionPerformed

    private void historyDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyDisplayActionPerformed
    }//GEN-LAST:event_historyDisplayActionPerformed

    private void plusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusButtonActionPerformed
        operator = Operation.SUM;
        result += Integer.parseInt(inputDisplay.getText());
        historyDisplay.setText(result.toString()+" +");
        lastValue = Integer.parseInt(inputDisplay.getText());
        inputDisplay.setText(result.toString());
        clearFlag = true;
    }//GEN-LAST:event_plusButtonActionPerformed

    private void minusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusButtonActionPerformed
        operator = Operation.MINUS;
        result -= Integer.parseInt(inputDisplay.getText());
        historyDisplay.setText(result.toString()+" -");
        lastValue = Integer.parseInt(inputDisplay.getText());
        inputDisplay.setText(result.toString());
        clearFlag = true;
    }//GEN-LAST:event_minusButtonActionPerformed

    private void multButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multButtonActionPerformed
        operator = Operation.MULTIPLY;
        result *= Integer.parseInt(inputDisplay.getText());
        historyDisplay.setText(result.toString()+" *");
        lastValue = Integer.parseInt(inputDisplay.getText());
        inputDisplay.setText(result.toString());
        clearFlag = true;
    }//GEN-LAST:event_multButtonActionPerformed

    private void divisionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divisionButtonActionPerformed
        operator = Operation.DIVISION;
        result /= Integer.parseInt(inputDisplay.getText());
        historyDisplay.setText(result.toString()+" /");
        lastValue = Integer.parseInt(inputDisplay.getText());
        inputDisplay.setText(result.toString());

        clearFlag = true;
    }//GEN-LAST:event_divisionButtonActionPerformed

    private void oneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneButtonActionPerformed
        assignNum("1");
    }//GEN-LAST:event_oneButtonActionPerformed

    private void twoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoButtonActionPerformed
        assignNum("2");
    }//GEN-LAST:event_twoButtonActionPerformed

    private void zeroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeroButtonActionPerformed
        if(inputDisplay.getText().equals("0")) {
            return;
        }
        assignNum("0");
    }//GEN-LAST:event_zeroButtonActionPerformed

    private void threeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeButtonActionPerformed
        assignNum("3");
    }//GEN-LAST:event_threeButtonActionPerformed

    private void fourButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourButtonActionPerformed
        assignNum("4");
    }//GEN-LAST:event_fourButtonActionPerformed

    private void fiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveButtonActionPerformed
        assignNum("5");
    }//GEN-LAST:event_fiveButtonActionPerformed

    private void sixButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixButtonActionPerformed
        assignNum("6");
    }//GEN-LAST:event_sixButtonActionPerformed

    private void sevenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sevenButtonActionPerformed
        assignNum("7");
    }//GEN-LAST:event_sevenButtonActionPerformed

    private void eightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightButtonActionPerformed
        assignNum("8");
    }//GEN-LAST:event_eightButtonActionPerformed

    private void nineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nineButtonActionPerformed
        assignNum("9");
    }//GEN-LAST:event_nineButtonActionPerformed

    private void inputDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDisplayActionPerformed
        
    }//GEN-LAST:event_inputDisplayActionPerformed
    boolean alreadySet = false;
    
    private void equalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equalButtonActionPerformed
        if(!alreadySet) {
            lastValue = Integer.parseInt(inputDisplay.getText());
            alreadySet = true;
        }
        if(operator != null){
            switch(operator) {
                case Operation.SUM -> result += lastValue;
                case Operation.MINUS -> result -= lastValue;
                case Operation.MULTIPLY -> result *= lastValue;
                case Operation.DIVISION -> result /= lastValue;
            }
        } else {
            result = lastValue;
        }
        inputDisplay.setText(result.toString());
    }//GEN-LAST:event_equalButtonActionPerformed
    
    
    private void assignNum(final String num) {
        if (clearFlag) {
            inputDisplay.setText("");
            clearFlag = false;
        }
        var current = inputDisplay.getText();
        inputDisplay.setText((current.length() == 1 && "0".equals(current)) ? num : current.concat(num));
        alreadySet = false;
        
    } 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new Calculator().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearAllButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton divisionButton;
    private javax.swing.JButton eightButton;
    private javax.swing.JButton equalButton;
    private javax.swing.JButton fiveButton;
    private javax.swing.JButton fourButton;
    private javax.swing.JTextField historyDisplay;
    private javax.swing.JTextField inputDisplay;
    private javax.swing.JButton minusButton;
    private javax.swing.JButton multButton;
    private javax.swing.JButton nineButton;
    private javax.swing.JButton oneButton;
    private javax.swing.JButton plusButton;
    private javax.swing.JButton pointButton;
    private javax.swing.JButton sevenButton;
    private javax.swing.JButton signSwitchButton;
    private javax.swing.JButton sixButton;
    private javax.swing.JButton threeButton;
    private javax.swing.JButton twoButton;
    private javax.swing.JButton zeroButton;
    // End of variables declaration//GEN-END:variables
}
