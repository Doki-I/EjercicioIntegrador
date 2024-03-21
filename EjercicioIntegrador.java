/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciointegrador;

import javax.swing.JOptionPane;

//Clase principal que controla el inventario del supermercado en el que se trabaja (SUPER CHINO)
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
