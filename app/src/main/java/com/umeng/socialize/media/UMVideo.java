package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UMVideo extends BaseMediaObject {

    /* JADX INFO: renamed from: f */
    private String f8305f;

    /* JADX INFO: renamed from: g */
    private String f8306g;

    /* JADX INFO: renamed from: h */
    private String f8307h;

    /* JADX INFO: renamed from: i */
    private String f8308i;

    /* JADX INFO: renamed from: j */
    private int f8309j;

    /* JADX INFO: renamed from: k */
    private File f8310k;

    public UMVideo(String str) {
        super(str);
    }

    public int getDuration() {
        return this.f8309j;
    }

    public String getH5Url() {
        return this.f8308i;
    }

    public String getHighBandDataUrl() {
        return this.f8307h;
    }

    public File getLocalVideoFile() {
        return this.f8310k;
    }

    public String getLowBandDataUrl() {
        return this.f8306g;
    }

    public String getLowBandUrl() {
        return this.f8305f;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.VEDIO;
    }

    public void setDuration(int i2) {
        this.f8309j = i2;
    }

    public void setH5Url(String str) {
        this.f8308i = str;
    }

    public void setHighBandDataUrl(String str) {
        this.f8307h = str;
    }

    public void setLowBandDataUrl(String str) {
        this.f8306g = str;
    }

    public void setLowBandUrl(String str) {
        this.f8305f = str;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        UMImage uMImage = this.f8275e;
        if (uMImage != null) {
            return uMImage.toByte();
        }
        return null;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public String toString() {
        return "UMVedio [media_url=" + this.a + ", qzone_title=" + this.f8272b + ", qzone_thumb=media_url=" + this.a + ", qzone_title=" + this.f8272b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap map = new HashMap();
        if (isUrlMedia()) {
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.a);
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
        }
        return map;
    }

    public UMVideo(File file) {
        this.f8310k = file;
    }
}
