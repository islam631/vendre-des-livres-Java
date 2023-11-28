package Beans;

public class Contient {
	private int NEMURO_CMP;
	private int ISBN_LV;
	private int QUATITE_CNT;

	public Contient() {
		super();
	}

	public Contient(int nEMURO_CMP, int iSBN_LV, int qUATITE_CNT) {
		super();
		NEMURO_CMP = nEMURO_CMP;
		ISBN_LV = iSBN_LV;
		QUATITE_CNT = qUATITE_CNT;
	}

	public int getNEMURO_CMP() {
		return NEMURO_CMP;
	}

	public void setNEMURO_CMP(int nEMURO_CMP) {
		NEMURO_CMP = nEMURO_CMP;
	}

	public int getISBN_LV() {
		return ISBN_LV;
	}

	public void setISBN_LV(int iSBN_LV) {
		ISBN_LV = iSBN_LV;
	}

	public int getQUATITE_CNT() {
		return QUATITE_CNT;
	}

	public void setQUATITE_CNT(int qUATITE_CNT) {
		QUATITE_CNT = qUATITE_CNT;
	}

}
