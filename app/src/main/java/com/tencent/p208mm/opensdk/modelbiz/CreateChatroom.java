package com.tencent.p208mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p208mm.opensdk.modelbase.BaseReq;
import com.tencent.p208mm.opensdk.modelbase.BaseResp;
import com.tencent.p208mm.opensdk.utils.C3240b;

/* loaded from: classes2.dex */
public class CreateChatroom {

    public static class Req extends BaseReq {
        public String chatroomName;
        public String chatroomNickName;
        public String extMsg;
        public String groupId = "";

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return !C3240b.m10372b(this.groupId);
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 14;
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_create_chatroom_group_id", this.groupId);
            bundle.putString("_wxapi_create_chatroom_chatroom_name", this.chatroomName);
            bundle.putString("_wxapi_create_chatroom_chatroom_nickname", this.chatroomNickName);
            bundle.putString("_wxapi_create_chatroom_ext_msg", this.extMsg);
            bundle.putString("_wxapi_basereq_openid", this.openId);
        }
    }

    public static class Resp extends BaseResp {
        public String extMsg;

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
            this.extMsg = bundle.getString("_wxapi_create_chatroom_ext_msg");
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 14;
        }

        @Override // com.tencent.p208mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_create_chatroom_ext_msg", this.extMsg);
        }
    }

    private CreateChatroom() {
    }
}
