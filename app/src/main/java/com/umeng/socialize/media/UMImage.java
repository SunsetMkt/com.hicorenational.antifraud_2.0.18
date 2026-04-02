package com.umeng.socialize.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.umeng.social.tool.UMImageMark;
import com.umeng.socialize.c.a.a;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UMImage extends BaseMediaObject {
    public static int BINARY_IMAGE = 5;
    public static int BITMAP_IMAGE = 4;
    public static int FILE_IMAGE = 1;
    public static int MAX_HEIGHT = 1024;
    public static int MAX_WIDTH = 768;
    public static int RES_IMAGE = 3;
    public static int URL_IMAGE = 2;
    public Bitmap.CompressFormat compressFormat;
    public CompressStyle compressStyle;

    /* JADX INFO: renamed from: f */
    private ConfiguredConvertor f8289f;

    /* JADX INFO: renamed from: g */
    private UMImage f8290g;

    /* JADX INFO: renamed from: h */
    private UMImageMark f8291h;

    /* JADX INFO: renamed from: i */
    private int f8292i;
    public boolean isLoadImgByCompress;

    /* JADX INFO: renamed from: j */
    private boolean f8293j;

    class BinaryConvertor extends ConfiguredConvertor {

        /* JADX INFO: renamed from: b */
        private byte[] f8294b;

        public BinaryConvertor(byte[] bArr) {
            this.f8294b = bArr;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return this.f8294b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    class BitmapConvertor extends ConfiguredConvertor {

        /* JADX INFO: renamed from: b */
        private Bitmap f8295b;

        public BitmapConvertor(Bitmap bitmap) {
            this.f8295b = bitmap;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return a.a(this.f8295b, UMImage.this.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            return this.f8295b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            byte[] bArrA = a.a(this.f8295b, UMImage.this.compressFormat);
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(bArrA);
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    public enum CompressStyle {
        SCALE,
        QUALITY
    }

    static abstract class ConfiguredConvertor implements IImageConvertor {
        ConfiguredConvertor() {
        }
    }

    class FileConvertor extends ConfiguredConvertor {

        /* JADX INFO: renamed from: b */
        private File f8296b;

        public FileConvertor(File file) {
            this.f8296b = file;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return a.a(this.f8296b, UMImage.this.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(UMImage.this.asBinImage());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            return this.f8296b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    interface IImageConvertor {
        byte[] asBinary();

        Bitmap asBitmap();

        File asFile();

        String asUrl();
    }

    class ResConvertor extends ConfiguredConvertor {

        /* JADX INFO: renamed from: b */
        private Context f8297b;

        /* JADX INFO: renamed from: c */
        private int f8298c;

        public ResConvertor(Context context, int i2) {
            this.f8298c = 0;
            this.f8297b = context;
            this.f8298c = i2;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            Context context = this.f8297b;
            int i2 = this.f8298c;
            UMImage uMImage = UMImage.this;
            return a.a(context, i2, uMImage.isLoadImgByCompress, uMImage.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    class UrlConvertor extends ConfiguredConvertor {

        /* JADX INFO: renamed from: b */
        private String f8299b;

        public UrlConvertor(String str) {
            this.f8299b = null;
            this.f8299b = str;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return a.a(this.f8299b);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return this.f8299b;
        }
    }

    public UMImage(Context context, File file) {
        this.f8289f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f8292i = 0;
        a(context, file);
    }

    private float a(float f2, float f3, float f4, float f5) {
        if (f2 <= f5 && f3 <= f5) {
            return -1.0f;
        }
        float f6 = f2 / f4;
        float f7 = f3 / f5;
        return f6 > f7 ? f6 : f7;
    }

    private void a(Context context, Object obj) {
        a(context, obj, null);
    }

    private void b(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            } catch (Exception e2) {
                SLog.error(e2);
            }
        }
    }

    public byte[] asBinImage() {
        ConfiguredConvertor configuredConvertor = this.f8289f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asBinary();
    }

    public Bitmap asBitmap() {
        ConfiguredConvertor configuredConvertor = this.f8289f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asBitmap();
    }

    public File asFileImage() {
        ConfiguredConvertor configuredConvertor = this.f8289f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asFile();
    }

    public String asUrlImage() {
        ConfiguredConvertor configuredConvertor = this.f8289f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asUrl();
    }

    public int getImageStyle() {
        return this.f8292i;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.IMAGE;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public UMImage getThumbImage() {
        return this.f8290g;
    }

    public boolean isHasWaterMark() {
        return this.f8293j;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public void setThumb(UMImage uMImage) {
        this.f8290g = uMImage;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        return asBinImage();
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap map = new HashMap();
        if (isUrlMedia()) {
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.a);
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
        }
        return map;
    }

    private void a(Context context, Object obj, UMImageMark uMImageMark) {
        Bitmap bitmapA;
        if (uMImageMark != null) {
            this.f8293j = true;
            this.f8291h = uMImageMark;
            this.f8291h.setContext(context);
        }
        if (ContextUtil.getContext() == null) {
            ContextUtil.setContext(context.getApplicationContext());
        }
        if (obj instanceof File) {
            this.f8292i = FILE_IMAGE;
            this.f8289f = new FileConvertor((File) obj);
            return;
        }
        if (obj instanceof String) {
            this.f8292i = URL_IMAGE;
            this.f8289f = new UrlConvertor((String) obj);
            return;
        }
        if (obj instanceof Integer) {
            this.f8292i = RES_IMAGE;
            bitmapA = isHasWaterMark() ? a(context, ((Integer) obj).intValue()) : null;
            if (bitmapA != null) {
                this.f8289f = new BitmapConvertor(bitmapA);
                return;
            } else {
                this.f8289f = new ResConvertor(context.getApplicationContext(), ((Integer) obj).intValue());
                return;
            }
        }
        if (obj instanceof byte[]) {
            this.f8292i = BINARY_IMAGE;
            bitmapA = isHasWaterMark() ? a((byte[]) obj) : null;
            if (bitmapA != null) {
                this.f8289f = new BitmapConvertor(bitmapA);
                return;
            } else {
                this.f8289f = new BinaryConvertor((byte[]) obj);
                return;
            }
        }
        if (obj instanceof Bitmap) {
            this.f8292i = BITMAP_IMAGE;
            bitmapA = isHasWaterMark() ? a((Bitmap) obj, true) : null;
            if (bitmapA == null) {
                bitmapA = (Bitmap) obj;
            }
            this.f8289f = new BitmapConvertor(bitmapA);
            return;
        }
        if (obj != null) {
            SLog.E(UmengText.IMAGE.UNKNOW_UMIMAGE + obj.getClass().getSimpleName());
            return;
        }
        SLog.E(UmengText.IMAGE.UNKNOW_UMIMAGE + d.c.a.b.a.a.f10075h);
    }

    public UMImage(Context context, String str) {
        super(str);
        this.f8289f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f8292i = 0;
        a((Context) new WeakReference(context).get(), str);
    }

    public UMImage(Context context, int i2) {
        this.f8289f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f8292i = 0;
        a(context, Integer.valueOf(i2));
    }

    public UMImage(Context context, byte[] bArr) {
        this.f8289f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f8292i = 0;
        a(context, bArr);
    }

    public UMImage(Context context, Bitmap bitmap) {
        this.f8289f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f8292i = 0;
        a(context, bitmap);
    }

    private Bitmap a(Bitmap bitmap, boolean z) {
        if (this.f8291h == null) {
            return bitmap;
        }
        if (bitmap == null) {
            return null;
        }
        if (z) {
            try {
                bitmap = a(bitmap);
            } catch (Exception e2) {
                SLog.error(e2);
                return null;
            }
        }
        return this.f8291h.compound(bitmap);
    }

    public UMImage(Context context, Bitmap bitmap, UMImageMark uMImageMark) {
        this.f8289f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f8292i = 0;
        a(context, bitmap, uMImageMark);
    }

    private Bitmap a(Context context, int i2) throws Throwable {
        InputStream inputStream;
        InputStream inputStreamOpenRawResource;
        if (i2 != 0 && context != null) {
            try {
                if (this.f8291h != null) {
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        inputStreamOpenRawResource = context.getResources().openRawResource(i2);
                        try {
                            BitmapFactory.decodeStream(inputStreamOpenRawResource, null, options);
                            a(inputStreamOpenRawResource);
                            int iA = (int) a(options.outWidth, options.outHeight, MAX_WIDTH, MAX_HEIGHT);
                            if (iA > 0) {
                                options.inSampleSize = iA;
                            }
                            options.inJustDecodeBounds = false;
                            InputStream inputStreamOpenRawResource2 = context.getResources().openRawResource(i2);
                            try {
                                Bitmap bitmapA = a(BitmapFactory.decodeStream(inputStreamOpenRawResource2, null, options), false);
                                a(inputStreamOpenRawResource2);
                                return bitmapA;
                            } catch (Exception e2) {
                                inputStreamOpenRawResource = inputStreamOpenRawResource2;
                                e = e2;
                                SLog.error(e);
                                a(inputStreamOpenRawResource);
                                return null;
                            } catch (Throwable th) {
                                inputStream = inputStreamOpenRawResource2;
                                th = th;
                                a(inputStream);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        inputStreamOpenRawResource = null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }

    public UMImage(Context context, int i2, UMImageMark uMImageMark) {
        this.f8289f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f8292i = 0;
        a(context, Integer.valueOf(i2), uMImageMark);
    }

    public UMImage(Context context, byte[] bArr, UMImageMark uMImageMark) {
        this.f8289f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f8292i = 0;
        a(context, bArr, uMImageMark);
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                SLog.error(e2);
            }
        }
    }

    private Bitmap a(byte[] bArr) {
        if (bArr != null && this.f8291h != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                int iA = (int) a(options.outWidth, options.outHeight, MAX_WIDTH, MAX_HEIGHT);
                if (iA > 0) {
                    options.inSampleSize = iA;
                }
                options.inJustDecodeBounds = false;
                return a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options), false);
            } catch (Exception e2) {
                SLog.error(e2);
            }
        }
        return null;
    }

    private Bitmap a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float fA = a(width, height, MAX_WIDTH, MAX_HEIGHT);
        if (fA < 0.0f) {
            return bitmap;
        }
        float f2 = 1.0f / fA;
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        b(bitmap);
        return bitmapCreateBitmap;
    }
}
