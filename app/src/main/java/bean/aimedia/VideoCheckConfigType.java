package bean.aimedia;

import java.util.List;
import network.BaseBean;

/* JADX INFO: loaded from: classes.dex */
public class VideoCheckConfigType extends BaseBean {
    private List<String> formatSuffix;
    private int maxSize;
    private int minSize;
    private int videoMinTime;
    private int videoMinWidth;

    public String getMaxSizeMb() {
        int i2 = this.maxSize;
        if (i2 < 1024) {
            return this.maxSize + "KB";
        }
        return (i2 / 1024) + "MB";
    }

    public String getMinSizeMb() {
        int i2 = this.minSize;
        if (i2 < 1024) {
            return this.minSize + "KB";
        }
        return (i2 / 1024) + "MB";
    }

    public List<String> getformatSuffix() {
        return this.formatSuffix;
    }

    public int getmaxSize() {
        return this.maxSize;
    }

    public int getminSize() {
        return this.minSize;
    }

    public int getvideoMinTime() {
        return this.videoMinTime;
    }

    public int getvideoMinWidth() {
        return this.videoMinWidth;
    }

    public void setformatSuffix(List<String> list) {
        this.formatSuffix = list;
    }

    public void setmaxSize(int i2) {
        this.maxSize = i2;
    }

    public void setminSize(int i2) {
        this.minSize = i2;
    }

    public void setvideoMinTime(int i2) {
        this.videoMinTime = i2;
    }

    public void setvideoMinWidth(int i2) {
        this.videoMinWidth = i2;
    }
}
