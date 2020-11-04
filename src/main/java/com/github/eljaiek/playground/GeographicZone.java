package com.github.eljaiek.playground;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "GEOGRAPHIC_ZONE")
public class GeographicZone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geo_zone_sequence")
    @SequenceGenerator(name = "geo_zone_sequence", sequenceName = "geo_zone_id_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    public GeographicZone(String name) {
        this.name = name;
    }
}