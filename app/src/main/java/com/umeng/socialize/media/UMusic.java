package com.umeng.socialize.media;

import android.os.Parcel;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class UMusic extends BaseMediaObject {

    /* renamed from: f */
    private String f13681f;

    /* renamed from: g */
    private String f13682g;

    /* renamed from: h */
    private String f13683h;

    /* renamed from: i */
    private String f13684i;

    /* renamed from: j */
    private int f13685j;

    /* renamed from: k */
    private String f13686k;

    public UMusic(String str) {
        super(str);
    }

    public int getDuration() {
        return this.f13685j;
    }

    public String getH5Url() {
        return this.f13683h;
    }

    public String getHighBandDataUrl() {
        return this.f13682g;
    }

    public String getLowBandDataUrl() {
        return this.f13681f;
    }

    public String getLowBandUrl() {
        return this.f13684i;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.MUSIC;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public UMImage getThumbImage() {
        return this.f13636e;
    }

    public String getmTargetUrl() {
        return this.f13686k;
    }

    public void setDuration(int i2) {
        this.f13685j = i2;
    }

    public void setH5Url(String str) {
        this.f13683h = str;
    }

    public void setHighBandDataUrl(String str) {
        this.f13682g = str;
    }

    public void setLowBandDataUrl(String str) {
        this.f13681f = str;
    }

    public void setLowBandUrl(String str) {
        this.f13684i = str;
    }

    public void setmTargetUrl(String str) {
        this.f13686k = str;
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
        return "UMusic [title=" + this.f13633b + "media_url=" + this.f13632a + ", qzone_title=" + this.f13633b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f13632a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, this.f13633b);
        }
        return hashMap;
    }

    protected UMusic(Parcel parcel) {
        super(parcel);
    }
}
