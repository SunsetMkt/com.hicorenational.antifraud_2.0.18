package util;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import com.hicorenational.antifraud.R;
import com.huawei.hms.android.SystemUtils;
import com.luck.picture.lib.entity.LocalMedia;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.common.Constants;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.vivo.push.PushClientConstants;
import interfaces.IHandler;
import interfaces.IOneClickListener;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import network.gson.ResponseDataTypeAdaptor;
import org.json.JSONArray;
import ui.Hicore;
import ui.activity.WebActivity;
import ui.presenter.WelocmPresenter;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes2.dex */
public class g2 {

    /* JADX INFO: renamed from: c */
    private static final String f14890c = "(^1(33|53|77|73|99|8[019])\\d{8}$)|(^1700\\d{7}$)";

    /* JADX INFO: renamed from: d */
    private static final String f14891d = "(^1(3[0-2]|4[5]|5[56]|6[6]|7[56]|8[56])\\d{8}$)|(^1709\\d{7}$)";

    /* JADX INFO: renamed from: e */
    private static final String f14892e = "(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)";

    /* JADX INFO: renamed from: g */
    static final int f14894g = 160;
    private static ThreadLocal<SimpleDateFormat> a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b */
    public static Handler f14889b = IHandler.mHandler;

    /* JADX INFO: renamed from: f */
    @SuppressLint({"SimpleDateFormat"})
    private static final ThreadLocal<SimpleDateFormat> f14893f = new c();

    /* JADX INFO: renamed from: h */
    static final int[] f14895h = {1601, 1637, 1833, 2078, 2274, 2302, 2433, 2594, 2787, 3106, 3212, 3472, 3635, 3722, 3730, 3858, 4027, 4086, 4390, 4558, 4684, 4925, 5249, 5600};

