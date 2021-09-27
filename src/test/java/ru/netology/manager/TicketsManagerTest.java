package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketsService;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketsManagerTest {
    Repository repository = new Repository();
    TicketsManager manager = new TicketsManager(repository);
    TicketsService ticket1 = new TicketsService(1, 4200, "SKC", "SRM", 120);
    TicketsService ticket2 = new TicketsService(2, 5600, "SKC", "PLK", 180);
    TicketsService ticket3 = new TicketsService(3, 3500, "SRM", "PLK", 90);
    TicketsService ticket4 = new TicketsService(4, 3200, "PLK", "SRM", 90);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
    }

    @Test
    public void shouldSearchByFromAirport() {
        TicketsService[] actual = manager.searchBy("SKC", "");
        TicketsService[] expected = new TicketsService[]{ticket1, ticket2};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchByNotFoundFlight() {
        TicketsService[] actual = manager.searchBy("AVG", "TBL");
        TicketsService[] expected = new TicketsService[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByToAirport() {
        TicketsService[] actual = manager.searchBy("", "PLK");
        TicketsService[] expected = new TicketsService[]{ticket3, ticket2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFromAndToAirport() {
        TicketsService[] actual = manager.searchBy("SKC", "SRM");
        TicketsService[] expected = new TicketsService[]{ticket4, ticket1, ticket2};

        assertArrayEquals(expected, actual);
    }
}