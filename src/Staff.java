import java.util.Comparator;

public abstract class Staff implements ICalculator {

    private String      maNhanVien;
    private String      tenNhanVien;
    private int         tuoiNhanVien;
    private double      heSoLuong;
    private String      ngayVaoLam;
    private Department  boPhanLamViec;
    private int         soNgayNghiPhep;
    private int         luongNhanVien;

    public Staff(String     maNhanVien,
                 String     tenNhanVien,
                 int        tuoiNhanVien,
                 double     heSoLuong,
                 String     ngayVaoLam,
                 Department boPhanLamViec,
                 int        soNgayNghiPhep) {
        setMaNhanVien(maNhanVien);
        setTenNhanVien(tenNhanVien);
        setTuoiNhanVien(tuoiNhanVien);
        setHeSoLuong(heSoLuong);
        setNgayVaoLam(ngayVaoLam);
        setBoPhanLamViec(boPhanLamViec);
        setSoNgayNghiPhep(soNgayNghiPhep);
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public int getTuoiNhanVien() {
        return  tuoiNhanVien;
    }

    public void setTuoiNhanVien(int tuoiNhanVien) {
        this.tuoiNhanVien = tuoiNhanVien;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {this.heSoLuong = heSoLuong; }

    public String getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public Department getBoPhanLamViec() {
        return boPhanLamViec;
    }

    public void setBoPhanLamViec(Department boPhanLamViec) {
        this.boPhanLamViec = boPhanLamViec;
    }

    public int getSoNgayNghiPhep() {
        return soNgayNghiPhep;
    }

    public void setSoNgayNghiPhep(int soNgayNghiPhep) {
        this.soNgayNghiPhep = soNgayNghiPhep;
    }

    public int getLuongNhanVien() {
        return luongNhanVien;
    }

    public void setLuongNhanVien(int luongNhanVien) {
        this.luongNhanVien = luongNhanVien;
    }

    //Hàm hiển thị thông tin nhân viên
    abstract void displayInformation();

    //Override 2 hàm compare để sắp xếp bảng lương tăng dần và giảm dần
    public static Comparator<Staff>  sortBangLuongTangDan = new Comparator<Staff>() {
        @Override
        public int compare(Staff s1, Staff s2) {
            int luongNV1 = s1.getLuongNhanVien();
            int luongNV2 = s2.getLuongNhanVien();
            return luongNV1 - luongNV2;
        }
    };

    public static Comparator<Staff>  sortBangLuongGiamDan = new Comparator<Staff>() {
        @Override
        public int compare(Staff s1, Staff s2) {
            int luongNV1 = s1.getLuongNhanVien();
            int luongNV2 = s2.getLuongNhanVien();
            return luongNV2 - luongNV1;
        }
    };

}
