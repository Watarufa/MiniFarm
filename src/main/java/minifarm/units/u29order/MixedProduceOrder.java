package minifarm.units.u29order;

import minifarm.core.api.ItemStack;
import minifarm.core.config.GameConfig;
import java.util.List;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): MixedProduceOrder
 * ================================================================================================
 * Modul Unit: U29ORDER
 * 
 * Deskripsi Kelas:
 * Pesanan pengiriman campuran hasil panen dan peternakan.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class MixedProduceOrder
 * - Superclass (Pewarisan) : extends AbstractDeliveryOrder
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public MixedProduceOrder()
 *    Logika Implementasi:
 *      super(
 *              "order_mixed_1",
 *              "Pasar Akhir Pekan",
 *              70L,
 *              List.of(
 *                      new ItemStack(GameConfig.CROP_WHEAT, 2),
 *                      new ItemStack(GameConfig.ITEM_EGG, 2)
 *              )
 *      );
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */
