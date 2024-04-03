package DoanQLMA;
import java.util.*;
public class QLMA {
	ArrayList<MonAn> danhSachMonAn = new ArrayList<>();
    ArrayList<MuaHang> danhSachMuaHang = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void themMonAn() {
        System.out.println("Nhập tên món:");
        String tenMon = sc.nextLine();
        System.out.println("Nhập giá tiền:");
        double giaTien = sc.nextDouble();
        danhSachMonAn.add(new MonAn(tenMon, giaTien));
        System.out.println("Đã thêm món: " + tenMon);
        sc.nextLine(); // Đọc ký tự newline
    }

    public void hienThiDSMonAn() {
        if (danhSachMonAn.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            System.out.println("Danh sách các món ăn:");
            int i = 1;
            for (MonAn monAn : danhSachMonAn) {
                System.out.println(i + ". " + monAn.getTenMon() + " - Giá: " + String.format("%.0f", monAn.getGiaTien()) + " VNĐ");
                i++;
            }
        }
    }

    public void timKiemMonAn() {
        if (danhSachMonAn.isEmpty()) {
            System.out.println("Danh sách món ăn rỗng.");
            return;
        }

        System.out.println("Nhập tên món cần tìm:");
        String tenCanTim = sc.nextLine();
        boolean timThay = false;
        for (MonAn monAn : danhSachMonAn) {
            if (monAn.getTenMon().equalsIgnoreCase(tenCanTim)) {
                System.out.println("Đã tìm thấy món: " + monAn.getTenMon() + " - Giá: " + String.format("%,.0f", monAn.getGiaTien()) + " VNĐ");
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy món.");
        }
    }

    public void xoaMonAn() {
        System.out.println("Nhập tên món cần xóa:");
        String tenCanXoa = sc.nextLine();
        boolean xoaThanhCong = false;
        for (int i = 0; i < danhSachMonAn.size(); i++) {
            if (danhSachMonAn.get(i).getTenMon().equalsIgnoreCase(tenCanXoa)) {
                danhSachMonAn.remove(i);
                System.out.println("Đã xóa món: " + tenCanXoa);
                xoaThanhCong = true;
                break;
            }
        }
        if (!xoaThanhCong) {
            System.out.println("Không tìm thấy món.");
        }
    }

    public void suaMonAn() {
        System.out.println("Nhập tên món cần sửa:");
        String tenCanSua = sc.nextLine();
        boolean suaThanhCong = false;
        for (int i = 0; i < danhSachMonAn.size(); i++) {
            MonAn monAn = danhSachMonAn.get(i);
            if (monAn.getTenMon().equalsIgnoreCase(tenCanSua)) {
                System.out.println("Nhập tên mới:");
                String tenMoi = sc.nextLine();
                System.out.println("Nhập giá tiền mới:");
                double giaMoi = sc.nextDouble();
                monAn.setTenMon(tenMoi);
                monAn.setGiaTien(giaMoi);
                System.out.println("Đã sửa thành: " + monAn.getTenMon() + " - Giá: " + String.format("%,.0f", monAn.getGiaTien()) + " VNĐ");
                suaThanhCong = true;
                break;
            }
        }
        if (!suaThanhCong) {
            System.out.println("Không tìm thấy món.");
        }
    }

    public void sapXepMonAn() {
        Collections.sort(danhSachMonAn, Comparator.comparing(MonAn::getTenMon));
        System.out.println("Đã sắp xếp danh sách theo tên món.");
    }

    public void thongKeMonAn() {
        if (danhSachMonAn.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            System.out.println("Tổng số món: " + danhSachMonAn.size());
            double tongTien = 0;
            System.out.println("Danh sách món ăn và giá tiền:");
            for (MonAn monAn : danhSachMonAn) {
                System.out.println("Tên món: " + monAn.getTenMon() + " - Giá tiền: " + monAn.getGiaTien() + " VNĐ");
                tongTien += monAn.getGiaTien();
            }
            System.out.println("Tổng giá trị: " + tongTien + " VNĐ");
        }
    }
    public void themKhachHang() {
        System.out.println("Nhập tên khách hàng:");
        String tenKhachHang = sc.nextLine();
        
        // Hiển thị danh sách món ăn để người dùng chọn
        hienThiDSMonAn();
        
        // Nhập thông tin về món ăn và giá
        System.out.println("Chọn món ăn theo số thứ tự:");
        int chonMonAn = Integer.parseInt(sc.nextLine());
        MonAn monAn = danhSachMonAn.get(chonMonAn - 1); // -1 vì danh sách bắt đầu từ 0
        
        // Tạo đối tượng MuaHang với thông tin đầy đủ và thêm vào danh sách
        danhSachMuaHang.add(new MuaHang(monAn, 1, monAn.getGiaTien(), tenKhachHang)); // Giả sử mỗi khách hàng mua 1 món và không có thông tin số lượng
        
        System.out.println("Đã thêm tên khách hàng đã mua món ăn: " + tenKhachHang + " - Món ăn: " + monAn.getTenMon() + " - Giá: " + monAn.getGiaTien() + " VNĐ");
    }
    public void hienThiDSKhachHangMuaMonAn() {
        if (danhSachMuaHang.isEmpty()) {
            System.out.println("Danh sách mua hàng trống.");
        } else {
            System.out.println("Danh sách khách hàng đã mua:");

            // Tạo một HashMap để lưu trữ thông tin món ăn đã mua bởi mỗi khách hàng
            HashMap<String, String> thongTinMonAnDaMua = new HashMap<>();

            // Duyệt qua danh sách mua hàng để cập nhật thông tin món ăn đã mua
            for (MuaHang muaHang : danhSachMuaHang) {
                String tenKhachHang = muaHang.getTenKhachHang();
                String tenMonAn = muaHang.getMonAn().getTenMon();
                double giaMonAn = muaHang.getMonAn().getGiaTien();

                // Nếu khách hàng đã tồn tại trong HashMap, cập nhật thông tin món ăn đã mua của khách hàng
                // Nếu không, thêm thông tin mới vào HashMap cho khách hàng
                if (thongTinMonAnDaMua.containsKey(tenKhachHang)) {
                    String thongTinCu = thongTinMonAnDaMua.get(tenKhachHang);
                    thongTinMonAnDaMua.put(tenKhachHang, thongTinCu + "\n- Món ăn: " + tenMonAn + " - Giá: " + giaMonAn + " VNĐ");
                } else {
                    thongTinMonAnDaMua.put(tenKhachHang, "- Món ăn: " + tenMonAn + " - Giá: " + giaMonAn + " VNĐ");
                }
            }

            // Hiển thị thông tin món ăn đã mua bởi mỗi khách hàng
            for (String tenKhachHang : thongTinMonAnDaMua.keySet()) {
                String thongTinMonAn = thongTinMonAnDaMua.get(tenKhachHang);
                System.out.println("- Khách hàng: " + tenKhachHang + "\n" + thongTinMonAn);
            }
        }
    }

}
