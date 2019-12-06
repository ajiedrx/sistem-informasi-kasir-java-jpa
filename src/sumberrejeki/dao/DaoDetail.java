package sumberrejeki.dao;

import java.util.ArrayList;
import sumberrejeki.model.Detail;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import sumberrejeki.model.Item;
import sumberrejeki.model.Transaction;
import static sumberrejeki.view.CashierMenu.transactionId;

public class DaoDetail extends BaseDao<Detail>{
    DaoItem daoItem;
    DaoTransaction daoTransaction;
    
    public DaoDetail(Class<Detail> type) {
        super(type);
        daoItem = new DaoItem(Item.class);
        daoTransaction = new DaoTransaction(Transaction.class);
    }

    @Override
    public void update(int id, Detail t) {
        startTransaction(PERSISTANCE_META);
        Detail editDetail = entityManager.find(Detail.class, id);
        editDetail.setTotal(t.getTotal());
        editDetail.setPrice(t.getPrice());
        editDetail.setItemId(t.getItemId());
        editDetail.setTransactionId(t.getTransactionId());
        entityManager.getTransaction().commit();
        endTransaction();
    }
    
    @Override
    public Object[] row(Detail detail) {
        Object[] row = new Object[4];
        row[0] = detail.getId();
        row[1] = detail.getItem();
        row[2] = detail.getTotal();
        row[3] = detail.getPrice();
        return row;
    }

    public void back(List<Detail> details) {
        Detail temp = details.get(0);
        details.forEach((detail) -> {
            Item item = detail.getItemId();
            item.setStock(item.getStock() + detail.getTotal());
            daoItem.update(item.getId(), item);
            delete(detail);
        });
        daoTransaction.delete(temp.getTransactionId());
    }

    public int total(List<Detail> details) {
        int sum = 0;
        sum = details.stream().map((detail) ->
                detail.getPrice()).reduce(sum, Integer::sum);
        return sum;
    }
    
    public int profit(List<Detail> details) {
        int sum = 0;
        sum = details.stream().map((detail) -> (detail.getPrice() 
                - (detail.getTotal() * detail.getItemId().getBuy()))).
                reduce(sum, Integer::sum);
        return sum;
    }
    
    public List<Detail> allInCart() {
        List<Detail> details = findAll();
        List<Detail> results = new ArrayList<>();
        details.stream().filter((detail) -> (
            detail.getTransactionId().getId().equals(transactionId))).
            forEachOrdered((detail) -> { results.add(detail);
        });
        return results;
    }
    
    public DefaultTableModel cart() {
        DefaultTableModel model = new DefaultTableModel();
        Object[] objects = new Object[]{"id", "nama", "total", "harga"};
        model.setColumnIdentifiers(objects);
        List<Detail> carts = allInCart();
        carts.forEach((cart) -> { model.addRow(row(cart)); });
        model.addRow(finalRow(carts));
        return model;
    }
    
    public Object[] finalRow(List<Detail> carts) {
        Object[] row = new Object[4];
        row[0] = "Total";
        row[1] = "";
        row[2] = "";
        row[3] = total(carts);
        return row;
    }
}
