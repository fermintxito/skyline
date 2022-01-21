package main.domain;

public class Skyline {

	public int abscisa;
	public int height;

	public Skyline(int abscisa, int altura) {
		super();
		this.abscisa = abscisa;
		this.height = altura;
	}

	public int getAbscisa() {
		return abscisa;
	}

	public void setAbscisa(int abscisa) {
		this.abscisa = abscisa;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(" Skyline [ ");
		sb.append("abscisa: " + abscisa + ",");
		sb.append("height: " + height + ",");
		sb.append("] ");

		return sb.toString();

	}

}
