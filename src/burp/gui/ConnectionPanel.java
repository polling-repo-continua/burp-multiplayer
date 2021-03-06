/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burp.gui;

import burp.IBurpExtenderCallbacks;
import burp.Multiplayer;
import burp.MultiplayerLogger;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author moloch
 */
public class ConnectionPanel extends javax.swing.JPanel {

    private final Multiplayer multiplayer;
    private List<Runnable> onConnectCallbacks = new ArrayList<Runnable>();
    private final IBurpExtenderCallbacks callbacks;
    private final MultiplayerLogger logger;
    
    /**
     * Creates new form ConnectionPanel
     * @param multiplayer
     * @param logger
     */
    public ConnectionPanel(Multiplayer multiplayer, MultiplayerLogger logger) {
        this.callbacks = logger.callbacks;
        this.logger = logger;
        this.multiplayer = multiplayer;
        initComponents();
        initLoadSettings();
        if (projectNameTextField.getText().isBlank() || projectNameTextField.getText().isEmpty()) {
            connectButton.setEnabled(false);
        }
    }
    
    public void initLoadSettings() {
        String projectName = loadExtensionSetting("projectName");
        if (projectName != null) {
            projectNameTextField.setText(projectName);
        }
        String hostname = loadExtensionSetting("hostname");
        if (hostname != null) {
            hostnameTextField.setText(hostname);
        }
        String port = loadExtensionSetting("port");
        if (port != null) {
            try {
                Integer.parseInt(port);
                portNumberTextField.setText(port);
            } catch (NumberFormatException e) {}
        }
    }
    
    public void onConnection(Runnable callback) {
        onConnectCallbacks.add(callback);
    }
    
    private void triggerOnConnection() {
        for (Runnable callback : onConnectCallbacks) {
            callback.run();
        }
    }
    
    private void saveExtensionSetting(String name, String value) {
        String key = String.format("multiplayer.%s.%s", this.getClass().getName(), name);
        callbacks.saveExtensionSetting(key, value);
    }
    
    private String loadExtensionSetting(String name) {
        String key = String.format("multiplayer.%s.%s", this.getClass().getName(), name);
        return callbacks.loadExtensionSetting(key);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hoastnameLabel = new javax.swing.JLabel();
        hostnameTextField = new javax.swing.JTextField();
        portNumberLabel = new javax.swing.JLabel();
        portNumberTextField = new javax.swing.JTextField();
        projectNameLabel = new javax.swing.JLabel();
        projectNameTextField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        connectButton = new javax.swing.JButton();
        saveSettingsCheckBox = new javax.swing.JCheckBox();

        hoastnameLabel.setText("Hostname");

        hostnameTextField.setColumns(10);
        hostnameTextField.setText("localhost");
        hostnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostnameTextFieldActionPerformed(evt);
            }
        });

        portNumberLabel.setText("Port Number");

        portNumberTextField.setColumns(10);
        portNumberTextField.setText("28015");

        projectNameLabel.setText("Project Name");

        projectNameTextField.setColumns(10);
        projectNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectNameTextFieldActionPerformed(evt);
            }
        });
        projectNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                projectNameTextFieldKeyReleased(evt);
            }
        });

        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("RethinkDB Connection");

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        saveSettingsCheckBox.setSelected(true);
        saveSettingsCheckBox.setText("Save Connection Settings");
        saveSettingsCheckBox.setToolTipText("");
        saveSettingsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSettingsCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveSettingsCheckBox)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(projectNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(projectNameTextField))
                            .addComponent(connectButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(portNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hoastnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hostnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(portNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(401, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectNameLabel)
                    .addComponent(projectNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hostnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hoastnameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portNumberLabel)
                    .addComponent(portNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveSettingsCheckBox)
                .addGap(11, 11, 11)
                .addComponent(connectButton)
                .addContainerGap(320, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void hostnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostnameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hostnameTextFieldActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed

        this.connectButton.setEnabled(false);
        
        String hostname = this.hostnameTextField.getText();
        Integer port = Integer.parseInt(this.portNumberTextField.getText());
        String projectName = this.projectNameTextField.getText();
        try {
            Boolean connected = this.multiplayer.Connect(hostname, port, projectName);
            if (connected) {
                
                if (saveSettingsCheckBox.isSelected()) {
                    saveExtensionSetting("projectName", projectName);
                    saveExtensionSetting("hostname", hostname);
                    saveExtensionSetting("port", String.format("%d", port));
                }
                
                this.triggerOnConnection();
            }
        } catch (Exception err) {
            logger.error(err);
            JOptionPane.showMessageDialog(this,
                String.format("Failed to connect.\n%s", err),
                "Conncection Error",
                JOptionPane.ERROR_MESSAGE);
            this.connectButton.setEnabled(true);
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    private void saveSettingsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSettingsCheckBoxActionPerformed

    }//GEN-LAST:event_saveSettingsCheckBoxActionPerformed

    private void projectNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectNameTextFieldActionPerformed

    }//GEN-LAST:event_projectNameTextFieldActionPerformed

    private void projectNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_projectNameTextFieldKeyReleased
        if (0 < projectNameTextField.getText().length()) {
            connectButton.setEnabled(true);
        }
        if (projectNameTextField.getText().isBlank() || projectNameTextField.getText().isEmpty()) {
            connectButton.setEnabled(false);
        }
    }//GEN-LAST:event_projectNameTextFieldKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JLabel hoastnameLabel;
    private javax.swing.JTextField hostnameTextField;
    private javax.swing.JLabel portNumberLabel;
    private javax.swing.JTextField portNumberTextField;
    private javax.swing.JLabel projectNameLabel;
    private javax.swing.JTextField projectNameTextField;
    private javax.swing.JCheckBox saveSettingsCheckBox;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
