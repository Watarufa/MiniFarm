package minifarm.units.u01plot;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U01")
@Tag("unit")
class PlotServiceTest {

    private PlotService plotService;

    @BeforeEach
    void setUp() {
        plotService = new PlotService(4, 8);
    }

    @Test
    @DisplayName("Petak kosong berhasil menerima tanaman baru")
    void placeCrop_whenPlotEmpty_succeeds() {
        String dummyCrop = "WheatCropInstance";
        OperationResult<Void> result = plotService.placeCrop(0, dummyCrop);

        assertTrue(result.isSuccess());
        assertEquals(ResultCode.SUCCESS, result.getCode());
        assertFalse(plotService.isPlotEmpty(0));
        assertEquals(1, plotService.getOccupiedPlotCount());
    }

    @Test
    @DisplayName("Petak terisi menolak penanaman tanaman kedua")
    void placeCrop_whenPlotOccupied_failsAndDoesNotMutateState() {
        plotService.placeCrop(0, "FirstCrop");
        OperationResult<Void> secondResult = plotService.placeCrop(0, "SecondCrop");

        assertTrue(secondResult.isFailure());
        assertEquals(ResultCode.INVALID_STATE, secondResult.getCode());
        assertEquals(1, plotService.getOccupiedPlotCount());
    }

    @Test
    @DisplayName("Petak yang telah dipanen/dikosongkan dapat ditanami kembali")
    void takeCrop_clearsPlotForReuse() {
        plotService.placeCrop(1, "SampleCrop");
        OperationResult<Object> takeResult = plotService.takeCrop(1);

        assertTrue(takeResult.isSuccess());
        assertEquals("SampleCrop", takeResult.getOrNull());
        assertTrue(plotService.isPlotEmpty(1));

        // Tanam kembali
        OperationResult<Void> replantResult = plotService.placeCrop(1, "NewCrop");
        assertTrue(replantResult.isSuccess());
    }

    @Test
    @DisplayName("Bukti Polymorphism: OutdoorPlot menjadi lembap saat hujan, sedangkan ProtectedPlot tidak")
    void polymorphicWeather_outdoorVersusProtectedReactionToRain() {
        // Petak 0 adalah OutdoorPlot
        // Konversi Petak 1 menjadi ProtectedCropPlot
        OperationResult<Void> convertResult = plotService.convertToProtectedPlot(1);
        assertTrue(convertResult.isSuccess());

        assertTrue(plotService.getPlot(0) instanceof OutdoorCropPlot);
        assertTrue(plotService.getPlot(1) instanceof ProtectedCropPlot);

        // Terapkan cuaca hujan
        plotService.applyDailyWeather(true);

        assertTrue(plotService.isPlotMoist(0), "Petak outdoor harus lembap terkena hujan");
        assertFalse(plotService.isPlotMoist(1), "Petak protected tidak boleh terkena hujan");
    }

    @Test
    @DisplayName("Aksi gagal tidak mengubah state petak (Atomisitas)")
    void placeCrop_withInvalidIndex_doesNotAffectPlots() {
        int initialOccupied = plotService.getOccupiedPlotCount();
        OperationResult<Void> result = plotService.placeCrop(99, "InvalidPlotCrop");

        assertTrue(result.isFailure());
        assertEquals(ResultCode.INVALID_ARGUMENT, result.getCode());
        assertEquals(initialOccupied, plotService.getOccupiedPlotCount());
    }
}

