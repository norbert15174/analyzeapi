package pl.analyzeapi.analyzeapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.analyzeapi.analyzeapi.model.Word;

import java.util.Set;

@Repository
public interface IWordRepository extends JpaRepository <Word, Long> {

    @Query("select w from word w where w.name in :names")
    Set <Word> findAllByNames(Set <String> names);

    @Query("select w from word w where w.name = :name")
    Page <Word> findAllByName(String name , Pageable pageable);
}
