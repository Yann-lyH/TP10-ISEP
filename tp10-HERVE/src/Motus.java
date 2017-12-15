import java.util.Scanner;

public class Motus {
	static int z = 1;

	public static String evaluer(String motJoueur, String motRecherche) {
		String motCorrection = "";
		String[] S1 = motJoueur.split("");
		String[] S2 = motRecherche.split("");
		String S3[] = new String[S1.length];

		for (int i = 0; i < S1.length; i++) {
			if (S1[i].equals(S2[i])) {
				S3[i] = "o";
			} else {
				if (motRecherche.indexOf(S1[i]) == -1) {
					S3[i] = "x";
				} else {
					// je ne sais pas comment n'afficher qu'un "-" lorsque'une lettre n'est présente
					//qu'une fois dans le mot du dico mais plusieurs fois dans le mot entré par le joueur.
					S3[i] = "-";
				}
				
			} 

		}
		for (int b = 0; b < S3.length; b++) {
			motCorrection = motCorrection + S3[b];
		}
		System.out.println(motCorrection);
		return motCorrection;
	}
	 public static void Compteur(String motC) {
		 System.out.println("Voulez vous continuer? ");
		 Scanner scan1 = new Scanner(System.in);
		 String d = scan1.nextLine();
			if (d.equals("yes")) {
				z = z + 1;
				System.out.println("nombre d'essai: " + z);
				System.out.println("Entrer la réponse");
				d = scan1.nextLine();
				evaluer(d, motC);
				if (d.equals(motC)) {
					System.out.println("Bien joué!");
					
				} else {
					Compteur(motC);
				}
				
			}else if (d.equals("no")) {
				System.out.println("Dommage");
				System.out.println("Le mot à trouver était: " + motC);
				System.out.println("Score total: " + z);
			} else {
				System.out.println("veuillez rentrer 'yes' or 'no' ");
				Compteur(motC);
			}
	 }

	public static void main(String[] args) {
		System.out.println("nombre d'essai: " + z);
		String motChoisi = Dictionnaire.choose();
		if (Dictionnaire.find(motChoisi)) {
			String[] mot = motChoisi.split("");
			System.out.println("première lettre: " + mot[0] + " et nombre de lettres: " + mot.length);
			Scanner scan = new Scanner(System.in);
			System.out.println("Entrer la réponse");
			String c = scan.nextLine();
			evaluer(c, motChoisi);
			if (c.equals(motChoisi)) {
				System.out.println("Bien joué!");
				
			} else {
				Compteur(motChoisi);
			}
				

		}

	}
}
