package minifarm.units.u06daycycle;

import minifarm.core.api.DayContext;

import java.util.Objects;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): PreDayValidationProcess
 * ================================================================================================
 * Modul Unit: U06DAYCYCLE
 * 
 * Deskripsi Kelas:
 * Tahap 1: Validasi sebelum proses harian (order = 10).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class PreDayValidationProcess
 * - Superclass (Pewarisan) : extends AbstractDailyProcess
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public PreDayValidationProcess()
 *    Logika Implementasi:
 *      super("PreDayValidation", 10);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public void execute(DayContext context)
 *    Logika Implementasi:
 *      // TODO U06: Lakukan validasi prasyarat harian jika diperlukan
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

public class PreDayValidationProcess extends AbstractDailyProcess {
    public PreDayValidationProcess() {
        super("PreDayValidation", 10);
    }

    @Override
    public void execute(DayContext context) {
        Objects.requireNonNull(context, "context tidak boleh null");
    }
}
