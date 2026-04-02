package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.at;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class UMConfigureImpl {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f7493e = 1000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ScheduledExecutorService f7494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Context f7495g;
    private static String a = at.b().b(at.o);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static CopyOnWriteArrayList<onMessageSendListener> f7490b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f7491c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f7492d = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f7496h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Runnable f7497i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f7491c == 0 || UMConfigureImpl.f7496h >= 10) {
                    if (!UMConfigureImpl.f7492d) {
                        boolean unused = UMConfigureImpl.f7492d = true;
                        UMConfigureImpl.b(UMConfigureImpl.f7495g);
                    }
                    if (UMConfigureImpl.f7494f != null) {
                        UMConfigureImpl.f7494f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f7494f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception unused3) {
            }
        }
    };

    static /* synthetic */ int f() {
        int i2 = f7496h;
        f7496h = i2 + 1;
        return i2;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        f7495g = context;
        try {
            if (f7491c < 1 || d(context)) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else {
                UMEnvelopeBuild.setTransmissionSendFlag(false);
                c(context);
                if (f7494f == null) {
                    f7494f = Executors.newScheduledThreadPool(1);
                    f7494f.scheduleAtFixedRate(f7497i, 0L, 100L, TimeUnit.MILLISECONDS);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerInterruptFlag() {
        try {
            f7491c++;
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        try {
            if (f7490b != null) {
                f7490b.add(onmessagesendlistener);
            }
            if (UMEnvelopeBuild.getTransmissionSendFlag() && f7490b != null && f7490b.size() > 0) {
                Iterator<onMessageSendListener> it = f7490b.iterator();
                while (it.hasNext()) {
                    it.next().onMessageSend();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void removeInterruptFlag() {
        try {
            f7491c--;
        } catch (Exception unused) {
        }
    }

    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        try {
            if (f7490b != null) {
                f7490b.remove(onmessagesendlistener);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(Context context) {
        try {
            UMEnvelopeBuild.setTransmissionSendFlag(true);
            if (f7490b != null && f7490b.size() > 0) {
                Iterator<onMessageSendListener> it = f7490b.iterator();
                while (it.hasNext()) {
                    it.next().onMessageSend();
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
            if (sharedPreferences == null || sharedPreferences == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(a, true);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    private static boolean d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
            if (sharedPreferences == null || sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.getBoolean(a, false);
        } catch (Throwable unused) {
            return false;
        }
    }
}
