package minifarm.ui;

/**
 * Utilitas warna ANSI untuk antarmuka CLI MiniFarm.
 * Mendukung warna teks (foreground), gaya (bold, dim), dan warna latar (background).
 * Menghormati environment variable NO_COLOR dan system property -Dminifarm.color=false.
 */
public final class AnsiColor {
    // Reset code
    public static final String RESET = "\u001B[0m";

    // Text Styles
    public static final String BOLD = "\u001B[1m";
    public static final String DIM = "\u001B[2m";
    public static final String ITALIC = "\u001B[3m";
    public static final String UNDERLINE = "\u001B[4m";

    // Standard Foreground Colors
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Bright / High-Contrast Foreground Colors
    public static final String BRIGHT_BLACK = "\u001B[90m"; // Gray
    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BRIGHT_BLUE = "\u001B[94m";
    public static final String BRIGHT_MAGENTA = "\u001B[95m";
    public static final String BRIGHT_CYAN = "\u001B[96m";
    public static final String BRIGHT_WHITE = "\u001B[97m";

    // Background Colors
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_MAGENTA = "\u001B[45m";
    public static final String BG_CYAN = "\u001B[46m";
    public static final String BG_GRAY = "\u001B[100m";

    private static boolean enabled = checkSupport();

    private AnsiColor() {}

    private static boolean checkSupport() {
        String noColor = System.getenv("NO_COLOR");
        if (noColor != null && !noColor.isBlank()) {
            return false;
        }
        String prop = System.getProperty("minifarm.color");
        if ("false".equalsIgnoreCase(prop)) {
            return false;
        }
        return true;
    }

    public static void setEnabled(boolean value) {
        enabled = value;
    }

    public static boolean isEnabled() {
        return enabled;
    }

    /**
     * Membungkus teks dengan kode-kode ANSI jika pewarnaan aktif.
     */
    public static String wrap(String text, String... codes) {
        if (!enabled || text == null || text.isEmpty()) {
            return text == null ? "" : text;
        }
        StringBuilder sb = new StringBuilder();
        for (String code : codes) {
            sb.append(code);
        }
        sb.append(text).append(RESET);
        return sb.toString();
    }

    // Helper warna teks umum
    public static String red(String text) { return wrap(text, BRIGHT_RED); }
    public static String green(String text) { return wrap(text, BRIGHT_GREEN); }
    public static String yellow(String text) { return wrap(text, BRIGHT_YELLOW); }
    public static String gold(String text) { return wrap(text, BOLD, BRIGHT_YELLOW); }
    public static String blue(String text) { return wrap(text, BRIGHT_BLUE); }
    public static String magenta(String text) { return wrap(text, BRIGHT_MAGENTA); }
    public static String cyan(String text) { return wrap(text, BRIGHT_CYAN); }
    public static String white(String text) { return wrap(text, BRIGHT_WHITE); }
    public static String gray(String text) { return wrap(text, BRIGHT_BLACK); }
    public static String bold(String text) { return wrap(text, BOLD); }
    public static String dim(String text) { return wrap(text, DIM); }

    // Helper semantik MiniFarm
    public static String success(String text) { return wrap(text, BOLD, BRIGHT_GREEN); }
    public static String error(String text) { return wrap(text, BOLD, BRIGHT_RED); }
    public static String warning(String text) { return wrap(text, BOLD, BRIGHT_YELLOW); }
    public static String header(String text) { return wrap(text, BOLD, BRIGHT_CYAN); }
    public static String subheader(String text) { return wrap(text, BOLD, BRIGHT_YELLOW); }
    public static String coins(long amount) { return wrap(amount + " G", BOLD, BRIGHT_YELLOW); }
    public static String energy(int cur, int max) {
        String str = cur + "/" + max;
        if (cur > max * 0.5) return wrap(str, BOLD, BRIGHT_GREEN);
        if (cur >= max * 0.2) return wrap(str, BOLD, BRIGHT_YELLOW);
        return wrap(str, BOLD, BRIGHT_RED);
    }
    public static String weather(String weatherType) {
        if (weatherType == null) return yellow("SUNNY");
        return switch (weatherType.toUpperCase()) {
            case "SUNNY" -> wrap("SUNNY", BOLD, BRIGHT_YELLOW);
            case "RAINY" -> wrap("RAINY", BOLD, BRIGHT_BLUE);
            case "STORM" -> wrap("STORM", BOLD, BRIGHT_MAGENTA);
            case "CLOUDY" -> wrap("CLOUDY", BOLD, BRIGHT_BLACK);
            case "WINDY" -> wrap("WINDY", BOLD, BRIGHT_CYAN);
            default -> yellow(weatherType);
        };
    }
}

