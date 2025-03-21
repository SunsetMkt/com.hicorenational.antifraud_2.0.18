package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.C3336at;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class UMConfigureImpl {

    /* renamed from: e */
    private static final int f12411e = 1000;

    /* renamed from: f */
    private static ScheduledExecutorService f12412f;

    /* renamed from: g */
    private static Context f12413g;

    /* renamed from: a */
    private static String f12407a = C3336at.m10865b().m10868b(C3336at.f11501o);

    /* renamed from: b */
    private static CopyOnWriteArrayList<onMessageSendListener> f12408b = new CopyOnWriteArrayList<>();

    /* renamed from: c */
    private static int f12409c = 0;

    /* renamed from: d */
    private static boolean f12410d = false;

    /* renamed from: h */
    private static int f12414h = 0;

    /* renamed from: i */
    private static Runnable f12415i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f12409c == 0 || UMConfigureImpl.f12414h >= 10) {
                    if (!UMConfigureImpl.f12410d) {
                        boolean unused = UMConfigureImpl.f12410d = true;
                        UMConfigureImpl.m11521b(UMConfigureImpl.f12413g);
                    }
                    if (UMConfigureImpl.f12412f != null) {
                        UMConfigureImpl.f12412f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f12412f = null;
                    }
                }
                UMConfigureImpl.m11527f();
            } catch (Exception unused3) {
            }
        }
    };

    /* renamed from: f */
    static /* synthetic */ int m11527f() {
        int i2 = f12414h;
        f12414h = i2 + 1;
        return i2;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        f12413g = context;
        try {
            if (f12409c < 1) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else if (m11525d(context)) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else {
                UMEnvelopeBuild.setTransmissionSendFlag(false);
                m11522c(context);
                if (f12412f == null) {
                    f12412f = Executors.newScheduledThreadPool(1);
                    f12412f.scheduleAtFixedRate(f12415i, 0L, 100L, TimeUnit.MILLISECONDS);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f12409c++;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        synchronized (UMConfigureImpl.class) {
            try {
                if (f12408b != null) {
                    f12408b.add(onmessagesendlistener);
                }
                if (UMEnvelopeBuild.getTransmissionSendFlag() && f12408b != null && f12408b.size() > 0) {
                    Iterator<onMessageSendListener> it = f12408b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f12409c--;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        synchronized (UMConfigureImpl.class) {
            try {
                if (f12408b != null) {
                    f12408b.remove(onmessagesendlistener);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static synchronized void m11521b(Context context) {
        synchronized (UMConfigureImpl.class) {
            try {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
                if (f12408b != null && f12408b.size() > 0) {
                    Iterator<onMessageSendListener> it = f12408b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: c */
    private static void m11522c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f12407a, 0);
            if (sharedPreferences == null || sharedPreferences == null) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(f12407a, true);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    private static boolean m11525d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f12407a, 0);
            if (sharedPreferences == null || sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.getBoolean(f12407a, false);
        } catch (Throwable unused) {
            return false;
        }
    }
}
