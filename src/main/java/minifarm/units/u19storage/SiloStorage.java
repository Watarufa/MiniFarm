package minifarm.units.u19storage;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): SiloStorage
 * ================================================================================================
 * Modul Unit: U19STORAGE
 * 
 * Deskripsi Kelas:
 * Silo Padi/Pakan (Silo Storage): hanya menerima benih (seed), hasil panen (produce), dan pakan (feed).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class SiloStorage
 * - Superclass (Pewarisan) : extends AbstractFarmStorage
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public SiloStorage()
 *    Logika Implementasi:
 *      super("silo_storage", "Grain Silo", 10);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean acceptsItem(String itemId)
 *    Logika Implementasi:
 *      if (itemId == null) return false;
 *      String id = itemId.toLowerCase();
 *      return id.contains("seed") || id.contains("wheat") || id.contains("corn") || id.contains("feed");
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */
