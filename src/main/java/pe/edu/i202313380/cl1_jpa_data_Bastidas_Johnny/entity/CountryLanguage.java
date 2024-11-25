package pe.edu.i202313380.cl1_jpa_data_Bastidas_Johnny.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguagePk countryLanguagePk;

    @Column(name = "IsOfficial")
    private String isofficial;

    @Column(name = "Percentage")
    private Double Porcentagem;

    @ManyToOne
    @JoinColumn(name = "CountryCode")
    @MapsId("countrycode")
    private Country country;
}
