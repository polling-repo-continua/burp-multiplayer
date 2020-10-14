/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burp.gui;

import burp.IBurpExtenderCallbacks;
import burp.Multiplayer;
import burp.MultiplayerLogger;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import javax.swing.JOptionPane;
import com.fasterxml.jackson.databind.*;

/**
 *
 * @author moloch
 */
public class OptionsPane extends javax.swing.JPanel {

    private final Multiplayer multiplayer;
    private final IBurpExtenderCallbacks callbacks;
    private final MultiplayerLogger logger;
    
    /**
     * Creates new form Options
     * @param multiplayer
     * @param callbacks
     * @param logger
     */
    public OptionsPane(Multiplayer multiplayer, MultiplayerLogger logger) {
        logger.setLevel(logger.INFO);
        logger.debug("Initializing options panel");
        this.multiplayer = multiplayer;
        this.callbacks = logger.callbacks;
        this.logger = logger;
        initComponents();
        initLoadSettings();
    }
    
    private void initLoadSettings() {
        String theImplication = loadExtensionSetting("sendToImpliesInProgress");
        if (theImplication != null) {
            if ("1".equals(theImplication)) {
                multiplayer.setSendToImpliesInProgress(true);
                sendToInProgressCheckBox.setSelected(true);
            } else {
                multiplayer.setSendToImpliesInProgress(false);
                sendToInProgressCheckBox.setSelected(false);
            }
        }
        
        String ignoreScanner = loadExtensionSetting("ignoreScanner");
        if (ignoreScanner != null) {
            if ("1".equals(ignoreScanner)) {
                multiplayer.setIgnoreScanner(true);
                ignoreScannerCheckBox.setSelected(true);
            } else {
                multiplayer.setIgnoreScanner(false);
                ignoreScannerCheckBox.setSelected(false);
            }
        }
        
        loadIgnoredFileExtensionList();
        loadIgnoredStatusCodesList();
    }

    private void saveExtensionSetting(String name, String value) {
        String key = String.format("multiplayer.%s.%s", this.getClass().getName(), name);
        callbacks.saveExtensionSetting(key, value);
    }
    
    private String loadExtensionSetting(String name) {
        String key = String.format("multiplayer.%s.%s", this.getClass().getName(), name);
        return callbacks.loadExtensionSetting(key);
    }
    
