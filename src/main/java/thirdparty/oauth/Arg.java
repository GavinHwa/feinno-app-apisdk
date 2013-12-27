package thirdparty.oauth;

public class Arg implements Comparable<Arg> {

	public String name;
	public String value;

	public Arg(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public int compareTo(Arg o) {
		int compared;
		Arg that = (Arg) o;
		compared = name.compareTo(that.name);
		if (0 == compared) {
			compared = value.compareTo(that.value);
		}
		return compared;
	}
}
