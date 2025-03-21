package org.android.spdy;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.spdy.ProtectedPointer;

/* loaded from: classes2.dex */
public final class SpdySession {
    private static volatile int count;
    private SpdyAgent agent;
    private String authority;
    private String domain;
    private Handler handler;
    Intenalcb intenalcb;
    private int mode;
    private int pubkey_seqnum;
    SessionCb sessionCallBack;
    private volatile long sessionNativePtr;
    private NetSparseArray<SpdyStreamContext> spdyStream;
    private HandlerThread thread;
    private Object userData;
    private AtomicBoolean closed = new AtomicBoolean();
    private boolean sessionClearedFromSessionMgr = false;
    private Object lock = new Object();
    private int streamcount = 1;
    volatile int refcount = 1;
    private ProtectedPointer pptr4sessionNativePtr = new ProtectedPointer(this);

    SpdySession(long j2, SpdyAgent spdyAgent, String str, String str2, SessionCb sessionCb, int i2, int i3, Object obj) {
        this.spdyStream = null;
        this.sessionCallBack = null;
        this.pubkey_seqnum = 0;
        this.userData = null;
        this.sessionNativePtr = j2;
        this.pptr4sessionNativePtr.setHow2close(new ProtectedPointer.ProtectedPointerOnClose() { // from class: org.android.spdy.SpdySession.1
            @Override // org.android.spdy.ProtectedPointer.ProtectedPointerOnClose
            public void close(Object obj2) {
                SpdySession spdySession = (SpdySession) obj2;
                spdySession.NotifyNotInvokeAnyMoreN(spdySession.sessionNativePtr);
                spdySession.setSessionNativePtr(0L);
            }
        });
        this.agent = spdyAgent;
        this.authority = str;
        this.intenalcb = new SpdySessionCallBack();
        this.domain = str2;
        this.spdyStream = new NetSparseArray<>(5);
        this.sessionCallBack = sessionCb;
        this.pubkey_seqnum = i3;
        this.mode = i2;
        this.userData = obj;
        this.closed.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int NotifyNotInvokeAnyMoreN(long j2);

    private int closeprivate() {
        synchronized (this.lock) {
            if (!this.sessionClearedFromSessionMgr) {
                this.agent.clearSpdySession(this.authority, this.domain, this.mode);
                this.sessionClearedFromSessionMgr = true;
            }
        }
        synchronized (this.lock) {
            SpdyStreamContext[] allStreamCb = getAllStreamCb();
            if (allStreamCb != null) {
                for (SpdyStreamContext spdyStreamContext : allStreamCb) {
                    spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyStreamCloseCallback] unfinished stm=" + spdyStreamContext.streamId);
                    spdyStreamContext.callBack.spdyStreamCloseCallback(this, (long) spdyStreamContext.streamId, -2001, spdyStreamContext.streamContext, null);
                }
            }
            this.spdyStream.clear();
        }
        return 0;
    }

    private String getAuthority() {
        return this.authority;
    }

    private native int sendCustomControlFrameN(long j2, int i2, int i3, int i4, int i5, byte[] bArr);

    private native int sendHeadersN(long j2, int i2, String[] strArr, boolean z);

    private native int setOptionN(long j2, int i2, int i3);

    private native int streamCloseN(long j2, int i2, int i3);

    private native int streamSendDataN(long j2, int i2, byte[] bArr, int i3, int i4, boolean z);

    private native int submitBioPingN(long j2);

    private native int submitPingN(long j2);

    private native int submitRequestN(long j2, String str, byte b2, String[] strArr, byte[] bArr, boolean z, int i2, int i3, int i4);

    public int cleanUp() {
        spduLog.Logd("tnet-jni", "[SpdySession.cleanUp] - ");
        if (this.closed.getAndSet(true)) {
            return 0;
        }
        this.agent.removeSession(this);
        return closeprivate();
    }

    public void clearAllStreamCb() {
        spduLog.Logd("tnet-jni", "[SpdySession.clearAllStreamCb] - ");
        synchronized (this.lock) {
            this.spdyStream.clear();
        }
    }

