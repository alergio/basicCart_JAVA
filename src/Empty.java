public class Empty implements StateCart{

    // referencia a la clase de contexto
    private Cart cart;

    public Empty(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void clearOut() {
        // vaciar si esta vacio no serviria
        System.out.println("ERROR: El carrito ya esta vacio");
    }

    @Override
    public void load(Product product) {
        // permite agregar productos
        cart.setState(new Loading(cart));
        System.out.println("NICE!: Cambio de estado de Carrito Vacio a Carrito cargando productos.");
        cart.getProducts().add(product);
        System.out.println("Agregando producto " + product.getDescription());

    }

    @Override
    public void pay() {
        // no podemos pagar si no hay productos
        System.out.println("ERROR: No hay productos para pagar.");
    }

    @Override
    public void close() {
        // no podemos cerrar el carro si esta vacio
        System.out.println("ERROR: El carro esta vacio, no podemos cerrarlo.");
    }
}
