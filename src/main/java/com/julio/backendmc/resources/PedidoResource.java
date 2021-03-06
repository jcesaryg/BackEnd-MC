package com.julio.backendmc.resources;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.julio.backendmc.domain.Pedido;
import com.julio.backendmc.services.PedidoService;


@RestController //Controlador Rest
@RequestMapping(value="/pedidos")//RequestMapping Evalua y regresa el Url que sera evaluado http://localhost:8080/pedidos
public class PedidoResource {
    
    @Autowired //Instacion Automatica el objeto
    private PedidoService service;//Accesara al Servicio
    
    @RequestMapping(value = "/{id}",method=RequestMethod.GET) //agrega al request method el id para su busqueda http://localhost:8080/categoria/1
    public ResponseEntity<?> find(@PathVariable Integer id)
    {
        Pedido obj = service.buscar(id);//Se va al servicio y se busca la categoria por el Id
        return ResponseEntity.ok().body(obj); //retorna ok = operacion fue con suceso, body = cuerpo del objeto obj que fue como categoria 
    }
}