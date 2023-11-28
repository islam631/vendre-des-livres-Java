package Beans;

public class Livre {

	private int ISBN_LV;
	private String TITRE_LV;
	private double PRIX_LV;
	private String DESC_LV;
	private int NMRPAGE_LV;
	private String DATEPR_LV;
	private int ID_CT;
	private String IMAGE;

	public Livre() {
		super();
	}

	




	public Livre(int iSBN_LV, String tITRE_LV, double pRIX_LV, String dESC_LV, int nMRPAGE_LV, String dATEPR_LV,
			int iD_CT, String iMAGE) {
		super();
		ISBN_LV = iSBN_LV;
		TITRE_LV = tITRE_LV;
		PRIX_LV = pRIX_LV;
		DESC_LV = dESC_LV;
		NMRPAGE_LV = nMRPAGE_LV;
		DATEPR_LV = dATEPR_LV;
		ID_CT = iD_CT;
		IMAGE = iMAGE;
	}



	public int getISBN_LV() {
		return ISBN_LV;
	}

	public void setISBN_LV(int iSBN_LV) {
		ISBN_LV = iSBN_LV;
	}

	public String getTITRE_LV() {
		return TITRE_LV;
	}

	public void setTITRE_LV(String tITRE_LV) {
		TITRE_LV = tITRE_LV;
	}

	public double getPRIX_LV() {
		return PRIX_LV;
	}

	public void setPRIX_LV(double pRIX_LV) {
		PRIX_LV = pRIX_LV;
	}

	public String getDESC_LV() {
		return DESC_LV;
	}

	public void setDESC_LV(String dESC_LV) {
		DESC_LV = dESC_LV;
	}

	public int getNMRPAGE_LV() {
		return NMRPAGE_LV;
	}

	public void setNMRPAGE_LV(int nMRPAGE_LV) {
		NMRPAGE_LV = nMRPAGE_LV;
	}

	public String getDATEPR_LV() {
		return DATEPR_LV;
	}

	public void setDATEPR_LV(String dATEPR_LV) {
		DATEPR_LV = dATEPR_LV;
	}

	public int getID_CT() {
		return ID_CT;
	}

	public void setID_CT(int iD_CT) {
		ID_CT = iD_CT;
	}

	public String getIMAGE() {
		return IMAGE;
	}


	public void setIMAGE(String iMAGE) {
		IMAGE = iMAGE;
	}

}
