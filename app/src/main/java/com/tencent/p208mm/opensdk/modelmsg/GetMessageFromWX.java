package com.tencent.p208mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p208mm.opensdk.modelbase.BaseReq;
import com.tencent.p208mm.opensdk.modelbase.BaseResp;
import com.tencent.p208mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p208mm.opensdk.utils.Log;

/* loaded from: classes2.dex */
public final class GetMessageFromWX {

    public static class Req extends BaseReq {
        public String country;
        public String lang;
        public String username;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.lang = bundle.getString("_wxapi_getmessage_req_lang");
            this.country = bundle.getString("_wxapi_getmessage_req_country");
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 3;
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_getmessage_req_lang", this.lang);
            bundle.putString("_wxapi_getmessage_req_country", this.country);
        }
    }

    public static class Resp extends BaseResp {
        private static final String TAG = "MicroMsg.SDK.GetMessageFromWX.Resp";
        public WXMediaMessage message;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            WXMediaMessage wXMediaMessage = this.message;
            if (wXMediaMessage != null) {
                return wXMediaMessage.checkArgs();
            }
            Log.m10364e(TAG, "checkArgs fail, message is null");
            return false;
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.message = WXMediaMessage.Builder.fromBundle(bundle);
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 3;
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
        }
    }

    private GetMessageFromWX() {
    }
}
