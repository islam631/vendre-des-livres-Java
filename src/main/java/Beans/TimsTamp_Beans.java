package Beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


public class TimsTamp_Beans {
//23-DEC-22 02.03.29.000000 PM

	private static int annee;
	private static int month;
	private static int day;
	private static int hour;
	private static int min;
	private static int seq;

	public TimsTamp_Beans() {
	}

	public TimsTamp_Beans(int annee, int month, int day, int hour, int min, int seq) {
		this.annee = annee;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.min = min;
		this.seq = seq;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public static String month_String(int month) {
		String string_month = null;
		if (month == 1) {
			string_month = "JAN";
		} else if (month == 2) {
			string_month = "FEB";
		} else if (month == 3) {
			string_month = "MAR";
		} else if (month == 4) {
			string_month = "APR";
		} else if (month == 5) {
			string_month = "MAY";
		} else if (month == 6) {
			string_month = "JUN";
		} else if (month == 7) {
			string_month = "JUL";
		} else if (month == 8) {
			string_month = "AUG";
		} else if (month == 9) {
			string_month = "SEP";
		} else if (month == 10) {
			string_month = "OCT";
		} else if (month == 11) {
			string_month = "NOV";
		} else if (month == 12) {
			string_month = "DEC";
		}
		return string_month;
	}

	// TO_TIMESTAMP('24-11-2022 05:52:25 PM','DD-MM-YYYY HH:MI:SS PM')

	public static String Timstamp_sintax_sql(String statut_temporel) {

		return "TO_TIMESTAMP('" + day + "-" + month + "-" + annee + " " + hour + ":" + min + ":" + seq + " "
				+ statut_temporel + "','DD-MM-YYYY HH:MI:SS " + statut_temporel + "')";
		// DD-MM-YYYY HH:MI:SS PM

	}
	public static void main(String[] args) {
		
		System.out.println(new TimsTamp_Beans(2003,5,16,10,10,10).Timstamp_sintax_sql("PM"));
		//int annee, int month, int day, int hour, int min, int seq
	}
	/*
	 * public static void main(String[] args) { //System.out.println(new
	 * TimsTamp_Beans(2022, 11, 24, 5, 52, 25).Timstamp_sintax_sql("PM")); int[] a=
	 * {4,5}; System.out.println(a[1]); }
	 */

}
