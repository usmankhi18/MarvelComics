package villa.usman.marvelcomics.ui.logout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import villa.usman.marvelcomics.LoginActivity;
import villa.usman.marvelcomics.R;
import villa.usman.marvelcomics.common.Constants;

public class LogoutFragment extends Fragment {
    SharedPreferences sharedpreferences;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_logout, container, false);
        sharedpreferences = getActivity().getSharedPreferences(Constants.ProfilePREFERENCES, Context.MODE_PRIVATE);
        sharedpreferences.edit().clear().commit();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
        return root;
    }
}