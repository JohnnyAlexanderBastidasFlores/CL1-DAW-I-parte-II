package pe.edu.i202313380.cl1_jpa_data_Bastidas_Johnny.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "CountryCode", insertable = false, updatable = false)
    private String countryCode;

    @Column(name = "District")
    private String district;

    @Column(name = "Population")
    private Integer population;

    @ManyToOne
    @JoinColumn(name = "country_code", insertable = false, updatable = false)
    private Country country;

}
