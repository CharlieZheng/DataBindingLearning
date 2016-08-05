package com.cndatacom.databindinglearning.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cndatacom.databindinglearning.R;
import com.cndatacom.databindinglearning.databinding.ActivityMainBinding;
import com.cndatacom.databindinglearning.entity.User;

/**
 * Created by Charlie on 2016/8/4.
 */
public class BasicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = android.databinding.DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("Zheng", "Charlie");
        binding.setUser(user);
    }
}
