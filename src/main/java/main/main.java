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
                        Producto aux = new Producto();
                        aux= agregarProducto();
                        if (aux!=null){
                            lista_productos.add(aux);
                        }
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

    private static Producto agregarProducto()
    {
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
            if (opcion==2)
            {
                aux = new Comida();
                aux = cargarComida();
            }
        }
        //System.out.println("producto agregado.");
        return aux;
        }

    private static void listarProductos(List<Producto>prod){
        prod.forEach(System.out::println);

    }
    private static void actualizarProducto(Producto prod){
        System.out.println("producto editado");
        

    }
    private static void eliminarProducto(){
        System.out.println("se eliminara producto");
    }
    private static void crearPedido(){

    }
    private static void listarPedidos(){

    }



    private static Bebida cargarBebida()
    {
        Scanner sc = new Scanner(System.in);
        Bebida beb = new Bebida();
        try
        {

            System.out.println("Ingrese Nombre de Bebida: ");
            String nombre = sc.nextLine();
            beb.setNombre(nombre);
            //sc.nextLine();

            System.out.println("Ingrese Precio de Bebida: ");
            double precio = sc.nextDouble();
            beb.setPrecioUnitario(precio);
            sc.nextLine();

            System.out.println("Ingrese Cantidad para Stock: ");
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
            String marca = sc.nextLine();
            beb.setMarca(marca);
            //sc.nextLine();

        }
        catch (Exception e)
        {
            System.out.println("Ocurrio un error de tipeo: " + e.toString());
            return null;
        }
        return beb;
    }

    private static Comida cargarComida()
    {
        Scanner sc = new Scanner(System.in);
        Comida comida = new Comida();
        try
        {
            System.out.println("Ingrese Nombre de Comida: ");
            String nombre = sc.nextLine();
            comida.setNombre(nombre);


            System.out.println("Ingrese Precio de la Comida: ");
            double precio = sc.nextDouble();
            comida.setPrecioUnitario(precio);
            sc.nextLine();

            System.out.println("Ingrese cantidad de Comida para stock: ");
            int cantidad = sc.nextInt();
            comida.setCantidad(cantidad);
            sc.nextLine();

            System.out.println("Ingrese Categoria de Comida ingresada: ");
            String tipocomida = sc.nextLine();
            comida.setTipoComida(tipocomida);
            //sc.nextLine();

            System.out.println("Ingrese peso de Comida por presentacion: ");
            double peso = sc.nextDouble();
            comida.setPeso(peso);
            sc.nextLine();

            System.out.println("Ingrese Marca del producto: ");
            String marca = sc.nextLine();
            comida.setMarca(marca);

        }
        catch (Exception e) {
            System.out.println("Ocurrio un error de tipeo: " + e.toString());
            return null;
        }
        return comida;
    }

}

