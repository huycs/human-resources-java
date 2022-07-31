abstract class Department {

    private String maBoPhan;
    private String tenBoPhan;

    public Department(String maBoPhan, String tenBoPhan) {
        setMaBoPhan(maBoPhan);
        setTenBoPhan(tenBoPhan);
    }

    public String getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(String maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    //Hàm toString() hiển thị thông tin bộ phận
    @Override
    public String toString() {
        return null;
    }

    //Hàn resetSoNhanVien() để gán lại số nhân viên hiện tại của mỗi bộ phận sau khi hiển thị thông tin
    public abstract void resetSoNhanVien ();
}
