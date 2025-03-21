package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.service.AbstractC4362an;
import com.xiaomi.push.service.C4361am;
import com.xiaomi.push.service.XMPushService;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.xiaomi.push.fa */
/* loaded from: classes2.dex */
public abstract class AbstractC4207fa {

    /* renamed from: a */
    private static final AtomicInteger f15261a = new AtomicInteger(0);

    /* renamed from: a */
    public static boolean f15262a;

    /* renamed from: a */
    protected C4208fb f15265a;

    /* renamed from: a */
    protected XMPushService f15267a;

    /* renamed from: a */
    protected int f15263a = 0;

    /* renamed from: a */
    protected long f15264a = -1;

    /* renamed from: b */
    protected volatile long f15273b = 0;

    /* renamed from: c */
    protected volatile long f15277c = 0;

    /* renamed from: a */
    private LinkedList<Pair<Integer, Long>> f15270a = new LinkedList<>();

    /* renamed from: a */
    private final Collection<InterfaceC4210fd> f15269a = new CopyOnWriteArrayList();

    /* renamed from: a */
    protected final Map<InterfaceC4212ff, a> f15271a = new ConcurrentHashMap();

    /* renamed from: b */
    protected final Map<InterfaceC4212ff, a> f15275b = new ConcurrentHashMap();

    /* renamed from: a */
    protected InterfaceC4216fj f15266a = null;

    /* renamed from: a */
    protected String f15268a = "";

    /* renamed from: b */
    protected String f15274b = "";

    /* renamed from: c */
    private int f15276c = 2;

    /* renamed from: b */
    protected final int f15272b = f15261a.getAndIncrement();

    /* renamed from: e */
    private long f15279e = 0;

    /* renamed from: d */
    protected long f15278d = 0;

