package com.tencent.p208mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p208mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p208mm.opensdk.utils.C3240b;
import com.tencent.p208mm.opensdk.utils.Log;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class WXWebpageObject implements WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXWebpageObject";
    public String canvasPageXml;
    public String extInfo;
    public String webpageUrl;
    public boolean isSecretMessage = false;
    public HashMap<String, String> extraInfoMap = null;

    public WXWebpageObject() {
    }

    public WXWebpageObject(String str) {
        this.webpageUrl = str;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str = this.webpageUrl;
        if (str != null && str.length() != 0 && this.webpageUrl.length() <= LENGTH_LIMIT) {
            return true;
        }
        Log.m10364e(TAG, "checkArgs fail, webpageUrl is invalid");
        return false;
    }

    public String getExtra(String str, String str2) {
        HashMap<String, String> hashMap = this.extraInfoMap;
        if (hashMap == null) {
            return null;
        }
        String str3 = hashMap.get(str);
        return str3 != null ? str3 : str2;
    }

    public void putExtra(String str, String str2) {
        if (this.extraInfoMap == null) {
            this.extraInfoMap = new HashMap<>();
        }
        if (C3240b.m10372b(str)) {
            return;
        }
        this.extraInfoMap.put(str, str2);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxwebpageobject_extInfo", this.extInfo);
        bundle.putString("_wxwebpageobject_webpageUrl", this.webpageUrl);
        bundle.putString("_wxwebpageobject_canvaspagexml", this.canvasPageXml);
        bundle.putBoolean("_wxwebpageobject_issecretmsg", this.isSecretMessage);
        HashMap<String, String> hashMap = this.extraInfoMap;
        if (hashMap != null) {
            bundle.putSerializable("_wxwebpageobject_extrainfo", hashMap);
        }
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 5;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.extInfo = bundle.getString("_wxwebpageobject_extInfo");
        this.webpageUrl = bundle.getString("_wxwebpageobject_webpageUrl");
        this.canvasPageXml = bundle.getString("_wxwebpageobject_canvaspagexml");
        this.isSecretMessage = bundle.getBoolean("_wxwebpageobject_issecretmsg");
        Serializable serializable = bundle.getSerializable("_wxwebpageobject_extrainfo");
        if (serializable != null) {
            this.extraInfoMap = (HashMap) serializable;
        }
    }
}
