package Beans;


public class Commande {

	private int NEMURO_CMP;
	private String DATE_CMP;
	private int ID_CMP;
	private int ID_VILLE;

	public Commande() {

	}

	public Commande(int nEMURO_CMP, String dATE_CMP, int iD_CMP, int iD_VILLE) {
		super();
		NEMURO_CMP = nEMURO_CMP;
		DATE_CMP = dATE_CMP;
		ID_CMP = iD_CMP;
		ID_VILLE = iD_VILLE;
	}

	public int getNEMURO_CMP() {
		return NEMURO_CMP;
	}

	public void setNEMURO_CMP(int nEMURO_CMP) {
		NEMURO_CMP = nEMURO_CMP;
	}

	public String getDATE_CMP() {
		return DATE_CMP;
	}

	public void setDATE_CMP(String dATE_CMP) {
		DATE_CMP = dATE_CMP;
	}

	public int getID_CMP() {
		return ID_CMP;
	}

	public void setID_CMP(int iD_CMP) {
		ID_CMP = iD_CMP;
	}

	public int getID_VILLE() {
		return ID_VILLE;
	}

	public void setID_VILLE(int iD_VILLE) {
		ID_VILLE = iD_VILLE;
	}

}
