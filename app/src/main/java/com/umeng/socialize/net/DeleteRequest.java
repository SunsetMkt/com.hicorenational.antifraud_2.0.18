package com.umeng.socialize.net;

import com.umeng.socialize.net.utils.URequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class DeleteRequest extends URequest {
    public DeleteRequest(String str, String str2) {
        super("https://api.weibo.com/oauth2/revokeoauth2");
        this.mMethod = URequest.RequestMethod.POST;
        this.mResponseClz = DeleteResponse.class;
        this.postStyle = URequest.PostStyle.APPLICATION;
        addStringParams("access_token", str2);
    }

    @Override // com.umeng.socialize.net.utils.URequest
    public Map<String, Object> buildParams() {
        return null;
    }

    @Override // com.umeng.socialize.net.utils.URequest
    public Map<String, Object> getBodyPair() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.mParams);
        return hashMap;
    }

    @Override // com.umeng.socialize.net.utils.URequest
    public String toGetUrl() {
        return null;
    }

    @Override // com.umeng.socialize.net.utils.URequest
    public JSONObject toJson() {
        return null;
    }
}
