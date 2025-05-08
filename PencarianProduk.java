import java.util.ArrayList; // Mengimpor kelas ArrayList untuk menyimpan hasil pencarian
import java.util.Scanner; // Mengimpor kelas Scanner untuk input dari pengguna

class Produk { // Membuat class Produk untuk merepresentasikan data produk
    String id;  // ID produk
    String nama; // Nama produk
    String kategori; // Kategori produk (Elektronik, Fashion, Buku)
    double harga; // Harga produk
    int stok; // Jumlah stok produk

    public Produk(String id, String nama, String kategori, double harga, int stok) {
        this.id = id;              // Inisialisasi ID
        this.nama = nama;          // Inisialisasi nama
        this.kategori = kategori;  // Inisialisasi kategori
        this.harga = harga;        // Inisialisasi harga
        this.stok = stok;          // Inisialisasi stok
    }

    @Override
    public String toString() { // Override method toString untuk mencetak objek dengan format tertentu
        return String.format("%-5s | %-25s | %-15s | Rp %.2f | Stok: %d",
                             id, nama, kategori, harga, stok);
        // Format output saat objek Produk dicetak
    }
}

public class PencarianProduk { // Kelas utama program
    public static void main(String[] args) { // Method utama program
        // Data produk
        Produk[] daftarProduk = { // Array berisi data produk yang sudah dibuat
            new Produk("P001", "Laptop Asus VivoBook", "Elektronik", 8500000, 10),
            new Produk("P002", "Smartphone Samsung Galaxy", "Elektronik", 5000000, 15),
            new Produk("P003", "Kemeja Formal Pria", "Fashion", 250000, 50),
            new Produk("P004", "Sepatu Lari Nike", "Fashion", 1200000, 25),
            new Produk("P005", "Buku Pemrograman Java", "Buku", 150000, 30),
            new Produk("P006", "Mouse Gaming Logitech", "Elektronik", 350000, 20),
            new Produk("P007", "Novel Bumi Manusia", "Buku", 95000, 40),
            new Produk("P008", "Tas Ransel", "Fashion", 300000, 35)
        };

        Scanner scanner = new Scanner(System.in); // Membuat Scanner untuk membaca input dari user

        System.out.println("=== SISTEM PENCARIAN PRODUK ==="); // Judul tampilan
        System.out.println("Kategori tersedia: Elektronik, Fashion, Buku"); // Menampilkan kategori
        System.out.print("Masukkan kategori produk: "); // Meminta input kategori
        String kategoriCari = scanner.nextLine(); // Menyimpan input kategori

        System.out.print("Masukkan harga minimum: Rp "); // Meminta input harga minimum
        double hargaMin = scanner.nextDouble(); // Menyimpan input harga minimum

        System.out.print("Masukkan harga maksimum: Rp "); // Meminta input harga maksimum
        double hargaMax = scanner.nextDouble(); // Menyimpan input harga maksimum

        // Lakukan pencarian linear multi-kriteria
        ArrayList<Produk> hasilPencarian = cariProdukByKriteria(daftarProduk, kategoriCari, hargaMin, hargaMax);
        // Memanggil method untuk mencari produk berdasarkan kategori dan rentang harga

            //Menampilkan Hasil Pencarian
        System.out.println("\nHASIL PENCARIAN:");
        System.out.println("===============================================================");
        System.out.printf("%-5s | %-25s | %-15s | %-10s | %-10s\n",
                          "ID", "Nama Produk", "Kategori", "Harga", "Stok"); // Header tabel hasil
        System.out.println("---------------------------------------------------------------");

        if (hasilPencarian.size() > 0) { // Jika ada hasil yang ditemukan
            for (Produk p : hasilPencarian) { // Loop melalui semua produk hasil pencarian
                System.out.println(p); // Tampilkan produk (menggunakan toString)
            }
        } else { //jika produk tidak ditemukan
            System.out.println("Tidak ada produk yang sesuai dengan kriteria pencarian.");
        }
        System.out.println("===============================================================");

        scanner.close(); // Menutup Scanner untuk mencegah kebocoran resource
    }

    public static ArrayList<Produk> cariProdukByKriteria(Produk[] daftarProduk,
                                                         String kategori,
                                                         double hargaMin,
                                                         double hargaMax) {
        ArrayList<Produk> hasilPencarian = new ArrayList<>(); // Membuat list kosong untuk hasil

        for (int i = 0; i < daftarProduk.length; i++) { // Loop seluruh produk
            Produk produk = daftarProduk[i]; // Ambil produk ke-i

            // Periksa apakah produk memenuhi semua kriteria
            if (produk.kategori.equalsIgnoreCase(kategori) && // Cek kategori (tanpa case sensitive)
                produk.harga >= hargaMin && // Cek harga minimum
                produk.harga <= hargaMax) { // Cek harga maksimum
                hasilPencarian.add(produk); // Tambahkan ke list hasil
            }
        }

        return hasilPencarian; // Kembalikan hasil pencarian
    }
}
