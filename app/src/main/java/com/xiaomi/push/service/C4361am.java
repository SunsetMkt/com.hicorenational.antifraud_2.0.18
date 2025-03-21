package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.xiaomi.push.service.am */
/* loaded from: classes2.dex */
public class C4361am {

    /* renamed from: a */
    private static C4361am f16541a;

    /* renamed from: a */
    private ConcurrentHashMap<String, HashMap<String, b>> f16543a = new ConcurrentHashMap<>();

    /* renamed from: a */
    private List<a> f16542a = new ArrayList();

    /* renamed from: com.xiaomi.push.service.am$a */
    public interface a {
        /* renamed from: a */
        void mo15814a();
    }

    /* renamed from: com.xiaomi.push.service.am$b */
    public static class b {

        /* renamed from: a */
        public Context f16545a;

        /* renamed from: a */
        Messenger f16547a;

        /* renamed from: a */
        private XMPushService f16549a;

        /* renamed from: a */
        public C4385h f16552a;

        /* renamed from: a */
        public String f16553a;

        /* renamed from: a */
        public boolean f16555a;

        /* renamed from: b */
        public String f16557b;

        /* renamed from: c */
        public String f16559c;

        /* renamed from: d */
        public String f16560d;

        /* renamed from: e */
        public String f16561e;

        /* renamed from: f */
        public String f16562f;

        /* renamed from: g */
        public String f16563g;

        /* renamed from: h */
        public String f16564h;

        /* renamed from: i */
        public String f16565i;

        /* renamed from: a */
        c f16551a = c.unbind;

        /* renamed from: a */
        private int f16544a = 0;

        /* renamed from: a */
        private final CopyOnWriteArrayList<a> f16554a = new CopyOnWriteArrayList<>();

        /* renamed from: b */
        c f16556b = null;

        /* renamed from: b */
        private boolean f16558b = false;

        /* renamed from: a */
        private XMPushService.C4330c f16548a = new XMPushService.C4330c(this);

        /* renamed from: a */
        IBinder.DeathRecipient f16546a = null;

        /* renamed from: a */
        final C7380b f16550a = new C7380b();

        /* renamed from: com.xiaomi.push.service.am$b$a */
        public interface a {
            /* renamed from: a */
            void mo14642a(c cVar, c cVar2, int i2);
        }

        /* renamed from: com.xiaomi.push.service.am$b$c */
        class c implements IBinder.DeathRecipient {

            /* renamed from: a */
            final Messenger f16572a;

            /* renamed from: a */
            final b f16573a;

            c(b bVar, Messenger messenger) {
                this.f16573a = bVar;
                this.f16572a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                AbstractC4022b.m13356b("peer died, chid = " + this.f16573a.f16563g);
                int i2 = 0;
                b.this.f16549a.m15798a(new XMPushService.AbstractC4337j(i2) { // from class: com.xiaomi.push.service.am.b.c.1
                    @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
                    /* renamed from: a */
                    public String mo14643a() {
                        return "clear peer job";
                    }

                    @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
                    /* renamed from: a */
                    public void mo14644a() {
                        c cVar = c.this;
                        if (cVar.f16572a == cVar.f16573a.f16547a) {
                            AbstractC4022b.m13356b("clean peer, chid = " + c.this.f16573a.f16563g);
                            c.this.f16573a.f16547a = null;
                        }
                    }
                }, 0L);
                if ("9".equals(this.f16573a.f16563g) && "com.xiaomi.xmsf".equals(b.this.f16549a.getPackageName())) {
                    b.this.f16549a.m15798a(new XMPushService.AbstractC4337j(i2) { // from class: com.xiaomi.push.service.am.b.c.2
                        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
                        /* renamed from: a */
                        public String mo14643a() {
                            return "check peer job";
                        }

                        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
                        /* renamed from: a */
                        public void mo14644a() {
                            C4361am m15951a = C4361am.m15951a();
                            b bVar = c.this.f16573a;
                            if (m15951a.m15954a(bVar.f16563g, bVar.f16557b).f16547a == null) {
                                XMPushService xMPushService = b.this.f16549a;
                                b bVar2 = c.this.f16573a;
                                xMPushService.m15801a(bVar2.f16563g, bVar2.f16557b, 2, null, null);
                            }
                        }
                    }, C2084a.f6122d);
                }
            }
        }

        public b() {
        }

