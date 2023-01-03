package pl.analyzeapi.analyzeapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String positions;
    private Integer count;
    @ManyToMany(mappedBy = "words", fetch = FetchType.LAZY)
    private Set <Fragment> fragments = new HashSet <>();

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Word word = (Word) o;
        return Objects.equals(name , word.name) && Objects.equals(positions , word.positions) && Objects.equals(count , word.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name , positions , count);
    }

    public List <Integer> getPositionsAsIntegerArray() {
        return Stream.of(positions.split(",")).map(Integer::valueOf).sorted().collect(Collectors.toList());
    }
}
