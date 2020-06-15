package villa.usman.marvelcomics.ui.characters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import villa.usman.marvelcomics.R;

public class CharactersFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_characters, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        textView.setText("This is characters fragment");
        return root;
    }
}
