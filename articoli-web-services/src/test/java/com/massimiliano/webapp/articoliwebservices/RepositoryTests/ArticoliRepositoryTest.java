package com.massimiliano.webapp.articoliwebservices.RepositoryTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.massimiliano.webapp.Application;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.massimiliano.webapp.entities.Articoli;
import com.massimiliano.webapp.entities.Barcode;
import com.massimiliano.webapp.entities.FamAssort;
import com.massimiliano.webapp.repository.ArticoliRepository;

@SpringBootTest()
@ContextConfiguration(classes = Application.class)
@TestMethodOrder(OrderAnnotation.class)
public class ArticoliRepositoryTest {

    @Autowired
    ArticoliRepository articoliRepository;

    @Test
    @Order(1)
    public void TestInsArticolo() {
        Articoli articolo = new Articoli("123Test", "Articolo di Test", 6, 1.75, "1");

        FamAssort famAssort = new FamAssort();
        famAssort.setId(1);
        articolo.setFamAssort(famAssort);

        Set<Barcode> Eans = new HashSet<>();
        Eans.add(new Barcode(articolo, "12345678", "CP"));

        articolo.setBarcode(Eans);

        articoliRepository.save(articolo);

        assertThat(articoliRepository.findByCodArt("123Test"))
                .extracting(Articoli::getDescrizione)
                .isEqualTo("Articolo di Test");
    }

    @Test
    @Order(2)
    public void TestSelByDescrizioneLike() {
        List<Articoli> items = articoliRepository.findByDescrizioneLike("Articolo di Test");
        assertEquals(1, items.size());
    }

    @Test
    @Order(3)
    public void TestfindByEan() throws Exception {
        assertThat(articoliRepository.SelByEan("12345678"))
                .extracting(Articoli::getDescrizione)
                .isEqualTo("Articolo di Test");

    }

    @Test
    @Order(4)
    public void TestDelArticolo() {
        Articoli articolo = articoliRepository.findByCodArt("123Test");

        articoliRepository.delete(articolo);

    }

}
