import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Admin> daftarAdmin = new ArrayList<>();
        daftarAdmin.add(new Admin("147"));
        daftarAdmin.add(new Admin("118"));

        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        daftarMahasiswa.add(new Mahasiswa("syahid abdurrahman", "202410370110147"));
        daftarMahasiswa.add(new Mahasiswa("rosyad aja", "202410370110118"));

        System.out.println("Pilih Login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            boolean loggedIn = false;
            for (Admin admin : daftarAdmin) {
                if (admin.login(username, password)) {
                    admin.displayInfo();
                    loggedIn = true;
                    break;
                }
            }
            if (!loggedIn) {
                System.out.println("Login gagal! Username atau password salah.");
            }

        } else if (choice == 2) {
            System.out.print("Masukkan Nama: ");
            String name = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            boolean loggedIn = false;
            for (Mahasiswa mhs : daftarMahasiswa) {
                if (mhs.login(name, nim)) {
                    mhs.displayInfo();
                    loggedIn = true;
                    break;
                }
            }
            if (!loggedIn) {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }

        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}