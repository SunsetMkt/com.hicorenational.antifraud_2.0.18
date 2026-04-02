package org.greenrobot.eventbus;

import android.util.Log;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes2.dex */
public interface g {

    /* JADX INFO: compiled from: Logger.java */
    public static class a implements g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final boolean f12928b;
        private final String a;

        static {
            boolean z = false;
            try {
                if (Class.forName("android.util.Log") != null) {
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            }
            f12928b = z;
        }

        public a(String str) {
            this.a = str;
        }

        public static boolean a() {
            return f12928b;
        }

        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str) {
            if (level != Level.OFF) {
                Log.println(a(level), this.a, str);
            }
        }

        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str, Throwable th) {
            if (level != Level.OFF) {
                Log.println(a(level), this.a, str + "\n" + Log.getStackTraceString(th));
            }
        }

        protected int a(Level level) {
            int iIntValue = level.intValue();
            if (iIntValue < 800) {
                return iIntValue < 500 ? 2 : 3;
            }
            if (iIntValue < 900) {
                return 4;
            }
            return iIntValue < 1000 ? 5 : 6;
        }
    }

    /* JADX INFO: compiled from: Logger.java */
    public static class b implements g {
        protected final Logger a;

        public b(String str) {
            this.a = Logger.getLogger(str);
        }

        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str) {
            this.a.log(level, str);
        }

        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str, Throwable th) {
            this.a.log(level, str, th);
        }
    }

    /* JADX INFO: compiled from: Logger.java */
    public static class c implements g {
        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str) {
            System.out.println("[" + level + "] " + str);
        }

        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str, Throwable th) {
            System.out.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    void a(Level level, String str);

    void a(Level level, String str, Throwable th);
}
