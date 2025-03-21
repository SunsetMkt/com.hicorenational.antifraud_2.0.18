package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class UMVideo extends BaseMediaObject {

    /* renamed from: f */
    private String f13675f;

    /* renamed from: g */
    private String f13676g;

    /* renamed from: h */
    private String f13677h;

    /* renamed from: i */
    private String f13678i;

    /* renamed from: j */
    private int f13679j;

    /* renamed from: k */
    private File f13680k;

    public UMVideo(String str) {
        super(str);
    }

    public int getDuration() {
        return this.f13679j;
    }

    public String getH5Url() {
        return this.f13678i;
    }

    public String getHighBandDataUrl() {
        return this.f13677h;
    }

    public File getLocalVideoFile() {
        return this.f13680k;
    }

    public String getLowBandDataUrl() {
        return this.f13676g;
    }

    public String getLowBandUrl() {
        return this.f13675f;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.VEDIO;
    }

    public void setDuration(int i2) {
        this.f13679j = i2;
    }

    public void setH5Url(String str) {
        this.f13678i = str;
    }

    public void setHighBandDataUrl(String str) {
        this.f13677h = str;
    }

    public void setLowBandDataUrl(String str) {
        this.f13676g = str;
    }

    public void setLowBandUrl(String str) {
        this.f13675f = str;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        UMImage uMImage = this.f13636e;
        if (uMImage != null) {
            return uMImage.toByte();
        }
        return null;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public String toString() {
        return "UMVedio [media_url=" + this.f13632a + ", qzone_title=" + this.f13633b + ", qzone_thumb=media_url=" + this.f13632a + ", qzone_title=" + this.f13633b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f13632a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
        }
        return hashMap;
    }

    public UMVideo(File file) {
        this.f13680k = file;
    }
}
