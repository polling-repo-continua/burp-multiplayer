/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burp.gui;

import burp.IBurpExtenderCallbacks;
import burp.Multiplayer;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author moloch
 */
public class OptionsPane extends javax.swing.JPanel {

    private Multiplayer multiplayer;
    private IBurpExtenderCallbacks callbacks;
    
    /**
     * Creates new form Options
     */
    public OptionsPane(Multiplayer multiplayer, IBurpExtenderCallbacks callbacks) {
        callbacks.printOutput("Initializing options panel");
        this.multiplayer = multiplayer;
        this.callbacks = callbacks;
        initComponents();
        callbacks.printOutput("Options panel initialized");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ignoreFileExtensionList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ignoreStatusCodesList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        addIgnoreFileExtensionButton = new javax.swing.JButton();
        removeIgnoreFileExtensionButton = new javax.swing.JButton();
        addIgnoreStatusCodeButton = new javax.swing.JButton();
        removeIgnoreStatusCodeButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        disconnectButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font(".SF NS Text", 1, 13)); // NOI18N
        jLabel1.setText("Ignore File Extensions");

        ignoreFileExtensionList.setModel(multiplayer.getIgnoreExtensions()
        );
        jScrollPane1.setViewportView(ignoreFileExtensionList);

        ignoreStatusCodesList.setModel(multiplayer.getIgnoredStatusCodes()
        );
        jScrollPane2.setViewportView(ignoreStatusCodesList);

        jLabel2.setFont(new java.awt.Font(".SF NS Text", 1, 13)); // NOI18N
        jLabel2.setText("Ignore Status Codes");

        addIgnoreFileExtensionButton.setText("Add");
        addIgnoreFileExtensionButton.setToolTipText("");
        addIgnoreFileExtensionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIgnoreFileExtensionButtonActionPerformed(evt);
            }
        });

        removeIgnoreFileExtensionButton.setText("Remove");
        removeIgnoreFileExtensionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeIgnoreFileExtensionButtonActionPerformed(evt);
            }
        });

        addIgnoreStatusCodeButton.setText("Add");
        addIgnoreStatusCodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIgnoreStatusCodeButtonActionPerformed(evt);
            }
        });

        removeIgnoreStatusCodeButton.setText("Remove");
        removeIgnoreStatusCodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeIgnoreStatusCodeButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font(".SF NS Text", 1, 13)); // NOI18N
        jLabel3.setText("Other Options");

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Ignore Scanner Requests");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(removeIgnoreFileExtensionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addIgnoreFileExtensionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                        .addComponent(disconnectButton)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(removeIgnoreStatusCodeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addIgnoreStatusCodeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox1)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(disconnectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addIgnoreFileExtensionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeIgnoreFileExtensionButton)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addIgnoreStatusCodeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeIgnoreStatusCodeButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap(155, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addIgnoreFileExtensionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIgnoreFileExtensionButtonActionPerformed
        String fileExt = JOptionPane.showInputDialog("Add file extension:");
        multiplayer.addIgnoredExtension(fileExt);
    }//GEN-LAST:event_addIgnoreFileExtensionButtonActionPerformed

    private void addIgnoreStatusCodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIgnoreStatusCodeButtonActionPerformed
        String status = JOptionPane.showInputDialog("Add status code:");
        multiplayer.addIgnoredStatusCodes(status);
    }//GEN-LAST:event_addIgnoreStatusCodeButtonActionPerformed

    private void removeIgnoreFileExtensionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeIgnoreFileExtensionButtonActionPerformed
        List<String> selectedValues = ignoreFileExtensionList.getSelectedValuesList();
        selectedValues.forEach((ext) -> {
            multiplayer.removeIgnoredExtension(ext);
        });
    }//GEN-LAST:event_removeIgnoreFileExtensionButtonActionPerformed

    private void removeIgnoreStatusCodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeIgnoreStatusCodeButtonActionPerformed
        List<String> selectedValues = ignoreStatusCodesList.getSelectedValuesList();
        selectedValues.forEach((code) -> {
            multiplayer.removeIgnoredStatusCodes(code);
        });
    }//GEN-LAST:event_removeIgnoreStatusCodeButtonActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        multiplayer.disconnect();
    }//GEN-LAST:event_disconnectButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addIgnoreFileExtensionButton;
    private javax.swing.JButton addIgnoreStatusCodeButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JList<String> ignoreFileExtensionList;
    private javax.swing.JList<String> ignoreStatusCodesList;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeIgnoreFileExtensionButton;
    private javax.swing.JButton removeIgnoreStatusCodeButton;
    // End of variables declaration//GEN-END:variables
}
