package javapro.repository;

import javapro.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country findByName(String name);

    @Query("select c " +
            "from Country c " +
            "WHERE c.name = :country ")
    Page<Country> findOne(Pageable pageable , @Param("country") String country);

    @Override
    Page<Country> findAll(Pageable pageable);

    List<Country> findAll();
}
