package pl.analyzeapi.analyzeapi.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapUtils {

    public static <K, V, T extends Collection <V>> void putOrUpdateCollections(Map <K, T> map , K key , T values) {
        if ( map.containsKey(key) ) {
            T currentValues = map.get(key);
            currentValues.addAll(values);
        } else {
            map.put(key , values);
        }
    }

}
