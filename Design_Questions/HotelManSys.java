/**
	Question: Hotel Management System.

	Logic: 
		- Classes are Customer, Hotel, Rooms, Reservations, Bill, Employee

	Classes: 
		Customer 	= Name, Address, Phone number, Proof, total stay days, arrival date
		Hotel 		= Name, id, Location
		Rooms 		= id, willBeFreedOn, category, AvailableRooms()
		Reservation = id, room_id, start_date, end_date, customer_id
		Bill 		= id, amount, date, customer_name, room_id, room_type, food_amount
		Employee 	= id, assigned_to_room_id

	Flow: 
		- Customer will reach the hotel using hotel location. Describes the stay details.
		- Employee of the Hotel checks the rooms availability and if available creates a record in the Reservation system.
		- Hotel allocates a Employee for this room (Customer.)
		- Finally after the end of the stay, Hotel creates a bill for the customer stay.
*/

class HotelManSys {

}