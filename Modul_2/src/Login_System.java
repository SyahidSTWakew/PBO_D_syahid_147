import java.util.Scanner;

class admin {
    private static String username = "Syahid";
    private static String password = "syahid147";

    public static boolean login(String inputusername, String inputpassword) {
        return inputusername.equals(username) && inputpassword.equals(password);
    }
}

class mahasiswa{
    static String nama;
    static String nim;

    public mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public static boolean login(String inputnama, String inputnim){
        return inputnama.equals(nama) && inputnim.equals(nim);
    }

    public void display_info(){
        System.out.println("Login berhasil!");
        System.out.println("Nama " + nama);
        System.out.println("Nim " + nim);
    }
}

public class Login_System {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        mahasiswa mahasiswaobj = new mahasiswa("Syahid", "147");
        admin adminobj = new admin();

        System.out.println("Pilihan:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.println("Masukkan pilihan:");
        int pilihan = Scanner.nextInt();
        Scanner.nextLine();

        if (pilihan == 1) {
            int percobaan = 0;
            while (percobaan < 3) {
                System.out.println("Masukkan username:");
                String username = Scanner.nextLine();
                System.out.println("Masukkan Password:");
                String password = Scanner.nextLine();

                if (admin.login(username, password)) {
                    System.out.println("Login anda berhasil! Selamat datang, mimin!");
                    break;
                } else {
                    percobaan++;
                    System.out.println("Login anda gagal! Eror! Percobaan: " + percobaan);
                }

                if (percobaan == 3){
                    System.out.println("Anda telah gagal login sebanyak 3 kali. Program ini akan ditutup.");
                }
            }

        } else if (pilihan == 2) {

            System.out.println("Masukkan nama:");
            String nama = Scanner.nextLine();
            System.out.println("Masukkan nim:");
            String nim = Scanner.nextLine();

            if (mahasiswa.login(nama, nim)) {
                mahasiswaobj.display_info();
            } else {
                System.out.println("Login Mahasiswa gagal! Eror!");
            }
            Scanner.close();
        }
    }
}
