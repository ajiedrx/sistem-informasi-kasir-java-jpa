package sumberrejeki.view;

import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.util.Objects;
import sumberrejeki.dao.DaoCategory;
import sumberrejeki.model.Category;
import javax.swing.JOptionPane;
import static sumberrejeki.view.DataList.itemEdit;
import sumberrejeki.dao.DaoItem;
import sumberrejeki.model.Item;

public class ItemForm extends javax.swing.JFrame implements Saving, Running,
        Completing<Item, Category>, OtherComponents {
    String selected;
    DaoItem daoItem;
    DaoCategory daoCategory;
    Category temp;

    public ItemForm() {
        initComponents();
        runComponents();
    }

    @Override
    public void initVariables() {
        daoItem = new DaoItem(Item.class);
        daoCategory = new DaoCategory(Category.class);
    }
    
    @Override
    public void load() {
        if(itemEdit > -1)
            display();
        categoryCombo.setModel(daoCategory.dropdown(itemEdit));
    }
    
    @Override
    public void display() {
        Item item = daoItem.findById(itemEdit);
        nameField.setText(item.getName());
        buyField.setText(String.valueOf(item.getBuy()));
        sellField.setText(String.valueOf(item.getSell()));
        stockField.setText(String.valueOf(item.getStock()));
        temp = daoCategory.findById(item.getCategoryId().getId());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new java.awt.Panel();
        nameField = new java.awt.TextField();
        buyField = new java.awt.TextField();
        sellField = new java.awt.TextField();
        categoryCombo = new javax.swing.JComboBox<>();
        stockField = new java.awt.TextField();
        processButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        subtitle = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setPreferredSize(new java.awt.Dimension(671, 643));

        nameField.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        nameField.setText("Masukkan nama barang");

        buyField.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        buyField.setText("Masukkan harga pokok barang");

        sellField.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        sellField.setText("Masukkan harga jual barang");

        categoryCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoryComboItemStateChanged(evt);
            }
        });

        stockField.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        stockField.setText("Masukkan jumlah stok barang");

        processButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        processButton.setText("PROSES");
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        backButton.setText("KEMBALI");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        subtitle.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        subtitle.setText("MENAMBAH/MENGUBAH DATA BARANG");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buyField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sellField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(categoryCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stockField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(processButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(backButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(subtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(subtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buyField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sellField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stockField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(processButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoryComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoryComboItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED){
            String choose = "Pilih satu kategori :";
            if (!categoryCombo.getSelectedItem().toString().equals(choose)) {
                selected = categoryCombo.getSelectedItem().toString();
                JOptionPane.showMessageDialog(this, "you choose" + selected);
            }
        }
    }//GEN-LAST:event_categoryComboItemStateChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        back();
    }//GEN-LAST:event_backButtonActionPerformed

    @Override
    public void back() {
        this.setVisible(false);
        new BossMenu().setVisible(true);
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
        Item item = new Item();
        item.setName(nameField.getText());
        item.setBuy(Integer.valueOf(buyField.getText()));
        item.setSell(Integer.valueOf(sellField.getText()));
        item.setStock(Integer.valueOf(stockField.getText()));
        Category category = daoCategory.findByName(selected);
        item.setCategoryId(category);
        action(item, category);
    }
    
    @Override
    public void action(Item item, Category category) {
        if(itemEdit > -1) {
            another(-1, category);
            item.setId(itemEdit);
            daoItem.update(itemEdit, item);
        } else {
            another(1, category);
            daoItem.save(item);
        }
    }
    
    @Override
    public void another(int counters, Category category) {
        boolean condition = true;
        if(counters == -1 && Objects.equals(category.getId(), temp.getId()))
            condition = false;
        if(condition == true) {
            category.setTotal(category.getTotal() + counters);
            daoCategory.update(category.getId(), category);
        }
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
            java.util.logging.Logger.getLogger(ItemForm.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new ItemForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private java.awt.Panel background;
    private java.awt.TextField buyField;
    private javax.swing.JComboBox<String> categoryCombo;
    private java.awt.TextField nameField;
    private javax.swing.JButton processButton;
    private java.awt.TextField sellField;
    private java.awt.TextField stockField;
    private java.awt.Label subtitle;
    // End of variables declaration//GEN-END:variables
}
