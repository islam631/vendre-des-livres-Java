package Beans;

public class Admin {

	private int ID_ADMIN;
	private String NOM_ADMIN;
	private String PRENOM_ADMIN;
	private String EMAIL_ADMIN;
	private String MOTDP_ADMIN;

	public Admin() {

	}

	public Admin(int iD_ADMIN, String nOM_ADMIN, String pRENOM_ADMIN, String eMAIL_ADMIN, String mOTDP_ADMIN) {
		super();
		ID_ADMIN = iD_ADMIN;
		NOM_ADMIN = nOM_ADMIN;
		PRENOM_ADMIN = pRENOM_ADMIN;
		EMAIL_ADMIN = eMAIL_ADMIN;
		MOTDP_ADMIN = mOTDP_ADMIN;
	}

	public int getID_ADMIN() {
		return ID_ADMIN;
	}

	public void setID_ADMIN(int iD_ADMIN) {
		ID_ADMIN = iD_ADMIN;
	}

	public String getNOM_ADMIN() {
		return NOM_ADMIN;
	}

	public void setNOM_ADMIN(String nOM_ADMIN) {
		NOM_ADMIN = nOM_ADMIN;
	}

	public String getPRENOM_ADMIN() {
		return PRENOM_ADMIN;
	}

	public void setPRENOM_ADMIN(String pRENOM_ADMIN) {
		PRENOM_ADMIN = pRENOM_ADMIN;
	}

	public String getEMAIL_ADMIN() {
		return EMAIL_ADMIN;
	}

	public void setEMAIL_ADMIN(String eMAIL_ADMIN) {
		EMAIL_ADMIN = eMAIL_ADMIN;
	}

	public String getMOTDP_ADMIN() {
		return MOTDP_ADMIN;
	}

	public void setMOTDP_ADMIN(String mOTDP_ADMIN) {
		MOTDP_ADMIN = mOTDP_ADMIN;
	}

}
