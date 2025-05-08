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
