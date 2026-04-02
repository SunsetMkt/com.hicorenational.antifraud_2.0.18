package com.heytap.mcssdk.d;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.heytap.mcssdk.R;
import com.heytap.mcssdk.k.h;
import com.heytap.mcssdk.k.i;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String a = "Heytap PUSH";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3918b = "System Default Channel";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f3919c = 3;

    /* JADX INFO: renamed from: com.heytap.mcssdk.d.a$a, reason: collision with other inner class name */
    class RunnableC0083a implements Runnable {
        final /* synthetic */ Context a;

        RunnableC0083a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.c().a()) {
                return;
            }
            String string = this.a.getString(R.string.system_default_channel);
            if (TextUtils.isEmpty(string)) {
                string = a.f3918b;
            }
            h.c().a(a.this.a(this.a, a.a, string, 3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(26)
    public boolean a(Context context, String str, String str2, int i2) {
        NotificationManager notificationManager;
        if (context == null || (notificationManager = (NotificationManager) context.getSystemService("notification")) == null) {
            return false;
        }
        notificationManager.createNotificationChannel(new NotificationChannel(str, str2, i2));
        return true;
    }

    public void a(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        i.a(new RunnableC0083a(context));
    }
}
