package sumberrejeki.dao;

import sumberrejeki.model.State;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sumberrejeki.model.Account;

public class DaoState extends BaseDao<State> implements Classification,
        FindByName<State> {
    
    DaoAccount daoAccount;
    
    public DaoState(Class<State> type) {
        super(type);
        daoAccount = new DaoAccount(Account.class);
    }

    @Override
    public void update(int id, State t) {
        startTransaction(PERSISTANCE_META);
        State editState = entityManager.find(State.class, id);
        editState.setName(t.getName());
        entityManager.getTransaction().commit();
        endTransaction();
    }
    
    @Override
    public State findByName(String name) {
        List<State> states = findAll();
        State result = null;
        for (State state : states) {
            if (state.getName().equals(name)) {
                result = state;
                break;
            }
        }
        return result;
    }
    
    @Override
    public Object[] row(State state) {
        Object[] row = new Object[2];
        row[0] = state.getId();
        row[1] = state.getName();
        return row;
    }
    
    @Override
    public DefaultComboBoxModel dropdown(int id) {
        List<State> states = findAll();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        if (id != -1)
            model.addElement(daoAccount.findById(id).getStateId().getName());
        model.addElement("Pilih satu status :");
        states.forEach((state) -> { model.addElement(state.getName()); });
        return model;
    }
}
