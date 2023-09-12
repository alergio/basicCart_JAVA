public interface StateCart {
    void clearOut();
    void load(Product product);
    void pay();
    void close();
}
