public class Loading implements StateCart{
    private Cart cart;

    public Loading(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void clearOut() {
        // eliminamos los productos del carro
        System.out.println("Eliminando todos los productos del carrito...");
        cart.getProducts().clear();
        cart.setState(new Empty(cart));
        System.out.println("NICE!: Cambio de estado de Carrito Cargando productos a Carrito Vacio");
    }

    @Override
    public void load(Product product) {
        // ya estamos cargando productos
        cart.getProducts().add(product);
        System.out.println("Agregando producto " + product.getDescription());
    }

    @Override
    public void pay() {
        // pasamos al estado pagando
        cart.setState(new Paying(cart));
        System.out.println("NICE!: Cambio estado de Cargando a Pagando.");
    }

    @Override
    public void close() {
        // no podemos cerrar el carrito sin pagar
        System.out.println("ERROR!: Para cerrar el carrito es necesario pagar primero.");
    }
}
