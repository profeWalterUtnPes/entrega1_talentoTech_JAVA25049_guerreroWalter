package main;
import Entity.Bebida;
import Entity.Comida;
import Entity.Producto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class main {
   // public List<Producto> lista_productos = new ArrayList<>();
    public static void main(String[] args) {
        List<Producto> lista_productos = new ArrayList<Producto>();
        lista_productos = CargaPrevia();

         Scanner scanner = new Scanner(System.in);
            int opcion = 0;

            do {
                mostrarMenu();
                opcion = leerOpcion();

                switch (opcion) {
                    case 1:
                        lista_productos.add(agregarProducto());
                        break;
                    case 2:
                        listarProductos(lista_productos);
                        break;
                    case 3:
                        actualizarProducto();
                        break;
                    case 4:
                        eliminarProducto();
                        break;
                    case 5:
                        crearPedido();
                        break;
                    case 6:
                        listarPedidos();
                        break;
                    case 7:
                        System.out.println("¡Gracias por usar la aplicación! ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }


                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            } while (opcion != 7);

            scanner.close(); // Cerrar el scanner al salir
        }//main

    private static List<Producto> CargaPrevia(){
        List<Producto>lista_productos = new ArrayList<Producto>();
        lista_productos.add(new Bebida("pepsi clasic",3500,100,"gaseosa",2500,"PEPSICO"));
        lista_productos.add(new Bebida("7up clasic",3500,100,"gaseosa",2500,"PEPSICO"));
        lista_productos.add(new Bebida("pepsi ligth",3500,100,"gaseosa",2500,"PEPSICO"));
        lista_productos.add(new Bebida("7up Ligth",3500,100,"gaseosa",2500,"PEPSICO"));

        lista_productos.add(new Comida("arroz 500g largo fino ", 1500,200,"granos",0.5,"molinos"));
        lista_productos.add(new Comida("fideos tirabuzon", 2500,200,"pastas",0.5,"molinos"));
        lista_productos.add(new Comida("Te", 1800,200,"infuciones",0.250,"morenita"));
        return lista_productos;
    }

    private static int leerOpcion() {
            Scanner scanner = new Scanner(System.in);
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea pendiente
                return opcion;
                }
            catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer de entrada
                return -1; // Retorna un valor inválido para que se repita el ciclo
                }
    }

    private static  void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1) Agregar producto");
        System.out.println("2) Listar productos");
        System.out.println("3) Buscar/Actualizar producto");
        System.out.println("4) Eliminar producto");
        System.out.println("5) Crear un pedido");
        System.out.println("6) Listar pedidos");
        System.out.println("7) Salir");
        System.out.print("Elija una opción: ");
    }

    private static Producto agregarProducto(){
        Producto aux = new Producto();
        Scanner sc = new Scanner(System.in);
        System.out.println("Que va ingresar una Bebida :1 o Comida: 2 ");
        int opcion =sc.nextInt();
        if (opcion == 1)
        {
            aux = new Bebida();
            aux = cargarBebida();

        }
        else
        {

        }

                System.out.println("producto agregado.");
        return aux;
        }
    private static int listarProductos(List<Producto>prod){
        prod.forEach(System.out::println);
        /*System.out.println("ID: "+ prod.get(6).getId() +
                " Producto: " + prod.get(6).getNombre());*/
        return  2;
    }
    private static int actualizarProducto(){
        System.out.println("producto editado");
        return  3;
    }
    private static int eliminarProducto(){
        System.out.println("se eliminara producto");

        return  4;
    }
    private static int crearPedido(){
        return  5;
    }
    private static int listarPedidos(){
        return  6;
    }
    private static Bebida cargarBebida(){
        Scanner sc = new Scanner(System.in);
        Bebida beb = new Bebida();
        try
        {
            System.out.println("Ingrese Nombre: ");
            String nombre = sc.next();
            beb.setNombre(nombre);
            sc.nextLine();

            System.out.println("Ingrese Precio: ");
            double precio = sc.nextDouble();
            beb.setPrecioUnitario(precio);
            sc.nextLine();

            System.out.println("Ingrese Cantidad: ");
            int cantidad = sc.nextInt();
            beb.setCantidad(cantidad);
            sc.nextLine();

            System.out.println("Ingrese tipo de bebida: ");
            String tipoBebida = sc.next();
            beb.setTipoBebida(tipoBebida);
            sc.nextLine();

            System.out.println("Ingrese cantidad en cm cubicos: ");
            int mililitros = sc.nextInt();
            beb.setMilitros(mililitros);
            sc.nextLine();

            System.out.println("Ingrese Marca del producto: ");
            String marca = sc.next();
            beb.setMarca(marca);
            sc.nextLine();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

        return beb;
    }


}

