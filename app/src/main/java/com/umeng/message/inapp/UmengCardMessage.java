package com.umeng.message.inapp;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.connect.common.Constants;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.C3551a;
import com.umeng.message.proguard.C3560ai;
import com.umeng.message.proguard.C3580bb;
import com.umeng.message.proguard.C3582bd;
import com.umeng.message.proguard.C3586f;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class UmengCardMessage extends DialogFragment {

    /* renamed from: b */
    private static final String f13087b = UmengCardMessage.class.getName();

    /* renamed from: a */
    public IUmengInAppMsgCloseCallback f13088a;

    /* renamed from: c */
    private Activity f13089c;

    /* renamed from: d */
    private UInAppMessage f13090d;

    /* renamed from: e */
    private String f13091e;

    /* renamed from: f */
    private Bitmap f13092f;

    /* renamed from: g */
    private ViewGroup f13093g;

    /* renamed from: h */
    private int f13094h;

    /* renamed from: i */
    private int f13095i;

    /* renamed from: j */
    private int f13096j;

    /* renamed from: k */
    private int f13097k;

    /* renamed from: l */
    private UInAppHandler f13098l;

    /* renamed from: m */
    private boolean f13099m = false;

    /* renamed from: n */
    private boolean f13100n = false;

    /* renamed from: o */
    private boolean f13101o = false;

    /* renamed from: p */
    private boolean f13102p = false;

    /* renamed from: q */
    private String[] f13103q = {"18", Constants.VIA_REPORT_TYPE_START_WAP, Constants.VIA_REPORT_TYPE_START_WAP};

    /* renamed from: a */
    static /* synthetic */ boolean m12170a(UmengCardMessage umengCardMessage) {
        umengCardMessage.f13100n = true;
        return true;
    }

    /* renamed from: e */
    static /* synthetic */ boolean m12174e(UmengCardMessage umengCardMessage) {
        umengCardMessage.f13102p = true;
        return true;
    }

    /* renamed from: f */
    static /* synthetic */ boolean m12175f(UmengCardMessage umengCardMessage) {
        umengCardMessage.f13101o = true;
        return true;
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f13093g != null) {
            RelativeLayout.LayoutParams layoutParams = configuration.orientation == 1 ? new RelativeLayout.LayoutParams(-1, -2) : new RelativeLayout.LayoutParams(-2, -1);
            int m12337a = C3580bb.m12337a(30.0f);
            int m12337a2 = C3580bb.m12337a(15.0f);
            layoutParams.setMargins(m12337a, m12337a2, m12337a, m12337a2);
            layoutParams.addRule(13);
            this.f13093g.setLayoutParams(layoutParams);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, R.style.Theme.NoTitleBar);
        setRetainInstance(true);
        try {
            this.f13089c = getActivity();
            Bundle arguments = getArguments();
            this.f13090d = new UInAppMessage(new JSONObject(arguments.getString("msg")));
            this.f13091e = arguments.getString("label");
            byte[] byteArray = arguments.getByteArray("bitmapByte");
            if (byteArray != null) {
                this.f13092f = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            }
            this.f13098l = InAppMessageManager.getInstance(this.f13089c).getInAppHandler();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int i2 = this.f13090d.msg_type;
        if (i2 == 5 || i2 == 6) {
            String m12160a = InAppMessageManager.getInstance(this.f13089c).m12160a("KEY_PLAIN_TEXT_SIZE", "");
            String[] split = !TextUtils.isEmpty(m12160a) ? m12160a.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP) : null;
            if (split != null) {
                this.f13103q = split;
            }
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.requestWindowFeature(1);
        return onCreateDialog;
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Rect rect;
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            this.f13095i = rect.height() - C3580bb.m12337a(65.0f);
            this.f13094h = (int) (this.f13095i * 1.2d);
            this.f13096j = rect.width() - C3580bb.m12337a(70.0f);
            this.f13097k = (this.f13096j / 2) * 3;
        } else {
            rect = null;
        }
        int i2 = this.f13090d.msg_type;
        if (i2 == 2 || i2 == 3) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f13089c);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.setBackgroundColor(Color.parseColor("#33000000"));
            RelativeLayout.LayoutParams layoutParams = getResources().getConfiguration().orientation == 1 ? new RelativeLayout.LayoutParams(-1, -2) : this.f13090d.msg_type == 2 ? new RelativeLayout.LayoutParams(this.f13094h, this.f13095i) : new RelativeLayout.LayoutParams(-2, -1);
            int m12337a = C3580bb.m12337a(30.0f);
            int m12337a2 = C3580bb.m12337a(15.0f);
            layoutParams.setMargins(m12337a, m12337a2, m12337a, m12337a2);
            layoutParams.addRule(13);
            this.f13093g = new FrameLayout(this.f13089c);
            this.f13093g.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int m12337a3 = C3580bb.m12337a(12.0f);
            layoutParams2.setMargins(m12337a3, m12337a3, m12337a3, m12337a3);
            ImageView imageView = new ImageView(this.f13089c);
            imageView.setLayoutParams(layoutParams2);
            imageView.setAdjustViewBounds(true);
            imageView.setId(C3586f.m12378a());
            imageView.setImageBitmap(this.f13092f);
            this.f13093g.addView(imageView);
            int m12337a4 = C3580bb.m12337a(24.0f);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(m12337a4, m12337a4, 5);
            C3582bd c3582bd = new C3582bd(this.f13089c);
            c3582bd.setLayoutParams(layoutParams3);
            this.f13093g.addView(c3582bd);
            relativeLayout.addView(this.f13093g);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UmengCardMessage.m12170a(UmengCardMessage.this);
                    if (TextUtils.equals("none", UmengCardMessage.this.f13090d.action_type)) {
                        return;
                    }
                    UmengCardMessage.this.f13098l.handleInAppMessage(UmengCardMessage.this.f13089c, UmengCardMessage.this.f13090d, 16);
                    UmengCardMessage.this.dismiss();
                }
            });
            c3582bd.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UmengCardMessage.m12174e(UmengCardMessage.this);
                    UmengCardMessage.this.dismiss();
                }
            });
            return relativeLayout;
        }
        if (i2 == 4) {
            View inflate = layoutInflater.inflate(C3551a.m12217a(C3551a.m12219a().f13144a, "umeng_custom_card_message"), viewGroup, false);
            ImageView imageView2 = (ImageView) inflate.findViewById(C3551a.m12218a("umeng_card_message_image"));
            Button button = (Button) inflate.findViewById(C3551a.m12218a("umeng_card_message_ok"));
            Button button2 = (Button) inflate.findViewById(C3551a.m12218a("umeng_card_message_close"));
            imageView2.setImageBitmap(this.f13092f);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UmengCardMessage.m12170a(UmengCardMessage.this);
                    if (TextUtils.equals("none", UmengCardMessage.this.f13090d.action_type)) {
                        return;
                    }
                    UmengCardMessage.this.f13098l.handleInAppMessage(UmengCardMessage.this.f13089c, UmengCardMessage.this.f13090d, 16);
                    UmengCardMessage.this.dismiss();
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UmengCardMessage.m12175f(UmengCardMessage.this);
                    if (TextUtils.equals("none", UmengCardMessage.this.f13090d.action_type)) {
                        return;
                    }
                    UmengCardMessage.this.f13098l.handleInAppMessage(UmengCardMessage.this.f13089c, UmengCardMessage.this.f13090d, 19);
                    UmengCardMessage.this.dismiss();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UmengCardMessage.m12174e(UmengCardMessage.this);
                    UmengCardMessage.this.dismiss();
                }
            });
            return inflate;
        }
        if ((i2 != 5 && i2 != 6) || rect == null) {
            return null;
        }
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f13089c);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout2.setBackgroundColor(Color.parseColor("#33000000"));
        if (getResources().getConfiguration().orientation == 1) {
            this.f13096j = rect.width() - C3580bb.m12337a(70.0f);
            if (this.f13090d.msg_type == 5) {
                this.f13097k = (this.f13096j / 6) * 5;
            } else {
                this.f13097k = (this.f13096j / 2) * 3;
            }
        } else {
            this.f13097k = rect.height() - C3580bb.m12337a(65.0f);
            this.f13096j = (this.f13097k / 5) * 6;
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.f13096j, this.f13097k);
        layoutParams4.addRule(13);
        LinearLayout linearLayout = new LinearLayout(this.f13089c);
        linearLayout.setLayoutParams(layoutParams4);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        int m12337a5 = C3580bb.m12337a(20.0f);
        layoutParams5.setMargins(m12337a5, m12337a5, m12337a5, m12337a5);
        TextView textView = new TextView(this.f13089c);
        textView.setLayoutParams(layoutParams5);
        textView.setGravity(17);
        textView.setText(this.f13090d.title);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        textView.setTextSize(Integer.parseInt(this.f13103q[0]));
        textView.setTextColor(Color.parseColor("#000000"));
        linearLayout.addView(textView);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams6.setMargins(m12337a5, 0, m12337a5, 0);
        layoutParams6.weight = 1.0f;
        ScrollView scrollView = new ScrollView(this.f13089c);
        scrollView.setLayoutParams(layoutParams6);
        scrollView.setScrollBarStyle(16777216);
        scrollView.setVerticalScrollBarEnabled(false);
        TextView textView2 = new TextView(this.f13089c);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView2.setText(this.f13090d.content);
        textView2.setTextSize(Integer.parseInt(this.f13103q[1]));
        textView2.setTextColor(Color.parseColor("#000000"));
        scrollView.addView(textView2);
        linearLayout.addView(scrollView);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(C3580bb.m12337a(1.0f), Color.parseColor("#D8D8D8"));
        gradientDrawable.setCornerRadius(20.0f);
        gradientDrawable.setColor(-1);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, C3580bb.m12337a(35.0f));
        layoutParams7.setMargins(m12337a5, C3580bb.m12337a(30.0f), m12337a5, m12337a5);
        TextView textView3 = new TextView(this.f13089c);
        textView3.setLayoutParams(layoutParams7);
        textView3.setGravity(17);
        textView3.setBackgroundColor(Color.parseColor("#FFFFFF"));
        textView3.setText(this.f13090d.button_text);
        textView3.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        textView3.setTextSize(Integer.parseInt(this.f13103q[2]));
        textView3.setTextColor(Color.parseColor("#000000"));
        textView3.setBackgroundDrawable(gradientDrawable);
        linearLayout.addView(textView3);
        relativeLayout2.addView(linearLayout);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UmengCardMessage.m12170a(UmengCardMessage.this);
                UmengCardMessage.this.f13098l.handleInAppMessage(UmengCardMessage.this.f13089c, UmengCardMessage.this.f13090d, 18);
                UmengCardMessage.this.dismiss();
            }
        });
        return relativeLayout2;
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        C3560ai m12243a = C3560ai.m12243a(this.f13089c);
        UInAppMessage uInAppMessage = this.f13090d;
        m12243a.m12249a(uInAppMessage.msg_id, uInAppMessage.msg_type, 0, this.f13100n ? 1 : 0, 0, 0, this.f13102p ? 1 : 0, 0, this.f13101o ? 1 : 0);
        this.f13102p = false;
        this.f13100n = false;
        this.f13101o = false;
        this.f13099m = false;
        IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback = this.f13088a;
        if (iUmengInAppMsgCloseCallback != null) {
            iUmengInAppMsgCloseCallback.onClose();
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onStart() {
        super.onStart();
        if (!this.f13099m) {
            C3560ai m12243a = C3560ai.m12243a(this.f13089c);
            UInAppMessage uInAppMessage = this.f13090d;
            m12243a.m12249a(uInAppMessage.msg_id, uInAppMessage.msg_type, 1, 0, 0, 0, 0, 0, 0);
        }
        this.f13099m = true;
    }
}
