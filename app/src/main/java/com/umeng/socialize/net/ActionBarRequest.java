package com.umeng.socialize.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.socialize.Config;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SocializeUtils;

/* loaded from: classes2.dex */
public class ActionBarRequest extends SocializeRequest {

    /* renamed from: a */
    private static final String f13687a = "/bar/get/";

    /* renamed from: b */
    private static final int f13688b = 1;

    /* renamed from: c */
    private int f13689c;

    public ActionBarRequest(Context context, boolean z) {
        super(context, "", ActionBarResponse.class, 1, URequest.RequestMethod.GET);
        this.f13689c = 0;
        this.mContext = context;
        this.f13689c = z ? 1 : 0;
        this.mMethod = URequest.RequestMethod.GET;
    }

    @Override // com.umeng.socialize.net.utils.URequest
    public String getEcryptString(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest
    protected String getPath() {
        return f13687a + SocializeUtils.getAppkey(this.mContext) + "/android";
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_DESCRIPTOR, Config.Descriptor);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_NEW_INSTALL, String.valueOf(this.f13689c));
        if (TextUtils.isEmpty(Config.EntityName)) {
            return;
        }
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_ENTITY_NAME, Config.EntityName);
    }
}
