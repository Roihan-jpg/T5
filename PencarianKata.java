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
