package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.p157h.AbstractC2095c;
import com.heytap.mcssdk.p158i.InterfaceC2099c;
import com.heytap.mcssdk.p160k.C2103c;
import com.heytap.mcssdk.p160k.C2107g;
import com.heytap.mcssdk.p160k.C2109i;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.heytap.mcssdk.f */
/* loaded from: classes.dex */
public class C2090f {

    /* renamed from: com.heytap.mcssdk.f$a */
    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f6207a;

        /* renamed from: b */
        final /* synthetic */ Intent f6208b;

        /* renamed from: c */
        final /* synthetic */ IDataMessageCallBackService f6209c;

        a(Context context, Intent intent, IDataMessageCallBackService iDataMessageCallBackService) {
            this.f6207a = context;
            this.f6208b = intent;
            this.f6209c = iDataMessageCallBackService;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<BaseMode> m5844a = AbstractC2095c.m5844a(this.f6207a, this.f6208b);
            if (m5844a == null) {
                return;
            }
            for (BaseMode baseMode : m5844a) {
                if (baseMode != null) {
                    for (InterfaceC2099c interfaceC2099c : C2080a.m5698w().m5744m()) {
                        if (interfaceC2099c != null) {
                            interfaceC2099c.mo5847a(this.f6207a, baseMode, this.f6209c);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.heytap.mcssdk.f$b */
    public class b {

        /* renamed from: a */
        private long f6210a;

        /* renamed from: b */
        private int f6211b;

        public b(long j2, int i2) {
            this.f6210a = j2;
            this.f6211b = i2;
        }

        /* renamed from: a */
        public long m5792a() {
            return this.f6210a;
        }

        /* renamed from: a */
        public void m5793a(int i2) {
            this.f6211b = i2;
        }

        /* renamed from: a */
        public void m5794a(long j2) {
            this.f6210a = j2;
        }

        /* renamed from: b */
        public int m5795b() {
            return this.f6211b;
        }
    }

    /* renamed from: com.heytap.mcssdk.f$c */
    public class c extends BaseMode {

        /* renamed from: j */
        private static final String f6212j = "&";

        /* renamed from: a */
        private String f6213a;

        /* renamed from: b */
        private String f6214b;

        /* renamed from: c */
        private String f6215c;

        /* renamed from: d */
        private String f6216d;

        /* renamed from: e */
        private int f6217e;

        /* renamed from: f */
        private String f6218f;

        /* renamed from: g */
        private int f6219g = -2;

        /* renamed from: h */
        private String f6220h;

        /* renamed from: i */
        private String f6221i;

        /* renamed from: a */
        public static <T> String m5796a(List<T> list) {
            StringBuilder sb = new StringBuilder();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("&");
            }
            return sb.toString();
        }

        /* renamed from: a */
        public String m5797a() {
            return this.f6213a;
        }

        /* renamed from: a */
        public void m5798a(int i2) {
            this.f6217e = i2;
        }

        /* renamed from: a */
        public void m5799a(String str) {
            this.f6213a = str;
        }

        /* renamed from: b */
        public String m5800b() {
            return this.f6214b;
        }

        /* renamed from: b */
        public void m5801b(int i2) {
            this.f6219g = i2;
        }

        /* renamed from: b */
        public void m5802b(String str) {
            this.f6214b = str;
        }

        /* renamed from: c */
        public String m5803c() {
            return this.f6215c;
        }

        /* renamed from: c */
        public void m5804c(String str) {
            this.f6215c = str;
        }

        /* renamed from: d */
        public String m5805d() {
            return this.f6216d;
        }

        /* renamed from: d */
        public void m5806d(String str) {
            this.f6216d = str;
        }

        /* renamed from: e */
        public int m5807e() {
            return this.f6217e;
        }

        /* renamed from: e */
        public void m5808e(String str) {
            this.f6218f = str;
        }

        /* renamed from: f */
        public String m5809f() {
            return this.f6218f;
        }

        /* renamed from: f */
        public void m5810f(String str) {
            this.f6221i = str;
        }

        /* renamed from: g */
        public int m5811g() {
            return this.f6219g;
        }

        /* renamed from: g */
        public void m5812g(String str) {
            this.f6220h = str;
        }

        @Override // com.heytap.msp.push.mode.BaseMode
        public int getType() {
            return 4105;
        }

        /* renamed from: h */
        public String m5813h() {
            return this.f6221i;
        }

        /* renamed from: i */
        public String m5814i() {
            return this.f6220h;
        }

        public String toString() {
            return "CallBackResult{, mRegisterID='" + this.f6215c + "', mSdkVersion='" + this.f6216d + "', mCommand=" + this.f6217e + "', mContent='" + this.f6218f + "', mAppPackage=" + this.f6220h + "', mResponseCode=" + this.f6219g + ", miniProgramPkg=" + this.f6221i + '}';
        }
    }

    /* renamed from: a */
    public static void m5791a(Context context, Intent intent, IDataMessageCallBackService iDataMessageCallBackService) {
        if (context == null) {
            C2107g.m5896e("context is null , please check param of parseIntent()");
            return;
        }
        if (intent == null) {
            C2107g.m5896e("intent is null , please check param of parseIntent()");
            return;
        }
        if (iDataMessageCallBackService == null) {
            C2107g.m5896e("callback is null , please check param of parseIntent()");
        } else if (C2103c.m5866c(context)) {
            C2109i.m5913a(new a(context, intent, iDataMessageCallBackService));
        } else {
            C2107g.m5896e("push is null ,please check system has push");
        }
    }
}
