package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.k.g;
import com.heytap.mcssdk.k.i;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {

    class a implements Runnable {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Intent f3921b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IDataMessageCallBackService f3922c;

        a(Context context, Intent intent, IDataMessageCallBackService iDataMessageCallBackService) {
            this.a = context;
            this.f3921b = intent;
            this.f3922c = iDataMessageCallBackService;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<BaseMode> listA = com.heytap.mcssdk.h.c.a(this.a, this.f3921b);
            if (listA == null) {
                return;
            }
            for (BaseMode baseMode : listA) {
                if (baseMode != null) {
                    for (com.heytap.mcssdk.i.c cVar : com.heytap.mcssdk.a.w().m()) {
                        if (cVar != null) {
                            cVar.a(this.a, baseMode, this.f3922c);
                        }
                    }
                }
            }
        }
    }

    public class b {
        private long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3923b;

        public b(long j2, int i2) {
            this.a = j2;
            this.f3923b = i2;
        }

        public long a() {
            return this.a;
        }

        public void a(int i2) {
            this.f3923b = i2;
        }

        public void a(long j2) {
            this.a = j2;
        }

        public int b() {
            return this.f3923b;
        }
    }

    public class c extends BaseMode {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final String f3924j = "&";
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f3925b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f3926c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f3927d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f3928e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f3929f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f3930g = -2;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f3931h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f3932i;

        public static <T> String a(List<T> list) {
            StringBuilder sb = new StringBuilder();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("&");
            }
            return sb.toString();
        }

        public String a() {
            return this.a;
        }

        public void a(int i2) {
            this.f3928e = i2;
        }

        public void a(String str) {
            this.a = str;
        }

        public String b() {
            return this.f3925b;
        }

        public void b(int i2) {
            this.f3930g = i2;
        }

        public void b(String str) {
            this.f3925b = str;
        }

        public String c() {
            return this.f3926c;
        }

        public void c(String str) {
            this.f3926c = str;
        }

        public String d() {
            return this.f3927d;
        }

        public void d(String str) {
            this.f3927d = str;
        }

        public int e() {
            return this.f3928e;
        }

        public void e(String str) {
            this.f3929f = str;
        }

        public String f() {
            return this.f3929f;
        }

        public void f(String str) {
            this.f3932i = str;
        }

        public int g() {
            return this.f3930g;
        }

        public void g(String str) {
            this.f3931h = str;
        }

        @Override // com.heytap.msp.push.mode.BaseMode
        public int getType() {
            return 4105;
        }

        public String h() {
            return this.f3932i;
        }

        public String i() {
            return this.f3931h;
        }

        public String toString() {
            return "CallBackResult{, mRegisterID='" + this.f3926c + "', mSdkVersion='" + this.f3927d + "', mCommand=" + this.f3928e + "', mContent='" + this.f3929f + "', mAppPackage=" + this.f3931h + "', mResponseCode=" + this.f3930g + ", miniProgramPkg=" + this.f3932i + '}';
        }
    }

    public static void a(Context context, Intent intent, IDataMessageCallBackService iDataMessageCallBackService) {
        if (context == null) {
            g.e("context is null , please check param of parseIntent()");
            return;
        }
        if (intent == null) {
            g.e("intent is null , please check param of parseIntent()");
            return;
        }
        if (iDataMessageCallBackService == null) {
            g.e("callback is null , please check param of parseIntent()");
        } else if (com.heytap.mcssdk.k.c.c(context)) {
            i.a(new a(context, intent, iDataMessageCallBackService));
        } else {
            g.e("push is null ,please check system has push");
        }
    }
}
