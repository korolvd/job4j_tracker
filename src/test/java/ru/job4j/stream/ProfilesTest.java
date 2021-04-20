package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Lenin street", 15, 8)),
                new Profile(new Address("Voronej", "Moscow street", 105, 18)),
                new Profile(new Address("Piter", "K. Marks street", 3, 56)),
                new Profile(new Address("Ijevsk", "Green street", 232, 72))
        );
        Profiles pf = new Profiles();
        List<Address> rsl = pf.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Lenin street", 15, 8));
        expected.add(new Address("Voronej", "Moscow street", 105, 18));
        expected.add(new Address("Piter", "K. Marks street", 3, 56));
        expected.add(new Address("Ijevsk", "Green street", 232, 72));
        assertThat(rsl, is(expected));
    }
}