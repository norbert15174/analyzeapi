package pl.analyzeapi.analyzeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.analyzeapi.analyzeapi.model.Fragment;

import java.util.List;
import java.util.Set;

public interface IFragmentRepository extends JpaRepository <Fragment, Long> {

    @Query("select f from fragment f inner join fetch f.words where f.uuid = :uuid")
    Set <Fragment> findAllByUUIDWithWords(String uuid);


}
