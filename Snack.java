/*
Kevin Josué Villagrán Mérida - 23584
Laboratorio #3 
Fecha de creación: 21/10/2023 12:00
Fecha de ultima modificación: 21/10/2023 23:35
*/
public class Snack extends Producto{

    //Atributos
    private float gramos;
    private String sabor;
    private String tamano;

    //Constructor de la clase Snack, aqui se definen todos sus atributos y los de la superclase tambien
    public Snack(int id, String nombre, int cantidadDisponible, int cantidadVendidos, boolean estado, float precio, float gramos, String sabor, String tamano){
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.gramos = gramos;
        this.sabor = sabor;
        this.tamano = tamano;
    }

    public String toString(){//Muestra a detalle todos los datos de este producto
        return "\n=== Datos del snack: " + nombre + " ===" +
        "\nId: " + id +
        "\nNombre: " + nombre +
        "\nTipo: Bebida" + 
        "\nCantidad disponible: " + cantidadDisponible +
        "\nCantidad de ejemplares ventidos: " + cantidadVendidos + 
        "\nEstado: " + getEstado() +
        "\nPrecio: " + precio +
        "\nSabor: " + sabor +
        "\nGramos: " + gramos +
        "\nTamaño: " + tamano;
    }
}