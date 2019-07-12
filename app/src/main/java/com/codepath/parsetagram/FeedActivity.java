package com.codepath.parsetagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.codepath.parsetagram.model.Post;

import java.io.Serializable;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    private List<Post> mPosts;

    ImageButton ibBack;
    ImageButton ibSettings;
    ImageButton ibHome;
    ImageButton ibProfile;
    ImageButton ibAdd;
    ImageButton ibProfileView;
    public FeedFragment feedFragment;
    public AddPhotoFragment addPhotoFragment;
    public ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        ibAdd = (ImageButton) findViewById(R.id.ibAdd);
        ibHome = (ImageButton) findViewById(R.id.ibHome);
        ibBack = (ImageButton) findViewById(R.id.ibBack);
        ibProfile = (ImageButton) findViewById(R.id.ibProfile);
        ibSettings = (ImageButton) findViewById(R.id.ibSettings);
        ibProfileView = (ImageButton) findViewById(R.id.ibProfilePic);

        ibHome.setImageResource(R.drawable.instagram_home_filled_24);

        feedFragment = new FeedFragment();
        addPhotoFragment = new AddPhotoFragment();
        profileFragment = new ProfileFragment();

        Fragment fragment = feedFragment;

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.FragmentPlace, fragment);

        ft.commit();

    }


    public void changeFragment(View view){
        Fragment fragment;

        if (view == findViewById(R.id.ibHome) || view == findViewById(R.id.ibBack)) {

            ibAdd.setImageResource(R.drawable.instagram_new_post_outline_24);
            ibHome.setImageResource(R.drawable.instagram_home_filled_24);
            ibProfile.setImageResource(R.drawable.instagram_user_outline_24);
            ibSettings.setImageResource(R.drawable.ufi_save);

            fragment = feedFragment;

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.FragmentPlace, fragment);

            ft.commit();


        } else if (view == findViewById(R.id.ibAdd)) {

            ibAdd.setImageResource(R.drawable.instagram_new_post_filled_24);
            ibHome.setImageResource(R.drawable.instagram_home_outline_24);
            ibProfile.setImageResource(R.drawable.instagram_user_outline_24);
            ibSettings.setImageResource(R.drawable.ufi_save);

            fragment = addPhotoFragment;

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.FragmentPlace, fragment);

            ft.commit();

        } else if (view == findViewById(R.id.ibProfile) || view == findViewById(R.id.ibProfilePic)) {


            ibAdd.setImageResource(R.drawable.instagram_new_post_outline_24);
            ibHome.setImageResource(R.drawable.instagram_home_outline_24);
            ibProfile.setImageResource(R.drawable.instagram_user_filled_24);
            ibSettings.setImageResource(R.drawable.ufi_save);

            fragment = profileFragment;

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.FragmentPlace, fragment);

            ft.commit();

        } else if (view == findViewById(R.id.ibSettings)) {


            ibAdd.setImageResource(R.drawable.instagram_new_post_outline_24);
            ibHome.setImageResource(R.drawable.instagram_home_outline_24);
            ibProfile.setImageResource(R.drawable.instagram_user_outline_24);
            ibSettings.setImageResource(R.drawable.ufi_save_active);

            fragment = profileFragment;

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.FragmentPlace, fragment);

            ft.commit();
        }



    }


    public void showDetailsFor(Serializable post) {
        // create intent for the new activity
        Intent intent = new Intent(this, PostDetailsActivity.class);
        // serialize the post using parceler, use its short name as a key
        intent.putExtra(Post.class.getSimpleName(), (Serializable) post);
        // show the activity
        startActivityForResult(intent,123);
    }

    public void showProfileFragment(Post post) {
        Fragment fragment;

        ibAdd.setImageResource(R.drawable.instagram_new_post_outline_24);
        ibHome.setImageResource(R.drawable.instagram_home_outline_24);
        ibProfile.setImageResource(R.drawable.instagram_user_filled_24);
        ibSettings.setImageResource(R.drawable.ufi_save);

        fragment = profileFragment;

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.FragmentPlace, fragment);

        ft.commit();
    }
}
