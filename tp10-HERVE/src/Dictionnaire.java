import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;

public class Dictionnaire {
	static String line;

	public static boolean find(String word) {
		try {
			BufferedReader file = new BufferedReader(
					new FileReader("C:\\Users\\Yann-Ly\\eclipse-workspace\\tp10-HERVE\\dictionnaireFr"));
			while ((line = file.readLine()) != null) {
				String a = line.replaceAll("\\d", "");
				if (word.equals(a)) {
					file.close();
					System.out.println("mot présent dans le dico");
					return true;

				}
			}
			file.close();
			System.out.println("mot non présent dans le dico");
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	public static String choose() {
		int i = 0;
		Random numLine = new Random();
		int num = numLine.nextInt(14061);
		try {
			BufferedReader file = new BufferedReader(
					new FileReader("C:\\Users\\Yann-Ly\\eclipse-workspace\\tp10-HERVE\\dictionnaireFr"));
			while ((line = file.readLine()) != null) {
				if (i == num) {
					String a = line.replaceAll("\\d", "");
					//System.out.println("mot random: " + a);          Permet d'afficher le mot sélectionné dans le dico.
					return a;
				} else {
					i++;
				}
			}
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