    int closeInternal() {
        if (this.closed.getAndSet(true)) {
            return 0;
        }
        return closeprivate();
    }

    public int closeSession() {
        int i2;
        ProtectedPointer protectedPointer;
        spduLog.Logd("tnet-jni", "[SpdySession.closeSession] - ");
        synchronized (this.lock) {
            i2 = 0;
            if (!this.sessionClearedFromSessionMgr) {
                spduLog.Logd("tnet-jni", "[SpdySession.closeSession] - " + this.authority);
                this.agent.clearSpdySession(this.authority, this.domain, this.mode);
                this.sessionClearedFromSessionMgr = true;
                try {
                    if (this.pptr4sessionNativePtr.enter()) {
                        try {
                            i2 = this.agent.closeSession(this.sessionNativePtr);
                            protectedPointer = this.pptr4sessionNativePtr;
                        } catch (UnsatisfiedLinkError e2) {
                            e2.printStackTrace();
                            protectedPointer = this.pptr4sessionNativePtr;
                        }
                        protectedPointer.exit();
                    } else {
                        i2 = -2001;
                    }
                } catch (Throwable th) {
                    this.pptr4sessionNativePtr.exit();
                    throw th;
                }
            }
        }
        return i2;
    }

    public SpdyStreamContext[] getAllStreamCb() {
        SpdyStreamContext[] spdyStreamContextArr;
        synchronized (this.lock) {
            int size = this.spdyStream.size();
            if (size > 0) {
                spdyStreamContextArr = new SpdyStreamContext[size];
                this.spdyStream.toArray(spdyStreamContextArr);
            } else {
                spdyStreamContextArr = null;
            }
        }
        return spdyStreamContextArr;
    }

    public String getDomain() {
        return this.domain;
    }

    Handler getMsgHandler() {
        return this.handler;
    }

    public int getRefCount() {
        return this.refcount;
    }

    long getSessionNativePtr() {
        return this.sessionNativePtr;
    }

    SpdyAgent getSpdyAgent() {
        return this.agent;
    }

    SpdyStreamContext getSpdyStream(int i2) {
        SpdyStreamContext spdyStreamContext;
        if (i2 <= 0) {
            return null;
        }
        synchronized (this.lock) {
            spdyStreamContext = this.spdyStream.get(i2);
        }
        return spdyStreamContext;
    }

    public Object getUserData() {
        return this.userData;
    }

    void increRefCount() {
        this.refcount++;
    }

    int putSpdyStreamCtx(SpdyStreamContext spdyStreamContext) {
        int i2;
        synchronized (this.lock) {
            i2 = this.streamcount;
            this.streamcount = i2 + 1;
            this.spdyStream.put(i2, spdyStreamContext);
        }
        return i2;
    }

    void releasePptr() {
        this.pptr4sessionNativePtr.release();
    }

    void removeSpdyStream(int i2) {
        if (i2 > 0) {
            synchronized (this.lock) {
                this.spdyStream.remove(i2);
            }
        }
    }

    public int sendCustomControlFrame(int i2, int i3, int i4, int i5, byte[] bArr) throws SpdyErrorException {
        int i6;
        sessionIsOpen();
        if (bArr != null && bArr.length <= 0) {
            bArr = null;
        }
        byte[] bArr2 = bArr;
        spduLog.Logi("tnet-jni", "[sendCustomControlFrame] - type: " + i3);
        if (this.pptr4sessionNativePtr.enter()) {
            i6 = sendCustomControlFrameN(this.sessionNativePtr, i2, i3, i4, i5, bArr2);
            this.pptr4sessionNativePtr.exit();
        } else {
            i6 = -2001;
        }
        if (i6 == 0) {
            return i6;
        }
        throw new SpdyErrorException("sendCustomControlFrame error: " + i6, i6);
    }

    void sessionIsOpen() {
        if (this.closed.get()) {
            throw new SpdyErrorException("session is already closed: -1104", TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE);
        }
    }

