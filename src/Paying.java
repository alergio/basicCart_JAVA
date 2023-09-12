public class Paying implements StateCart{
    private Cart cart;
    public Paying(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void clearOut() {
        // cancelamos el carro.
        System.out.println("Eliminando todos los productos del carrito...");
        cart.getProducts().clear();
        System.out.println("Productos eliminados, cancelando compra...");
        cart.setState(new Empty(cart));
        System.out.println("NICE!: Cambio de estado de Pagando a Carrito Vacio");
    }

    @Override
    public void load(Product product) {
        // no podemos cargar productos si ya estamos pagando
        System.out.println("ERROR!: Ya estas pagando, no podes agregar productos.");
    }

    @Override
    public void pay() {
        // no podemos pagar si ya estamos pagando
        System.out.println("ERROR!: Ya estas pagando, no puedes pagar devuelta.");
    }

    @Override
    public void close() {
        // cerramos la compra
        cart.setState(new Closing(cart));
        System.out.println("NICE!: Compra realizada con exito. Gracias!");
        System.out.println("Cambio de estado de Pagando a Cerrado");
    }
}
