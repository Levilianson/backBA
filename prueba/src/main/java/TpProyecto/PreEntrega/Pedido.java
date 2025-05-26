package TpProyecto.PreEntrega;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Producto> productos;

    public Pedido() {
        this.productos= new ArrayList<>();
    }
    public void agregarProductoAlPedido(Producto producto){
        this.productos.add(producto);
    }
}
