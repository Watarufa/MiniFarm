package minifarm.ui;

/**
 * Kumpulan ASCII art penuh warna untuk mempercantik antarmuka CLI MiniFarm.
 */
public final class AsciiArt {
    private AsciiArt() {}

    public static final String BANNER = 
            AnsiColor.cyan("========================================================================================\n") +
            AnsiColor.wrap("   __  __ _       _ _____                     ____ _     ___ \n", AnsiColor.BOLD, AnsiColor.BRIGHT_GREEN) +
            AnsiColor.wrap("  |  \\/  (_)_ __ (_)  ___|_ _ _ __ _ __ ___   / ___| |   |_ _|   ", AnsiColor.BOLD, AnsiColor.BRIGHT_GREEN) +
            AnsiColor.wrap("Simulator Pertanian CLI\n", AnsiColor.BOLD, AnsiColor.BRIGHT_YELLOW) +
            AnsiColor.wrap("  | |\\/| | | '_ \\| | |_ / _` | '__| '_ ` _ \\ | |   | |    | |    ", AnsiColor.BOLD, AnsiColor.BRIGHT_GREEN) +
            AnsiColor.wrap("Responsi Kolaboratif OOP\n", AnsiColor.BOLD, AnsiColor.BRIGHT_WHITE) +
            AnsiColor.wrap("  | |  | | | | | | |  _| (_| | |  | | | | | || |___| |___ | |    ", AnsiColor.BOLD, AnsiColor.BRIGHT_GREEN) +
            AnsiColor.wrap("Target Platform: Java 17\n", AnsiColor.BOLD, AnsiColor.BRIGHT_CYAN) +
            AnsiColor.wrap("  |_|  |_|_|_| |_|_|_|  \\__,_|_|  |_| |_| |_(_)____|_____|___|\n", AnsiColor.BOLD, AnsiColor.BRIGHT_GREEN) +
            AnsiColor.cyan("========================================================================================");

    public static final String WEATHER_SUNNY =
            AnsiColor.yellow("     \\   /\n") +
            AnsiColor.yellow("      .-.\n") +
            AnsiColor.yellow("   ― (   ) ―   ") + AnsiColor.wrap("[ CERAH / SUNNY ]", AnsiColor.BOLD, AnsiColor.BRIGHT_YELLOW) + "\n" +
            AnsiColor.yellow("      `-’\n") +
            AnsiColor.yellow("     /   \\");

    public static final String WEATHER_CLOUDY =
            AnsiColor.gray("      .--.\n") +
            AnsiColor.gray("   .-(    ).\n") +
            AnsiColor.gray("  (___.__)__)  ") + AnsiColor.wrap("[ BERAWAN / CLOUDY ]", AnsiColor.BOLD, AnsiColor.BRIGHT_BLACK);

    public static final String WEATHER_RAINY =
            AnsiColor.gray("      .--.\n") +
            AnsiColor.gray("   .-(    ).\n") +
            AnsiColor.gray("  (___.__)__)  ") + AnsiColor.wrap("[ HUJAN / RAINY ]", AnsiColor.BOLD, AnsiColor.BRIGHT_BLUE) + "\n" +
            AnsiColor.blue("    /  /  /\n") +
            AnsiColor.blue("   /  /  /");

    public static final String CHICKEN_ART =
            AnsiColor.red("    (o") + AnsiColor.yellow("_\n") +
            AnsiColor.yellow("    //\\   ") + AnsiColor.wrap("[ Ayam Petelur / Coop ]", AnsiColor.BOLD, AnsiColor.BRIGHT_WHITE) + "\n" +
            AnsiColor.yellow("    V_/_");

    public static final String COW_ART =
            AnsiColor.white("    ((...))\n") +
            AnsiColor.white("    ( o o )\n") +
            AnsiColor.white("     \\   /    ") + AnsiColor.wrap("[ Sapi Perah / Pasture ]", AnsiColor.BOLD, AnsiColor.BRIGHT_WHITE) + "\n" +
            AnsiColor.white("      ^_^");

    public static final String SHEEP_ART =
            AnsiColor.white("     o-o\n") +
            AnsiColor.white("    ('o')     ") + AnsiColor.wrap("[ Domba Wol / Pasture ]", AnsiColor.BOLD, AnsiColor.BRIGHT_WHITE) + "\n" +
            AnsiColor.white("    c(\")(\")");

