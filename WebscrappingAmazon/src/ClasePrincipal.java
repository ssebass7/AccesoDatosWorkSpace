


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ClasePrincipal {

	public static void main(String[] args) {
		
		Document document;
		try {
			document = Jsoup.connect("https://www.amazon.es/moviles-smartphones-libres/b?ie=UTF8&node=934197031").get();
			Elements elementos_padre = document.select(".a-section.a-spacing-none.octopus-pc-item-block.octopus-pc-asin-block");
		
			for (Element elemento_hijo : elementos_padre) {
				
					Element elm_foto = elemento_hijo.selectFirst(".octopus-pc-item-image.octopus-pc-item-image-v3");
					Element elm_precio_entero = elemento_hijo.selectFirst(".a-price-whole");
					Element elm_precio_decimal = elemento_hijo.selectFirst(".a-price-fraction");
					Element elm_descripcion = elemento_hijo.selectFirst(".a-size-base.a-color-base");
					String ruta_imagen = elm_foto.absUrl("src");
					String desc = elm_descripcion.text();
					String precio = elm_precio_entero.text() + elm_precio_decimal.text();
					System.out.println(ruta_imagen + " " + precio + " " + desc);
					
			 /* System.out.println(elemento_hijo.html());
			  						//innerText .text()
			  						//innerHTML .html()*/
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
