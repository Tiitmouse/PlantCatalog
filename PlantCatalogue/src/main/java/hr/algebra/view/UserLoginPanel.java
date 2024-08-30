/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hr.algebra.view;

/**
 *
 * @author lorena
 */
public class UserLoginPanel extends javax.swing.JPanel {

   
    /**
     * Creates new form UserLoginPanel
     */
    public UserLoginPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfUsernameInput = new javax.swing.JTextField();
        btnLoginProceed = new javax.swing.JButton();
        lblLoginPicture = new javax.swing.JLabel();
        tfPasswordInput = new javax.swing.JPasswordField();

        setBackground(java.awt.Color.white);

        tfUsernameInput.setBackground(new java.awt.Color(137, 151, 116));
        tfUsernameInput.setText("Username");

        btnLoginProceed.setBackground(new java.awt.Color(137, 151, 116));
        btnLoginProceed.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnLoginProceed.setText("➤");

        lblLoginPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoginPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginPlant.png"))); // NOI18N

        tfPasswordInput.setBackground(new java.awt.Color(137, 151, 116));
        tfPasswordInput.setText("jPasswordField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblLoginPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfUsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(btnLoginProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfUsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(tfPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(btnLoginProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lblLoginPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginProceed;
    private javax.swing.JLabel lblLoginPicture;
    private javax.swing.JPasswordField tfPasswordInput;
    private javax.swing.JTextField tfUsernameInput;
    // End of variables declaration//GEN-END:variables

}
