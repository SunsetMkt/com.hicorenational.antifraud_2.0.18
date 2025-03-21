package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class UMMin extends BaseMediaObject {

    /* renamed from: f */
    private String f13670f;

    /* renamed from: g */
    private String f13671g;

    public UMMin(String str) {
        super(str);
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.WEBPAGE;
    }

    public String getPath() {
        return this.f13671g;
    }

    public String getUserName() {
        return this.f13670f;
    }

    public void setPath(String str) {
        this.f13671g = str;
    }

    public void setUserName(String str) {
        this.f13670f = str;
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
