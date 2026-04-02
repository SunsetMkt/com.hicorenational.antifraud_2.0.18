package com.hihonor.push.sdk;

import android.os.Bundle;
import android.os.Handler;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushCallback;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.ResponseHeader;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.z;

/* JADX INFO: loaded from: classes.dex */
public class h0 extends IPushCallback.Stub {
    public final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0 f4259b;

    public h0(Object obj, i0 i0Var) {
        this.a = obj;
        this.f4259b = i0Var;
    }

    @Override // com.hihonor.push.framework.aidl.IPushCallback
    public void onResult(DataBuffer dataBuffer) {
        Bundle header = dataBuffer.getHeader();
        Bundle body = dataBuffer.getBody();
        ResponseHeader responseHeader = new ResponseHeader();
        MessageCodec.parseMessageEntity(header, responseHeader);
        Object obj = this.a;
        if (obj instanceof IMessageEntity) {
            MessageCodec.parseMessageEntity(body, (IMessageEntity) obj);
        }
        i0 i0Var = this.f4259b;
        ApiException apiException = new ApiException(responseHeader.getStatusCode(), responseHeader.getStatusMessage());
        Object obj2 = this.a;
        z.b bVar = (z.b) i0Var;
        bVar.getClass();
        z zVar = z.f4293c;
        f1<?> f1Var = bVar.a;
        zVar.getClass();
        Handler handler = zVar.a;
        handler.sendMessage(handler.obtainMessage(2, f1Var));
        bVar.a.b(apiException, obj2);
    }
}
