package com.android.dingtalk.share.ddsharemodule.message;

import android.os.Bundle;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;

/* loaded from: classes.dex */
public class DDWebpageMessage extends BaseMediaObject {
    private static final int MAX_WEBPAGE_URL_LENGTH = 10240;
    private static final String TAG = "DDWebpageMessage";
    public String mUrl;

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str = this.mUrl;
        return (str == null || str.length() == 0 || this.mUrl.length() > MAX_WEBPAGE_URL_LENGTH) ? false : true;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public int getSupportVersion() {
        return ShareConstant.DINGDING_SDK_SHARE_VERSION_V1;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putString(ShareConstant.EXTRA_WEB_PAGE_OBJECT_URL, this.mUrl);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public int type() {
        return 1;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mUrl = bundle.getString(ShareConstant.EXTRA_WEB_PAGE_OBJECT_URL);
    }
}
