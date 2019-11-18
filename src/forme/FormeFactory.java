package forme;

public class FormeFactory {

	public static int FORME_RECTANGLE = 1;
	public static int FORME_TRIANGLE = 2;
	public static int FORME_LIGNE = 3;
	public static int FORME_CERCLE = 4;
	public static int FORME_CONTENEUR = 5;

	public static Forme create(int forme, int... args) {

		Forme formeCreee = null;

		if (forme == FORME_RECTANGLE) {

			int x1 = args[0];
			int y1 = args[1];
			int x2 = args[2];
			int y2 = args[3];

			formeCreee = new Rectangle(x1, y1, x2, y2);

		}
		else if (forme == FORME_TRIANGLE) {

            int x1 = args[0];
            int y1 = args[1];
            int x2 = args[2];
            int y2 = args[3];
            int x3 = args[4];
            int y3 = args[5];

            formeCreee = new Triangle(x1, y1, x2, y2, x3, y3);

		}
		else if (forme == FORME_LIGNE) {

            int x1 = args[0];
            int y1 = args[1];
            int x2 = args[2];
            int y2 = args[3];

			formeCreee = new Ligne(x1, y1, x2, y2);

		}
		else if (forme == FORME_CERCLE) {

            int x = args[0];
            int y = args[1];
            int w = args[2];

			formeCreee = new Cercle(x, y, w);

		}
		else if (forme == FORME_CONTENEUR) {
			int x1 = args[0];
			int x2 = args[1];
			int y1 = args[2];
			int y2 = args[3];
			
			Conteneur cont = new Conteneur(x1, x2, y1, y2);
			cont.ajouterForme(FormeFactory.create(FORME_TRIANGLE, x1, y1, x2, y2, x1 + 50, y1+50));
			Forme contForm = new LabelDecorator(cont);
			contForm = new PoisDecorator(contForm);
			//cont.ajouterForme(FormeFactory.create(1, x1, x1 - 50, y1, y1 - 50));
			formeCreee = contForm;
		}
		return formeCreee;
	}
}