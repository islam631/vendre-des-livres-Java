package Beans;

public class CompteCL {
	private int ID_CMP;
	private String EMAIL_CMP;
	private String MOTDP_CMP;
	private int ID_CL;

	public CompteCL() {

	}

	public CompteCL(int iD_CMP,  String eMAIL_CMP, String mOTDP_CMP, int iD_CL) {
		super();
		ID_CMP = iD_CMP;
		EMAIL_CMP = eMAIL_CMP;
		MOTDP_CMP = mOTDP_CMP;
		ID_CL = iD_CL;
	}

	public int getID_CMP() {
		return ID_CMP;
	}

	public void setID_CMP(int iD_CMP) {
		ID_CMP = iD_CMP;
	}


	public String getEMAIL_CMP() {
		return EMAIL_CMP;
	}

	public void setEMAIL_CMP(String eMAIL_CMP) {
		EMAIL_CMP = eMAIL_CMP;
	}

	public String getMOTDP_CMP() {
		return MOTDP_CMP;
	}

	public void setMOTDP_CMP(String mOTDP_CMP) {
		MOTDP_CMP = mOTDP_CMP;
	}

	public int getID_CL() {
		return ID_CL;
	}

	public void setID_CL(int iD_CL) {
		ID_CL = iD_CL;
	}

}
