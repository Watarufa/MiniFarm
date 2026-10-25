package minifarm.units.u31journal;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractFarmNotification
 * ================================================================================================
 * Modul Unit: U31JOURNAL
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar notifikasi jurnal aktivitas (Polimorfik).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractFarmNotification
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String message;
 * 2. private final int day;
 * 3. private final long timestamp = System.currentTimeMillis();
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractFarmNotification(int day, String message)
 *    Logika Implementasi:
 *      this.day = day;
 *      this.message = message != null ? message : "";
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public int getDay()
 *    Logika Implementasi:
 *      return day;
 * 
 * 2. public String getMessage()
 *    Logika Implementasi:
 *      return message;
 * 
 * 3. public long getTimestamp()
 *    Logika Implementasi:
 *      return timestamp;
 * 
 * 4. public abstract String format()
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */
