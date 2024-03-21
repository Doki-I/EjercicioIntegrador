/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejerciciointegrador;



import javax.swing.JOptionPane;

//Clase principal que controla el inventario del supermercadoe en el que se trabaja (SUPER CHINO)
public class EjercicioIntegrador {

    public static void main(String[] args) {
        String nombreSupermercado = JOptionPane.showInputDialog(null, "Ingrese el nombre del supermercado:");
        String codigoSupermercado = JOptionPane.showInputDialog(null, "Ingrese el código del supermercado:");
        String nombreEmpleado = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado:");
        String cedulaEmpleado = JOptionPane.showInputDialog(null, "Ingrese la cédula del empleado:");

        int numProductos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de productos a ingresar:"));
        Producto[] inventario = new Producto[numProductos];

        for (int i = 0; i < numProductos; i++) {
            String codigo = JOptionPane.showInputDialog(null, "Ingrese el código del producto " + (i + 1) + ":");
            String nombreProducto = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto " + (i + 1) + ":");
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de productos a ingresar:"));
            double precioBase = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio base del producto " + (i + 1) + ":"));

            String tipoStr = JOptionPane.showInputDialog(null, "Ingrese el tipo de producto " + (i + 1) + " (Alimentos, Bebidas, Higiene, Limpieza):");
            TipoProducto tipo = TipoProducto.valueOf(tipoStr.toUpperCase());

            inventario[i] = new Producto(codigo, nombreProducto, nombreEmpleado, cedulaEmpleado, cantidad, precioBase, tipo);
        }

        StringBuilder inventarioInfo = new StringBuilder();
        double totalGanancia = 0.0;
        for (Producto producto : inventario) {
            inventarioInfo.append(producto.getInfoProducto()).append("\n");
            totalGanancia += producto.getGananciaEsperada();
        }

        JOptionPane.showMessageDialog(null, "Inventario del Supermercado: " + nombreSupermercado + " - Código: " + codigoSupermercado + "\n" + inventarioInfo.toString() + "\nMonto total de ganancia esperada: " + totalGanancia);
    }
}

[Clase Producto]
    
//ENUM QUE SE PIDE EN EL TRABAJO
enum TipoProducto {
    ALIMENTOS, BEBIDAS, HIGIENE, LIMPIEZA
}

//CLASE REPRESENTADA EN PRODUCTO PARA IDENTIFICAR DETALLES 
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
    
//CALCULOS NECESARIOS PARA SACAR LOS PRECIOS DE CADA PRODUCTO CON SUS REFERENTES GANANCIAS 
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
                precioBruto = precioBase; 
                break;
        }
    }

    private void calcularGananciaEsperada() {
        gananciaEsperada = (precioBruto - precioBase) * cantidad;
    }

    public String getInfoProducto() {
        return "Código: " + codigo
                + ", Nombre: " + nombre
                + ", Nombre Empleado: " + nombreEmpleado
                + ", Cédula Empleado: " + cedulaEmpleado
                + ", Cantidad: " + cantidad
                + ", Precio Base: " + precioBase
                + ", Tipo: " + tipo
                + ", Precio Bruto: " + precioBruto
                + ", Ganancia Esperada: " + gananciaEsperada;
    }

    public double getPrecioBruto() {
        return precioBruto;
    }

    public double getGananciaEsperada() {
        return gananciaEsperada;
    }
}
//USE GET PARA OBTENER LOS CALCULOS.
