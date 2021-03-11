
public class ClasePrincipal {

	static String rutaCovid19 = "";

	public static void main(String[] args) {

		rutaCovid19 = "C:\\Users\\sseba\\Desktop\\Sebas\\DAM2\\Acceso a Datos\\workspaceAD\\Covid-19\\CCAA\\datos_ccaas.csv";
		AccesoFichero ac = new AccesoFichero();
		ac.AccesoFichero();
		AccesoFichero.fileWriter();
	}
}
