package com.proyectofinal.sistemasdistribuidos;

import java.util.ArrayList;

public class ConfirmationCart {

    private ArrayList<Producto> listProducts;
    private int precioTotalProductos;

    public ConfirmationCart(ArrayList<Producto> listProducts, int precioTotalProductos){
        this.listProducts = listProducts;
        this.precioTotalProductos = precioTotalProductos;
    }

    public ArrayList<Producto> getListProducts() {
        return listProducts;
    }

    public void setListProducts(ArrayList<Producto> listProducts) {
        this.listProducts = listProducts;
    }

    public int getPrecioTotalProductos() {
        return precioTotalProductos;
    }

    public void setPrecioTotalProductos(int precioTotalProductos) {
        this.precioTotalProductos = precioTotalProductos;
    }
}
