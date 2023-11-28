package Beans;

public class Client_Beans {

	private int ID_CL;
	private String NOM_CL;
	private String PRENOM_CL;
	private String DATEN_CL;
	private int TEL_CL;
	private int ID_VILLE;

	public Client_Beans() {

	}
	public static String getDate(String date){
		return "TO_DATE('"+date+"','YYYY-MM-DD')";
	}
	
	public Client_Beans(int iD_CL, String nOM_CL, String pRENOM_CL, String dATEN_CL, int tEL_CL,
			int iD_VILLE) {
		super();
		ID_CL = iD_CL;
		NOM_CL = nOM_CL;
		PRENOM_CL = pRENOM_CL;
		DATEN_CL = dATEN_CL;
		TEL_CL = tEL_CL;
		ID_VILLE = iD_VILLE;
	}

	public int getID_CL() {
		return ID_CL;
	}

	public void setID_CL(int iD_CL) {
		ID_CL = iD_CL;
	}

	public String getNOM_CL() {
		return NOM_CL;
	}

	public void setNOM_CL(String nOM_CL) {
		NOM_CL = nOM_CL;
	}

	public String getPRENOM_CL() {
		return PRENOM_CL;
	}

	public void setPRENOM_CL(String pRENOM_CL) {
		PRENOM_CL = pRENOM_CL;
	}

	public String getDATEN_CL() {
		return DATEN_CL;
	}

	public void setDATEN_CL(String dATEN_CL) {
		DATEN_CL = dATEN_CL;
	}

	public int getTEL_CL() {
		return TEL_CL;
	}

	public void setTEL_CL(int tEL_CL) {
		TEL_CL = tEL_CL;
	}

	

	public int getID_VILLE() {
		return ID_VILLE;
	}

	public void setID_VILLE(int iD_VILLE) {
		ID_VILLE = iD_VILLE;
	}

}
