public class Closing implements StateCart{
    private Cart cart;

    public Closing(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void clearOut() {
        // cancelamos el carro.
        System.out.println("Eliminando todos los productos del carrito...");
        cart.getProducts().clear();
        System.out.println("Productos eliminados, cancelando compra...");
        cart.setState(new Empty(cart));
        System.out.println("NICE!: Cambio de estado de Cerrando a Carrito Vacio");
    }

    @Override
    public void load(Product product) {
        // no podemos cargarlo con productos en este paso
        System.out.println("ERROR!: No puedes cargar productos si estas cerrando el carrito.");
    }

    @Override
    public void pay() {
        // no podemos pagar en este paso
        System.out.println("ERROR!: No puedes pagar si ya estas cerrando el carrito.");
    }

    @Override
    public void close() {
        // no podemos cerrarlo si ya esta cerrandose
        System.out.println("ERROR!: No puedes cerrar el carrito si ya esta cerrandose.");
    }
}
