/*
Kevin Josué Villagrán Mérida - 23584
Laboratorio #3 
Fecha de creación: 21/10/2023 12:00
Fecha de ultima modificación: 21/10/2023 23:35
*/
public abstract class Producto{

    //Atributos en comun de los productos
    protected int id;
    protected String nombre;
    protected int cantidadDisponible;
    protected int cantidadVendidos;
    protected boolean estado;
    protected float precio;

    //Constructor de la clase producto, aqui se definen todos sus atributos
    public Producto(int id, String nombre, int cantidadDisponible, int cantidadVendidos, boolean estado, float precio){
        this.id = id;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadVendidos = cantidadVendidos;
        this.estado = estado;
        this.precio = precio;
    }

    //Getter del nombre, este originalmente no estaba en el diseño, fue agregado por cuestiones de estetica, para que al disparar los listados se viera mas organizado, en lugar que se mostraran datos extras que no se desean, aunque realmente es nada mas que eso, un apoyo visual.
    public String getNombre(){
        return nombre;
    }

    public int getId(){//Sirve para obtener el id del producto
        return id;
    }

    //Getter del precio, este tampoco estaba originalmente en el analisis y diseño, esto porque se me olvido considerar que la cantidad de ventas se multiplicaria por el precio, pero en este caso lo agrego para que las ventas se puedan dar adecuadamente
    public float getPrecio(){
        return precio;
    }

    public int getVentas(){//Sirve para obtener la cantidad de ejemplares vendidos
        return cantidadVendidos;
    }

    public int getDisponible(){//Sirve para obtener la cantidad de ejemplares disponibles
        return cantidadDisponible;
    }

    public String getEstado(){//Dependiendo de la variable estado, se define si esta o no disponible.
        if(estado)
            return "Disponible";
        else
            return "No disponible";
    }
}