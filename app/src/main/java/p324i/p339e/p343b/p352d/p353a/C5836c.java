package p324i.p339e.p343b.p352d.p353a;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import bean.SurveyH5Bean;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: IdentifierIdClient.java */
/* renamed from: i.e.b.d.a.c */
/* loaded from: classes2.dex */
public class C5836c {

    /* renamed from: A */
    private static boolean f21017A = false;

    /* renamed from: B */
    private static int f21018B = 13;

    /* renamed from: C */
    private static C5837d f21019C = null;

    /* renamed from: D */
    private static C5837d f21020D = null;

    /* renamed from: E */
    private static C5837d f21021E = null;

    /* renamed from: F */
    private static C5837d f21022F = null;

    /* renamed from: G */
    private static HandlerThread f21023G = null;

    /* renamed from: H */
    private static Handler f21024H = null;

    /* renamed from: I */
    private static String f21025I = null;

    /* renamed from: J */
    private static String f21026J = null;

    /* renamed from: K */
    private static String f21027K = null;

    /* renamed from: L */
    private static String f21028L = null;

    /* renamed from: M */
    private static String f21029M = null;

    /* renamed from: N */
    private static String f21030N = null;

    /* renamed from: O */
    private static String f21031O = null;

    /* renamed from: P */
    private static volatile C5836c f21032P = null;

    /* renamed from: Q */
    private static volatile C5835b f21033Q = null;

    /* renamed from: R */
    private static int f21034R = 0;

    /* renamed from: S */
    private static int f21035S = 0;

    /* renamed from: T */
    private static int f21036T = 0;

    /* renamed from: U */
    private static int f21037U = 0;

    /* renamed from: V */
    private static int f21038V = 0;

    /* renamed from: W */
    private static int f21039W = 0;

    /* renamed from: X */
    private static int f21040X = 0;

    /* renamed from: Y */
    private static int f21041Y = 0;

    /* renamed from: Z */
    private static int f21042Z = 0;

    /* renamed from: a0 */
    private static int f21043a0 = 0;

    /* renamed from: b */
    private static final String f21044b = "VMS_SDK_Client";

    /* renamed from: b0 */
    private static int f21045b0 = 0;

    /* renamed from: c */
    private static final String f21046c = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: c0 */
    private static int f21047c0 = 0;

    /* renamed from: d */
    private static final String f21048d = "persist.sys.identifierid.supported";

    /* renamed from: e */
    public static final String f21049e = "persist.sys.identifierid";

    /* renamed from: f */
    private static final String f21050f = "com.vivo.vms";

    /* renamed from: g */
    private static final String f21051g = "appid";

    /* renamed from: h */
    private static final String f21052h = "type";

    /* renamed from: i */
    private static final String f21053i = "OAID";

    /* renamed from: j */
    private static final String f21054j = "VAID";

    /* renamed from: k */
    private static final String f21055k = "OAIDSTATUS";

    /* renamed from: l */
    private static Object f21056l = new Object();

    /* renamed from: m */
    private static final int f21057m = 0;

    /* renamed from: n */
    private static final int f21058n = 1;

    /* renamed from: o */
    private static final int f21059o = 2;

    /* renamed from: p */
    private static final int f21060p = 3;

    /* renamed from: q */
    private static final int f21061q = 4;

    /* renamed from: r */
    private static final int f21062r = 5;

    /* renamed from: s */
    private static final int f21063s = 6;

    /* renamed from: t */
    private static final int f21064t = 7;

    /* renamed from: u */
    private static final int f21065u = 8;

    /* renamed from: v */
    private static final int f21066v = 9;

    /* renamed from: w */
    private static final int f21067w = 10;

    /* renamed from: x */
    private static final int f21068x = 11;

    /* renamed from: y */
    private static final int f21069y = 2000;

    /* renamed from: z */
    private static Context f21070z;

    /* renamed from: a */
    private final int f21071a;

