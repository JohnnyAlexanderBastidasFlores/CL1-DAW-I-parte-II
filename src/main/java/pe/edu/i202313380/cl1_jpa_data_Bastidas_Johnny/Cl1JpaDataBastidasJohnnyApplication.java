package pe.edu.i202313380.cl1_jpa_data_Bastidas_Johnny;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pe.edu.i202313380.cl1_jpa_data_Bastidas_Johnny.entity.Country;
import pe.edu.i202313380.cl1_jpa_data_Bastidas_Johnny.repository.CountryRepository;

import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataBastidasJohnnyApplication implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(Cl1JpaDataBastidasJohnnyApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // Buscar los lenguajes del país "ARG" (Argentina)
        Optional<Country> argentina = countryRepository.findById("ARG");

        // Imprimir los lenguajes si se encuentra "ARG", de lo contrario, imprimir los de "PER"
        argentina.ifPresentOrElse(
                country -> {
                    System.out.println("Lenguajes hablados en Argentina:");
                    country.getLanguages().forEach(language -> System.out.println(language.getCountryLanguagePk().getLanguage()));
                },
                () -> {
                    // Si no se encuentra, buscar "PER" (Perú)
                    Optional<Country> peru = countryRepository.findById("PER");
                    peru.ifPresent(country -> {
                        System.out.println("Lenguajes hablados en Perú:");
                        country.getLanguages().forEach(language -> System.out.println(language.getCountryLanguagePk().getLanguage()));
                    });
                }
        );
    }
}
