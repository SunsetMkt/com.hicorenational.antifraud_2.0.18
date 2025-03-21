package util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.widget.Toast;
import com.luck.picture.lib.config.PictureMimeType;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Calendar;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: ShotScreenUtils.java */
/* renamed from: util.t1 */
/* loaded from: classes2.dex */
public class C7322t1 {

    /* renamed from: i */
    private static final String f25599i = "ShotScreenUtils";

    /* renamed from: j */
    private static ImageReader f25600j;

    /* renamed from: a */
    private d f25601a;

    /* renamed from: b */
    private int f25602b;

    /* renamed from: c */
    private int f25603c;

    /* renamed from: d */
    private int f25604d;

    /* renamed from: e */
    private Intent f25605e;

    /* renamed from: f */
    private Context f25606f;

    /* renamed from: g */
    private MediaProjection f25607g;

    /* renamed from: h */
    private VirtualDisplay f25608h;

    /* compiled from: ShotScreenUtils.java */
    /* renamed from: util.t1$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7322t1.this.m26581i();
        }
    }

    /* compiled from: ShotScreenUtils.java */
    /* renamed from: util.t1$b */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7322t1.this.m26580h();
        }
    }

    /* compiled from: ShotScreenUtils.java */
    /* renamed from: util.t1$c */
    public static final class c {
        private c() {
        }

        @Deprecated
        /* renamed from: a */
        public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> m26590a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
            if (asyncTask == null) {
                throw new IllegalArgumentException("task can not be null");
            }
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
            return asyncTask;
        }
    }

    /* compiled from: ShotScreenUtils.java */
    /* renamed from: util.t1$d */
    public interface d {
        /* renamed from: a */
        void m26591a();

        /* renamed from: a */
        void m26592a(Uri uri);

        /* renamed from: b */
        void m26593b();
    }

    /* compiled from: ShotScreenUtils.java */
    /* renamed from: util.t1$e */
    private class e extends AsyncTask<Image, Void, Uri> {
        private e() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Uri doInBackground(Image... imageArr) {
            if (imageArr == null || imageArr.length < 1 || imageArr[0] == null) {
                if (C7322t1.this.f25601a != null) {
                    C7322t1.this.f25601a.m26593b();
                }
                return null;
            }
            Image image = imageArr[0];
            int width = image.getWidth();
            int height = image.getHeight();
            Image.Plane[] planes = image.getPlanes();
            ByteBuffer buffer = planes[0].getBuffer();
            int pixelStride = planes[0].getPixelStride();
            Bitmap createBitmap = Bitmap.createBitmap(((planes[0].getRowStride() - (pixelStride * width)) / pixelStride) + width, height, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(buffer);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, width, height);
            image.close();
            if (createBitmap2 != null) {
                C7322t1 c7322t1 = C7322t1.this;
                return c7322t1.m26569a(c7322t1.f25606f, createBitmap2);
            }
            if (C7322t1.this.f25601a != null) {
                C7322t1.this.f25601a.m26593b();
            }
            return null;
        }

        /* synthetic */ e(C7322t1 c7322t1, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Uri uri) {
            super.onPostExecute(uri);
            if (uri != null) {
                if (C7322t1.this.f25601a != null) {
                    Toast.makeText(C7322t1.this.f25606f, "截屏完成。", 0).show();
                    C7322t1.this.f25601a.m26592a(uri);
                    return;
                }
                return;
            }
            if (C7322t1.this.f25601a != null) {
                C7322t1.this.f25601a.m26593b();
            }
        }
    }

    /* compiled from: ShotScreenUtils.java */
    /* renamed from: util.t1$f */
    private static class f {

        /* renamed from: a */
        private static final C7322t1 f25612a = new C7322t1(null);

        private f() {
        }
    }

    /* synthetic */ C7322t1(a aVar) {
        this();
    }

    /* renamed from: e */
    public static C7322t1 m26577e() {
        return f.f25612a;
    }

    /* renamed from: f */
    private MediaProjectionManager m26578f() {
        return (MediaProjectionManager) this.f25606f.getSystemService("media_projection");
    }

    /* renamed from: g */
    private void m26579g() {
        if (this.f25605e != null) {
            this.f25607g = m26578f().getMediaProjection(-1, this.f25605e);
            return;
        }
        C7301n1.m26457b(f25599i, "setUpMediaProjection: 获取权限返回数据发生异常！");
        d dVar = this.f25601a;
        if (dVar != null) {
            dVar.m26593b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m26580h() {
        Image acquireLatestImage = f25600j.acquireLatestImage();
        if (acquireLatestImage == null) {
            m26589b();
        } else {
            c.m26590a(new e(this, null), acquireLatestImage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m26581i() {
        if (this.f25607g != null) {
            m26584l();
        } else {
            m26579g();
            m26584l();
        }
    }

    /* renamed from: j */
    private void m26582j() {
        VirtualDisplay virtualDisplay = this.f25608h;
        if (virtualDisplay == null) {
            return;
        }
        virtualDisplay.release();
        this.f25608h = null;
    }

    /* renamed from: k */
    private void m26583k() {
        MediaProjection mediaProjection = this.f25607g;
        if (mediaProjection != null) {
            mediaProjection.stop();
            this.f25607g = null;
        }
    }

    /* renamed from: l */
    private void m26584l() {
        this.f25608h = this.f25607g.createVirtualDisplay("screen-mirror", this.f25602b, this.f25603c, this.f25604d, 16, f25600j.getSurface(), null, null);
    }

    public void setOnShotScreenListener(d dVar) {
        this.f25601a = dVar;
    }

    private C7322t1() {
    }

    /* renamed from: c */
    public static boolean m26574c() {
        return f25600j != null;
    }

    /* renamed from: d */
    private void m26576d() {
        f25600j = ImageReader.newInstance(this.f25602b, this.f25603c, 1, 1);
    }

    /* renamed from: b */
    public void m26589b() {
        d dVar = this.f25601a;
        if (dVar != null) {
            dVar.m26591a();
        }
        Handler handler = new Handler();
        handler.postDelayed(new a(), 5L);
        handler.postDelayed(new b(), 30L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Uri m26569a(Context context, Bitmap bitmap) {
        String str;
        if (C7337y1.m26768b()) {
            str = context.getExternalFilesDir(Environment.DIRECTORY_DCIM) + File.separator + "ScreenShots";
        } else {
            str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + File.separator + "ScreenShots";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis / 1000;
        Calendar calendar = Calendar.getInstance();
        String str2 = "Screenshot_" + calendar.get(1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (calendar.get(2) + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(10) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(12) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(13) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(14) + AbstractC1191a.f2606s1 + context.getPackageName() + PictureMimeType.PNG;
        String str3 = str + File.separator + str2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ContentValues contentValues = new ContentValues();
        ContentResolver contentResolver = context.getContentResolver();
        contentValues.put("_data", str3);
        contentValues.put("title", str2);
        contentValues.put("_display_name", str2);
        contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
        contentValues.put("date_added", Long.valueOf(j2));
        contentValues.put("date_modified", Long.valueOf(j2));
        contentValues.put("mime_type", PictureMimeType.MIME_TYPE_PNG);
        contentValues.put(SocializeProtocolConstants.WIDTH, Integer.valueOf(width));
        contentValues.put(SocializeProtocolConstants.HEIGHT, Integer.valueOf(height));
        Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        try {
            OutputStream openOutputStream = contentResolver.openOutputStream(insert);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, openOutputStream);
            openOutputStream.flush();
            openOutputStream.close();
        } catch (FileNotFoundException e2) {
            d dVar = this.f25601a;
            if (dVar != null) {
                dVar.m26593b();
            }
            e2.printStackTrace();
        } catch (IOException e3) {
            d dVar2 = this.f25601a;
            if (dVar2 != null) {
                dVar2.m26593b();
            }
            e3.printStackTrace();
        }
        contentValues.clear();
        contentValues.put("_size", Long.valueOf(new File(str3).length()));
        contentResolver.update(insert, contentValues, null, null);
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        Uri fromFile = Uri.fromFile(new File(str3));
        intent.setData(fromFile);
        context.sendBroadcast(intent);
        return fromFile;
    }

    /* renamed from: a */
    public C7322t1 m26585a(int i2, int i3, int i4) {
        this.f25602b = i2;
        this.f25603c = i3;
        this.f25604d = i4;
        return this;
    }

    /* renamed from: a */
    public C7322t1 m26586a(Context context) {
        this.f25606f = context;
        return this;
    }

    /* renamed from: a */
    public C7322t1 m26587a(Intent intent) {
        this.f25605e = intent;
        m26576d();
        return this;
    }

    /* renamed from: a */
    public void m26588a() {
        m26583k();
        m26582j();
    }
}
