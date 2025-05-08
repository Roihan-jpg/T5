import java.util.Scanner; // Mengimpor kelas Scanner untuk input dari pengguna

class Mahasiswa {
    String nim; // Menyimpan Nomor Induk Mahasiswa
    String nama; // Menyimpan nama mahasiswa
    String jurusan; // Menyimpan jurusan mahasiswa
    double ipk; // Menyimpan IPK mahasiswa

    public Mahasiswa(String nim, String nama, String jurusan, double ipk) { // Konstruktor Mahasiswa
        this.nim = nim; // Menetapkan nilai NIM
        this.nama = nama; // Menetapkan nilai nama
        this.jurusan = jurusan; // Menetapkan nilai jurusan
        this.ipk = ipk; // Menetapkan nilai IPK
    }

    @Override
    public String toString() { // Override method toString untuk representasi teks objek
        return String.format("NIM: %s\nNama: %s\nJurusan: %s\nIPK: %.2f", nim, nama, jurusan, ipk);
        // Mengembalikan format string yang rapi untuk data mahasiswa
    }
}

public class PencarianDataMahasiswa { // Kelas utama program
    public static void main(String[] args) { // Method utama
        // Data mahasiswa
        Mahasiswa[] daftarMahasiswa = { // Array objek Mahasiswa berisi data mahasiswa
            new Mahasiswa("2023001", "Budi Santoso", "Teknik Informatika", 3.75),
            new Mahasiswa("2023002", "Andi Wijaya", "Sistem Informasi", 3.50),
            new Mahasiswa("2023003", "Dewi Lestari", "Teknik Komputer", 3.90),
            new Mahasiswa("2023004", "Rina Maulana", "Teknik Informatika", 3.60),
            new Mahasiswa("2023005", "Doni Kusuma", "Manajemen Informatika", 3.25),
            new Mahasiswa("2023006", "Sinta Rahma", "Sistem Informasi", 3.85),
            new Mahasiswa("2023007", "Rudi Hermawan", "Teknik Komputer", 3.40)
        };

        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk input dari keyboard

        System.out.println("=== SISTEM PENCARIAN DATA MAHASISWA ==="); // Menampilkan judul program
        System.out.print("Masukkan NIM Mahasiswa yang dicari: "); // Meminta input NIM
        String nimCari = scanner.nextLine(); // Membaca input NIM dari pengguna

        // Lakukan pencarian linear
        Mahasiswa hasilPencarian = cariMahasiswaByNIM(daftarMahasiswa, nimCari); // Memanggil method untuk mencari mahasiswa berdasarkan NIM

        System.out.println("\nHASIL PENCARIAN:"); // Menampilkan judul hasil pencarian
        if (hasilPencarian != null) { // Jika mahasiswa ditemukan
            System.out.println("Mahasiswa ditemukan!"); // Menampilkan pesan sukses
            System.out.println(hasilPencarian); // Menampilkan data mahasiswa
        } else {
            System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan."); // Menampilkan pesan jika NIM tidak ditemukan
        }

        scanner.close(); // Menutup scanner setelah digunakan
    }

    public static Mahasiswa cariMahasiswaByNIM(Mahasiswa[] daftarMahasiswa, String nim) {
        for (int i = 0; i < daftarMahasiswa.length; i++) { // Melakukan loop ke seluruh data mahasiswa
            // Bandingkan NIM mahasiswa saat ini dengan NIM yang dicari
            if (daftarMahasiswa[i].nim.equals(nim)) { // Jika NIM cocok dengan input
                return daftarMahasiswa[i]; // Kembalikan objek Mahasiswa yang ditemukan
            }
        }
        // Jika tidak ditemukan
        return null;
    }
}



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



import java.util.ArrayList; // Mengimpor class ArrayList untuk menyimpan posisi kata yang ditemukan
import java.util.Scanner; // Mengimpor class Scanner untuk membaca input dari pengguna

