package perpustakaan;

public class Fiksi extends Buku
{
    private String genre;

    public Fiksi(String judul, String penulis, String genre)
    {
        super(judul, penulis); //Memanggil constructor milik superclass (Buku)
        this.genre = genre;
    }

    @Override
    public void displayInfo()
    {
        System.out.println("Buku Fiksi: " + judul + " oleh " + penulis + " (Genre: " + genre+")");
    }
}