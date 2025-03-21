package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.b0;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class z implements Handler.Callback {

    /* renamed from: c, reason: collision with root package name */
    public static final z f6357c = new z();

    /* renamed from: a, reason: collision with root package name */
    public final Handler f6358a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<w, a> f6359b = new ConcurrentHashMap(5, 0.75f, 1);

    public static class b implements i0 {

        /* renamed from: a, reason: collision with root package name */
        public f1<?> f6366a;

        public b(f1<?> f1Var) {
            this.f6366a = f1Var;
        }
    }

    public z() {
        HandlerThread handlerThread = new HandlerThread("HonorApiManager");
        handlerThread.start();
        this.f6358a = new Handler(handlerThread.getLooper(), this);
    }

    public <TResult> a1<TResult> a(f1<TResult> f1Var) {
        n0<TResult> n0Var = new n0<>();
        f1Var.f6276a = n0Var;
        Handler handler = this.f6358a;
        handler.sendMessage(handler.obtainMessage(1, f1Var));
        return n0Var.f6310a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a aVar;
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                return false;
            }
            f1 f1Var = (f1) message.obj;
            w wVar = f1Var.f6279d;
            if (wVar != null && this.f6359b.containsKey(wVar) && (aVar = this.f6359b.get(wVar)) != null) {
                synchronized (aVar) {
                    String str = "resolveResult apiCall " + f1Var.f6277b;
                    aVar.f6361b.remove(f1Var);
                    if (aVar.f6360a.peek() == null || aVar.f6361b.peek() == null) {
                        aVar.a();
                        z.this.f6359b.remove(aVar.f6364e);
                    }
                }
            }
            return true;
        }
        f1<?> f1Var2 = (f1) message.obj;
        w wVar2 = f1Var2.f6279d;
        a aVar2 = this.f6359b.get(wVar2);
        if (aVar2 == null) {
            aVar2 = new a(wVar2);
            this.f6359b.put(wVar2, aVar2);
        }
        synchronized (aVar2) {
            com.hihonor.push.sdk.b.a(z.this.f6358a);
            String str2 = "sendRequest " + f1Var2.f6277b;
            if (((d0) aVar2.f6362c).a()) {
                aVar2.a(f1Var2);
            } else {
                aVar2.f6360a.add(f1Var2);
                HonorPushErrorEnum honorPushErrorEnum = aVar2.f6363d;
                if (honorPushErrorEnum == null || honorPushErrorEnum.getErrorCode() == 0) {
                    synchronized (aVar2) {
                        com.hihonor.push.sdk.b.a(z.this.f6358a);
                        if (!((d0) aVar2.f6362c).a()) {
                            if (!(((d0) aVar2.f6362c).f6261a.get() == 5)) {
                                d0 d0Var = (d0) aVar2.f6362c;
                                d0Var.getClass();
                                int i3 = d0Var.f6261a.get();
                                String str3 = "enter connect, connection Status: " + i3;
                                if (i3 != 3 && i3 != 5 && i3 != 4) {
                                    l lVar = l.f6299e;
                                    int b2 = com.hihonor.push.sdk.b.b(lVar.a());
                                    if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                        d0Var.f6261a.set(5);
                                        RemoteServiceBean a2 = com.hihonor.push.sdk.b.a(lVar.a());
                                        f0 f0Var = new f0(a2);
                                        d0Var.f6264d = f0Var;
                                        f0Var.f6273b = new c0(d0Var);
                                        if (a2.checkServiceInfo()) {
                                            Intent intent = new Intent();
                                            String packageName = f0Var.f6272a.getPackageName();
                                            String packageAction = f0Var.f6272a.getPackageAction();
                                            String packageServiceName = f0Var.f6272a.getPackageServiceName();
                                            if (TextUtils.isEmpty(packageServiceName)) {
                                                intent.setAction(packageAction);
                                                intent.setPackage(packageName);
                                            } else {
                                                intent.setComponent(new ComponentName(packageName, packageServiceName));
                                            }
                                            synchronized (f0.f6271e) {
                                                if (lVar.a().bindService(intent, f0Var, 1)) {
                                                    Handler handler = f0Var.f6274c;
                                                    if (handler != null) {
                                                        handler.removeMessages(1001);
                                                    } else {
                                                        f0Var.f6274c = new Handler(Looper.getMainLooper(), new e0(f0Var));
                                                    }
                                                    f0Var.f6274c.sendEmptyMessageDelayed(1001, com.heytap.mcssdk.constant.a.q);
                                                } else {
                                                    f0Var.f6275d = true;
                                                    f0Var.a(8002001);
                                                }
                                            }
                                        } else {
                                            String str4 = "bind core is null : " + f0Var.f6272a;
                                            f0Var.a(8002004);
                                        }
                                    } else {
                                        d0Var.a(b2);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    aVar2.a(aVar2.f6363d);
                }
            }
        }
        return true;
    }

    public class a implements b0.a {

        /* renamed from: a, reason: collision with root package name */
        public final Queue<f1<?>> f6360a = new LinkedList();

        /* renamed from: b, reason: collision with root package name */
        public final Queue<f1<?>> f6361b = new LinkedList();

        /* renamed from: c, reason: collision with root package name */
        public final b0 f6362c = new d0(this);

        /* renamed from: d, reason: collision with root package name */
        public HonorPushErrorEnum f6363d = null;

        /* renamed from: e, reason: collision with root package name */
        public final w f6364e;

        public a(w wVar) {
            this.f6364e = wVar;
        }

        public final synchronized void a(HonorPushErrorEnum honorPushErrorEnum) {
            com.hihonor.push.sdk.b.a(z.this.f6358a);
            Iterator<f1<?>> it = this.f6360a.iterator();
            while (it.hasNext()) {
                it.next().b(honorPushErrorEnum.toApiException(), null);
            }
            this.f6360a.clear();
            this.f6363d = honorPushErrorEnum;
            a();
            z.this.f6359b.remove(this.f6364e);
        }

        public final synchronized void b() {
            com.hihonor.push.sdk.b.a(z.this.f6358a);
            this.f6363d = null;
            Iterator<f1<?>> it = this.f6360a.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            this.f6360a.clear();
        }

        public final synchronized void a(f1<?> f1Var) {
            Type type;
            this.f6361b.add(f1Var);
            b0 b0Var = this.f6362c;
            b bVar = new b(f1Var);
            f1Var.getClass();
            Object obj = null;
            try {
                Type genericSuperclass = f1Var.getClass().getGenericSuperclass();
                Class cls = (genericSuperclass == null || (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) == null) ? null : (Class) type;
                if (cls != null && !cls.isPrimitive()) {
                    obj = cls.newInstance();
                }
            } catch (Exception e2) {
                c.a("In newResponseInstance, instancing exception." + e2.getMessage());
            }
            h0 h0Var = new h0(obj, bVar);
            String str = "start transport parse. " + f1Var.f6277b;
            IPushInvoke iPushInvoke = ((d0) b0Var).f6262b;
            String str2 = f1Var.f6277b;
            RequestHeader requestHeader = f1Var.f6280e;
            IMessageEntity iMessageEntity = f1Var.f6278c;
            Bundle bundle = new Bundle();
            Bundle bundle2 = new Bundle();
            MessageCodec.formMessageEntity(requestHeader, bundle);
            MessageCodec.formMessageEntity(iMessageEntity, bundle2);
            DataBuffer dataBuffer = new DataBuffer(str2, bundle, bundle2);
            if (iPushInvoke != null) {
                try {
                    iPushInvoke.call(dataBuffer, h0Var);
                } catch (Exception e3) {
                    String str3 = "transport remote error. " + e3;
                }
            }
        }

        public void a() {
            com.hihonor.push.sdk.b.a(z.this.f6358a);
            d0 d0Var = (d0) this.f6362c;
            int i2 = d0Var.f6261a.get();
            String str = "enter disconnect, connection Status: " + i2;
            if (i2 != 3) {
                if (i2 != 5) {
                    return;
                }
                d0Var.f6261a.set(4);
            } else {
                f0 f0Var = d0Var.f6264d;
                if (f0Var != null) {
                    f0Var.b();
                }
                d0Var.f6261a.set(1);
            }
        }
    }
}
