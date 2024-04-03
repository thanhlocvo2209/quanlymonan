package DoanQLMA;

public class MuaHang {
	public MuaHang() {
		super();
	}
	MonAn  monAn;
	int soLuong;
    double tongTien;
	String tenKhachHang;
	
	
	public MuaHang(MonAn monAn, int soLuong, double tongTien, String tenKhachHang) {
		super();
		this.monAn = monAn;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
		this.tenKhachHang = tenKhachHang;
	}
	
	public MuaHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }
	
	public MonAn getMonAn() {
		return monAn;
	}
	public void setMonAn(MonAn monAn) {
		this.monAn = monAn;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

}
