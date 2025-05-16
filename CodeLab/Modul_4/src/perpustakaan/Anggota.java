package perpustakaan;

public class Anggota implements Peminjaman
{
    //atribut
    private String nama;
    private String idAnggota;

    public Anggota(String nama, String idAnggota)
    {
        this.nama = nama;
        this.idAnggota = idAnggota;
    }
    //Menandakan method ini meng-override method dari interface.
    @Override
    public void pinjamBuku(String judul)
    {
        System.out.println(nama + " meminjam buku berjudul: " + judul);
    }

    @Override
    public void pinjamBuku(String judul, int durasi)
    {
        System.out.println(nama + " meminjam buku \"" + judul + "\" selama " + durasi + " hari.");
    }

    @Override
    public void kembalikanBuku(String judul)
    {
        System.out.println(nama + " mengembalikan buku berjudul: " + judul);
    }

    public void displayInfo()
    {
        System.out.println("Anggota: " + nama + " (ID: " + idAnggota+")");
    }
}