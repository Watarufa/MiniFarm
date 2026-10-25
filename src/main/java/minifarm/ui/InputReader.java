package minifarm.ui;

/**
 * Interface pembaca input untuk CLI, mempermudah pengujian otomatis tanpa blocking System.in.
 */
public interface InputReader {
    String readLine(String prompt);
    int readInt(String prompt, int min, int max);
}

