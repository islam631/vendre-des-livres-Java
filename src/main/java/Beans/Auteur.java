package Beans;

public class Auteur {
	private int ID_AUT;
	private String NOM_AUT;
	private String PRENOM_AUT;
	private String DATEN_AUT;
	private String NATIONALITE_AUT;

	public Auteur() {
		super();
	}

	public Auteur(int iD_AUT, String nOM_AUT, String pRENOM_AUT, String dATEN_AUT, String nATIONALITE_AUT) {
		super();
		ID_AUT = iD_AUT;
		NOM_AUT = nOM_AUT;
		PRENOM_AUT = pRENOM_AUT;
		DATEN_AUT = dATEN_AUT;
		NATIONALITE_AUT = nATIONALITE_AUT;
	}

	public int getID_AUT() {
		return ID_AUT;
	}

	public void setID_AUT(int iD_AUT) {
		ID_AUT = iD_AUT;
	}

	public String getNOM_AUT() {
		return NOM_AUT;
	}

	public void setNOM_AUT(String nOM_AUT) {
		NOM_AUT = nOM_AUT;
	}

	public String getPRENOM_AUT() {
		return PRENOM_AUT;
	}

	public void setPRENOM_AUT(String pRENOM_AUT) {
		PRENOM_AUT = pRENOM_AUT;
	}

	public String getDATEN_AUT() {
		return DATEN_AUT;
	}

	public void setDATEN_AUT(String dATEN_AUT) {
		DATEN_AUT = dATEN_AUT;
	}

	public String getNATIONALITE_AUT() {
		return NATIONALITE_AUT;
	}

	public void setNATIONALITE_AUT(String nATIONALITE_AUT) {
		NATIONALITE_AUT = nATIONALITE_AUT;
	}

}