    /* compiled from: IdentifierIdClient.java */
    /* renamed from: i.e.b.d.a.c$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C5836c.f21034R + C5836c.f21035S + C5836c.f21040X + C5836c.f21043a0 + C5836c.f21036T + C5836c.f21037U + C5836c.f21042Z + C5836c.f21043a0 + C5836c.f21038V + C5836c.f21039W + C5836c.f21045b0 + C5836c.f21047c0 > 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("oaid", C5836c.this.m24494a(C5836c.f21034R, C5836c.f21035S, C5836c.f21040X, C5836c.f21041Y));
                contentValues.put("vaid", C5836c.this.m24494a(C5836c.f21036T, C5836c.f21037U, C5836c.f21042Z, C5836c.f21043a0));
                contentValues.put("aaid", C5836c.this.m24494a(C5836c.f21038V, C5836c.f21039W, C5836c.f21045b0, C5836c.f21047c0));
                C5836c.f21033Q.m24486a(7, "vivo", new ContentValues[]{contentValues});
                int unused = C5836c.f21034R = C5836c.f21035S = C5836c.f21036T = C5836c.f21037U = C5836c.f21038V = C5836c.f21039W = 0;
                int unused2 = C5836c.f21040X = C5836c.f21041Y = C5836c.f21042Z = C5836c.f21043a0 = C5836c.f21045b0 = C5836c.f21047c0 = 0;
            }
        }
    }

    /* compiled from: IdentifierIdClient.java */
    /* renamed from: i.e.b.d.a.c$b */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 11) {
                int i2 = message.getData().getInt("type");
                try {
                    String m24484a = C5836c.f21033Q.m24484a(i2, message.getData().getString("appid"));
                    if (i2 == 0) {
                        String unused = C5836c.f21025I = m24484a;
                        C5836c.m24506c(8, C5836c.f21025I);
                    } else if (i2 == 1) {
                        if (m24484a != null) {
                            String unused2 = C5836c.f21026J = m24484a;
                        }
                        C5836c.m24506c(9, C5836c.f21026J);
                    } else if (i2 == 2) {
                        if (m24484a != null) {
                            String unused3 = C5836c.f21027K = m24484a;
                        }
                        C5836c.m24506c(10, C5836c.f21027K);
                    } else if (i2 != 3) {
                        if (i2 == 4) {
                            String unused4 = C5836c.f21029M = m24484a;
                        } else if (i2 == 5 && m24484a != null) {
                            String unused5 = C5836c.f21030N = m24484a;
                        }
                    } else if (m24484a != null) {
                        String unused6 = C5836c.f21028L = m24484a;
                    }
                } catch (Exception e2) {
                    String str = "readException:" + e2.toString();
                }
                synchronized (C5836c.f21056l) {
                    C5836c.f21056l.notify();
                }
            }
        }
    }

    private C5836c() {
        m24524n();
        f21033Q = new C5835b(f21070z);
        this.f21071a = m24504c(f21070z);
    }

    /* renamed from: m */
    private void m24523m() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new a(), 600L, 600L, TimeUnit.SECONDS);
    }

    /* renamed from: n */
    private static void m24524n() {
        f21023G = new HandlerThread("SqlWorkThread");
        f21023G.start();
        f21024H = new b(f21023G.getLooper());
    }

    /* renamed from: o */
    private static void m24525o() {
        f21017A = "1".equals(m24497a(f21048d, "0")) || "1".equals(m24497a(f21049e, "0"));
    }

    /* renamed from: p */
    static boolean m24526p() {
        if (!f21017A) {
            m24525o();
        }
        return f21017A;
    }

    /* renamed from: g */
    String m24546g() {
        String str = f21027K;
        if (str != null) {
            m24506c(2, str);
            return f21027K;
        }
        m24509d(2, "vivo");
        if (f21021E == null) {
            m24498a(f21070z, 2, "vivo");
        }
        m24506c(2, f21027K);
        return f21027K;
    }

    /* renamed from: h */
    String m24547h() {
        m24512e(4, null);
        return f21029M;
    }

    /* renamed from: i */
    String m24548i() {
        String str = f21030N;
        if (str != null) {
            return str;
        }
        m24512e(5, "vivo");
        return f21030N;
    }

    /* renamed from: j */
    String m24549j() {
        String str = f21030N;
        if (str != null) {
            return str;
        }
        m24509d(5, "vivo");
        return f21030N;
    }

    /* renamed from: c */
    private static int m24504c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(f21050f, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* renamed from: d */
    String m24543d() {
        String str = f21026J;
        if (str != null) {
            m24506c(1, str);
            return f21026J;
        }
        m24512e(1, "vivo");
        if (f21020D == null) {
            m24498a(f21070z, 1, "vivo");
        }
        m24506c(1, f21026J);
        return f21026J;
    }

    /* renamed from: e */
    String m24544e() {
        String str = f21026J;
        if (str != null) {
            m24506c(1, str);
            return f21026J;
        }
        m24509d(1, "vivo");
        if (f21020D == null) {
            m24498a(f21070z, 1, "vivo");
        }
        m24506c(1, f21026J);
        return f21026J;
    }

    /* renamed from: f */
    String m24545f() {
        String str = f21027K;
        if (str != null) {
            m24506c(2, str);
            return f21027K;
        }
        m24512e(2, "vivo");
        if (f21021E == null) {
            m24498a(f21070z, 2, "vivo");
        }
        m24506c(2, f21027K);
        return f21027K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m24494a(int i2, int i3, int i4, int i5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i2);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(i3);
        stringBuffer.append(";");
        stringBuffer.append(i4);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(i5);
        return stringBuffer.toString();
    }

    /* renamed from: b */
    static C5836c m24500b(Context context) {
        if (m24526p()) {
            return m24493a(context);
        }
        return null;
    }

    /* renamed from: a */
    static C5836c m24493a(Context context) {
        if (f21070z == null) {
            if (context == null) {
                return null;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            f21070z = context;
        }
        if (f21032P == null) {
            synchronized (C5836c.class) {
                if (f21032P == null) {
                    f21032P = new C5836c();
                    f21032P.m24523m();
                }
            }
        }
        return f21032P;
    }

    /* renamed from: b */
    String m24540b() {
        String str = f21025I;
        if (str != null) {
            m24506c(0, str);
            return f21025I;
        }
        m24512e(0, null);
        if (f21019C == null) {
            m24498a(f21070z, 0, null);
        }
        m24506c(0, f21025I);
        return f21025I;
    }

    /* renamed from: c */
    String m24542c() {
        String str = f21025I;
        if (str != null) {
            m24506c(0, str);
            return f21025I;
        }
        m24509d(0, null);
        if (f21019C == null) {
            m24498a(f21070z, 0, null);
        }
        m24506c(0, f21025I);
        return f21025I;
    }

    /* renamed from: d */
    private void m24509d(int i2, String str) {
        m24538a(i2, str);
    }

    /* renamed from: e */
    private void m24512e(int i2, String str) {
        synchronized (f21056l) {
            m24538a(i2, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f21056l.wait(2000L);
            } catch (InterruptedException unused) {
            }
            int i3 = ((SystemClock.uptimeMillis() - uptimeMillis) > 2000L ? 1 : ((SystemClock.uptimeMillis() - uptimeMillis) == 2000L ? 0 : -1));
        }
    }

    /* renamed from: b */
    List m24541b(List<String> list) {
        if (this.f21071a >= f21018B && list != null && list.size() != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    String[] split = list.get(i2).split(Constants.COLON_SEPARATOR);
                    if (split.length == 2) {
                        arrayList.add(Boolean.valueOf(f21033Q.m24485a(6, "vivo", split[0], split[1])));
                    }
                }
                return arrayList;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m24506c(int i2, String str) {
        if (i2 == 0) {
            if (str == null) {
                f21035S++;
                return;
            } else {
                f21034R++;
            }
        }
        if (i2 == 1) {
            if (str == null) {
                f21037U++;
                return;
            } else {
                f21036T++;
                return;
            }
        }
        if (i2 == 2) {
            if (str == null) {
                f21039W++;
                return;
            } else {
                f21038V++;
                return;
            }
        }
        switch (i2) {
            case 8:
                if (str != null) {
                    f21040X++;
                    break;
                } else {
                    f21041Y++;
                    break;
                }
            case 9:
                if (str != null) {
                    f21042Z++;
                    break;
                } else {
                    f21043a0++;
                    break;
                }
            case 10:
                if (str != null) {
                    f21045b0++;
                    break;
                } else {
                    f21047c0++;
                    break;
                }
        }
    }

    /* renamed from: a */
    String m24537a() {
        String str = f21028L;
        if (str != null) {
            return str;
        }
        m24512e(3, null);
        return f21028L;
    }

    /* renamed from: a */
    boolean m24539a(List<String> list) {
        if (this.f21071a >= f21018B && list != null && list.size() != 0) {
            try {
                ContentValues[] contentValuesArr = new ContentValues[list.size()];
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
                for (int i2 = 0; i2 < list.size(); i2++) {
                    ContentValues contentValues = new ContentValues();
                    String[] split = list.get(i2).split(Constants.COLON_SEPARATOR);
                    if (split.length != 2) {
                        return false;
                    }
                    String str = split[0];
                    String str2 = split[1];
                    contentValues.put(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, str);
                    contentValues.put("uid", str2);
                    contentValues.put(SurveyH5Bean.VALUE, format);
                    contentValuesArr[i2] = contentValues;
                }
                return f21033Q.m24486a(6, "vivo", contentValuesArr);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    void m24538a(int i2, String str) {
        Message obtainMessage = f21024H.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2 || i2 == 6) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        f21024H.sendMessage(obtainMessage);
    }

    /* renamed from: a */
    private static String m24497a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "0");
            } catch (Exception e2) {
                String str3 = "getProperty: invoke is error" + e2.getMessage();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* renamed from: a */
    private static synchronized void m24498a(Context context, int i2, String str) {
        synchronized (C5836c.class) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        if (f21021E == null) {
                            f21021E = new C5837d(f21032P, 2, str);
                            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + context.getPackageName()), false, f21021E);
                        }
                    }
                } else if (f21020D == null) {
                    f21020D = new C5837d(f21032P, 1, str);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, f21020D);
                }
            } else if (f21019C == null) {
                f21019C = new C5837d(f21032P, 0, null);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f21019C);
            }
        }
    }
}
