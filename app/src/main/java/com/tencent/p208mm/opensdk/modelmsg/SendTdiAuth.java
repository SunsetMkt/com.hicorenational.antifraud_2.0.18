package com.tencent.p208mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p208mm.opensdk.modelmsg.SendAuth;

/* loaded from: classes2.dex */
public class SendTdiAuth {

    public static final class Resp extends SendAuth.Resp {
        private static final String KEY_AUTH_BUFFER = "_wxapi_sendauth_resp_tdi_buffer";
        private static final String TAG = "MicroMsg.SDK.SendTdiAuth.Resp";
        public byte[] tdiAuthBuffer;

        public Resp(Bundle bundle) {
            super(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.p208mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.p208mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.tdiAuthBuffer = bundle.getByteArray(KEY_AUTH_BUFFER);
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.p208mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 31;
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.p208mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putByteArray(KEY_AUTH_BUFFER, this.tdiAuthBuffer);
        }
    }

    private SendTdiAuth() {
    }
}
