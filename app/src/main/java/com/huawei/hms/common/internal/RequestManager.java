package com.huawei.hms.common.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class RequestManager implements Handler.Callback {
    public static final int NOTIFY_CONNECT_FAILED = 10012;
    public static final int NOTIFY_CONNECT_SUCCESS = 10011;
    public static final int NOTIFY_CONNECT_SUSPENDED = 10013;

    /* renamed from: b */
    private static volatile RequestManager f7285b;

    /* renamed from: c */
    private static Handler f7286c;

    /* renamed from: a */
    private static final Object f7284a = new Object();

    /* renamed from: d */
    private static Queue<HuaweiApi.RequestHandler> f7287d = new ConcurrentLinkedQueue();

    /* renamed from: e */
    private static Map<String, HuaweiApi.RequestHandler> f7288e = new LinkedHashMap();

    private RequestManager(Looper looper) {
        f7286c = new Handler(looper, this);
    }

    public static void addRequestToQueue(HuaweiApi.RequestHandler requestHandler) {
        f7287d.add(requestHandler);
    }

    public static void addToConnectedReqMap(final String str, final HuaweiApi.RequestHandler requestHandler) {
        if (f7286c == null) {
            return;
        }
        HMSLog.m7717i("RequestManager", "addToConnectedReqMap");
        f7286c.post(new Runnable() { // from class: com.huawei.hms.common.internal.RequestManager.1
            @Override // java.lang.Runnable
            public void run() {
                RequestManager.f7288e.put(str, requestHandler);
            }
        });
    }

    /* renamed from: b */
    private void m6745b() {
        while (!f7287d.isEmpty()) {
            HuaweiApi.RequestHandler poll = f7287d.poll();
            if (poll != null) {
                Object client = poll.getClient();
                if (client instanceof BaseHmsClient) {
                    BaseHmsClient baseHmsClient = (BaseHmsClient) client;
                    baseHmsClient.setService(IAIDLInvoke.Stub.asInterface(baseHmsClient.getAdapter().getServiceBinder()));
                    poll.onConnected();
                }
            }
        }
    }

    /* renamed from: c */
    private void m6746c() {
        HMSLog.m7717i("RequestManager", "NOTIFY_CONNECT_SUSPENDED.");
        while (!f7287d.isEmpty()) {
            f7287d.poll().onConnectionSuspended(1);
        }
        m6747d();
    }

    /* renamed from: d */
    private void m6747d() {
        HMSLog.m7717i("RequestManager", "notifyRunningRequestConnectSuspend, connectedReqMap.size(): " + f7288e.size());
        Iterator<Map.Entry<String, HuaweiApi.RequestHandler>> it = f7288e.entrySet().iterator();
        while (it.hasNext()) {
            try {
                it.next().getValue().onConnectionSuspended(1);
            } catch (RuntimeException e2) {
                HMSLog.m7715e("RequestManager", "NOTIFY_CONNECT_SUSPENDED Exception: " + e2.getMessage());
            }
            it.remove();
        }
    }

    public static Handler getHandler() {
        return f7286c;
    }

    public static RequestManager getInstance() {
        synchronized (f7284a) {
            if (f7285b == null) {
                HandlerThread handlerThread = new HandlerThread("RequestManager");
                handlerThread.start();
                f7285b = new RequestManager(handlerThread.getLooper());
            }
        }
        return f7285b;
    }

    public static void removeReqByTransId(final String str) {
        if (f7286c == null) {
            return;
        }
        HMSLog.m7717i("RequestManager", "removeReqByTransId");
        f7286c.post(new Runnable() { // from class: com.huawei.hms.common.internal.RequestManager.2
            @Override // java.lang.Runnable
            public void run() {
                RequestManager.f7288e.remove(str);
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message == null) {
            return false;
        }
        HMSLog.m7717i("RequestManager", "RequestManager handleMessage.");
        switch (message.what) {
            case NOTIFY_CONNECT_SUCCESS /* 10011 */:
                m6745b();
                break;
            case NOTIFY_CONNECT_FAILED /* 10012 */:
                m6744a(message);
                break;
            case NOTIFY_CONNECT_SUSPENDED /* 10013 */:
                m6746c();
                break;
            default:
                HMSLog.m7717i("RequestManager", "handleMessage unknown msg:" + message.what);
                break;
        }
        return false;
    }

    /* renamed from: a */
    private void m6744a(Message message) {
        HMSLog.m7717i("RequestManager", "NOTIFY_CONNECT_FAILED.");
        try {
            BaseHmsClient.ConnectionResultWrapper connectionResultWrapper = (BaseHmsClient.ConnectionResultWrapper) message.obj;
            HuaweiApi.RequestHandler request = connectionResultWrapper.getRequest();
            f7287d.remove(request);
            request.onConnectionFailed(connectionResultWrapper.getConnectionResult());
        } catch (RuntimeException e2) {
            HMSLog.m7715e("RequestManager", "<handleConnectFailed> handle Failed" + e2.getMessage());
        }
    }
}
