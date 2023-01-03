package pl.analyzeapi.analyzeapi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "fragment")
public class Fragment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String text;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "fragment_word",
            joinColumns = @JoinColumn(name = "fragment_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "word_id", referencedColumnName = "id"))
    private Set <Word> words = new HashSet <>();

    public void addWord(Word word) {
        this.words.add(word);
        word.getFragments().add(this);
    }

    public boolean hasWords() {
        return !words.isEmpty();
    }
}