        /* renamed from: b */
        private boolean m15973b(int i2, int i3, String str) {
            if (i2 == 1) {
                return (this.f16551a == c.binded || !this.f16549a.m15812c() || i3 == 21 || (i3 == 7 && "wait".equals(str))) ? false : true;
            }
            if (i2 == 2) {
                return this.f16549a.m15812c();
            }
            if (i2 != 3) {
                return false;
            }
            return !"wait".equals(str);
        }

        /* renamed from: a */
        public String m15975a(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        /* renamed from: com.xiaomi.push.service.am$b$b, reason: collision with other inner class name */
        class C7380b extends XMPushService.AbstractC4337j {

            /* renamed from: a */
            String f16568a;

            /* renamed from: b */
            int f16569b;

            /* renamed from: b */
            String f16570b;

            /* renamed from: c */
            int f16571c;

            public C7380b() {
                super(0);
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public String mo14643a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public void mo14644a() {
                if (b.this.m15971a(this.f16569b, this.f16571c, this.f16570b)) {
                    b.this.m15969a(this.f16569b, this.f16571c, this.f16568a, this.f16570b);
                    return;
                }
                AbstractC4022b.m13356b(" ignore notify client :" + b.this.f16563g);
            }

            /* renamed from: a */
            public XMPushService.AbstractC4337j m15981a(int i2, int i3, String str, String str2) {
                this.f16569b = i2;
                this.f16571c = i3;
                this.f16570b = str2;
                this.f16568a = str;
                return this;
            }
        }

        /* renamed from: a */
        void m15976a() {
            try {
                Messenger messenger = this.f16547a;
                if (messenger != null && this.f16546a != null) {
                    messenger.getBinder().unlinkToDeath(this.f16546a, 0);
                }
            } catch (Exception unused) {
            }
            this.f16556b = null;
        }

        /* renamed from: b */
        public void m15980b(a aVar) {
            this.f16554a.remove(aVar);
        }

        /* renamed from: a */
        void m15977a(Messenger messenger) {
            m15976a();
            try {
                if (messenger != null) {
                    this.f16547a = messenger;
                    this.f16558b = true;
                    this.f16546a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f16546a, 0);
                } else {
                    AbstractC4022b.m13356b("peer linked with old sdk chid = " + this.f16563g);
                }
            } catch (Exception e2) {
                AbstractC4022b.m13356b("peer linkToDeath err: " + e2.getMessage());
                this.f16547a = null;
                this.f16558b = false;
            }
        }

        public b(XMPushService xMPushService) {
            this.f16549a = xMPushService;
            m15978a(new a() { // from class: com.xiaomi.push.service.am.b.1
                @Override // com.xiaomi.push.service.C4361am.b.a
                /* renamed from: a */
                public void mo14642a(c cVar, c cVar2, int i2) {
                    if (cVar2 == c.binding) {
                        b.this.f16549a.m15798a(b.this.f16548a, C2084a.f6122d);
                    } else {
                        b.this.f16549a.m15810b(b.this.f16548a);
                    }
                }
            });
        }

        /* renamed from: a */
        public void m15979a(c cVar, int i2, int i3, String str, String str2) {
            boolean z;
            Iterator<a> it = this.f16554a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.mo14642a(this.f16551a, cVar, i3);
                }
            }
            c cVar2 = this.f16551a;
            int i4 = 0;
            if (cVar2 != cVar) {
                AbstractC4022b.m13347a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, m15975a(i2), AbstractC4362an.m15982a(i3), str, str2, this.f16563g));
                this.f16551a = cVar;
            }
            if (this.f16552a == null) {
                AbstractC4022b.m13361d("status changed while the client dispatcher is missing");
                return;
            }
            if (cVar == c.binding) {
                return;
            }
            if (this.f16556b != null && (z = this.f16558b)) {
                i4 = (this.f16547a == null || !z) ? Constants.REQUEST_API : 1000;
            }
            this.f16549a.m15810b(this.f16550a);
            if (m15973b(i2, i3, str2)) {
                m15969a(i2, i3, str, str2);
            } else {
                this.f16549a.m15798a(this.f16550a.m15981a(i2, i3, str, str2), i4);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m15969a(int i2, int i3, String str, String str2) {
            c cVar = this.f16551a;
            this.f16556b = cVar;
            if (i2 == 2) {
                this.f16552a.m16103a(this.f16545a, this, i3);
                return;
            }
            if (i2 == 3) {
                this.f16552a.m16104a(this.f16545a, this, str2, str);
                return;
            }
            if (i2 == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.f16544a++;
                } else if (z) {
                    this.f16544a = 0;
                    if (this.f16547a != null) {
                        try {
                            this.f16547a.send(Message.obtain(null, 16, this.f16549a.f16422a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f16552a.m16105a(this.f16549a, this, z, i3, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public boolean m15971a(int i2, int i3, String str) {
            boolean z;
            c cVar = this.f16556b;
            if (cVar == null || !(z = this.f16558b)) {
                return true;
            }
            if (cVar == this.f16551a) {
                AbstractC4022b.m13356b(" status recovered, don't notify client:" + this.f16563g);
                return false;
            }
            if (this.f16547a != null && z) {
                AbstractC4022b.m13356b("Peer alive notify status to client:" + this.f16563g);
                return true;
            }
            AbstractC4022b.m13356b("peer died, ignore notify " + this.f16563g);
            return false;
        }

        /* renamed from: a */
        public void m15978a(a aVar) {
            this.f16554a.add(aVar);
        }

        /* renamed from: a */
        public long m15974a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.f16544a + 1) * 15)) * 1000;
        }

        /* renamed from: a */
        public static String m15968a(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1);
        }
    }

    /* renamed from: com.xiaomi.push.service.am$c */
    public enum c {
        unbind,
        binding,
        binded
    }

    private C4361am() {
    }

    /* renamed from: a */
    public static synchronized C4361am m15951a() {
        C4361am c4361am;
        synchronized (C4361am.class) {
            if (f16541a == null) {
                f16541a = new C4361am();
            }
            c4361am = f16541a;
        }
        return c4361am;
    }

    /* renamed from: b */
    public synchronized void m15965b() {
        this.f16542a.clear();
    }

    /* renamed from: a */
    public synchronized void m15962a(b bVar) {
        HashMap<String, b> hashMap = this.f16543a.get(bVar.f16563g);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f16543a.put(bVar.f16563g, hashMap);
        }
        hashMap.put(m15952a(bVar.f16557b), bVar);
        AbstractC4022b.m13347a("add active client. " + bVar.f16553a);
        Iterator<a> it = this.f16542a.iterator();
        while (it.hasNext()) {
            it.next().mo15814a();
        }
    }

    /* renamed from: a */
    public synchronized void m15964a(String str, String str2) {
        HashMap<String, b> hashMap = this.f16543a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(m15952a(str2));
            if (bVar != null) {
                bVar.m15976a();
            }
            hashMap.remove(m15952a(str2));
            if (hashMap.isEmpty()) {
                this.f16543a.remove(str);
            }
        }
        Iterator<a> it = this.f16542a.iterator();
        while (it.hasNext()) {
            it.next().mo15814a();
        }
    }

    /* renamed from: a */
    public synchronized void m15963a(String str) {
        HashMap<String, b> hashMap = this.f16543a.get(str);
        if (hashMap != null) {
            Iterator<b> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().m15976a();
            }
            hashMap.clear();
            this.f16543a.remove(str);
        }
        Iterator<a> it2 = this.f16542a.iterator();
        while (it2.hasNext()) {
            it2.next().mo15814a();
        }
    }

    /* renamed from: a */
    public synchronized List<String> m15957a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<HashMap<String, b>> it = this.f16543a.values().iterator();
        while (it.hasNext()) {
            for (b bVar : it.next().values()) {
                if (str.equals(bVar.f16553a)) {
                    arrayList.add(bVar.f16563g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized ArrayList<b> m15955a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        Iterator<HashMap<String, b>> it = this.f16543a.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().values());
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized Collection<b> m15956a(String str) {
        if (!this.f16543a.containsKey(str)) {
            return new ArrayList();
        }
        return ((HashMap) this.f16543a.get(str).clone()).values();
    }

    /* renamed from: a */
    public synchronized b m15954a(String str, String str2) {
        HashMap<String, b> hashMap = this.f16543a.get(str);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(m15952a(str2));
    }

    /* renamed from: a */
    public synchronized void m15960a(Context context, int i2) {
        Iterator<HashMap<String, b>> it = this.f16543a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().m15979a(c.unbind, 2, i2, (String) null, (String) null);
            }
        }
    }

    /* renamed from: a */
    public synchronized int m15953a() {
        return this.f16543a.size();
    }

    /* renamed from: a */
    public synchronized void m15958a() {
        Iterator<b> it = m15955a().iterator();
        while (it.hasNext()) {
            it.next().m15976a();
        }
        this.f16543a.clear();
    }

    /* renamed from: a */
    public synchronized void m15959a(Context context) {
        Iterator<HashMap<String, b>> it = this.f16543a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().m15979a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    /* renamed from: a */
    private String m15952a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    /* renamed from: a */
    public synchronized void m15961a(a aVar) {
        this.f16542a.add(aVar);
    }
}
