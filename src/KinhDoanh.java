public class KinhDoanh extends Department{

    private static int soNhanVienPhongKD = 0;

    public KinhDoanh() {
        super("KD", "Kinh Doanh");
        soNhanVienPhongKD++;
    }

    //Hàm toString() hiển thị thông tin bộ phận Kinh Doanh
    @Override
    public String toString() {
        System.out.printf("%-8s%-15s%-8s\n",
                getMaBoPhan(),
                getTenBoPhan(),
                soNhanVienPhongKD-1
                );
        return null;
    }


    //Hàn resetSoNhanVien() để gán lại số nhân viên hiện tại của bộ phận Kinh Doanh sau khi hiển thị thông tin
    @Override
    public void resetSoNhanVien() {
        soNhanVienPhongKD--;
    }
}
