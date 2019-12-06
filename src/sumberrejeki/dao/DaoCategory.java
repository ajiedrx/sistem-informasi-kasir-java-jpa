package sumberrejeki.dao;

import sumberrejeki.model.Category;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sumberrejeki.model.Item;

public class DaoCategory extends BaseDao<Category> implements Classification,
        FindByName<Category> {
    DaoItem daoItem;
    
    public DaoCategory(Class<Category> type) {
        super(type);
        daoItem = new DaoItem(Item.class);
    }

    @Override
    public void update(int id, Category t) {
        startTransaction(PERSISTANCE_META);
        Category editCategory = entityManager.find(Category.class, id);
        editCategory.setName(t.getName());
        entityManager.getTransaction().commit();
        endTransaction();
    }
    
    @Override
    public Category findByName(String name) {
        List<Category> categories = findAll();
        Category result = null;
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                result = category;
                break;
            }
        }
        return result;
    }
    
    @Override
    public Object[] row(Category category) {
        Object[] row = new Object[3];
        row[0] = category.getId();
        row[1] = category.getName();
        row[2] = category.getTotal();
        return row;
    }
    
    @Override
    public DefaultComboBoxModel dropdown(int id) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        if (id != -1)
            model.addElement(daoItem.findById(id).getCategoryId().getName());
        List<Category> categories = findAll();
        model.addElement("Pilih satu kategori :");
        categories.forEach((category) -> {
            model.addElement(category.getName());
        });
        return model;
    }
}
