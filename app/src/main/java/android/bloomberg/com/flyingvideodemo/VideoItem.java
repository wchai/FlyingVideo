package android.bloomberg.com.flyingvideodemo;

/**
 * Created by wchai1 on 3/24/16.
 */
public class VideoItem {
    public VideoItem(String name, String desc, String url, String thumbnailUrl) {
        mName = name;
        mDesc = desc;
        mUrl = url;
        mThumbnailUrl = thumbnailUrl;
    }
    public String mName;
    public String mDesc;
    public String mUrl;
    public String mThumbnailUrl;
}

