package sumberrejeki.dao;

import sumberrejeki.model.Item;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class DaoItem extends BaseDao<Item> implements Classification,
        FindByName<Item> {

    public DaoItem(Class<Item> type) {
        super(type);
    }

    @Override
    public void update(int id, Item t) {
        startTransaction(PERSISTANCE_META);
        Item editItem = entityManager.find(Item.class, id);
        editItem.setName(t.getName());
        editItem.setBuy(t.getBuy());
        editItem.setSell(t.getSell());
        editItem.setStock(t.getStock());
        editItem.setCategoryId(t.getCategoryId());
        entityManager.getTransaction().commit();
        endTransaction();
    }
    
    @Override
    public Item findByName(String name) {
        List<Item> items = findAll();
        Item result = null;
        for (Item item : items) {
            if(item.getName().equals(name)) {
                result = item;
                break;
            }
        }
        return result;
    }
    
    @Override
    public Object[] row(Item item) {
        Object[] row = new Object[6];
        row[0] = item.getId();
        row[1] = item.getName();
        row[2] = item.getBuy();
        row[3] = item.getSell();
        row[4] = item.getStock();
        row[5] = item.getCategory();
        return row;
    }
    
    @Override
    public DefaultComboBoxModel dropdown(int id) {
        List<Item> items = findAll();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Pilih satu kategori :");
        items.stream().filter((item) -> (item.getCategoryId().getId() == id)).
            forEachOrdered((item) -> { model.addElement(item.getName());
        });
        return model;
    }
}
