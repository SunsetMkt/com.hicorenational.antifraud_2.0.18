package org.android.spdy;

import android.content.Context;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import okio.Utf8;
import p286h.C5230f1;
import p286h.p323z2.C5736h0;

/* loaded from: classes2.dex */
public final class SpdyAgent {
    public static final int ACCS_ONLINE_SERVER = 1;
    public static final int ACCS_TEST_SERVER = 0;
    private static final boolean HAVE_CLOSE = false;
    private static final int KB32 = 32768;
    private static final int KB8 = 8192;
    private static final int MAX_SPDY_SESSION_COUNT = 50;
    private static final int MB5 = 5242880;
    static final int MODE_QUIC = 256;
    static final int SPDY_CUSTOM_CONTROL_FRAME_RECV = 4106;
    static final int SPDY_DATA_CHUNK_RECV = 4097;
    static final int SPDY_DATA_RECV = 4098;
    static final int SPDY_DATA_SEND = 4099;
    static final int SPDY_PING_RECV = 4101;
    static final int SPDY_REQUEST_RECV = 4102;
    static final int SPDY_SESSION_CLOSE = 4103;
    static final int SPDY_SESSION_CREATE = 4096;
    static final int SPDY_SESSION_FAILED_ERROR = 4105;
    static final int SPDY_STREAM_CLOSE = 4100;
    static final int SPDY_STREAM_RESPONSE_RECV = 4104;
    private static final String TNET_SO_VERSION = "tnet-3.1.14";
    public static volatile boolean enableDebug = false;
    public static volatile boolean enableTimeGaurd = false;
    private AccsSSLCallback accsSSLCallback;
    private long agentNativePtr;
    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /* renamed from: r */
    private static final Lock f21519r = rwLock.readLock();

    /* renamed from: w */
    private static final Lock f21520w = rwLock.writeLock();
    private static volatile boolean loadSucc = false;
    private static volatile SpdyAgent gSingleInstance = null;
    private static Object lock = new Object();
    private static Object domainHashLock = new Object();
    private static HashMap<String, Integer> domainHashMap = new HashMap<>();
    private static int totalDomain = 0;
    private HashMap<String, SpdySession> sessionMgr = new HashMap<>(5);
    private LinkedList<SpdySession> sessionQueue = new LinkedList<>();
    private AtomicBoolean closed = new AtomicBoolean();
    private String proxyUsername = null;
    private String proxyPassword = null;

