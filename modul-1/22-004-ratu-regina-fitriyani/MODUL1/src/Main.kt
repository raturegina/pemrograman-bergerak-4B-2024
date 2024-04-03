import java.util.Scanner

class VCD(val judul: String, var tersedia: Boolean)

class TokoVCD {
    private val daftarVCD = mutableListOf<VCD>()


    init {
        // Menambahkan beberapa VCD ke dalam daftar
        daftarVCD.add(VCD("KERETA MANGGARAI", true))
        daftarVCD.add(VCD("STAWBERRY SHORTCAKE", true))
        daftarVCD.add(VCD("TRAIN TO BUSAN", false))
        daftarVCD.add(VCD("WARKOP DKI", true))
    }

    fun tampilkanDaftarVCD() {
        println("Daftar VCD yang tersedia:")
        for ((index, vcd) in daftarVCD.withIndex()) {
            println("${index + 1}. ${vcd.judul} - Tersedia: ${if (vcd.tersedia) "Ya" else "Tidak"}")
        }
    }

    fun pinjamVCD(index: Int) {
        if (index >= 0 && index < daftarVCD.size) {
            val vcd = daftarVCD[index]
            if (vcd.tersedia) {
                println("Anda berhasil meminjam VCD ${vcd.judul}.")
                vcd.tersedia = false
            } else {
                println("Maaf, VCD ${vcd.judul} tidak tersedia untuk dipinjam saat ini.")
            }
        } else {
            println("Indeks VCD tidak valid.")
            //digunakan untuk meminjam VCD berdasarkan indeksnya.
        // Jika VCD tersedia, maka VCD tersebut dipinjam dan statusnya diubah menjadi tidak tersedia.
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val toko = TokoVCD()
    //Membuat objek TokoVCD, yang akan digunakan untuk mengelola toko peminjaman VCD.

    while (true) {
        println("\nSelamat datang di Toko Peminjaman VCD")
        println("1. Tampilkan Daftar VCD")
        println("2. Pinjam VCD")
        println("3. Keluar")
        print("Pilihan Anda: ")

        when (scanner.nextInt()) { //input pilihan pengguna
            1 -> toko.tampilkanDaftarVCD()
            2 -> {
                println("Masukkan nomor VCD yang ingin Anda pinjam:")
                val index = scanner.nextInt() - 1
                toko.pinjamVCD(index)
            }
            3 -> {
                println("Terima kasih telah menggunakan layanan kami.")
                return
            }
            else -> println("Pilihan tidak valid. Silakan pilih lagi.")
        }
    }
}