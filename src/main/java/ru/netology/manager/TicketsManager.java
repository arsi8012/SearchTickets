package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.TicketsService;
import ru.netology.repository.Repository;

import java.util.Arrays;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketsManager {
    private Repository items;

    public void add(TicketsService item) {
        items.save(item);
    }

    public TicketsService[] searchBy(String from, String to) {
        TicketsService[] result = new TicketsService[0];
        for (TicketsService item : items.getAll()) {
            if (item.getFromAirport().equals(from) || item.getToAirport().equals(to)) {
                TicketsService[] tmp = new TicketsService[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
