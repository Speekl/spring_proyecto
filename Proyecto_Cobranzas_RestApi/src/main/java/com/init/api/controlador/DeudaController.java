package com.init.api.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.server.ResponseStatusException;

import com.init.api.modelo.Deuda;
import com.init.api.servicio.IDeuda;

@Controller
@RequestMapping(value="/deuda")
public class DeudaController {
	
    @Autowired
	private IDeuda deudaservice;

	@GetMapping("/listar")
	public ResponseEntity<List<Deuda>> listarDeuda(){
	
		
		List<Deuda> deudas= new ArrayList<>();

			deudas=deudaservice.ListAllDeuda();
			
			if(deudas.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
	
		return ResponseEntity.ok(deudas);
	}
	
	@RequestMapping(value="/buscar/{id}",method = RequestMethod.GET)
	public ResponseEntity<Deuda> getDeuda(@PathVariable("id")Long id){
		Deuda deuda=deudaservice.getDeuda(id);
		if (deuda==null) {
			return ResponseEntity.noContent().build();
			
		}
		return ResponseEntity.ok(deuda);
	}
	
	@RequestMapping(value="/crear",method = RequestMethod.POST)
	public ResponseEntity<Deuda> crearDeuda(@Validated @RequestBody Deuda deuda,BindingResult result){
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Deuda deudaCreado=deudaservice.createDeuda(deuda);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(deudaCreado);
	}
	
	
	@PutMapping(value="/editar/{id}")
	public ResponseEntity<Deuda> actualizarDeuda(@PathVariable("id")Long id,@RequestBody Deuda deuda){
	deuda.setIddeuda(id);
	Deuda deudaactualizado=deudaservice.updateDeuda(deuda);
	   if(deudaactualizado==null) {
		   return ResponseEntity.notFound().build();
	   }
	   return ResponseEntity.ok(deudaactualizado);
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminarDeuda(@PathVariable("id") Long id) {
		deudaservice.deleteDeuda(id);
	}
}
