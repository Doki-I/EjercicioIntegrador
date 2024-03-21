/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciointegrador1;


//Enum que se necesita en el trabajo 
enum TipoProducto {
    ALIMENTOS, BEBIDAS, HIGIENE, LIMPIEZA
}

//Clase Producto para representar cada producto
class Producto {
    private String codigo;
    private String nombre;
    private String nombreEmpleado;
    private String cedulaEmpleado;
    private int cantidad;
    private double precioBase;
    private TipoProducto tipo;
    private double precioBruto;
    private double gananciaEsperada;

    public Producto(String codigo, String nombre, String nombreEmpleado, String cedulaEmpleado, int cantidad, double precioBase, TipoProducto tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nombreEmpleado = nombreEmpleado;
        this.cedulaEmpleado = cedulaEmpleado;
        this.cantidad = cantidad;
        this.precioBase = precioBase;
        this.tipo = tipo;
        calcularPrecioBruto();
        calcularGananciaEsperada();
    }

    private void calcularPrecioBruto() {
        switch (tipo) {
            case ALIMENTOS:
                precioBruto = precioBase * 0.2 + precioBase;
                break;
            case BEBIDAS:
                precioBruto = precioBase * 0.3 + precioBase;
                break;
            case HIGIENE:
                precioBruto = precioBase * 0.25 + precioBase + 500;
                break;
            case LIMPIEZA:
                precioBruto = precioBase * 0.19 + precioBase * 0.04 + 1000 + precioBase;
                break;
            default:
                precioBruto = precioBase; // Default case
                break;
        }
    }

    private void calcularGananciaEsperada() {
        gananciaEsperada = (precioBruto - precioBase) * cantidad;
    }

    public String getInfoProducto() {
        return "Código: " + codigo +
                ", Nombre: " + nombre +
                ", Nombre Empleado: " + nombreEmpleado +
                ", Cédula Empleado: " + cedulaEmpleado +
                ", Cantidad: " + cantidad +
                ", Precio Base: " + precioBase +
                ", Tipo: " + tipo +
                ", Precio Bruto: " + precioBruto +
                ", Ganancia Esperada: " + gananciaEsperada;
    }

    public double getPrecioBruto() {
        return precioBruto;
    }

    public double getGananciaEsperada() {
        return gananciaEsperada;
    }
}
