package main;
import Entity.Bebida;
import Entity.Comida;
import Entity.Pedido;
import Entity.Producto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class main
{
   // public List<Producto> lista_productos = new ArrayList<>();
    public static void main(String[] args)
    {

        List<Producto> lista_productos = new ArrayList<Producto>();
        List<Pedido> listaPed = new ArrayList<Pedido>();


        lista_productos = CargaPrevia();

         Scanner scanner = new Scanner(System.in);
            int opcion = 0;

            do {
                mostrarMenu();
                opcion = leerOpcion();

                switch (opcion)
                {
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
                        int id;
                        id = elegirProducto(3,lista_productos);
                            actualizarProducto(id, lista_productos);
                        break;
                    case 4:
                        int id_elim;
                        id_elim = elegirProducto(4,lista_productos);
                        eliminarProducto(id_elim, lista_productos);
                        break;
                    case 5:
                        id=elegirProductoPedido(5,lista_productos);
                        if(id!=-1)
                            {
                            Producto p = new Producto();
                            p= lista_productos.get(id);
                            Pedido auxPed = new Pedido();
                            auxPed= crearPedido(p);
                            if(auxPed != null)
                            {
                                listaPed.add(auxPed);
                            }
                        }
                        break;
                    case 6:
                        listarPedidos(listaPed);
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

    private static List<Producto> CargaPrevia()
    {
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

    private static int leerOpcion()
    {
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

    private static  void mostrarMenu()
    {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1) Agregar producto");
        System.out.println("2) Listar productos");
        System.out.println("3) Actualizar producto");
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

    private static void listarProductos(List<Producto>prod)
    {
        prod.forEach(System.out::println);

        System.out.println("REPORTE:");
        System.out.println("________");

        for (int i = 0; i < prod.size(); i++) {
            System.out.println("_____________________________________________________");
            System.out.println("Producto: "+ prod.get(i).getNombre()+ " PU: " + prod.get(i).getPrecioUnitario());
            System.out.println("Cantidad: " + prod.get(i).getCantidad());
            if(prod.get(i) instanceof Bebida)
            {
                System.out.println("Marca: " + ((Bebida) prod.get(i)).getMarca());
                System.out.println("Tipo de Bebida: " + ((Bebida) prod.get(i)).getTipoBebida() );
                System.out.println("Mililitros: " + ((Bebida) prod.get(i)).getMilitros());
            }
            if (prod.get(i) instanceof Comida)
            {
                System.out.println("Marca: " + ((Comida) prod.get(i)).getMarca());
                System.out.println("Peso: " + ((Comida) prod.get(i)).getPeso() );
                System.out.println("Tipo de Comida: " + ((Comida) prod.get(i)).getTipoComida());
            }
        }
        System.out.println("_____________________________________________________");

    }
    private static List<Producto> actualizarProducto(int id, List<Producto>lista) {
        Scanner sc = new Scanner(System.in);
        System.out.println("SE VA A ACTUALIZAR  EL PRODUCTO CON ID: "+ id);
        for (Producto producto : lista) {
            if (producto.getId() == id) {

                System.out.println("ingrese nuevo nombre de Producto: ");
                String nombre = sc.nextLine();
                producto.setNombre(nombre);

                System.out.println("Ingrese nuevo Precio de Producto: ");
                double valorUnit = sc.nextDouble();
                producto.setPrecioUnitario(valorUnit);
                sc.nextLine();

                System.out.println("Ingrese nueva cantidad de Producto: ");
                int cant = sc.nextInt();
                producto.setCantidad(cant);
                sc.nextLine();

                if(producto instanceof Bebida)
                {
                    System.out.println("Ingrese nuevo tipo de bebida: ");
                    String tipoBebida = sc.next();
                    ((Bebida) producto).setTipoBebida(tipoBebida);
                    sc.nextLine();

                    System.out.println("Ingrese nueva cantidad en cm cubicos: ");
                    int mililitros = sc.nextInt();
                    ((Bebida) producto).setMilitros(mililitros);
                    sc.nextLine();

                    System.out.println("Ingrese nueva Marca del producto: ");
                    String marca = sc.nextLine();
                    ((Bebida) producto).setMarca(marca);
                    //sc.nextLine();
                }else if(producto instanceof Comida) {
                    System.out.println("Ingrese nueva Categoria de Comida ingresada: ");
                    String tipocomida = sc.nextLine();
                    ((Comida) producto).setTipoComida(tipocomida);
                    //sc.nextLine();

                    System.out.println("Ingrese nuevo peso de Comida por presentacion: ");
                    double peso = sc.nextDouble();
                    ((Comida) producto).setPeso(peso);
                    sc.nextLine();

                    System.out.println("Ingrese nueva Marca del producto: ");
                    String marca = sc.nextLine();
                    ((Comida) producto).setMarca(marca);
                }
                System.out.println("Producto con ID " + id + " actualizado exitosamente.");
                break; //cortar
            }

        }
        return lista;
    }
    private static List<Producto> eliminarProducto (int id, List<Producto>lista)
    {
            Scanner sc = new Scanner(System.in);

            System.out.println("SE VA A ELIMINAR DE LA LISTA EL PRODUCTO CON ID: "+ id);
            System.out.println("Si desea confirmar escriba OK: ");
            String bandera = sc.nextLine();
            if(bandera.equals("ok"))
            {
                for (int i =0 ; i<lista.size(); i++)
                {
                    if (lista.get(i).getId() == id)
                    {
                        lista.remove(i); // Elimina el producto actual de la lista
                        System.out.println("Producto con ID " + id + " eliminado exitosamente.");
                        break;
                    }
                }
            }
            return lista;
        }
        private static Pedido crearPedido (Producto prod)
        {
            Producto unProd = new Producto();
            unProd = prod;
            Pedido unPedido = new Pedido();
            System.out.println("producto: " + unProd.getNombre() +" , Precio: " + unProd.getPrecioUnitario()+ " , Stock: " + unProd.getCantidad());

            unPedido.setProducto(unProd);
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("ingrese nro de pedido: ");
                int pedido = sc.nextInt();
                unPedido.setNropedido(pedido);
                sc.nextLine();

                System.out.println("Ingrese cantidad a Pedir: ");
                int cant = sc.nextInt();
                unPedido.setCantidad(cant);

                //pruebo aca
                unPedido.restarStock(cant);
                System.out.println("Se descontaron " + cant + " del STOCK de producto: " + unPedido.getProducto().getNombre());

                System.out.println("PRODUCTO AGREGADO A PEDIDO " + pedido + " CON EXITO");
            }
            catch (Exception e) {
                System.out.println("Ocurrio un error de tipeo: " + e.toString());
                return null;
            }

            return unPedido ;
        }
        private static void listarPedidos (List<Pedido>pedido)
        {
            pedido.forEach(System.out::println);

            System.out.println("REPORTE:");
            System.out.println("________");

            for (int i = 0; i < pedido.size(); i++) {
                System.out.println("_____________________________________________________");
                System.out.println("Pedido: "+ pedido.get(i).getNropedido()+ " Nombre: " + pedido.get(i).getProducto().getNombre());
                System.out.println("Cantidad pedida: " + pedido.get(i).getCantidad());
                System.out.println("Precio unitario: " + pedido.get(i).getProducto().getPrecioUnitario());
            }
            System.out.println("_____________________________________________________");

        }
        private static Bebida cargarBebida ()
        {
            Scanner sc = new Scanner(System.in);
            Bebida beb = new Bebida();
            try {

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

            } catch (Exception e) {
                System.out.println("Ocurrio un error de tipeo: " + e.toString());
                return null;
            }
            return beb;
        }

        private static Comida cargarComida ()
        {
            Scanner sc = new Scanner(System.in);
            Comida comida = new Comida();
            try {
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

                System.out.println("NUEVO PRODUCTO INGRESADO");

            } catch (Exception e) {
                System.out.println("Ocurrio un error de tipeo: " + e.toString());
                return null;
            }
            return comida;
        }
        private static int elegirProducto (int opcion, List < Producto > lista)
        {
            String eleccion ="";
            if(opcion==3)
            {
                eleccion = "MODIFICAR";
            }
            else
            {
                if(opcion==4)
                {
                    eleccion = "ELIMINAR";
                }
                else
                {
                    if(opcion==5)
                    {
                        eleccion = "CREAR PEDIDO";
                    }
                }
            }

            for (int i = 0; i < lista.size(); i++) {
                System.out.println("_____________________________________________________");
                System.out.println("ID: "+ lista.get(i).getId() + " Nombre: " + lista.get(i).getNombre());
            }
            System.out.println("_____________________________________________________");
            Scanner sc = new Scanner(System.in);
            System.out.println("SELECCIONE NRO DE ID PARA " + eleccion);
            int valor = sc.nextInt();
            return valor;
        }

    private static int elegirProductoPedido (int opcion, List < Producto > lista)
    {
        String eleccion ="";
        if(opcion==5)
        {
            eleccion = "CREAR PEDIDO";
        }

        for (int i = 0; i < lista.size(); i++) {
            System.out.println("_____________________________________________________");
            System.out.println("ID: "+ lista.get(i).getId() + " Nombre: " + lista.get(i).getNombre());
        }
        System.out.println("_____________________________________________________");
        int valor = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("SELECCIONE NRO DE ID PARA " + eleccion);
        System.out.println("Si quiere agregar mas productos vuelva a agregar un producto con el mismo nro de pedido");
        try {
            valor = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Ocurrio un error de tipeo: " + e.toString());
        }

        int indice = -1;
        for (int i = 0; i < lista.size(); i++) {
            if(valor == lista.get(i).getId())
            {
                indice = i;
                break;
            }

        }
        if (indice==-1){
            System.out.println("el indice no existe");
        }
        return indice;
    }

}

