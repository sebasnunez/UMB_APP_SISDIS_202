package com.proyectofinal.sistemasdistribuidos;

import java.util.ArrayList;

public class Cart {

    private String id;
    private ArrayList<Producto> listaItems = new ArrayList<>();

    public Cart(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addProduct(Producto producto){
        listaItems.add(producto);
    }

    public void eliminarProducto(int idProducto){
        if(!listaItems.isEmpty()){
            for(int i=0; i<listaItems.size();i++){
                if(listaItems.get(i).getId() == idProducto){
                    listaItems.remove(i);
                }
            }
        }
    }

    public ArrayList<Producto> getListProducts(){
        return listaItems;
    }

    public void deleteAllProducts(){
        listaItems.clear();
    }

}
