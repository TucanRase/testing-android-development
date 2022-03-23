package tucanrase.personal.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import tucanrase.personal.project.databinding.ActivityTestBinding;
import tucanrase.personal.project.fragments.HomeFragment;
import tucanrase.personal.project.fragments.SearchFragment;

public class ActivityTest extends AppCompatActivity {
ActivityTestBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new SearchFragment());

        binding.bottomNavBar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.searchNav:
                    replaceFragment(new SearchFragment());
                    break;
                case R.id.homeNav:
                    replaceFragment(new HomeFragment());
                    break;
            }

            return true;
        });
    }

    public void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }
}