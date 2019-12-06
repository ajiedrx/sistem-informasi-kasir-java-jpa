package sumberrejeki.view;

import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import static sumberrejeki.view.DataList.accountEdit;
import javax.swing.JOptionPane;
import sumberrejeki.dao.DaoState;
import sumberrejeki.model.State;
import sumberrejeki.dao.DaoAccount;
import sumberrejeki.model.Account;
import java.util.Objects;

public class AccountForm extends javax.swing.JFrame implements Saving, Running,
        Completing<Account, State>, OtherComponents {
    String selected;
    DaoState daoState;
    DaoAccount daoAccount;
    State temp;

    public AccountForm() {
        initComponents();
        runComponents();
    }
    
    @Override
    public void initVariables() {
        daoState = new DaoState(State.class);
        daoAccount = new DaoAccount(Account.class);
    }
    
    @Override
    public void load() {
        if (accountEdit > -1)
            display();
        stateCombo.setModel(daoState.dropdown(accountEdit));
    }
    
    @Override
    public void display() {
        Account account = daoAccount.findById(accountEdit);
        nameField.setText(account.getName());
        passwordField.setText(account.getPassword());
        temp = account.getStateId();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroung = new java.awt.Panel();
        subtitle = new java.awt.Label();
        nameField = new java.awt.TextField();
        stateCombo = new javax.swing.JComboBox<>();
        backButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        processButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroung.setPreferredSize(new java.awt.Dimension(671, 643));

        subtitle.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        subtitle.setText("MENAMBAH/MENGUBAH DATA AKUN");

        nameField.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        nameField.setText("Masukkan nama");

        stateCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                stateComboItemStateChanged(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        backButton.setText("KEMBALI");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        passwordField.setText("jPasswordField1");

        processButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        processButton.setText("PROSES");
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroungLayout = new javax.swing.GroupLayout(backgroung);
        backgroung.setLayout(backgroungLayout);
        backgroungLayout.setHorizontalGroup(
            backgroungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroungLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(backgroungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroungLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(subtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(processButton, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(backgroungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(stateCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordField)
                            .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        backgroungLayout.setVerticalGroup(
            backgroungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroungLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(subtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stateCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(processButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
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

    private void stateComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_stateComboItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String choose = "Pilih satu status :";
            if (!stateCombo.getSelectedItem().toString().equals(choose)) {
                selected = stateCombo.getSelectedItem().toString();
                JOptionPane.showMessageDialog(this, "you choose" + selected);
            }
        }
    }//GEN-LAST:event_stateComboItemStateChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        back();
    }//GEN-LAST:event_backButtonActionPerformed

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        try {
            process();
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_processButtonActionPerformed
    
    @Override
    public void save() {
        Account account = new Account();
        account.setName(nameField.getText());
        account.setPassword(passwordField.getText());
        State state = daoState.findByName(selected);
        System.out.println(selected);
        account.setStateId(state);
        action(account, state);
    }
    
    @Override
    public void action(Account account, State state) {
        if (accountEdit > -1) {
            another(-1, state);
            account.setId(accountEdit);
            daoAccount.update(accountEdit, account);
        } else {
            another(1, state);
            daoAccount.save(account);
        }
    }
    
    @Override
    public void another(int counters, State state) {
        boolean condition = true;
        if (counters == -1 && Objects.equals(state.getId(), temp.getId()))
            condition = false;
        if (condition == true) {
            state.setTotal(state.getTotal() + counters);
            daoState.update(state.getId(), state);
        }
    }
    
    
    @Override
    public void back() {
        this.setVisible(false);
        new BossMenu().setVisible(true);
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
            java.util.logging.Logger.getLogger(AccountForm.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new AccountForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private java.awt.Panel backgroung;
    private java.awt.TextField nameField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton processButton;
    private javax.swing.JComboBox<String> stateCombo;
    private java.awt.Label subtitle;
    // End of variables declaration//GEN-END:variables
}
