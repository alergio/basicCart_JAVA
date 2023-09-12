public class Cliente {
    public static void main(String[] args) {
        // inicializo productos
        Product naranjas = new Product("Naranja x kg", 50.0);
        Product manzanas = new Product("Manzanas x kg", 60.0);
        Product limones = new Product("Limones x kg", 70.0);
        Product lechuga = new Product("Lechuga x unidad", 40.0);

        // inicializo el carro
        Cart cart = new Cart();

        // intento avanzar, deberia dar error porque el carro esta vacio
        cart.next();

        // intento pagar, deberia dar error
        cart.pay();

        System.out.println("------------------separador-----------");

        // agrego los productos al carro
        cart.addToCart(naranjas);
        cart.addToCart(manzanas);
        cart.addToCart(limones);
        cart.addToCart(lechuga);

        System.out.println("------------------separador-----------");

        // pruebo vaciar el carrito
        cart.cleanCart();

        System.out.println("------------------separador-----------");

        // vuelvo a agregar los productos
        cart.addToCart(naranjas);
        cart.addToCart(manzanas);
        cart.addToCart(limones);
        cart.addToCart(lechuga);

        // consulto el total del carro
        cart.getTotalProducts();

        System.out.println("------------------separador-----------");

        // pruebo avanzar y retroceder
        cart.next();
        cart.goBack();

        System.out.println("------------------separador-----------");

        // consulto devuelta los productos
        cart.getTotalProducts();

        System.out.println("------------------separador-----------");

        // voy a pagar y finalizo la compra
        cart.pay();
        cart.next();
        cart.next();

        System.out.println("------------------separador-----------");

        // consulto el total del carrito
        cart.getTotalProducts();


    }
}
