import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee extends Staff {

    private int soGioLamThem;

    public Employee(String      maNhanVien,
                    String      tenNhanVien,
                    int         tuoiNhanVien,
                    double      heSoLuong,
                    String      ngayVaoLam,
                    Department  boPhanLamViec,
                    int         soNgayNghiPhep,
                    int         soGioLamThem) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong,  ngayVaoLam, boPhanLamViec, soNgayNghiPhep);
        setSoGioLamThem(soGioLamThem);
        setLuongNhanVien(calculateSalary());
    }

    public int getSoGioLamThem() {
        return soGioLamThem;
    }

    public void setSoGioLamThem(int soGioLamThem) {
        this.soGioLamThem = soGioLamThem;
    }

    //Sử dụng hàm calculateSalary() trong Interface ICalculator để tính lương
    @Override
    public int calculateSalary() {
        setLuongNhanVien((int)(getHeSoLuong()*3000000 + getSoGioLamThem()*200000));
        return this.getLuongNhanVien();
    }

    //Hàm hiển thị thông tin nhân viên
    @Override
    void displayInformation() {
        System.out.printf(  "%-8s%-23s%-8s%-16s%-15s%-20s%-15s%-20s%-15s\n",
                            getMaNhanVien(),
                            getTenNhanVien(),
                            getTuoiNhanVien(),
                            getNgayVaoLam(),
                            getBoPhanLamViec().getTenBoPhan(),
                            "Nhân Viên",
                            getHeSoLuong(),
                            getSoNgayNghiPhep(),
                            getSoGioLamThem());
    }
}
