package main;
import Entity.Bebida;
import Entity.Comida;
import Entity.Producto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {


        List<Producto> lista_productos = new ArrayList<>();

        lista_productos.add(new Bebida("pepsi clasic",3500,100,"gaseosa",2500,"PEPSICO"));
        lista_productos.add(new Bebida("7up clasic",3500,100,"gaseosa",2500,"PEPSICO"));
        lista_productos.add(new Bebida("pepsi ligth",3500,100,"gaseosa",2500,"PEPSICO"));
        lista_productos.add(new Bebida("7up Ligth",3500,100,"gaseosa",2500,"PEPSICO"));

        lista_productos.add(new Comida("arroz 500g largo fino ", 1500,200,"granos",0.5,"molinos"));
        lista_productos.add(new Comida("fideos tirabuzon", 2500,200,"pastas",0.5,"molinos"));
        lista_productos.add(new Comida("Te", 1800,200,"infuciones",0.250,"morenita"));





        lista_productos.forEach(System.out::println);

         Scanner scanner = new Scanner(System.in);
            int opcion = 0;

            do {
                mostrarMenu();
                opcion = leerOpcion();

                switch (opcion) {
                    case 1:
                        agregarProducto();
                        break;
                    case 2:
                        listarProductos();
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

    private static int agregarProducto(){
        System.out.println("producto agregado.");
        return  1;
        }
    private static int listarProductos(){

        return  2;
    }
    private static int actualizarProducto(){
        System.out.println("producto editado");
        return  3;
    }
    private static int eliminarProducto(){
        System.out.println("se eliminara producto);

        return  4;
    }
    private static int crearPedido(){
        return  5;
    }
    private static int listarPedidos(){
        return  6;
    }

}

