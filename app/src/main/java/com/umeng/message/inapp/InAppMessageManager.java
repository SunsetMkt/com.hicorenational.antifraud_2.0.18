package com.umeng.message.inapp;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.ae;
import com.umeng.message.proguard.ag;
import com.umeng.message.proguard.ai;
import com.umeng.message.proguard.aq;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.h;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class InAppMessageManager {
    public static boolean a = false;

    /* JADX INFO: renamed from: d */
    public static int f7890d = 1800000;

    /* JADX INFO: renamed from: e */
    public static int f7891e = 1000;

    /* JADX INFO: renamed from: f */
    private static InAppMessageManager f7892f;

    /* JADX INFO: renamed from: b */
    public final Context f7893b;

    /* JADX INFO: renamed from: c */
    String f7894c;

    /* JADX INFO: renamed from: h */
    private final aq f7896h = new aq("in_app");

    /* JADX INFO: renamed from: g */
    private UInAppHandler f7895g = new UmengInAppClickHandler();

    /* JADX INFO: renamed from: com.umeng.message.inapp.InAppMessageManager$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f7897b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ int f7898c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ int f7899d;

        /* JADX INFO: renamed from: e */
        final /* synthetic */ int f7900e;

        /* JADX INFO: renamed from: f */
        final /* synthetic */ int f7901f;

        /* JADX INFO: renamed from: g */
        final /* synthetic */ int f7902g;

        /* JADX INFO: renamed from: h */
        final /* synthetic */ int f7903h;

        /* JADX INFO: renamed from: i */
        final /* synthetic */ int f7904i;

        public AnonymousClass1(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            str = str;
            i = i2;
            i = i3;
            i = i4;
            i = i5;
            i = i6;
            i = i7;
            i = i8;
            i = i9;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                ae aeVarA = InAppMessageManager.a(InAppMessageManager.this, str);
                if (aeVarA != null) {
                    InAppMessageManager.this.f7893b.getContentResolver().update(h.e(InAppMessageManager.this.f7893b), new ae(str, i, aeVarA.f7949d + i, aeVarA.f7950e + i, aeVarA.f7951f + i, aeVarA.f7952g + i, aeVarA.f7953h + i, aeVarA.f7954i + i, aeVarA.f7955j).a(), "MsgId=?", new String[]{str});
                } else {
                    InAppMessageManager.this.f7893b.getContentResolver().insert(h.e(InAppMessageManager.this.f7893b), new ae(str, i, i, i, i, i, i, i, i).a());
                }
                UMLog.mutlInfo("InAppMessageManager", 2, "store in app cache log success");
            } catch (Exception e2) {
                UMLog.mutlInfo("InAppMessageManager", 0, "store in app cache log fail");
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.umeng.message.inapp.InAppMessageManager$2 */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f7906b;

        AnonymousClass2(String str, String str2) {
            str = str;
            str = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                InAppMessageManager.this.f7896h.a(str, str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.umeng.message.inapp.InAppMessageManager$3 */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ File a;

        AnonymousClass3(File file) {
            file = file;
        }

        @Override // java.lang.Runnable
        public final void run() {
            File file = file;
            if (file != null && file.exists() && file.canWrite() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (!file2.isDirectory()) {
                        file2.delete();
                    }
                }
                file.delete();
            }
        }
    }

    private InAppMessageManager(Context context) {
        this.f7893b = context.getApplicationContext();
    }

    private int d(String str) {
        return Integer.parseInt(a(str, "0"));
    }

    public static InAppMessageManager getInstance(Context context) {
        if (f7892f == null) {
            synchronized (InAppMessageManager.class) {
                if (f7892f == null) {
                    f7892f = new InAppMessageManager(context);
                }
            }
        }
        return f7892f;
    }

    public final long c(String str) {
        return Long.parseLong(a("KEY_LAST_SHOW_CARD_TS_".concat(String.valueOf(str)), "0"));
    }

    public UInAppHandler getInAppHandler() {
        return this.f7895g;
    }

    public void setInAppHandler(UInAppHandler uInAppHandler) {
        this.f7895g = uInAppHandler;
    }

    public void setInAppMsgDebugMode(boolean z) {
        a = z;
    }

    public void setMainActivityPath(String str) {
        this.f7894c = str;
    }

    public void setPlainTextSize(int i2, int i3, int i4) {
        if (i2 <= 0 || i3 <= 0 || i4 <= 0) {
            UMLog.mutlInfo("InAppMessageManager", 0, "\u7eaf\u6587\u672c\u5b57\u4f53\u5927\u5c0f\u4e0d\u80fd\u5c0f\u4e8e0");
            return;
        }
        b("KEY_PLAIN_TEXT_SIZE", i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i3 + Constants.ACCEPT_TIME_SEPARATOR_SP + i4);
    }

    public void showCardMessage(Activity activity, String str, IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback) {
        if (f.b()) {
            UPLog.d("InAppMessageManager", "showCardMessage failed, silent mode!");
            return;
        }
        ag agVar = new ag(activity, str, iUmengInAppMsgCloseCallback);
        if (TextUtils.isEmpty(agVar.f7960c.trim())) {
            UMLog.mutlInfo(ag.a, 0, "\u63d2\u5c4f\u6d88\u606f\u7684\u6807\u7b7e\u4e0d\u80fd\u4e3a\u7a7a");
            return;
        }
        if (!agVar.a(agVar.f7960c)) {
            UMLog.mutlInfo(ag.a, 0, "\u63d2\u5c4f\u6d88\u606f\u7684\u6700\u5927\u6807\u7b7e\u6570\u4e3a 10");
            return;
        }
        if (a) {
            ai.a(agVar.f7959b).a(agVar.f7960c, agVar);
        } else if (System.currentTimeMillis() - Long.parseLong(getInstance(agVar.f7959b).a("KEY_CARD_TS_".concat(String.valueOf(agVar.f7960c)), "0")) > f7890d) {
            ai.a(agVar.f7959b).a(agVar.f7960c, agVar);
        } else {
            agVar.b((UInAppMessage) null);
        }
    }

    public final void a(UInAppMessage uInAppMessage) {
        if (uInAppMessage == null) {
            b("KEY_LAST_SPLASH_ID", "");
        } else if (uInAppMessage.getRaw() != null) {
            b("KEY_LAST_SPLASH_ID", uInAppMessage.getRaw().toString());
        }
    }

    public final void b(String str) {
        String strConcat = "KEY_LAST_SHOW_CARD_TS_".concat(String.valueOf(str));
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        b(strConcat, sb.toString());
    }

    public final boolean c(UInAppMessage uInAppMessage) {
        return uInAppMessage.show_times == 0 || d(uInAppMessage.msg_id) < uInAppMessage.show_times;
    }

    public static boolean b(UInAppMessage uInAppMessage) {
        try {
            return System.currentTimeMillis() < new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(uInAppMessage.expire_time).getTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final String a() {
        return a("KEY_LAST_SPLASH_ID", "");
    }

    public final void a(UInAppMessage uInAppMessage, String str) {
        if (uInAppMessage == null) {
            b("KEY_LAST_CARD_ID_".concat(String.valueOf(str)), "");
        } else if (uInAppMessage.getRaw() != null) {
            b("KEY_LAST_CARD_ID_".concat(String.valueOf(str)), uInAppMessage.getRaw().toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x003b A[PHI: r1
  0x003b: PHI (r1v3 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:41:0x0039, B:35:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArrayList<ae> b() {
        ArrayList<ae> arrayList = new ArrayList<>();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f7893b.getContentResolver().query(h.e(this.f7893b), null, null, null, null);
                for (boolean zMoveToFirst = cursorQuery != null ? cursorQuery.moveToFirst() : false; zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
                    arrayList.add(new ae(cursorQuery));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final String a(String str) {
        return a("KEY_LAST_CARD_ID_".concat(String.valueOf(str)), "");
    }

    public final void a(String str, int i2) {
        if (i2 == 0) {
            b(str, "0");
        }
        if (i2 == 1) {
            b(str, String.valueOf(d(str) + 1));
        }
    }

    public final String a(String str, String str2) {
        return this.f7896h.b(str, str2);
    }

    public final void a(File file) {
        b.c(new Runnable() { // from class: com.umeng.message.inapp.InAppMessageManager.3
            final /* synthetic */ File a;

            AnonymousClass3(File file2) {
                file = file2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                File file2 = file;
                if (file2 != null && file2.exists() && file.canWrite() && file.isDirectory()) {
                    for (File file22 : file.listFiles()) {
                        if (!file22.isDirectory()) {
                            file22.delete();
                        }
                    }
                    file.delete();
                }
            }
        });
    }

    static /* synthetic */ ae a(InAppMessageManager inAppMessageManager, String str) {
        Cursor cursorQuery = inAppMessageManager.f7893b.getContentResolver().query(h.e(inAppMessageManager.f7893b), null, "MsgId=?", new String[]{str}, null);
        ae aeVar = cursorQuery != null ? cursorQuery.moveToFirst() : false ? new ae(cursorQuery) : null;
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return aeVar;
    }

    public final void b(String str, String str2) {
        b.c(new Runnable() { // from class: com.umeng.message.inapp.InAppMessageManager.2
            final /* synthetic */ String a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ String f7906b;

            AnonymousClass2(String str3, String str22) {
                str = str3;
                str = str22;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    InAppMessageManager.this.f7896h.a(str, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
