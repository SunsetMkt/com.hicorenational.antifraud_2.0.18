package bean.aimedia;

import network.BaseBean;

/* JADX INFO: loaded from: classes.dex */
public class AiMedia extends BaseBean {
    private AudioCheckConfigType audioCheckConfig;
    private ImageCheckConfigType imageCheckConfig;
    private TextCheckConfigType textCheckConfig;
    private VideoCheckConfigType videoCheckConfig;

    public AudioCheckConfigType getaudioCheckConfig() {
        return this.audioCheckConfig;
    }

    public ImageCheckConfigType getimageCheckConfig() {
        return this.imageCheckConfig;
    }

    public TextCheckConfigType gettextCheckConfig() {
        return this.textCheckConfig;
    }

    public VideoCheckConfigType getvideoCheckConfig() {
        return this.videoCheckConfig;
    }

    public void setaudioCheckConfig(AudioCheckConfigType audioCheckConfigType) {
        this.audioCheckConfig = audioCheckConfigType;
    }

    public void setimageCheckConfig(ImageCheckConfigType imageCheckConfigType) {
        this.imageCheckConfig = imageCheckConfigType;
    }

    public void settextCheckConfig(TextCheckConfigType textCheckConfigType) {
        this.textCheckConfig = textCheckConfigType;
    }

    public void setvideoCheckConfig(VideoCheckConfigType videoCheckConfigType) {
        this.videoCheckConfig = videoCheckConfigType;
    }
}
