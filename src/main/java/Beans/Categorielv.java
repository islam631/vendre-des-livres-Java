package Beans;

public class Categorielv {
	private int ID_CT;
	private String NOM_CT;
	private String DESC_CT;

	public Categorielv() {

	}

	public Categorielv(int iD_CT, String nOM_CT, String dESC_CT) {
		super();
		ID_CT = iD_CT;
		NOM_CT = nOM_CT;
		DESC_CT = dESC_CT;
	}

	public int getID_CT() {
		return ID_CT;
	}

	public void setID_CT(int iD_CT) {
		ID_CT = iD_CT;
	}

	public String getNOM_CT() {
		return NOM_CT;
	}

	public void setNOM_CT(String nOM_CT) {
		NOM_CT = nOM_CT;
	}

	public String getDESC_CT() {
		return DESC_CT;
	}

	public void setDESC_CT(String dESC_CT) {
		DESC_CT = dESC_CT;
	}

}
