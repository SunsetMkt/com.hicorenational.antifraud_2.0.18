package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import cn.cloudwalk.libproject.Contants;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.e;
import com.tencent.open.b.h;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class ImageActivity extends Activity {
    RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private QQToken f6675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f6677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f6678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Button f6679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Button f6680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b f6681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f6682i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ProgressBar f6683j;
    private String r;
    private Bitmap s;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f6684k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f6685l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f6686m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f6687n = 0;
    private final int o = Contants.PREVIEW_W;
    private final int p = Contants.PREVIEW_W;
    private Rect q = new Rect();
    private final View.OnClickListener t = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.f6683j.setVisibility(0);
            ImageActivity.this.f6680g.setEnabled(false);
            ImageActivity.this.f6680g.setTextColor(Color.rgb(21, 21, 21));
            ImageActivity.this.f6679f.setEnabled(false);
            ImageActivity.this.f6679f.setTextColor(Color.rgb(36, 94, 134));
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageActivity.this.c();
                }
            }).start();
            if (ImageActivity.this.f6685l) {
                ImageActivity.this.a("10657", 0L);
                return;
            }
            ImageActivity.this.a("10655", System.currentTimeMillis() - ImageActivity.this.f6686m);
            if (ImageActivity.this.f6678e.f6692b) {
                ImageActivity.this.a("10654", 0L);
            }
        }
    };
    private final View.OnClickListener u = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.a("10656", System.currentTimeMillis() - ImageActivity.this.f6686m);
            ImageActivity.this.setResult(0);
            ImageActivity.this.d();
        }
    };
    private final IUiListener v = new DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.5
        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            ImageActivity.this.f6680g.setEnabled(true);
            int i2 = -1;
            ImageActivity.this.f6680g.setTextColor(-1);
            ImageActivity.this.f6679f.setEnabled(true);
            ImageActivity.this.f6679f.setTextColor(-1);
            ImageActivity.this.f6683j.setVisibility(8);
            JSONObject jSONObject = (JSONObject) obj;
            try {
                i2 = jSONObject.getInt("ret");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (i2 != 0) {
                ImageActivity.this.a("\u8bbe\u7f6e\u51fa\u9519\u4e86\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55\u518d\u5c1d\u8bd5\u4e0b\u5462\uff1a\uff09", 1);
                e.a().a(ImageActivity.this.f6675b.getOpenId(), ImageActivity.this.f6675b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, "12", Constants.VIA_ACT_TYPE_NINETEEN, "1");
                return;
            }
            ImageActivity.this.a("\u8bbe\u7f6e\u6210\u529f", 0);
            ImageActivity.this.a("10658", 0L);
            e.a().a(ImageActivity.this.f6675b.getOpenId(), ImageActivity.this.f6675b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, "12", "3", "0");
            ImageActivity imageActivity = ImageActivity.this;
            if (imageActivity.f6676c != null && !"".equals(ImageActivity.this.f6676c)) {
                Intent intent = new Intent();
                intent.setClassName(imageActivity, ImageActivity.this.f6676c);
                if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null) {
                    imageActivity.startActivity(intent);
                }
            }
            ImageActivity.this.a(0, jSONObject.toString(), null, null);
            ImageActivity.this.d();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            ImageActivity.this.f6680g.setEnabled(true);
            ImageActivity.this.f6680g.setTextColor(-1);
            ImageActivity.this.f6679f.setEnabled(true);
            ImageActivity.this.f6679f.setTextColor(-1);
            ImageActivity.this.f6679f.setText("\u91cd\u8bd5");
            ImageActivity.this.f6683j.setVisibility(8);
            ImageActivity.this.f6685l = true;
            ImageActivity.this.a(uiError.errorMessage, 1);
            ImageActivity.this.a("10660", 0L);
        }
    };
    private final IUiListener w = new DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.6
        private void a(int i2) {
            if (ImageActivity.this.f6684k < 2) {
                ImageActivity.this.e();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            int i2 = -1;
            try {
                i2 = jSONObject.getInt("ret");
                if (i2 == 0) {
                    final String string = jSONObject.getString("nickname");
                    ImageActivity.this.f6677d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageActivity.this.c(string);
                        }
                    });
                    ImageActivity.this.a("10659", 0L);
                } else {
                    ImageActivity.this.a("10661", 0L);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (i2 != 0) {
                a(i2);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            a(0);
        }
    };

    /* JADX INFO: compiled from: ProGuard */
    private class QQAvatarImp extends BaseApi {
        public QQAvatarImp(QQToken qQToken) {
            super(qQToken);
        }

        public void setAvator(Bitmap bitmap, IUiListener iUiListener) {
            Bundle bundleA = a();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmap.recycle();
            BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(iUiListener);
            bundleA.putByteArray("picture", byteArray);
            HttpUtils.requestAsync(this.f6711c, g.a(), "user/set_user_face", bundleA, "POST", tempRequestListener);
            e.a().a(this.f6711c.getOpenId(), this.f6711c.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, "12", Constants.VIA_ACT_TYPE_NINETEEN, "0");
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    class a extends View {
        public a(Context context) {
            super(context);
        }

        public void a(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawableB = ImageActivity.this.b("com.tencent.plus.blue_normal.png");
            Drawable drawableB2 = ImageActivity.this.b("com.tencent.plus.blue_down.png");
            Drawable drawableB3 = ImageActivity.this.b("com.tencent.plus.blue_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, drawableB2);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, drawableB);
            stateListDrawable.addState(View.ENABLED_STATE_SET, drawableB);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, drawableB);
            stateListDrawable.addState(View.EMPTY_STATE_SET, drawableB3);
            button.setBackgroundDrawable(stateListDrawable);
        }

        public void b(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawableB = ImageActivity.this.b("com.tencent.plus.gray_normal.png");
            Drawable drawableB2 = ImageActivity.this.b("com.tencent.plus.gray_down.png");
            Drawable drawableB3 = ImageActivity.this.b("com.tencent.plus.gray_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, drawableB2);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, drawableB);
            stateListDrawable.addState(View.ENABLED_STATE_SET, drawableB);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, drawableB);
            stateListDrawable.addState(View.EMPTY_STATE_SET, drawableB3);
            button.setBackgroundDrawable(stateListDrawable);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        d();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(a());
        this.f6677d = new Handler();
        Bundle bundleExtra = getIntent().getBundleExtra(Constants.KEY_PARAMS);
        this.r = bundleExtra.getString("picture");
        this.f6676c = bundleExtra.getString("return_activity");
        String string = bundleExtra.getString("appid");
        String string2 = bundleExtra.getString("access_token");
        long j2 = bundleExtra.getLong("expires_in");
        String string3 = bundleExtra.getString("openid");
        this.f6687n = bundleExtra.getInt("exitAnim");
        this.f6675b = new QQToken(string);
        this.f6675b.setAccessToken(string2, ((j2 - System.currentTimeMillis()) / 1000) + "");
        this.f6675b.setOpenId(string3);
        b();
        e();
        this.f6686m = System.currentTimeMillis();
        a("10653", 0L);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f6678e.setImageBitmap(null);
        Bitmap bitmap = this.s;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.s.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        float fWidth = this.q.width();
        Matrix imageMatrix = this.f6678e.getImageMatrix();
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        float f2 = fArr[2];
        float f3 = fArr[5];
        float f4 = fArr[0];
        float f5 = 640.0f / fWidth;
        int i2 = (int) ((this.q.left - f2) / f4);
        int i3 = i2 < 0 ? 0 : i2;
        int i4 = (int) ((this.q.top - f3) / f4);
        int i5 = i4 < 0 ? 0 : i4;
        Matrix matrix = new Matrix();
        matrix.set(imageMatrix);
        matrix.postScale(f5, f5);
        int i6 = (int) (650.0f / f4);
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.s, i3, i5, Math.min(this.s.getWidth() - i3, i6), Math.min(this.s.getHeight() - i5, i6), matrix, true);
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, Contants.PREVIEW_W, Contants.PREVIEW_W);
            bitmapCreateBitmap.recycle();
            a(bitmapCreateBitmap2);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            a(Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, Constants.MSG_IMAGE_ERROR, e2.getMessage());
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        finish();
        int i2 = this.f6687n;
        if (i2 != 0) {
            overridePendingTransition(0, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f6684k++;
        new UserInfo(this, this.f6675b).getUserInfo(this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable b(String str) {
        return m.a(str, this);
    }

    private void b() {
        try {
            this.s = a(this.r);
        } catch (IOException e2) {
            e2.printStackTrace();
            a(Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, Constants.MSG_IMAGE_ERROR, e2.getMessage());
            d();
        }
        if (this.s != null) {
            this.f6678e.setImageBitmap(this.s);
            this.f6679f.setOnClickListener(this.t);
            this.f6680g.setOnClickListener(this.u);
            this.a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.connect.avatar.ImageActivity.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ImageActivity.this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ImageActivity imageActivity = ImageActivity.this;
                    imageActivity.q = imageActivity.f6681h.a();
                    ImageActivity.this.f6678e.a(ImageActivity.this.q);
                }
            });
            return;
        }
        throw new IOException("cannot read picture: '" + this.r + "'!");
    }

    private String d(String str) {
        return str.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", "&");
    }

    private Bitmap a(String str) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        Uri uri = Uri.parse(str);
        InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
        if (inputStreamOpenInputStream == null) {
            return null;
        }
        try {
            BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        inputStreamOpenInputStream.close();
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        while (i3 * i4 > 4194304) {
            i3 /= 2;
            i4 /= 2;
            i2 *= 2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i2;
        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, options);
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i2) {
        Toast toastMakeText = Toast.makeText(this, str, 1);
        LinearLayout linearLayout = (LinearLayout) toastMakeText.getView();
        ((TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 16.0f), com.tencent.connect.avatar.a.a(this, 16.0f)));
        if (i2 == 0) {
            imageView.setImageDrawable(b("com.tencent.plus.ic_success.png"));
        } else {
            imageView.setImageDrawable(b("com.tencent.plus.ic_error.png"));
        }
        linearLayout.addView(imageView, 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        toastMakeText.setView(linearLayout);
        toastMakeText.setGravity(17, 0, 0);
        toastMakeText.show();
    }

    private View a() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
        this.a = new RelativeLayout(this);
        this.a.setLayoutParams(layoutParams);
        this.a.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(layoutParams3);
        this.a.addView(relativeLayout);
        this.f6678e = new c(this);
        this.f6678e.setLayoutParams(layoutParams2);
        this.f6678e.setScaleType(ImageView.ScaleType.MATRIX);
        relativeLayout.addView(this.f6678e);
        this.f6681h = new b(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(layoutParams2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(15, -1);
        this.f6681h.setLayoutParams(layoutParams4);
        relativeLayout.addView(this.f6681h);
        LinearLayout linearLayout = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.tencent.connect.avatar.a.a(this, 80.0f));
        layoutParams5.addRule(14, -1);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.a.addView(linearLayout);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 24.0f), com.tencent.connect.avatar.a.a(this, 24.0f)));
        imageView.setImageDrawable(b("com.tencent.plus.logo.png"));
        linearLayout.addView(imageView);
        this.f6682i = new TextView(this);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(layoutParams3);
        layoutParams6.leftMargin = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.f6682i.setLayoutParams(layoutParams6);
        this.f6682i.setEllipsize(TextUtils.TruncateAt.END);
        this.f6682i.setSingleLine();
        this.f6682i.setTextColor(-1);
        this.f6682i.setTextSize(24.0f);
        this.f6682i.setVisibility(8);
        linearLayout.addView(this.f6682i);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.tencent.connect.avatar.a.a(this, 60.0f));
        layoutParams7.addRule(12, -1);
        layoutParams7.addRule(9, -1);
        relativeLayout2.setLayoutParams(layoutParams7);
        relativeLayout2.setBackgroundDrawable(b("com.tencent.plus.bar.png"));
        int iA = com.tencent.connect.avatar.a.a(this, 10.0f);
        relativeLayout2.setPadding(iA, iA, iA, 0);
        this.a.addView(relativeLayout2);
        a aVar = new a(this);
        int iA2 = com.tencent.connect.avatar.a.a(this, 14.0f);
        int iA3 = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.f6680g = new Button(this);
        this.f6680g.setLayoutParams(new RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f)));
        this.f6680g.setText("\u53d6\u6d88");
        this.f6680g.setTextColor(-1);
        this.f6680g.setTextSize(18.0f);
        this.f6680g.setPadding(iA2, iA3, iA2, iA3);
        aVar.b(this.f6680g);
        relativeLayout2.addView(this.f6680g);
        this.f6679f = new Button(this);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f));
        layoutParams8.addRule(11, -1);
        this.f6679f.setLayoutParams(layoutParams8);
        this.f6679f.setTextColor(-1);
        this.f6679f.setTextSize(18.0f);
        this.f6679f.setPadding(iA2, iA3, iA2, iA3);
        this.f6679f.setText("\u9009\u53d6");
        aVar.a(this.f6679f);
        relativeLayout2.addView(this.f6679f);
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams9.addRule(13, -1);
        textView.setLayoutParams(layoutParams9);
        textView.setText("\u79fb\u52a8\u548c\u7f29\u653e");
        textView.setPadding(0, com.tencent.connect.avatar.a.a(this, 3.0f), 0, 0);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        relativeLayout2.addView(textView);
        this.f6683j = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams10.addRule(14, -1);
        layoutParams10.addRule(15, -1);
        this.f6683j.setLayoutParams(layoutParams10);
        this.f6683j.setVisibility(8);
        this.a.addView(this.f6683j);
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String strD = d(str);
        if ("".equals(strD)) {
            return;
        }
        this.f6682i.setText(strD);
        this.f6682i.setVisibility(0);
    }

    private void a(Bitmap bitmap) {
        new QQAvatarImp(this.f6675b).setAvator(bitmap, this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final int i2) {
        this.f6677d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ImageActivity.this.b(str, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEY_ERROR_CODE, i2);
        intent.putExtra(Constants.KEY_ERROR_MSG, str2);
        intent.putExtra(Constants.KEY_ERROR_DETAIL, str3);
        intent.putExtra(Constants.KEY_RESPONSE, str);
        setResult(-1, intent);
    }

    public void a(String str, long j2) {
        a(str, j2, this.f6675b.getAppId());
    }

    public static void a(String str, long j2, String str2) {
        HashMap map = new HashMap();
        map.put("strValue", str2);
        map.put("nValue", str);
        map.put("qver", Constants.SDK_VERSION);
        if (j2 != 0) {
            map.put("elt", String.valueOf(j2));
        }
        h.a().a("https://cgi.qplus.com/report/report", map);
    }
}