    public int setOption(int i2, int i3) throws SpdyErrorException {
        int i4;
        sessionIsOpen();
        if (this.pptr4sessionNativePtr.enter()) {
            i4 = setOptionN(this.sessionNativePtr, i2, i3);
            this.pptr4sessionNativePtr.exit();
        } else {
            i4 = -2001;
        }
        if (i4 == 0) {
            return i4;
        }
        throw new SpdyErrorException("setOption error: " + i4, i4);
    }

    void setSessionNativePtr(long j2) {
        this.sessionNativePtr = j2;
    }

    public int streamReset(long j2, int i2) throws SpdyErrorException {
        int i3;
        sessionIsOpen();
        spduLog.Logd("tnet-jni", "[SpdySession.streamReset] - ");
        if (this.pptr4sessionNativePtr.enter()) {
            i3 = streamCloseN(this.sessionNativePtr, (int) j2, i2);
            this.pptr4sessionNativePtr.exit();
        } else {
            i3 = -2001;
        }
        if (i3 == 0) {
            return i3;
        }
        throw new SpdyErrorException("streamReset error: " + i3, i3);
    }

    @Deprecated
    public int submitBioPing() throws SpdyErrorException {
        int i2;
        sessionIsOpen();
        if (this.pptr4sessionNativePtr.enter()) {
            i2 = submitBioPingN(this.sessionNativePtr);
            this.pptr4sessionNativePtr.exit();
        } else {
            i2 = -2001;
        }
        if (i2 == 0) {
            return i2;
        }
        throw new SpdyErrorException("submitBioPing error: " + i2, i2);
    }

    public int submitPing() throws SpdyErrorException {
        int i2;
        sessionIsOpen();
        if (this.pptr4sessionNativePtr.enter()) {
            i2 = submitPingN(this.sessionNativePtr);
            this.pptr4sessionNativePtr.exit();
        } else {
            i2 = -2001;
        }
        if (i2 == 0) {
            return i2;
        }
        throw new SpdyErrorException("submitPing error: " + i2, i2);
    }

    public int submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Spdycb spdycb) throws SpdyErrorException {
        SpdyStreamContext spdyStreamContext;
        String str;
        int i2;
        if (spdyRequest == null || obj == null || spdyRequest.getAuthority() == null) {
            throw new SpdyErrorException("submitRequest error: -1102", TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
        sessionIsOpen();
        byte[] dataproviderToByteArray = SpdyAgent.dataproviderToByteArray(spdyRequest, spdyDataProvider);
        if (dataproviderToByteArray != null && dataproviderToByteArray.length <= 0) {
            dataproviderToByteArray = null;
        }
        byte[] bArr = dataproviderToByteArray;
        boolean z = spdyDataProvider != null ? spdyDataProvider.finished : true;
        SpdyStreamContext spdyStreamContext2 = new SpdyStreamContext(obj, spdycb);
        int putSpdyStreamCtx = putSpdyStreamCtx(spdyStreamContext2);
        String[] mapToByteArray = SpdyAgent.mapToByteArray(spdyRequest.getHeaders());
        spduLog.Logi("tnet-jni", "index=" + putSpdyStreamCtx + "  starttime=" + System.currentTimeMillis());
        if (this.pptr4sessionNativePtr.enter()) {
            spdyStreamContext = spdyStreamContext2;
            str = "tnet-jni";
            i2 = submitRequestN(this.sessionNativePtr, spdyRequest.getUrlPath(), (byte) spdyRequest.getPriority(), mapToByteArray, bArr, z, putSpdyStreamCtx, spdyRequest.getRequestTimeoutMs(), spdyRequest.getRequestRdTimeoutMs());
            this.pptr4sessionNativePtr.exit();
        } else {
            spdyStreamContext = spdyStreamContext2;
            str = "tnet-jni";
            i2 = -2001;
        }
        spduLog.Logi(str, "index=" + putSpdyStreamCtx + "   calltime=" + System.currentTimeMillis());
        if (i2 >= 0) {
            spdyStreamContext.streamId = i2;
            return i2;
        }
        removeSpdyStream(putSpdyStreamCtx);
        throw new SpdyErrorException("submitRequest error: " + i2, i2);
    }
}
