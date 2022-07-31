import java.util.Date;

public class Manager extends Staff {

    private String chucDanh;

    public Manager(String       maNhanVien,
                   String       tenNhanVien,
                   int          tuoiNhanVien,
                   double       heSoLuong,
                   String       ngayVaoLam,
                   Department   boPhanLamViec,
                   int          soNgayNghiPhep,
                   String       chucDanh) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong,  ngayVaoLam, boPhanLamViec, soNgayNghiPhep);
        setChucDanh(chucDanh);
        setLuongNhanVien(calculateSalary());
    }

    public String getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    //Sử dụng hàm calculateSalary() trong Interface ICalculator để tính lương
    @Override
    public int calculateSalary() {
        if(getChucDanh().equals("Business Leader")) {
            setLuongNhanVien((int)(this.getHeSoLuong()*5000000 + 8000000));
        } else if(getChucDanh().equals("Project Leader")) {
            setLuongNhanVien((int)(this.getHeSoLuong()*5000000 + 5000000));
        } else {
            setLuongNhanVien((int)(this.getHeSoLuong()*5000000 + 6000000));
        }
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
                getChucDanh(),
                getHeSoLuong(),
                getSoNgayNghiPhep(),
                "N/a");
    }
}
