package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class am {
    private static am a;

    /* JADX INFO: renamed from: a */
    private ConcurrentHashMap<String, HashMap<String, b>> f989a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a */
    private List<a> f988a = new ArrayList();

    public interface a {
        void a();
    }

    public static class b {

        /* JADX INFO: renamed from: a */
        public Context f990a;

        /* JADX INFO: renamed from: a */
        Messenger f992a;

        /* JADX INFO: renamed from: a */
        private XMPushService f994a;

        /* JADX INFO: renamed from: a */
        public h f997a;

        /* JADX INFO: renamed from: a */
        public String f998a;

        /* JADX INFO: renamed from: a */
        public boolean f1000a;

        /* JADX INFO: renamed from: b */
        public String f1001b;

        /* JADX INFO: renamed from: c */
        public String f9358c;

        /* JADX INFO: renamed from: d */
        public String f9359d;

        /* JADX INFO: renamed from: e */
        public String f9360e;

        /* JADX INFO: renamed from: f */
        public String f9361f;

        /* JADX INFO: renamed from: g */
        public String f9362g;

        /* JADX INFO: renamed from: h */
        public String f9363h;

        /* JADX INFO: renamed from: i */
        public String f9364i;

        /* JADX INFO: renamed from: a */
        c f996a = c.unbind;
        private int a = 0;

        /* JADX INFO: renamed from: a */
        private final CopyOnWriteArrayList<a> f999a = new CopyOnWriteArrayList<>();

        /* JADX INFO: renamed from: b */
        c f9357b = null;

        /* JADX INFO: renamed from: b */
        private boolean f1002b = false;

        /* JADX INFO: renamed from: a */
        private XMPushService.c f993a = new XMPushService.c(this);

        /* JADX INFO: renamed from: a */
        IBinder.DeathRecipient f991a = null;

        /* JADX INFO: renamed from: a */
        final C0153b f995a = new C0153b();

        /* JADX INFO: renamed from: com.xiaomi.push.service.am$b$1 */
        class AnonymousClass1 implements a {
            AnonymousClass1() {
            }

            @Override // com.xiaomi.push.service.am.b.a
            public void a(c cVar, c cVar2, int i2) {
                if (cVar2 == c.binding) {
                    b.this.f994a.a(b.this.f993a, com.heytap.mcssdk.constant.a.f3868d);
                } else {
                    b.this.f994a.b(b.this.f993a);
                }
            }
        }

        public interface a {
            void a(c cVar, c cVar2, int i2);
        }

        class c implements IBinder.DeathRecipient {
            final Messenger a;

            /* JADX INFO: renamed from: a */
            final b f1005a;

            /* JADX INFO: renamed from: com.xiaomi.push.service.am$b$c$1 */
            class AnonymousClass1 extends XMPushService.j {
                AnonymousClass1(int i2) {
                    super(i2);
                }

                @Override // com.xiaomi.push.service.XMPushService.j
                public String a() {
                    return "clear peer job";
                }

                @Override // com.xiaomi.push.service.XMPushService.j
                /* JADX INFO: renamed from: a */
                public void mo377a() {
                    c cVar = c.this;
                    if (cVar.a == cVar.f1005a.f992a) {
                        com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + c.this.f1005a.f9362g);
                        c.this.f1005a.f992a = null;
                    }
                }
            }

            /* JADX INFO: renamed from: com.xiaomi.push.service.am$b$c$2 */
            class AnonymousClass2 extends XMPushService.j {
                AnonymousClass2(int i2) {
                    super(i2);
                }

                @Override // com.xiaomi.push.service.XMPushService.j
                public String a() {
                    return "check peer job";
                }

                @Override // com.xiaomi.push.service.XMPushService.j
                /* JADX INFO: renamed from: a */
                public void mo377a() {
                    am amVarA = am.a();
                    b bVar = c.this.f1005a;
                    if (amVarA.a(bVar.f9362g, bVar.f1001b).f992a == null) {
                        XMPushService xMPushService = b.this.f994a;
                        b bVar2 = c.this.f1005a;
                        xMPushService.a(bVar2.f9362g, bVar2.f1001b, 2, null, null);
                    }
                }
            }

            c(b bVar, Messenger messenger) {
                this.f1005a = bVar;
                this.a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f1005a.f9362g);
                b.this.f994a.a(new XMPushService.j(0) { // from class: com.xiaomi.push.service.am.b.c.1
                    AnonymousClass1(int i2) {
                        super(i2);
                    }

                    @Override // com.xiaomi.push.service.XMPushService.j
                    public String a() {
                        return "clear peer job";
                    }

                    @Override // com.xiaomi.push.service.XMPushService.j
                    /* JADX INFO: renamed from: a */
                    public void mo377a() {
                        c cVar = c.this;
                        if (cVar.a == cVar.f1005a.f992a) {
                            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + c.this.f1005a.f9362g);
                            c.this.f1005a.f992a = null;
                        }
                    }
                }, 0L);
                if ("9".equals(this.f1005a.f9362g) && "com.xiaomi.xmsf".equals(b.this.f994a.getPackageName())) {
                    b.this.f994a.a(new XMPushService.j(0) { // from class: com.xiaomi.push.service.am.b.c.2
                        AnonymousClass2(int i2) {
                            super(i2);
                        }

                        @Override // com.xiaomi.push.service.XMPushService.j
                        public String a() {
                            return "check peer job";
                        }

                        @Override // com.xiaomi.push.service.XMPushService.j
                        /* JADX INFO: renamed from: a */
                        public void mo377a() {
                            am amVarA = am.a();
                            b bVar = c.this.f1005a;
                            if (amVarA.a(bVar.f9362g, bVar.f1001b).f992a == null) {
                                XMPushService xMPushService = b.this.f994a;
                                b bVar2 = c.this.f1005a;
                                xMPushService.a(bVar2.f9362g, bVar2.f1001b, 2, null, null);
                            }
                        }
                    }, com.heytap.mcssdk.constant.a.f3868d);
                }
            }
        }

        public b() {
        }

        private boolean b(int i2, int i3, String str) {
            if (i2 == 1) {
                return (this.f996a == c.binded || !this.f994a.m666c() || i3 == 21 || (i3 == 7 && "wait".equals(str))) ? false : true;
            }
            if (i2 == 2) {
                return this.f994a.m666c();
            }
            if (i2 != 3) {
                return false;
            }
            return !"wait".equals(str);
        }

        public String a(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        /* JADX INFO: renamed from: com.xiaomi.push.service.am$b$b */
        class C0153b extends XMPushService.j {

            /* JADX INFO: renamed from: a */
            String f1003a;

            /* JADX INFO: renamed from: b */
            int f9365b;

            /* JADX INFO: renamed from: b */
            String f1004b;

            /* JADX INFO: renamed from: c */
            int f9366c;

            public C0153b() {
                super(0);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo377a() {
                if (b.this.a(this.f9365b, this.f9366c, this.f1004b)) {
                    b.this.a(this.f9365b, this.f9366c, this.f1003a, this.f1004b);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.f9362g);
            }

            public XMPushService.j a(int i2, int i3, String str, String str2) {
                this.f9365b = i2;
                this.f9366c = i3;
                this.f1004b = str2;
                this.f1003a = str;
                return this;
            }
        }

        /* JADX INFO: renamed from: a */
        void m697a() {
            try {
                Messenger messenger = this.f992a;
                if (messenger != null && this.f991a != null) {
                    messenger.getBinder().unlinkToDeath(this.f991a, 0);
                }
            } catch (Exception unused) {
            }
            this.f9357b = null;
        }

        public void b(a aVar) {
            this.f999a.remove(aVar);
        }

        void a(Messenger messenger) {
            m697a();
            try {
                if (messenger != null) {
                    this.f992a = messenger;
                    this.f1002b = true;
                    this.f991a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f991a, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.f9362g);
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e2.getMessage());
                this.f992a = null;
                this.f1002b = false;
            }
        }

        public b(XMPushService xMPushService) {
            this.f994a = xMPushService;
            a(new a() { // from class: com.xiaomi.push.service.am.b.1
                AnonymousClass1() {
                }

                @Override // com.xiaomi.push.service.am.b.a
                public void a(c cVar, c cVar2, int i2) {
                    if (cVar2 == c.binding) {
                        b.this.f994a.a(b.this.f993a, com.heytap.mcssdk.constant.a.f3868d);
                    } else {
                        b.this.f994a.b(b.this.f993a);
                    }
                }
            });
        }

        public void a(c cVar, int i2, int i3, String str, String str2) {
            boolean z;
            for (a aVar : this.f999a) {
                if (aVar != null) {
                    aVar.a(this.f996a, cVar, i3);
                }
            }
            c cVar2 = this.f996a;
            int i4 = 0;
            if (cVar2 != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m48a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i2), an.a(i3), str, str2, this.f9362g));
                this.f996a = cVar;
            }
            if (this.f997a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
                return;
            }
            if (cVar == c.binding) {
                return;
            }
            if (this.f9357b != null && (z = this.f1002b)) {
                i4 = (this.f992a == null || !z) ? Constants.REQUEST_API : 1000;
            }
            this.f994a.b(this.f995a);
            if (b(i2, i3, str2)) {
                a(i2, i3, str, str2);
            } else {
                this.f994a.a(this.f995a.a(i2, i3, str, str2), i4);
            }
        }

        public void a(int i2, int i3, String str, String str2) {
            c cVar = this.f996a;
            this.f9357b = cVar;
            if (i2 == 2) {
                this.f997a.a(this.f990a, this, i3);
                return;
            }
            if (i2 == 3) {
                this.f997a.a(this.f990a, this, str2, str);
                return;
            }
            if (i2 == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.a++;
                } else if (z) {
                    this.a = 0;
                    if (this.f992a != null) {
                        try {
                            this.f992a.send(Message.obtain(null, 16, this.f994a.f935a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f997a.a(this.f994a, this, z, i3, str);
            }
        }

        public boolean a(int i2, int i3, String str) {
            boolean z;
            c cVar = this.f9357b;
            if (cVar == null || !(z = this.f1002b)) {
                return true;
            }
            if (cVar == this.f996a) {
                com.xiaomi.channel.commonutils.logger.b.b(" status recovered, don't notify client:" + this.f9362g);
                return false;
            }
            if (this.f992a != null && z) {
                com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.f9362g);
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.b("peer died, ignore notify " + this.f9362g);
            return false;
        }

        public void a(a aVar) {
            this.f999a.add(aVar);
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((long) ((this.a + 1) * 15))) * 1000;
        }

        public static String a(String str) {
            int iLastIndexOf;
            return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(iLastIndexOf + 1);
        }
    }

    public enum c {
        unbind,
        binding,
        binded
    }

    private am() {
    }

    public static synchronized am a() {
        if (a == null) {
            a = new am();
        }
        return a;
    }

    public synchronized void b() {
        this.f988a.clear();
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> map = this.f989a.get(bVar.f9362g);
        if (map == null) {
            map = new HashMap<>();
            this.f989a.put(bVar.f9362g, map);
        }
        map.put(a(bVar.f1001b), bVar);
        com.xiaomi.channel.commonutils.logger.b.m48a("add active client. " + bVar.f998a);
        Iterator<a> it = this.f988a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m695a(String str, String str2) {
        HashMap<String, b> map = this.f989a.get(str);
        if (map != null) {
            b bVar = map.get(a(str2));
            if (bVar != null) {
                bVar.m697a();
            }
            map.remove(a(str2));
            if (map.isEmpty()) {
                this.f989a.remove(str);
            }
        }
        Iterator<a> it = this.f988a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m694a(String str) {
        HashMap<String, b> map = this.f989a.get(str);
        if (map != null) {
            Iterator<b> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().m697a();
            }
            map.clear();
            this.f989a.remove(str);
        }
        Iterator<a> it2 = this.f988a.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized List<String> m692a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<HashMap<String, b>> it = this.f989a.values().iterator();
        while (it.hasNext()) {
            for (b bVar : it.next().values()) {
                if (str.equals(bVar.f998a)) {
                    arrayList.add(bVar.f9362g);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public synchronized ArrayList<b> m690a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        Iterator<HashMap<String, b>> it = this.f989a.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().values());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public synchronized Collection<b> m691a(String str) {
        if (!this.f989a.containsKey(str)) {
            return new ArrayList();
        }
        return ((HashMap) this.f989a.get(str).clone()).values();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> map = this.f989a.get(str);
        if (map == null) {
            return null;
        }
        return map.get(a(str2));
    }

    public synchronized void a(Context context, int i2) {
        Iterator<HashMap<String, b>> it = this.f989a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().a(c.unbind, 2, i2, (String) null, (String) null);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized int m689a() {
        return this.f989a.size();
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m693a() {
        Iterator<b> it = m690a().iterator();
        while (it.hasNext()) {
            it.next().m697a();
        }
        this.f989a.clear();
    }

    public synchronized void a(Context context) {
        Iterator<HashMap<String, b>> it = this.f989a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("@");
        return iIndexOf > 0 ? str.substring(0, iIndexOf) : str;
    }

    public synchronized void a(a aVar) {
        this.f988a.add(aVar);
    }
}
