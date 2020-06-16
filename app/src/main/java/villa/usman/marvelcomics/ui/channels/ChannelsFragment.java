package villa.usman.marvelcomics.ui.channels;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import villa.usman.marvelcomics.R;

public class ChannelsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_photos, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        textView.setText("This is channels fragment");
        return root;
    }
}