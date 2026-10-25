package minifarm.units.u25quest;

import minifarm.core.events.DomainEvent;
import minifarm.core.events.ItemSold;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): SaleValueQuest
 * ================================================================================================
 * Modul Unit: U25QUEST
 * 
 * Deskripsi Kelas:
 * Quest mencapai total nilai penjualan komoditas.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class SaleValueQuest
 * - Superclass (Pewarisan) : extends AbstractQuest
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public SaleValueQuest(String questId, String title, int targetValue, long reward)
 *    Logika Implementasi:
 *      super(questId, title, targetValue, reward);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean handleEvent(DomainEvent event)
 *    Logika Implementasi:
 *      if (event instanceof ItemSold sold) {
 *          advanceProgress((int) sold.getTotalPrice());
 *          return true;
 *      }
 *      return false;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */
