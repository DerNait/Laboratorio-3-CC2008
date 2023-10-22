/*
Kevin Josué Villagrán Mérida - 23584
Laboratorio #3 
Fecha de creación: 21/10/2023 12:00
Fecha de ultima modificación: 21/10/2023 23:35
*/
import java.io.*;//Importamos librerias
import java.util.*;

public class Tienda{

    public static void main(String[] args){
        ArrayList<Producto> productos = new ArrayList<Producto>();
        Scanner scan = new Scanner(System.in);

        boolean salir = false;//Permite salir del programa
        String seleccion;

        //Cargamos CSV de la tienda
        try{
            Scanner fileScan = new Scanner(new File("productos_tienda.csv"));
            fileScan.useDelimiter(";");

            if(fileScan.hasNextLine()){
                fileScan.nextLine();
            }

            while(fileScan.hasNextLine()){
                String[] productosData = fileScan.nextLine().split(";");

                switch(productosData[6]){
                    case "Bebida":
                        Bebida bebida;
                        
                        if(productosData[4].equals("Disponible"))
                            bebida = new Bebida(Integer.parseInt(productosData[0]),productosData[1],Integer.parseInt(productosData[2]),Integer.parseInt(productosData[3]),true,Float.parseFloat(productosData[5]),Float.parseFloat(productosData[7]), productosData[8]);
                        else
                            bebida = new Bebida(Integer.parseInt(productosData[0]),productosData[1],Integer.parseInt(productosData[2]),Integer.parseInt(productosData[3]),false,Float.parseFloat(productosData[5]),Float.parseFloat(productosData[7]), productosData[8]);

                        productos.add(bebida);                        
                        break;
                    case "Snack":
                        Snack snack;

                        if(productosData[4].equals("Disponible"))
                            snack = new Snack(Integer.parseInt(productosData[0]),productosData[1],Integer.parseInt(productosData[2]),Integer.parseInt(productosData[3]),true,Float.parseFloat(productosData[5]),Float.parseFloat(productosData[9]),productosData[10],productosData[11]);
                        else
                            snack = new Snack(Integer.parseInt(productosData[0]),productosData[1],Integer.parseInt(productosData[2]),Integer.parseInt(productosData[3]),false,Float.parseFloat(productosData[5]),Float.parseFloat(productosData[9]),productosData[10],productosData[11]);

                        productos.add(snack);
                        break;
                    case "Limpieza":
                        Limpieza limpieza;

                        if(productosData[4].equals("Disponible"))
                            limpieza = new Limpieza(Integer.parseInt(productosData[0]),productosData[1],Integer.parseInt(productosData[2]),Integer.parseInt(productosData[3]),true,Float.parseFloat(productosData[5]),productosData[8],productosData[12]);
                        else
                            limpieza = new Limpieza(Integer.parseInt(productosData[0]),productosData[1],Integer.parseInt(productosData[2]),Integer.parseInt(productosData[3]),false,Float.parseFloat(productosData[5]),productosData[8],productosData[12]);

                        productos.add(limpieza);
                        break;
                }
            }

            System.out.println("\nArchivo productos_tienda.csv cargado correctamente...");//En caso de que lo cargue correctamente
            System.out.println(productos.size());

        }catch(Exception e){
            System.out.println("\nNo se pudo cargar el archivo de productos_tienda.csv");//En caso de que no
            System.out.println("Motivo: " + e);
            System.out.println(productos.size());
        }

        System.out.println("\nBienvenido al sistema de la administracion de productos de la tienda");

        while(!salir){//Menu principal
            System.out.println("\n=== MENU DE OPCIONES ===");
            System.out.println("¿Que desea hacer?");
            System.out.println("1. Buscar un producto por medio del id.");           
            System.out.println("2. Listar los productos de una categoria");
            System.out.println("3. Mostrar las ventas actuales");   
            System.out.println("4. Mostrar el informe general de la tienda");
            System.out.println("5. Salir");

            seleccion = scan.nextLine();

            switch(seleccion){//Depende de la seleccion del usuario, se hace cada opcion del menu
                case "1":
                    buscarProducto(productos);
                    break;
                case "2":
                    listarCategoria(productos);
                    break;
                case "3":
                    mostrarVentas(productos);
                    break;
                case "4":
                    mostrarInforme(productos);
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default://Si mete un valor invalido
                    System.out.println("\nIngrese un valor numerico valido");
            }
        }
    }

    public static void buscarProducto(ArrayList<Producto> productos){
        Scanner scan = new Scanner(System.in);
        boolean anException = false;
        int id = 0;//Aqui se almacenara el id del producto que el usuario desea ver

        do{//Ciclo que se interrumpe solo si no hay un error en el dato que introduce el usuario
                    System.out.println("\nIngrese el ID del producto que desea ver: ");
                try{
                    id = Integer.parseInt(scan.nextLine());//Se almacena el dato del ID
                    anException = false;
                }catch(Exception e){
                    System.out.println("\nIntroduzca un valor numerico valido");
                    anException = true;
                }
        } while(anException);
        for(Producto producto : productos){
            if(producto.getId() == id)//Se muestran los detalles del producto si coincide con el ID del producto
                System.out.println(producto);
        }
    }

    public static void listarCategoria(ArrayList<Producto> productos){
        Scanner scan = new Scanner(System.in);
        String seleccion = null;

        System.out.println("\nIngrese la categoria del producto que desea ver: (1. Bebida, 2. Snack, 3. Limpieza)");//Se le ofrecen las 3 categorias disponibles
        seleccion = scan.nextLine();//Se almacena la opcion del usuario

        switch(seleccion){//Dependiendo de lo que haya escogido, se imprime el nombre de cada producto de la categoria elegida
            case "1":
                System.out.println("\nListando bebidas...");
                for(Producto producto : productos){
                    if(producto instanceof Bebida)
                        System.out.println(producto.getNombre());
                }
                break;
            case "2":
                System.out.println("\nListando snacks...");
                for(Producto producto : productos){
                    if(producto instanceof Snack)
                        System.out.println(producto.getNombre());
                }
                break;
            case "3":
                System.out.println("\nListando productos de limpieza...");
                for(Producto producto : productos){
                    if(producto instanceof Limpieza)
                        System.out.println(producto.getNombre());
                }
                break;
            default:
                System.out.println("\nIngrese un valor numerico valido");//En caso de no introducir un numero en las categorias
                break;
        }
        
    }

    public static void mostrarVentas(ArrayList<Producto> productos){
        float dineroVentas = 0;
        float comision = 0;

        for(Producto producto : productos){
            if(producto instanceof Limpieza){//Si el producto pertenece a limpieza (mi categoria), entonces:
                dineroVentas += (producto.getPrecio()*producto.getVentas())*0.80;//Se agregara el 80% de las ventas a las ventas totales
                comision += (producto.getPrecio()*producto.getVentas())*0.20;//Se agregara el 20% de las ventas al total de comisiones a pagar
            }
            else
                dineroVentas += (producto.getPrecio()*producto.getVentas());//Si es de las categorias predefinidas, se agrega el precio por la cantidad de productos al total de ventas
        }

        //Se muestra el informe
        System.out.println("\n=== Total de ventas ===");   
        System.out.println("Ventas totales Q"+dineroVentas);  
        System.out.println("Porcentaje por categoria Limpieza Q"+comision);  
    }

    public static void mostrarInforme(ArrayList<Producto> productos){
        //Contadores
        int bebidas = 0;
        int snacks = 0;
        int limpieza = 0;

        for(Producto producto : productos){//Se suma cada producto en cada categoria
            if(producto instanceof Bebida)
                bebidas++;
            
            if(producto instanceof Snack)
                snacks++;
            
            if(producto instanceof Limpieza)
                limpieza++;
        }

        System.out.println("\n=== Listado de cateogiras con el total de productos ===");//Se imprime el total de productos que hay en cada categoria
        System.out.println("a. Bebidas - " + bebidas);
        System.out.println("b. Snacks - " + snacks);
        System.out.println("c. Limpieza - " + limpieza);

        System.out.println("\n=== Listado de productos por categoria ===");//Se listan por nombre los productos que hay en cada categoria
        System.out.println("\n=== Bebidas ===");//Bebidas
        for(Producto producto : productos){
            if(producto instanceof Bebida)
                System.out.println(producto.getNombre());
        }
        
        System.out.println("\n=== Snacks ===");//Snacks
        for(Producto producto : productos){
            if(producto instanceof Snack)
                System.out.println(producto.getNombre());
        }
        
        System.out.println("\n=== Limpieza ===");//Limpieza
        for(Producto producto : productos){            
            if(producto instanceof Limpieza)
                System.out.println(producto.getNombre());
        }

        mostrarVentas(productos);//Se muestran las ventas como se hacia en el metodo anterior
    }
}