package sumberrejeki.view;

import static sumberrejeki.view.Submenu.submenuChoice;
import sumberrejeki.dao.DaoAccount;
import sumberrejeki.dao.DaoCategory;
import sumberrejeki.dao.DaoItem;
import sumberrejeki.dao.DaoTransaction;
import sumberrejeki.dao.DaoState;
import sumberrejeki.model.State;
import sumberrejeki.model.Account;
import sumberrejeki.model.Category;
import sumberrejeki.model.Item;
import sumberrejeki.model.Transaction;
import javax.swing.JOptionPane;

public class DataList extends javax.swing.JFrame implements Running,
        OtherComponents {
    public static Integer accountEdit = -1;
    public static Integer itemEdit = -1;
    public static Integer categoryEdit = -1;
    DaoAccount daoAccount;
    DaoItem daoItem;
    DaoCategory daoCategory;
    DaoTransaction daoTransaction;
    DaoState daoState;
    
    public DataList() {
        initComponents();
        runComponents();
    }
    
    @Override
    public void initVariables() {
        daoAccount = new DaoAccount(Account.class);
        daoItem = new DaoItem(Item.class);
        daoCategory = new DaoCategory(Category.class);
        daoTransaction = new DaoTransaction(Transaction.class);
        daoState = new DaoState(State.class);
    }
    
    @Override
    public void load() {
        try {
            display();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    @Override
    public void display() {
        switch(submenuChoice) {
            case 3: accountTable(); break;
            case 4: itemTable(); break;
            case 5: categoryTable(); break;
            case 6: transactionTable(); break;
        }
    }
    
    public void accountTable() {
        Object[] objects = new Object[]{"ID","Nama","Kata Sandi", "Status"};
        table.setModel(daoAccount.table(objects));
    }
    
    public void itemTable() {
        Object[] objects = new Object[]{"ID","Nama","Harga Beli", "Harga Jual",
        "Persediaan", "Category"};
        table.setModel(daoItem.table(objects));
    }
    
    public void categoryTable() {
        Object[] objects = new Object[]{"ID", "Nama", "Total"};
        table.setModel(daoCategory.table(objects));
    }
    
    public void transactionTable() {
        Object[] objects = new Object[]{"ID", "Waktu", "Total", "Kasir", "Laba"};
        table.setModel(daoTransaction.table(objects));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new java.awt.Panel();
        title = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        back = new javax.swing.JButton();
        idField = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        title.setText("DAFTAR DATA");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        edit.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        edit.setText("UBAH");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        delete.setText("HAPUS");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        back.setText("KEMBALI");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Masukkan ID");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(idField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(backgroundLayout.createSequentialGroup()
                            .addGap(149, 149, 149)
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        try {
            edit();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_editActionPerformed

    public void edit() {
        switch(submenuChoice) {
            case 3: accountEdit(); break;
            case 4: itemEdit(); break;
            case 5: categoryEdit(); break;
            case 6: transactionEdit(); break;
        }
        this.setVisible(false);
    }
    
    public void accountEdit() {
        accountEdit = (Integer) idField.getValue();
        new AccountForm().setVisible(true);
    }
    
    public void itemEdit() {
        itemEdit = (Integer) idField.getValue();
        new ItemForm().setVisible(true);
    }
    
    public void categoryEdit() {
        categoryEdit = (Integer) idField.getValue();
        new CategoryForm().setVisible(true);
    }
    
    public void transactionEdit() {
        JOptionPane.showMessageDialog(this, "transaction can't edit");
        new BossMenu().setVisible(true);
    }
    
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            delete();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        back();
    }//GEN-LAST:event_backActionPerformed
    
    public void delete() {
        switch(submenuChoice) {
            case 3: accountDelete(); break;
            case 4: itemDelete(); break;
            case 5: categoryDelete(); break;
            case 6: transactionDelete(); break;
        }
    }
    
    public void back() {
        this.setVisible(false);
        new Submenu().setVisible(true);
    }
    
    public void accountDelete() {
        int accountDelete = (Integer) idField.getValue();
        Account account = daoAccount.findById(accountDelete);
        State state = account.getStateId();
        state.setTotal(state.getTotal() - 1);
        daoState.update(state.getId(), state);
        daoAccount.delete(account);
        JOptionPane.showMessageDialog(this, "account is deleted");
    }
    
    public void itemDelete() {
        int itemDelete = (Integer) idField.getValue();
        Item item = daoItem.findById(itemDelete);
        Category category = item.getCategoryId();
        category.setTotal(category.getTotal() - 1);
        daoCategory.update(category.getId(), category);
        daoItem.delete(item);
        JOptionPane.showMessageDialog(this, "item is deleted");
    }
    
    public void categoryDelete() {
        int categoryDelete = (Integer) idField.getValue();
        Category categoryDeleted = daoCategory.findById(categoryDelete);
        if(categoryDeleted.getTotal() > 0) {
            daoCategory.delete(daoCategory.findById(categoryDelete));
            JOptionPane.showMessageDialog(this, "category is deleted");
        } else
            JOptionPane.showMessageDialog(this, "category can't delete");
    }
    
    public void transactionDelete() {
        JOptionPane.showMessageDialog(this, "transaction can't delete");
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
            java.util.logging.Logger.getLogger(DataList.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new DataList().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private java.awt.Panel background;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JSpinner idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private java.awt.Label title;
    // End of variables declaration//GEN-END:variables
}
