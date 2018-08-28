package ee.sda.maven.tickets;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class AdultTicketMachineTest {

//  @Mock
  private DiscountCalculator discountCalculator;

  private Clock clock = Clock.fixed(Instant.parse("2018-08-27T10:00:00Z"), ZoneId.of("Europe/Tallinn"));

  @Before
  public void setUp() throws Exception {
    discountCalculator = mock(DiscountCalculator.class);
  }

  @Test
  public void buy_ThrowsNoPersonDataException_IfPersonIsNull() {
    // given
    Person person = null;
    AdultTicketMachine adultTicketMachine = new AdultTicketMachine(discountCalculator, 100, clock);

    // when
    try {
      adultTicketMachine.buy(person);
      fail("no exception was thrown");
    } catch (NoPersonDataException e) {
      // then
      assertEquals("Sorry, no person data", e.getMessage());
      assertNotNull(e.getTimestamp());
      assertEquals(LocalDateTime.now(clock), e.getTimestamp());

      verify(discountCalculator).calculate(any());
    }
  }

  @Test
  public void buy_ReturnsFullPriceTicket_IfSubsidizedPersonAndNoDiscountCalculator() throws NoPersonDataException {
    // given
    Person person = new Person(50, PersonStatus.DISABLED);
    DiscountCalculator discountCalculator = null;
    AdultTicketMachine adultTicketMachine = new AdultTicketMachine(discountCalculator, 100, clock);

    // when
    Ticket result = adultTicketMachine.buy(person);

    // then
    assertEquals(100, result.getPrice());
    assertEquals(person, result.getPerson());
    // assertEquals(LocalDateTime.now(), result.getTimestamp());
    assertNotNull(result.getTimestamp());
  }

  @Test
  public void buy_ReturnsFullPriceTicket_IfSubsidizedPersonAndDiscountCalculator() throws NoPersonDataException {
    // given
    Person person = new Person(50, PersonStatus.DISABLED);
    when(discountCalculator.calculate(person)).thenReturn(90);
    AdultTicketMachine adultTicketMachine = new AdultTicketMachine(discountCalculator, 100, clock);

    // when
    Ticket result = adultTicketMachine.buy(person);

    // then
    assertEquals(10, result.getPrice());
    assertEquals(person, result.getPerson());
    // assertEquals(LocalDateTime.now(), result.getTimestamp());
    assertNotNull(result.getTimestamp());

    verify(discountCalculator).calculate(person);
  }

}