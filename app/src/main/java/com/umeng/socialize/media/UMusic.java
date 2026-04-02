package com.umeng.socialize.media;

import android.os.Parcel;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UMusic extends BaseMediaObject {

    /* JADX INFO: renamed from: f */
    private String f8311f;

    /* JADX INFO: renamed from: g */
    private String f8312g;

    /* JADX INFO: renamed from: h */
    private String f8313h;

    /* JADX INFO: renamed from: i */
    private String f8314i;

    /* JADX INFO: renamed from: j */
    private int f8315j;

    /* JADX INFO: renamed from: k */
    private String f8316k;

    public UMusic(String str) {
        super(str);
    }

    public int getDuration() {
        return this.f8315j;
    }

    public String getH5Url() {
        return this.f8313h;
    }

    public String getHighBandDataUrl() {
        return this.f8312g;
    }

    public String getLowBandDataUrl() {
        return this.f8311f;
    }

    public String getLowBandUrl() {
        return this.f8314i;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.MUSIC;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public UMImage getThumbImage() {
        return this.f8275e;
    }

    public String getmTargetUrl() {
        return this.f8316k;
    }

    public void setDuration(int i2) {
        this.f8315j = i2;
    }

    public void setH5Url(String str) {
        this.f8313h = str;
    }

    public void setHighBandDataUrl(String str) {
        this.f8312g = str;
    }

    public void setLowBandDataUrl(String str) {
        this.f8311f = str;
    }

    public void setLowBandUrl(String str) {
        this.f8314i = str;
    }

    public void setmTargetUrl(String str) {
        this.f8316k = str;
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
        return "UMusic [title=" + this.f8272b + "media_url=" + this.a + ", qzone_title=" + this.f8272b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap map = new HashMap();
        if (isUrlMedia()) {
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.a);
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, this.f8272b);
        }
        return map;
    }

    protected UMusic(Parcel parcel) {
        super(parcel);
    }
}
