public class TicketReserveSystem {
    public static void main(String[] args) {
        TicketPool pool = new TicketPool(5); // Only 5 tickets available
        // Simulate 10 people
        for(int i= 1; i<=10; i++){
            String customerName = "Customer " + i;
            // Virtual thread for each customer
            Thread.startVirtualThread(new Customer(customerName, pool));
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}