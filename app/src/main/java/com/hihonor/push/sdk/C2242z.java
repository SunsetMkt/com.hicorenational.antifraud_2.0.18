package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.InterfaceC2187b0;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.hihonor.push.sdk.z */
/* loaded from: classes.dex */
public class C2242z implements Handler.Callback {

    /* renamed from: c */
    public static final C2242z f6856c = new C2242z();

    /* renamed from: a */
    public final Handler f6857a;

    /* renamed from: b */
    public final Map<C2236w, a> f6858b = new ConcurrentHashMap(5, 0.75f, 1);

    /* renamed from: com.hihonor.push.sdk.z$b */
    public static class b implements InterfaceC2209i0 {

        /* renamed from: a */
        public AbstractC2201f1<?> f6865a;

        public b(AbstractC2201f1<?> abstractC2201f1) {
            this.f6865a = abstractC2201f1;
        }
    }

    public C2242z() {
        HandlerThread handlerThread = new HandlerThread("HonorApiManager");
        handlerThread.start();
        this.f6857a = new Handler(handlerThread.getLooper(), this);
    }

    /* renamed from: a */
    public <TResult> C2185a1<TResult> m6403a(AbstractC2201f1<TResult> abstractC2201f1) {
        C2219n0<TResult> c2219n0 = new C2219n0<>();
        abstractC2201f1.f6775a = c2219n0;
        Handler handler = this.f6857a;
        handler.sendMessage(handler.obtainMessage(1, abstractC2201f1));
        return c2219n0.f6809a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a aVar;
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                return false;
            }
            AbstractC2201f1 abstractC2201f1 = (AbstractC2201f1) message.obj;
            C2236w c2236w = abstractC2201f1.f6778d;
            if (c2236w != null && this.f6858b.containsKey(c2236w) && (aVar = this.f6858b.get(c2236w)) != null) {
                synchronized (aVar) {
                    String str = "resolveResult apiCall " + abstractC2201f1.f6776b;
                    aVar.f6860b.remove(abstractC2201f1);
                    if (aVar.f6859a.peek() == null || aVar.f6860b.peek() == null) {
                        aVar.m6404a();
                        C2242z.this.f6858b.remove(aVar.f6863e);
                    }
                }
            }
            return true;
        }
        AbstractC2201f1<?> abstractC2201f12 = (AbstractC2201f1) message.obj;
        C2236w c2236w2 = abstractC2201f12.f6778d;
        a aVar2 = this.f6858b.get(c2236w2);
        if (aVar2 == null) {
            aVar2 = new a(c2236w2);
            this.f6858b.put(c2236w2, aVar2);
        }
        synchronized (aVar2) {
            C2186b.m6366a(C2242z.this.f6857a);
            String str2 = "sendRequest " + abstractC2201f12.f6776b;
            if (((C2194d0) aVar2.f6861c).m6383a()) {
                aVar2.m6405a(abstractC2201f12);
            } else {
                aVar2.f6859a.add(abstractC2201f12);
                HonorPushErrorEnum honorPushErrorEnum = aVar2.f6862d;
                if (honorPushErrorEnum == null || honorPushErrorEnum.getErrorCode() == 0) {
                    synchronized (aVar2) {
                        C2186b.m6366a(C2242z.this.f6857a);
                        if (!((C2194d0) aVar2.f6861c).m6383a()) {
                            if (!(((C2194d0) aVar2.f6861c).f6760a.get() == 5)) {
                                C2194d0 c2194d0 = (C2194d0) aVar2.f6861c;
                                c2194d0.getClass();
                                int i3 = c2194d0.f6760a.get();
                                String str3 = "enter connect, connection Status: " + i3;
                                if (i3 != 3 && i3 != 5 && i3 != 4) {
                                    C2214l c2214l = C2214l.f6798e;
                                    int m6371b = C2186b.m6371b(c2214l.m6393a());
                                    if (m6371b == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                        c2194d0.f6760a.set(5);
                                        RemoteServiceBean m6361a = C2186b.m6361a(c2214l.m6393a());
                                        ServiceConnectionC2200f0 serviceConnectionC2200f0 = new ServiceConnectionC2200f0(m6361a);
                                        c2194d0.f6763d = serviceConnectionC2200f0;
                                        serviceConnectionC2200f0.f6772b = new C2190c0(c2194d0);
                                        if (m6361a.checkServiceInfo()) {
                                            Intent intent = new Intent();
                                            String packageName = serviceConnectionC2200f0.f6771a.getPackageName();
                                            String packageAction = serviceConnectionC2200f0.f6771a.getPackageAction();
                                            String packageServiceName = serviceConnectionC2200f0.f6771a.getPackageServiceName();
                                            if (TextUtils.isEmpty(packageServiceName)) {
                                                intent.setAction(packageAction);
                                                intent.setPackage(packageName);
                                            } else {
                                                intent.setComponent(new ComponentName(packageName, packageServiceName));
                                            }
                                            synchronized (ServiceConnectionC2200f0.f6770e) {
                                                if (c2214l.m6393a().bindService(intent, serviceConnectionC2200f0, 1)) {
                                                    Handler handler = serviceConnectionC2200f0.f6773c;
                                                    if (handler != null) {
                                                        handler.removeMessages(1001);
                                                    } else {
                                                        serviceConnectionC2200f0.f6773c = new Handler(Looper.getMainLooper(), new C2197e0(serviceConnectionC2200f0));
                                                    }
                                                    serviceConnectionC2200f0.f6773c.sendEmptyMessageDelayed(1001, C2084a.f6135q);
                                                } else {
                                                    serviceConnectionC2200f0.f6774d = true;
                                                    serviceConnectionC2200f0.m6385a(8002001);
                                                }
                                            }
                                        } else {
                                            String str4 = "bind core is null : " + serviceConnectionC2200f0.f6771a;
                                            serviceConnectionC2200f0.m6385a(8002004);
                                        }
                                    } else {
                                        c2194d0.m6382a(m6371b);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    aVar2.m6406a(aVar2.f6862d);
                }
            }
        }
        return true;
    }

    /* renamed from: com.hihonor.push.sdk.z$a */
    public class a implements InterfaceC2187b0.a {

        /* renamed from: a */
        public final Queue<AbstractC2201f1<?>> f6859a = new LinkedList();

        /* renamed from: b */
        public final Queue<AbstractC2201f1<?>> f6860b = new LinkedList();

        /* renamed from: c */
        public final InterfaceC2187b0 f6861c = new C2194d0(this);

        /* renamed from: d */
        public HonorPushErrorEnum f6862d = null;

        /* renamed from: e */
        public final C2236w f6863e;

        public a(C2236w c2236w) {
            this.f6863e = c2236w;
        }

        /* renamed from: a */
        public final synchronized void m6406a(HonorPushErrorEnum honorPushErrorEnum) {
            C2186b.m6366a(C2242z.this.f6857a);
            Iterator<AbstractC2201f1<?>> it = this.f6859a.iterator();
            while (it.hasNext()) {
                it.next().m6387b(honorPushErrorEnum.toApiException(), null);
            }
            this.f6859a.clear();
            this.f6862d = honorPushErrorEnum;
            m6404a();
            C2242z.this.f6858b.remove(this.f6863e);
        }

        /* renamed from: b */
        public final synchronized void m6407b() {
            C2186b.m6366a(C2242z.this.f6857a);
            this.f6862d = null;
            Iterator<AbstractC2201f1<?>> it = this.f6859a.iterator();
            while (it.hasNext()) {
                m6405a(it.next());
            }
            this.f6859a.clear();
        }

        /* renamed from: a */
        public final synchronized void m6405a(AbstractC2201f1<?> abstractC2201f1) {
            Type type;
            this.f6860b.add(abstractC2201f1);
            InterfaceC2187b0 interfaceC2187b0 = this.f6861c;
            b bVar = new b(abstractC2201f1);
            abstractC2201f1.getClass();
            Object obj = null;
            try {
                Type genericSuperclass = abstractC2201f1.getClass().getGenericSuperclass();
                Class cls = (genericSuperclass == null || (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) == null) ? null : (Class) type;
                if (cls != null && !cls.isPrimitive()) {
                    obj = cls.newInstance();
                }
            } catch (Exception e2) {
                C2189c.m6376a("In newResponseInstance, instancing exception." + e2.getMessage());
            }
            BinderC2206h0 binderC2206h0 = new BinderC2206h0(obj, bVar);
            String str = "start transport parse. " + abstractC2201f1.f6776b;
            IPushInvoke iPushInvoke = ((C2194d0) interfaceC2187b0).f6761b;
            String str2 = abstractC2201f1.f6776b;
            RequestHeader requestHeader = abstractC2201f1.f6779e;
            IMessageEntity iMessageEntity = abstractC2201f1.f6777c;
            Bundle bundle = new Bundle();
            Bundle bundle2 = new Bundle();
            MessageCodec.formMessageEntity(requestHeader, bundle);
            MessageCodec.formMessageEntity(iMessageEntity, bundle2);
            DataBuffer dataBuffer = new DataBuffer(str2, bundle, bundle2);
            if (iPushInvoke != null) {
                try {
                    iPushInvoke.call(dataBuffer, binderC2206h0);
                } catch (Exception e3) {
                    String str3 = "transport remote error. " + e3;
                }
            }
        }

        /* renamed from: a */
        public void m6404a() {
            C2186b.m6366a(C2242z.this.f6857a);
            C2194d0 c2194d0 = (C2194d0) this.f6861c;
            int i2 = c2194d0.f6760a.get();
            String str = "enter disconnect, connection Status: " + i2;
            if (i2 != 3) {
                if (i2 != 5) {
                    return;
                }
                c2194d0.f6760a.set(4);
            } else {
                ServiceConnectionC2200f0 serviceConnectionC2200f0 = c2194d0.f6763d;
                if (serviceConnectionC2200f0 != null) {
                    serviceConnectionC2200f0.m6386b();
                }
                c2194d0.f6760a.set(1);
            }
        }
    }
}
