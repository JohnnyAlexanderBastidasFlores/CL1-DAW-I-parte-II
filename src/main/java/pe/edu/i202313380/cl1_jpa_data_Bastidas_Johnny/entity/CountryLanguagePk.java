package pe.edu.i202313380.cl1_jpa_data_Bastidas_Johnny.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguagePk {

    @Column(name = "CountryCode")
    private String countrycode;

    @Column(name = "Language")
    private String Language;
}
