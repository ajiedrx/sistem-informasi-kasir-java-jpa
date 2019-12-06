package sumberrejeki.view;

public interface Running {
    public void initVariables();
    public void load();
    public default void runComponents() {
        initVariables();
        load();
    }
}
