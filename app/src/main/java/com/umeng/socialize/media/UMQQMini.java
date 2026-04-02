package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UMQQMini extends BaseMediaObject {

    /* JADX INFO: renamed from: f */
    private String f8302f;

    /* JADX INFO: renamed from: g */
    private String f8303g;

    /* JADX INFO: renamed from: h */
    private String f8304h;

    public UMQQMini(String str) {
        super(str);
        this.f8302f = "";
        this.f8303g = "";
        this.f8304h = "";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.WEBPAGE;
    }

    public String getMiniAppId() {
        return this.f8302f;
    }

    public String getPath() {
        return this.f8303g;
    }

    public String getType() {
        return this.f8304h;
    }

    public void setMiniAppId(String str) {
        this.f8302f = str;
    }

    public void setPath(String str) {
        this.f8303g = str;
    }

    public void setType(String str) {
        this.f8304h = str;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        UMImage uMImage = this.f8275e;
        if (uMImage != null) {
            return uMImage.toByte();
        }
        return null;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public Map<String, Object> toUrlExtraParams() {
        HashMap map = new HashMap();
        if (isUrlMedia()) {
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.a);
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, this.f8272b);
        }
        return map;
    }
}
