public class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String nama, String nim) {
        return super.getNama().equalsIgnoreCase(nama) && super.getNim().equals(nim);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil!");
        super.displayInfo();
    }
}