package p286h.p292i2;

import com.umeng.analytics.AnalyticsConfig;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import p286h.C5715y1;
import p286h.InterfaceC5440n0;
import p286h.InterfaceC5713y;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5506l;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Timer.kt */
@InterfaceC5481e(name = "TimersKt")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001aJ\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001aL\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001a\u001a\u0010\u0010\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001aJ\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001aL\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001a$\u0010\u0011\u001a\u00020\f2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001a0\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001a8\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001a0\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001a8\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001a8\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001a8\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b¨\u0006\u0016"}, m23546d2 = {"fixedRateTimer", "Ljava/util/Timer;", CommonNetImpl.NAME, "", "daemon", "", "startAt", "Ljava/util/Date;", AnalyticsConfig.RTD_PERIOD, "", "action", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "initialDelay", "timer", "timerTask", "schedule", "time", "delay", "scheduleAtFixedRate", "kotlin-stdlib"}, m23547k = 2, m23548mv = {1, 1, 16})
/* renamed from: h.i2.c */
/* loaded from: classes2.dex */
public final class C5338c {

    /* compiled from: Timer.kt */
    /* renamed from: h.i2.c$a */
    public static final class a extends TimerTask {

        /* renamed from: a */
        final /* synthetic */ InterfaceC5506l f20218a;

        public a(InterfaceC5506l interfaceC5506l) {
            this.f20218a = interfaceC5506l;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f20218a.invoke(this);
        }
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final TimerTask m21908a(@InterfaceC5816d Timer timer, long j2, InterfaceC5506l<? super TimerTask, C5715y1> interfaceC5506l) {
        a aVar = new a(interfaceC5506l);
        timer.schedule(aVar, j2);
        return aVar;
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final TimerTask m21915b(@InterfaceC5816d Timer timer, long j2, long j3, InterfaceC5506l<? super TimerTask, C5715y1> interfaceC5506l) {
        a aVar = new a(interfaceC5506l);
        timer.scheduleAtFixedRate(aVar, j2, j3);
        return aVar;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final TimerTask m21910a(@InterfaceC5816d Timer timer, Date date, InterfaceC5506l<? super TimerTask, C5715y1> interfaceC5506l) {
        a aVar = new a(interfaceC5506l);
        timer.schedule(aVar, date);
        return aVar;
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final TimerTask m21916b(@InterfaceC5816d Timer timer, Date date, long j2, InterfaceC5506l<? super TimerTask, C5715y1> interfaceC5506l) {
        a aVar = new a(interfaceC5506l);
        timer.scheduleAtFixedRate(aVar, date, j2);
        return aVar;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final TimerTask m21907a(@InterfaceC5816d Timer timer, long j2, long j3, InterfaceC5506l<? super TimerTask, C5715y1> interfaceC5506l) {
        a aVar = new a(interfaceC5506l);
        timer.schedule(aVar, j2, j3);
        return aVar;
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final Timer m21911b(String str, boolean z, long j2, long j3, InterfaceC5506l<? super TimerTask, C5715y1> interfaceC5506l) {
        Timer m21901a = m21901a(str, z);
        m21901a.schedule(new a(interfaceC5506l), j2, j3);
        return m21901a;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final TimerTask m21909a(@InterfaceC5816d Timer timer, Date date, long j2, InterfaceC5506l<? super TimerTask, C5715y1> interfaceC5506l) {
        a aVar = new a(interfaceC5506l);
        timer.schedule(aVar, date, j2);
        return aVar;
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final Timer m21913b(String str, boolean z, Date date, long j2, InterfaceC5506l<? super TimerTask, C5715y1> interfaceC5506l) {
        Timer m21901a = m21901a(str, z);
        m21901a.schedule(new a(interfaceC5506l), date, j2);
        return m21901a;
    }

    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: a */
    public static final Timer m21901a(@InterfaceC5817e String str, boolean z) {
        return str == null ? new Timer(z) : new Timer(str, z);
    }

    /* renamed from: b */
    static /* synthetic */ Timer m21912b(String str, boolean z, long j2, long j3, InterfaceC5506l interfaceC5506l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            j2 = 0;
        }
        Timer m21901a = m21901a(str, z);
        m21901a.schedule(new a(interfaceC5506l), j2, j3);
        return m21901a;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final Timer m21902a(String str, boolean z, long j2, long j3, InterfaceC5506l<? super TimerTask, C5715y1> interfaceC5506l) {
        Timer m21901a = m21901a(str, z);
        m21901a.scheduleAtFixedRate(new a(interfaceC5506l), j2, j3);
        return m21901a;
    }

    /* renamed from: b */
    static /* synthetic */ Timer m21914b(String str, boolean z, Date date, long j2, InterfaceC5506l interfaceC5506l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        Timer m21901a = m21901a(str, z);
        m21901a.schedule(new a(interfaceC5506l), date, j2);
        return m21901a;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final Timer m21904a(String str, boolean z, Date date, long j2, InterfaceC5506l<? super TimerTask, C5715y1> interfaceC5506l) {
        Timer m21901a = m21901a(str, z);
        m21901a.scheduleAtFixedRate(new a(interfaceC5506l), date, j2);
        return m21901a;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final TimerTask m21906a(InterfaceC5506l<? super TimerTask, C5715y1> interfaceC5506l) {
        return new a(interfaceC5506l);
    }

    /* renamed from: a */
    static /* synthetic */ Timer m21903a(String str, boolean z, long j2, long j3, InterfaceC5506l interfaceC5506l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            j2 = 0;
        }
        Timer m21901a = m21901a(str, z);
        m21901a.scheduleAtFixedRate(new a(interfaceC5506l), j2, j3);
        return m21901a;
    }

    /* renamed from: a */
    static /* synthetic */ Timer m21905a(String str, boolean z, Date date, long j2, InterfaceC5506l interfaceC5506l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        Timer m21901a = m21901a(str, z);
        m21901a.scheduleAtFixedRate(new a(interfaceC5506l), date, j2);
        return m21901a;
    }
}