    private void saveIgnoredFileExtensionList() {
        List<String> ignoredFileExts = multiplayer.getIgnoredFileExtensionsList();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(ignoredFileExts);
            saveExtensionSetting("ignoredFileExtensions", json);
        } catch (JsonProcessingException err) {
            callbacks.printError(err.toString());
        }
    }
    
    private void loadIgnoredFileExtensionList() {
        String json = loadExtensionSetting("ignoredFileExtensions");
        if (json != null && !json.isBlank() && !json.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                List<String> ignoredFileExts = objectMapper.readValue(json, List.class);
                multiplayer.clearIgnoredExtensions();
                ignoredFileExts.forEach(ext -> multiplayer.addIgnoredExtension(ext));
            } catch (JsonProcessingException err) {
                callbacks.printError(err.toString());
                saveExtensionSetting("ignoredFileExtensions", null);
            }
        }
    }

    private void saveIgnoredStatusCodesList() {
        List<String> ignoredStatusCodes = multiplayer.getIgnoredStatusCodesList();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(ignoredStatusCodes);
            saveExtensionSetting("ignoredStatusCodes", json);
        } catch (JsonProcessingException err) {
            callbacks.printError(err.toString());
        }
    }
    
    private void loadIgnoredStatusCodesList() {
        String json = loadExtensionSetting("ignoredStatusCodes");
        if (json != null && !json.isBlank() && !json.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                List<String> ignoredFileExts = objectMapper.readValue(json, List.class);
                multiplayer.clearIgnoredStatusCodes();
                ignoredFileExts.forEach(code -> multiplayer.addIgnoredStatusCodes(code));
            } catch (JsonProcessingException err) {
                callbacks.printError(err.toString());
                saveExtensionSetting("ignoredStatusCodes", null);
            }
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

        ignoreFileExtensionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ignoredFileExtensionJList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ignoredStatusCodesJList = new javax.swing.JList<>();
        ignoreStatusCodesLabel = new javax.swing.JLabel();
        addIgnoreFileExtensionButton = new javax.swing.JButton();
        removeIgnoreFileExtensionButton = new javax.swing.JButton();
        addIgnoreStatusCodeButton = new javax.swing.JButton();
        removeIgnoreStatusCodeButton = new javax.swing.JButton();
        otherOptionsLabel = new javax.swing.JLabel();
        ignoreScannerCheckBox = new javax.swing.JCheckBox();
        disconnectButton = new javax.swing.JButton();
        sendToInProgressCheckBox = new javax.swing.JCheckBox();
        logLevelComboBox = new javax.swing.JComboBox<>();
        loggingLabel = new javax.swing.JLabel();

        ignoreFileExtensionLabel.setFont(new java.awt.Font(".SF NS Text", 1, 13)); // NOI18N
        ignoreFileExtensionLabel.setText("Ignore File Extensions");

        ignoredFileExtensionJList.setModel(multiplayer.getIgnoreExtensions()
        );
        jScrollPane1.setViewportView(ignoredFileExtensionJList);

        ignoredStatusCodesJList.setModel(multiplayer.getIgnoredStatusCodes()
        );
        jScrollPane2.setViewportView(ignoredStatusCodesJList);

        ignoreStatusCodesLabel.setFont(new java.awt.Font(".SF NS Text", 1, 13)); // NOI18N
        ignoreStatusCodesLabel.setText("Ignore Status Codes");

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

        otherOptionsLabel.setFont(new java.awt.Font(".SF NS Text", 1, 13)); // NOI18N
        otherOptionsLabel.setText("Other Options");

        ignoreScannerCheckBox.setSelected(true);
        ignoreScannerCheckBox.setText("Ignore Scanner Requests");
        ignoreScannerCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ignoreScannerCheckBoxActionPerformed(evt);
            }
        });

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        sendToInProgressCheckBox.setSelected(true);
        sendToInProgressCheckBox.setText("Send To Implies In Progress");
        sendToInProgressCheckBox.setToolTipText("");
        sendToInProgressCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToInProgressCheckBoxActionPerformed(evt);
            }
        });

        logLevelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            logger.DEBUG, logger.INFO, logger.WARN, logger.ERROR
        }));
        logLevelComboBox.setSelectedItem(logger.INFO);
        logLevelComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logLevelComboBoxActionPerformed(evt);
            }
        });

        loggingLabel.setFont(new java.awt.Font(".SF NS Text", 1, 13)); // NOI18N
        loggingLabel.setText("Log Level");

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
                            .addComponent(ignoreFileExtensionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 353, Short.MAX_VALUE)
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
                                    .addComponent(ignoreStatusCodesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ignoreScannerCheckBox)
                                .addComponent(otherOptionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sendToInProgressCheckBox)
                                .addComponent(loggingLabel)
                                .addComponent(logLevelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ignoreFileExtensionLabel)
                    .addComponent(disconnectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addIgnoreFileExtensionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeIgnoreFileExtensionButton)))
                .addGap(18, 18, 18)
                .addComponent(ignoreStatusCodesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addIgnoreStatusCodeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeIgnoreStatusCodeButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(otherOptionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ignoreScannerCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendToInProgressCheckBox)
                .addGap(18, 18, 18)
                .addComponent(loggingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logLevelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addIgnoreFileExtensionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIgnoreFileExtensionButtonActionPerformed
        String fileExt = JOptionPane.showInputDialog("Add file extension:");
        multiplayer.addIgnoredExtension(fileExt);
        saveIgnoredFileExtensionList();
    }//GEN-LAST:event_addIgnoreFileExtensionButtonActionPerformed

    private void addIgnoreStatusCodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIgnoreStatusCodeButtonActionPerformed
        String status = JOptionPane.showInputDialog("Add status code:");
        multiplayer.addIgnoredStatusCodes(status);
        saveIgnoredStatusCodesList();
    }//GEN-LAST:event_addIgnoreStatusCodeButtonActionPerformed

    private void removeIgnoreFileExtensionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeIgnoreFileExtensionButtonActionPerformed
        List<String> selectedValues = ignoredFileExtensionJList.getSelectedValuesList();
        selectedValues.forEach((ext) -> {
            multiplayer.removeIgnoredExtension(ext);
        });
        saveIgnoredFileExtensionList();
    }//GEN-LAST:event_removeIgnoreFileExtensionButtonActionPerformed

    private void removeIgnoreStatusCodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeIgnoreStatusCodeButtonActionPerformed
        List<String> selectedValues = ignoredStatusCodesJList.getSelectedValuesList();
        selectedValues.forEach((code) -> {
            multiplayer.removeIgnoredStatusCodes(code);
        });
        saveIgnoredStatusCodesList();
    }//GEN-LAST:event_removeIgnoreStatusCodeButtonActionPerformed

    private void ignoreScannerCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ignoreScannerCheckBoxActionPerformed
        multiplayer.setIgnoreScanner(ignoreScannerCheckBox.isSelected());
        String ignoreScanner = ignoreScannerCheckBox.isSelected() ? "1" : "0";
        saveExtensionSetting("ignoreScanner", ignoreScanner);
    }//GEN-LAST:event_ignoreScannerCheckBoxActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        multiplayer.disconnect();
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void sendToInProgressCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToInProgressCheckBoxActionPerformed
        multiplayer.setSendToImpliesInProgress(sendToInProgressCheckBox.isSelected());
        String theImplication = sendToInProgressCheckBox.isSelected() ? "1" : "0";
        saveExtensionSetting("sendToImpliesInProgress", theImplication);
    }//GEN-LAST:event_sendToInProgressCheckBoxActionPerformed

    private void logLevelComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logLevelComboBoxActionPerformed
        String level = (String) logLevelComboBox.getSelectedItem();
        logger.setLevel(level);
    }//GEN-LAST:event_logLevelComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addIgnoreFileExtensionButton;
    private javax.swing.JButton addIgnoreStatusCodeButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JLabel ignoreFileExtensionLabel;
    private javax.swing.JCheckBox ignoreScannerCheckBox;
    private javax.swing.JLabel ignoreStatusCodesLabel;
    private javax.swing.JList<String> ignoredFileExtensionJList;
    private javax.swing.JList<String> ignoredStatusCodesJList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> logLevelComboBox;
    private javax.swing.JLabel loggingLabel;
    private javax.swing.JLabel otherOptionsLabel;
    private javax.swing.JButton removeIgnoreFileExtensionButton;
    private javax.swing.JButton removeIgnoreStatusCodeButton;
    private javax.swing.JCheckBox sendToInProgressCheckBox;
    // End of variables declaration//GEN-END:variables
}
