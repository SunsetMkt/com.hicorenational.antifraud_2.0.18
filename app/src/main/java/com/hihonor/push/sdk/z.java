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

/* JADX INFO: loaded from: classes.dex */
public class z implements Handler.Callback {

    /* JADX INFO: renamed from: c */
    public static final z f4293c = new z();
    public final Handler a;

    /* JADX INFO: renamed from: b */
    public final Map<w, a> f4294b = new ConcurrentHashMap(5, 0.75f, 1);

    public static class b implements i0 {
        public f1<?> a;

        public b(f1<?> f1Var) {
            this.a = f1Var;
        }
    }

    public z() {
        HandlerThread handlerThread = new HandlerThread("HonorApiManager");
        handlerThread.start();
        this.a = new Handler(handlerThread.getLooper(), this);
    }

    public <TResult> a1<TResult> a(f1<TResult> f1Var) {
        n0<TResult> n0Var = new n0<>();
        f1Var.a = n0Var;
        Handler handler = this.a;
        handler.sendMessage(handler.obtainMessage(1, f1Var));
        return n0Var.a;
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
            w wVar = f1Var.f4253d;
            if (wVar != null && this.f4294b.containsKey(wVar) && (aVar = this.f4294b.get(wVar)) != null) {
                synchronized (aVar) {
                    String str = "resolveResult apiCall " + f1Var.f4251b;
                    aVar.f4295b.remove(f1Var);
                    if (aVar.a.peek() == null || aVar.f4295b.peek() == null) {
                        aVar.a();
                        z.this.f4294b.remove(aVar.f4298e);
                    }
                }
            }
            return true;
        }
        f1<?> f1Var2 = (f1) message.obj;
        w wVar2 = f1Var2.f4253d;
        a aVar2 = this.f4294b.get(wVar2);
        if (aVar2 == null) {
            aVar2 = new a(wVar2);
            this.f4294b.put(wVar2, aVar2);
        }
        synchronized (aVar2) {
            com.hihonor.push.sdk.b.a(z.this.a);
            String str2 = "sendRequest " + f1Var2.f4251b;
            if (((d0) aVar2.f4296c).a()) {
                aVar2.a(f1Var2);
            } else {
                aVar2.a.add(f1Var2);
                HonorPushErrorEnum honorPushErrorEnum = aVar2.f4297d;
                if (honorPushErrorEnum == null || honorPushErrorEnum.getErrorCode() == 0) {
                    synchronized (aVar2) {
                        com.hihonor.push.sdk.b.a(z.this.a);
                        if (!((d0) aVar2.f4296c).a()) {
                            if (!(((d0) aVar2.f4296c).a.get() == 5)) {
                                d0 d0Var = (d0) aVar2.f4296c;
                                d0Var.getClass();
                                int i3 = d0Var.a.get();
                                String str3 = "enter connect, connection Status: " + i3;
                                if (i3 != 3 && i3 != 5 && i3 != 4) {
                                    l lVar = l.f4263e;
                                    int iB = com.hihonor.push.sdk.b.b(lVar.a());
                                    if (iB == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                        d0Var.a.set(5);
                                        RemoteServiceBean remoteServiceBeanA = com.hihonor.push.sdk.b.a(lVar.a());
                                        f0 f0Var = new f0(remoteServiceBeanA);
                                        d0Var.f4243d = f0Var;
                                        f0Var.f4248b = new c0(d0Var);
                                        if (remoteServiceBeanA.checkServiceInfo()) {
                                            Intent intent = new Intent();
                                            String packageName = f0Var.a.getPackageName();
                                            String packageAction = f0Var.a.getPackageAction();
                                            String packageServiceName = f0Var.a.getPackageServiceName();
                                            if (TextUtils.isEmpty(packageServiceName)) {
                                                intent.setAction(packageAction);
                                                intent.setPackage(packageName);
                                            } else {
                                                intent.setComponent(new ComponentName(packageName, packageServiceName));
                                            }
                                            synchronized (f0.f4247e) {
                                                if (lVar.a().bindService(intent, f0Var, 1)) {
                                                    Handler handler = f0Var.f4249c;
                                                    if (handler != null) {
                                                        handler.removeMessages(1001);
                                                    } else {
                                                        f0Var.f4249c = new Handler(Looper.getMainLooper(), new e0(f0Var));
                                                    }
                                                    f0Var.f4249c.sendEmptyMessageDelayed(1001, com.heytap.mcssdk.constant.a.q);
                                                } else {
                                                    f0Var.f4250d = true;
                                                    f0Var.a(8002001);
                                                }
                                            }
                                        } else {
                                            String str4 = "bind core is null : " + f0Var.a;
                                            f0Var.a(8002004);
                                        }
                                    } else {
                                        d0Var.a(iB);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    aVar2.a(aVar2.f4297d);
                }
            }
        }
        return true;
    }

    public class a implements b0.a {
        public final Queue<f1<?>> a = new LinkedList();

        /* JADX INFO: renamed from: b */
        public final Queue<f1<?>> f4295b = new LinkedList();

        /* JADX INFO: renamed from: c */
        public final b0 f4296c = new d0(this);

        /* JADX INFO: renamed from: d */
        public HonorPushErrorEnum f4297d = null;

        /* JADX INFO: renamed from: e */
        public final w f4298e;

        public a(w wVar) {
            this.f4298e = wVar;
        }

        public final synchronized void a(HonorPushErrorEnum honorPushErrorEnum) {
            com.hihonor.push.sdk.b.a(z.this.a);
            Iterator<f1<?>> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b(honorPushErrorEnum.toApiException(), null);
            }
            this.a.clear();
            this.f4297d = honorPushErrorEnum;
            a();
            z.this.f4294b.remove(this.f4298e);
        }

        public final synchronized void b() {
            com.hihonor.push.sdk.b.a(z.this.a);
            this.f4297d = null;
            Iterator<f1<?>> it = this.a.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            this.a.clear();
        }

        /* JADX WARN: Removed duplicated region for block: B:66:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final synchronized void a(f1<?> f1Var) {
            IPushInvoke iPushInvoke;
            Class cls;
            Type type;
            this.f4295b.add(f1Var);
            b0 b0Var = this.f4296c;
            b bVar = new b(f1Var);
            f1Var.getClass();
            Object objNewInstance = null;
            try {
                Type genericSuperclass = f1Var.getClass().getGenericSuperclass();
                cls = (genericSuperclass == null || (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) == null) ? null : (Class) type;
            } catch (Exception e2) {
                c.a("In newResponseInstance, instancing exception." + e2.getMessage());
            }
            if (cls != null && !cls.isPrimitive()) {
                objNewInstance = cls.newInstance();
                h0 h0Var = new h0(objNewInstance, bVar);
                String str = "start transport parse. " + f1Var.f4251b;
                iPushInvoke = ((d0) b0Var).f4241b;
                String str2 = f1Var.f4251b;
                RequestHeader requestHeader = f1Var.f4254e;
                IMessageEntity iMessageEntity = f1Var.f4252c;
                Bundle bundle = new Bundle();
                Bundle bundle2 = new Bundle();
                MessageCodec.formMessageEntity(requestHeader, bundle);
                MessageCodec.formMessageEntity(iMessageEntity, bundle2);
                DataBuffer dataBuffer = new DataBuffer(str2, bundle, bundle2);
                if (iPushInvoke != null) {
                }
            } else {
                h0 h0Var2 = new h0(objNewInstance, bVar);
                String str3 = "start transport parse. " + f1Var.f4251b;
                iPushInvoke = ((d0) b0Var).f4241b;
                String str22 = f1Var.f4251b;
                RequestHeader requestHeader2 = f1Var.f4254e;
                IMessageEntity iMessageEntity2 = f1Var.f4252c;
                Bundle bundle3 = new Bundle();
                Bundle bundle22 = new Bundle();
                MessageCodec.formMessageEntity(requestHeader2, bundle3);
                MessageCodec.formMessageEntity(iMessageEntity2, bundle22);
                DataBuffer dataBuffer2 = new DataBuffer(str22, bundle3, bundle22);
                if (iPushInvoke != null) {
                    try {
                        iPushInvoke.call(dataBuffer2, h0Var2);
                    } catch (Exception e3) {
                        String str4 = "transport remote error. " + e3;
                    }
                }
            }
        }

        public void a() {
            com.hihonor.push.sdk.b.a(z.this.a);
            d0 d0Var = (d0) this.f4296c;
            int i2 = d0Var.a.get();
            String str = "enter disconnect, connection Status: " + i2;
            if (i2 != 3) {
                if (i2 != 5) {
                    return;
                }
                d0Var.a.set(4);
            } else {
                f0 f0Var = d0Var.f4243d;
                if (f0Var != null) {
                    f0Var.b();
                }
                d0Var.a.set(1);
            }
        }
    }
}
