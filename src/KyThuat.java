public class KyThuat extends Department{

    private static int soNhanVienPhongKT = 0;

    public KyThuat() {
        super("KT", "Kỹ Thuật");
        soNhanVienPhongKT++;
    }

    //Hàm toString() hiển thị thông tin bộ phận Kỹ Thuật
    @Override
    public String toString() {
        System.out.printf("%-8s%-15s%-8s\n",
                getMaBoPhan(),
                getTenBoPhan(),
                soNhanVienPhongKT-1
        );
        return null;
    }

    //Hàn resetSoNhanVien() để gán lại số nhân viên hiện tại của bộ phận Kỹ Thuật sau khi hiển thị thông tin
    @Override
    public void resetSoNhanVien() {
        soNhanVienPhongKT--;
    }
}
