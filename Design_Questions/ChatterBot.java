/**
	Question: ChatterBot sysytem.

	Reference:  https://www.planet-source-code.com/vb/scripts/ShowCode.asp?txtCodeId=5369&lngWId=3
				http://www.codeproject.com/Articles/36106/Chatbot-Tutorial

	Tutorial:

	  Basics:
		- ChatterBot requires knowledge of three domains,
			1) AI
			2) NLP (Natural Language Processing)
			3) Expert System
		- The system does not know anything on its own. It has a database of facts and rules which are searched to give the best possible response.
		- Very rarely it matches the entire sentense. It gives the answer only based on the keywords in the question.

	  How does it work?
		Knowledge Base:
	  		What ever the machine says we will from the "knowledge base".
	  	
	  	Static Database:
	  		When ever the system does not understand what the user is saying then we write the answer from the static database.	
	  		Example scenarios like enter, some random text so the system writes back saying .. "sorry can you be more clear."

		Keywords:
			System does not read the entire sentense which the user types. It takes the sentence and gets the keywords and based on that keyword it searches the "knowledge base" and returns the output. So everythign is "context" based not what the user has exactly written.
			So keywords define the context.
			Once the context is defined then the system deliberatly motivates the user to speak about that topic.
*/

class ChatterBot {

}