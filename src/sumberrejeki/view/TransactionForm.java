package sumberrejeki.view;

import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import java.util.List;
import sumberrejeki.dao.DaoCategory;
import sumberrejeki.model.Category;
import sumberrejeki.dao.DaoItem;
import sumberrejeki.model.Item;
import sumberrejeki.dao.DaoDetail;
import sumberrejeki.model.Detail;
import sumberrejeki.dao.DaoTransaction;
import sumberrejeki.model.Transaction;
import static sumberrejeki.view.CashierMenu.transactionId;

public class TransactionForm extends javax.swing.JFrame implements Saving,
        Running {
    DaoCategory daoCategory;
    DaoItem daoItem;
    DaoDetail daoDetail;
    DaoTransaction daoTransaction;
    String categorySelected;
    String itemSelected;
    Category category;
    Item item;
    Transaction transaction;
    
    public TransactionForm() {
        initComponents();
        runComponents();
    }
    
    @Override
    public void load() {
        categoryCombo.setModel(daoCategory.dropdown(-1));
    }
    
    @Override
    public void initVariables() {
        daoCategory = new DaoCategory(Category.class);
        daoItem = new DaoItem(Item.class);
        daoDetail = new DaoDetail(Detail.class);
        daoTransaction = new DaoTransaction(Transaction.class);
        transaction = daoTransaction.findById(transactionId);
    }
    
    public void items() {
        itemCombo.setModel(daoItem.dropdown(category.getId()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        background = new java.awt.Panel();
        categoryCombo = new javax.swing.JComboBox<>();
        itemCombo = new javax.swing.JComboBox<>();
        totalField = new javax.swing.JTextField();
        processButton = new javax.swing.JButton();
        notaButton = new javax.swing.JButton();
        cartButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        label = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setPreferredSize(new java.awt.Dimension(671, 643));

        categoryCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoryComboItemStateChanged(evt);
            }
        });

        itemCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                itemComboItemStateChanged(evt);
            }
        });

        totalField.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        totalField.setText("Masukkan jumlah barang");

        processButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        processButton.setText("PROSES");
        processButton.setToolTipText("");
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        notaButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        notaButton.setText("NOTA");
        notaButton.setToolTipText("");
        notaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notaButtonActionPerformed(evt);
            }
        });

        cartButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        cartButton.setToolTipText("");
        cartButton.setLabel("KERANJANG");
        cartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        backButton.setText("KEMBALI");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        label.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        label.setText("MENAMBAH TRANSAKSI BARANG");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(itemCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(processButton, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                                    .addComponent(notaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(itemCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(processButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(notaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoryComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoryComboItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            categorySelected = categoryCombo.getSelectedItem().toString();
            category = daoCategory.findByName(categorySelected);
            if(!categorySelected.equals("Pilih salah satu kategori")) {
                itemCombo.removeAllItems();
                items();
            }
        }
    }//GEN-LAST:event_categoryComboItemStateChanged

    @Override
    public void back() {
        totalField.setText("Masukkan jumlah barang");
        categoryCombo.removeAllItems();
        load();
        itemCombo.removeAllItems();
    }
    
    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        try {
            process();
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_processButtonActionPerformed

    @Override
    public void save() {
        int total = Integer.valueOf(totalField.getText());
        int stock = item.getStock() - total;
        if(stock >= 0) 
            action(total, stock);
        else 
            JOptionPane.showMessageDialog(this, "there're no more");
    }
    
    public void action(int total, int stock) {
        Detail detail = new Detail();
        detail.setItemId(item);
        detail.setTransactionId(transaction);
        detail.setTotal(total);
        detail.setPrice(total*item.getSell());
        daoDetail.save(detail);
        item.setStock(stock);
        daoItem.update(item.getId(), item);
    }
    
    private void itemComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_itemComboItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            itemSelected = itemCombo.getSelectedItem().toString();
            item = daoItem.findByName(itemSelected);
        }
    }//GEN-LAST:event_itemComboItemStateChanged

    private void cartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartButtonActionPerformed
        try{
            new Cart().setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_cartButtonActionPerformed

    private void notaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notaButtonActionPerformed
        try{
            update();
            message();
            out();
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_notaButtonActionPerformed

    public void update() {
        List<Detail> carts = daoDetail.allInCart();
        transaction.setProfit(daoDetail.profit(carts));
        transaction.setTotal(daoDetail.total(carts));
        daoTransaction.update(transactionId, transaction);
    }
    
    public void message() {
        String message = "TOTAL BELANJA :" + transaction.getTotal();
        JOptionPane.showMessageDialog(this, message);
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        try {
            remove();
            out();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_backButtonActionPerformed

    public void remove() {
        List<Detail> carts = daoDetail.allInCart();
        if(carts.isEmpty())
            daoTransaction.delete(transaction);
        else
            daoDetail.back(carts);
    }
    
    public void out() {
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
            java.util.logging.Logger.getLogger(TransactionForm.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(() -> {
            new TransactionForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private java.awt.Panel background;
    private javax.swing.JButton cartButton;
    private javax.swing.JComboBox<String> categoryCombo;
    private javax.swing.JComboBox<String> itemCombo;
    private javax.swing.JProgressBar jProgressBar1;
    private java.awt.Label label;
    private javax.swing.JButton notaButton;
    private javax.swing.JButton processButton;
    private javax.swing.JTextField totalField;
    // End of variables declaration//GEN-END:variables
}
