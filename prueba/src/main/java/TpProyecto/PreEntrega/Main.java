package TpProyecto.PreEntrega;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        // LISTA DE OBJETOS PRODUCTO Y EL STOCK
        ArrayList<Producto> productos =new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        //ENVIO LA LISTA PARA QUE SE AGREGEN LOS PRODUCTOS
        AgregarProductoBase(productos);
        // PARA GENERAR EL LOOP DEL MENU USAMOS DO / WHILE
        // LA VARIABLE CONDICIONAL ES LA OPCION

        Scanner entrada = new Scanner(System.in);
        int opcion =0;

        do{
            try{
                System.out.println("""
                    Menu Inicio:
                    1- Agregar Producto
                    2- Mostrar Productos
                    3- Buscar o Actualizar producto
                    4- Eliminar producto
                    5- Crear Pedido
                    6- Ver Pedidos
                    7- Salir
                    SELECCIONE UNA OPCION:
                    """);
                opcion = entrada.nextInt();
                //SWICTH CASE PARA EJECUTAR LAS INTRUCCIONES
                switch (opcion){
                    case 1 -> agregarProducto(productos);
                    case 2 -> mostrarProductos(productos);
                    case 3 -> buscarProducto(productos);
                    case 4 -> eliminarProducto(productos);
                    case 5 -> System.out.println(" faltaCrear un pedido");
                    case 6 -> System.out.println("faltaListar pedidos...");
                    case 7 -> System.out.println("HASTA LA PROXIMA");
                    default -> System.out.println("Opcion incorrecta");
                }
            }
            catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e){
                e.printStackTrace();
                System.out.println("EEERRROOORRR 😵");
            }
        }
        while (opcion !=7);
    }
    private static void agregarProducto(ArrayList<Producto>productos){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Nombre del prodructo a Agregar: ");
        String nombre = entrada.nextLine();
        System.out.printf("Precio: %s: ",nombre);
        double precio = entrada.nextDouble();
        System.out.printf("Stock %s: ",nombre);
        int stock = entrada.nextInt();
        Producto producto = new Producto(nombre, precio, stock);

        productos.add(producto);

        System.out.println(" Se cargo exitosamente 🛒");
    }

    private static void mostrarProductos(AbstractList<Producto>productos){
        if(productos.isEmpty()){
            System.out.println(" Esta vacio 🛒");
        }
        else {
            for(Producto producto : productos){
                producto.imprimir();
            }
        }
    }

    private static void buscarProducto(ArrayList<Producto>productos){
        System.out.println("Buscando producto: ");
        Scanner entrada = new Scanner(System.in);
        String buscar = entrada.nextLine();
        ArrayList<Producto>encontrado = new ArrayList<>();

        for(Producto producto: productos){
            if(producto.buscarProducto(buscar)){
                encontrado.add(producto);
            }
        }

        if (encontrado.isEmpty()){
            System.out.println("NO ESTA EL PRODUCTO");
        }
        else {
            for(Producto producto : encontrado){
                producto.imprimir();
            }
        }
    }

    private static void eliminarProducto(ArrayList<Producto>productos){
        Scanner entrada = new Scanner(System.in);
        System.out.println("ID para eliminar: ");
        int idABorrar = entrada.nextInt();
        boolean borrado = false;
        boolean esta = false;
        for(Producto producto : productos){
            if(producto.dameId() == idABorrar){
                esta = true;
                System.out.println("El producto a borrar es el siguiente: ");
                producto.imprimir();
                System.out.println("confirma: 1-SI 2-NO");
                int eliminar = entrada.nextInt();
                if(eliminar == 1){
                    System.out.println("BORRADO");
                    productos.remove(producto);
                    borrado = true;
                    break;
                }
            }
        }
        if(!esta){
            throw new RuntimeException("No esta el producto");
        }
        if(borrado){
            System.out.println("BORRADO OK");
        }

    }

    public static void AgregarProductoBase(ArrayList<Producto> productos) {
        productos.add(new Producto("Monitor", 1000, 10));
        productos.add(new Producto("Micrófono", 2000, 10));
        productos.add(new Producto("Teclado mecánico", 1500, 15));
        productos.add(new Producto("Mouse gamer", 1200, 20));
        productos.add(new Producto("Laptop", 15000, 5));
        productos.add(new Producto("Tablet", 8000, 7));
        productos.add(new Producto("Disco duro externo", 2500, 12));
        productos.add(new Producto("Memoria USB 64GB", 500, 25));
        productos.add(new Producto("Router Wi-Fi", 1800, 10));
        productos.add(new Producto("Smartphone", 12000, 8));
        productos.add(new Producto("Audífonos Bluetooth", 2200, 18));
        productos.add(new Producto("Cámara Web HD", 1300, 10));
        productos.add(new Producto("Impresora", 4000, 6));
        productos.add(new Producto("Proyector", 9000, 4));
        productos.add(new Producto("Reproductor multimedia", 3000, 9));
        productos.add(new Producto("Smartwatch", 3500, 11));
        productos.add(new Producto("Lector de tarjetas", 800, 14));
        productos.add(new Producto("Estabilizador de voltaje", 1100, 10));
        productos.add(new Producto("Cable HDMI", 300, 30));
        productos.add(new Producto("Panel táctil USB", 2000, 5));

    }
}
