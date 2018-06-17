package lambda;

public class TestCommand {

	public static void main(String[] args) {

		// Etape  1 : classe anonyme
		Command c1 = new Command () {
			public void doSth(String s) {	
				s.equals("Hello");
			}	
		};

		// Etape 2 : je retire le code administratif (signature de méthode)
		// J'ajoute la flèche des lambdas
		Command c2 = (String s) -> {
			s.equals("Hello");
		};

		// Etape 3 : Java sait que s est de type String   
		Command c3 = s -> {
			s.equals("Hello");
		};

	}

}