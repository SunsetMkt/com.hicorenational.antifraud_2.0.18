package com.tencent.p208mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p208mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p208mm.opensdk.utils.C3240b;
import com.tencent.p208mm.opensdk.utils.Log;

/* loaded from: classes2.dex */
public class WXEmojiPageSharedObject implements WXMediaMessage.IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
    public String desc;
    public String iconUrl;
    public int pageType;
    public String secondUrl;
    public int tid;
    public String title;
    public int type;
    public String url;

    public WXEmojiPageSharedObject() {
    }

    public WXEmojiPageSharedObject(int i2, int i3, String str, String str2, String str3, String str4, int i4, String str5) {
        this.tid = i3;
        this.title = str;
        this.desc = str2;
        this.iconUrl = str3;
        this.secondUrl = str4;
        this.pageType = i4;
        this.url = str5;
        this.type = i2;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if (!C3240b.m10372b(this.title) && !C3240b.m10372b(this.iconUrl)) {
            return true;
        }
        Log.m10364e(TAG, "checkArgs fail, title or iconUrl is invalid");
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putInt("_wxemojisharedobject_tid", this.tid);
        bundle.putString("_wxemojisharedobject_title", this.title);
        bundle.putString("_wxemojisharedobject_desc", this.desc);
        bundle.putString("_wxemojisharedobject_iconurl", this.iconUrl);
        bundle.putString("_wxemojisharedobject_secondurl", this.secondUrl);
        bundle.putInt("_wxemojisharedobject_pagetype", this.pageType);
        bundle.putString("_wxwebpageobject_url", this.url);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return this.type;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.tid = bundle.getInt("_wxemojisharedobject_tid");
        this.title = bundle.getString("_wxemojisharedobject_title");
        this.desc = bundle.getString("_wxemojisharedobject_desc");
        this.iconUrl = bundle.getString("_wxemojisharedobject_iconurl");
        this.secondUrl = bundle.getString("_wxemojisharedobject_secondurl");
        this.pageType = bundle.getInt("_wxemojisharedobject_pagetype");
        this.url = bundle.getString("_wxwebpageobject_url");
    }
}