    private SpdyAgent(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind, AccsSSLCallback accsSSLCallback) throws UnsatisfiedLinkError {
        try {
            SoInstallMgrSdk.init(context);
            loadSucc = SoInstallMgrSdk.initSo(TNET_SO_VERSION, 1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            this.agentNativePtr = initAgent(spdyVersion.getInt(), spdySessionKind.getint(), SslVersion.SLIGHT_VERSION_V1.getint());
            this.accsSSLCallback = accsSSLCallback;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
        this.closed.set(false);
    }

    static void InvlidCharJudge(byte[] bArr, byte[] bArr2) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if ((bArr[i2] & C5230f1.f20085c) < 32 || (bArr[i2] & C5230f1.f20085c) > 126) {
                bArr[i2] = Utf8.REPLACEMENT_BYTE;
            }
        }
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if ((bArr2[i3] & C5230f1.f20085c) < 32 || (bArr2[i3] & C5230f1.f20085c) > 126) {
                bArr2[i3] = Utf8.REPLACEMENT_BYTE;
            }
        }
    }

    private void agentIsOpen() {
        if (this.closed.get()) {
            throw new SpdyErrorException("SPDY_JNI_ERR_ASYNC_CLOSE", TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE);
        }
        checkLoadSo();
    }

    private void bioPingRecvCallback(SpdySession spdySession, int i2) {
        spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.bioPingRecvCallback(spdySession, i2);
        }
    }

    private void checkLoadSo() throws SpdyErrorException {
        if (loadSucc) {
            return;
        }
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (lock) {
            if (loadSucc) {
                return;
            }
            loadSucc = SoInstallMgrSdk.initSo(TNET_SO_VERSION, 1);
            this.agentNativePtr = initAgent(0, 0, 0);
            if (!loadSucc) {
                throw new SpdyErrorException("TNET_JNI_ERR_LOAD_SO_FAIL", TnetStatusCode.TNET_JNI_ERR_LOAD_SO_FAIL);
            }
        }
    }

    public static boolean checkLoadSucc() {
        return loadSucc;
    }

    private native int closeSessionN(long j2);

    public static int configIpStackMode(int i2) {
        spduLog.Logi("tnet-jni", "[configIpStackMode] - " + i2);
        return configIpStackModeN(i2);
    }

    private static native int configIpStackModeN(int i2);

    private native int configLogFileN(String str, int i2, int i3);

    private native int configLogFileN(String str, int i2, int i3, int i4);

    private static void crashReporter(int i2) {
    }

    private native long createSessionN(long j2, SpdySession spdySession, int i2, byte[] bArr, char c2, byte[] bArr2, char c3, byte[] bArr3, byte[] bArr4, Object obj, int i3, int i4, int i5, byte[] bArr5);

    static byte[] dataproviderToByteArray(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider) {
        headJudge(spdyRequest.getHeaders());
        if (spdyDataProvider == null) {
            return null;
        }
        String mapBodyToString = mapBodyToString(spdyDataProvider.postBody);
        byte[] bytes = mapBodyToString != null ? mapBodyToString.getBytes() : spdyDataProvider.data;
        if (bytes == null || bytes.length < 5242880) {
            return bytes;
        }
        throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + bytes.length, TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
    }

    private native int freeAgent(long j2);

    private int getDomainHashIndex(String str) {
        Integer num;
        synchronized (domainHashLock) {
            num = domainHashMap.get(str);
            if (num == null) {
                HashMap<String, Integer> hashMap = domainHashMap;
                int i2 = totalDomain + 1;
                totalDomain = i2;
                hashMap.put(str, Integer.valueOf(i2));
                num = Integer.valueOf(totalDomain);
            }
        }
        return num.intValue();
    }

    public static SpdyAgent getInstance(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind) throws UnsatisfiedLinkError, SpdyErrorException {
        if (gSingleInstance == null) {
            synchronized (lock) {
                if (gSingleInstance == null) {
                    gSingleInstance = new SpdyAgent(context, spdyVersion, spdySessionKind, null);
                }
            }
        }
        return gSingleInstance;
    }

    private void getPerformance(SpdySession spdySession, SslPermData sslPermData) {
    }

    private byte[] getSSLMeta(SpdySession spdySession) {
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[getSSLMeta] - session is null");
            return null;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb != null) {
            return intenalcb.getSSLMeta(spdySession);
        }
        spduLog.Logi("tnet-jni", "[getSSLMeta] - session.intenalcb is null");
        return null;
    }

    private byte[] getSSLPublicKey(int i2, byte[] bArr) {
        AccsSSLCallback accsSSLCallback = this.accsSSLCallback;
        if (accsSSLCallback != null) {
            return accsSSLCallback.getSSLPublicKey(i2, bArr);
        }
        spduLog.Logd("tnet-jni", "[getSSLPublicKey] - accsSSLCallback is null.");
        return null;
    }

    private native long getSession(long j2, byte[] bArr, char c2);

    static void headJudge(Map<String, String> map) {
        if (map != null) {
            int i2 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                InvlidCharJudge(key.getBytes(), value.getBytes());
                i2 += key.length() + 1 + value.length();
                securityCheck(i2, value.length());
            }
        }
    }

    private native long initAgent(int i2, int i3, int i4);

    @Deprecated
    public static void inspect(String str) {
    }

    private native void logFileCloseN();

    private native void logFileFlushN();

    static String mapBodyToString(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map == null) {
            return null;
        }
        int i2 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key);
            sb.append('=');
            sb.append(value);
            sb.append(C5736h0.f20714c);
            i2 += key.length() + 1 + value.length();
            tableListJudge(i2);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    static String[] mapToByteArray(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        String[] strArr = new String[map.size() * 2];
        int i2 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            strArr[i2] = entry.getKey();
            strArr[i2 + 1] = entry.getValue();
            i2 += 2;
        }
        return strArr;
    }

    private int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[putSSLMeta] - session is null");
            return -1;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb != null) {
            return intenalcb.putSSLMeta(spdySession, bArr);
        }
        spduLog.Logi("tnet-jni", "[putSSLMeta] - session.intenalcb is null");
        return -1;
    }

    static void securityCheck(int i2, int i3) {
        if (i2 >= 32768) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + i2, TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
        if (i3 < 8192) {
            return;
        }
        throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:value=" + i3, TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
    }

    private native int setConTimeout(long j2, int i2);

    private native int setSessionKind(long j2, int i2);

    private void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i2, int i3) {
        spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyCustomControlFrameFailCallback(spdySession, obj, i2, i3);
        }
    }

    private void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i2, int i3, int i4, int i5, byte[] bArr) {
        spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyCustomControlFrameRecvCallback(spdySession, obj, i2, i3, i4, i5, bArr);
        }
    }

    private void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, int i2, SpdyByteArray spdyByteArray, int i3) {
        spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - ");
        long j2 = i2 & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session.intenalcb is null");
        } else {
            intenalcb.spdyDataChunkRecvCB(spdySession, z, j2, spdyByteArray, i3);
        }
    }

    private void spdyDataRecvCallback(SpdySession spdySession, boolean z, int i2, int i3, int i4) {
        spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - ");
        long j2 = i2 & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyDataRecvCallback(spdySession, z, j2, i3, i4);
        }
    }

    private void spdyDataSendCallback(SpdySession spdySession, boolean z, int i2, int i3, int i4) {
        long j2 = i2 & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyDataSendCallback(spdySession, z, j2, i3, i4);
        }
    }

    private void spdyPingRecvCallback(SpdySession spdySession, int i2, Object obj) {
        spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyPingRecvCallback(spdySession, i2, obj);
        }
    }

    private void spdyRequestRecvCallback(SpdySession spdySession, int i2, int i3) {
        long j2 = i2 & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyRequestRecvCallback(spdySession, j2, i3);
        }
    }

    private void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i2) {
        spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - errorCode = " + i2);
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session is null");
        } else {
            try {
                if (spdySession.intenalcb == null) {
                    spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session.intenalcb is null");
                } else {
                    spdySession.intenalcb.spdySessionCloseCallback(spdySession, obj, superviseConnectInfo, i2);
                }
            } finally {
                spdySession.cleanUp();
            }
        }
        spdySession.releasePptr();
    }

    private void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session.intenalcb is null");
        } else {
            intenalcb.spdySessionConnectCB(spdySession, superviseConnectInfo);
        }
    }

    private void spdySessionFailedError(SpdySession spdySession, int i2, Object obj) {
        spduLog.Logi("tnet-jni", "[spdySessionFailedError] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session is null");
        } else {
            try {
                if (spdySession.intenalcb == null) {
                    spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session.intenalcb is null");
                } else {
                    spdySession.intenalcb.spdySessionFailedError(spdySession, i2, obj);
                }
            } finally {
                spdySession.cleanUp();
            }
        }
        spdySession.releasePptr();
    }

    private void spdySessionOnWritable(SpdySession spdySession, Object obj, int i2) {
        spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - session is null");
            return;
        }
        try {
            if (spdySession.intenalcb == null) {
                spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - session.intenalcb is null");
            } else {
                spdySession.intenalcb.spdySessionOnWritable(spdySession, obj, i2);
            }
        } catch (Throwable th) {
            spduLog.Loge("tnet-jni", "[spdySessionOnWritable] - exception:" + th);
        }
    }

    private void spdyStreamCloseCallback(SpdySession spdySession, int i2, int i3, int i4, SuperviseData superviseData) {
        spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - ");
        long j2 = i2 & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyStreamCloseCallback(spdySession, j2, i3, i4, superviseData);
        }
    }

    private void spdyStreamResponseRecv(SpdySession spdySession, int i2, String[] strArr, int i3) {
        spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - ");
        Map<String, List<String>> stringArrayToMap = stringArrayToMap(strArr);
        long j2 = i2 & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session.intenalcb is null");
        } else {
            intenalcb.spdyOnStreamResponse(spdySession, j2, stringArrayToMap, i3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.util.Map<java.lang.String, java.util.List<java.lang.String>> stringArrayToMap(java.lang.String[] r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            java.util.HashMap r1 = new java.util.HashMap
            r2 = 5
            r1.<init>(r2)
            r2 = 0
        Lb:
            int r3 = r2 + 2
            int r4 = r7.length
            if (r3 > r4) goto L38
            r4 = r7[r2]
            if (r4 == 0) goto L37
            int r4 = r2 + 1
            r5 = r7[r4]
            if (r5 != 0) goto L1b
            goto L37
        L1b:
            r5 = r7[r2]
            java.lang.Object r5 = r1.get(r5)
            java.util.List r5 = (java.util.List) r5
            if (r5 != 0) goto L30
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 1
            r5.<init>(r6)
            r2 = r7[r2]
            r1.put(r2, r5)
        L30:
            r2 = r7[r4]
            r5.add(r2)
            r2 = r3
            goto Lb
        L37:
            return r0
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.spdy.SpdyAgent.stringArrayToMap(java.lang.String[]):java.util.Map");
    }

    static void tableListJudge(int i2) {
        if (i2 < 5242880) {
            return;
        }
        throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + i2, TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
    }

    void clearSpdySession(String str, String str2, int i2) {
        if (str != null) {
            f21520w.lock();
            if (str != null) {
                try {
                    this.sessionMgr.remove(str + str2 + i2);
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }
    }

    public void close() {
    }

    int closeSession(long j2) {
        return closeSessionN(j2);
    }

    public int configLogFile(String str, int i2, int i3) {
        if (loadSucc) {
            return configLogFileN(str, i2, i3);
        }
        return -1;
    }

    @Deprecated
    public SpdySession createSession(String str, Object obj, SessionCb sessionCb, int i2) throws SpdyErrorException {
        return createSession(str, "", obj, sessionCb, null, i2, 0);
    }

    public HashMap<String, SpdySession> getAllSession() {
        return this.sessionMgr;
    }

    public void logFileClose() {
        if (loadSucc) {
            logFileFlushN();
            logFileCloseN();
        }
    }

    public void logFileFlush() {
        if (loadSucc) {
            logFileFlushN();
        }
    }

    void removeSession(SpdySession spdySession) {
        f21520w.lock();
        try {
            this.sessionQueue.remove(spdySession);
        } finally {
            f21520w.unlock();
        }
    }

    public void setAccsSslCallback(AccsSSLCallback accsSSLCallback) {
        spduLog.Logi("tnet-jni", "[setAccsSslCallback] - " + accsSSLCallback.getClass());
        this.accsSSLCallback = accsSSLCallback;
    }

    @Deprecated
    public int setConnectTimeOut(int i2) {
        agentIsOpen();
        try {
            return setConTimeout(this.agentNativePtr, i2);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public void setProxyUsernamePassword(String str, String str2) {
        this.proxyUsername = str;
        this.proxyPassword = str2;
    }

    @Deprecated
    public int setSessionKind(SpdySessionKind spdySessionKind) {
        agentIsOpen();
        try {
            return setSessionKind(this.agentNativePtr, spdySessionKind.getint());
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Deprecated
    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, SslCertcb sslCertcb, int i2) throws SpdyErrorException {
        SpdySession createSession = createSession(spdyRequest.getAuthority(), spdyRequest.getDomain(), obj, sessionCb, sslCertcb, i2, 0, spdyRequest.getConnectionTimeoutMs());
        createSession.submitRequest(spdyRequest, spdyDataProvider, obj2, spdycb);
        return createSession;
    }

    @Deprecated
    public void switchAccsServer(int i2) {
    }

    public int configLogFile(String str, int i2, int i3, int i4) {
        if (loadSucc) {
            return configLogFileN(str, i2, i3, i4);
        }
        return -1;
    }

    @Deprecated
    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, int i2) throws SpdyErrorException {
        return createSession(str, str2, obj, sessionCb, null, i2, 0);
    }

    @Deprecated
    public SpdySession createSession(String str, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i2) throws SpdyErrorException {
        return createSession(str, "", obj, sessionCb, sslCertcb, i2, 0);
    }

    @Deprecated
    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, SslCertcb sslCertcb, int i2, int i3) throws SpdyErrorException {
        SpdySession createSession = createSession(spdyRequest.getAuthority(), spdyRequest.getDomain(), obj, sessionCb, sslCertcb, i2, i3, spdyRequest.getConnectionTimeoutMs());
        createSession.submitRequest(spdyRequest, spdyDataProvider, obj2, spdycb);
        return createSession;
    }

    public SpdySession createSession(SessionInfo sessionInfo) throws SpdyErrorException {
        return createSession(sessionInfo.getAuthority(), sessionInfo.getDomain(), sessionInfo.getSessonUserData(), sessionInfo.getSessionCb(), null, sessionInfo.getMode(), sessionInfo.getPubKeySeqNum(), sessionInfo.getConnectionTimeoutMs(), sessionInfo.getCertHost());
    }

    @Deprecated
    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i2, int i3) throws SpdyErrorException {
        return createSession(str, str2, obj, sessionCb, sslCertcb, i2, i3, -1);
    }

    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, int i2, int i3) throws SpdyErrorException {
        return submitRequest(spdyRequest, spdyDataProvider, obj, obj2, spdycb, sessionCb, null, i2, i3);
    }

    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i2, int i3, int i4) throws SpdyErrorException {
        return createSession(str, str2, obj, sessionCb, sslCertcb, i2, i3, i4, null);
    }

    @Deprecated
    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, int i2) throws SpdyErrorException {
        return submitRequest(spdyRequest, spdyDataProvider, obj, obj2, spdycb, sessionCb, (SslCertcb) null, i2);
    }

    @Deprecated
    public static SpdyAgent getInstance(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind, AccsSSLCallback accsSSLCallback) throws UnsatisfiedLinkError, SpdyErrorException {
        if (gSingleInstance == null) {
            synchronized (lock) {
                if (gSingleInstance == null) {
                    gSingleInstance = new SpdyAgent(context, spdyVersion, spdySessionKind, accsSSLCallback);
                }
            }
        }
        return gSingleInstance;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0189 A[Catch: all -> 0x013d, TryCatch #3 {all -> 0x013d, blocks: (B:59:0x0109, B:61:0x010d, B:34:0x0169, B:36:0x0189, B:40:0x0193, B:33:0x0165), top: B:58:0x0109 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0193 A[Catch: all -> 0x013d, TRY_LEAVE, TryCatch #3 {all -> 0x013d, blocks: (B:59:0x0109, B:61:0x010d, B:34:0x0169, B:36:0x0189, B:40:0x0193, B:33:0x0165), top: B:58:0x0109 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.android.spdy.SpdySession createSession(java.lang.String r25, java.lang.String r26, java.lang.Object r27, org.android.spdy.SessionCb r28, org.android.spdy.SslCertcb r29, int r30, int r31, int r32, java.lang.String r33) throws org.android.spdy.SpdyErrorException {
        /*
            Method dump skipped, instructions count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.spdy.SpdyAgent.createSession(java.lang.String, java.lang.String, java.lang.Object, org.android.spdy.SessionCb, org.android.spdy.SslCertcb, int, int, int, java.lang.String):org.android.spdy.SpdySession");
    }
}
