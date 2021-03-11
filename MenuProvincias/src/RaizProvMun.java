import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="consulta_municipiero", strict = false)
public class RaizProvMun {
@ElementList
private List<Municipio> municipiero;

public List<Municipio> getMunicipiero() {
	return municipiero;
}

public void setMunicipiero(List<Municipio> municipiero) {
	this.municipiero = municipiero;
}


}
