package DoanQLMA;

public class MonAn {
String tenMon;
	
	public MonAn(String tenMon, double giaTien) {
		super();
		this.tenMon = tenMon;
		this.giaTien = giaTien;
	}
	double giaTien;
	public String getTenMon() {	
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public double getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}
	public MonAn() {
		super();
	}
	 public String toString() {
	        return "Tên món: " + tenMon + ", Giá tiền: " + giaTien;
	    }

}
