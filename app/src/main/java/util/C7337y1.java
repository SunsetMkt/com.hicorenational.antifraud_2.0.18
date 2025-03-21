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
import com.google.gson.C2051e;
import com.hicorenational.antifraud.C2113R;
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
import p023b.p024a.p025a.p029g.C0929b;
import p031c.p035b.p043c.C0981c;
import p031c.p035b.p043c.C0988d;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1104o;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.EnumC1096g;
import p031c.p035b.p043c.p062f0.C1072a;
import p031c.p035b.p043c.p062f0.C1073b;
import p031c.p035b.p043c.p062f0.p063c.EnumC1079f;
import p031c.p035b.p043c.p072z.C1163b;
import p031c.p035b.p043c.p072z.C1171j;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.Hicore;
import p388ui.activity.WebActivity;
import p388ui.presenter.WelocmPresenter;

/* compiled from: Utils.java */
/* renamed from: util.y1 */
/* loaded from: classes2.dex */
public class C7337y1 {

    /* renamed from: c */
    private static final String f25732c = "(^1(33|53|77|73|99|8[019])\\d{8}$)|(^1700\\d{7}$)";

    /* renamed from: d */
    private static final String f25733d = "(^1(3[0-2]|4[5]|5[56]|6[6]|7[56]|8[56])\\d{8}$)|(^1709\\d{7}$)";

    /* renamed from: e */
    private static final String f25734e = "(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)";

    /* renamed from: g */
    static final int f25736g = 160;

    /* renamed from: a */
    private static ThreadLocal<SimpleDateFormat> f25730a = new ThreadLocal<>();

    /* renamed from: b */
    public static Handler f25731b = IHandler.mHandler;

    /* renamed from: f */
    @SuppressLint({"SimpleDateFormat"})
    private static final ThreadLocal<SimpleDateFormat> f25735f = new c();

    /* renamed from: h */
    static final int[] f25737h = {1601, 1637, 1833, 2078, 2274, 2302, 2433, 2594, 2787, 3106, 3212, 3472, 3635, 3722, 3730, 3858, 4027, 4086, 4390, 4558, 4684, 4925, 5249, 5600};

    /* renamed from: i */
    static final char[] f25738i = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'w', 'x', 'y', 'z'};

    /* compiled from: Utils.java */
    /* renamed from: util.y1$a */
    static class a extends ClickableSpan {

        /* renamed from: a */
        final /* synthetic */ Activity f25739a;

        a(Activity activity) {
            this.f25739a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str;
            if (view instanceof TextView) {
                ((TextView) view).setHighlightColor(0);
            }
            if (TextUtils.isEmpty(WelocmPresenter.XY_service)) {
                str = C4440a.f16884f + C4445b.f17138x;
            } else {
                str = WelocmPresenter.XY_service;
            }
            String str2 = str + "?time=" + C4440a.m16411m();
            Activity activity = this.f25739a;
            activity.startActivity(new Intent(activity, (Class<?>) WebActivity.class).putExtra(C7292k1.f25363P, "服务协议").putExtra(C7292k1.f25365Q, str2));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: util.y1$b */
    static class b extends ClickableSpan {

        /* renamed from: a */
        final /* synthetic */ Activity f25740a;

        b(Activity activity) {
            this.f25740a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str;
            if (view instanceof TextView) {
                ((TextView) view).setHighlightColor(0);
            }
            if (TextUtils.isEmpty(WelocmPresenter.XY_conceal)) {
                str = C4440a.f16884f + C4445b.f17135w;
            } else {
                str = WelocmPresenter.XY_conceal;
            }
            String str2 = str + "?time=" + C4440a.m16411m();
            Activity activity = this.f25740a;
            activity.startActivity(new Intent(activity, (Class<?>) WebActivity.class).putExtra(C7292k1.f25363P, "隐私政策").putExtra(C7292k1.f25365Q, str2));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: util.y1$c */
    static class c extends ThreadLocal<SimpleDateFormat> {
        c() {
        }

        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: util.y1$d */
    static class d implements TextWatcher {

        /* renamed from: a */
        boolean f25741a;

        /* renamed from: b */
        final /* synthetic */ EditText f25742b;

        d(EditText editText) {
            this.f25742b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (this.f25741a) {
                this.f25742b.setText(editable.toString().substring(0, editable.toString().length() - 1));
                EditText editText = this.f25742b;
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
                    this.f25741a = true;
                } else {
                    this.f25741a = false;
                }
            }
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: util.y1$e */
    static class e implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        final /* synthetic */ Activity f25743a;

        /* renamed from: b */
        final /* synthetic */ ScrollView f25744b;

        e(Activity activity, ScrollView scrollView) {
            this.f25743a = activity;
            this.f25744b = scrollView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int height = this.f25743a.getWindow().getDecorView().getRootView().getHeight();
            Rect rect = new Rect();
            this.f25743a.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int max = Math.max(height, rect.bottom);
            int i2 = max - rect.bottom;
            if (i2 <= max / 4) {
                this.f25744b.setPadding(0, 0, 0, 0);
            } else {
                this.f25744b.setPadding(0, 0, 0, i2);
                this.f25744b.scrollTo(0, i2);
            }
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: util.y1$f */
    static class f implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        boolean f25745a = false;

        /* renamed from: b */
        final /* synthetic */ Activity f25746b;

        /* renamed from: c */
        final /* synthetic */ NestedScrollView f25747c;

        f(Activity activity, NestedScrollView nestedScrollView) {
            this.f25746b = activity;
            this.f25747c = nestedScrollView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            View currentFocus = this.f25746b.getCurrentFocus();
            int height = this.f25746b.getWindow().getDecorView().getRootView().getHeight();
            Rect rect = new Rect();
            this.f25746b.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int max = Math.max(height, rect.bottom);
            int i2 = max - rect.bottom;
            if (i2 <= max / 4) {
                this.f25747c.setPadding(0, 0, 0, 0);
                this.f25745a = false;
                return;
            }
            if (currentFocus == null || !(currentFocus instanceof EditText)) {
                return;
            }
            int[] iArr = new int[2];
            currentFocus.getLocationInWindow(iArr);
            int m26285a = ((max - iArr[1]) - C7264c1.m26285a(this.f25746b, 50.0f)) - this.f25747c.getScrollY();
            if (m26285a >= i2 || this.f25745a) {
                return;
            }
            this.f25747c.setPadding(0, 0, 0, i2);
            this.f25747c.scrollTo(0, i2 - m26285a);
            this.f25745a = true;
        }
    }

    /* renamed from: A */
    public static String m26719A(String str) {
        return str.replace(AbstractC1191a.f2568g, "");
    }

    /* renamed from: B */
    public static long m26720B(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    /* renamed from: a */
    public static String m26731a(int i2) {
        if (i2 == 64) {
            return "贷款中介";
        }
        switch (i2) {
            case 50:
                return "骚扰电话";
            case 51:
                return "房产中介";
            case 52:
                return "保险理财";
            case 53:
                return "广告推销";
            case 54:
                return "诈骗电话";
            case 55:
                return "快递送餐";
            case 56:
                return "出租车专车";
            case 57:
                return "招聘猎头";
            case 58:
                return "教育培训";
            case 59:
                return "家政物业";
            case 60:
                return "搬运送货";
            case 61:
                return "维修装修";
            default:
                return "";
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m26755a(String str, Uri uri) {
    }

    /* renamed from: a */
    public static boolean m26758a(String str, String str2) {
        return Pattern.compile(str2).matcher(str).matches();
    }

    /* renamed from: b */
    public static String m26765b(Long l2) {
        return m26739a(new Date(l2.longValue()));
    }

    /* renamed from: c */
    public static String m26770c() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    /* renamed from: d */
    public static String m26775d(String str) {
        m26777e().applyPattern(str);
        return m26777e().format(new Date(System.currentTimeMillis()));
    }

    /* renamed from: e */
    public static SimpleDateFormat m26777e() {
        SimpleDateFormat simpleDateFormat = f25730a.get();
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat();
        f25730a.set(simpleDateFormat2);
        return simpleDateFormat2;
    }

    /* renamed from: f */
    public static String m26779f(String str) {
        return str.substring(str.lastIndexOf("."));
    }

    /* renamed from: g */
    public static void m26782g() {
        File file;
        File[] listFiles;
        String m26357b = C7277f1.m26357b();
        String str = Build.BRAND;
        if (str.equalsIgnoreCase("xiaomi")) {
            file = new File(m26357b, "MIUI/sound_recorder/call_rec");
        } else if (str.equalsIgnoreCase("oppo")) {
            file = new File(m26357b, "Recordings/Call Recordings");
            if (!file.exists()) {
                file = new File(m26357b, "Recordings");
            }
        } else {
            file = (str.equalsIgnoreCase("huawei") || str.equalsIgnoreCase(SystemUtils.PRODUCT_HONOR)) ? new File(m26357b, "Sounds/CallRecord") : str.equalsIgnoreCase("vivo") ? new File(m26357b, "录音/通话录音") : str.equalsIgnoreCase("sansung") ? new File(m26357b, "Sounds") : str.equalsIgnoreCase("Letv") ? new File(m26357b, "Recorder/remote") : null;
        }
        if (file == null || (listFiles = file.listFiles()) == null) {
            return;
        }
        Hicore.getApp().getSharedPreferences("record_preferences", 0).edit().putInt("file_nums", listFiles.length).commit();
    }

    /* renamed from: h */
    public static String m26783h(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 2) {
            return str;
        }
        String str2 = "";
        for (int i2 = 0; i2 < str.length() - 2; i2++) {
            str2 = str2 + "*";
        }
        return str.substring(0, 1) + str2 + str.substring(str.length() - 1);
    }

    /* renamed from: i */
    public static long m26784i(String str) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    /* renamed from: j */
    public static String m26785j(String str) {
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

    /* renamed from: k */
    public static String m26786k(String str) {
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

    /* renamed from: l */
    public static String m26787l(String str) {
        try {
            return str.substring(0, 3) + "******" + str.substring(str.length() - 2);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: m */
    public static String m26788m(String str) {
        if (TextUtils.isEmpty(str) ? false : Pattern.matches(f25734e, str)) {
            return "中国移动";
        }
        if (TextUtils.isEmpty(str) ? false : Pattern.matches(f25733d, str)) {
            return "中国联通";
        }
        return TextUtils.isEmpty(str) ? false : Pattern.matches(f25732c, str) ? "中国电信" : "未知";
    }

    /* renamed from: n */
    public static String m26789n(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ((charAt >> 7) != 0) {
                stringBuffer.append(String.valueOf(m26729a(charAt).charValue()));
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: o */
    public static String m26790o(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 2) {
            return str;
        }
        String str2 = "";
        for (int i2 = 0; i2 < str.length() - 2; i2++) {
            str2 = str2 + "*";
        }
        return str.substring(0, 1) + str2 + str.substring(str.length() - 1);
    }

    /* renamed from: p */
    public static boolean m26791p(String str) {
        return str == null || str.length() == 0 || TextUtils.equals(AbstractC1191a.f2571h, str);
    }

    /* renamed from: q */
    public static boolean m26792q(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    /* renamed from: r */
    public static boolean m26793r(String str) {
        return Pattern.compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$").matcher(str).matches();
    }

    /* renamed from: s */
    public static void m26794s(String str) {
        ((ClipboardManager) Hicore.getApp().getSystemService("clipboard")).setText(str);
        C7331w1.m26688a("复制成功");
    }

    /* renamed from: t */
    public static String m26795t(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    /* renamed from: u */
    public static boolean m26796u(String str) {
        return str.matches("^[\\u4e00-\\u9fa5\\u36c3\\u4DAE]{2,}$");
    }

    /* renamed from: v */
    public static boolean m26797v(String str) {
        return Pattern.compile("^([a-z0-9A-Z]+[^\\s]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$").matcher(str).matches();
    }

    /* renamed from: w */
    public static boolean m26798w(String str) {
        return Pattern.compile("^.*[a-zA-Z]+.*$").matcher(str).matches();
    }

    /* renamed from: x */
    public static boolean m26799x(String str) {
        return str.matches("^[\\u4e00-\\u9fa5.·•\\u36c3\\u4DAE]{2,}$");
    }

    /* renamed from: y */
    public static boolean m26800y(String str) {
        return Pattern.compile("^.*[0-9]+.*$").matcher(str).matches();
    }

    /* renamed from: z */
    public static boolean m26801z(String str) {
        return Pattern.compile("^[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]$").matcher(str).matches();
    }

    /* renamed from: f */
    public static boolean m26780f() {
        return m26756a();
    }

    /* renamed from: a */
    public static String m26732a(long j2) {
        DecimalFormat decimalFormat = new DecimalFormat("###.0");
        long j3 = j2 / C0929b.f1558a;
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

    /* renamed from: b */
    public static Bitmap m26763b(View view) {
        Bitmap bitmap = null;
        if (view == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        if (view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0) {
            try {
                bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                System.gc();
                try {
                    bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError unused2) {
                }
            }
            Canvas canvas = new Canvas(bitmap);
            canvas.drawBitmap(bitmap, 0.0f, bitmap.getHeight(), new Paint());
            view.draw(canvas);
        }
        return bitmap;
    }

    /* renamed from: c */
    public static void m26772c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    /* renamed from: d */
    public static String m26773d() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    /* renamed from: e */
    public static String m26776e(String str) {
        return new SimpleDateFormat(str).format(new Date(System.currentTimeMillis()));
    }

    /* renamed from: d */
    public static String m26774d(Context context, String str) {
        Uri parse = Uri.parse(str);
        if (!TextUtils.isEmpty(parse.getAuthority())) {
            Cursor query = context.getContentResolver().query(parse, null, null, null, null);
            if (query != null) {
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                if (query.moveToFirst()) {
                    String string = query.getString(columnIndexOrThrow);
                    query.close();
                    return string;
                }
            }
            return "";
        }
        return parse.getPath();
    }

    /* renamed from: e */
    public static void m26778e(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse(str));
        context.startActivity(intent);
    }

    /* renamed from: c */
    public static Uri m26769c(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return FileProvider.getUriForFile(context, context.getApplicationInfo().packageName + ".fileprovider", new File(str));
        }
        return Uri.parse(new File(str).toString());
    }

    /* renamed from: a */
    public static String m26739a(Date date) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
    }

    /* renamed from: c */
    public static void m26771c(Context context, int i2) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            String str = "您有" + i2 + "条未读消息";
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(AccsClientConfig.DEFAULT_CONFIGTAG, "默认通知", 4);
                notificationChannel.setShowBadge(true);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            Notification build = new NotificationCompat.Builder(context, AccsClientConfig.DEFAULT_CONFIGTAG).setContentTitle("消息提示").setContentText(str).setWhen(System.currentTimeMillis()).setSmallIcon(C2113R.mipmap.logo).setAutoCancel(true).setChannelId(AccsClientConfig.DEFAULT_CONFIGTAG).setNumber(i2).setBadgeIconType(1).build();
            notificationManager.cancel(1);
            Object obj = build.getClass().getDeclaredField("extraNotification").get(build);
            obj.getClass().getDeclaredMethod("setMessageCount", Integer.TYPE).invoke(obj, Integer.valueOf(i2));
            notificationManager.notify(1, build);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public static String m26737a(Long l2, String str) {
        return new SimpleDateFormat(str).format(new Date(l2.longValue()));
    }

    /* renamed from: a */
    public static List<LocalMedia> m26741a(List<LocalMedia> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            LocalMedia localMedia = list.get(i2);
            if (new File(localMedia.getPath()).length() > 209715200) {
                C7331w1.m26688a("200M以上文件，不可上传");
            } else {
                arrayList.add(localMedia);
            }
        }
        list.clear();
        return arrayList;
    }

    /* renamed from: b */
    public static long m26761b(Context context, String str) {
        if (C7328v1.m26680q()) {
            return m26722a(context, Uri.parse(str));
        }
        return m26784i(str);
    }

    /* renamed from: b */
    public static String m26764b(long j2) {
        long j3 = j2 / 1000;
        long j4 = j3 % 60;
        long j5 = (j3 / 60) % 60;
        long j6 = j3 / 3600;
        return j6 > 0 ? String.format("%d:%02d:%02d", Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)) : String.format("%02d:%02d", Long.valueOf(j5), Long.valueOf(j4));
    }

    /* renamed from: g */
    public static String m26781g(String str) {
        try {
            return !TextUtils.isEmpty(str) ? new URL(str).getHost() : "";
        } catch (Exception e2) {
            C7301n1.m26456b("获取域名失败，" + e2);
            return "";
        }
    }

    /* renamed from: a */
    public static String m26740a(Map map) {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(map);
            return jSONArray.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static long m26762b(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    /* renamed from: a */
    public static void m26745a(Context context) {
        try {
            ((KeyguardManager) context.getSystemService("keyguard")).newKeyguardLock("unLock").disableKeyguard();
            PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(268435462, "bright");
            newWakeLock.acquire();
            newWakeLock.release();
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static void m26767b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            m26767b(file2.getPath());
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

    /* renamed from: a */
    public static String m26733a(Activity activity, View view) {
        String str;
        String str2 = "国家反诈中心_" + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(Long.valueOf(System.currentTimeMillis())) + ".jpg";
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                if (m26768b()) {
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
            Bitmap m26724a = m26724a(view);
            File file2 = new File(str + str2);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            m26724a.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            m26744a(activity, file2);
            return file2.getAbsolutePath();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m26768b() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: b */
    public static void m26766b(Context context, int i2) {
        Intent intent = new Intent();
        intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        intent.addFlags(16777216);
        intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
        intent.putExtra(PushClientConstants.TAG_CLASS_NAME, "ui.activity.WelcomeActivity");
        intent.putExtra("notificationNum", i2);
        context.sendBroadcast(intent);
    }

    /* renamed from: a */
    private static void m26744a(Activity activity, File file) {
        MediaScannerConnection.scanFile(activity, new String[]{file.getPath()}, new String[]{m26735a(file)}, new MediaScannerConnection.OnScanCompletedListener() { // from class: util.t0
            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public final void onScanCompleted(String str, Uri uri) {
                C7337y1.m26755a(str, uri);
            }
        });
    }

    /* renamed from: a */
    public static String m26735a(File file) {
        return URLConnection.getFileNameMap().getContentTypeFor(file.getName());
    }

    /* renamed from: a */
    public static Bitmap m26724a(View view) {
        if (view == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getHeight(), 1073741824));
        view.layout((int) view.getX(), (int) view.getY(), ((int) view.getX()) + view.getMeasuredWidth(), ((int) view.getY()) + view.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache(), 0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.setDrawingCacheEnabled(false);
        view.destroyDrawingCache();
        return createBitmap;
    }

    /* renamed from: a */
    public static String m26734a(View view, String str, IOneClickListener iOneClickListener) {
        try {
            Bitmap m26763b = m26763b(view);
            File file = new File(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            m26763b.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
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

    /* renamed from: a */
    public static void m26747a(Context context, int i2, ImageView imageView) {
        Animation loadAnimation = AnimationUtils.loadAnimation(context, i2);
        loadAnimation.setInterpolator(new LinearInterpolator());
        if (loadAnimation != null) {
            imageView.startAnimation(loadAnimation);
        } else {
            imageView.setAnimation(loadAnimation);
            imageView.startAnimation(loadAnimation);
        }
    }

    /* renamed from: a */
    private static long m26722a(Context context, Uri uri) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(context, uri);
            return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    /* renamed from: a */
    public static CharSequence m26728a(Activity activity, String str, String str2, String str3, String str4, String str5) {
        Hicore app = Hicore.getApp();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (str + str4 + str2 + str5 + str3));
        spannableStringBuilder.setSpan(new a(activity), str.length(), str.length() + str4.length(), 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(app.getResources().getColor(C2113R.color.blue)), str.length(), str.length() + str4.length(), 33);
        spannableStringBuilder.setSpan(new b(activity), (str + str4 + str2).length(), (str + str4 + str2 + str5).length(), 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(app.getResources().getColor(C2113R.color.blue)), (str + str4 + str2).length(), (str + str4 + str2 + str5).length(), 33);
        return spannableStringBuilder;
    }

    /* renamed from: a */
    public static String m26736a(Long l2) {
        if (l2 == null) {
            return "";
        }
        Date date = new Date();
        date.setTime(l2.longValue());
        Calendar calendar = Calendar.getInstance();
        String format = f25735f.get().format(calendar.getTime());
        String format2 = f25735f.get().format(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" HH:mm:ss");
        if (format.equals(format2)) {
            return simpleDateFormat.format(date);
        }
        if (((int) ((calendar.getTimeInMillis() / 86400000) - (date.getTime() / 86400000))) == 1) {
            return "昨天" + simpleDateFormat.format(date);
        }
        return new SimpleDateFormat("MM/dd HH:mm:ss").format(date);
    }

    /* renamed from: a */
    public static void m26751a(Context context, List<LocalMedia> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.get(i2).setPath(m26774d(context, list.get(i2).getPath()));
        }
    }

    /* renamed from: a */
    public static boolean m26757a(Activity activity, SHARE_MEDIA share_media) {
        return UMShareAPI.get(activity).isInstall(activity, share_media);
    }

    /* renamed from: a */
    public static ObjectAnimator m26723a(View view, long j2, float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, f2);
        ofFloat.setDuration(j2);
        ofFloat.start();
        return ofFloat;
    }

    /* renamed from: a */
    public static <T> T m26730a(Object obj, Class<T> cls) {
        try {
            C2051e buildGson = ResponseDataTypeAdaptor.buildGson();
            T t = (T) buildGson.m5569a(buildGson.m5572a(obj), (Class) cls);
            C7301n1.m26453a("modelA2B A=" + obj.getClass() + " B=" + cls + " 转换后=" + t);
            return t;
        } catch (Exception e2) {
            C7301n1.m26456b("modelA2B Exception=" + obj.getClass() + AbstractC1191a.f2568g + cls + AbstractC1191a.f2568g + e2.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Map<String, Object> m26742a(Object obj) {
        return m26743a(true, obj);
    }

    /* renamed from: a */
    public static Map<String, Object> m26743a(boolean z, Object obj) {
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(new HashMap());
        for (Field field : obj.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object obj2 = field.get(obj);
                if (z || obj2 != null) {
                    synchronizedMap.put(field.getName(), obj2);
                }
            } catch (Exception unused) {
            }
        }
        return synchronizedMap;
    }

    /* renamed from: a */
    public static Character m26729a(char c2) {
        try {
            byte[] bytes = String.valueOf(c2).getBytes("GBK");
            if (bytes[0] >= 128 || bytes[0] <= 0) {
                return Character.valueOf(m26721a(bytes));
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    static char m26721a(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) (bArr[i2] - 160);
        }
        int i3 = (bArr[0] * 100) + bArr[1];
        for (int i4 = 0; i4 < 23; i4++) {
            int[] iArr = f25737h;
            if (i3 >= iArr[i4] && i3 < iArr[i4 + 1]) {
                return f25738i[i4];
            }
        }
        return '-';
    }

    /* renamed from: a */
    public static C1107r m26727a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        C0981c c0981c = new C0981c(new C1171j(new C1104o(width, height, iArr)));
        C1072a c1072a = new C1072a();
        EnumMap enumMap = new EnumMap(EnumC1044e.class);
        enumMap.put((EnumMap) EnumC1044e.CHARACTER_SET, (EnumC1044e) "utf-8");
        enumMap.put((EnumMap) EnumC1044e.TRY_HARDER, (EnumC1044e) true);
        try {
            return c1072a.mo1186a(c0981c, enumMap);
        } catch (C0988d | C1097h | C1102m e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m26725a(String str, int i2, int i3) {
        return m26726a(str, i2, i3, "UTF-8", EnumC1079f.M, 2, ViewCompat.MEASURED_STATE_MASK, -1);
    }

    /* renamed from: a */
    public static Bitmap m26726a(String str, int i2, int i3, String str2, Object obj, Object obj2, int i4, int i5) {
        if (!TextUtils.isEmpty(str) && i2 >= 0 && i3 >= 0) {
            try {
                Hashtable hashtable = new Hashtable();
                if (!TextUtils.isEmpty(str2)) {
                    hashtable.put(EnumC1096g.CHARACTER_SET, str2);
                }
                hashtable.put(EnumC1096g.ERROR_CORRECTION, obj);
                hashtable.put(EnumC1096g.MARGIN, obj2);
                C1163b mo1190a = new C1073b().mo1190a(str, EnumC0953a.QR_CODE, i2, i3, hashtable);
                int[] iArr = new int[i2 * i3];
                for (int i6 = 0; i6 < i3; i6++) {
                    for (int i7 = 0; i7 < i2; i7++) {
                        if (mo1190a.m2173b(i7, i6)) {
                            iArr[(i6 * i2) + i7] = i4;
                        } else {
                            iArr[(i6 * i2) + i7] = i5;
                        }
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
                return createBitmap;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m26756a() {
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

    /* renamed from: a */
    public static void m26748a(Context context, Class<?> cls) {
        m26749a(context, cls, (Bundle) null);
    }

    /* renamed from: a */
    public static void m26749a(Context context, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(context, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.addFlags(AbstractC1191a.f2487B1);
        intent.addFlags(CommonNetImpl.FLAG_SHARE);
        context.startActivity(intent);
    }

    /* renamed from: a */
    public static boolean m26760a(String str, boolean z) {
        String m26775d = m26775d("yyyy-MM-dd");
        if (!TextUtils.equals(m26775d, C7325u1.m26616a(str, ""))) {
            C7307p1.m26486b(str, 0);
        }
        if (z) {
            C7307p1.m26486b(str, C7307p1.m26473a(str, 0) + 1);
            C7325u1.m26630b(str, m26775d);
        }
        return C7307p1.m26473a(str, 0) > WelocmPresenter.mFailureNumStartValidate;
    }

    /* renamed from: a */
    public static void m26750a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + str));
        context.startActivity(intent);
    }

    /* renamed from: a */
    public static String m26738a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        long currentTimeMillis = (System.currentTimeMillis() - m26720B(str)) / 1000;
        if (currentTimeMillis < 30) {
            return "刚刚";
        }
        if (currentTimeMillis < 3600) {
            return (currentTimeMillis / 60) + "分钟前";
        }
        if (currentTimeMillis < 86400) {
            return (currentTimeMillis / 3600) + "小时前";
        }
        return str.substring(0, 11);
    }

    /* renamed from: a */
    public static void m26752a(EditText editText) {
        editText.addTextChangedListener(new d(editText));
    }

    /* renamed from: a */
    public static void m26753a(ScrollView scrollView, Activity activity) {
        scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new e(activity, scrollView));
    }

    /* renamed from: a */
    public static void m26754a(NestedScrollView nestedScrollView, Activity activity) {
        nestedScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new f(activity, nestedScrollView));
    }

    /* renamed from: a */
    public static void m26746a(Context context, int i2) {
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

    /* renamed from: a */
    public static boolean m26759a(String str, List<String> list) {
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
}
