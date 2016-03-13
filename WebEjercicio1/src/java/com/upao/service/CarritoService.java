package com.upao.service;

import com.upao.dto.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Upao
 */
public class CarritoService {
    private List<Producto> lista;
    
    public CarritoService(){
        lista=new ArrayList<>();
    }
    
    //Agregar
    public void agregar(Producto producto){
        producto.setImporte(producto.getPrecio()*producto.getCant());
        lista.add(producto);
    }
    
    //Listar
    public List<Producto> getLista(){
        return lista;
    }
    
    //Calculo Importe
    public double getTotal(){
        double total=0;
        for (Producto p : lista) {
            total+=p.getImporte();
        }
        return total;
    }
}
