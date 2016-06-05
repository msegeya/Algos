What is REST?
	REpresentative State Transfer

	RESTFUL is referred for web services written by applying REST architectural concept are called RESTful services, it focuses on system resources and how state of resource should be transported over HTTP protocol to a different clients written in different language.  

Key Characteristics:
	*) REST is stateless. (Stateless - They don't persist any state between requests from the client. i.e. the service doesn't know or care, that a subsequent request came from client that has/hasn't made a previous request.)	
	*) You can mix up all the below one and say something.
--------------------------------------------------------------------------------------------
REST Methods:
	GET (Req data from specified resource), POST (Submits data that has to be processed) , PUT, DELETE
--------------------------------------------------------------------------------------------
Difference between PUT and POST methods?
	PUT - Is used to create resources.
	POST - Is used to update resources.

	PUT - If you know the resource location (URL), then use PUT to completely update the resources.
	POST - If you don't know the resource location (URL) then use POST.
--------------------------------------------------------------------------------------------
Can we use GET in place of PUT for creating resource?
NO. Get is used to view data not to update it.
--------------------------------------------------------------------------------------------
Difference between AJAX and REST
	AJAX - Request are sent to server using XHTTPRequest.
	REST - REST uses URL structure and a request/response pattern.

	AJAX - It is a technology.
	REST - It is a software Architecture

	AJAX - Eliminates the interaction between client and server by making calls Asynchronously.
	REST - REST requires interaction between client and server.
--------------------------------------------------------------------------------------------
In Java how do we use REST?
JAXB
--------------------------------------------------------------------------------------------
