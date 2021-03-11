import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Municipio {

	@Element
	private String nm;

	@Element
	private String locat;

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getLocat() {
		return locat;
	}

	public void setLocat(String locat) {
		this.locat = locat;
	}

	@Override
	public String toString() {
		return "Municipio [nm=" + nm + ", locat=" + locat + "]";
	}

}
