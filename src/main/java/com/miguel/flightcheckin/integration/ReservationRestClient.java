package com.miguel.flightcheckin.integration;

import com.miguel.flightcheckin.integration.dto.Reservation;
import com.miguel.flightcheckin.integration.dto.UpdateReservationRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(UpdateReservationRequest request);
}

