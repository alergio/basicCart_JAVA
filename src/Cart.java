import java.util.ArrayList;
public class Cart {
    private StateCart state;
    private ArrayList<Product> products = new ArrayList<>();

    public Cart() {
        this.setState(new Empty(this));
    }

    public void addToCart(Product product){
        this.getState().load(product);
    }

    public void cleanCart() {
        this.getState().clearOut();
    }

    public void pay() {
        this.getState().pay();
    }

    public void next() {
        if (state instanceof Empty){
            System.out.println("ERROR: No puedes avanzar si el carro esta vacio.");
            System.out.println("El estado del carro es: Vacio");
        } else if (state instanceof Loading) {
            System.out.println("Avanzando...");
            this.setState(new Paying(this));
            System.out.println("Ahora estas en el estado: Pagando..");
        } else if(state instanceof Paying) {
            System.out.println("Avanzando...");
            this.setState(new Closing(this));
            System.out.println("Ahora estas en el estado: Cerrando..");
        } else if(state instanceof Closing) {
            System.out.println("Concretando la compra...");
            this.getProducts().clear();
            this.setState(new Empty(this));
            System.out.println("Finalizo la compra, ahora el carrito esta vacio.");
        }
    }

    public void goBack() {
        if (state instanceof Empty){
            System.out.println("ERROR: No puedes volver atras si el carro esta vacio.");
            System.out.println("El estado del carro es: Vacio");
        } else if (state instanceof Loading) {
            System.out.println("ERROR!: No puedes volver atras.. podrias vaciar el carrito.");
            System.out.println("El estado del carro es: Cargando productos");
        } else if(state instanceof Paying) {
            System.out.println("Regresando...");
            this.setState(new Loading(this));
            System.out.println("Ahora estas en el estado: Cargando productos");
        } else if(state instanceof Closing) {
            System.out.println("ERROR!: No puedes volver atras.. ya hiciste tu compra!");
        }
    }

    public StateCart getState() {
        return state;
    }

    public void setState(StateCart state) {
        this.state = state;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void getTotalProducts(){
        if (products.isEmpty()){
            System.out.println("El carrito esta vacio..");
        } else {
            Double totalPrice = 0.0;
            for (Product producto : this.getProducts()) {
                System.out.println("Producto: " + producto.getDescription() + " - Precio: " + producto.getPrice());
                totalPrice += producto.getPrice();
            }
            System.out.println("El precio total del carro es: " + totalPrice);
        }
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

}
