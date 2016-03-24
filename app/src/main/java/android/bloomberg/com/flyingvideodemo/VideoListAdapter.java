package android.bloomberg.com.flyingvideodemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by wchai1 on 3/24/16.
 */
public class VideoListAdapter extends BaseAdapter {

    private static final String TEST_VIDEO_URL = //"http://cdn-mobapi.bloomberg.com/mobapi/v2/android/media/video/cc/3G/376Xa7cAQVmS571BLUk4iA.m3u8";
//     "http://wpc.17155.phicdn.net/8017155/p/m/NjcxODM5Mw/5ZX78MJ6sJOG6hTBMf94FcVa_P_rAxvkkizXiO5FoxxiYjZk/DMD160324Ssbc_700.mp4";
    "http://bbgvod-mmd-cust.lldns.net/m/NjcxODM5Mw/5ZX78MJ6sJOG6hTBMf94FcVa_P_rAxvkkizXiO5FoxxiYjZk/DMD160324Ssbc_240.mp4";

    private ArrayList<VideoItem> mVideos = new ArrayList<VideoItem>();

    public VideoListAdapter() {

        VideoItem video = new VideoItem(
                "The Mad Scientist Who Wants to Save the World",
                "Mar. 23 -- Sir Avery is a self taught inventor, who's invented mostly medical equipment that he's made drastically cheaper and available to third world countries. ",
                "http://wpc.17155.phicdn.net/8017155/p/m/NjcxNDQ1MQ/FbwZIOqAoia84xmOL6AjndrSiXd0Y5gWIHn6IgL37qU2N2Nm/digi_16_03_18_HWNZAVERY_digital_700.mp4",
                "http://assets.bwbx.io/images/i7a.VVMcF0Cg/v5/640x-1.jpg"
        );
        mVideos.add(video);

        video = new VideoItem(
                "An Inside Look at Citi's Secret Client List",
                "March 24 -- There’s a secret list that Citigroup keeps on its equity-research desk at its swank campus in Tribeca. And if you’re not on it -- well, you might as well be nobody. At the top is a handful of hedge-fund giants, the \"Focus Five,\" that bring in big money for Citigroup: Millennium, Citadel, Surveyor Capital, Point72 and Carlson Capital, according to a person with direct knowledge of the list. Bloomberg's Laura Keller has more on \"Bloomberg Markets.\"",
                "http://wpc.17155.phicdn.net/8017155/p/m/NjcxODYwOQ/f5hEiUssg2rzoqIZFHvmPcOKhmvP48LqdtUHpe9evDlmMTQw/dmd160324bmlk_700.mp4",
                "http://www.bloomberg.com/image/iBXVxRPcPNho.jpg"
        );
        mVideos.add(video);

        video = new VideoItem(
                "Trump Leads GOP Field in Bloomberg Politics Poll",
                "Mar 23 -- Mark Halperin and John Heilemann discuss a Bloomberg Politics national poll and the Republican presidential candidates’ chances on “With All Due Respect.”",
                "http://wpc.17155.phicdn.net/8017155/p/m/NjcxNzYyMw/K0rCipKDZYlpbN6HFvsAxH_EhPMqpWYxrM0kzvsZTDUzYjU3/dmdwadra032316_700.mp4",
                "http://assets.bwbx.io/images/ikGxwTtuXh9Q/v5/628x-1.jpg"
        );
        mVideos.add(video);

        video = new VideoItem(
                "Five Countries, Five Beleaguered Leaders",
                "March 24 -- Scandals, turbulent economies, tarnished legacies or simply uncertain futures: It’s testing times for the leaders of some of the world’s most prominent countries. Bloomberg's Tony Czuczka and Toluse Olorunnipa report on \"Bloomberg Markets.\"",
                "http://bbgvod-mmd-cust.lldns.net/m/NjcxODU5OQ/2WhqNtg.QABdKaPzcyp0kwRAI8dzPdwxki4V77PJTKc4MTMx/dmd160324bmtc_700.mp4",
                "http://www.bloomberg.com/image/i.VX2kipRoA0.jpg"
        );
        mVideos.add(video);

        video = new VideoItem(
                "Honda Shows Off Its Sporty Side With New MDX",
                "March 24 -- American Honda Executive Vice President John Mendel discusses the company's new models. He speaks from the New York International Auto Show on \"Bloomberg Markets.\"",
                "http://wpc.17155.phicdn.net/8017155/p/m/NjcxODU4OQ/nBt1syyuxVQ_Bg8jeaNHkM_SGkSg5nyfXrCrgG0jUARlMDFl/dmd160324bmjm_700.mp4",
                "http://www.bloomberg.com/image/iBDsT5FzjKBU.jpg"
        );
        mVideos.add(video);

        mVideos.add(new VideoItem("Testing video #1", "Desc of testing video #1", TEST_VIDEO_URL,  null));
        mVideos.add(new VideoItem("Testing video #2", "Desc of testing video #2", TEST_VIDEO_URL,  null));
        mVideos.add(new VideoItem("Testing video #3", "Desc of testing video #3", TEST_VIDEO_URL,  null));
        mVideos.add(new VideoItem("Testing video #4", "Desc of testing video #4", TEST_VIDEO_URL,  null));
        mVideos.add(new VideoItem("Testing video #5", "Desc of testing video #5", TEST_VIDEO_URL,  null));
        mVideos.add(new VideoItem("Testing video #6", "Desc of testing video #6", TEST_VIDEO_URL,  null));
        mVideos.add(new VideoItem("Testing video #7", "Desc of testing video #7", TEST_VIDEO_URL,  null));
        mVideos.add(new VideoItem("Testing video #8", "Desc of testing video #8", TEST_VIDEO_URL,  null));
        mVideos.add(new VideoItem("Testing video #9", "Desc of testing video #9", TEST_VIDEO_URL,  null));
        mVideos.add(new VideoItem("Testing video #10", "Desc of testing video #10", TEST_VIDEO_URL,  null));
        mVideos.add(new VideoItem("Testing video #11", "Desc of testing video #11", TEST_VIDEO_URL,  null));
    }

