/**
	Question: Command Design Pattern.

	Reference:  https://dzone.com/articles/design-patterns-command
				https://www.youtube.com/watch?v=7Pj5kAhVBlg

	Definition: Client says I want a specific command to run when execute() is called on one of the any encapsulated(hidden) objects. Client or User just gives us the commnad like on or off. Now by using this commnad we need to perform many actions how we perform or by using which class we perform is not needed for the user.

	Explanation: 
		- Suppose if we want to turn on the TV. 
		- Click on TV remote button to turn on.
		- This will call "DeviceController" class which will inturn call TurnTVOn will be called which inturn calls Television.TurnTVOn().
*/

class Light {
	private boolean light_on;
	public void switch_on(boolean on) { light_on = on; }
	public void switch_off(boolean off) { light_on = off; }
}

interface Command {
	public void execute();
}

class LightOn_Command implements Command {
	
	Light light;
	
	public LightOn_Command(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.switch_on(true);
		System.out.println("Light Turned On.");
	}
}

class LightOff_Command implements Command {

	Light light;
	
	public LightOff_Command(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.switch_off(false);
		System.out.println("Light Turned Off.");
	}
}

class Switch_Button {
	private Command command;
	
	public void setSwitchCmd(Command command) {
		this.command = command;
	}
	
	public void pressSwitch() {
		command.execute();
	}
}

public class CommandPattern {
	public static void main(String[] args) {
		Switch_Button switch_btn = new Switch_Button();
		Light light = new Light();
		LightOn_Command lightOn_Cmd = new LightOn_Command(light);
		LightOff_Command lightOff_Cmd = new LightOff_Command(light);
		
		switch_btn.setSwitchCmd(lightOn_Cmd);
		switch_btn.pressSwitch();
		
		switch_btn.setSwitchCmd(lightOff_Cmd);
		switch_btn.pressSwitch();
	}
}