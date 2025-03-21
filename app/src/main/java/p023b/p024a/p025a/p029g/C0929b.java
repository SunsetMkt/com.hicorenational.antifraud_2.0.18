package p023b.p024a.p025a.p029g;

import android.R;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p286h.C5230f1;

/* compiled from: ConvertUtils.java */
/* renamed from: b.a.a.g.b */
/* loaded from: classes.dex */
public class C0929b {

    /* renamed from: a */
    public static final long f1558a = 1073741824;

    /* renamed from: b */
    public static final long f1559b = 1048576;

    /* renamed from: c */
    public static final long f1560c = 1024;

    /* renamed from: a */
    public static float m1080a(Object obj) {
        try {
            return Float.parseFloat(obj.toString());
        } catch (NumberFormatException unused) {
            return -1.0f;
        }
    }

    /* renamed from: a */
    public static int m1081a(byte b2, byte b3) {
        return (b2 << 8) + (b3 & C5230f1.f20085c);
    }

    /* renamed from: b */
    public static int m1104b(Object obj) {
        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: c */
    public static long m1113c(Object obj) {
        try {
            return Long.parseLong(obj.toString());
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    /* renamed from: d */
    public static String m1118d(byte... bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i4 = bArr[i3] < 0 ? bArr[i3] + 256 : bArr[i3];
            int i5 = i2 + 1;
            cArr2[i2] = cArr[i4 >>> 4];
            i2 = i5 + 1;
            cArr2[i5] = cArr[i4 & 15];
        }
        return new String(cArr2);
    }

    /* renamed from: e */
    public static int m1119e(byte[] bArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i2 += (bArr[i3] & C5230f1.f20085c) << (i3 * 8);
        }
        return i2;
    }

    /* renamed from: a */
    public static byte[] m1101a(String str, boolean z) {
        if (str == null || str.equals("")) {
            return null;
        }
        if (!z) {
            return str.getBytes();
        }
        String replaceAll = str.replaceAll("\\s+", "");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(replaceAll.length() / 2);
        for (int i2 = 0; i2 < replaceAll.length(); i2 += 2) {
            byteArrayOutputStream.write(("0123456789ABCDEF".indexOf(replaceAll.charAt(i2)) << 4) | "0123456789ABCDEF".indexOf(replaceAll.charAt(i2 + 1)));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            C0931d.m1159c(e2);
        }
        return byteArray;
    }

    /* renamed from: b */
    public static byte[] m1110b(int i2) {
        return ByteBuffer.allocate(4).putInt(i2).array();
    }

    /* renamed from: c */
    public static String m1116c(String str) {
        String str2 = "";
        for (char c2 : str.toCharArray()) {
            if (c2 == '\"' || c2 == '\'' || c2 == '\\') {
                str2 = str2 + "\\";
            }
            str2 = str2 + c2;
        }
        return str2;
    }

    /* renamed from: b */
    public static String m1108b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : str.getBytes()) {
            sb.append(Integer.toHexString(b2 & C5230f1.f20085c));
            sb.append(AbstractC1191a.f2568g);
        }
        return sb.toString();
    }

    /* renamed from: e */
    public static String m1120e(int i2) {
        String hexString = Integer.toHexString(i2);
        C0931d.m1166e(String.format(Locale.CHINA, "%d to hex string is %s", Integer.valueOf(i2), hexString));
        return hexString;
    }

    /* renamed from: c */
    public static Drawable m1114c(byte[] bArr) {
        return m1106b(m1105b(bArr));
    }

    /* renamed from: c */
    public static int m1112c(Context context, float f2) {
        int i2 = (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
        C0931d.m1166e(f2 + " px == " + i2 + " sp");
        return i2;
    }

    /* renamed from: d */
    public static int m1117d(@ColorInt int i2) {
        return m1082a(i2, 0.8f);
    }

    /* renamed from: c */
    public static String m1115c(@ColorInt int i2) {
        return m1090a(i2, false);
    }

    /* renamed from: b */
    public static String m1109b(Object[] objArr) {
        return Arrays.deepToString(objArr);
    }

    /* renamed from: b */
    public static Bitmap m1105b(byte[] bArr) {
        return m1088a(bArr, -1, -1);
    }

    /* renamed from: b */
    public static Drawable m1106b(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable(Resources.getSystem(), bitmap);
    }

    /* renamed from: b */
    public static byte[] m1111b(Drawable drawable) {
        return m1099a(m1086a(drawable));
    }

    /* renamed from: a */
    public static String m1096a(byte... bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 8];
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i4 = bArr[i3] < 0 ? bArr[i3] + 256 : bArr[i3];
            int i5 = i2 + 1;
            cArr2[i2] = cArr[(i4 >>> 7) & 1];
            int i6 = i5 + 1;
            cArr2[i5] = cArr[(i4 >>> 6) & 1];
            int i7 = i6 + 1;
            cArr2[i6] = cArr[(i4 >>> 5) & 1];
            int i8 = i7 + 1;
            cArr2[i7] = cArr[(i4 >>> 4) & 1];
            int i9 = i8 + 1;
            cArr2[i8] = cArr[(i4 >>> 3) & 1];
            int i10 = i9 + 1;
            cArr2[i9] = cArr[(i4 >>> 2) & 1];
            int i11 = i10 + 1;
            cArr2[i10] = cArr[(i4 >>> 1) & 1];
            i2 = i11 + 1;
            cArr2[i11] = cArr[i4 & 1];
        }
        return new String(cArr2);
    }

    /* renamed from: b */
    public static int m1103b(Context context, float f2) {
        int i2 = (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
        C0931d.m1166e(f2 + " dp == " + i2 + " px");
        return i2;
    }

    /* renamed from: b */
    public static String m1107b(InputStream inputStream) {
        return m1094a(inputStream, "utf-8");
    }

    /* renamed from: a */
    public static String m1089a(int i2) {
        String binaryString = Integer.toBinaryString(i2);
        C0931d.m1166e(String.format(Locale.CHINA, "%d to binary string is %s", Integer.valueOf(i2), binaryString));
        return binaryString;
    }

    /* renamed from: a */
    public static <T> T[] m1102a(List<T> list) {
        return (T[]) list.toArray();
    }

    /* renamed from: a */
    public static <T> List<T> m1098a(T[] tArr) {
        return Arrays.asList(tArr);
    }

    /* renamed from: a */
    public static String m1097a(Object[] objArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
            sb.append(str);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static byte[] m1100a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[100];
            while (true) {
                int read = inputStream.read(bArr, 0, 100);
                if (read == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e2) {
            C0931d.m1159c(e2);
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m1099a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            C0931d.m1159c(e2);
        }
        return byteArray;
    }

    /* renamed from: a */
    public static Bitmap m1088a(byte[] bArr, int i2, int i3) {
        Bitmap bitmap = null;
        if (bArr.length == 0) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDither = false;
            options.inPreferredConfig = null;
            if (i2 > 0 && i3 > 0) {
                options.outWidth = i2;
                options.outHeight = i3;
            }
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            bitmap.setDensity(96);
            return bitmap;
        } catch (Exception e2) {
            C0931d.m1148a(e2);
            return bitmap;
        }
    }

    /* renamed from: a */
    public static Bitmap m1086a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof ColorDrawable) {
            Bitmap createBitmap = Bitmap.createBitmap(32, 32, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawColor(((ColorDrawable) drawable).getColor());
            return createBitmap;
        }
        if (!(drawable instanceof NinePatchDrawable)) {
            return null;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap2;
    }

    @TargetApi(19)
    /* renamed from: a */
    public static String m1092a(Context context, Uri uri) {
        if (uri == null) {
            C0931d.m1166e("uri is null");
            return "";
        }
        C0931d.m1166e("uri: " + uri.toString());
        String path = uri.getPath();
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            String[] split = documentId.split(Constants.COLON_SEPARATOR);
            String str = split[0];
            char c2 = 65535;
            int hashCode = authority.hashCode();
            if (hashCode != 320699453) {
                if (hashCode != 596745902) {
                    if (hashCode == 1734583286 && authority.equals("com.android.providers.media.documents")) {
                        c2 = 2;
                    }
                } else if (authority.equals("com.android.externalstorage.documents")) {
                    c2 = 0;
                }
            } else if (authority.equals("com.android.providers.downloads.documents")) {
                c2 = 1;
            }
            if (c2 != 0) {
                if (c2 == 1) {
                    return m1093a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), (String) null, (String[]) null);
                }
                if (c2 == 2) {
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return m1093a(context, uri2, "_id=?", new String[]{split[1]});
                }
            } else if ("primary".equalsIgnoreCase(str)) {
                return Environment.getExternalStorageDirectory() + "/" + split[1];
            }
        } else {
            if ("content".equalsIgnoreCase(scheme)) {
                if (authority.equals("com.google.android.apps.photos.content")) {
                    return uri.getLastPathSegment();
                }
                return m1093a(context, uri, (String) null, (String[]) null);
            }
            if ("file".equalsIgnoreCase(scheme)) {
                return uri.getPath();
            }
        }
        C0931d.m1166e("uri to path: " + path);
        return path;
    }

    /* renamed from: a */
    private static String m1093a(Context context, Uri uri, String str, String[] strArr) {
        String str2 = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query == null) {
                return null;
            }
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
            query.moveToFirst();
            str2 = query.getString(columnIndexOrThrow);
            query.close();
            return str2;
        } catch (IllegalArgumentException e2) {
            C0931d.m1148a(e2);
            return str2;
        }
    }

    /* renamed from: a */
    public static Bitmap m1087a(View view) {
        int i2;
        int width = view.getWidth();
        int height = view.getHeight();
        if (view instanceof ListView) {
            ListView listView = (ListView) view;
            i2 = 0;
            for (int i3 = 0; i3 < listView.getChildCount(); i3++) {
                i2 += listView.getChildAt(i3).getHeight();
            }
        } else if (view instanceof ScrollView) {
            ScrollView scrollView = (ScrollView) view;
            i2 = 0;
            for (int i4 = 0; i4 < scrollView.getChildCount(); i4++) {
                i2 += scrollView.getChildAt(i4).getHeight();
            }
        } else {
            i2 = height;
        }
        view.setDrawingCacheEnabled(true);
        view.clearFocus();
        view.setPressed(false);
        boolean willNotCacheDrawing = view.willNotCacheDrawing();
        view.setWillNotCacheDrawing(false);
        int drawingCacheBackgroundColor = view.getDrawingCacheBackgroundColor();
        view.setDrawingCacheBackgroundColor(-1);
        if (drawingCacheBackgroundColor != -1) {
            view.destroyDrawingCache();
        }
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(drawingCache, 0.0f, 0.0f, (Paint) null);
        canvas.save();
        canvas.restore();
        if (!createBitmap.isRecycled()) {
            C0931d.m1166e("recycle bitmap: " + createBitmap.toString());
            createBitmap.recycle();
        }
        view.destroyDrawingCache();
        view.setWillNotCacheDrawing(willNotCacheDrawing);
        view.setDrawingCacheBackgroundColor(drawingCacheBackgroundColor);
        return createBitmap;
    }

    /* renamed from: a */
    public static int m1083a(Context context, float f2) {
        int i2 = (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
        C0931d.m1166e(f2 + " px == " + i2 + " dp");
        return i2;
    }

    /* renamed from: a */
    public static String m1095a(String str) {
        try {
            return new String(str.getBytes("utf-8"), "gbk");
        } catch (UnsupportedEncodingException e2) {
            C0931d.m1159c(e2);
            return str;
        }
    }

    /* renamed from: a */
    public static String m1091a(long j2) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j2 < 1024) {
            return j2 + "B";
        }
        if (j2 < 1048576) {
            return decimalFormat.format(j2 / 1024.0d) + "K";
        }
        if (j2 < f1558a) {
            return decimalFormat.format(j2 / 1048576.0d) + "M";
        }
        return decimalFormat.format(j2 / 1.073741824E9d) + "G";
    }

    /* renamed from: a */
    public static String m1094a(InputStream inputStream, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
            }
            bufferedReader.close();
            inputStream.close();
        } catch (IOException e2) {
            C0931d.m1148a(e2);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static int m1082a(@ColorInt int i2, @FloatRange(from = 0.0d, m293to = 1.0d) float f2) {
        float[] fArr = new float[3];
        Color.colorToHSV(i2, fArr);
        fArr[2] = fArr[2] * f2;
        return Color.HSVToColor(fArr);
    }

    /* renamed from: a */
    public static String m1090a(@ColorInt int i2, boolean z) {
        String hexString = Integer.toHexString(Color.alpha(i2));
        String hexString2 = Integer.toHexString(Color.red(i2));
        String hexString3 = Integer.toHexString(Color.green(i2));
        String hexString4 = Integer.toHexString(Color.blue(i2));
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        if (hexString2.length() == 1) {
            hexString2 = "0" + hexString2;
        }
        if (hexString3.length() == 1) {
            hexString3 = "0" + hexString3;
        }
        if (hexString4.length() == 1) {
            hexString4 = "0" + hexString4;
        }
        if (z) {
            String str = hexString + hexString2 + hexString3 + hexString4;
            C0931d.m1166e(String.format(Locale.CHINA, "%d to color string is %s", Integer.valueOf(i2), str));
            return str;
        }
        String str2 = hexString2 + hexString3 + hexString4;
        C0931d.m1166e(String.format(Locale.CHINA, "%d to color string is %s%s%s%s, exclude alpha is %s", Integer.valueOf(i2), hexString, hexString2, hexString3, hexString4, str2));
        return str2;
    }

    /* renamed from: a */
    public static ColorStateList m1085a(@ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorInt int i5) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_enabled}, new int[]{R.attr.state_enabled, R.attr.state_focused}, new int[]{R.attr.state_enabled}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_window_focused}, new int[0]}, new int[]{i3, i4, i2, i4, i5, i2});
    }

    /* renamed from: a */
    public static ColorStateList m1084a(@ColorInt int i2, @ColorInt int i3) {
        return m1085a(i2, i3, i3, i2);
    }
}
