package minifarm.units.u13farmerprofile;

import minifarm.core.api.FarmerSnapshot;

// abstract class: cetakan dasar buat semua profesi petani
// gak bisa di new langsung, harus lewat anaknya (Balanced, Cultivator, Rancher)
public abstract class AbstractFarmerProfile {

    // encapsulation: field dibuat private final
    // jadi gak bisa diubah sembarangan dari luar, bacanya lewat getter
    private final String name;
    private final String specialization;

    // protected: cuma kelas anak yang bisa manggil ini lewat super(...)
    protected AbstractFarmerProfile(String name, String specialization) {
        // cek null dulu baru trim, biar gak error kalau namanya null
        // nama kosong atau cuma spasi langsung ditolak
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama petani tidak boleh kosong");
        }
        this.name = name.trim(); // simpan nama yang udah dirapiin
        this.specialization = specialization;
    }

    // getter: cara baca field private dari luar kelas
    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    // method abstract: gak ada isinya di sini
    // tiap profesi wajib bikin versinya sendiri, ini yang bikin polymorphism
    public abstract double getEnergyCostModifier(String actionType);

    // bungkus data petani jadi satu objek FarmerSnapshot buat dibaca modul lain
    public FarmerSnapshot toSnapshot(int energy, int maxEnergy, long coins) {
        return new FarmerSnapshot(name, specialization, energy, maxEnergy, coins);
    }
}