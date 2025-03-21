package com.tencent.p208mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p208mm.opensdk.utils.Log;

/* loaded from: classes2.dex */
public abstract class WXChannelBaseJumpInfo implements IWXChannelJumpInfo {
    private static final String TAG = "MicroMsg.SDK.WXChannelBaseJumpInfo";
    private static final int WORDING_LENGTH_LIMIT = 1024;
    public String extra;
    public String wording;

    @Override // com.tencent.p208mm.opensdk.modelbiz.IWXChannelJumpInfo
    public boolean checkArgs() {
        String str = this.wording;
        if (str == null || str.length() < 1024) {
            return true;
        }
        Log.m10364e(TAG, "checkArgs fail, wording is invalid");
        return false;
    }

    @Override // com.tencent.p208mm.opensdk.modelbiz.IWXChannelJumpInfo
    public void serialize(Bundle bundle) {
        bundle.putString("wx_channel_jump_base_wording", this.wording);
        bundle.putString("wx_channel_jump_base_extra", this.extra);
    }

    @Override // com.tencent.p208mm.opensdk.modelbiz.IWXChannelJumpInfo
    public void unserialize(Bundle bundle) {
        this.wording = bundle.getString("wx_channel_jump_base_wording");
        this.extra = bundle.getString("wx_channel_jump_base_extra");
    }
}
