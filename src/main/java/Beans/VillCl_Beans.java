package Beans;

public class VillCl_Beans {

	private int ID_VILLE;
	private String PAYS_VL;
	private String NOM_VL;

	public VillCl_Beans() {

	}

	public VillCl_Beans(int iD_VILLE, String pAYS_VL, String nOM_VL) {
		super();
		ID_VILLE = iD_VILLE;
		PAYS_VL = pAYS_VL;
		NOM_VL = nOM_VL;
	}

	public int getID_VILLE() {
		return ID_VILLE;
	}

	public void setID_VILLE(int iD_VILLE) {
		ID_VILLE = iD_VILLE;
	}

	public String getPAYS_VL() {
		return PAYS_VL;
	}

	public void setPAYS_VL(String pAYS_VL) {
		PAYS_VL = pAYS_VL;
	}

	public String getNOM_VL() {
		return NOM_VL;
	}

	public void setNOM_VL(String nOM_VL) {
		NOM_VL = nOM_VL;
	}

}
