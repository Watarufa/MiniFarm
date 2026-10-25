package minifarm.ui;

/**
 * Menu tampilan navigasi CLI MiniFarm dengan skema warna yang nyaman, hierarkis, dan informatif.
 */
public final class ConsoleMenu {
    private ConsoleMenu() {}

    public static void printMainMenu() {
        System.out.println(AnsiColor.header("NAVIGASI MENU UTAMA:"));
        printMenuItem(1, "Farm & Crops", "(Lahan & Tanaman: Tanam, Siram, Pupuk, Panen)");
        printMenuItem(2, "Inventory & Storage", "(Tas Ransel & Fasilitas Gudang Barn/Silo)");
        printMenuItem(3, "Shop", "(Toko Pembelian Bibit, Pakan & Perlengkapan)");
        printMenuItem(4, "Market", "(Pasar Penjualan Komoditas Hasil Panen & Ternak)");
        printMenuItem(5, "Animal Ranch & Housing", "(Peternakan: Ayam, Sapi, Domba & Kandang)");
        printMenuItem(6, "Crafting", "(Meja Kerja Resep Pembuatan Pakan, Pupuk & Tool)");
        printMenuItem(7, "Quests, Achievements & Orders", "(Papan Tugas, Pencapaian & Pesanan Pengiriman)");
        printMenuItem(8, "Farmer Profile, Skills & Journal", "(Profil Karakter, Level Skill, Statistik & Log)");
        printMenuItem(9, "Farm Upgrades", "(Perluas Lahan, Kapasitas Gudang & Rumah Kaca)");
        
        System.out.println(" " + AnsiColor.bold(AnsiColor.cyan("10.")) + " " +
                AnsiColor.bold(AnsiColor.green("Advance Day")) + " " +
                AnsiColor.gray("(Lewati Hari & Jalankan Siklus Pertumbuhan Harian)"));
        
        System.out.println("  " + AnsiColor.bold(AnsiColor.red("0.")) + " " +
                AnsiColor.bold(AnsiColor.red("Keluar (Exit Game)")));
    }

    private static void printMenuItem(int number, String title, String subtitle) {
        System.out.println("  " + AnsiColor.bold(AnsiColor.yellow(number + ".")) + " " +
                AnsiColor.bold(AnsiColor.white(title)) + " " +
                AnsiColor.gray(subtitle));
    }
}
