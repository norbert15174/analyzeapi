package pl.analyzeapi.analyzeapi.creator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.analyzeapi.analyzeapi.model.Fragment;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FragmentCreator {

    public static Fragment build(String text , String uuid) {
        var fragment = new Fragment();
        fragment.setUuid(uuid);
        fragment.setText(text);
        return fragment;
    }

}
