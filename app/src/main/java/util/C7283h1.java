package util;

import android.os.Handler;
import android.os.Looper;
import bean.PhoneInfoBean;
import com.google.gson.C2051e;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: HttpPhoneUtil.java */
/* renamed from: util.h1 */
/* loaded from: classes2.dex */
public class C7283h1 {

    /* renamed from: f */
    private static C2051e f25312f;

    /* renamed from: b */
    private String f25314b;

    /* renamed from: c */
    private Map<String, String> f25315c;

    /* renamed from: d */
    private c f25316d;

    /* renamed from: a */
    private OkHttpClient f25313a = new OkHttpClient();

    /* renamed from: e */
    private Handler f25317e = new Handler(Looper.getMainLooper());

    /* compiled from: HttpPhoneUtil.java */
    /* renamed from: util.h1$a */
    class a implements Callback {

        /* compiled from: HttpPhoneUtil.java */
        /* renamed from: util.h1$a$a, reason: collision with other inner class name */
        class RunnableC7440a implements Runnable {
            RunnableC7440a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C7283h1.this.f25316d.onFail("请求错误");
            }
        }

        /* compiled from: HttpPhoneUtil.java */
        /* renamed from: util.h1$a$b */
        class b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Response f25320a;

            b(Response response) {
                this.f25320a = response;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!this.f25320a.isSuccessful()) {
                    C7283h1.this.f25316d.onFail("请求失败");
                    return;
                }
                try {
                    C7283h1.this.f25316d.onSuccess(this.f25320a.body().string());
                } catch (IOException e2) {
                    e2.printStackTrace();
                    C7283h1.this.f25316d.onFail("结果转换失败");
                }
            }
        }

        a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (C7283h1.this.f25316d != null) {
                C7283h1.this.f25317e.post(new RunnableC7440a());
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            if (C7283h1.this.f25316d != null) {
                C7283h1.this.f25317e.post(new b(response));
            }
        }
    }

    /* compiled from: HttpPhoneUtil.java */
    /* renamed from: util.h1$b */
    public interface b {
        /* renamed from: a */
        void m26378a(PhoneInfoBean phoneInfoBean);
    }

    /* compiled from: HttpPhoneUtil.java */
    /* renamed from: util.h1$c */
    public interface c {
        void onFail(String str);

        void onSuccess(Object obj);
    }

    public C7283h1(c cVar) {
        this.f25316d = cVar;
    }

    /* renamed from: a */
    public void m26376a(String str, Map<String, String> map) {
        m26373a(str, map, false);
    }

    /* renamed from: b */
    public void m26377b(String str, Map<String, String> map) {
        m26373a(str, map, true);
    }

    /* renamed from: a */
    private void m26373a(String str, Map<String, String> map, boolean z) {
        this.f25314b = str;
        this.f25315c = map;
        m26375b(z);
    }

    /* renamed from: b */
    private void m26375b(boolean z) {
        this.f25313a.newCall(m26371a(z)).enqueue(new a());
    }

    /* renamed from: a */
    private Request m26371a(boolean z) {
        if (z) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            for (Map.Entry<String, String> entry : this.f25315c.entrySet()) {
                builder.addFormDataPart(entry.getKey(), entry.getValue());
            }
            return new Request.Builder().url(this.f25314b).post(builder.build()).build();
        }
        return new Request.Builder().url(this.f25314b + "?" + m26370a(this.f25315c)).build();
    }

    /* renamed from: a */
    private String m26370a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue() + "&");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (r1 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0046, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0053, code lost:
    
        if (r1 != null) goto L28;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m26369a(java.lang.String r9) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            ui.Hicore r2 = p388ui.Hicore.getApp()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
            android.content.ContentResolver r3 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
            android.net.Uri r4 = android.provider.CallLog.Calls.CONTENT_URI     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
            java.lang.String r2 = "number"
            java.lang.String r5 = "date"
            java.lang.String r6 = "type"
            java.lang.String r7 = "geocoded_location"
            java.lang.String r8 = "name"
            java.lang.String[] r5 = new java.lang.String[]{r2, r5, r6, r7, r8}     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
        L22:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
            if (r2 == 0) goto L41
            r2 = 0
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
            r3 = 3
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
            boolean r2 = android.text.TextUtils.equals(r2, r9)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
            if (r2 == 0) goto L22
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
            if (r2 == 0) goto L3f
            goto L22
        L3f:
            r0 = r3
            goto L22
        L41:
            r1.close()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
            if (r1 == 0) goto L56
        L46:
            r1.close()     // Catch: java.lang.Exception -> L4a
            goto L56
        L4a:
            goto L56
        L4c:
            r9 = move-exception
            if (r1 == 0) goto L52
            r1.close()     // Catch: java.lang.Exception -> L52
        L52:
            throw r9
        L53:
            if (r1 == 0) goto L56
            goto L46
        L56:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L60
            java.lang.String r0 = util.C7337y1.m26788m(r9)
        L60:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: util.C7283h1.m26369a(java.lang.String):java.lang.String");
    }
}
