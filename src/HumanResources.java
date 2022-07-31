import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HumanResources {
    public static void main(String[] args) {
        //Tạo ArrayList để quản lý nhân viên
        ArrayList<Staff> quanLyNhanVien = new ArrayList<Staff>();

        //Thêm nhân viên vào ArrayList vừa tạo
        quanLyNhanVien.add(new Employee("NV1", "Bui Van An", 35, 1.9,
                "22/12/2021", new KinhDoanh(), 9, 22));
        quanLyNhanVien.add(new Employee("NV2", "Ngo Tuan Vu", 26, 2.9,
                "14/01/2015", new HanhChinh(), 4, 47));
        quanLyNhanVien.add(new Employee("NV3", "Vo Ngoc Phuong Linh", 23, 3.6,
                "26/03/2016", new KyThuat(), 2, 16));
        quanLyNhanVien.add(new Manager("NV4", "Nguyen Truong Giang", 27, 6.2,
                "13/11/2008", new KinhDoanh(), 12, "Business Leader"));
        quanLyNhanVien.add(new Manager("NV5", "Tran Thuy Duong", 33, 4.3,
                "10/05/2011", new HanhChinh(), 7, "Project Leader"));
        quanLyNhanVien.add(new Manager("NV6", "Ngo Cam Uyen", 24, 3,
                "08/12/2017", new KyThuat(), 1, "Technical Leader"));

        //Hiển thị mô tả và cách chọn chức năng
        System.out.printf("\n*** CHÀO MỪNG ĐẾN VỚI CHƯƠNG TRÌNH HUMAN RESOURCES ***\nĐể chọn chức năng, vui lòng nhấn phím theo số thứ tự tương ứng.\n");

        //Vòng lặp do...while để người dùng chọn lại chức năng
        String tiepTuc;
        do {
            chonChucNang(quanLyNhanVien);
            System.out.printf("\n* Tiếp tục sử dụng chương trình?\n1.Yes (Nhấn phím 1 hoặc Y)\n2.No  (Nhấn phím bất kỳ còn lại)\nLựa chọn: ");
            Scanner input = new Scanner(System.in);
            tiepTuc = input.nextLine();
        } while(tiepTuc.toLowerCase().contains("1") || tiepTuc.toLowerCase().contains("y"));
        System.out.printf("\n*** CẢM ƠN BẠN ĐÃ SỬ DỤNG CHƯƠNG TRÌNH! ***");
    }

    //Hàm chọn chức năng
    static void chonChucNang(ArrayList<Staff> arl) {
        System.out.printf(
                "\n* Các chức năng của chương trình:\n" +
                "\n1. Hiển thị danh sách nhân viên hiện có trong công ty" +
                "\n2. Hiển thị các bộ phận trong công ty" +
                "\n3. Hiển thị các nhân viên theo từng bộ phận" +
                "\n4. Thêm nhân viên mới vào công ty" +
                "\n5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên" +
                "\n6. Hiển thị bảng lương của nhân viên toàn công ty" +
                "\n7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần hoặc giảm dần\n"+
                "\nChọn chức năng: ");

        Scanner input = new Scanner(System.in);
        String yourChoice = input.nextLine();

        if(yourChoice.equals("1")) {
            danhSachNhanVien(arl);
        } else if(yourChoice.equals("2")) {
            danhSachBoPhanTrongCongTy();
        } else if(yourChoice.equals("3")) {
            nhanVienTheoTungBoPhan(arl);
        } else if(yourChoice.equals("4")) {
            themNhanVien(arl);
        } else if(yourChoice.equals("5")) {
            timKiemNhanVien(arl);
        } else if(yourChoice.equals("6")) {
            bangLuong(arl);
        } else if(yourChoice.equals("7")) {
            bangLuongTangDan(arl);
        } else {
            System.out.printf("\nRẤT TIẾC! CHỨC NĂNG KHÔNG TỒN TẠI!\n");
        }
    }

    //Hàm để in Header
    static void printHeader() {
        System.out.printf("\n%-5s%-8s%-23s%-8s%-16s%-15s%-20s%-15s%-20s%-15s\n\n","STT","Mã NV","Họ tên","Tuổi","Ngày vào làm","Bộ phận","Chức danh","Hệ số lương", "Số ngày nghỉ phép", "Số giờ làm thêm");
    }
    static void printHeader2() {
        System.out.printf("\n%-5s%-8s%-23s%-8s%-16s%-15s%-20s%-15s%-20s%-15s\n","STT","Mã NV","Họ tên","Tuổi","Ngày vào làm","Bộ phận","Chức danh","Hệ số lương", "Số ngày nghỉ phép", "Số giờ làm thêm");
    }

    //Chức năng 1: hiển thị danh sách nhân viên hiện có trong công ty
    static void danhSachNhanVien(ArrayList<Staff> arl) {
        System.out.printf("\n* Danh sách nhân viên hiện có trong công ty:\n");
        printHeader();

        int soThuTu = 0;
        //Dùng Vòng lặp for và hàm displayInfomation để hiển thị thông tin nhân viên trong ArrayList arl
        for(Staff staff:arl){
            soThuTu++;
            System.out.printf("%-5s",soThuTu);
            staff.displayInformation();
        }
    }

    //Chức năng 2: hiển thị các bộ phận trong công ty
    static void danhSachBoPhanTrongCongTy() {
        //Tạo ArrayList chứa các bộ phận
        ArrayList<Department> listDepartment = new ArrayList<Department>();
        listDepartment.add(new KinhDoanh());
        listDepartment.add(new HanhChinh());
        listDepartment.add(new KyThuat());

        int soThuTu = 0;
        System.out.printf("\n* Các bộ phận hiện có trong công ty:\n");
        System.out.printf("\n%-5s%-8s%-15s%-8s\n\n","STT","Mã BP","Tên BP","Số nhân viên hiện tại");
        //Vòng lặp for và hàm toString() để hiển thị thông tin các bộ phận
        for(Department d:listDepartment) {
            soThuTu++;
            System.out.printf("%-5s",soThuTu);
            (d).toString();
            d.resetSoNhanVien();
        }
    }

    //Chức năng 3: hiển thị nhân viên theo từng bộ phận
    static void nhanVienTheoTungBoPhan(ArrayList<Staff> arl) {
        System.out.printf("\n* Chọn bộ phận muốn hiển thị nhân viên (Nhấn phím 1, 2, 3 hoặc 4):\n\n1. Kinh Doanh\n2. Hành Chính\n3. Kỹ Thuật\n4. Tất cả bộ phận\n\nLựa chọn: ");
        int soThuTu = 0;
        Scanner input = new Scanner(System.in);
        int chonBoPhan = Integer.parseInt(input.nextLine());
        while (chonBoPhan < 1 || chonBoPhan > 4) {
            System.out.printf("Bộ phận không tồn tại. Vui lòng chọn lại: ");
            chonBoPhan = Integer.parseInt(input.nextLine());
        }

        //Gọi hàm hiển thị thông tin nhân viên trong bộ phận tương ứng với lựa chọn
        if(chonBoPhan == 1) {
            System.out.printf("\n* Nhân viên bộ phận Kinh Doanh:\n");
            printHeader();
            boPhanKD(arl, soThuTu);
        } else if(chonBoPhan == 2) {
            System.out.printf("\n* Nhân viên bộ phận Hành Chính:\n");
            printHeader();
            boPhanHC(arl, soThuTu);
        } else if (chonBoPhan == 3){
            System.out.printf("\n* Nhân viên bộ phận Kỹ Thuật:\n");
            printHeader();
            boPhanKT(arl, soThuTu);
        } else {
            System.out.printf("\n* Bộ phận Kinh Doanh:");
            printHeader2();
            boPhanKD(arl, soThuTu);

            System.out.printf("\n* Bộ phận Hành Chính:");
            printHeader2();
            boPhanHC(arl, soThuTu);

            System.out.printf("\n* Bộ phận Kỹ Thuật:");
            printHeader2();
            boPhanKT(arl, soThuTu);
        }

    }

    //Lặp qua ArrayList và hiển thị thông tin nhân viên có mã bộ phận tương ứng với lựa chọn
    static void boPhanKD(ArrayList<Staff> arl, int soThuTu) {
        for (Staff staff:arl) {
            if(staff.getBoPhanLamViec().getMaBoPhan().equals("KD")) {
                soThuTu++;
                System.out.printf("%-5s",soThuTu);
                staff.displayInformation();
            }
        }
    }

    static void boPhanHC(ArrayList<Staff> arl, int soThuTu) {
        for (Staff staff:arl) {
            if(staff.getBoPhanLamViec().getMaBoPhan().equals("HC")) {
                soThuTu++;
                System.out.printf("%-5s",soThuTu);
                staff.displayInformation();
            }
        }
    }

    static void boPhanKT(ArrayList<Staff> arl, int soThuTu) {
        for (Staff staff:arl) {
            if(staff.getBoPhanLamViec().getMaBoPhan().equals("KT")) {
                soThuTu++;
                System.out.printf("%-5s",soThuTu);
                staff.displayInformation();
            }
        }
    }

    //Chức năng 4: Thêm nhân viên
    static void themNhanVien(ArrayList<Staff> arl) {
        Scanner input = new Scanner(System.in);
        System.out.printf("\n* Nhập thông tin nhân viên cần thêm\n\n");

        //Tạo mã nhân viên
        String maNhanVien = "NV" + (arl.size() + 1);

        //Nhập họ tên
        System.out.printf("%-50s","Họ và tên: ");
        String tenNhanVien = input.nextLine();

        //Nhập tuổi phù hợp
        System.out.printf("%-50s","Tuổi: ");
        int tuoiNhanVien = Integer.parseInt(input.nextLine());
        while (tuoiNhanVien < 16 || tuoiNhanVien > 100) {
            System.out.printf("\nTuổi không hợp lệ. Nhập lại tuổi: ");
            tuoiNhanVien = Integer.parseInt(input.nextLine());
        }

        //Nhập hệ số lương
        System.out.printf("%-50s","Hệ số lương: ");
        double heSoLuong = Double.parseDouble(input.nextLine());

        //Nhập ngày vào làm
        System.out.printf("%-50s","Ngày vào làm(dd/mm/yyyy): ");
        String ngayVaoLam = input.nextLine();

        //Nhập số ngày nghỉ phép
        System.out.printf("%-50s","Số ngày nghỉ phép: ");
        int soNgayNghiPhep = Integer.parseInt(input.nextLine());

        //Chọn bộ phận làm việc
        Department boPhanLamViec = null;
        System.out.printf("\nBộ phận làm việc (Nhập 1, 2 hoặc 3) \n");
        System.out.printf("1. Kinh Doanh\n2. Hành Chính\n3. Kỹ Thuật\n%-50s", "Lựa chọn:");
        int chonBoPhan = Integer.parseInt(input.nextLine());
        while (chonBoPhan < 1 || chonBoPhan > 3) {
            System.out.printf("Bộ phận không tồn tại. Chọn lại bộ phận: ");
            chonBoPhan = Integer.parseInt(input.nextLine());
        }
        if(chonBoPhan == 1) {
            boPhanLamViec = new KinhDoanh();
        } else if(chonBoPhan == 2) {
            boPhanLamViec = new HanhChinh();
        } else if(chonBoPhan == 3) {
            boPhanLamViec = new KyThuat();
        }

        //Chọn nhân viên được thêm là quản lý hay nhân viên thường
        System.out.printf("\nQuản lý hay nhân viên thường? (Nhập 1 hoặc 2)\n1. Quản lý\n2. Nhân viên thường\n%-50s","Lựa chọn:");
        String chucDanh;
        int chonChucDanh = Integer.parseInt(input.nextLine());
        while (chonChucDanh < 1 || chonChucDanh > 2) {
            System.out.printf("Lựa chọn không đúng. Vui lòng chọn lại: ");
            chonChucDanh = Integer.parseInt(input.nextLine());
        }

        //Nếu là quản lý thì chọn chức danh
        if(chonChucDanh == 1) {
            System.out.printf("\nChọn chức danh (Nhập 1, 2 hoặc 3):\n1. Business Leader\n2. Project Leader\n3. Technical Leader\n%-50s","Lựa chọn:");
            chonChucDanh = Integer.parseInt(input.nextLine());
            while (chonChucDanh < 1 || chonChucDanh > 3) {
                System.out.printf("Chức danh không tồn tại. Chọn lại chức danh: ");
                chonChucDanh = Integer.parseInt(input.nextLine());
            }
            if(chonChucDanh == 1){
                chucDanh = "Business Leader";
            } else if(chonChucDanh == 2) {
                chucDanh = "Project Leader";
            } else {
                chucDanh = "Technical Leader";
            }
            //Thêm quản lý vào ArrayList
            arl.add(new Manager(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep, chucDanh));

        //Nếu là nhân viên thường thì nhập số giờ làm thêm
        } else {
            chucDanh = "Nhân Viên";
            System.out.printf("\n%-50s","Số giờ làm thêm: ");
            int soGioLamThem = Integer.parseInt(input.nextLine());
            //Thêm nhân viên thường vào ArrayList
            arl.add(new Employee(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep, soGioLamThem));
        }

        //Hiển thị thông tin nhân viên vừa thêm
        System.out.printf("\n* Thông tin nhân viên vừa thêm:\n");
        printHeader2();
        System.out.printf("%-5s","1");
        arl.get(arl.size()-1).displayInformation();
    }

    //Chức năng 5: tìm kiếm nhân viên
    static void timKiemNhanVien(ArrayList<Staff> arl){
        //Nhập tên hoặc mã nhân viên cần tìm
        System.out.printf("\n* Nhập tên hoặc mã nhân viên cần tìm: ");
        Scanner input = new Scanner(System.in);
        String giaTriCanTim = input.nextLine();
        int ketQuaTimKiem = 0;
        printHeader();
        //Dùng vòng lặp for và hàm contains() để lặp qua ArrayList, hiển thị thông tin nhân viên nếu trong mã nhân viên hoặc tên có chứa từ khóa đã nhập vào
        for(Staff e:arl) {
                if(e.getTenNhanVien().toLowerCase().contains(giaTriCanTim.toLowerCase()) ||
                        e.getMaNhanVien().toLowerCase().contains(giaTriCanTim.toLowerCase())) {
                    ketQuaTimKiem++;
                    System.out.printf("%-5s",ketQuaTimKiem);
                    e.displayInformation();
                }
            }
            System.out.printf("\nTìm thấy " + ketQuaTimKiem + " kết quả.\n");
    }

    //Chức năng 6: hiển thị bảng lương
    static void bangLuong(ArrayList<Staff> arl) {
        System.out.printf("\n* Bảng lương nhân viên:\n");
        System.out.printf("\n%-5s%-8s%-23s%-23s\n\n", "STT", "Mã NV", "Họ Tên", "Lương");
        int soThuTu = 0;
        //Dùng vòng lặp for lặp qua ArrayList và in ra lương của từng nhân viên
        for(Staff e:arl) {
            soThuTu++;
            String s = String.format("%,d", e.getLuongNhanVien());
            System.out.printf("%-5s%-8s%-23s%-23s\n", soThuTu, e.getMaNhanVien(),e .getTenNhanVien(), s);
        }
    }

    //Chức năng 7: hiển thị bảng lương tăng dần - giảm dần
    static void bangLuongTangDan(ArrayList<Staff> arl) {
        int soThuTu = 0;
        Scanner input = new Scanner(System.in);
        System.out.printf("\n* Xem bảng lương:\n 1. Tăng dần (nhấn phím 1)\n 2. Giảm dần(nhấn phím 2)\nLựa chọn: ");
        String sortType = input.nextLine();

        if(sortType.equals("1")) {
            //Dùng hàm sortBangLUongTangDan() để sắp xếp nhân viên trong ArrayList theo thứ tự tăng dần
            //Dùng vòng lặp for để lặp qua ArrayList đã được sắp xếp lại và in ra thông tin
            System.out.printf("\n* Bảng lương tăng dần:\n");
            System.out.printf("\n%-5s%-8s%-23s%-23s\n\n", "STT", "Mã NV", "Tên", "Lương");
            Collections.sort(arl, Staff.sortBangLuongTangDan);
            for(Staff e:arl) {
                soThuTu++;
                String s = String.format("%,d", e.getLuongNhanVien());
                System.out.printf("%-5s%-8s%-23s%-23s\n", soThuTu, e.getMaNhanVien(),e.getTenNhanVien(),s);
            }
        } else if(sortType.equals("2")) {
            //Dùng hàm sortBangLUongGiamDan() để sắp xếp nhân viên theo thứ tự tăng dần
            //Dùng vòng lặp for để lặp qua ArrayList đã được sắp xếp lại và in ra thông tin
            System.out.printf("\n* Bảng lương giảm dần:\n");
            System.out.printf("\n%-5s%-8s%-23s%-23s\n\n", "STT", "Mã NV", "Tên", "Lương");
            Collections.sort(arl, Staff.sortBangLuongGiamDan);
            for(Staff e:arl) {
                soThuTu++;
                String s = String.format("%,d", e.getLuongNhanVien());
                System.out.printf("%-5s%-8s%-23s%-23s\n", soThuTu, e.getMaNhanVien(),e.getTenNhanVien(),s);
            }
        } else {
            System.out.printf("\nRẤT TIẾC! CHƯA CÓ CÁCH SÁCH XẾP ĐÃ CHỌN!\n");
        }

    }
}
