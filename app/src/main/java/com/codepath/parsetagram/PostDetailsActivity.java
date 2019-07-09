package com.codepath.parsetagram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.parsetagram.model.Post;

public class PostDetailsActivity extends AppCompatActivity {

    // the movie to display
    Post post;

    // the view objects
    ImageView ivImage;
    TextView tvUser;
    TextView tvDescription;
    ImageView imageView3;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        // resolve the view objects
        ivImage = (ImageView) findViewById(R.id.ivImage);
        tvUser = (TextView) findViewById(R.id.tvUser);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        tvDate = (TextView) findViewById(R.id.tvDate);

        // unwrap the movie passed in via intent, using its simple name as a key
        post = (Post) getIntent().getParcelableExtra(Post.class.getSimpleName());
        Log.d("PostDetailsActivity", String.format("Showing details for '%s'", post.getDescription()));

        tvDescription.setText(post.getDescription());

    }
}
