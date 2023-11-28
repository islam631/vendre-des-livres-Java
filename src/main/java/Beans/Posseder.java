package Beans;

public class Posseder {
	private int ISBN_LV;
	private int ID_AUT;

	public Posseder() {
		super();
	}

	public Posseder(int iSBN_LV, int iD_AUT) {
		super();
		ISBN_LV = iSBN_LV;
		ID_AUT = iD_AUT;
	}

	public int getISBN_LV() {
		return ISBN_LV;
	}

	public void setISBN_LV(int iSBN_LV) {
		ISBN_LV = iSBN_LV;
	}

	public int getID_AUT() {
		return ID_AUT;
	}

	public void setID_AUT(int iD_AUT) {
		ID_AUT = iD_AUT;
	}

}
