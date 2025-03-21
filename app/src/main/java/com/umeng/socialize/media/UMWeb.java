package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class UMWeb extends BaseMediaObject {
    public UMWeb(String str) {
        super(str);
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.WEBPAGE;
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
        return "UMWEB [media_url=" + this.f13632a + ", title=" + this.f13633b + "media_url=" + this.f13632a + ", des=" + this.f13635d + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f13632a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
        }
        return hashMap;
    }

    public UMWeb(String str, String str2, String str3, UMImage uMImage) {
        this.f13632a = str;
        setThumb(uMImage);
        this.f13635d = str3;
        setTitle(str2);
    }
}
