package com.miguel.flightcheckin.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.miguel.flightcheckin.integration.dto.Reservation;
import com.miguel.flightcheckin.integration.dto.UpdateReservationRequest;

@Component    //Convertimos la Clase en un componente de Spring
public class ReservationRestClientImpl implements ReservationRestClient {
	

	@Override
	public Reservation findReservation(Long id) {
		//Creamos una instancia de RestTemplate de Spring
		RestTemplate restTemplate = new RestTemplate();
		//Ejecutamos el metodo HTTP GET para obtener un objeto Reservation
		Reservation reservation = restTemplate.getForObject("http://localhost:8080/flightreservation/reservations/"+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(UpdateReservationRequest request) {
		//Creamos una instancia de RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//Ejecutamos el metodo HTTP Post para realizar la modificacion 
		Reservation reservation = restTemplate.postForObject("http://localhost:8080/flightreservation/reservations", request, Reservation.class);
		
		return reservation;
	}

}
