package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.entity.UInAppMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: com.umeng.message.proguard.af */
/* loaded from: classes2.dex */
public class AsyncTaskC3557af extends AsyncTask<String, Void, Bitmap[]> {

    /* renamed from: b */
    private static final String f13164b = AsyncTaskC3557af.class.getName();

    /* renamed from: a */
    public a f13165a;

    /* renamed from: c */
    private String f13166c;

    /* renamed from: d */
    private BitmapFactory.Options f13167d;

    /* renamed from: com.umeng.message.proguard.af$a */
    public interface a {
        /* renamed from: a */
        void mo12211a(Bitmap[] bitmapArr);
    }

    public AsyncTaskC3557af(Context context, UInAppMessage uInAppMessage) {
        this.f13166c = C3586f.m12382a(context, uInAppMessage.msg_id);
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            this.f13167d = new BitmapFactory.Options();
            this.f13167d.inSampleSize = m12231a(uInAppMessage, i2, i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap[] doInBackground(String... strArr) {
        Bitmap decodeStream;
        boolean z;
        boolean z2;
        Bitmap[] bitmapArr = new Bitmap[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            try {
                String str = strArr[i2];
                StringBuilder sb = new StringBuilder();
                sb.append(str.hashCode());
                if (new File(this.f13166c, sb.toString()).exists()) {
                    bitmapArr[i2] = m12232a(strArr[i2]);
                } else {
                    bitmapArr[i2] = m12232a(strArr[i2]);
                    if (bitmapArr[i2] == null) {
                        String str2 = strArr[i2];
                        UMLog.mutlInfo(f13164b, 2, "Downloading image start");
                        URLConnection openConnection = new URL(str2).openConnection();
                        openConnection.connect();
                        InputStream inputStream = openConnection.getInputStream();
                        if (this.f13167d == null) {
                            decodeStream = BitmapFactory.decodeStream(inputStream);
                        } else {
                            UMLog.mutlInfo(f13164b, 2, "decode options");
                            decodeStream = BitmapFactory.decodeStream(inputStream, null, this.f13167d);
                        }
                        inputStream.close();
                        UMLog.mutlInfo(f13164b, 2, "Downloading image finish");
                        bitmapArr[i2] = decodeStream;
                        Bitmap bitmap = bitmapArr[i2];
                        String str3 = strArr[i2];
                        if (bitmap != null) {
                            try {
                                File file = new File(this.f13166c);
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str3.hashCode());
                                FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f13166c, sb2.toString()));
                                z2 = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e2) {
                                    z = z2;
                                    e = e2;
                                    e.printStackTrace();
                                    z2 = z;
                                    UMLog.mutlInfo(f13164b, 2, "store bitmap".concat(String.valueOf(z2)));
                                }
                            } catch (Exception e3) {
                                e = e3;
                                z = false;
                            }
                            UMLog.mutlInfo(f13164b, 2, "store bitmap".concat(String.valueOf(z2)));
                        }
                    }
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        return bitmapArr;
    }

    @Override // android.os.AsyncTask
    protected /* synthetic */ void onPostExecute(Bitmap[] bitmapArr) {
        Bitmap[] bitmapArr2 = bitmapArr;
        super.onPostExecute(bitmapArr2);
        for (Bitmap bitmap : bitmapArr2) {
            if (bitmap == null) {
                return;
            }
        }
        a aVar = this.f13165a;
        if (aVar != null) {
            aVar.mo12211a(bitmapArr2);
        }
    }

    /* renamed from: a */
    private Bitmap m12232a(String str) {
        Bitmap bitmap = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str.hashCode());
            bitmap = BitmapFactory.decodeFile(this.f13166c + sb.toString());
            UMLog.mutlInfo(f13164b, 2, "load from local");
            return bitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return bitmap;
        }
    }

    /* renamed from: a */
    private static int m12231a(UInAppMessage uInAppMessage, int i2, int i3) {
        int i4 = uInAppMessage.height;
        int i5 = uInAppMessage.width;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                i6 *= 2;
            }
        }
        return i6;
    }
}
