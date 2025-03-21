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

/* loaded from: classes2.dex */
public class ShareActivity extends Activity implements View.OnClickListener {

    /* renamed from: c */
    private static final String f13611c = "ShareActivity";

    /* renamed from: d */
    private static int f13612d = 140;

    /* renamed from: a */
    protected ImageView f13613a;

    /* renamed from: f */
    private String f13616f;

    /* renamed from: g */
    private String f13617g;

    /* renamed from: h */
    private String f13618h;

    /* renamed from: i */
    private ResContainer f13619i;

    /* renamed from: j */
    private EditText f13620j;

    /* renamed from: k */
    private TextView f13621k;

    /* renamed from: l */
    private Context f13622l;

    /* renamed from: m */
    private boolean f13623m;

    /* renamed from: n */
    private SHARE_MEDIA f13624n;

    /* renamed from: p */
    private ImageView f13626p;

    /* renamed from: q */
    private TextView f13627q;

    /* renamed from: e */
    private String f13615e = "7.3.2";

    /* renamed from: o */
    private boolean f13625o = false;

    /* renamed from: b */
    TextWatcher f13614b = new TextWatcher() { // from class: com.umeng.socialize.editorpage.ShareActivity.1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ShareActivity shareActivity = ShareActivity.this;
            shareActivity.f13623m = shareActivity.m12645e();
        }
    };

    /* renamed from: b */
    private String m12641b(String str) {
        return str.equals("TENCENT") ? getResources().getString(this.f13619i.string("umeng_socialize_sharetotencent")) : str.equals("RENREN") ? getResources().getString(this.f13619i.string("umeng_socialize_sharetorenren")) : str.equals("DOUBAN") ? getResources().getString(this.f13619i.string("umeng_socialize_sharetodouban")) : str.equals("TWITTER") ? getResources().getString(this.f13619i.string("umeng_socialize_sharetotwitter")) : str.equals("LINKEDIN") ? getResources().getString(this.f13619i.string("umeng_socialize_sharetolinkin")) : getResources().getString(this.f13619i.string("umeng_socialize_sharetosina"));
    }

    /* renamed from: c */
    private void m12643c() {
        SHARE_MEDIA share_media;
        String obj = this.f13620j.getText().toString();
        if (TextUtils.isEmpty(obj.trim()) && this.f13624n == SHARE_MEDIA.SINA && (TextUtils.isEmpty(this.f13618h) || this.f13618h.equals("web") || this.f13618h.equals("video") || this.f13618h.equals("music"))) {
            Toast.makeText(this.f13622l, UmengText.SHARE.CONTEXT_EMPTY, 0).show();
            return;
        }
        if (SocializeUtils.countContentLength(obj) <= f13612d || (share_media = this.f13624n) == SHARE_MEDIA.TWITTER || share_media == SHARE_MEDIA.LINKEDIN) {
            if (this.f13623m && this.f13624n != SHARE_MEDIA.TWITTER) {
                Toast.makeText(this.f13622l, UmengText.SHARE.CONTEXT_LONG, 0).show();
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(SocializeConstants.KEY_TEXT, obj);
            bundle.putString("pic", this.f13618h);
            intent.putExtras(bundle);
            setResult(-1, intent);
            m12646a();
        }
    }

    /* renamed from: d */
    private void m12644d() {
        this.f13618h = null;
        findViewById(this.f13619i.m12637id("root")).setBackgroundColor(Color.parseColor("#D4E0E5"));
        findViewById(this.f13619i.m12637id("umeng_socialize_share_bottom_area")).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public boolean m12645e() {
        int countContentLength = f13612d - SocializeUtils.countContentLength(this.f13620j.getText().toString());
        this.f13621k.setText(SocializeUtils.countContentLength(this.f13620j.getText().toString()) + "/" + f13612d);
        return countContentLength < 0;
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
        m12646a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == this.f13619i.m12637id("umeng_back")) {
            onCancel(view);
        } else if (id == this.f13619i.m12637id("umeng_share_btn")) {
            m12643c();
        } else if (id == this.f13619i.m12637id("umeng_del")) {
            m12644d();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f13619i = ResContainer.get(this);
        this.f13625o = SocializeUtils.isFloatWindowStyle(this);
        super.onCreate(bundle);
        this.f13622l = this;
        setContentView(this.f13619i.layout("umeng_socialize_share"));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.softInputMode = 32;
        if (this.f13625o) {
            int[] floatWindowSize = SocializeUtils.getFloatWindowSize(this.f13622l);
            attributes.width = floatWindowSize[0];
            attributes.height = floatWindowSize[1];
        }
        getWindow().setAttributes(attributes);
        SLog.m12716E(UmengText.SHARE.SHAREVIEWV + this.f13615e);
        Bundle extras = getIntent().getExtras();
        this.f13624n = m12638a(extras.getString(SocializeConstants.KEY_PLATFORM));
        f13612d = HandlerRequestCode.TWITTER_REQUEST_AUTH_CODE;
        this.f13616f = extras.getString(SocializeConstants.KEY_TEXT);
        this.f13618h = extras.getString("pic");
        this.f13617g = extras.getString("title");
        m12642b();
        this.f13626p = (ImageView) findViewById(this.f13619i.m12637id("umeng_del"));
        this.f13620j.addTextChangedListener(this.f13614b);
        ((TextView) findViewById(this.f13619i.m12637id("umeng_title"))).setText(m12641b(extras.getString(SocializeConstants.KEY_PLATFORM)));
        findViewById(this.f13619i.m12637id("umeng_back")).setOnClickListener(this);
        findViewById(this.f13619i.m12637id("umeng_share_btn")).setOnClickListener(this);
        this.f13626p.setOnClickListener(this);
        this.f13621k = (TextView) findViewById(this.f13619i.m12637id("umeng_socialize_share_word_num"));
        this.f13623m = m12645e();
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
        this.f13620j.requestFocus();
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    /* renamed from: a */
    private SHARE_MEDIA m12638a(String str) {
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

    /* renamed from: a */
    protected void m12646a() {
        finish();
    }

    /* renamed from: b */
    private void m12642b() {
        this.f13620j = (EditText) findViewById(this.f13619i.m12637id("umeng_socialize_share_edittext"));
        if (!TextUtils.isEmpty(this.f13616f)) {
            this.f13620j.setText(this.f13616f);
            this.f13620j.setSelection(this.f13616f.length());
        }
        this.f13627q = (TextView) findViewById(this.f13619i.m12637id("umeng_web_title"));
        this.f13613a = (ImageView) findViewById(this.f13619i.m12637id("umeng_share_icon"));
        if (this.f13618h != null) {
            findViewById(this.f13619i.m12637id("umeng_socialize_share_bottom_area")).setVisibility(0);
            this.f13613a = (ImageView) findViewById(this.f13619i.m12637id("umeng_share_icon"));
            this.f13613a.setVisibility(0);
            if (this.f13618h.equals("video")) {
                this.f13613a.setImageResource(ResContainer.getResourceId(this.f13622l, "drawable", "umeng_socialize_share_video"));
            } else if (this.f13618h.equals("music")) {
                this.f13613a.setImageResource(ResContainer.getResourceId(this.f13622l, "drawable", "umeng_socialize_share_music"));
            } else if (this.f13618h.equals("web")) {
                this.f13613a.setImageResource(ResContainer.getResourceId(this.f13622l, "drawable", "umeng_socialize_share_web"));
            } else {
                this.f13613a.setImageURI(Uri.fromFile(new File(this.f13618h)));
            }
            if (!TextUtils.isEmpty(this.f13617g)) {
                this.f13627q.setVisibility(0);
                this.f13627q.setText(this.f13617g);
            }
            findViewById(this.f13619i.m12637id("root")).setBackgroundColor(-1);
            return;
        }
        if (TextUtils.isEmpty(this.f13617g)) {
            return;
        }
        this.f13613a.setImageResource(ResContainer.getResourceId(this.f13622l, "drawable", "umeng_socialize_share_web"));
        this.f13627q.setVisibility(0);
        this.f13627q.setText(this.f13617g);
    }
}
