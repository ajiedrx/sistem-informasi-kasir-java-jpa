package sumberrejeki.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.table.DefaultTableModel;

public abstract class BaseDao<T> {
    public final String PERSISTANCE_META = "persistance";
    EntityManagerFactory emFactory;
    EntityManager entityManager;
    private final Class<T> type;

    public BaseDao(Class<T> type) {
        this.type = type;
    } 
    
    public void startTransaction(String persistence) {
        emFactory = Persistence.createEntityManagerFactory(persistence);
        entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }
    
    public void endTransaction() {
        entityManager.close();
        emFactory.close();
    }
    
    public void save(T t) {
        startTransaction(PERSISTANCE_META);
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        endTransaction();
    }
    
    public abstract void update(int id, T t);
    
    public void delete(T t) {
        startTransaction(PERSISTANCE_META);
        T t2 = entityManager.merge(t);
        entityManager.remove(t2);
        entityManager.getTransaction().commit();
        endTransaction();
    }
    
    public T findById(int id) {
        startTransaction(PERSISTANCE_META);
        T t = entityManager.find(type, id);
        endTransaction();
        return t;
    }
    
    public List<T> findAll() {
        startTransaction(PERSISTANCE_META);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(type);
        Root<T> rootEntry = cq.from(type);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = entityManager.createQuery(all);
        List<T> result = allQuery.getResultList();
        endTransaction();
        return result;
    }
    
    public DefaultTableModel table(Object[] objects) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(objects);
        for(int i = 0; i < findAll().size(); i++)                                 
            model.addRow(row(findAll().get(i)));
        return model;
    }
    
    public abstract Object[] row(T t);
}
