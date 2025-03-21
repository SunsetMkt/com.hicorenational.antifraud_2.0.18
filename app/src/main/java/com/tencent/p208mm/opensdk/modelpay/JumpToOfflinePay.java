package com.tencent.p208mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.p208mm.opensdk.modelbase.BaseReq;
import com.tencent.p208mm.opensdk.modelbase.BaseResp;

/* loaded from: classes2.dex */
public class JumpToOfflinePay {

    public static class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.JumpToOfflinePay.Req";

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 24;
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }

    public static class Resp extends BaseResp {
        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 24;
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }
}
