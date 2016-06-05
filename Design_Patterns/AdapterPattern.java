/**
	Question: Adpater Pattern

	Reference: 	http://www.avajava.com/tutorials/lessons/adapter-pattern.html?page=1
				https://www.youtube.com/watch?v=qG286LQM6BU

	Definition: (Refer Adapter_pattern.png)
		When two interfaces need to communicate and they don't have a common protocol between then then we need to use Adpater between them such that they will communicate without any issues.

	Explanation: 
		- Consider you are moving from Europe to US and you need to use your laptop in US.
		- Your laptop expects Europe plug for power supply which is not the case in US.
		- So now inorder to get your plug accept US and convert to Europe we need an Adapter.
		- The Adapter knows how to convert one from the other and acts as a middle man.

	Below Code Example: 
		- We have a Celcius reporter class which gives us details only in Celcius.
		- TemparatureInfo is an interface which is the target. That is we should convert the Celcius to Farenheit where Farenheit is the target class.
		- Adapter Patter can be done in two ways,
			1) Adapter Class Pattern
			2) Adapter Object Pattern
		- TemparatureClassAdapter implements TemparatureInfo and extends CelciusReporter which calculates the value of the temparature in celsius in Celcius and Farenheit.
		- TemparatureObjectAdapter implements TemparatureInfo which calculates the value of the temparature using the CelciusReporter object.	
*/

public class AdapterPattern {
	public static void main(String[] args) {
		System.out.println("Adapter Class Pattern");
		TemparatureInfo info_using_class = new TemparatureClassAdapter();
		test(info_using_class);
		
		System.out.println("------------------------------------------");
		
		System.out.println("Adapter Object Pattern");
		TemparatureObjectAdapter info_using_obj = new TemparatureObjectAdapter();
		test(info_using_obj);
	}
	
	public static void test(TemparatureInfo info) {
		System.out.println("For 0 degree Celcius: ");
		info.setTemparatureInC(0);
		System.out.println("Temparature in C: " + info.getTemparatureInC());
		System.out.println("Temparature in F: " + info.getTemparatureInF());
		
		System.out.println("For 85 degree Farenheit: ");
		info.setTemparatureInF(85);
		System.out.println("Temparature in C: " + info.getTemparatureInC());
		System.out.println("Temparature in F: " + info.getTemparatureInF());
	}
}

// Our source is in celsius and our target is in farenheit.
class CelciusReporter {
	double temparature_in_celsius;

	public double getTemparature_in_celcius() {
		return temparature_in_celsius;
	}

	public void setTemparature_in_celcius(double temparature_in_celsius) {
		this.temparature_in_celsius = temparature_in_celsius;
	}
}

// Target Interface is expecting in Farenheit.
interface TemparatureInfo {
	public double getTemparatureInF();
	public void setTemparatureInF(double temparatureInF);
	
	public double getTemparatureInC();
	public void setTemparatureInC(double temparatueInC);
}

// Class Adapter. (We also have Object Adapter. See below class for more details.)
class TemparatureClassAdapter extends CelciusReporter implements TemparatureInfo {

	@Override
	public double getTemparatureInF() {
		return cToF(temparature_in_celsius);
	}
	
	@Override
	public double getTemparatureInC() {
		return temparature_in_celsius;
	}
	
	@Override
	public void setTemparatureInF(double temparatureInF) {
		this.temparature_in_celsius = fToC(temparatureInF);
	}

	@Override
	public void setTemparatureInC(double temparatueInC) {
		this.temparature_in_celsius = temparatueInC;
	}
	
	private double cToF(double c) {
		return ((c * 9 / 5) + 32);
	}
	
	private double fToC(double f) {
		return ((f - 32) * 5 / 9);
	}
	
}

class TemparatureObjectAdapter implements TemparatureInfo {

	CelciusReporter celciusReporter;
	
	public TemparatureObjectAdapter() {
		celciusReporter = new CelciusReporter();
	}
	
	@Override
	public double getTemparatureInC() {
		return celciusReporter.getTemparature_in_celcius();
	}
	
	@Override
	public double getTemparatureInF() {
		return cToF(celciusReporter.getTemparature_in_celcius());
	}

	@Override
	public void setTemparatureInF(double temparatureInF) {
		celciusReporter.setTemparature_in_celcius(fToC(temparatureInF));
	}

	@Override
	public void setTemparatureInC(double temparatueInC) {
		celciusReporter.setTemparature_in_celcius(temparatueInC);
	}
	
	private double cToF(double c) {
		return ((c * 9 / 5) + 32); 
	}
	
	private double fToC(double f) {
		return ((f - 32) * 5 / 9);
	}
}