package com.umeng.socialize.editorpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.umeng.socialize.bean.HandlerRequestCode;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.ResContainer;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class ShareActivity extends Activity implements View.OnClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f8259c = "ShareActivity";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f8260d = 140;
    protected ImageView a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f8263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f8264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f8265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ResContainer f8266i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private EditText f8267j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f8268k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Context f8269l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f8270m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private SHARE_MEDIA f8271n;
    private ImageView p;
    private TextView q;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f8262e = "7.3.2";
    private boolean o = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    TextWatcher f8261b = new TextWatcher() { // from class: com.umeng.socialize.editorpage.ShareActivity.1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ShareActivity shareActivity = ShareActivity.this;
            shareActivity.f8270m = shareActivity.e();
        }
    };

    private String b(String str) {
        return str.equals("TENCENT") ? getResources().getString(this.f8266i.string("umeng_socialize_sharetotencent")) : str.equals("RENREN") ? getResources().getString(this.f8266i.string("umeng_socialize_sharetorenren")) : str.equals("DOUBAN") ? getResources().getString(this.f8266i.string("umeng_socialize_sharetodouban")) : str.equals("TWITTER") ? getResources().getString(this.f8266i.string("umeng_socialize_sharetotwitter")) : str.equals("LINKEDIN") ? getResources().getString(this.f8266i.string("umeng_socialize_sharetolinkin")) : getResources().getString(this.f8266i.string("umeng_socialize_sharetosina"));
    }

    private void c() {
        SHARE_MEDIA share_media;
        String string = this.f8267j.getText().toString();
        if (TextUtils.isEmpty(string.trim()) && this.f8271n == SHARE_MEDIA.SINA && (TextUtils.isEmpty(this.f8265h) || this.f8265h.equals("web") || this.f8265h.equals("video") || this.f8265h.equals("music"))) {
            Toast.makeText(this.f8269l, UmengText.SHARE.CONTEXT_EMPTY, 0).show();
            return;
        }
        if (SocializeUtils.countContentLength(string) <= f8260d || (share_media = this.f8271n) == SHARE_MEDIA.TWITTER || share_media == SHARE_MEDIA.LINKEDIN) {
            if (this.f8270m && this.f8271n != SHARE_MEDIA.TWITTER) {
                Toast.makeText(this.f8269l, UmengText.SHARE.CONTEXT_LONG, 0).show();
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(SocializeConstants.KEY_TEXT, string);
            bundle.putString("pic", this.f8265h);
            intent.putExtras(bundle);
            setResult(-1, intent);
            a();
        }
    }

    private void d() {
        this.f8265h = null;
        findViewById(this.f8266i.id("root")).setBackgroundColor(Color.parseColor("#D4E0E5"));
        findViewById(this.f8266i.id("umeng_socialize_share_bottom_area")).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        int iCountContentLength = f8260d - SocializeUtils.countContentLength(this.f8267j.getText().toString());
        this.f8268k.setText(SocializeUtils.countContentLength(this.f8267j.getText().toString()) + "/" + f8260d);
        return iCountContentLength < 0;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!SocializeConstants.BACKKEY_COMPLETE_CLOSE || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        new Handler().postDelayed(new Runnable() { // from class: com.umeng.socialize.editorpage.ShareActivity.2
            @Override // java.lang.Runnable
            public void run() {
                ShareActivity.this.setResult(1000);
                ShareActivity.this.finish();
            }
        }, 400L);
        return true;
    }

    public void onCancel(View view) {
        setResult(1000);
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == this.f8266i.id("umeng_back")) {
            onCancel(view);
        } else if (id == this.f8266i.id("umeng_share_btn")) {
            c();
        } else if (id == this.f8266i.id("umeng_del")) {
            d();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f8266i = ResContainer.get(this);
        this.o = SocializeUtils.isFloatWindowStyle(this);
        super.onCreate(bundle);
        this.f8269l = this;
        setContentView(this.f8266i.layout("umeng_socialize_share"));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.softInputMode = 32;
        if (this.o) {
            int[] floatWindowSize = SocializeUtils.getFloatWindowSize(this.f8269l);
            attributes.width = floatWindowSize[0];
            attributes.height = floatWindowSize[1];
        }
        getWindow().setAttributes(attributes);
        SLog.E(UmengText.SHARE.SHAREVIEWV + this.f8262e);
        Bundle extras = getIntent().getExtras();
        this.f8271n = a(extras.getString(SocializeConstants.KEY_PLATFORM));
        f8260d = HandlerRequestCode.TWITTER_REQUEST_AUTH_CODE;
        this.f8263f = extras.getString(SocializeConstants.KEY_TEXT);
        this.f8265h = extras.getString("pic");
        this.f8264g = extras.getString("title");
        b();
        this.p = (ImageView) findViewById(this.f8266i.id("umeng_del"));
        this.f8267j.addTextChangedListener(this.f8261b);
        ((TextView) findViewById(this.f8266i.id("umeng_title"))).setText(b(extras.getString(SocializeConstants.KEY_PLATFORM)));
        findViewById(this.f8266i.id("umeng_back")).setOnClickListener(this);
        findViewById(this.f8266i.id("umeng_share_btn")).setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.f8268k = (TextView) findViewById(this.f8266i.id("umeng_socialize_share_word_num"));
        this.f8270m = e();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            setResult(1000);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.f8267j.requestFocus();
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    private SHARE_MEDIA a(String str) {
        if (str.equals("DOUBAN")) {
            return SHARE_MEDIA.DOUBAN;
        }
        if (str.equals("TWITTER")) {
            return SHARE_MEDIA.TWITTER;
        }
        if (str.equals("LINKEDIN")) {
            return SHARE_MEDIA.LINKEDIN;
        }
        return SHARE_MEDIA.SINA;
    }

    protected void a() {
        finish();
    }

    private void b() {
        this.f8267j = (EditText) findViewById(this.f8266i.id("umeng_socialize_share_edittext"));
        if (!TextUtils.isEmpty(this.f8263f)) {
            this.f8267j.setText(this.f8263f);
            this.f8267j.setSelection(this.f8263f.length());
        }
        this.q = (TextView) findViewById(this.f8266i.id("umeng_web_title"));
        this.a = (ImageView) findViewById(this.f8266i.id("umeng_share_icon"));
        if (this.f8265h != null) {
            findViewById(this.f8266i.id("umeng_socialize_share_bottom_area")).setVisibility(0);
            this.a = (ImageView) findViewById(this.f8266i.id("umeng_share_icon"));
            this.a.setVisibility(0);
            if (this.f8265h.equals("video")) {
                this.a.setImageResource(ResContainer.getResourceId(this.f8269l, "drawable", "umeng_socialize_share_video"));
            } else if (this.f8265h.equals("music")) {
                this.a.setImageResource(ResContainer.getResourceId(this.f8269l, "drawable", "umeng_socialize_share_music"));
            } else if (this.f8265h.equals("web")) {
                this.a.setImageResource(ResContainer.getResourceId(this.f8269l, "drawable", "umeng_socialize_share_web"));
            } else {
                this.a.setImageURI(Uri.fromFile(new File(this.f8265h)));
            }
            if (!TextUtils.isEmpty(this.f8264g)) {
                this.q.setVisibility(0);
                this.q.setText(this.f8264g);
            }
            findViewById(this.f8266i.id("root")).setBackgroundColor(-1);
            return;
        }
        if (TextUtils.isEmpty(this.f8264g)) {
            return;
        }
        this.a.setImageResource(ResContainer.getResourceId(this.f8269l, "drawable", "umeng_socialize_share_web"));
        this.q.setVisibility(0);
        this.q.setText(this.f8264g);
    }
}
