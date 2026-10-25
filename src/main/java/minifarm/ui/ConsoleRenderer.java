package minifarm.ui;

import minifarm.core.api.CropSnapshot;
import minifarm.core.api.SoilSnapshot;
import minifarm.units.u01plot.AbstractFarmPlot;
import minifarm.units.u01plot.OutdoorCropPlot;
import minifarm.units.u01plot.PlotService;
import minifarm.units.u05soil.SoilService;

import java.util.Optional;

/**
 * Utilitas untuk merender teks berwarna, visual ASCII art, tabel status, dan umpan balik interaktif.
 * Menggunakan kombinasi ANSI color dan ASCII border standar yang tahan banting di seluruh terminal.
 */
public final class ConsoleRenderer {
    private ConsoleRenderer() {}

    /**
     * Membersihkan layar konsol secara nyata (clear screen & reset cursor)
     * agar tampilan tidak menumpuk di command line.
     */
    public static void clearScreen() {
        try {
            String os = System.getProperty("os.name", "").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } catch (Throwable ignored) {
        }
        // ANSI escape codes:
        // \033[H   : Home cursor (1, 1)
        // \033[2J  : Clear entire screen
        // \033[3J  : Clear scrollback buffer
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
    }

    public static void printBanner() {
        System.out.println(AsciiArt.BANNER);
    }

    public static void printHeader(String title) {
        String bar = AnsiColor.cyan("=".repeat(75));
        System.out.println("\n" + bar);
        System.out.println("  >>> " + AnsiColor.wrap(title.toUpperCase(), AnsiColor.BOLD, AnsiColor.BRIGHT_CYAN) + " <<<");
        System.out.println(bar);
    }

    public static void printStatus(
            int day,
            String weather,
            int energy,
            int maxEnergy,
            long coins,
            int occupiedPlots,
            int totalPlots,
            String lastMessage
    ) {
        String border = AnsiColor.cyan("+" + "-".repeat(73) + "+");
        System.out.println(border);

        // Format cell content dengan pad agar ANSI escape tidak merusak layout kolom
        String dayStr = AnsiColor.bold(AnsiColor.white("HARI: ")) + AnsiColor.cyan(String.format("%02d", day));
        
        String weatherPad = String.format("%-7s", weather);
        String weatherStr = AnsiColor.bold(AnsiColor.white("CUACA: ")) + AnsiColor.weather(weather) + " ".repeat(Math.max(0, 7 - weather.length()));
        
        String energyStr = AnsiColor.bold(AnsiColor.white("ENERGI: ")) + AnsiColor.energy(energy, maxEnergy);
        String energyPad = " ".repeat(Math.max(0, 7 - (energy + "/" + maxEnergy).length()));

        String coinVal = String.format("%6d G", coins);
        String coinStr = AnsiColor.bold(AnsiColor.white("KOIN: ")) + AnsiColor.gold(coinVal);

        String plotVal = String.format("%d/%-2d", occupiedPlots, totalPlots);
        String plotStr = AnsiColor.bold(AnsiColor.white("LAHAN: ")) + AnsiColor.cyan(plotVal);

        String sep = AnsiColor.cyan(" | ");
        System.out.println(
                AnsiColor.cyan("| ") +
                dayStr + sep +
                weatherStr + sep +
                energyStr + energyPad + sep +
                coinStr + sep +
                plotStr +
                AnsiColor.cyan(" |")
        );
        System.out.println(border);

        if (lastMessage != null && !lastMessage.isBlank()) {
            if (lastMessage.startsWith("[OK]") || lastMessage.contains("Berhasil") || lastMessage.contains("berhasil")) {
                System.out.println(AnsiColor.green(">> NOTIFIKASI: " + lastMessage));
            } else if (lastMessage.startsWith("[!]") || lastMessage.contains("Gagal") || lastMessage.contains("gagal")) {
                System.out.println(AnsiColor.red(">> NOTIFIKASI: " + lastMessage));
            } else {
                System.out.println(AnsiColor.yellow(">> NOTIFIKASI: " + lastMessage));
            }
            System.out.println(AnsiColor.cyan("-".repeat(75)));
        }
    }

    public static void printStatus(int day, String weather, int energy, int maxEnergy, long coins, int occupiedPlots, int totalPlots) {
        printStatus(day, weather, energy, maxEnergy, coins, occupiedPlots, totalPlots, null);
    }

