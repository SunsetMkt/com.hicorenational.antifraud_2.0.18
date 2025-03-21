package com.heytap.mcssdk.p155d;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.heytap.mcssdk.C2079R;
import com.heytap.mcssdk.p160k.C2108h;
import com.heytap.mcssdk.p160k.C2109i;

/* renamed from: com.heytap.mcssdk.d.a */
/* loaded from: classes.dex */
public class C2088a {

    /* renamed from: a */
    public static final String f6202a = "Heytap PUSH";

    /* renamed from: b */
    private static final String f6203b = "System Default Channel";

    /* renamed from: c */
    private static final int f6204c = 3;

    /* renamed from: com.heytap.mcssdk.d.a$a */
    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f6205a;

        a(Context context) {
            this.f6205a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C2108h.m5907c().m5911a()) {
                return;
            }
            String string = this.f6205a.getString(C2079R.string.system_default_channel);
            if (TextUtils.isEmpty(string)) {
                string = C2088a.f6203b;
            }
            C2108h.m5907c().m5910a(C2088a.this.m5788a(this.f6205a, C2088a.f6202a, string, 3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(26)
    /* renamed from: a */
    public boolean m5788a(Context context, String str, String str2, int i2) {
        NotificationManager notificationManager;
        if (context == null || (notificationManager = (NotificationManager) context.getSystemService("notification")) == null) {
            return false;
        }
        notificationManager.createNotificationChannel(new NotificationChannel(str, str2, i2));
        return true;
    }

    /* renamed from: a */
    public void m5790a(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        C2109i.m5913a(new a(context));
    }
}