public class PencarianKata { // Kelas utama program
    public static void main(String[] args) { // Fungsi utama tempat eksekusi program dimulai
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk input teks dari user

        System.out.println("=== SISTEM PENCARIAN KATA ==="); // Menampilkan judul program
        System.out.print("Masukkan teks: "); // Minta input teks
        String teks = scanner.nextLine(); // Baca seluruh teks yang dimasukkan

        System.out.print("Masukkan kata yang dicari: "); // Minta input kata yang ingin dicari
        String kataCari = scanner.nextLine(); // Baca kata yang akan dicari

        // Lakukan pencarian kata
        ArrayList<Integer> posisiDitemukan = cariKata(teks, kataCari); // Memanggil metode pencarian kata dan menyimpan indeks posisi kemunculan

        System.out.println("\nHASIL PENCARIAN:"); // Menampilkan header hasil pencarian
        if (posisiDitemukan.size() > 0) { // Jika ditemukan satu atau lebih posisi
            System.out.println("Kata '" + kataCari + "' ditemukan sebanyak " +
                               posisiDitemukan.size() + " kali pada posisi:"); // Tampilkan jumlah ditemukan

            for (int i = 0; i < posisiDitemukan.size(); i++) { // Iterasi setiap posisi ditemukan
                System.out.println("- Indeks ke-" + posisiDitemukan.get(i) +
                                   " (karakter ke-" + (posisiDitemukan.get(i) + 1) + ")"); // Tampilkan indeks (0-based dan 1-based)
            }

            // Tampilkan teks dengan highlight kata yang ditemukan
            System.out.println("\nTeks dengan highlight:"); // Tampilkan teks dengan highlight
            tampilkanTeksHighlight(teks, kataCari, posisiDitemukan); // Panggil fungsi penanda highlight
        } else {
            System.out.println("Kata '" + kataCari + "' tidak ditemukan dalam teks."); // Jika tidak ditemukan
        }

        scanner.close(); // Tutup scanner untuk mencegah kebocoran resource
    }

    public static ArrayList<Integer> cariKata(String teks, String kata) {
        ArrayList<Integer> posisi = new ArrayList<>(); // List untuk menyimpan posisi kata yang ditemukan

        // Konversi ke lowercase untuk pencarian case-insensitive
        String teksLower = teks.toLowerCase(); // Ubah ke lowercase agar pencarian tidak sensitif huruf besar-kecil
        String kataLower = kata.toLowerCase(); // Ubah kata pencarian ke lowercase

        int panjangKata = kataLower.length(); // Panjang kata yang dicari
        int panjangTeks = teksLower.length(); // Panjang teks input

        // Lakukan linear search
        for (int i = 0; i <= panjangTeks - panjangKata; i++) { // Iterasi dari awal hingga sisa panjang cukup
            // Periksa apakah substring dari posisi i sampai i+panjangKata sama dengan kata
            String potongan = teksLower.substring(i, i + panjangKata); // Ambil substring dengan panjang kata

            if (potongan.equals(kataLower)) { // Jika cocok dengan kata yang dicari
                posisi.add(i); // Simpan posisi indeks ke dalam list

                // Optional: Skip ke akhir kata yang ditemukan untuk menghindari overlap
                // i += panjangKata - 1;
            }
        }

        return posisi; // Kembalikan list posisi yang ditemukan
    }

    public static void tampilkanTeksHighlight(String teks, String kata, ArrayList<Integer> posisi) {
        StringBuilder hasil = new StringBuilder(teks); // Gunakan StringBuilder agar manipulasi teks efisien

        // Tambahkan marker untuk highlight (dari posisi terjauh dulu untuk menghindari pergeseran indeks)
        for (int i = posisi.size() - 1; i >= 0; i--) { // Iterasi mundur agar posisi insert tidak bergeser
            int pos = posisi.get(i); // Ambil posisi kata
            hasil.insert(pos + kata.length(), "]"); // Tambahkan tanda penutup ]
            hasil.insert(pos, "["); // Tambahkan tanda pembuka [
        }

        System.out.println(hasil.toString()); // Tampilkan hasil dengan highlight
    }
}
