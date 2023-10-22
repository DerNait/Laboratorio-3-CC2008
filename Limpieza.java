/*
Kevin Josué Villagrán Mérida - 23584
Laboratorio #3 
Fecha de creación: 21/10/2023 12:00
Fecha de ultima modificación: 21/10/2023 23:35
*/
public class Limpieza extends Producto{

    //Atributos
    private String tipo;
    private String marca;

    //Constructor de la clase limpieza, aqui se definen todos sus atributos y los de la superclase tambien
    public Limpieza(int id, String nombre, int cantidadDisponible, int cantidadVendidos, boolean estado, float precio, String tipo, String marca){
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.tipo = tipo;
        this.marca = marca;
    }

    public String toString(){//Muestra a detalle todos los datos de este producto
        return "\n=== Datos del producto de limpieza: " + nombre + " ===" +
        "\nId: " + id +
        "\nNombre: " + nombre +
        "\nTipo: Limpieza" + 
        "\nCantidad disponible: " + cantidadDisponible +
        "\nCantidad de ejemplares ventidos: " + cantidadVendidos + 
        "\nEstado: " + getEstado() +
        "\nPrecio: " + precio +
        "\nTipo: " + tipo +
        "\nMarca: " + marca;
    }
}