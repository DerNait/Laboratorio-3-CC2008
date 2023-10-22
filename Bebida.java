/*
Kevin Josué Villagrán Mérida - 23584
Laboratorio #3 
Fecha de creación: 21/10/2023 12:00
Fecha de ultima modificación: 21/10/2023 23:35
*/
public class Bebida extends Producto{

    //Atributos
    private float mililitros;
    private String tipo;

    //Constructor de la clase Bebida, aqui se definen todos sus atributos y los de la superclase tambien
    public Bebida(int id, String nombre, int cantidadDisponible, int cantidadVendidos, boolean estado, float precio, float mililitros, String tipo){
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.mililitros = mililitros;
        this.tipo = tipo;
    }

    public String toString(){//Muestra a detalle todos los datos de este producto
        return "\n=== Datos de la bebida: " + nombre + " ===" +
        "\nId: " + id +
        "\nNombre: " + nombre +
        "\nTipo: Bebida" + 
        "\nCantidad disponible: " + cantidadDisponible +
        "\nCantidad de ejemplares ventidos: " + cantidadVendidos + 
        "\nEstado: " + getEstado() +
        "\nPrecio: " + precio +
        "\nTipo: " + tipo +
        "\nMililitros: " + mililitros;
    }
}