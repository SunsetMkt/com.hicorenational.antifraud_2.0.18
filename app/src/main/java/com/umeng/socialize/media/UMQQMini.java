package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class UMQQMini extends BaseMediaObject {

    /* renamed from: f */
    private String f13672f;

    /* renamed from: g */
    private String f13673g;

    /* renamed from: h */
    private String f13674h;

    public UMQQMini(String str) {
        super(str);
        this.f13672f = "";
        this.f13673g = "";
        this.f13674h = "";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.WEBPAGE;
    }

    public String getMiniAppId() {
        return this.f13672f;
    }

    public String getPath() {
        return this.f13673g;
    }

    public String getType() {
        return this.f13674h;
    }

    public void setMiniAppId(String str) {
        this.f13672f = str;
    }

    public void setPath(String str) {
        this.f13673g = str;
    }

    public void setType(String str) {
        this.f13674h = str;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        UMImage uMImage = this.f13636e;
        if (uMImage != null) {
            return uMImage.toByte();
        }
        return null;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f13632a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, this.f13633b);
        }
        return hashMap;
    }
}
