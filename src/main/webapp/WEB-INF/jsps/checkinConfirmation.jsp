<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check In Confirmation</title>
</head>
<body>
  Check in completed Successfully!<br/>
  Reservation Id: ${reservation.id} <br/>
  Passenger Name: ${reservation.passengerId.firstName} ${reservation.passengerId.lastName}<br/>
  Flight number: ${reservation.flightId.flightNumber}<br/>
  
  
</body>
</html>