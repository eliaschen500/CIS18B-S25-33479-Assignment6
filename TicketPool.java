// Shared resource: keeping track of how many tickets are left
public class TicketPool {
    private int availableTickets;

    public TicketPool(int totalTickets) {
        this.availableTickets = totalTickets;
    }
    //Synchronized method to make sure only one thread can reserve at a time
    public synchronized Ticket reserveTicket(String customerName) {
        while (availableTickets <= 0){
            System.out.println(customerName + " is waiting...no tickets left right now.");
            try{
                wait(); // Wait someone to release a ticket
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                return null;
            }
        }
        availableTickets--;
        Ticket ticket = new Ticket(availableTickets, "Concert");
        System.out.println(customerName + " reserved a ticket. Tickets left: " + availableTickets);
        return ticket;
    }
    // Method for releasing tickets
    public synchronized void releaseTicket(){
        availableTickets++;
        notifyAll(); // Notify anyone who is waiting for the ticket
    }
}