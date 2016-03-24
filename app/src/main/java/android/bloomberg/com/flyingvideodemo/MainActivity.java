package android.bloomberg.com.flyingvideodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private boolean mVideoPlayerVisible = false;
    private FlyingVideoPlayer mFlyingVideoPlayer = null;
    private VideoListAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFlyingVideoPlayer = (FlyingVideoPlayer)findViewById(R.id.flyingVideoPlayer);
        mFlyingVideoPlayer.setVisibility(View.GONE);
        ListView videoList = (ListView)findViewById(R.id.listView);
        videoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("ME", "Item " + i + " clicked!");
                if (!mVideoPlayerVisible) {
                    mFlyingVideoPlayer.setVisibility(View.VISIBLE);
                    mVideoPlayerVisible = true;
                }
                VideoItem video = (VideoItem)mAdapter.getItem(i);
                mFlyingVideoPlayer.playVideo(video);
            }
        });
        mAdapter = new VideoListAdapter();
        videoList.setAdapter(mAdapter);
    }
}
