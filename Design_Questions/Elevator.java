/**
	Question: Elevator Design.

	Reference: http://stackoverflow.com/a/493350/967638

	NOTE: First we will design only for one elevator. Later we can simulate it for pool of elevators.

	Logic for 1 Elevator: (Read full before editing anything.)
		- Following are present in the elevator class,
			=> Current floor, Moving Up, Moving down, Moving Speed, Door closing speed, Passenger capacity, Max. Floor, Min. Floor, Total weight capacity.
		- When a request comes for "x" floor. Take a queue and add this floor to the queue.
			=> Start at floor 0 that is lift lobby. When a new request comes move to that floor.
		- While moving if a new request comes and if that request is in the same direction in which the lift is moving then stop at that floor else leave the request in the queue.
			Counter: If the lift is moving in that direction but the lift is already full then don't serve the request.
		- What if the first request comes for 2 floor but the current floor is 3 and the elevator is moving up. We don't serve. But if there is one more request and the lift moves in that direction then it has to be served. So if the request cannot be served then push the request into the queue else serve it.
		- Check at every floor if the request is there for this floor or not. If yes then stop else move on.
		- So now all the requests are been served while moving up. Check the queue if there are any pending requests if so then sort the requests in the decreasing order and start serving them.
		- If you reach the bottom floor and check if there are any requests for left if so then sort the queue in increasing order and start serving them.
		- If you are at 5th floor (total 10 floors) and you got request to 8th and 2nd floor at the same time then randomly choose one.

	Logic for pool of Elevators:
		- Elevator class attributes will be same as above.
		- A Bank class which has the details of the elevators that are free and that are servicing requests.

		Scheduling logic: 
		  #) If elevator is available then pick the elevator for the requested floor.
		  	 Else Pick and elevator moving to this floor.
		  	 Else Pick a standing elevator on an another floor.
		  	 Else Pick the elevator with the lowest load.
		
		Elevator States:	
			#) Maintenance: The elevatore does not react to signals from the bank.
			#) Stand: Let's say elevator is at some floor. If the request is for the same floor then door opens else the elevator moves in that direction.
			#) UP: Each time it checks whether the floor is the one which it is trying to server if so then it stops and opens the door and removes the request from its own queue. After completing if there is no more requests for this one then it will stand in that floor.
			#) Down: Same as above but in down direction.

		Elevator Signals:
			#) Alarm: Stop the elevator at the immediate next floor. Open the doors move the requests to the request bank.
			#) Door Open: When ever target floor is reached then open the door.
			#) Door Close: Close the doors if there are open.
*/

class Elevator {
	/*We are just designing not implementing. */
}