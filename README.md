# CIS18B-S25-33479-Assignment6
This is a simple Java project that shows how multiple customers (threads) try to reserve tickets at the same time. It uses basic concurrency ideas like threads, synchronized code, and immutable objects.
# What does this project do
- Creates 10 customer threads (virtual threads)
- Each customer tries to reserve a ticket
- There are only 5 tickets total
- If a ticket is available, the customer gets one
- If not, they see a message saying no tickets left
# Files in the project
- Ticket.java: represents a ticket, cannot be changed once created
- TicketPool.java: keeps track of how many tickets are left
- Customer.java: each customer is a thread trying to get a ticket
- TicketReserveSystem.java: the main program that starts everything
# How to run
Requirements:
Java 21 or newer (because we use virtual threads)

Run it:
- javac Ticket.java TicketPool.java Customer.java TicketReserveSystem.java
- java TicketReserveSystem
You should see output in the console showing which customers got a ticket and which didn’t.
# Key concepts used
- Virtual threads: lightweight threads in Java 21
- Synchronized block: only one thread can change ticket count at a time
- Immutable object: Ticket class has final fields, no setters
