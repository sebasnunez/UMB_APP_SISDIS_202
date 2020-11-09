package com.proyectofinal.sistemasdistribuidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controler {

    private ArrayList<Cart> carts = new ArrayList<>();

    @Autowired
    Producer MessageProducer;

    @PostMapping("/addItem")
    public void addItem(@PathVariable String topic, @PathVariable String idCart, @RequestBody Producto body) {
        Cart currentCart = null;
        if(carts.isEmpty()){
            currentCart = new Cart(idCart);
            carts.add(currentCart);
        }else{
            for(int i=0; i<carts.size(); i++){
                if(carts.get(i).getId().equals(idCart)){
                    currentCart = carts.get(i);
                }
            }
            if(currentCart == null){
                currentCart = new Cart(idCart);
                carts.add(currentCart);
            }
        }
        currentCart.addProduct(body);
        MessageProducer.sendMessage(topic, "Producto agregado al carrito de compras");
    }

    @GetMapping("/showCart")
    public void showCart(@PathVariable String topic, @RequestParam(value = "idCart", required = true) String idCart){
        Cart currentCart = null;
        if(carts.isEmpty()){
            MessageProducer.sendMessage(topic, "No existe un carrito de compras para mostrar");
        }else{
            for(int i=0; i<carts.size(); i++){
                if(carts.get(i).getId().equals(idCart)){
                    currentCart = carts.get(i);
                }
            }
            if(currentCart == null){
                MessageProducer.sendMessage(topic, "No existe un carrito de compras para mostrar");
            }else{
                MessageProducer.sendList(topic, currentCart.getListProducts());
            }
        }
    }

    @DeleteMapping("/deleteItemCart")
    public void deleteItemCart(@PathVariable String topic, @RequestParam(value = "idCart", required = true) String idCart,
                               @RequestParam(value = "idProduct", required = true) int idProduct){
        Cart currentCart = null;
        if(carts.isEmpty()){
            MessageProducer.sendMessage(topic, "No existe un carrito de compras para mostrar");
        }else {
            for(int i=0; i<carts.size(); i++){
                if(carts.get(i).getId().equals(idCart)){
                    currentCart = carts.get(i);
                }
            }
            if(currentCart == null){
                MessageProducer.sendMessage(topic, "No existe un carrito de compras para mostrar");
            }else{
                currentCart.eliminarProducto(idProduct);
                MessageProducer.sendMessage(topic, "Producto eliminado del carriot de compras");
            }
        }
    }

    @DeleteMapping("/deleteAllItems")
    public void deleteAllItems(@PathVariable String topic, @RequestParam(value = "idCart", required = true) String idCart){
        Cart currentCart = null;
        if(carts.isEmpty()){
            MessageProducer.sendMessage(topic, "No existe un carrito de compras para mostrar");
        }else {
            for(int i=0; i<carts.size(); i++){
                if(carts.get(i).getId().equals(idCart)){
                    currentCart = carts.get(i);
                }
            }
            if(currentCart == null){
                MessageProducer.sendMessage(topic, "No existe un carrito de compras para mostrar");
            }else{
                currentCart.deleteAllProducts();
                MessageProducer.sendMessage(topic, "Se vaciado el carrito de compras");
            }
        }
    }

    @GetMapping("/confirmarComprar")
    public void confirmarCompra(@PathVariable String topic, @RequestParam(value = "idCart", required = true) String idCart){
        Cart currentCart = null;
        int precioTotalItems = 0;
        if(carts.isEmpty()){
            MessageProducer.sendMessage(topic, "No existe un carrito de compras para mostrar");
        }else {
            for(int i=0; i<carts.size(); i++){
                if(carts.get(i).getId().equals(idCart)){
                    currentCart = carts.get(i);
                }
            }
            if(currentCart == null){
                MessageProducer.sendMessage(topic, "No existe un carrito de compras para mostrar");
            }else{
                for(int i=0; i<currentCart.getListProducts().size(); i++){
                    Producto currentProduct = currentCart.getListProducts().get(i);
                    precioTotalItems += currentProduct.getPrecio();
                }
                ConfirmationCart confirmationCart = new ConfirmationCart(currentCart.getListProducts(), precioTotalItems);
                MessageProducer.sendListTotal(topic, confirmationCart);
            }
        }

    }


}
