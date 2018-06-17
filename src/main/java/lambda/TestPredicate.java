package lambda;

public class TestPredicate {

	public static void main(String[] args) {

		// Etape  1 : classe anonyme
		Predicate p1 = new Predicate () {
			public boolean test(String s) {
				return s.length()>10;
			}	
		};

		// Etape 2 : je retire le code administratif (signature de méthode)
		// J'ajoute la flèche des lambdas
		Predicate p2 = (String s) -> {
			return s.length()>10;
		};

		// Etape 3 : Java sait que s est de type String car p3 est de type Predicate et Java
		// peut voir dans la signature de son unique méthode que le paramètre est 
		// de type String
		Predicate p3 = s -> {
			return s.length()>10;
		};

		// Etape 4 : Comme il n'y a a que le return dans le corps de la méthode
		// je peux supprimer les accolades ainsi que le return
		Predicate p4 = s -> s.length()>10;
	}
}