public class Customer implements Runnable {
    private final String name;
    private final TicketPool pool;

    public Customer(String name, TicketPool pool){
        this.name = name;
        this.pool = pool;
    }
    @Override
    public void run() {
        Ticket ticket = pool.reserveTicket(name);
        if(ticket != null){
            System.out.println(name + " successfully reserved ticket for " + ticket.getEvent() +", ID " + ticket.getId());
        } else{
            System.out.println(name + " could not reserve the ticket");
        }
    }
}
