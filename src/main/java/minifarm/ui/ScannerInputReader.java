package minifarm.ui;

import java.util.Scanner;

/**
 * Implementasi InputReader standar menggunakan Scanner dari System.in
 * dengan umpan balik visual berwarna saat terjadi kesalahan input.
 */
public class ScannerInputReader implements InputReader {
    private final Scanner scanner;

    public ScannerInputReader() {
        this.scanner = new Scanner(System.in);
    }

    public ScannerInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readLine(String prompt) {
        System.out.print(AnsiColor.bold(prompt));
        if (!scanner.hasNextLine()) {
            return "";
        }
        return scanner.nextLine().trim();
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(AnsiColor.bold(prompt));
            if (!scanner.hasNextLine()) {
                return min;
            }
            String input = scanner.nextLine().trim();
            try {
                int val = Integer.parseInt(input);
                if (val >= min && val <= max) {
                    return val;
                }
                System.out.println(AnsiColor.error("(!) Input di luar rentang [" + min + " - " + max + "]. Silakan coba lagi."));
            } catch (NumberFormatException e) {
                System.out.println(AnsiColor.error("(!) Input harus berupa angka valid. Silakan coba lagi."));
            }
        }
    }
}
