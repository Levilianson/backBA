package TpProyecto.PreEntrega;

import java.util.Locale;

public class Producto {
    private final int id;
    private String nombre;
    private double precio;
    private int stock;
    private int compra;
    private static int contID;

    public Producto(String nombre, double precio, int stock) {
        this.id = contID;
        this.nombre = nombre;
        this.precio = precio;
        this.compra = 0;
        this.stock = stock;
        contID++;
    }
    //public Producto(){}
    // METODOS DE LA CLASE
    public void imprimir(){
        System.out.printf("""
                Codigo: %s - Nombre: %s - Valor: %s - Stock: %s
                """, id,nombre,precio,stock);
    }

    public boolean buscarProducto(String producto){
        //Paso a minuscula pero tambien puede ser a mayusculas
        String enMinuscula= this.nombre.toLowerCase();
        //OPERADOR BOOLEANO
        return enMinuscula.contains(producto.toLowerCase());
    }

    // SETTERS Y GETTERS

    public int dameId() {
        return id;
    }

    public String dameNombre() {
        return nombre;
    }

    public void cambiarNombre(String nombre) {
        this.nombre = nombre;
    }

    public double damePrecio() {
        return precio;
    }

    public void cambiarPrecio(double precio) {
        this.precio = precio;
    }

    public int dameStock() {
        return stock;
    }

    public void cambiarStock(int stock) {
        this.stock = stock;
    }

    public int dameCompra() {
        return compra;
    }

    public void cambiarCompra(int compraompra) {
        this.compra = compra;
    }

    public static int dameContID() {
        return contID;
    }

    public static void cambiarContID(int contID) {
        Producto.contID = contID;
    }
}
