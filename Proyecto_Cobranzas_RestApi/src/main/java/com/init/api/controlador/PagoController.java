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

import com.init.api.modelo.Empleado;
import com.init.api.modelo.Pago;
import com.init.api.servicio.IPago;


@Controller
@RequestMapping(value="/pago")
public class PagoController {

	@Autowired
	private IPago pagoservice;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Pago>> listarPago(@RequestParam(name = "empleadoId",required=false) Long empleadoId){
	
		
		List<Pago> pagos= new ArrayList<>();
		if(empleadoId==null) {
			pagos=pagoservice.ListAllPago();
			if(pagos.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			pagos=pagoservice.findByEmpleado(Empleado.builder().idempleado(empleadoId).build());
			if(pagos.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.ok(pagos);
	}
	
	@RequestMapping(value="/buscar/{id}",method = RequestMethod.GET)
	public ResponseEntity<Pago> getPago(@PathVariable("id")Long id){
		Pago pago=pagoservice.getPago(id);
		if (pago==null) {
			return ResponseEntity.noContent().build();
			
		}
		return ResponseEntity.ok(pago);
	}
	
	@RequestMapping(value="/crear",method = RequestMethod.POST)
	public ResponseEntity<Pago> crearPago(@Validated @RequestBody Pago pago,BindingResult result){
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Pago pagoCreado=pagoservice.createPago(pago);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pagoCreado);
	}
	
	
	@PutMapping(value="/editar/{id}")
	public ResponseEntity<Pago> actualizarPago(@PathVariable("id")Long id,@RequestBody Pago pago){
	pago.setIdpago(id);
	Pago pagoactualizado=pagoservice.updatePago(pago);
	   if(pagoactualizado==null) {
		   return ResponseEntity.notFound().build();
	   }
	   return ResponseEntity.ok(pagoactualizado);
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminarPago(@PathVariable("id") Long idpago) {
		pagoservice.deletePago(idpago);
	}
	
	
	
}
