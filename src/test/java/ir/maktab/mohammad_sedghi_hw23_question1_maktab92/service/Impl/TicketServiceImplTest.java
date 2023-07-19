package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket;
import net.bytebuddy.ClassFileVersion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class TicketServiceImplTest {
    TicketServiceImpl ticketService;
    @InjectMocks
    Ticket ticket;
    @InjectMocks
    LocalDate departureDate;
    @InjectMocks
    List<Ticket> ticketList;
    @InjectMocks
    Long id;
    @InjectMocks
    Optional<Ticket> ticketOptional;

    @BeforeEach
    void setUp() {
        ticketService = Mockito.mock(TicketServiceImpl.class);
        ticket = Mockito.mock(Ticket.class);
        ticket = new Ticket("tehran", "esfahan", LocalDate.now(), LocalTime.of(13, 50), "793");
        ticketList = Mockito.mock(ArrayList.class);
        ticketList.add(ticket);
    }

    @Test
    void findPath() {
        // Mockito.when(personService.validate(person)).thenReturn(true);
        Mockito.when(ticketService.findPath("", "", departureDate)).thenReturn(ticketList);
        Assertions.assertEquals(ticketList, ticketService.findPath("", "", departureDate));

    }

    @Test
    void findTicketByMemberId() {
        Mockito.when(ticketService.findById(id)).thenReturn(ticketOptional);
        Assertions.assertEquals(ticketOptional, ticketService.findById(id));

    }
}