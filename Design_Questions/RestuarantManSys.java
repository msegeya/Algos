/**
	Question: Restuarant Management System

	Logic: 
		- Classes present are Customer, Restuarant, Order, Owner, Employee (delievered by employee details), Menu

	Class Details:
		Restuarant 		= Address, Timings, Rating, Menu
		Customer		= Customer name, Table id, Order id
		Order 			= Order id, Order items id(s), Emoployee id, Order Status
		Menu 			= Items, price, availability
		Employee 		= Employee id, isActiveEmp(), OrderTaken, OrderDelievary
		Owner 			= Name, Restuarant Id, Orders
		Table			= table id, isAvailable, table capacity

	How system works?
		- Customer checks the address of the restuarant and asks for a table.
		- Employee checks for the table (we can also talk about capacity of the table.) and allocates a table to customer.
		- Customer looks at the Menu and orders items.
		- Employee creates a new order for the customer (or by table id) with the items the customer want.
		- Order will be having the items, table id, customer name, Employee id who had raised the order.
		- Once the order is served we change the order status to true and enter the order id in to Owner's list.
*/

class RestuarantManSys {
	
}