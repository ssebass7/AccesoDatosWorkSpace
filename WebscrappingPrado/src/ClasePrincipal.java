import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClasePrincipal {

	public static void main(String[] args) {
		
		ArrayList<Cuadro> lista_cuadros = new ArrayList();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca la ruta de la colección");
		String ruta = sc.nextLine();
		//https://www.museodelprado.es/coleccion/artista/goya-y-lucientes-francisco-de/39568a17-81b5-4d6f-84fa-12db60780812

		try {
			Document document = Jsoup.connect(ruta).get();
			Element elemento_nombre = document.selectFirst("div.obra-autor>article>h1");
			String nombre_autor="";
			if(elemento_nombre!=null) {
				
				nombre_autor =  elemento_nombre.text();
			
				System.out.println("NOMBRE: " + nombre_autor);
			}
			
			Element	elemento_padre = document.selectFirst("div.mostrable.miniaturas");
			Elements elementos_figure = elemento_padre.select("figure");
			
			for(Element e : elementos_figure) {
				
				Element elemento_imagen = e.selectFirst("div.imgwrap>a>img");
				Element elemento_titulo = e.selectFirst("figcaption>dl>dt.trunca-texto>a");
				String url = elemento_imagen.absUrl("src");
				String titulo = elemento_titulo.text();
				Cuadro c = new Cuadro(url, titulo);
				lista_cuadros.add(c);
			}
			
			Artista a = new Artista(nombre_autor,lista_cuadros);
			String nombre_fichero = nombre_autor.split(" ")[0]+".html";
			FileWriter f = new FileWriter("C:\\Users\\sseba\\Desktop\\Sebas\\DAM2\\Acceso a Datos\\Cuadros\\"+nombre_fichero,false);
			
			String html = "<html><head></head><body>";
			html += "<h1>" + a.getNombre() + "</h1>";
			html += "<table>";
			
			for(Cuadro c : lista_cuadros) {
				
				html += "<tr><td><img src ='" + c.getRuta_cuadro() + "'></td>";
				html += "<td>" + c.getTitulo() + "</td><tr>";
				
				
			}
			
			html += "</table></body></html>";
			f.write(html);
			f.close();
			System.out.println("TAREA REALIZADA");
			//figure>div.imgwrap>a>img
			//figure>figcaption>d1>dt.trunca-texto>a
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
