package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> addresses = profiles.stream()
                .map(profile -> profile.getAddress())
                .collect(Collectors.toList());
        Comparator<Address> comparator = Comparator.comparing(Address::getCity);
        return addresses.stream().sorted(comparator).distinct().collect(Collectors.toList());
    }
}
