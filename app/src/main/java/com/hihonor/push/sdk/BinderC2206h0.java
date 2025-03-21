package com.hihonor.push.sdk;

import android.os.Bundle;
import android.os.Handler;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushCallback;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.ResponseHeader;
import com.hihonor.push.sdk.C2242z;
import com.hihonor.push.sdk.common.data.ApiException;

/* renamed from: com.hihonor.push.sdk.h0 */
/* loaded from: classes.dex */
public class BinderC2206h0 extends IPushCallback.Stub {

    /* renamed from: a */
    public final Object f6787a;

    /* renamed from: b */
    public final InterfaceC2209i0 f6788b;

    public BinderC2206h0(Object obj, InterfaceC2209i0 interfaceC2209i0) {
        this.f6787a = obj;
        this.f6788b = interfaceC2209i0;
    }

    @Override // com.hihonor.push.framework.aidl.IPushCallback
    public void onResult(DataBuffer dataBuffer) {
        Bundle header = dataBuffer.getHeader();
        Bundle body = dataBuffer.getBody();
        ResponseHeader responseHeader = new ResponseHeader();
        MessageCodec.parseMessageEntity(header, responseHeader);
        Object obj = this.f6787a;
        if (obj instanceof IMessageEntity) {
            MessageCodec.parseMessageEntity(body, (IMessageEntity) obj);
        }
        InterfaceC2209i0 interfaceC2209i0 = this.f6788b;
        ApiException apiException = new ApiException(responseHeader.getStatusCode(), responseHeader.getStatusMessage());
        Object obj2 = this.f6787a;
        C2242z.b bVar = (C2242z.b) interfaceC2209i0;
        bVar.getClass();
        C2242z c2242z = C2242z.f6856c;
        AbstractC2201f1<?> abstractC2201f1 = bVar.f6865a;
        c2242z.getClass();
        Handler handler = c2242z.f6857a;
        handler.sendMessage(handler.obtainMessage(2, abstractC2201f1));
        bVar.f6865a.m6387b(apiException, obj2);
    }
}
