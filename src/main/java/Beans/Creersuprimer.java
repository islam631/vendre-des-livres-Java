package Beans;

public class Creersuprimer {

	private int ID_CMP;
	private int ID_ADMIN;

	public Creersuprimer() {

	}

	public Creersuprimer(int iD_CMP, int iD_ADMIN) {
		super();
		ID_CMP = iD_CMP;
		ID_ADMIN = iD_ADMIN;
	}

	public int getID_CMP() {
		return ID_CMP;
	}

	public void setID_CMP(int iD_CMP) {
		ID_CMP = iD_CMP;
	}

	public int getID_ADMIN() {
		return ID_ADMIN;
	}

	public void setID_ADMIN(int iD_ADMIN) {
		ID_ADMIN = iD_ADMIN;
	}

}
