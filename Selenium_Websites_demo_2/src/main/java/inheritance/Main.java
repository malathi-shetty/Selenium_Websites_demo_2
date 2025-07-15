package inheritance;

public class Main {
	

		public static void doPrint(Base o) {
			o.print();
		}

	public static void main(String[] args) {
		Base x = new Base(); // parent
		Base y = new Derived(); // parent ref - child class
		Derived z = new Derived(); // child
		doPrint(x); // Outputs: Base
		doPrint(y); // Outputs: Derived
		doPrint(z); // Outputs: Derived
	}

	}


