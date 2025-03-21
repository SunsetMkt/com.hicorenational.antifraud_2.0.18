package util;

import android.os.Handler;
import android.os.Looper;
import bean.PhoneInfoBean;
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
/* loaded from: classes2.dex */
public class h1 {

    /* renamed from: f, reason: collision with root package name */
    private static com.google.gson.e f20822f;

    /* renamed from: b, reason: collision with root package name */
    private String f20824b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, String> f20825c;

    /* renamed from: d, reason: collision with root package name */
    private c f20826d;

    /* renamed from: a, reason: collision with root package name */
    private OkHttpClient f20823a = new OkHttpClient();

    /* renamed from: e, reason: collision with root package name */
    private Handler f20827e = new Handler(Looper.getMainLooper());

    /* compiled from: HttpPhoneUtil.java */
    class a implements Callback {

        /* compiled from: HttpPhoneUtil.java */
        /* renamed from: util.h1$a$a, reason: collision with other inner class name */
        class RunnableC0322a implements Runnable {
            RunnableC0322a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h1.this.f20826d.onFail("请求错误");
            }
        }

        /* compiled from: HttpPhoneUtil.java */
        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Response f20830a;

            b(Response response) {
                this.f20830a = response;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!this.f20830a.isSuccessful()) {
                    h1.this.f20826d.onFail("请求失败");
                    return;
                }
                try {
                    h1.this.f20826d.onSuccess(this.f20830a.body().string());
                } catch (IOException e2) {
                    e2.printStackTrace();
                    h1.this.f20826d.onFail("结果转换失败");
                }
            }
        }

        a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (h1.this.f20826d != null) {
                h1.this.f20827e.post(new RunnableC0322a());
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            if (h1.this.f20826d != null) {
                h1.this.f20827e.post(new b(response));
            }
        }
    }

    /* compiled from: HttpPhoneUtil.java */
    public interface b {
        void a(PhoneInfoBean phoneInfoBean);
    }

    /* compiled from: HttpPhoneUtil.java */
    public interface c {
        void onFail(String str);

        void onSuccess(Object obj);
    }

    public h1(c cVar) {
        this.f20826d = cVar;
    }

    public void a(String str, Map<String, String> map) {
        a(str, map, false);
    }

    public void b(String str, Map<String, String> map) {
        a(str, map, true);
    }

    private void a(String str, Map<String, String> map, boolean z) {
        this.f20824b = str;
        this.f20825c = map;
        b(z);
    }

    private void b(boolean z) {
        this.f20823a.newCall(a(z)).enqueue(new a());
    }

    private Request a(boolean z) {
        if (z) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            for (Map.Entry<String, String> entry : this.f20825c.entrySet()) {
                builder.addFormDataPart(entry.getKey(), entry.getValue());
            }
            return new Request.Builder().url(this.f20824b).post(builder.build()).build();
        }
        return new Request.Builder().url(this.f20824b + "?" + a(this.f20825c)).build();
    }

    private String a(Map<String, String> map) {
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r9) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            ui.Hicore r2 = ui.Hicore.getApp()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
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
            java.lang.String r0 = util.y1.m(r9)
        L60:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: util.h1.a(java.lang.String):java.lang.String");
    }
}
