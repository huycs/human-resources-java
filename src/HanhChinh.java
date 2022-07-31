public class HanhChinh extends Department{

    private static int soNhanVienPhongHC = 0;

    public HanhChinh() {
        super("HC", "Hành Chính");
        soNhanVienPhongHC++;
    }

    //Hàm toString() hiển thị thông tin bộ phận Hành Chính
    @Override
    public String toString() {
        System.out.printf("%-8s%-15s%-8s\n",
                getMaBoPhan(),
                getTenBoPhan(),
                soNhanVienPhongHC-1
        );
        return null;
    }

    //Hàn resetSoNhanVien() để gán lại số nhân viên hiện tại của bộ phận Hành Chính sau khi hiển thị thông tin
    @Override
    public void resetSoNhanVien() {
        soNhanVienPhongHC--;
    }
}
