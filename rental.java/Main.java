import java.util.Scanner;


class Kendaraan {
    protected String merk;
    protected String nomorPlat;

    public Kendaraan(String merk, String nomorPlat) {
        this.merk = merk;
        this.nomorPlat = nomorPlat;
    }

    public void tampilkanData() {
        System.out.println("Merk Kendaraan: " + merk);
        System.out.println("Nomor Plat: " + nomorPlat);
    }
}


class Penyewa {
    private String nama;
    private String kontak;

    public Penyewa(String nama, String kontak) {
        this.nama = nama;
        this.kontak = kontak;
    }

    public void tampilkanDataPenyewa() {
        System.out.println("Penyewa: " + nama);
        System.out.println("Kontak Penyewa: " + kontak);
    }
}


class PenyediaRental {
    private String namaPerusahaan;
    private String kontakPerusahaan;

    public PenyediaRental(String namaPerusahaan, String kontakPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
        this.kontakPerusahaan = kontakPerusahaan;
    }

    public void tampilkanDataPenyedia() {
        System.out.println("Penyedia Rental: " + namaPerusahaan);
        System.out.println("Kontak Penyedia: " + kontakPerusahaan);
    }
}


class RentalMobil extends Kendaraan {
    private int hargaSewa;
    private PenyediaRental penyediaRental;

    public RentalMobil(String merk, String nomorPlat, int hargaSewa, PenyediaRental penyediaRental) {
        super(merk, nomorPlat); 
        this.hargaSewa = hargaSewa;
        this.penyediaRental = penyediaRental;
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData(); 
        System.out.println("Harga Sewa Mobil: Rp " + hargaSewa + " per hari");
        penyediaRental.tampilkanDataPenyedia();
        System.out.println("----------------------------");
    }

    public int hitungTotalSewa(int hari) {
        return hargaSewa * hari;
    }
}


class RentalMotor extends Kendaraan {
    private int hargaSewa;
    private PenyediaRental penyediaRental;

    public RentalMotor(String merk, String nomorPlat, int hargaSewa, PenyediaRental penyediaRental) {
        super(merk, nomorPlat); 
        this.hargaSewa = hargaSewa;
        this.penyediaRental = penyediaRental;
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData(); 
        System.out.println("Harga Sewa Motor: Rp " + hargaSewa + " per hari");
        penyediaRental.tampilkanDataPenyedia();
        System.out.println("----------------------------");
    }

    public int hitungTotalSewa(int hari) {
        return hargaSewa * hari;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Selamat datang di Rental kendaraan Jaya");
        System.out.println("=============================");

        
        PenyediaRental penyedia = new PenyediaRental("Rental Kendaraan Jaya", "021-123456");

        
        Kendaraan[] kendaraanTersedia = {
            new RentalMobil("Toyota Avanza", "B 1234 AB", 500000, penyedia),
            new RentalMobil("Honda Brio", "D 5678 CD", 300000, penyedia),
            new RentalMobil("Mitsubishi Pajero", "F 9101 EF", 800000, penyedia),
            new RentalMotor("Yamaha Nmax", "B 4321 GH", 150000, penyedia),
            new RentalMotor("Honda Vario", "D 8765 IJ", 100000, penyedia)
        };

        
        System.out.print("Masukkan nama penyewa: ");
        String namaPenyewa = scanner.nextLine();
        System.out.print("Masukkan kontak penyewa: ");
        String kontakPenyewa = scanner.nextLine();
        Penyewa penyewa = new Penyewa(namaPenyewa, kontakPenyewa);

        
        System.out.println("\nDaftar Kendaraan yang Tersedia:");
        for (int i = 0; i < kendaraanTersedia.length; i++) {
            Kendaraan kendaraan = kendaraanTersedia[i];
            if (kendaraan instanceof RentalMobil) {
                RentalMobil mobil = (RentalMobil) kendaraan;
                System.out.println((i + 1) + ". " + mobil.merk + " (Mobil) - Rp " + mobil.hitungTotalSewa(1) + " per hari");
            } else if (kendaraan instanceof RentalMotor) {
                RentalMotor motor = (RentalMotor) kendaraan;
                System.out.println((i + 1) + ". " + motor.merk + " (Motor) - Rp " + motor.hitungTotalSewa(1) + " per hari");
            }
        }

        
        System.out.print("Pilih kendaraan yang ingin disewa (1-5): ");
        int pilihanKendaraan = scanner.nextInt();
        scanner.nextLine(); 

        if (pilihanKendaraan < 1 || pilihanKendaraan > kendaraanTersedia.length) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        
        System.out.print("Masukkan jumlah hari penyewaan: ");
        int jumlahHari = scanner.nextInt();

       
        Kendaraan kendaraanDipilih = kendaraanTersedia[pilihanKendaraan - 1];
        System.out.println("\nDetail Penyewaan:");
        kendaraanDipilih.tampilkanData();
        penyewa.tampilkanDataPenyewa();
        if (kendaraanDipilih instanceof RentalMobil) {
            RentalMobil mobil = (RentalMobil) kendaraanDipilih;
            System.out.println("Total Sewa untuk " + jumlahHari + " hari: Rp " + mobil.hitungTotalSewa(jumlahHari));
        } else if (kendaraanDipilih instanceof RentalMotor) {
            RentalMotor motor = (RentalMotor) kendaraanDipilih;
            System.out.println("Total Sewa untuk " + jumlahHari + " hari: Rp " + motor.hitungTotalSewa(jumlahHari));
        }

        
        System.out.println("\n=============================");
        System.out.println("Dibuat oleh: Kholis");
    }
}
