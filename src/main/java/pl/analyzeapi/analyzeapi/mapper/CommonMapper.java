package pl.analyzeapi.analyzeapi.mapper;

import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.analyzeapi.analyzeapi.utils.MapUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonMapper {

    public static Map <String, Set <Integer>> positionsByWord(String[] words) {
        Map <String, Set <Integer>> positionByWord = new HashMap <>();
        for (int i = 0; i < words.length; i++) {
            MapUtils.putOrUpdateCollections(positionByWord , words[i] , Sets.newHashSet(1 + i));
        }
        return positionByWord;
    }

}
