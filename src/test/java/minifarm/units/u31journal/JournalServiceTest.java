package minifarm.units.u31journal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U31")
@Tag("unit")
class JournalServiceTest {

    private JournalService journalService;

    @BeforeEach
    void setUp() {
        journalService = new JournalService();
    }

    @Test
    @DisplayName("Jurnal mencatat notifikasi dan menjaga kapasitas maksimal 50 entri (FIFO)")
    void record_maintainsMaxCapacityFifty() {
        for (int i = 1; i <= 60; i++) {
            journalService.record(new InfoNotification(1, "Catatan ke-" + i));
        }

        assertEquals(50, journalService.getAllEntries().size(), "Maksimal 50 entri");
        // Entri paling lama (1-10) harus sudah terhapus, entri pertama di list adalah ke-11
        assertTrue(journalService.getAllEntries().get(0).getMessage().contains("Catatan ke-11"));
        assertTrue(journalService.getAllEntries().get(49).getMessage().contains("Catatan ke-60"));
    }

    @Test
    @DisplayName("Bukti Polymorphism: Tiap turunan AbstractFarmNotification memformat teks secara berbeda")
    void polymorphicNotifications_formatDifferently() {
        AbstractFarmNotification succ = new SuccessNotification(1, "Panen Berhasil");
        AbstractFarmNotification warn = new WarningNotification(1, "Hama Terdeteksi");
        AbstractFarmNotification info = new InfoNotification(1, "Hari Baru");

        assertTrue(succ.format().startsWith("[SUCCESS"));
        assertTrue(warn.format().startsWith("[WARN"));
        assertTrue(info.format().startsWith("[INFO"));
    }
}