    /* JADX INFO: renamed from: i */
    static final char[] f14896i = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'w', 'x', 'y', 'z'};

    /* JADX INFO: compiled from: Utils.java */
    static class a extends ClickableSpan {
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str;
            if (view instanceof TextView) {
                ((TextView) view).setHighlightColor(0);
            }
            if (TextUtils.isEmpty(WelocmPresenter.XY_service)) {
                str = e.a.f10142f + f.b.y;
            } else {
                str = WelocmPresenter.XY_service;
            }
            String str2 = str + "?time=" + e.a.m();
            Activity activity = this.a;
            activity.startActivity(new Intent(activity, (Class<?>) WebActivity.class).putExtra(p1.P, "\u670d\u52a1\u534f\u8bae").putExtra(p1.Q, str2));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: compiled from: Utils.java */
    static class b extends ClickableSpan {
        final /* synthetic */ Activity a;

        b(Activity activity) {
            this.a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str;
            if (view instanceof TextView) {
                ((TextView) view).setHighlightColor(0);
            }
            if (TextUtils.isEmpty(WelocmPresenter.XY_conceal)) {
                str = e.a.f10142f + f.b.x;
            } else {
                str = WelocmPresenter.XY_conceal;
            }
            String str2 = str + "?time=" + e.a.m();
            Activity activity = this.a;
            activity.startActivity(new Intent(activity, (Class<?>) WebActivity.class).putExtra(p1.P, "\u9690\u79c1\u653f\u7b56").putExtra(p1.Q, str2));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: compiled from: Utils.java */
    static class c extends ThreadLocal<SimpleDateFormat> {
        c() {
        }

        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    }

    /* JADX INFO: compiled from: Utils.java */
    static class d implements TextWatcher {
        boolean a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ EditText f14897b;

        d(EditText editText) {
            this.f14897b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (this.a) {
                this.f14897b.setText(editable.toString().substring(0, editable.toString().length() - 1));
                EditText editText = this.f14897b;
                editText.setSelection(editText.getText().length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence.toString().contains(".")) {
                if (charSequence.length() - charSequence.toString().lastIndexOf(".") >= 4) {
                    this.a = true;
                } else {
                    this.a = false;
                }
            }
        }
    }

    /* JADX INFO: compiled from: Utils.java */
    static class e implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ Activity a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ ScrollView f14898b;

        e(Activity activity, ScrollView scrollView) {
            this.a = activity;
            this.f14898b = scrollView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int height = this.a.getWindow().getDecorView().getRootView().getHeight();
            Rect rect = new Rect();
            this.a.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int iMax = Math.max(height, rect.bottom);
            int i2 = iMax - rect.bottom;
            if (i2 <= iMax / 4) {
                this.f14898b.setPadding(0, 0, 0, 0);
            } else {
                this.f14898b.setPadding(0, 0, 0, i2);
                this.f14898b.scrollTo(0, i2);
            }
        }
    }

    /* JADX INFO: compiled from: Utils.java */
    static class f implements ViewTreeObserver.OnGlobalLayoutListener {
        boolean a = false;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Activity f14899b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ NestedScrollView f14900c;

        f(Activity activity, NestedScrollView nestedScrollView) {
            this.f14899b = activity;
            this.f14900c = nestedScrollView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            View currentFocus = this.f14899b.getCurrentFocus();
            int height = this.f14899b.getWindow().getDecorView().getRootView().getHeight();
            Rect rect = new Rect();
            this.f14899b.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int iMax = Math.max(height, rect.bottom);
            int i2 = iMax - rect.bottom;
            if (i2 <= iMax / 4) {
                this.f14900c.setPadding(0, 0, 0, 0);
                this.a = false;
                return;
            }
            if (currentFocus == null || !(currentFocus instanceof EditText)) {
                return;
            }
            int[] iArr = new int[2];
            currentFocus.getLocationInWindow(iArr);
            int iA = ((iMax - iArr[1]) - g1.a(this.f14899b, 50.0f)) - this.f14900c.getScrollY();
            if (iA >= i2 || this.a) {
                return;
            }
            this.f14900c.setPadding(0, 0, 0, i2);
            this.f14900c.scrollTo(0, i2 - iA);
            this.a = true;
        }
    }

    public static String A(String str) {
        return str.replace(d.c.a.b.a.a.f10074g, "");
    }

    public static long B(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String a(int i2) {
        if (i2 == 64) {
            return "\u8d37\u6b3e\u4e2d\u4ecb";
        }
        switch (i2) {
            case 50:
                return "\u9a9a\u6270\u7535\u8bdd";
            case 51:
                return "\u623f\u4ea7\u4e2d\u4ecb";
            case 52:
                return "\u4fdd\u9669\u7406\u8d22";
            case 53:
                return "\u5e7f\u544a\u63a8\u9500";
            case 54:
                return "\u8bc8\u9a97\u7535\u8bdd";
            case 55:
                return "\u5feb\u9012\u9001\u9910";
            case 56:
                return "\u51fa\u79df\u8f66\u4e13\u8f66";
            case 57:
                return "\u62db\u8058\u730e\u5934";
            case 58:
                return "\u6559\u80b2\u57f9\u8bad";
            case 59:
                return "\u5bb6\u653f\u7269\u4e1a";
            case 60:
                return "\u642c\u8fd0\u9001\u8d27";
            case 61:
                return "\u7ef4\u4fee\u88c5\u4fee";
            default:
                return "";
        }
    }

    static /* synthetic */ void a(String str, Uri uri) {
    }

    public static boolean a(String str, String str2) {
        return Pattern.compile(str2).matcher(str).matches();
    }

    public static String b(Long l2) {
        return a(new Date(l2.longValue()));
    }

    public static String c() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    public static String d(String str) {
        e().applyPattern(str);
        return e().format(new Date(System.currentTimeMillis()));
    }

    public static SimpleDateFormat e() {
        SimpleDateFormat simpleDateFormat = a.get();
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat();
        a.set(simpleDateFormat2);
        return simpleDateFormat2;
    }

    public static String f(String str) {
        return str.substring(str.lastIndexOf("."));
    }

    public static void g() {
        File file;
        File[] fileArrListFiles;
        String strB = j1.b();
        String str = Build.BRAND;
        if (str.equalsIgnoreCase("xiaomi")) {
            file = new File(strB, "MIUI/sound_recorder/call_rec");
        } else if (str.equalsIgnoreCase("oppo")) {
            file = new File(strB, "Recordings/Call Recordings");
            if (!file.exists()) {
                file = new File(strB, "Recordings");
            }
        } else {
            file = (str.equalsIgnoreCase("huawei") || str.equalsIgnoreCase(SystemUtils.PRODUCT_HONOR)) ? new File(strB, "Sounds/CallRecord") : str.equalsIgnoreCase("vivo") ? new File(strB, "\u5f55\u97f3/\u901a\u8bdd\u5f55\u97f3") : str.equalsIgnoreCase("sansung") ? new File(strB, "Sounds") : str.equalsIgnoreCase("Letv") ? new File(strB, "Recorder/remote") : null;
        }
        if (file == null || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        Hicore.getApp().getSharedPreferences("record_preferences", 0).edit().putInt("file_nums", fileArrListFiles.length).commit();
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 2) {
            return str;
        }
        String str2 = "";
        for (int i2 = 0; i2 < str.length() - 2; i2++) {
            str2 = str2 + "*";
        }
        return str.substring(0, 1) + str2 + str.substring(str.length() - 1);
    }

    public static long i(String str) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String j(String str) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < str.length() - 1; i2++) {
                stringBuffer.append("*");
            }
            return str.replaceAll(str.substring(1), stringBuffer.toString());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String k(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            int length = str.length();
            if (length <= 1) {
                return "*";
            }
            return "*" + str.substring(1, length);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String l(String str) {
        try {
            return str.substring(0, 3) + "******" + str.substring(str.length() - 2);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String m(String str) {
        if (TextUtils.isEmpty(str) ? false : Pattern.matches(f14892e, str)) {
            return "\u4e2d\u56fd\u79fb\u52a8";
        }
        if (TextUtils.isEmpty(str) ? false : Pattern.matches(f14891d, str)) {
            return "\u4e2d\u56fd\u8054\u901a";
        }
        return TextUtils.isEmpty(str) ? false : Pattern.matches(f14890c, str) ? "\u4e2d\u56fd\u7535\u4fe1" : "\u672a\u77e5";
    }

    public static String n(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if ((cCharAt >> 7) != 0) {
                stringBuffer.append(String.valueOf(a(cCharAt).charValue()));
            }
        }
        return stringBuffer.toString();
    }

    public static String o(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 2) {
            return str;
        }
        String str2 = "";
        for (int i2 = 0; i2 < str.length() - 2; i2++) {
            str2 = str2 + "*";
        }
        return str.substring(0, 1) + str2 + str.substring(str.length() - 1);
    }

    public static boolean p(String str) {
        return str == null || str.length() == 0 || TextUtils.equals(d.c.a.b.a.a.f10075h, str);
    }

    public static boolean q(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean r(String str) {
        return Pattern.compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$").matcher(str).matches();
    }

    public static void s(String str) {
        ((ClipboardManager) Hicore.getApp().getSystemService("clipboard")).setText(str);
        e2.a("\u590d\u5236\u6210\u529f");
    }

    public static String t(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static boolean u(String str) {
        return str.matches("^[\\u4e00-\\u9fa5\\u36c3\\u4DAE]{2,}$");
    }

    public static boolean v(String str) {
        return Pattern.compile("^([a-z0-9A-Z]+[^\\s]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$").matcher(str).matches();
    }

    public static boolean w(String str) {
        return Pattern.compile("^.*[a-zA-Z]+.*$").matcher(str).matches();
    }

    public static boolean x(String str) {
        return str.matches("^[\\u4e00-\\u9fa5.\u00b7\u2022\\u36c3\\u4DAE]{2,}$");
    }

    public static boolean y(String str) {
        return Pattern.compile("^.*[0-9]+.*$").matcher(str).matches();
    }

    public static boolean z(String str) {
        return Pattern.compile("^[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]$").matcher(str).matches();
    }

    public static boolean f() {
        return a();
    }

    public static String a(long j2) {
        DecimalFormat decimalFormat = new DecimalFormat("###.0");
        long j3 = j2 / c.a.a.g.b.a;
        if (j3 >= 1) {
            return decimalFormat.format(j3) + "GB";
        }
        long j4 = j2 / 1048576;
        if (j4 >= 1) {
            return decimalFormat.format(j4) + "MB";
        }
        long j5 = j2 / 1024;
        if (j5 >= 1) {
            return decimalFormat.format(j5) + "KB";
        }
        return j2 + "B";
    }

    public static void b(Context context) {
        try {
            ((KeyguardManager) context.getSystemService("keyguard")).newKeyguardLock("unLock").disableKeyguard();
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(268435462, "bright");
            wakeLockNewWakeLock.acquire();
            wakeLockNewWakeLock.release();
        } catch (Exception unused) {
        }
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static String d() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    public static String e(String str) {
        return new SimpleDateFormat(str).format(new Date(System.currentTimeMillis()));
    }

    public static String d(Context context, String str) {
        Uri uri = Uri.parse(str);
        if (!TextUtils.isEmpty(uri.getAuthority())) {
            Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null) {
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    cursorQuery.close();
                    return string;
                }
            }
            return "";
        }
        return uri.getPath();
    }

    public static void e(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse(str));
        context.startActivity(intent);
    }

    public static Uri c(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return FileProvider.getUriForFile(context, context.getApplicationInfo().packageName + ".fileprovider", new File(str));
        }
        return Uri.parse(new File(str).toString());
    }

    public static Bitmap b(View view) {
        Bitmap bitmapCreateBitmap = null;
        if (view == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        if (view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0) {
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                System.gc();
                try {
                    bitmapCreateBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError unused2) {
                }
            }
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawBitmap(bitmapCreateBitmap, 0.0f, bitmapCreateBitmap.getHeight(), new Paint());
            view.draw(canvas);
        }
        return bitmapCreateBitmap;
    }

    public static String a(Date date) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
    }

    public static void c(Context context, int i2) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            String str = "\u60a8\u6709" + i2 + "\u6761\u672a\u8bfb\u6d88\u606f";
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(AccsClientConfig.DEFAULT_CONFIGTAG, "\u9ed8\u8ba4\u901a\u77e5", 4);
                notificationChannel.setShowBadge(true);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            Notification notificationBuild = new NotificationCompat.Builder(context, AccsClientConfig.DEFAULT_CONFIGTAG).setContentTitle("\u6d88\u606f\u63d0\u793a").setContentText(str).setWhen(System.currentTimeMillis()).setSmallIcon(R.mipmap.logo).setAutoCancel(true).setChannelId(AccsClientConfig.DEFAULT_CONFIGTAG).setNumber(i2).setBadgeIconType(1).build();
            notificationManager.cancel(1);
            Object obj = notificationBuild.getClass().getDeclaredField("extraNotification").get(notificationBuild);
            obj.getClass().getDeclaredMethod("setMessageCount", Integer.TYPE).invoke(obj, Integer.valueOf(i2));
            notificationManager.notify(1, notificationBuild);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String a(Long l2, String str) {
        return new SimpleDateFormat(str).format(new Date(l2.longValue()));
    }

    public static List<LocalMedia> a(List<LocalMedia> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            LocalMedia localMedia = list.get(i2);
            if (new File(localMedia.getPath()).length() > 209715200) {
                e2.a("200M\u4ee5\u4e0a\u6587\u4ef6\uff0c\u4e0d\u53ef\u4e0a\u4f20");
            } else {
                arrayList.add(localMedia);
            }
        }
        list.clear();
        return arrayList;
    }

    public static String g(String str) {
        try {
            return !TextUtils.isEmpty(str) ? new URL(str).getHost() : "";
        } catch (Exception e2) {
            s1.b("\u83b7\u53d6\u57df\u540d\u5931\u8d25\uff0c" + e2);
            return "";
        }
    }

    public static String a(Map map) {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(map);
            return jSONArray.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static long b(Context context, String str) {
        if (d2.q()) {
            return a(context, Uri.parse(str));
        }
        return i(str);
    }

    public static String a(Activity activity, View view) {
        String str;
        String str2 = "\u56fd\u5bb6\u53cd\u8bc8\u4e2d\u5fc3_" + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(Long.valueOf(System.currentTimeMillis())) + ".jpg";
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                if (b()) {
                    str = Hicore.getApp().getExternalFilesDir("").getAbsolutePath() + "/" + Environment.DIRECTORY_DCIM + "/Camera/";
                } else {
                    str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + Environment.DIRECTORY_DCIM + "/Camera/";
                }
            } else {
                str = activity.getApplicationContext().getFilesDir().getAbsolutePath() + "/qmfz/";
            }
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            Bitmap bitmapA = a(view);
            File file2 = new File(str + str2);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmapA.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            a(activity, file2);
            return file2.getAbsolutePath();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String b(long j2) {
        long j3 = j2 / 1000;
        long j4 = j3 % 60;
        long j5 = (j3 / 60) % 60;
        long j6 = j3 / 3600;
        return j6 > 0 ? String.format("%d:%02d:%02d", Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)) : String.format("%02d:%02d", Long.valueOf(j5), Long.valueOf(j4));
    }

    public static long b(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static void b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null) {
                    for (File file2 : fileArrListFiles) {
                        if (file2.isDirectory()) {
                            b(file2.getPath());
                        } else {
                            file2.delete();
                        }
                    }
                }
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @SuppressLint({"WrongConstant"})
    public static void b(Context context, int i2) {
        Intent intent = new Intent();
        intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        intent.addFlags(16777216);
        intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
        intent.putExtra(PushClientConstants.TAG_CLASS_NAME, "ui.activity.WelcomeActivity");
        intent.putExtra("notificationNum", i2);
        context.sendBroadcast(intent);
    }

    private static void a(Activity activity, File file) {
        MediaScannerConnection.scanFile(activity, new String[]{file.getPath()}, new String[]{a(file)}, new MediaScannerConnection.OnScanCompletedListener() { // from class: util.t0
            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public final void onScanCompleted(String str, Uri uri) {
                g2.a(str, uri);
            }
        });
    }

    public static String a(File file) {
        return URLConnection.getFileNameMap().getContentTypeFor(file.getName());
    }

    public static Bitmap a(View view) {
        if (view == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getHeight(), 1073741824));
        view.layout((int) view.getX(), (int) view.getY(), ((int) view.getX()) + view.getMeasuredWidth(), ((int) view.getY()) + view.getMeasuredHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getDrawingCache(), 0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.setDrawingCacheEnabled(false);
        view.destroyDrawingCache();
        return bitmapCreateBitmap;
    }

    public static String a(View view, String str, IOneClickListener iOneClickListener) {
        try {
            Bitmap bitmapB = b(view);
            File file = new File(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmapB.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
            }
            return file.getAbsolutePath();
        } catch (Exception e2) {
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
            }
            e2.printStackTrace();
            return null;
        } catch (Throwable th) {
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
            }
            th.printStackTrace();
            return "";
        }
    }

    public static void a(Context context, int i2, ImageView imageView) {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, i2);
        animationLoadAnimation.setInterpolator(new LinearInterpolator());
        if (animationLoadAnimation != null) {
            imageView.startAnimation(animationLoadAnimation);
        } else {
            imageView.setAnimation(animationLoadAnimation);
            imageView.startAnimation(animationLoadAnimation);
        }
    }

    private static long a(Context context, Uri uri) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(context, uri);
            return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static CharSequence a(Activity activity, String str, String str2, String str3, String str4, String str5) {
        Hicore app = Hicore.getApp();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (str + str4 + str2 + str5 + str3));
        spannableStringBuilder.setSpan(new a(activity), str.length(), str.length() + str4.length(), 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(app.getResources().getColor(R.color.blue)), str.length(), str.length() + str4.length(), 33);
        spannableStringBuilder.setSpan(new b(activity), (str + str4 + str2).length(), (str + str4 + str2 + str5).length(), 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(app.getResources().getColor(R.color.blue)), (str + str4 + str2).length(), (str + str4 + str2 + str5).length(), 33);
        return spannableStringBuilder;
    }

    public static String a(Long l2) {
        if (l2 == null) {
            return "";
        }
        Date date = new Date();
        date.setTime(l2.longValue());
        Calendar calendar = Calendar.getInstance();
        String str = f14893f.get().format(calendar.getTime());
        String str2 = f14893f.get().format(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" HH:mm:ss");
        if (str.equals(str2)) {
            return simpleDateFormat.format(date);
        }
        if (((int) ((calendar.getTimeInMillis() / 86400000) - (date.getTime() / 86400000))) == 1) {
            return "\u6628\u5929" + simpleDateFormat.format(date);
        }
        return new SimpleDateFormat("MM/dd HH:mm:ss").format(date);
    }

    public static void a(Context context, List<LocalMedia> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.get(i2).setPath(d(context, list.get(i2).getPath()));
        }
    }

    public static boolean a(Activity activity, SHARE_MEDIA share_media) {
        return UMShareAPI.get(activity).isInstall(activity, share_media);
    }

    public static ObjectAnimator a(View view, long j2, float f2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, f2);
        objectAnimatorOfFloat.setDuration(j2);
        objectAnimatorOfFloat.start();
        return objectAnimatorOfFloat;
    }

    public static <T> T a(Object obj, Class<T> cls) {
        try {
            com.google.gson.e eVarBuildGson = ResponseDataTypeAdaptor.buildGson();
            T t = (T) eVarBuildGson.a(eVarBuildGson.a(obj), (Class) cls);
            s1.a("modelA2B A=" + obj.getClass() + " B=" + cls + " \u8f6c\u6362\u540e=" + t);
            return t;
        } catch (Exception e2) {
            s1.b("modelA2B Exception=" + obj.getClass() + d.c.a.b.a.a.f10074g + cls + d.c.a.b.a.a.f10074g + e2.getMessage());
            return null;
        }
    }

    public static Map<String, Object> a(Object obj) {
        return a(true, obj);
    }

    public static Map<String, Object> a(boolean z, Object obj) {
        Map<String, Object> mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        for (Field field : obj.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object obj2 = field.get(obj);
                if (z || obj2 != null) {
                    mapSynchronizedMap.put(field.getName(), obj2);
                }
            } catch (Exception unused) {
            }
        }
        return mapSynchronizedMap;
    }

    public static Character a(char c2) {
        try {
            byte[] bytes = String.valueOf(c2).getBytes("GBK");
            if (bytes[0] >= 128 || bytes[0] <= 0) {
                return Character.valueOf(a(bytes));
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    static char a(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) (bArr[i2] - 160);
        }
        int i3 = (bArr[0] * 100) + bArr[1];
        for (int i4 = 0; i4 < 23; i4++) {
            int[] iArr = f14895h;
            if (i3 >= iArr[i4] && i3 < iArr[i4 + 1]) {
                return f14896i[i4];
            }
        }
        return '-';
    }

    public static d.b.c.r a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        d.b.c.c cVar = new d.b.c.c(new d.b.c.z.j(new d.b.c.o(width, height, iArr)));
        d.b.c.f0.a aVar = new d.b.c.f0.a();
        EnumMap enumMap = new EnumMap(d.b.c.e.class);
        enumMap.put(d.b.c.e.CHARACTER_SET, "utf-8");
        enumMap.put(d.b.c.e.TRY_HARDER, true);
        try {
            return aVar.a(cVar, enumMap);
        } catch (d.b.c.d | d.b.c.h | d.b.c.m e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bitmap a(String str, int i2, int i3) {
        return a(str, i2, i3, "UTF-8", d.b.c.f0.c.f.M, 2, ViewCompat.MEASURED_STATE_MASK, -1);
    }

    public static Bitmap a(String str, int i2, int i3, String str2, Object obj, Object obj2, int i4, int i5) {
        if (!TextUtils.isEmpty(str) && i2 >= 0 && i3 >= 0) {
            try {
                Hashtable hashtable = new Hashtable();
                if (!TextUtils.isEmpty(str2)) {
                    hashtable.put(d.b.c.g.CHARACTER_SET, str2);
                }
                hashtable.put(d.b.c.g.ERROR_CORRECTION, obj);
                hashtable.put(d.b.c.g.MARGIN, obj2);
                d.b.c.z.b bVarA = new d.b.c.f0.b().a(str, d.b.c.a.QR_CODE, i2, i3, hashtable);
                int[] iArr = new int[i2 * i3];
                for (int i6 = 0; i6 < i3; i6++) {
                    for (int i7 = 0; i7 < i2; i7++) {
                        if (bVarA.b(i7, i6)) {
                            iArr[(i6 * i2) + i7] = i4;
                        } else {
                            iArr[(i6 * i2) + i7] = i5;
                        }
                    }
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
                return bitmapCreateBitmap;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static boolean a() {
        boolean z;
        String[] strArr = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            if (new File(strArr[i2]).exists()) {
                z = true;
                break;
            }
            i2++;
        }
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || z;
    }

    public static void a(Context context, Class<?> cls) {
        a(context, cls, (Bundle) null);
    }

    public static void a(Context context, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(context, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.addFlags(d.c.a.b.a.a.B1);
        intent.addFlags(CommonNetImpl.FLAG_SHARE);
        context.startActivity(intent);
    }

    public static boolean a(String str, boolean z) {
        String strD = d("yyyy-MM-dd");
        if (!TextUtils.equals(strD, c2.a(str, ""))) {
            u1.b(str, 0);
        }
        if (z) {
            u1.b(str, u1.a(str, 0) + 1);
            c2.b(str, strD);
        }
        return u1.a(str, 0) > WelocmPresenter.mFailureNumStartValidate;
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + str));
        context.startActivity(intent);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() - B(str)) / 1000;
        if (jCurrentTimeMillis < 30) {
            return "\u521a\u521a";
        }
        if (jCurrentTimeMillis < 3600) {
            return (jCurrentTimeMillis / 60) + "\u5206\u949f\u524d";
        }
        if (jCurrentTimeMillis < 86400) {
            return (jCurrentTimeMillis / 3600) + "\u5c0f\u65f6\u524d";
        }
        return str.substring(0, 11);
    }

    public static void a(EditText editText) {
        editText.addTextChangedListener(new d(editText));
    }

    public static void a(ScrollView scrollView, Activity activity) {
        scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new e(activity, scrollView));
    }

    public static void a(NestedScrollView nestedScrollView, Activity activity) {
        nestedScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new f(activity, nestedScrollView));
    }

    public static void a(Context context, int i2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("package", context.getPackageName());
            bundle.putString("class", "ui.activity.WelcomeActivity");
            bundle.putInt("badgenumber", i2);
            context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) && list != null) {
            if (str.startsWith("+86")) {
                str = str.substring(3);
            } else if (str.startsWith("86")) {
                str = str.substring(2);
            } else if (str.startsWith("0086")) {
                str = str.substring(4);
            }
            if (str.length() == 11) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (str.startsWith(it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean a(Context context) {
        Iterator<ApplicationInfo> it = context.getPackageManager().getInstalledApplications(0).iterator();
        while (it.hasNext()) {
            if ("com.tencent.mm".equals(it.next().packageName)) {
                return true;
            }
        }
        return false;
    }
}
