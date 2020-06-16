package villa.usman.marvelcomics.ui.photos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import villa.usman.marvelcomics.R;

public class PhotosFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_photos, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        textView.setText("This is photos fragment");
        return root;
    }
}
