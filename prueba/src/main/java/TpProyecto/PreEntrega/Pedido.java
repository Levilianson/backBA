package TpProyecto.PreEntrega;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final int numeroPedido;
    private List<Producto> productos;
    private static int contPedido;
    private double total=0;

    public Pedido() {
        this.productos= new ArrayList<>();
        this.total=0;
        this.numeroPedido =contPedido;
        contPedido++;
    }

    public void agregarProductoAlPedido(Producto producto){
        double total=+ producto.dameCompra()*producto.damePrecio();
        this.productos.add(producto);
    }

    public void imprimirPedido(){
        System.out.printf("""
                Numero Pedido: %s Total: %s 
                """,numeroPedido,total);
        for (Producto producto: productos){
            System.out.println(producto.dameId()+producto.dameNombre()+producto.dameCompra());
        }
    }
}
