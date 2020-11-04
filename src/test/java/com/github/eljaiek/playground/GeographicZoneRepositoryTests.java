package com.github.eljaiek.playground;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
@ActiveProfiles("local")
class GeographicZoneRepositoryTests {

    @Autowired GeographicZoneRepository geographicZoneRepository;

    @Test
    void findAllShouldReturnImportedDataAfterStartup() {
        // When
        var actualZones = geographicZoneRepository.findAll().
                stream()
                .map(GeographicZone::getName)
                .collect(Collectors.toList());

        // Then
        assertThat(actualZones).contains("AFRICA", "EUROPE");
    }
}

