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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.init.api.modelo.DetDeuda;
import com.init.api.modelo.Deuda;
import com.init.api.servicio.IDetDeuda;



@Controller
@RequestMapping(value="/detalle")
public class DetDeudaController {

	@Autowired
	private IDetDeuda detalleservice;
	
	@GetMapping("/listar")
	public ResponseEntity<List<DetDeuda>> listarDetalle(@RequestParam(name = "deudaId",required=false) Long deudaId){
	
		
		List<DetDeuda> detalles= new ArrayList<>();
		if(deudaId==null) {
			detalles=detalleservice.ListAllDetDeuda();
			if(detalles.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			detalles=detalleservice.findByDeuda(Deuda.builder().iddeuda(deudaId).build());
			if(detalles.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.ok(detalles);
	}
	
	@RequestMapping(value="/buscar/{id}",method = RequestMethod.GET)
	public ResponseEntity<DetDeuda> getDetalle(@PathVariable("id")Long id){
		DetDeuda detalle=detalleservice.getDetDeuda(id);
		if (detalle==null) {
			return ResponseEntity.noContent().build();
			
		}
		return ResponseEntity.ok(detalle);
	}
	
	@RequestMapping(value="/crear",method = RequestMethod.POST)
	public ResponseEntity<DetDeuda> crearDetalle(@Validated @RequestBody DetDeuda detalle,BindingResult result){
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		DetDeuda detalleCreado=detalleservice.createDetDeuda(detalle);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(detalleCreado);
	}
	
	@PutMapping(value="/editar/{id}")
	public ResponseEntity<DetDeuda> actualizarDetalle(@PathVariable("id")Long id,@RequestBody DetDeuda detalle){
	detalle.setIddeudatalle(id);
	DetDeuda detalleactualizado=detalleservice.updateDetDeuda(detalle);
	   if(detalleactualizado==null) {
		   return ResponseEntity.notFound().build();
	   }
	   return ResponseEntity.ok(detalleactualizado);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminarDetalle(@PathVariable("id") Long id) {
		detalleservice.deleteDetDeuda(id);
	}
	

	

}
