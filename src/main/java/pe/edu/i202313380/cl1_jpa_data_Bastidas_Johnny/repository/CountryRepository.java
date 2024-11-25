package pe.edu.i202313380.cl1_jpa_data_Bastidas_Johnny.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pe.edu.i202313380.cl1_jpa_data_Bastidas_Johnny.entity.Country;
import pe.edu.i202313380.cl1_jpa_data_Bastidas_Johnny.entity.CountryLanguage;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, String> {

    // Método para encontrar un país por su nombre
    List<Country> findByName(String name);

    // Consulta personalizada para obtener los idiomas de un país
    @Query("SELECT cl FROM CountryLanguage cl WHERE cl.country.code = :countryCode")
    List<CountryLanguage> findLanguagesByCountryCode(@Param("countryCode") String countryCode);

    // Consulta personalizada para encontrar países por continente
    @Query("SELECT c FROM Country c WHERE c.continent = :continent")
    List<Country> findByContinent(@Param("continent") String continent);
    }
