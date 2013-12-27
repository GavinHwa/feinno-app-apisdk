package thirdparty.renren.renrenAPIv2;

/**
 * 图片
 */
public class Image {

    /**
     * 图片的大小。eg:TINY
     */
    private ImageSize size;
    /**
     * 图片的URL eg:http://hdn.xnimg.cn/photos/hdn421/20110725/1145/tiny_fYru_144030h019117.jpg
     */
    private String url;

    public void setSize(ImageSize size) {
        this.size = size;
    }

    public ImageSize getSize() {
        return this.size;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}