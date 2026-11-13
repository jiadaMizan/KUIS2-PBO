package id.ac.polinema.quiz2;

import java.util.List;
/**
 * Tempat bebas untuk mencoba programmu. Kelas ini TIDAK dinilai.
 *
 * Ide percobaan (tulis sendiri setelah tiap tahap selesai):
 *  1. Buat satu Customer, lalu coba ubah namanya.
 *  2. Buat satu RegularLaundry dan satu ExpressLaundry, lalu tampilkan harga-nya.
 *  3. Masukkan keduanya ke OrderCalculator.totalPrice(...) lewat sebuah List.
 *  4. Buat LaundryDesk dengan new ConsoleReceiptPrinter(), tambahkan pesanan laundry, lalu panggil checkout(...).
 *
 * Jalankan lewat NetBeans (Run Project), VS Code (Run di atas main),
 * atau terminal: mvn -q compile exec:java
 */
public class Main {

    public static void main(String[] args) {
        Customer customer1 = new Customer("C001", "Budi");
        customer1.setName("   ");
        System.out.println("Pelanggan: " + customer1.getCustomerId() + " - " + customer1.getName());

        LaundryOrder reguler = new RegularLaundry("L1", customer1, 5);
        LaundryOrder ekspres = new ExpressLaundry("L2", customer1, 5);

        System.out.println("Reguler  : Rp " + reguler.calculatePrice());
        System.out.println("Ekspres  : Rp " + ekspres.calculatePrice());
        System.out.println("Antar-jemput ekspres: Rp " + ((Deliverable) ekspres).deliveryFee());

        List<LaundryOrder> orders = List.of(reguler, ekspres);
        System.out.println("Total harga    : Rp " + OrderCalculator.totalPrice(orders));
        System.out.println("Total antar-jemput: Rp " + OrderCalculator.totalDelivery(orders));

        System.out.println("Berat 25 valid? " + OrderCalculator.isAcceptable(new RegularLaundry("L3", customer1, 25)));

        LaundryDesk desk = new LaundryDesk(new ConsoleReceiptPrinter());
        desk.add(reguler);
        desk.add(ekspres);
        System.out.println("Jumlah pesanan: " + desk.count());
        desk.checkout("L1");
        desk.checkout("L9");
    }
}
