package sumberrejeki.view;

import javax.swing.JOptionPane;
import sumberrejeki.dao.DaoAccount;
import sumberrejeki.model.Account;

public class Login extends javax.swing.JFrame {
    DaoAccount daoAccount;
    public static Integer accountId;
    
    public Login() {
        initComponents();
        daoAccount = new DaoAccount(Account.class);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroung = new java.awt.Panel();
        subtitle = new java.awt.Label();
        name = new java.awt.TextField();
        password = new javax.swing.JPasswordField();
        process = new javax.swing.JButton();
        subtitle1 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroung.setPreferredSize(new java.awt.Dimension(671, 643));

        subtitle.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        subtitle.setText("MASUK KE AKUN YANG TERDAFTAR");

        name.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        name.setText("Masukkan nama");

        password.setText("jPasswordField1");

        process.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        process.setText("PROSES");
        process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processActionPerformed(evt);
            }
        });

        subtitle1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        subtitle1.setText("SUMBER REJEKI");

        javax.swing.GroupLayout backgroungLayout = new javax.swing.GroupLayout(backgroung);
        backgroung.setLayout(backgroungLayout);
        backgroungLayout.setHorizontalGroup(
            backgroungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroungLayout.createSequentialGroup()
                .addGroup(backgroungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroungLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(backgroungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(process, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(backgroungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(password)
                                    .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(backgroungLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(subtitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(backgroungLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(subtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        backgroungLayout.setVerticalGroup(
            backgroungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroungLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(subtitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(process, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void processActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processActionPerformed
        try {
            validation(daoAccount.login(name.getText(), password.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_processActionPerformed
    
    public void validation(Account account) {
        if(account == null)
            JOptionPane.showMessageDialog(this, "name/password wrong");
        else
            action(account);
    }
    
    public void action(Account account) {
        accountId = account.getId();
        int state = account.getIdState();
        if(state == 2) 
            new BossMenu().setVisible(true);
        if(state== 3)
            new CashierMenu().setVisible(true);
        this.setVisible(false);
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException |
                javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Panel backgroung;
    private java.awt.TextField name;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton process;
    private java.awt.Label subtitle;
    private java.awt.Label subtitle1;
    // End of variables declaration//GEN-END:variables
}
