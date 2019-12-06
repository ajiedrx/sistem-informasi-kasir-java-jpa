package sumberrejeki.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import sumberrejeki.model.Transaction;

public class DaoTransaction extends BaseDao<Transaction>{
    
    public DaoTransaction(Class<Transaction> type) {
        super(type);
    }

    @Override
    public void update(int id, Transaction t) {
        startTransaction(PERSISTANCE_META);
        Transaction editTransaction = entityManager.find(Transaction.class, id);
        editTransaction.setTime(t.getTime());
        editTransaction.setAccountId(t.getAccountId());
        editTransaction.setTotal(t.getTotal());
        editTransaction.setProfit(t.getProfit());
        entityManager.getTransaction().commit();
        endTransaction();
    }
    
    public Transaction findIdByTime(String time) {
        Transaction result = null;
        List<Transaction> transactions = findAll();
        for (Transaction transaction : transactions) {
            if (transaction.getTime().equals(time)) {
                result = transaction;
                break;
            }
        }
        return result;
    }
    
    @Override
    public Object[] row(Transaction transaction) {
        Object[] row = new Object[5];
        row[0] = transaction.getId();
        row[1] = transaction.getTime();
        row[2] = transaction.getTotal();
        row[3] = transaction.getAccount();
        row[4] = transaction.getProfit();
        return row;
    }
    
    public String time() {
        LocalDateTime date = LocalDateTime.now(); 
        DateTimeFormatter dateFormat =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return date.format(dateFormat);
    }
}
