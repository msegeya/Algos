/**
	Question: Template Design Pattern
	
	Reference: http://www.tutorialspoint.com/design_pattern/template_pattern.htm

	Definition: 
		- In Template pattern, an abstract class exposes defined way(s)/template(s) to execute its methods. Its subclasses can override the method implementation as per need but the invocation is to be in the same way as defined by an abstract class.

	Explanation: 
		- Create an abstract class called Game. 
		 	1) Assume every sport has three steps 1) Initialize 2) startPlay 3) endPlay
		 	2) What ever the game is but the order of the game is constant as "initialize -> startPlay -> endPlay"
		- Take two sports Football and Tennis. Both of them will have same format as above so inorder to maintain the order of teh exectuion we need to create a method called play in the abstract class and mark it as **final**
		- Only if the play class is final then there will be no other sub-class that can override the super class play method.
		- Finally all the concrete sub-classes will have the same template of execution order.
*/

public class TemplatePattern {
	public static void main(String[] args) {
		Game game_football = new Football();
		game_football.play();
		System.out.println("****************************");
		Game game_tennis = new Tennis();
		game_tennis.play();
	}
}

abstract class Game {
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
	
	public final void play() {
		initialize();
		
		startPlay();
		
		endPlay();
	}
}

class Football extends Game {

	@Override
	void initialize() {
		System.out.println("Football initialized.");
	}

	@Override
	void startPlay() {
		System.out.println("Football play started.");
	}

	@Override
	void endPlay() {
		System.out.println("Football play ended.");
	}
}

class Tennis extends Game {

	@Override
	void initialize() {
		System.out.println("Tennis play initialized.");
	}

	@Override
	void startPlay() {
		System.out.println("Tennis play started.");
		
	}

	@Override
	void endPlay() {
		System.out.println("Tennis play ended.");
		
	}
}