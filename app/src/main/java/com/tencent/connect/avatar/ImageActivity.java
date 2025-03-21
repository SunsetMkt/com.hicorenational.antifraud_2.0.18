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
import com.tencent.open.p212b.C3263e;
import com.tencent.open.p212b.C3266h;
import com.tencent.open.utils.C3289g;
import com.tencent.open.utils.C3295m;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class ImageActivity extends Activity {

    /* renamed from: a */
    RelativeLayout f10946a;

    /* renamed from: b */
    private QQToken f10947b;

    /* renamed from: c */
    private String f10948c;

    /* renamed from: d */
    private Handler f10949d;

    /* renamed from: e */
    private C3221c f10950e;

    /* renamed from: f */
    private Button f10951f;

    /* renamed from: g */
    private Button f10952g;

    /* renamed from: h */
    private C3220b f10953h;

    /* renamed from: i */
    private TextView f10954i;

    /* renamed from: j */
    private ProgressBar f10955j;

    /* renamed from: r */
    private String f10963r;

    /* renamed from: s */
    private Bitmap f10964s;

    /* renamed from: k */
    private int f10956k = 0;

    /* renamed from: l */
    private boolean f10957l = false;

    /* renamed from: m */
    private long f10958m = 0;

    /* renamed from: n */
    private int f10959n = 0;

    /* renamed from: o */
    private final int f10960o = Contants.PREVIEW_W;

    /* renamed from: p */
    private final int f10961p = Contants.PREVIEW_W;

    /* renamed from: q */
    private Rect f10962q = new Rect();

    /* renamed from: t */
    private final View.OnClickListener f10965t = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.f10955j.setVisibility(0);
            ImageActivity.this.f10952g.setEnabled(false);
            ImageActivity.this.f10952g.setTextColor(Color.rgb(21, 21, 21));
            ImageActivity.this.f10951f.setEnabled(false);
            ImageActivity.this.f10951f.setTextColor(Color.rgb(36, 94, 134));
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageActivity.this.m10269c();
                }
            }).start();
            if (ImageActivity.this.f10957l) {
                ImageActivity.this.m10286a("10657", 0L);
                return;
            }
            ImageActivity.this.m10286a("10655", System.currentTimeMillis() - ImageActivity.this.f10958m);
            if (ImageActivity.this.f10950e.f10986b) {
                ImageActivity.this.m10286a("10654", 0L);
            }
        }
    };

    /* renamed from: u */
    private final View.OnClickListener f10966u = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.m10286a("10656", System.currentTimeMillis() - ImageActivity.this.f10958m);
            ImageActivity.this.setResult(0);
            ImageActivity.this.m10273d();
        }
    };

    /* renamed from: v */
    private final IUiListener f10967v = new DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.5
        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            ImageActivity.this.f10952g.setEnabled(true);
            int i2 = -1;
            ImageActivity.this.f10952g.setTextColor(-1);
            ImageActivity.this.f10951f.setEnabled(true);
            ImageActivity.this.f10951f.setTextColor(-1);
            ImageActivity.this.f10955j.setVisibility(8);
            JSONObject jSONObject = (JSONObject) obj;
            try {
                i2 = jSONObject.getInt("ret");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (i2 != 0) {
                ImageActivity.this.m10259a("设置出错了，请重新登录再尝试下呢：）", 1);
                C3263e.m10457a().m10459a(ImageActivity.this.f10947b.getOpenId(), ImageActivity.this.f10947b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, "12", Constants.VIA_ACT_TYPE_NINETEEN, "1");
                return;
            }
            ImageActivity.this.m10259a("设置成功", 0);
            ImageActivity.this.m10286a("10658", 0L);
            C3263e.m10457a().m10459a(ImageActivity.this.f10947b.getOpenId(), ImageActivity.this.f10947b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, "12", "3", "0");
            ImageActivity imageActivity = ImageActivity.this;
            if (imageActivity.f10948c != null && !"".equals(ImageActivity.this.f10948c)) {
                Intent intent = new Intent();
                intent.setClassName(imageActivity, ImageActivity.this.f10948c);
                if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null) {
                    imageActivity.startActivity(intent);
                }
            }
            ImageActivity.this.m10255a(0, jSONObject.toString(), null, null);
            ImageActivity.this.m10273d();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            ImageActivity.this.f10952g.setEnabled(true);
            ImageActivity.this.f10952g.setTextColor(-1);
            ImageActivity.this.f10951f.setEnabled(true);
            ImageActivity.this.f10951f.setTextColor(-1);
            ImageActivity.this.f10951f.setText("重试");
            ImageActivity.this.f10955j.setVisibility(8);
            ImageActivity.this.f10957l = true;
            ImageActivity.this.m10259a(uiError.errorMessage, 1);
            ImageActivity.this.m10286a("10660", 0L);
        }
    };

    /* renamed from: w */
    private final IUiListener f10968w = new DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.6
        /* renamed from: a */
        private void m10287a(int i2) {
            if (ImageActivity.this.f10956k < 2) {
                ImageActivity.this.m10275e();
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
                    ImageActivity.this.f10949d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageActivity.this.m10270c(string);
                        }
                    });
                    ImageActivity.this.m10286a("10659", 0L);
                } else {
                    ImageActivity.this.m10286a("10661", 0L);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (i2 != 0) {
                m10287a(i2);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            m10287a(0);
        }
    };

    /* compiled from: ProGuard */
    private class QQAvatarImp extends BaseApi {
        public QQAvatarImp(QQToken qQToken) {
            super(qQToken);
        }

        public void setAvator(Bitmap bitmap, IUiListener iUiListener) {
            Bundle m10308a = m10308a();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmap.recycle();
            BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(iUiListener);
            m10308a.putByteArray("picture", byteArray);
            HttpUtils.requestAsync(this.f11013c, C3289g.m10603a(), "user/set_user_face", m10308a, "POST", tempRequestListener);
            C3263e.m10457a().m10459a(this.f11013c.getOpenId(), this.f11013c.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, "12", Constants.VIA_ACT_TYPE_NINETEEN, "0");
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.avatar.ImageActivity$a */
    class C3218a extends View {
        public C3218a(Context context) {
            super(context);
        }

        /* renamed from: a */
        public void m10288a(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable m10263b = ImageActivity.this.m10263b("com.tencent.plus.blue_normal.png");
            Drawable m10263b2 = ImageActivity.this.m10263b("com.tencent.plus.blue_down.png");
            Drawable m10263b3 = ImageActivity.this.m10263b("com.tencent.plus.blue_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, m10263b2);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, m10263b);
            stateListDrawable.addState(View.ENABLED_STATE_SET, m10263b);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, m10263b);
            stateListDrawable.addState(View.EMPTY_STATE_SET, m10263b3);
            button.setBackgroundDrawable(stateListDrawable);
        }

        /* renamed from: b */
        public void m10289b(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable m10263b = ImageActivity.this.m10263b("com.tencent.plus.gray_normal.png");
            Drawable m10263b2 = ImageActivity.this.m10263b("com.tencent.plus.gray_down.png");
            Drawable m10263b3 = ImageActivity.this.m10263b("com.tencent.plus.gray_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, m10263b2);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, m10263b);
            stateListDrawable.addState(View.ENABLED_STATE_SET, m10263b);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, m10263b);
            stateListDrawable.addState(View.EMPTY_STATE_SET, m10263b3);
            button.setBackgroundDrawable(stateListDrawable);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        m10273d();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(m10253a());
        this.f10949d = new Handler();
        Bundle bundleExtra = getIntent().getBundleExtra(Constants.KEY_PARAMS);
        this.f10963r = bundleExtra.getString("picture");
        this.f10948c = bundleExtra.getString("return_activity");
        String string = bundleExtra.getString("appid");
        String string2 = bundleExtra.getString("access_token");
        long j2 = bundleExtra.getLong("expires_in");
        String string3 = bundleExtra.getString("openid");
        this.f10959n = bundleExtra.getInt("exitAnim");
        this.f10947b = new QQToken(string);
        this.f10947b.setAccessToken(string2, ((j2 - System.currentTimeMillis()) / 1000) + "");
        this.f10947b.setOpenId(string3);
        m10264b();
        m10275e();
        this.f10958m = System.currentTimeMillis();
        m10286a("10653", 0L);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f10950e.setImageBitmap(null);
        Bitmap bitmap = this.f10964s;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f10964s.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m10269c() {
        float width = this.f10962q.width();
        Matrix imageMatrix = this.f10950e.getImageMatrix();
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        float f2 = fArr[2];
        float f3 = fArr[5];
        float f4 = fArr[0];
        float f5 = 640.0f / width;
        int i2 = (int) ((this.f10962q.left - f2) / f4);
        int i3 = i2 < 0 ? 0 : i2;
        int i4 = (int) ((this.f10962q.top - f3) / f4);
        int i5 = i4 < 0 ? 0 : i4;
        Matrix matrix = new Matrix();
        matrix.set(imageMatrix);
        matrix.postScale(f5, f5);
        int i6 = (int) (650.0f / f4);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.f10964s, i3, i5, Math.min(this.f10964s.getWidth() - i3, i6), Math.min(this.f10964s.getHeight() - i5, i6), matrix, true);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, Contants.PREVIEW_W, Contants.PREVIEW_W);
            createBitmap.recycle();
            m10256a(createBitmap2);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            m10259a(Constants.MSG_IMAGE_ERROR, 1);
            m10255a(-5, null, Constants.MSG_IMAGE_ERROR, e2.getMessage());
            m10273d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m10273d() {
        finish();
        int i2 = this.f10959n;
        if (i2 != 0) {
            overridePendingTransition(0, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m10275e() {
        this.f10956k++;
        new UserInfo(this, this.f10947b).getUserInfo(this.f10968w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Drawable m10263b(String str) {
        return C3295m.m10661a(str, this);
    }

    /* renamed from: b */
    private void m10264b() {
        try {
            this.f10964s = m10250a(this.f10963r);
        } catch (IOException e2) {
            e2.printStackTrace();
            m10259a(Constants.MSG_IMAGE_ERROR, 1);
            m10255a(-5, null, Constants.MSG_IMAGE_ERROR, e2.getMessage());
            m10273d();
        }
        if (this.f10964s != null) {
            this.f10950e.setImageBitmap(this.f10964s);
            this.f10951f.setOnClickListener(this.f10965t);
            this.f10952g.setOnClickListener(this.f10966u);
            this.f10946a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.connect.avatar.ImageActivity.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ImageActivity.this.f10946a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ImageActivity imageActivity = ImageActivity.this;
                    imageActivity.f10962q = imageActivity.f10953h.m10295a();
                    ImageActivity.this.f10950e.m10303a(ImageActivity.this.f10962q);
                }
            });
            return;
        }
        throw new IOException("cannot read picture: '" + this.f10963r + "'!");
    }

    /* renamed from: d */
    private String m10272d(String str) {
        return str.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", "&");
    }

    /* renamed from: a */
    private Bitmap m10250a(String str) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        Uri parse = Uri.parse(str);
        InputStream openInputStream = getContentResolver().openInputStream(parse);
        if (openInputStream == null) {
            return null;
        }
        try {
            BitmapFactory.decodeStream(openInputStream, null, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        openInputStream.close();
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
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(parse), null, options);
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10267b(String str, int i2) {
        Toast makeText = Toast.makeText(this, str, 1);
        LinearLayout linearLayout = (LinearLayout) makeText.getView();
        ((TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(C3219a.m10293a(this, 16.0f), C3219a.m10293a(this, 16.0f)));
        if (i2 == 0) {
            imageView.setImageDrawable(m10263b("com.tencent.plus.ic_success.png"));
        } else {
            imageView.setImageDrawable(m10263b("com.tencent.plus.ic_error.png"));
        }
        linearLayout.addView(imageView, 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        makeText.setView(linearLayout);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    /* renamed from: a */
    private View m10253a() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
        this.f10946a = new RelativeLayout(this);
        this.f10946a.setLayoutParams(layoutParams);
        this.f10946a.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(layoutParams3);
        this.f10946a.addView(relativeLayout);
        this.f10950e = new C3221c(this);
        this.f10950e.setLayoutParams(layoutParams2);
        this.f10950e.setScaleType(ImageView.ScaleType.MATRIX);
        relativeLayout.addView(this.f10950e);
        this.f10953h = new C3220b(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(layoutParams2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(15, -1);
        this.f10953h.setLayoutParams(layoutParams4);
        relativeLayout.addView(this.f10953h);
        LinearLayout linearLayout = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, C3219a.m10293a(this, 80.0f));
        layoutParams5.addRule(14, -1);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.f10946a.addView(linearLayout);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(C3219a.m10293a(this, 24.0f), C3219a.m10293a(this, 24.0f)));
        imageView.setImageDrawable(m10263b("com.tencent.plus.logo.png"));
        linearLayout.addView(imageView);
        this.f10954i = new TextView(this);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(layoutParams3);
        layoutParams6.leftMargin = C3219a.m10293a(this, 7.0f);
        this.f10954i.setLayoutParams(layoutParams6);
        this.f10954i.setEllipsize(TextUtils.TruncateAt.END);
        this.f10954i.setSingleLine();
        this.f10954i.setTextColor(-1);
        this.f10954i.setTextSize(24.0f);
        this.f10954i.setVisibility(8);
        linearLayout.addView(this.f10954i);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, C3219a.m10293a(this, 60.0f));
        layoutParams7.addRule(12, -1);
        layoutParams7.addRule(9, -1);
        relativeLayout2.setLayoutParams(layoutParams7);
        relativeLayout2.setBackgroundDrawable(m10263b("com.tencent.plus.bar.png"));
        int m10293a = C3219a.m10293a(this, 10.0f);
        relativeLayout2.setPadding(m10293a, m10293a, m10293a, 0);
        this.f10946a.addView(relativeLayout2);
        C3218a c3218a = new C3218a(this);
        int m10293a2 = C3219a.m10293a(this, 14.0f);
        int m10293a3 = C3219a.m10293a(this, 7.0f);
        this.f10952g = new Button(this);
        this.f10952g.setLayoutParams(new RelativeLayout.LayoutParams(C3219a.m10293a(this, 78.0f), C3219a.m10293a(this, 45.0f)));
        this.f10952g.setText("取消");
        this.f10952g.setTextColor(-1);
        this.f10952g.setTextSize(18.0f);
        this.f10952g.setPadding(m10293a2, m10293a3, m10293a2, m10293a3);
        c3218a.m10289b(this.f10952g);
        relativeLayout2.addView(this.f10952g);
        this.f10951f = new Button(this);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(C3219a.m10293a(this, 78.0f), C3219a.m10293a(this, 45.0f));
        layoutParams8.addRule(11, -1);
        this.f10951f.setLayoutParams(layoutParams8);
        this.f10951f.setTextColor(-1);
        this.f10951f.setTextSize(18.0f);
        this.f10951f.setPadding(m10293a2, m10293a3, m10293a2, m10293a3);
        this.f10951f.setText("选取");
        c3218a.m10288a(this.f10951f);
        relativeLayout2.addView(this.f10951f);
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams9.addRule(13, -1);
        textView.setLayoutParams(layoutParams9);
        textView.setText("移动和缩放");
        textView.setPadding(0, C3219a.m10293a(this, 3.0f), 0, 0);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        relativeLayout2.addView(textView);
        this.f10955j = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams10.addRule(14, -1);
        layoutParams10.addRule(15, -1);
        this.f10955j.setLayoutParams(layoutParams10);
        this.f10955j.setVisibility(8);
        this.f10946a.addView(this.f10955j);
        return this.f10946a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m10270c(String str) {
        String m10272d = m10272d(str);
        if ("".equals(m10272d)) {
            return;
        }
        this.f10954i.setText(m10272d);
        this.f10954i.setVisibility(0);
    }

    /* renamed from: a */
    private void m10256a(Bitmap bitmap) {
        new QQAvatarImp(this.f10947b).setAvator(bitmap, this.f10967v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10259a(final String str, final int i2) {
        this.f10949d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ImageActivity.this.m10267b(str, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10255a(int i2, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEY_ERROR_CODE, i2);
        intent.putExtra(Constants.KEY_ERROR_MSG, str2);
        intent.putExtra(Constants.KEY_ERROR_DETAIL, str3);
        intent.putExtra(Constants.KEY_RESPONSE, str);
        setResult(-1, intent);
    }

    /* renamed from: a */
    public void m10286a(String str, long j2) {
        m10260a(str, j2, this.f10947b.getAppId());
    }

    /* renamed from: a */
    public static void m10260a(String str, long j2, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("strValue", str2);
        hashMap.put("nValue", str);
        hashMap.put("qver", Constants.SDK_VERSION);
        if (j2 != 0) {
            hashMap.put("elt", String.valueOf(j2));
        }
        C3266h.m10468a().m10473a("https://cgi.qplus.com/report/report", hashMap);
    }
}
