package org.greenrobot.eventbus;

import android.util.Log;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Logger.java */
/* renamed from: org.greenrobot.eventbus.g */
/* loaded from: classes2.dex */
public interface InterfaceC6053g {

    /* compiled from: Logger.java */
    /* renamed from: org.greenrobot.eventbus.g$a */
    public static class a implements InterfaceC6053g {

        /* renamed from: b */
        static final boolean f21574b;

        /* renamed from: a */
        private final String f21575a;

        static {
            boolean z = false;
            try {
                if (Class.forName("android.util.Log") != null) {
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            }
            f21574b = z;
        }

        public a(String str) {
            this.f21575a = str;
        }

        /* renamed from: a */
        public static boolean m25024a() {
            return f21574b;
        }

        @Override // org.greenrobot.eventbus.InterfaceC6053g
        /* renamed from: a */
        public void mo25022a(Level level, String str) {
            if (level != Level.OFF) {
                Log.println(m25025a(level), this.f21575a, str);
            }
        }

        @Override // org.greenrobot.eventbus.InterfaceC6053g
        /* renamed from: a */
        public void mo25023a(Level level, String str, Throwable th) {
            if (level != Level.OFF) {
                Log.println(m25025a(level), this.f21575a, str + "\n" + Log.getStackTraceString(th));
            }
        }

        /* renamed from: a */
        protected int m25025a(Level level) {
            int intValue = level.intValue();
            if (intValue < 800) {
                return intValue < 500 ? 2 : 3;
            }
            if (intValue < 900) {
                return 4;
            }
            return intValue < 1000 ? 5 : 6;
        }
    }

    /* compiled from: Logger.java */
    /* renamed from: org.greenrobot.eventbus.g$b */
    public static class b implements InterfaceC6053g {

        /* renamed from: a */
        protected final Logger f21576a;

        public b(String str) {
            this.f21576a = Logger.getLogger(str);
        }

        @Override // org.greenrobot.eventbus.InterfaceC6053g
        /* renamed from: a */
        public void mo25022a(Level level, String str) {
            this.f21576a.log(level, str);
        }

        @Override // org.greenrobot.eventbus.InterfaceC6053g
        /* renamed from: a */
        public void mo25023a(Level level, String str, Throwable th) {
            this.f21576a.log(level, str, th);
        }
    }

    /* compiled from: Logger.java */
    /* renamed from: org.greenrobot.eventbus.g$c */
    public static class c implements InterfaceC6053g {
        @Override // org.greenrobot.eventbus.InterfaceC6053g
        /* renamed from: a */
        public void mo25022a(Level level, String str) {
            System.out.println("[" + level + "] " + str);
        }

        @Override // org.greenrobot.eventbus.InterfaceC6053g
        /* renamed from: a */
        public void mo25023a(Level level, String str, Throwable th) {
            System.out.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    /* renamed from: a */
    void mo25022a(Level level, String str);

    /* renamed from: a */
    void mo25023a(Level level, String str, Throwable th);
}
