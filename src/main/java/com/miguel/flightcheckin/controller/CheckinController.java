package com.miguel.flightcheckin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miguel.flightcheckin.integration.ReservationRestClient;
import com.miguel.flightcheckin.integration.dto.Reservation;
import com.miguel.flightcheckin.integration.dto.UpdateReservationRequest;

@Controller  //Indicamos q es una clase controladora de Spring MVC
public class CheckinController {
	

	//Inyectamos la clase ReservationRestClientImpl
	@Autowired
	private ReservationRestClient restClient;
   
	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		//retornamos el nombre de la vista a mostrar
		return "startCheckin";
	}
	
	@RequestMapping("/startCheckin")
	public String startCheckin(@RequestParam("reservationId") long  reservationId, ModelMap modelMap) {
		//recuperamos la reservacion en base a su Id
		Reservation reservation = restClient.findReservation(reservationId);
		
		//Agregamos ña Reservacion al ModelMap
		modelMap.addAttribute("reservation", reservation);
		//Retornamos el nombre de la nueva vista a mostrar
		return "displayReservationDetails";
	}
	
	@RequestMapping("/completeCheckin")
	public String completeCheckin(@RequestParam("reservationId") Long reservationId,@RequestParam("numberOfBags") int numberOfBags, ModelMap modelMap) {
		//Creamos una instancia de UpdateReservationRequest
		UpdateReservationRequest request = new UpdateReservationRequest();
		//le seteamos los valores del el ID de la reservacion a modificar y el numero de maletas
		request.setIdReservation(reservationId);
		request.setNumberOfBags(numberOfBags);
		request.setCheckedIn(true);
		
		//invocamos al metodo del cliente REST responsable de enviar la instancia de UpdateReservationRequest
		//adjunta a la petcion al Proveedor de Servicio REST 'flightReservation'
		Reservation updatedReservation = restClient.updateReservation(request);
		
		//agregamos la Reservacion ya modificada al ModelMap
		modelMap.addAttribute("reservation", updatedReservation);
		
		return "checkinConfirmation";
	}
	
}
