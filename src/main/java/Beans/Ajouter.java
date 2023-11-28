package Beans;

public class Ajouter {
	private int ID_ADMIN;
	private int ISBN_LV;
	private int NBREMPR_LV;

	public Ajouter() {
		super();
	}

	public Ajouter(int iD_ADMIN, int iSBN_LV, int nBREMPR_LV) {
		super();
		ID_ADMIN = iD_ADMIN;
		ISBN_LV = iSBN_LV;
		NBREMPR_LV = nBREMPR_LV;
	}

	public int getID_ADMIN() {
		return ID_ADMIN;
	}

	public void setID_ADMIN(int iD_ADMIN) {
		ID_ADMIN = iD_ADMIN;
	}

	public int getISBN_LV() {
		return ISBN_LV;
	}

	public void setISBN_LV(int iSBN_LV) {
		ISBN_LV = iSBN_LV;
	}

	public int getNBREMPR_LV() {
		return NBREMPR_LV;
	}

	public void setNBREMPR_LV(int nBREMPR_LV) {
		NBREMPR_LV = nBREMPR_LV;
	}

}
