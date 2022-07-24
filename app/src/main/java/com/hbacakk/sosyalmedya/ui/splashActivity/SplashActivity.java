package com.hbacakk.sosyalmedya.ui.splashActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.hbacakk.sosyalmedya.R;
import com.hbacakk.sosyalmedya.databinding.ActivitySplashBinding;
import com.hbacakk.sosyalmedya.ui.main.MainActivity;
import com.hbacakk.sosyalmedya.utilities.Constants;
import com.hbacakk.sosyalmedya.utilities.PreferenceManager;
import com.hbacakk.sosyalmedya.viewmodels.MainViewModel;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding splashBinding;
    OnboardingAdapter onboardingAdapter;

    MainViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashBinding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(splashBinding.getRoot());

        initialize();

    }

    private void initialize() {
        //region: Main ViewModel
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        //endregion
        //region: Listener
        listener();
        //endregion
        // region: setupOnBoardingItems
        setupOnBoardingItems();
        //endregion
        // region: setupIndicators
        setupIndicators();
        setCurrentOnBoardingIndicators(0);
        //endregion
        // region: registerOnPageChangeCallback
        splashBinding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnBoardingIndicators(position);

                if (position % 2 == 1) {
                    splashBinding.imageViewNext.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.background_button_next));
                    splashBinding.textViewNext.setTextColor(getResources().getColor(R.color.white));
                    splashBinding.imageViewArrow.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white));
                } else {
                    splashBinding.imageViewNext.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.background_button_next_2));

                    splashBinding.textViewNext.setTextColor(getResources().getColor(R.color.black));
                    splashBinding.imageViewArrow.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.black));
                }
            }
        });
        //endregion

        new PreferenceManager(this).putBoolean(Constants.SHOW_IS_SPLASH_SCREEN, true);
    }

    private void setupIndicators() {
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(4, 0, 4, 0);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                    R.drawable.indicator_inactive));
            indicators[i].setLayoutParams(layoutParams);
            splashBinding.linearLayoutIndicators.addView(indicators[i]);
        }

    }

    private void setupOnBoardingItems() {
        onboardingAdapter = new OnboardingAdapter(mainViewModel.getOnBoardingItems());
        splashBinding.viewPager.setAdapter(onboardingAdapter);
    }

    private void setCurrentOnBoardingIndicators(int index) {
        int childCount = splashBinding.linearLayoutIndicators.getChildCount();

        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) splashBinding.linearLayoutIndicators.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                        R.drawable.indicator_active));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                        R.drawable.indicator_inactive));
            }
        }
    }

    private void listener() {
        splashBinding.imageViewNext.setOnClickListener(view -> {
            if (splashBinding.viewPager.getCurrentItem() + 1 < onboardingAdapter.getItemCount()) {
                splashBinding.viewPager.setCurrentItem(splashBinding.viewPager.getCurrentItem() + 1);
            } else {
                startActivity(new Intent(getApplicationContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
            }

        });
    }
}