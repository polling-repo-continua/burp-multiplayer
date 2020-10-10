/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burp.gui;

import burp.IBurpExtenderCallbacks;
import burp.Multiplayer;

/**
 *
 * @author moloch
 */
public class MainPanel extends javax.swing.JPanel {

    private Multiplayer multiplayer;
    private IBurpExtenderCallbacks callbacks;
    
    /**
     * Creates new form MainPanel
     */
    public MainPanel(Multiplayer multiplayer, IBurpExtenderCallbacks callbacks) {
        this.callbacks = callbacks;
        initComponents();
        this.multiplayer = multiplayer;

        // Initialize Tabs
        InScopePane inScopePane = new InScopePane(multiplayer, callbacks);
        this.mainTabbedPane.addTab("In-Scope", inScopePane);
        
        OptionsPane optionsPane = new OptionsPane();
        this.mainTabbedPane.addTab("Options", optionsPane);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTabbedPane = new javax.swing.JTabbedPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane mainTabbedPane;
    // End of variables declaration//GEN-END:variables
}
