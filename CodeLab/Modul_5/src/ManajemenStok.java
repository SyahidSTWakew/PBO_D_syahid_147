import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenStok
{
    public static void main(String[] args)
    {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running)
        {
            System.out.println();
            System.out.println("===== Menu Manajemen Stok =====");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");


            int opsi = -1;
            try
            {
                opsi = scanner.nextInt();
                scanner.nextLine();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            switch (opsi)
            {
                case 1:

                    try
                    {
                        System.out.print("Masukkan nama barang: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan stok awal: ");
                        int stok = scanner.nextInt();
                        scanner.nextLine();
                        daftarBarang.add(new Barang(nama, stok));
                        System.out.println("Barang '" + nama + "' berhasil ditambahkan.");
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("Input stok harus berupa angka!");
                        scanner.nextLine();
                    }
                    break;

                case 2:

                    if (daftarBarang.isEmpty())
                    {
                        System.out.println("Stok barang kosong.");
                    }
                    else
                    {
                        System.out.println("--- Daftar Barang ---");
                        for (int i = 0; i < daftarBarang.size(); i++)
                        {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". Nama: " + b.getNama() + ", Stok: " + b.getStok());
                        }
                    }
                    break;

                case 3:

                    if (daftarBarang.isEmpty())
                    {
                        System.out.println("Tidak ada barang untuk dikurangi.");
                        break;
                    }
                    try
                    {
                        System.out.println("--- Daftar Barang (Pilih untuk Kurangi Stok) ---");
                        for (int i = 0; i < daftarBarang.size(); i++)
                        {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
                        }
                        System.out.print("Masukkan nomor indeks barang: ");
                        int indeks = scanner.nextInt();
                        System.out.print("Masukkan jumlah stok yang akan diambil: ");
                        int jumlah = scanner.nextInt();
                        scanner.nextLine();

                        Barang b = daftarBarang.get(indeks);
                        if (jumlah > b.getStok())
                        {
                            throw new StokTidakCukupException("Stok untuk '" + b.getNama() + "' hanya tersisa " + b.getStok());
                        }
                        b.setStok(b.getStok() - jumlah);
                        System.out.println("Stok barang '" + b.getNama() + "' berhasil dikurangi. Sisa stok: " + b.getStok());
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine();
                    }
                    catch (IndexOutOfBoundsException e)
                    {
                        System.out.println("Indeks barang tidak valid!" );
                    }
                    catch (StokTidakCukupException e)
                    {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih! Program berakhir.");
                    running = false;
                    break;

                default:
                    System.out.println("Opsi tidak valid!");
            }
        }
        scanner.close();
    }
}