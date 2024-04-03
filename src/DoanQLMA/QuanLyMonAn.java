package DoanQLMA;
import java.util.Scanner;
public class QuanLyMonAn {
	public static void main(String[] args) {
        QLMA qlma = new QLMA();
        Scanner sc = new Scanner(System.in);

        while (true) {
        	System.out.println("*================ MENU ===============*");
            System.out.println("*=========== Quản Lý Món Ăn===========*");
            System.out.println("*| 1. Thêm món ăn                    |*");
            System.out.println("*| 2. Hiển thị danh sách món ăn      |*");
            System.out.println("*| 3. Tìm kiếm món ăn                |*");
            System.out.println("*| 4. Xóa món ăn                     |*");
            System.out.println("*| 5. Sửa món ăn                     |*");
            System.out.println("*| 6. Sắp xếp danh sách món ăn       |*");
            System.out.println("*| 7. Thống kê món ăn                |*");
            System.out.println("*| 8. Thêm khách hàng                |*");
            System.out.println("*| 9. Hiển Thị danh sách khách hàng  |*");
            System.out.println("*| 0. Thoát Chương Trình             |*");
            System.out.println("*====== Mời Bạn Chọn Chức Năng =======*");

            int luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                	qlma.themMonAn();
                    break;
                case 2:
                	qlma.hienThiDSMonAn();
                    break;
                case 3:
                	qlma.timKiemMonAn();
                    break;
                case 4:
                	qlma.xoaMonAn();
                    break;
                case 5:
                	qlma.suaMonAn();
                    break;
                case 6:
                	qlma.sapXepMonAn();
                    break;
                case 7:
                	qlma.thongKeMonAn();
                    break;
                case 8:
                	qlma.themKhachHang();
                    break;
                case 9:
                	qlma.hienThiDSKhachHangMuaMonAn();
                    break;
               
                case 0:
                    System.out.println("Bạn đã thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

}
