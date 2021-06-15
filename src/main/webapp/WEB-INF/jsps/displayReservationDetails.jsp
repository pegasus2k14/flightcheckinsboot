<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
  <h2>Flight Details</h2>
  Airlines: ${reservation.flightId.operatingAirlines} <br/>
  Flight number: ${reservation.flightId.flightNumber}<br/>
  Departure city: ${reservation.flightId.departureCity}<br/>
  Arrival city: ${reservation.flightId.arrivalCity}<br/>
  Date of Departure: ${reservation.flightId.dateOfDeparture}<br/>
  Estimated Departure time: ${reservation.flightId.estimatedDepartureTime}<br/>
  
  <h2>Passenger Details</h2>
  Name: ${reservation.passengerId.firstName}  ${reservation.passengerId.lastName}<br/>
  Email: ${reservation.passengerId.email}<br/>
  Email: ${reservation.passengerId.phone}<br/><br/>
  
  <!-- Para que el pasajero ingrese el # de maletas a registrar -->
  <form action="completeCheckin" method="post">
     
     <input type="hidden" value="${reservation.id}" name="reservationId">
     
     Enter number of bags to checkin: <input type="text" name="numberOfBags"/>
     <input type="submit" value="Check In">
  </form>
</body>
</html>