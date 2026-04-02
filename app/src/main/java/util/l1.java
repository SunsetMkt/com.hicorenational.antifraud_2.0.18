package util;

import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.provider.CallLog;
import android.text.TextUtils;
import bean.PhoneInfoBean;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ui.Hicore;

/* JADX INFO: compiled from: HttpPhoneUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class l1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static com.google.gson.e f14948f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f14950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f14951d;
    private OkHttpClient a = new OkHttpClient();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f14952e = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: HttpPhoneUtil.java */
    class a implements Callback {

        /* JADX INFO: renamed from: util.l1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpPhoneUtil.java */
        class RunnableC0324a implements Runnable {
            RunnableC0324a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l1.this.f14951d.onFail("\u8bf7\u6c42\u9519\u8bef");
            }
        }

        /* JADX INFO: compiled from: HttpPhoneUtil.java */
        class b implements Runnable {
            final /* synthetic */ Response a;

            b(Response response) {
                this.a = response;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!this.a.isSuccessful()) {
                    l1.this.f14951d.onFail("\u8bf7\u6c42\u5931\u8d25");
                    return;
                }
                try {
                    l1.this.f14951d.onSuccess(this.a.body().string());
                } catch (IOException e2) {
                    e2.printStackTrace();
                    l1.this.f14951d.onFail("\u7ed3\u679c\u8f6c\u6362\u5931\u8d25");
                }
            }
        }

        a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (l1.this.f14951d != null) {
                l1.this.f14952e.post(new RunnableC0324a());
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            if (l1.this.f14951d != null) {
                l1.this.f14952e.post(new b(response));
            }
        }
    }

    /* JADX INFO: compiled from: HttpPhoneUtil.java */
    public interface b {
        void a(PhoneInfoBean phoneInfoBean);
    }

    /* JADX INFO: compiled from: HttpPhoneUtil.java */
    public interface c {
        void onFail(String str);

        void onSuccess(Object obj);
    }

    public l1(c cVar) {
        this.f14951d = cVar;
    }

    public void a(String str, Map<String, String> map) {
        a(str, map, false);
    }

    public void b(String str, Map<String, String> map) {
        a(str, map, true);
    }

    private void a(String str, Map<String, String> map, boolean z) {
        this.f14949b = str;
        this.f14950c = map;
        b(z);
    }

    private void b(boolean z) {
        this.a.newCall(a(z)).enqueue(new a());
    }

    private Request a(boolean z) {
        if (z) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            for (Map.Entry<String, String> entry : this.f14950c.entrySet()) {
                builder.addFormDataPart(entry.getKey(), entry.getValue());
            }
            return new Request.Builder().url(this.f14949b).post(builder.build()).build();
        }
        return new Request.Builder().url(this.f14949b + "?" + a(this.f14950c)).build();
    }

    private String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue() + "&");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0046 A[EXC_TOP_SPLITTER, PHI: r0 r1
  0x0046: PHI (r0v2 java.lang.String) = (r0v1 java.lang.String), (r0v5 java.lang.String) binds: [B:21:0x0053, B:13:0x0044] A[DONT_GENERATE, DONT_INLINE]
  0x0046: PHI (r1v3 android.database.Cursor) = (r1v2 android.database.Cursor), (r1v5 android.database.Cursor) binds: [B:21:0x0053, B:13:0x0044] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        String str2 = "";
        Cursor cursorQuery = null;
        try {
            cursorQuery = Hicore.getApp().getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"number", "date", "type", "geocoded_location", CommonNetImpl.NAME}, null, null, null);
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(0);
                String string2 = cursorQuery.getString(3);
                if (TextUtils.equals(string, str) && !TextUtils.isEmpty(string2)) {
                    str2 = string2;
                }
            }
            cursorQuery.close();
        } catch (Exception unused) {
            if (cursorQuery != null) {
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Exception unused3) {
            }
        }
        return TextUtils.isEmpty(str2) ? g2.m(str) : str2;
    }
}