    static {
        f15262a = false;
        try {
            f15262a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        C4213fg.m14798a();
    }

    protected AbstractC4207fa(XMPushService xMPushService, C4208fb c4208fb) {
        this.f15265a = c4208fb;
        this.f15267a = xMPushService;
        m14772b();
    }

    /* renamed from: a */
    private String m14757a(int i2) {
        return i2 == 1 ? "connected" : i2 == 0 ? "connecting" : i2 == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a */
    public C4208fb m14761a() {
        return this.f15265a;
    }

    /* renamed from: a */
    public abstract void mo14741a(AbstractC4221fo abstractC4221fo);

    /* renamed from: a */
    public abstract void mo14742a(C4361am.b bVar);

    /* renamed from: a */
    public abstract void mo14743a(String str, String str2);

    /* renamed from: a */
    public abstract void mo14745a(C4197er[] c4197erArr);

    /* renamed from: a */
    public boolean mo14746a() {
        return false;
    }

    /* renamed from: b */
    public String m14771b() {
        return this.f15265a.m14791b();
    }

    /* renamed from: b */
    public abstract void mo14773b(int i2, Exception exc);

    /* renamed from: b */
    public abstract void mo14748b(C4197er c4197er);

    /* renamed from: b */
    public abstract void mo14777b(boolean z);

    /* renamed from: c */
    public boolean m14780c() {
        return this.f15276c == 1;
    }

    /* renamed from: d */
    public void m14781d() {
        synchronized (this.f15270a) {
            this.f15270a.clear();
        }
    }

    /* renamed from: com.xiaomi.push.fa$a */
    public static class a {

        /* renamed from: a */
        private InterfaceC4212ff f15280a;

        /* renamed from: a */
        private InterfaceC4217fk f15281a;

        public a(InterfaceC4212ff interfaceC4212ff, InterfaceC4217fk interfaceC4217fk) {
            this.f15280a = interfaceC4212ff;
            this.f15281a = interfaceC4217fk;
        }

        /* renamed from: a */
        public void m14783a(AbstractC4221fo abstractC4221fo) {
            InterfaceC4217fk interfaceC4217fk = this.f15281a;
            if (interfaceC4217fk == null || interfaceC4217fk.mo14118a(abstractC4221fo)) {
                this.f15280a.mo14117a(abstractC4221fo);
            }
        }

        /* renamed from: a */
        public void m14782a(C4197er c4197er) {
            this.f15280a.mo14116a(c4197er);
        }
    }

    /* renamed from: a */
    public String mo14762a() {
        return this.f15265a.m14793c();
    }

    /* renamed from: b */
    public void m14774b(InterfaceC4210fd interfaceC4210fd) {
        this.f15269a.remove(interfaceC4210fd);
    }

    /* renamed from: c */
    public synchronized void m14779c() {
        this.f15279e = SystemClock.elapsedRealtime();
    }

    /* renamed from: a */
    public long m14760a() {
        return this.f15277c;
    }

    /* renamed from: b */
    public void m14776b(InterfaceC4212ff interfaceC4212ff, InterfaceC4217fk interfaceC4217fk) {
        if (interfaceC4212ff != null) {
            this.f15275b.put(interfaceC4212ff, new a(interfaceC4212ff, interfaceC4217fk));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    /* renamed from: a */
    public void m14765a(InterfaceC4210fd interfaceC4210fd) {
        if (interfaceC4210fd == null || this.f15269a.contains(interfaceC4210fd)) {
            return;
        }
        this.f15269a.add(interfaceC4210fd);
    }

    /* renamed from: a */
    public void m14767a(InterfaceC4212ff interfaceC4212ff, InterfaceC4217fk interfaceC4217fk) {
        if (interfaceC4212ff != null) {
            this.f15271a.put(interfaceC4212ff, new a(interfaceC4212ff, interfaceC4217fk));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    /* renamed from: b */
    public void m14775b(InterfaceC4212ff interfaceC4212ff) {
        this.f15275b.remove(interfaceC4212ff);
    }

    /* renamed from: b */
    protected void m14772b() {
        String str;
        if (this.f15265a.m14789a() && this.f15266a == null) {
            Class<?> cls = null;
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (cls == null) {
                this.f15266a = new C4205ez(this);
                return;
            }
            try {
                this.f15266a = (InterfaceC4216fj) cls.getConstructor(AbstractC4207fa.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e3) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e3);
            }
        }
    }

    /* renamed from: a */
    public void m14766a(InterfaceC4212ff interfaceC4212ff) {
        this.f15271a.remove(interfaceC4212ff);
    }

    /* renamed from: a */
    protected Map<InterfaceC4212ff, a> m14763a() {
        return this.f15271a;
    }

    /* renamed from: a */
    public int m14759a() {
        return this.f15263a;
    }

    /* renamed from: a */
    public void m14764a(int i2, int i3, Exception exc) {
        int i4 = this.f15276c;
        if (i2 != i4) {
            AbstractC4022b.m13347a(String.format("update the connection status. %1$s -> %2$s : %3$s ", m14757a(i4), m14757a(i2), AbstractC4362an.m15982a(i3)));
        }
        if (C4092au.m13799a((Context) this.f15267a)) {
            m14758a(i2);
        }
        if (i2 == 1) {
            this.f15267a.m15794a(10);
            if (this.f15276c != 0) {
                AbstractC4022b.m13347a("try set connected while not connecting.");
            }
            this.f15276c = i2;
            Iterator<InterfaceC4210fd> it = this.f15269a.iterator();
            while (it.hasNext()) {
                it.next().mo14176b(this);
            }
            return;
        }
        if (i2 == 0) {
            if (this.f15276c != 2) {
                AbstractC4022b.m13347a("try set connecting while not disconnected.");
            }
            this.f15276c = i2;
            Iterator<InterfaceC4210fd> it2 = this.f15269a.iterator();
            while (it2.hasNext()) {
                it2.next().mo14173a(this);
            }
            return;
        }
        if (i2 == 2) {
            this.f15267a.m15794a(10);
            int i5 = this.f15276c;
            if (i5 == 0) {
                Iterator<InterfaceC4210fd> it3 = this.f15269a.iterator();
                while (it3.hasNext()) {
                    it3.next().mo14175a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i5 == 1) {
                Iterator<InterfaceC4210fd> it4 = this.f15269a.iterator();
                while (it4.hasNext()) {
                    it4.next().mo14174a(this, i3, exc);
                }
            }
            this.f15276c = i2;
        }
    }

    /* renamed from: b */
    public boolean m14778b() {
        return this.f15276c == 0;
    }

    /* renamed from: b */
    public int m14770b() {
        return this.f15276c;
    }

    /* renamed from: a */
    public synchronized void m14768a(String str) {
        if (this.f15276c == 0) {
            AbstractC4022b.m13347a("setChallenge hash = " + C4099ba.m13875a(str).substring(0, 8));
            this.f15268a = str;
            m14764a(1, 0, null);
        } else {
            AbstractC4022b.m13347a("ignore setChallenge because connection was disconnected");
        }
    }

    /* renamed from: a */
    public synchronized boolean m14769a(long j2) {
        return this.f15279e >= j2;
    }

    /* renamed from: a */
    private void m14758a(int i2) {
        synchronized (this.f15270a) {
            if (i2 == 1) {
                this.f15270a.clear();
            } else {
                this.f15270a.add(new Pair<>(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())));
                if (this.f15270a.size() > 6) {
                    this.f15270a.remove(0);
                }
            }
        }
    }
}
