package minifarm.units.u06daycycle;

import minifarm.core.api.*;
import minifarm.core.events.DayAdvanced;
import minifarm.core.events.EventBus;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): DayCycleService
 * ================================================================================================
 * Modul Unit: U06DAYCYCLE
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U06: Siklus Hari dan Pemroses Harian.
 * Mengimplementasikan GameClock.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class DayCycleService
 * - Interface yang Diimplementasikan: implements GameClock
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private int currentDay;
 * 2. private WeatherSnapshot currentWeather;
 * 3. private final List<DailyProcess> processes = new ArrayList<>();
 * 4. private final List<DailyTickParticipant> participants = new ArrayList<>();
 * 5. private final EventBus eventBus;
 * 6. private final EnergyPort energyPort;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public DayCycleService(int initialDay, WeatherSnapshot initialWeather, EventBus eventBus, EnergyPort energyPort)
 *    Logika Implementasi:
 *      this.currentDay = initialDay;
 *      this.currentWeather = initialWeather != null ? initialWeather : new WeatherSnapshot("SUNNY", false, 1.0);
 *      this.eventBus = eventBus;
 *      this.energyPort = energyPort;
 *      
 *      // Registrasi default processes
 *      registerProcess(new PreDayValidationProcess());
 *      registerProcess(new DailyResolutionProcess());
 *      registerProcess(new DayRolloverProcess());
 * 
 * 2. Constructor: public DayCycleService(EventBus eventBus, EnergyPort energyPort)
 *    Logika Implementasi:
 *      this(1, new WeatherSnapshot("SUNNY", false, 1.0), eventBus, energyPort);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void registerProcess(DailyProcess process)
 *    Logika Implementasi:
 *      if (process != null) {
 *          processes.add(process);
 *          processes.sort(Comparator.comparingInt(DailyProcess::getOrder));
 *      }
 * 
 * 2. public void registerParticipant(DailyTickParticipant participant)
 *    Logika Implementasi:
 *      if (participant != null) {
 *          participants.add(participant);
 *          participants.sort(Comparator.comparingInt(DailyTickParticipant::getExecutionOrder));
 *      }
 * 
 * 3. @Override public int getCurrentDay()
 *    Logika Implementasi:
 *      return currentDay;
 * 
 * 4. @Override public WeatherSnapshot getCurrentWeather()
 *    Logika Implementasi:
 *      return currentWeather;
 * 
 * 5. public void setCurrentWeather(WeatherSnapshot nextWeather)
 *    Logika Implementasi:
 *      if (nextWeather != null) {
 *          this.currentWeather = nextWeather;
 *      }
 * 
 * 6. public OperationResult<Void> advanceDay(WeatherSnapshot nextWeather)
 *    Keterangan / Tujuan: Memajukan hari permainan: 1. Jalankan semua DailyProcess sesuai urutan order. 2. Jalankan semua DailyTickParticipant. 3. Pulihkan energi pemain ke batas maksimal. 4. Naikkan nomor hari tepat +1. 5. Publikasikan event DayAdvanced.
 *    Logika Implementasi:
 *      DayContext context = new DayContext(currentDay, currentWeather);
 *      
 *      // TODO U06:
 *      // 1. Eksekusi processes
 *      for (DailyProcess proc : processes) {
 *          proc.execute(context);
 *      }
 *      
 *      // 2. Eksekusi participants
 *      for (DailyTickParticipant part : participants) {
 *          part.onDayAdvance(context);
 *      }
 *      
 *      // 3. Pulihkan energi
 *      if (energyPort != null) {
 *          energyPort.restoreEnergy(energyPort.getMaxEnergy());
 *      }
 *      
 *      // 4. Majukan hari
 *      currentDay++;
 *      if (nextWeather != null) {
 *          this.currentWeather = nextWeather;
 *      }
 *      
 *      // 5. Publikasikan event pergantian hari
 *      if (eventBus != null) {
 *          eventBus.publish(new DayAdvanced(currentDay, currentWeather.getWeatherType()));
 *      }
 *      
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

public class DayCycleService implements GameClock {
    private int currentDay;
    private WeatherSnapshot currentWeather;
    private final List<DailyProcess> processes = new ArrayList<>();
    private final List<DailyTickParticipant> participants = new ArrayList<>();
    private final EventBus eventBus;
    private final EnergyPort energyPort;

    public DayCycleService(int initialDay, WeatherSnapshot initialWeather, EventBus eventBus, EnergyPort energyPort) {
        this.currentDay = initialDay;
        this.currentWeather = initialWeather != null ? initialWeather : new WeatherSnapshot("SUNNY", false, 1.0);
        this.eventBus = eventBus;
        this.energyPort = energyPort;

        registerProcess(new PreDayValidationProcess());
        registerProcess(new DailyResolutionProcess());
        registerProcess(new DayRolloverProcess());
    }

    public DayCycleService(EventBus eventBus, EnergyPort energyPort) {
        this(1, new WeatherSnapshot("SUNNY", false, 1.0), eventBus, energyPort);
    }

    public void registerProcess(DailyProcess process) {
        if (process != null) {
            processes.add(process);
            processes.sort(Comparator.comparingInt(DailyProcess::getOrder));
        }
    }

    public void registerParticipant(DailyTickParticipant participant) {
        if (participant != null) {
            participants.add(participant);
            participants.sort(Comparator.comparingInt(DailyTickParticipant::getExecutionOrder));
        }
    }

    @Override
    public int getCurrentDay() {
        return currentDay;
    }

    @Override
    public WeatherSnapshot getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(WeatherSnapshot nextWeather) {
        if (nextWeather != null) {
            this.currentWeather = nextWeather;
        }
    }

    public OperationResult<Void> advanceDay(WeatherSnapshot nextWeather) {
        DayContext context = new DayContext(currentDay, currentWeather);

        for (DailyProcess process : processes) {
            process.execute(context);
        }

        for (DailyTickParticipant participant : participants) {
            participant.onDayAdvance(context);
        }

        if (energyPort != null) {
            energyPort.restoreEnergy(energyPort.getMaxEnergy());
        }

        currentDay++;
        if (nextWeather != null) {
            this.currentWeather = nextWeather;
        }

        if (eventBus != null) {
            eventBus.publish(new DayAdvanced(currentDay, currentWeather.getWeatherType()));
        }

        return OperationResult.ok();
    }
}
