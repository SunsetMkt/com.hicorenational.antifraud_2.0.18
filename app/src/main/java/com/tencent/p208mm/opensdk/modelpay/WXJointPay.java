package com.tencent.p208mm.opensdk.modelpay;

import android.os.Bundle;

/* loaded from: classes2.dex */
public class WXJointPay {

    public static class JointPayReq extends PayReq {
        @Override // com.tencent.p208mm.opensdk.modelpay.PayReq, com.tencent.p208mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return super.checkArgs();
        }

        @Override // com.tencent.p208mm.opensdk.modelpay.PayReq, com.tencent.p208mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.p208mm.opensdk.modelpay.PayReq, com.tencent.p208mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 27;
        }

        @Override // com.tencent.p208mm.opensdk.modelpay.PayReq, com.tencent.p208mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }

    public static class JointPayResp extends PayResp {
        public JointPayResp() {
        }

        public JointPayResp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.p208mm.opensdk.modelpay.PayResp, com.tencent.p208mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return super.checkArgs();
        }

        @Override // com.tencent.p208mm.opensdk.modelpay.PayResp, com.tencent.p208mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.p208mm.opensdk.modelpay.PayResp, com.tencent.p208mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 27;
        }

        @Override // com.tencent.p208mm.opensdk.modelpay.PayResp, com.tencent.p208mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }
}
