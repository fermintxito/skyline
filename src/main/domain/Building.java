package main.domain;

public class Building {
	private int left;
	private int right;
	private int height;

	public Building(int left, int right, int height) {
		super();
		this.left = left;
		this.right = right;
		this.height = height;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Building [ /r/n");
		sb.append("left: " + left + ",/r/n");
		sb.append("right: " + right + ",/r/n");
		sb.append("height: " + height + ",/r/n");
		sb.append("]");

		return sb.toString();

	}
}
