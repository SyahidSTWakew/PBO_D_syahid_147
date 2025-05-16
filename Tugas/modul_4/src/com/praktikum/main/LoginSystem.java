package com.praktikum.main;

import com.praktikum.users.*;

import java.util.Scanner;

public class LoginSystem
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Syahid Abdurrahman", "202410370110147", "admin147", "pw147");
        Mahasiswa mahasiswa = new Mahasiswa("syahid", "202410370110147");

        System.out.println("Pilih login sebagai:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1)
        {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            if (admin.login(username, password))
            {
                User user = admin;
                user.displayAppMenu();
            }
            else
            {
                System.out.println("Login Admin gagal.");
            }

        }
        else if (pilihan == 2)
        {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            if (mahasiswa.login(nama, nim))
            {
                User user = mahasiswa;
                user.displayAppMenu();
            }
            else
            {
                System.out.println("Login Mahasiswa gagal.");
            }
        }
    }
}