package sumberrejeki.view;

public interface Saving {
    public void save();
    public void back();
    public default void process() {
        save();
        back();
    }
}
