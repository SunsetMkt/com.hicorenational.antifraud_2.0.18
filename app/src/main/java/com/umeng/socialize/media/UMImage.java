package com.umeng.socialize.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.umeng.social.tool.UMImageMark;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.p217c.p218a.C3633a;
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
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes2.dex */
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

    /* renamed from: f */
    private ConfiguredConvertor f13653f;

    /* renamed from: g */
    private UMImage f13654g;

    /* renamed from: h */
    private UMImageMark f13655h;

    /* renamed from: i */
    private int f13656i;
    public boolean isLoadImgByCompress;

    /* renamed from: j */
    private boolean f13657j;

    class BinaryConvertor extends ConfiguredConvertor {

        /* renamed from: b */
        private byte[] f13659b;

        public BinaryConvertor(byte[] bArr) {
            this.f13659b = bArr;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return this.f13659b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return C3633a.m12613a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return C3633a.m12622b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    class BitmapConvertor extends ConfiguredConvertor {

        /* renamed from: b */
        private Bitmap f13661b;

        public BitmapConvertor(Bitmap bitmap) {
            this.f13661b = bitmap;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return C3633a.m12616a(this.f13661b, UMImage.this.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            return this.f13661b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            byte[] m12616a = C3633a.m12616a(this.f13661b, UMImage.this.compressFormat);
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return C3633a.m12622b(m12616a);
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

        /* renamed from: b */
        private File f13664b;

        public FileConvertor(File file) {
            this.f13664b = file;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return C3633a.m12618a(this.f13664b, UMImage.this.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return C3633a.m12613a(UMImage.this.asBinImage());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            return this.f13664b;
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

        /* renamed from: b */
        private Context f13666b;

        /* renamed from: c */
        private int f13667c;

        public ResConvertor(Context context, int i2) {
            this.f13667c = 0;
            this.f13666b = context;
            this.f13667c = i2;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            Context context = this.f13666b;
            int i2 = this.f13667c;
            UMImage uMImage = UMImage.this;
            return C3633a.m12615a(context, i2, uMImage.isLoadImgByCompress, uMImage.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return C3633a.m12613a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return C3633a.m12622b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    class UrlConvertor extends ConfiguredConvertor {

        /* renamed from: b */
        private String f13669b;

        public UrlConvertor(String str) {
            this.f13669b = null;
            this.f13669b = str;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return C3633a.m12619a(this.f13669b);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return C3633a.m12613a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return C3633a.m12622b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return this.f13669b;
        }
    }

    public UMImage(Context context, File file) {
        this.f13653f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f13656i = 0;
        m12654a(context, file);
    }

    /* renamed from: a */
    private float m12649a(float f2, float f3, float f4, float f5) {
        if (f2 <= f5 && f3 <= f5) {
            return -1.0f;
        }
        float f6 = f2 / f4;
        float f7 = f3 / f5;
        return f6 > f7 ? f6 : f7;
    }

    /* renamed from: a */
    private void m12654a(Context context, Object obj) {
        m12655a(context, obj, null);
    }

    /* renamed from: b */
    private void m12657b(Bitmap bitmap) {
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
        ConfiguredConvertor configuredConvertor = this.f13653f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asBinary();
    }

    public Bitmap asBitmap() {
        ConfiguredConvertor configuredConvertor = this.f13653f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asBitmap();
    }

    public File asFileImage() {
        ConfiguredConvertor configuredConvertor = this.f13653f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asFile();
    }

    public String asUrlImage() {
        ConfiguredConvertor configuredConvertor = this.f13653f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asUrl();
    }

    public int getImageStyle() {
        return this.f13656i;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.IMAGE;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public UMImage getThumbImage() {
        return this.f13654g;
    }

    public boolean isHasWaterMark() {
        return this.f13657j;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public void setThumb(UMImage uMImage) {
        this.f13654g = uMImage;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        return asBinImage();
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f13632a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
        }
        return hashMap;
    }

    /* renamed from: a */
    private void m12655a(Context context, Object obj, UMImageMark uMImageMark) {
        Bitmap m12652a;
        if (uMImageMark != null) {
            this.f13657j = true;
            this.f13655h = uMImageMark;
            this.f13655h.setContext(context);
        }
        if (ContextUtil.getContext() == null) {
            ContextUtil.setContext(context.getApplicationContext());
        }
        if (obj instanceof File) {
            this.f13656i = FILE_IMAGE;
            this.f13653f = new FileConvertor((File) obj);
            return;
        }
        if (obj instanceof String) {
            this.f13656i = URL_IMAGE;
            this.f13653f = new UrlConvertor((String) obj);
            return;
        }
        if (obj instanceof Integer) {
            this.f13656i = RES_IMAGE;
            m12652a = isHasWaterMark() ? m12650a(context, ((Integer) obj).intValue()) : null;
            if (m12652a != null) {
                this.f13653f = new BitmapConvertor(m12652a);
                return;
            } else {
                this.f13653f = new ResConvertor(context.getApplicationContext(), ((Integer) obj).intValue());
                return;
            }
        }
        if (obj instanceof byte[]) {
            this.f13656i = BINARY_IMAGE;
            m12652a = isHasWaterMark() ? m12653a((byte[]) obj) : null;
            if (m12652a != null) {
                this.f13653f = new BitmapConvertor(m12652a);
                return;
            } else {
                this.f13653f = new BinaryConvertor((byte[]) obj);
                return;
            }
        }
        if (obj instanceof Bitmap) {
            this.f13656i = BITMAP_IMAGE;
            m12652a = isHasWaterMark() ? m12652a((Bitmap) obj, true) : null;
            if (m12652a == null) {
                m12652a = (Bitmap) obj;
            }
            this.f13653f = new BitmapConvertor(m12652a);
            return;
        }
        if (obj != null) {
            SLog.m12716E(UmengText.IMAGE.UNKNOW_UMIMAGE + obj.getClass().getSimpleName());
            return;
        }
        SLog.m12716E(UmengText.IMAGE.UNKNOW_UMIMAGE + AbstractC1191a.f2571h);
    }

    public UMImage(Context context, String str) {
        super(str);
        this.f13653f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f13656i = 0;
        m12654a((Context) new WeakReference(context).get(), str);
    }

    public UMImage(Context context, int i2) {
        this.f13653f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f13656i = 0;
        m12654a(context, Integer.valueOf(i2));
    }

    public UMImage(Context context, byte[] bArr) {
        this.f13653f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f13656i = 0;
        m12654a(context, bArr);
    }

    public UMImage(Context context, Bitmap bitmap) {
        this.f13653f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f13656i = 0;
        m12654a(context, bitmap);
    }

    /* renamed from: a */
    private Bitmap m12652a(Bitmap bitmap, boolean z) {
        if (this.f13655h == null) {
            return bitmap;
        }
        if (bitmap == null) {
            return null;
        }
        if (z) {
            try {
                bitmap = m12651a(bitmap);
            } catch (Exception e2) {
                SLog.error(e2);
                return null;
            }
        }
        return this.f13655h.compound(bitmap);
    }

    public UMImage(Context context, Bitmap bitmap, UMImageMark uMImageMark) {
        this.f13653f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f13656i = 0;
        m12655a(context, bitmap, uMImageMark);
    }

    /* renamed from: a */
    private Bitmap m12650a(Context context, int i2) {
        InputStream inputStream;
        InputStream inputStream2;
        if (i2 != 0 && context != null) {
            try {
                if (this.f13655h != null) {
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        inputStream2 = context.getResources().openRawResource(i2);
                        try {
                            BitmapFactory.decodeStream(inputStream2, null, options);
                            m12656a(inputStream2);
                            int m12649a = (int) m12649a(options.outWidth, options.outHeight, MAX_WIDTH, MAX_HEIGHT);
                            if (m12649a > 0) {
                                options.inSampleSize = m12649a;
                            }
                            options.inJustDecodeBounds = false;
                            InputStream openRawResource = context.getResources().openRawResource(i2);
                            try {
                                Bitmap m12652a = m12652a(BitmapFactory.decodeStream(openRawResource, null, options), false);
                                m12656a(openRawResource);
                                return m12652a;
                            } catch (Exception e2) {
                                inputStream2 = openRawResource;
                                e = e2;
                                SLog.error(e);
                                m12656a(inputStream2);
                                return null;
                            } catch (Throwable th) {
                                inputStream = openRawResource;
                                th = th;
                                m12656a(inputStream);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        inputStream2 = null;
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
        this.f13653f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f13656i = 0;
        m12655a(context, Integer.valueOf(i2), uMImageMark);
    }

    public UMImage(Context context, byte[] bArr, UMImageMark uMImageMark) {
        this.f13653f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f13656i = 0;
        m12655a(context, bArr, uMImageMark);
    }

    /* renamed from: a */
    private void m12656a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                SLog.error(e2);
            }
        }
    }

    /* renamed from: a */
    private Bitmap m12653a(byte[] bArr) {
        if (bArr != null && this.f13655h != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                int m12649a = (int) m12649a(options.outWidth, options.outHeight, MAX_WIDTH, MAX_HEIGHT);
                if (m12649a > 0) {
                    options.inSampleSize = m12649a;
                }
                options.inJustDecodeBounds = false;
                return m12652a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options), false);
            } catch (Exception e2) {
                SLog.error(e2);
            }
        }
        return null;
    }

    /* renamed from: a */
    private Bitmap m12651a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float m12649a = m12649a(width, height, MAX_WIDTH, MAX_HEIGHT);
        if (m12649a < 0.0f) {
            return bitmap;
        }
        float f2 = 1.0f / m12649a;
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        m12657b(bitmap);
        return createBitmap;
    }
}
