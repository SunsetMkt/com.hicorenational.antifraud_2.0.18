package com.huawei.hms.api;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes.dex */
public class IPCCallback extends IAIDLCallback.Stub {
    private static final String TAG = "IPCCallback";
    private final DatagramTransport.InterfaceC2523a mCallback;
    private final Class<? extends IMessageEntity> mResponseClass;

    public IPCCallback(Class<? extends IMessageEntity> cls, DatagramTransport.InterfaceC2523a interfaceC2523a) {
        this.mResponseClass = cls;
        this.mCallback = interfaceC2523a;
    }

    @Override // com.huawei.hms.core.aidl.IAIDLCallback
    public void call(DataBuffer dataBuffer) throws RemoteException {
        if (dataBuffer == null || TextUtils.isEmpty(dataBuffer.URI)) {
            HMSLog.m7715e(TAG, "In call, URI cannot be empty.");
            throw new RemoteException();
        }
        MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
        IMessageEntity iMessageEntity = null;
        if (dataBuffer.getBodySize() > 0 && (iMessageEntity = newResponseInstance()) != null) {
            find.decode(dataBuffer.getBody(), iMessageEntity);
        }
        DatagramTransport.InterfaceC2523a interfaceC2523a = this.mCallback;
        if (interfaceC2523a != null) {
            if (dataBuffer.header == null) {
                interfaceC2523a.mo7669a(0, iMessageEntity);
                return;
            }
            ResponseHeader responseHeader = new ResponseHeader();
            find.decode(dataBuffer.header, responseHeader);
            this.mCallback.mo7669a(responseHeader.getStatusCode(), iMessageEntity);
        }
    }

    protected IMessageEntity newResponseInstance() {
        Class<? extends IMessageEntity> cls = this.mResponseClass;
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e2) {
            HMSLog.m7715e(TAG, "In newResponseInstance, instancing exception." + e2.getMessage());
            return null;
        }
    }
}
