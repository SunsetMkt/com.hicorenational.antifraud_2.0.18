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

/* JADX INFO: compiled from: ShotScreenUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class b2 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f14845i = "ShotScreenUtils";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ImageReader f14846j;
    private d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Intent f14850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f14851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MediaProjection f14852g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private VirtualDisplay f14853h;

    /* JADX INFO: compiled from: ShotScreenUtils.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b2.this.i();
        }
    }

    /* JADX INFO: compiled from: ShotScreenUtils.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b2.this.h();
        }
    }

    /* JADX INFO: compiled from: ShotScreenUtils.java */
    public static final class c {
        private c() {
        }

        @Deprecated
        public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
            if (asyncTask == null) {
                throw new IllegalArgumentException("task can not be null");
            }
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
            return asyncTask;
        }
    }

    /* JADX INFO: compiled from: ShotScreenUtils.java */
    public interface d {
        void a();

        void a(Uri uri);

        void b();
    }

    /* JADX INFO: compiled from: ShotScreenUtils.java */
    private class e extends AsyncTask<Image, Void, Uri> {
        private e() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Uri doInBackground(Image... imageArr) {
            if (imageArr == null || imageArr.length < 1 || imageArr[0] == null) {
                if (b2.this.a != null) {
                    b2.this.a.b();
                }
                return null;
            }
            Image image = imageArr[0];
            int width = image.getWidth();
            int height = image.getHeight();
            Image.Plane[] planes = image.getPlanes();
            ByteBuffer buffer = planes[0].getBuffer();
            int pixelStride = planes[0].getPixelStride();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((planes[0].getRowStride() - (pixelStride * width)) / pixelStride) + width, height, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.copyPixelsFromBuffer(buffer);
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, width, height);
            image.close();
            if (bitmapCreateBitmap2 != null) {
                b2 b2Var = b2.this;
                return b2Var.a(b2Var.f14851f, bitmapCreateBitmap2);
            }
            if (b2.this.a != null) {
                b2.this.a.b();
            }
            return null;
        }

        /* synthetic */ e(b2 b2Var, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Uri uri) {
            super.onPostExecute(uri);
            if (uri != null) {
                if (b2.this.a != null) {
                    Toast.makeText(b2.this.f14851f, "\u622a\u5c4f\u5b8c\u6210\u3002", 0).show();
                    b2.this.a.a(uri);
                    return;
                }
                return;
            }
            if (b2.this.a != null) {
                b2.this.a.b();
            }
        }
    }

    /* JADX INFO: compiled from: ShotScreenUtils.java */
    private static class f {
        private static final b2 a = new b2(null);

        private f() {
        }
    }

    /* synthetic */ b2(a aVar) {
        this();
    }

    public static b2 e() {
        return f.a;
    }

    private MediaProjectionManager f() {
        return (MediaProjectionManager) this.f14851f.getSystemService("media_projection");
    }

    private void g() {
        if (this.f14850e != null) {
            this.f14852g = f().getMediaProjection(-1, this.f14850e);
            return;
        }
        s1.b(f14845i, "setUpMediaProjection: \u83b7\u53d6\u6743\u9650\u8fd4\u56de\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff01");
        d dVar = this.a;
        if (dVar != null) {
            dVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Image imageAcquireLatestImage = f14846j.acquireLatestImage();
        if (imageAcquireLatestImage == null) {
            b();
        } else {
            c.a(new e(this, null), imageAcquireLatestImage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f14852g != null) {
            l();
        } else {
            g();
            l();
        }
    }

    private void j() {
        VirtualDisplay virtualDisplay = this.f14853h;
        if (virtualDisplay == null) {
            return;
        }
        virtualDisplay.release();
        this.f14853h = null;
    }

    private void k() {
        MediaProjection mediaProjection = this.f14852g;
        if (mediaProjection != null) {
            mediaProjection.stop();
            this.f14852g = null;
        }
    }

    private void l() {
        this.f14853h = this.f14852g.createVirtualDisplay("screen-mirror", this.f14847b, this.f14848c, this.f14849d, 16, f14846j.getSurface(), null, null);
    }

    public void setOnShotScreenListener(d dVar) {
        this.a = dVar;
    }

    private b2() {
    }

    public static boolean c() {
        return f14846j != null;
    }

    private void d() {
        f14846j = ImageReader.newInstance(this.f14847b, this.f14848c, 1, 1);
    }

    public void b() {
        d dVar = this.a;
        if (dVar != null) {
            dVar.a();
        }
        Handler handler = new Handler();
        handler.postDelayed(new a(), 5L);
        handler.postDelayed(new b(), 30L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Uri a(Context context, Bitmap bitmap) {
        String str;
        if (g2.b()) {
            str = context.getExternalFilesDir(Environment.DIRECTORY_DCIM) + File.separator + "ScreenShots";
        } else {
            str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + File.separator + "ScreenShots";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis / 1000;
        Calendar calendar = Calendar.getInstance();
        String str2 = "Screenshot_" + calendar.get(1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (calendar.get(2) + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(10) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(12) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(13) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(14) + d.c.a.b.a.a.s1 + context.getPackageName() + PictureMimeType.PNG;
        String str3 = str + File.separator + str2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ContentValues contentValues = new ContentValues();
        ContentResolver contentResolver = context.getContentResolver();
        contentValues.put("_data", str3);
        contentValues.put("title", str2);
        contentValues.put("_display_name", str2);
        contentValues.put("datetaken", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("date_added", Long.valueOf(j2));
        contentValues.put("date_modified", Long.valueOf(j2));
        contentValues.put("mime_type", PictureMimeType.MIME_TYPE_PNG);
        contentValues.put(SocializeProtocolConstants.WIDTH, Integer.valueOf(width));
        contentValues.put(SocializeProtocolConstants.HEIGHT, Integer.valueOf(height));
        Uri uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        try {
            OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStreamOpenOutputStream);
            outputStreamOpenOutputStream.flush();
            outputStreamOpenOutputStream.close();
        } catch (FileNotFoundException e2) {
            d dVar = this.a;
            if (dVar != null) {
                dVar.b();
            }
            e2.printStackTrace();
        } catch (IOException e3) {
            d dVar2 = this.a;
            if (dVar2 != null) {
                dVar2.b();
            }
            e3.printStackTrace();
        }
        contentValues.clear();
        contentValues.put("_size", Long.valueOf(new File(str3).length()));
        contentResolver.update(uriInsert, contentValues, null, null);
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        Uri uriFromFile = Uri.fromFile(new File(str3));
        intent.setData(uriFromFile);
        context.sendBroadcast(intent);
        return uriFromFile;
    }

    public b2 a(int i2, int i3, int i4) {
        this.f14847b = i2;
        this.f14848c = i3;
        this.f14849d = i4;
        return this;
    }

    public b2 a(Context context) {
        this.f14851f = context;
        return this;
    }

    public b2 a(Intent intent) {
        this.f14850e = intent;
        d();
        return this;
    }

    public void a() {
        k();
        j();
    }
}
