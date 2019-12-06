package sumberrejeki.dao;

import sumberrejeki.model.Account;
import java.util.List;

public class DaoAccount extends BaseDao<Account>{
    
    public DaoAccount(Class<Account> type) {
        super(type);
    }

    @Override
    public void update(int id, Account t) {
        startTransaction(PERSISTANCE_META);
        Account editAccount = entityManager.find(Account.class, id);
        editAccount.setName(t.getName());
        editAccount.setPassword(t.getPassword());
        editAccount.setStateId(t.getStateId());
        entityManager.getTransaction().commit();
        endTransaction();
    }
    
    public Account login(String name, String password) {
        List<Account> accounts = findAll();
        Account result = null;
        for(Account account : accounts){
            if (check(account, name, password)) {
                result = account;
                break;
            }
        }
        return result;
    }
    
    public boolean check(Account account, String name, String password) {
        if(account.getName().equals(name)) { 
            if (account.getPassword().equals(password))
                return true;
            else
                return false;
        } else
            return false;
    }
    
    @Override
    public Object[] row(Account account) {
        Object[] row = new Object[4];
        row[0] = account.getId();
        row[1] = account.getName();
        row[2] = account.getPassword();
        row[3] = account.getState();
        return row;
    }
}