    @Override
    public int getCount() {
        return mVideos.size();
    }

    @Override
    public Object getItem(int pos) {
        if (pos >= 0 && pos < mVideos.size()) {
            return mVideos.get(pos);
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int pos) {
        return (long)pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list_item, null);
        }
        VideoItem video = mVideos.get(pos);
        TextView desc = (TextView)convertView.findViewById(R.id.video_desc);
        desc.setText(mVideos.get(pos).mName);
        ImageView thumbnail = (ImageView) convertView.findViewById(R.id.thumbnail);
        if (video.mThumbnailUrl != null) {
            thumbnail.setTag(video.mThumbnailUrl);
            thumbnail.setVisibility(View.INVISIBLE);
            TaskArg arg = new TaskArg();
            arg.imageView = thumbnail;
            arg.imageUrl = video.mThumbnailUrl;
            new DownloadImagesTask().execute(arg);
        } else {
            thumbnail.setVisibility(View.GONE);
        }
        return convertView;
    }

    public class TaskArg {
        public ImageView imageView;
        public String imageUrl;
    }

    public class DownloadImagesTask extends AsyncTask<TaskArg, Void, Bitmap> {

        WeakReference<ImageView> imageView = null;

        @Override
        protected Bitmap doInBackground(TaskArg... args) {
            TaskArg arg = args[0];
            ImageView view = arg.imageView;
            imageView = new WeakReference<ImageView>(view);
            return download_Image(arg.imageUrl);
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            if (imageView.get() != null) {
                if (result != null) {
                    imageView.get().setImageBitmap(result);
                    imageView.get().setVisibility(View.VISIBLE);
                } else {
                    imageView.get().setVisibility(View.GONE);
                }
            }
        }

        private Bitmap download_Image(String url) {
            Bitmap bmp = null;
            URL imgUrl;
            try {
                imgUrl = new URL(url);
                bmp = BitmapFactory.decodeStream(imgUrl.openConnection().getInputStream());
                return bmp;
            } catch (Exception e) {
                Log.e("BMP", "Loading thumbnail excp: " + e.toString());
                return null;
            }
        }
    }
}
