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

/* JADX INFO: loaded from: classes.dex */
public class RequestManager implements Handler.Callback {
    public static final int NOTIFY_CONNECT_FAILED = 10012;
    public static final int NOTIFY_CONNECT_SUCCESS = 10011;
    public static final int NOTIFY_CONNECT_SUSPENDED = 10013;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile RequestManager f4565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f4566c;
    private static final Object a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Queue<HuaweiApi.RequestHandler> f4567d = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Map<String, HuaweiApi.RequestHandler> f4568e = new LinkedHashMap();

    private RequestManager(Looper looper) {
        f4566c = new Handler(looper, this);
    }

    public static void addRequestToQueue(HuaweiApi.RequestHandler requestHandler) {
        f4567d.add(requestHandler);
    }

    public static void addToConnectedReqMap(final String str, final HuaweiApi.RequestHandler requestHandler) {
        if (f4566c == null) {
            return;
        }
        HMSLog.i("RequestManager", "addToConnectedReqMap");
        f4566c.post(new Runnable() { // from class: com.huawei.hms.common.internal.RequestManager.1
            @Override // java.lang.Runnable
            public void run() {
                RequestManager.f4568e.put(str, requestHandler);
            }
        });
    }

    private void b() {
        while (!f4567d.isEmpty()) {
            HuaweiApi.RequestHandler requestHandlerPoll = f4567d.poll();
            if (requestHandlerPoll != null) {
                Object client = requestHandlerPoll.getClient();
                if (client instanceof BaseHmsClient) {
                    BaseHmsClient baseHmsClient = (BaseHmsClient) client;
                    baseHmsClient.setService(IAIDLInvoke.Stub.asInterface(baseHmsClient.getAdapter().getServiceBinder()));
                    requestHandlerPoll.onConnected();
                }
            }
        }
    }

    private void c() {
        HMSLog.i("RequestManager", "NOTIFY_CONNECT_SUSPENDED.");
        while (!f4567d.isEmpty()) {
            f4567d.poll().onConnectionSuspended(1);
        }
        d();
    }

    private void d() {
        HMSLog.i("RequestManager", "notifyRunningRequestConnectSuspend, connectedReqMap.size(): " + f4568e.size());
        Iterator<Map.Entry<String, HuaweiApi.RequestHandler>> it = f4568e.entrySet().iterator();
        while (it.hasNext()) {
            try {
                it.next().getValue().onConnectionSuspended(1);
            } catch (RuntimeException e2) {
                HMSLog.e("RequestManager", "NOTIFY_CONNECT_SUSPENDED Exception: " + e2.getMessage());
            }
            it.remove();
        }
    }

    public static Handler getHandler() {
        return f4566c;
    }

    public static RequestManager getInstance() {
        synchronized (a) {
            if (f4565b == null) {
                HandlerThread handlerThread = new HandlerThread("RequestManager");
                handlerThread.start();
                f4565b = new RequestManager(handlerThread.getLooper());
            }
        }
        return f4565b;
    }

    public static void removeReqByTransId(final String str) {
        if (f4566c == null) {
            return;
        }
        HMSLog.i("RequestManager", "removeReqByTransId");
        f4566c.post(new Runnable() { // from class: com.huawei.hms.common.internal.RequestManager.2
            @Override // java.lang.Runnable
            public void run() {
                RequestManager.f4568e.remove(str);
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message == null) {
            return false;
        }
        HMSLog.i("RequestManager", "RequestManager handleMessage.");
        switch (message.what) {
            case NOTIFY_CONNECT_SUCCESS /* 10011 */:
                b();
                break;
            case NOTIFY_CONNECT_FAILED /* 10012 */:
                a(message);
                break;
            case NOTIFY_CONNECT_SUSPENDED /* 10013 */:
                c();
                break;
            default:
                HMSLog.i("RequestManager", "handleMessage unknown msg:" + message.what);
                break;
        }
        return false;
    }

    private void a(Message message) {
        HMSLog.i("RequestManager", "NOTIFY_CONNECT_FAILED.");
        try {
            BaseHmsClient.ConnectionResultWrapper connectionResultWrapper = (BaseHmsClient.ConnectionResultWrapper) message.obj;
            HuaweiApi.RequestHandler request = connectionResultWrapper.getRequest();
            f4567d.remove(request);
            request.onConnectionFailed(connectionResultWrapper.getConnectionResult());
        } catch (RuntimeException e2) {
            HMSLog.e("RequestManager", "<handleConnectFailed> handle Failed" + e2.getMessage());
        }
    }
}
