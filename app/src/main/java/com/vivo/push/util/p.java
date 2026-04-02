package com.vivo.push.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.vivo.push.f.u;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ImageDownTask.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p extends AsyncTask<String, Void, List<Bitmap>> {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InsideNotificationItem f8686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f8687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8689e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private NotifyArriveCallbackByUser f8690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private u.a f8691g;

    public p(Context context, InsideNotificationItem insideNotificationItem, long j2, boolean z, u.a aVar, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        this.a = context;
        this.f8686b = insideNotificationItem;
        this.f8687c = j2;
        this.f8688d = z;
        this.f8691g = aVar;
        this.f8690f = notifyArriveCallbackByUser;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(List<Bitmap> list) {
        List<Bitmap> list2 = list;
        super.onPostExecute(list2);
        u.c("ImageDownTask", "onPostExecute");
        com.vivo.push.t.c(new q(this, list2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a A[EXC_TOP_SPLITTER, PHI: r5
  0x008a: PHI (r5v5 java.io.InputStream) = (r5v4 java.io.InputStream), (r5v6 java.io.InputStream) binds: [B:24:0x0088, B:29:0x0094] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Bitmap> doInBackground(String... strArr) throws Throwable {
        InputStream inputStream;
        Bitmap bitmapDecodeStream;
        this.f8689e = this.f8686b.getNotifyDisplayStatus();
        InputStream inputStream2 = null;
        if (!this.f8688d) {
            u.d("ImageDownTask", "bitmap is not display by forbid net");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            String str = strArr[i2];
            u.d("ImageDownTask", "imgUrl=" + str + " i=" + i2);
            if (!TextUtils.isEmpty(str)) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setConnectTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    u.c("ImageDownTask", "code=".concat(String.valueOf(responseCode)));
                    if (responseCode == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            try {
                                bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                            } catch (MalformedURLException unused) {
                                u.a("ImageDownTask", "MalformedURLException");
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                                bitmapDecodeStream = null;
                            } catch (IOException unused3) {
                                u.a("ImageDownTask", "IOException");
                                if (inputStream != null) {
                                }
                                bitmapDecodeStream = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream2 = inputStream;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception unused4) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        inputStream = null;
                        bitmapDecodeStream = null;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                } catch (MalformedURLException unused6) {
                    inputStream = null;
                } catch (IOException unused7) {
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                arrayList.add(bitmapDecodeStream);
            } else if (i2 == 0) {
                arrayList.add(null);
            }
        }
        return arrayList;
    }
}
