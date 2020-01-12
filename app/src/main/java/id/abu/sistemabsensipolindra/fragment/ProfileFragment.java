package id.abu.sistemabsensipolindra.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import id.abu.sistemabsensipolindra.R;
import id.abu.sistemabsensipolindra.activity.LoginActivity;
import id.abu.sistemabsensipolindra.helper.SharedPrefManager;


public class ProfileFragment extends Fragment implements View.OnClickListener {

    Button btnLogout;
    TextView textNama;

    public ProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        btnLogout = rootView.findViewById(R.id.btnLogout);
        textNama = rootView.findViewById(R.id.textNama);
        btnLogout.setOnClickListener(this);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("sistemabsensipolindra", Context.MODE_PRIVATE);
        textNama.setText(sharedPreferences.getString("keyusername", "null"));
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController =
                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
    }

    @Override
    public void onClick(View v) {
        SharedPrefManager.getInstance(getActivity()).logout();
        getActivity().finish();
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }
}