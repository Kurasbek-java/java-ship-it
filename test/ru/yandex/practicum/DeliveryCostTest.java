package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryCostTest {

    @Test
    public void shouldReturn30WhenStandardParcelAndWeightIs15() {
        StandardParcel standardParcel = new StandardParcel("Камни", 15, "Astana", 18);
        assertEquals(30, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldReturn15WhenFragileParcelAndWeightIs5() {
        FragileParcel fragileParcel = new FragileParcel("Стекло", 5, "Astana", 18);
        assertEquals(15, fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldReturn100WhenPerishableParcelAndWeightIs25() {
        PerishableParcel perishableParcel = new PerishableParcel("Яица", 25, "Astana", 18, 5);
        assertEquals(100, perishableParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldReturnTrueWhenPerishableParcelWithLimitValues() {
        PerishableParcel perishableParcel = new PerishableParcel("Яица", 25, "Astana", 12, 5);
        assertTrue(perishableParcel.isExpired(18));
    }

    @Test
    public void shouldReturnTrueWhenPerishableParcel() {
        PerishableParcel perishableParcel = new PerishableParcel("Яица", 25, "Astana", 12, 5);
        assertTrue(perishableParcel.isExpired(20));
    }

    @Test
    public void shouldReturnFalseWhenPerishableParcelWithLimitValues() {
        PerishableParcel perishableParcel = new PerishableParcel("Яица", 25, "Astana", 12, 5);
        assertFalse(perishableParcel.isExpired(17));
    }

    @Test
    public void shouldReturnFalseWhenPerishableParcel() {
        PerishableParcel perishableParcel = new PerishableParcel("Яица", 25, "Astana", 12, 5);
        assertFalse(perishableParcel.isExpired(14));
    }

    @Test
    public void checkMaxWeightOfParcelBox() {
        ParcelBox<StandardParcel> standardParcelParcelBox = new ParcelBox<>(20);
        StandardParcel standardParcel = new StandardParcel("Камни", 15, "Astana", 18);

        standardParcelParcelBox.addParcel(standardParcel);
        assertEquals(1, standardParcelParcelBox.getSize());

        StandardParcel standardParcel1 = new StandardParcel("Книги", 5, "Astana", 18);
        standardParcelParcelBox.addParcel(standardParcel1);
        assertEquals(2, standardParcelParcelBox.getSize());

        StandardParcel standardParcel2 = new StandardParcel("Мяч", 1, "Astana", 18);
        standardParcelParcelBox.addParcel(standardParcel2);
        assertEquals(2, standardParcelParcelBox.getSize());

    }
}