    /**
     * Merender grid petak lahan secara visual dengan warna kontras dan indikator status jelas.
     */
    public static void renderPlotGrid(PlotService plotService, SoilService soilService) {
        int total = plotService.getPlotCount();
        System.out.println("\n" + AnsiColor.header("VISUALISASI PETAK LAHAN PERTANIAN:"));

        for (int i = 0; i < total; i++) {
            AbstractFarmPlot plot = plotService.getPlot(i);
            boolean isProtected = !(plot instanceof OutdoorCropPlot);
            String plotType = isProtected 
                    ? AnsiColor.magenta("[Rumah Kaca/Greenhouse]") 
                    : AnsiColor.cyan("[Luar Ruang/Outdoor]   ");
            
            boolean moist = plotService.isPlotMoist(i);
            String moistStr = moist 
                    ? AnsiColor.blue("[Lembap/Moist]") 
                    : AnsiColor.gray("[Kering/Dry]  ");
            
            SoilSnapshot soil = soilService.getSoilSnapshot(i);
            String fertStr;
            int fert = soil.getFertility();
            if (fert >= 80) {
                fertStr = AnsiColor.green(String.format("%3d/100", fert));
            } else if (fert >= 50) {
                fertStr = AnsiColor.yellow(String.format("%3d/100", fert));
            } else {
                fertStr = AnsiColor.gray(String.format("%3d/100", fert));
            }

            Optional<CropSnapshot> cropOpt = plotService.getCropSnapshot(i);

            System.out.println(AnsiColor.cyan("  +---------------------------------------------------------+"));
            System.out.printf("  | " + AnsiColor.bold(AnsiColor.yellow("Petak #%d")) + " %s | Tanah: %s | Subur: %s |\n",
                    i, plotType, moistStr, fertStr);

            if (cropOpt.isEmpty()) {
                System.out.println("  |   Tanaman : " + AnsiColor.gray("(Kosong)") + "                                    |");
                System.out.println("  |   Status  : " + AnsiColor.gray("[ . . . Petak Siap Ditanami . . . ]") + "         |");
            } else {
                CropSnapshot crop = cropOpt.get();
                String matureTag = crop.isMature() 
                        ? AnsiColor.wrap("[ SIAP PANEN! ]", AnsiColor.BOLD, AnsiColor.BRIGHT_GREEN) 
                        : AnsiColor.yellow("[ Masih Tumbuh ]");
                
                String progressBar = renderProgressBar(crop.getGrowthDay(), crop.getDaysToMature(), 10);
                
                String hpStr;
                int hp = crop.getHealth();
                if (hp >= 70) {
                    hpStr = AnsiColor.green(String.format("%3d/100", hp));
                } else if (hp >= 40) {
                    hpStr = AnsiColor.yellow(String.format("%3d/100", hp));
                } else {
                    hpStr = AnsiColor.red(String.format("%3d/100", hp));
                }

                String cropName = AnsiColor.bold(AnsiColor.yellow(String.format("%-12s", crop.getCropType().toUpperCase())));
                System.out.println("  |   Tanaman : " + cropName + " | " + matureTag + "                |");
                System.out.printf("  |   Progres : %s (%d/%d hari) | HP: %s           |\n",
                        progressBar, crop.getGrowthDay(), crop.getDaysToMature(), hpStr);
            }
            System.out.println(AnsiColor.cyan("  +---------------------------------------------------------+"));
        }
    }

    public static String renderProgressBar(int current, int max, int width) {
        if (max <= 0) return AnsiColor.gray("[]");
        float fraction = (float) current / max;
        int filled = Math.min(width, Math.max(0, Math.round(fraction * width)));
        return AnsiColor.gray("[") +
                AnsiColor.green("#".repeat(filled)) +
                AnsiColor.gray("-".repeat(width - filled)) +
                AnsiColor.gray("]");
    }

    public static void printSuccess(String message) {
        System.out.println("\n" + AnsiColor.success("[BERHASIL] ") + message);
    }

    public static void printWarning(String message) {
        System.out.println("\n" + AnsiColor.warning("[PERINGATAN] ") + message);
    }

    public static void printError(String message) {
        System.out.println("\n" + AnsiColor.error("[GAGAL] ") + message);
    }

    public static void printInfo(String message) {
        System.out.println("\n" + AnsiColor.cyan("[INFO] ") + message);
    }
}