    public static final String BARN_ART =
            AnsiColor.red("      /\\\n") +
            AnsiColor.red("     /  \\      ") + AnsiColor.cyan("+--------------------------+\n") +
            AnsiColor.red("    /____\\     ") + AnsiColor.cyan("| ") + AnsiColor.wrap("GUDANG PENYIMPANAN BARN", AnsiColor.BOLD, AnsiColor.BRIGHT_WHITE) + AnsiColor.cyan("  |\n") +
            AnsiColor.white("    | [][]|    ") + AnsiColor.cyan("| ") + AnsiColor.gray("Kapasitas: Semua Jenis   ") + AnsiColor.cyan("|\n") +
            AnsiColor.white("    |  __ |    ") + AnsiColor.cyan("+--------------------------+\n") +
            AnsiColor.white("    | |  ||");

    public static final String SILO_ART =
            AnsiColor.blue("     .---.\n") +
            AnsiColor.blue("    /_____\\    ") + AnsiColor.cyan("+--------------------------+\n") +
            AnsiColor.blue("    |     |    ") + AnsiColor.cyan("| ") + AnsiColor.wrap("SILO BIJI-BIJIAN & PAKAN", AnsiColor.BOLD, AnsiColor.BRIGHT_CYAN) + AnsiColor.cyan(" |\n") +
            AnsiColor.blue("    | === |    ") + AnsiColor.cyan("| ") + AnsiColor.gray("Khusus: Seed, Crop, Feed ") + AnsiColor.cyan("|\n") +
            AnsiColor.blue("    |     |    ") + AnsiColor.cyan("+--------------------------+\n") +
            AnsiColor.blue("    '-----'");

    public static final String SHOP_ART =
            AnsiColor.yellow("    .-----------------------.\n") +
            AnsiColor.yellow("    |   ") + AnsiColor.wrap("TOKO PAK TANI", AnsiColor.BOLD, AnsiColor.BRIGHT_YELLOW) + AnsiColor.yellow("       |\n") +
            AnsiColor.yellow("    |  ") + AnsiColor.green("Benih - Alat - Pupuk") + AnsiColor.yellow(" |\n") +
            AnsiColor.yellow("    '-----------------------'\n") +
            AnsiColor.white("             \\(o_o)/");

    public static final String MARKET_ART =
            AnsiColor.gold("    $$$$$$$$$$$$$$$$$$$$$$$$$\n") +
            AnsiColor.gold("    $   ") + AnsiColor.wrap("PASAR KOMODITAS", AnsiColor.BOLD, AnsiColor.BRIGHT_GREEN) + AnsiColor.gold("     $\n") +
            AnsiColor.gold("    $ ") + AnsiColor.yellow("Jual Hasil & Panenmu! ") + AnsiColor.gold("$\n") +
            AnsiColor.gold("    $$$$$$$$$$$$$$$$$$$$$$$$$");

    public static final String TROPHY_ART =
            AnsiColor.gold("      .------------.\n") +
            AnsiColor.gold("     /              \\\n") +
            AnsiColor.gold("    |  ") + AnsiColor.wrap("[ PENCAPAIAN ]", AnsiColor.BOLD, AnsiColor.BRIGHT_YELLOW) + AnsiColor.gold(" |\n") +
            AnsiColor.gold("     \\     ##       /\n") +
            AnsiColor.gold("      '----||------'\n") +
            AnsiColor.gold("          /  \\");

    public static final String CRAFT_ART =
            AnsiColor.magenta("       ____\n") +
            AnsiColor.magenta("      /    \\    ") + AnsiColor.wrap("[ MEJA KERJA CRAFTING ]", AnsiColor.BOLD, AnsiColor.BRIGHT_MAGENTA) + "\n" +
            AnsiColor.magenta("     |======|   ") + AnsiColor.gray("Buat Pupuk, Pakan & Kit\n") +
            AnsiColor.magenta("      \\____/");

    public static String getWeatherArt(String weatherType) {
        if (weatherType == null) return WEATHER_SUNNY;
        return switch (weatherType.toUpperCase()) {
            case "RAINY" -> WEATHER_RAINY;
            case "CLOUDY" -> WEATHER_CLOUDY;
            default -> WEATHER_SUNNY;
        };
    }
}
