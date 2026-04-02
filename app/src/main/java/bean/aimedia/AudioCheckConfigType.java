package bean.aimedia;

import java.util.List;
import network.BaseBean;

/* JADX INFO: loaded from: classes.dex */
public class AudioCheckConfigType extends BaseBean {
    private int audioMaxTime;
    private int audioMinTime;
    private List<String> formatSuffix;
    private int maxSize;
    private int minSize;

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

    public int getaudioMaxTime() {
        return this.audioMaxTime;
    }

    public int getaudioMinTime() {
        return this.audioMinTime;
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

    public void setaudioMaxTime(int i2) {
        this.audioMaxTime = i2;
    }

    public void setaudioMinTime(int i2) {
        this.audioMinTime = i2;
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
}
