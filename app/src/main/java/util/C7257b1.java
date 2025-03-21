package util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AlertDialog;
import bean.NoteDlgBean;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import interfaces.IEditClickListener;
import interfaces.IImageClickListener;
import interfaces.IOneClickListener;
import interfaces.ITimerState;
import manager.BaseDialog;
import p245d.C4443d;
import p357j.C5845d;
import p388ui.view.AbstractC7237p;
import p388ui.view.DialogC7241s;

/* compiled from: DialogUtils.java */
/* renamed from: util.b1 */
/* loaded from: classes2.dex */
public class C7257b1 {

    /* renamed from: a */
    private static DialogC7241s f25123a;

    /* compiled from: DialogUtils.java */
    /* renamed from: util.b1$a */
    static class a extends AbstractC7237p {

        /* renamed from: g */
        final /* synthetic */ Context f25124g;

        /* renamed from: h */
        final /* synthetic */ ITimerState f25125h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j2, long j3, Context context, ITimerState iTimerState) {
            super(j2, j3);
            this.f25124g = context;
            this.f25125h = iTimerState;
        }

        @Override // p388ui.view.AbstractC7237p
        /* renamed from: a */
        public void mo25433a(long j2) {
            Context context = this.f25124g;
            if (context == null || ((Activity) context).isFinishing()) {
                return;
            }
            this.f25125h.timeCount((int) (j2 / 1000));
        }

        @Override // p388ui.view.AbstractC7237p
        /* renamed from: d */
        public void mo25434d() {
            this.f25125h.timeOver();
        }
    }

    /* compiled from: DialogUtils.java */
    /* renamed from: util.b1$b */
    static class b implements ITimerState {

        /* renamed from: a */
        final /* synthetic */ Activity f25126a;

        /* renamed from: b */
        final /* synthetic */ Dialog f25127b;

        /* renamed from: c */
        final /* synthetic */ boolean f25128c;

        b(Activity activity, Dialog dialog, boolean z) {
            this.f25126a = activity;
            this.f25127b = dialog;
            this.f25128c = z;
        }

        @Override // interfaces.ITimerState
        public void timeCount(int i2) {
        }

        @Override // interfaces.ITimerState
        public void timeOver() {
            Activity activity = this.f25126a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            Dialog dialog = this.f25127b;
            if (dialog != null) {
                dialog.dismiss();
            }
            if (this.f25128c) {
                this.f25126a.finish();
            }
        }
    }

    /* compiled from: DialogUtils.java */
    /* renamed from: util.b1$c */
    static class c implements ITimerState {

        /* renamed from: a */
        final /* synthetic */ Button f25129a;

        /* renamed from: b */
        final /* synthetic */ String f25130b;

        c(Button button, String str) {
            this.f25129a = button;
            this.f25130b = str;
        }

        @Override // interfaces.ITimerState
        public void timeCount(int i2) {
            this.f25129a.setText(Html.fromHtml(this.f25130b + "&#160;&#160;&#160;<font color=#2946E6>(" + i2 + "s)</font>"));
        }

        @Override // interfaces.ITimerState
        public void timeOver() {
            Button button = this.f25129a;
            if (button != null) {
                button.setEnabled(true);
                this.f25129a.setTextColor(Color.parseColor("#2946E6"));
                this.f25129a.setText(this.f25130b);
            }
        }
    }

    /* compiled from: DialogUtils.java */
    /* renamed from: util.b1$d */
    static class d implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ IOneClickListener f25131a;

        /* renamed from: b */
        final /* synthetic */ BaseDialog f25132b;

        d(IOneClickListener iOneClickListener, BaseDialog baseDialog) {
            this.f25131a = iOneClickListener;
            this.f25132b = baseDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IOneClickListener iOneClickListener = this.f25131a;
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
            }
            this.f25132b.dismiss();
        }
    }

    /* compiled from: DialogUtils.java */
    /* renamed from: util.b1$e */
    static class e implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ IOneClickListener f25133a;

        /* renamed from: b */
        final /* synthetic */ BaseDialog f25134b;

        e(IOneClickListener iOneClickListener, BaseDialog baseDialog) {
            this.f25133a = iOneClickListener;
            this.f25134b = baseDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IOneClickListener iOneClickListener = this.f25133a;
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
            }
            this.f25134b.dismiss();
        }
    }

    /* renamed from: a */
    public static AlertDialog m26190a(Context context, @DrawableRes int i2, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(i2);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(str3, onClickListener);
        builder.setNegativeButton(str4, onClickListener2);
        return builder.create();
    }

    /* renamed from: b */
    public static Dialog m26210b(Activity activity, String str, String str2, IOneClickListener iOneClickListener) {
        return m26182a(activity, str, (String) null, str2, iOneClickListener);
    }

    /* renamed from: c */
    static /* synthetic */ void m26222c(IOneClickListener iOneClickListener, BaseDialog baseDialog, View view) {
        if (iOneClickListener != null) {
            iOneClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: d */
    static /* synthetic */ void m26225d(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: e */
    static /* synthetic */ void m26229e(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: f */
    static /* synthetic */ void m26231f(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: g */
    static /* synthetic */ void m26232g(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: h */
    static /* synthetic */ void m26233h(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: i */
    static /* synthetic */ void m26234i(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: j */
    static /* synthetic */ void m26235j(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: k */
    static /* synthetic */ void m26236k(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: l */
    static /* synthetic */ void m26237l(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: m */
    static /* synthetic */ void m26238m(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: n */
    static /* synthetic */ void m26239n(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: o */
    static /* synthetic */ void m26240o(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: p */
    static /* synthetic */ void m26241p(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: q */
    static /* synthetic */ void m26242q(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: r */
    static /* synthetic */ void m26243r(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: s */
    static /* synthetic */ void m26244s(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: t */
    static /* synthetic */ void m26245t(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: u */
    static /* synthetic */ void m26246u(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: v */
    static /* synthetic */ void m26247v(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: w */
    static /* synthetic */ void m26248w(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: b */
    public static Dialog m26211b(Activity activity, String str, String str2, String str3, String str4, IClickListener iClickListener) {
        return m26183a(activity, str, str2, str3, str4, -1, -1, iClickListener);
    }

    /* renamed from: c */
    public static BaseDialog m26219c(Activity activity, String str, String str2, String str3, String str4, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_bt_dialog_red);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.tv_title);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.tv_subtitle);
        Button button = (Button) baseDialog.findViewById(C2113R.id.btn_cancel);
        Button button2 = (Button) baseDialog.findViewById(C2113R.id.btn_confirm);
        textView.setText(str);
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26236k(IClickListener.this, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26196a(IClickListener.this, view);
            }
        });
        return baseDialog;
    }

    /* renamed from: d */
    static /* synthetic */ void m26226d(IOneClickListener iOneClickListener, BaseDialog baseDialog, View view) {
        if (iOneClickListener != null) {
            iOneClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: e */
    public static Dialog m26228e(Activity activity, String str, String str2, String str3, String str4, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_btn_bg_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialogdp(-2.0f);
        baseDialog.setHeightDialogdp(-2.0f);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(C2113R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26239n(IClickListener.this, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26240o(IClickListener.this, baseDialog, view);
            }
        });
        return baseDialog;
    }

    /* renamed from: f */
    public static Dialog m26230f(Activity activity, String str, String str2, String str3, String str4, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.flow_primiss_dialog_tips);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(C2113R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        textView.setText(str);
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26206a(BaseDialog.this, iClickListener, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26218b(BaseDialog.this, iClickListener, view);
            }
        });
        return baseDialog;
    }

    /* renamed from: b */
    static /* synthetic */ void m26214b(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: d */
    public static Dialog m26224d(Activity activity, String str, String str2, String str3, String str4, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.report_case_tips_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.dialog_title);
        baseDialog.findViewById(C2113R.id.ll_content);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.tv_report_time);
        TextView textView3 = (TextView) baseDialog.findViewById(C2113R.id.tv_case_num);
        TextView textView4 = (TextView) baseDialog.findViewById(C2113R.id.tv_polic_num);
        Button button = (Button) baseDialog.findViewById(C2113R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        textView.setText(str);
        textView2.setText(str2);
        boolean isEmpty = TextUtils.isEmpty(str3);
        String str5 = C4443d.f16920D;
        if (isEmpty) {
            str3 = C4443d.f16920D;
        }
        textView3.setText(str3);
        if (!TextUtils.isEmpty(str4)) {
            str5 = str4;
        }
        textView4.setText(str5);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26237l(IClickListener.this, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26238m(IClickListener.this, baseDialog, view);
            }
        });
        return baseDialog;
    }

    /* renamed from: b */
    public static Dialog m26208b(Activity activity, int i2, String str, String str2, String str3, String str4, int i3, int i4, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_icon_bt_dialog2);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        ImageView imageView = (ImageView) baseDialog.findViewById(C2113R.id.iv_top_icon);
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(C2113R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        if (i2 != -1) {
            imageView.setImageResource(i2);
        } else {
            imageView.setVisibility(8);
        }
        textView.setText(str);
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        if (i3 == -1) {
            button.setTextColor(-14072090);
            button.setAlpha(0.5f);
        } else {
            button.setTextColor(activity.getResources().getColor(i3));
        }
        if (i4 == -1) {
            button2.setTextColor(-14072090);
        } else {
            button2.setTextColor(activity.getResources().getColor(i4));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: util.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26245t(IClickListener.this, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26246u(IClickListener.this, baseDialog, view);
            }
        });
        return baseDialog;
    }

    /* renamed from: a */
    private static synchronized void m26195a(Context context, int i2, ITimerState iTimerState) {
        synchronized (C7257b1.class) {
            new a(i2 * 1000, 1000L, context, iTimerState);
        }
    }

    /* renamed from: a */
    public static void m26194a(Activity activity, boolean z, int i2, Dialog dialog) {
        m26195a(activity, i2, new b(activity, dialog, z));
    }

    /* renamed from: a */
    public static void m26192a(Activity activity, int i2, Button button, String str) {
        m26195a(activity, i2, new c(button, str));
    }

    /* renamed from: a */
    public static Dialog m26182a(Activity activity, String str, String str2, String str3, IOneClickListener iOneClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_dialog_one);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.title);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.subtitle);
        Button button = (Button) baseDialog.findViewById(C2113R.id.button);
        button.setText(str3);
        textView.setText(str);
        if (!TextUtils.isEmpty(str2)) {
            textView2.setVisibility(0);
            textView2.setText(str2);
        }
        button.setOnClickListener(new d(iOneClickListener, baseDialog));
        return baseDialog;
    }

    /* renamed from: c */
    static /* synthetic */ void m26221c(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: c */
    static /* synthetic */ void m26220c(IClickListener iClickListener, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
    }

    /* renamed from: a */
    public static Dialog m26187a(Context context, String str, String str2, String str3, IOneClickListener iOneClickListener) {
        if (context == null) {
            return null;
        }
        BaseDialog baseDialog = new BaseDialog(context, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_dialog_one);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.title);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.subtitle);
        Button button = (Button) baseDialog.findViewById(C2113R.id.button);
        button.setText(str3);
        textView.setText(str);
        if (TextUtils.isEmpty(str2)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(str2);
        }
        button.setOnClickListener(new e(iOneClickListener, baseDialog));
        return baseDialog;
    }

    /* renamed from: b */
    public static Dialog m26209b(Activity activity, int i2, String str, String str2, String str3, String str4, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_icon_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialogdp(-2.0f);
        baseDialog.setHeightDialogdp(-2.0f);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        ImageView imageView = (ImageView) baseDialog.findViewById(C2113R.id.iv_top_icon);
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(C2113R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        if (i2 != -1) {
            imageView.setImageResource(i2);
        } else {
            imageView.setVisibility(8);
        }
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26241p(IClickListener.this, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26242q(IClickListener.this, baseDialog, view);
            }
        });
        return baseDialog;
    }

    /* renamed from: a */
    public static Dialog m26169a(Activity activity, int i2, String str, String str2, String str3, int i3, final IOneClickListener iOneClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_icon_one_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        ImageView imageView = (ImageView) baseDialog.findViewById(C2113R.id.iv_top_icon);
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        ImageView imageView2 = (ImageView) baseDialog.findViewById(C2113R.id.iv_close);
        if (i2 != -1) {
            imageView.setImageResource(i2);
        } else {
            imageView.setVisibility(8);
        }
        textView.setText(str);
        textView2.setText(str2);
        button.setText(str3);
        if (i3 == -1) {
            button.setTextColor(-14072090);
        } else {
            button.setTextColor(activity.getResources().getColor(i3));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: util.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26222c(IOneClickListener.this, baseDialog, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: util.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseDialog.this.dismiss();
            }
        });
        return baseDialog;
    }

    /* renamed from: b */
    static /* synthetic */ void m26215b(IImageClickListener iImageClickListener, BaseDialog baseDialog, View view) {
        if (iImageClickListener != null) {
            iImageClickListener.clickImage();
        }
        baseDialog.dismiss();
    }

    /* renamed from: b */
    public static Dialog m26212b(Activity activity, boolean z, int i2, String str, int i3) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_iv_h_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(true);
        baseDialog.setCanceledOnTouchOutside(true);
        baseDialog.initOnCreate();
        baseDialog.show();
        ImageView imageView = (ImageView) baseDialog.findViewById(C2113R.id.iv_img);
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.tv_title);
        imageView.setBackgroundResource(i3);
        textView.setText(str);
        m26194a(activity, z, i2, baseDialog);
        return baseDialog;
    }

    /* renamed from: a */
    public static Dialog m26181a(Activity activity, String str, String str2, String str3, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_bt_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.customdialog_title);
        ((TextView) baseDialog.findViewById(C2113R.id.customdialog_subtitle)).setVisibility(8);
        Button button = (Button) baseDialog.findViewById(C2113R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        textView.setText(str);
        button.setText(str2);
        button2.setText(str3);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26232g(IClickListener.this, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26233h(IClickListener.this, baseDialog, view);
            }
        });
        return baseDialog;
    }

    /* renamed from: b */
    static /* synthetic */ void m26218b(BaseDialog baseDialog, IClickListener iClickListener, View view) {
        baseDialog.dismiss();
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m26216b(IOneClickListener iOneClickListener, BaseDialog baseDialog, View view) {
        if (iOneClickListener != null) {
            iOneClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: b */
    static /* synthetic */ void m26213b(IClickListener iClickListener, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m26196a(IClickListener iClickListener, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
    }

    /* renamed from: a */
    public static Dialog m26185a(Activity activity, String str, String str2, String str3, String str4, IClickListener iClickListener) {
        return m26184a(activity, str, str2, str3, str4, -1, -1, false, iClickListener);
    }

    /* renamed from: a */
    public static Dialog m26183a(Activity activity, String str, String str2, String str3, String str4, int i2, int i3, IClickListener iClickListener) {
        return m26177a(activity, str, (CharSequence) str2, false, str3, str4, i2, i3, iClickListener);
    }

    /* renamed from: a */
    public static Dialog m26177a(Activity activity, String str, CharSequence charSequence, boolean z, String str2, String str3, int i2, int i3, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_bt_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialogdp(-2.0f);
        baseDialog.setHeightDialogdp(-2.0f);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(C2113R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        if (z) {
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setText(charSequence);
        } else {
            textView2.setText(charSequence);
        }
        if (TextUtils.isEmpty(charSequence)) {
            textView2.setVisibility(8);
        }
        textView.setText(str);
        button.setText(str2);
        button2.setText(str3);
        if (i2 == -1) {
            button.setTextColor(-14072090);
        } else {
            button.setTextColor(activity.getResources().getColor(i2));
        }
        if (i3 == -1) {
            button2.setTextColor(-14072090);
        } else {
            button2.setTextColor(activity.getResources().getColor(i3));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: util.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26234i(IClickListener.this, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26235j(IClickListener.this, baseDialog, view);
            }
        });
        return baseDialog;
    }

    /* renamed from: a */
    public static Dialog m26178a(Activity activity, String str, CharSequence charSequence, boolean z, String str2, String str3, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_clause_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialogdp(-2.0f);
        baseDialog.setHeightDialogdp(-2.0f);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(C2113R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        textView2.setGravity(3);
        if (z) {
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setText(charSequence);
        } else {
            textView2.setText(charSequence);
        }
        if (TextUtils.isEmpty(charSequence)) {
            textView2.setVisibility(8);
        }
        textView.setText(str);
        button.setText(str2);
        button2.setText(str3);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26243r(IClickListener.this, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26244s(IClickListener.this, baseDialog, view);
            }
        });
        return baseDialog;
    }

    @SuppressLint({"ResourceAsColor"})
    /* renamed from: a */
    public static Dialog m26184a(Activity activity, String str, String str2, String str3, String str4, int i2, int i3, boolean z, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_bt_title_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialogdp(-2.0f);
        baseDialog.setHeightDialogdp(-2.0f);
        baseDialog.setCancelable(z);
        baseDialog.setCanceledOnTouchOutside(z);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.customdialog_subtitle);
        View findViewById = baseDialog.findViewById(C2113R.id.ll_subtit);
        Button button = (Button) baseDialog.findViewById(C2113R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        if (!TextUtils.isEmpty(str2)) {
            findViewById.setVisibility(0);
        }
        textView.setText(str);
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        if (i2 == -1) {
            button.setTextColor(-14072090);
        } else {
            button.setTextColor(activity.getResources().getColor(i2));
        }
        if (i3 == -1) {
            button2.setTextColor(-14072090);
        } else {
            button2.setTextColor(activity.getResources().getColor(i3));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: util.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26197a(IClickListener.this, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26214b(IClickListener.this, baseDialog, view);
            }
        });
        return baseDialog;
    }

    /* renamed from: a */
    static /* synthetic */ void m26197a(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: a */
    public static Dialog m26189a(Context context, String str, String str2, String str3, String str4, IClickListener iClickListener) {
        return m26188a(context, str, str2, str3, str4, -1, -1, iClickListener);
    }

    /* renamed from: a */
    public static Dialog m26188a(Context context, String str, String str2, String str3, String str4, int i2, int i3, final IClickListener iClickListener) {
        if (context == null) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(context, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_bt_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialogdp(-2.0f);
        baseDialog.setHeightDialogdp(-2.0f);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(C2113R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        textView.setText(str);
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        if (i2 == -1) {
            button.setTextColor(-14072090);
        } else {
            button.setTextColor(context.getResources().getColor(i2));
        }
        if (i3 == -1) {
            button2.setTextColor(-14072090);
        } else {
            button2.setTextColor(context.getResources().getColor(i3));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: util.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26221c(IClickListener.this, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26225d(IClickListener.this, baseDialog, view);
            }
        });
        return baseDialog;
    }

    /* renamed from: a */
    public static Dialog m26171a(Activity activity, int i2, String str, String str2, String str3, String str4, IClickListener iClickListener) {
        return m26170a(activity, i2, str, str2, str3, str4, -1, -1, iClickListener);
    }

    /* renamed from: a */
    public static Dialog m26170a(Activity activity, int i2, String str, String str2, String str3, String str4, int i3, int i4, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_icon_bt_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        ImageView imageView = (ImageView) baseDialog.findViewById(C2113R.id.iv_top_icon);
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(C2113R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        ImageView imageView2 = (ImageView) baseDialog.findViewById(C2113R.id.iv_close);
        if (i2 != -1) {
            imageView.setImageResource(i2);
        } else {
            imageView.setVisibility(8);
        }
        textView.setText(str);
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        if (i3 == -1) {
            button.setTextColor(-14072090);
        } else {
            button.setTextColor(activity.getResources().getColor(i3));
        }
        if (i4 == -1) {
            button2.setTextColor(-14072090);
        } else {
            button2.setTextColor(activity.getResources().getColor(i4));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: util.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26229e(IClickListener.this, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26231f(IClickListener.this, baseDialog, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: util.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseDialog.this.dismiss();
            }
        });
        return baseDialog;
    }

    /* renamed from: a */
    public static Dialog m26176a(Activity activity, String str, final IImageClickListener iImageClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_image_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialogdp(-2.0f);
        baseDialog.setHeightDialogdp(-2.0f);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        ImageView imageView = (ImageView) baseDialog.findViewById(C2113R.id.iv_close);
        ImageView imageView2 = (ImageView) baseDialog.findViewById(C2113R.id.iv_content);
        C5845d.m24613b(imageView2, str);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: util.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26200a(IImageClickListener.this, baseDialog, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: util.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26215b(IImageClickListener.this, baseDialog, view);
            }
        });
        return baseDialog;
    }

    /* renamed from: a */
    static /* synthetic */ void m26200a(IImageClickListener iImageClickListener, BaseDialog baseDialog, View view) {
        if (iImageClickListener != null) {
            iImageClickListener.clickClose();
        }
        baseDialog.dismiss();
    }

    /* renamed from: a */
    public static Dialog m26186a(Activity activity, boolean z, int i2, String str, int i3) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_iv_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(true);
        baseDialog.setCanceledOnTouchOutside(true);
        baseDialog.initOnCreate();
        baseDialog.show();
        ImageView imageView = (ImageView) baseDialog.findViewById(C2113R.id.iv_img);
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.tv_title);
        imageView.setBackgroundResource(i3);
        textView.setText(str);
        m26194a(activity, z, i2, baseDialog);
        return baseDialog;
    }

    /* renamed from: a */
    public static Dialog m26172a(final Activity activity, int i2, final String str, String str2, String str3, String str4, final IOneClickListener iOneClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_dialog_one_time);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.title);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.subtitle);
        Button button = (Button) baseDialog.findViewById(C2113R.id.button);
        textView.setText(Html.fromHtml(str2));
        if (!TextUtils.isEmpty(str3)) {
            textView2.setVisibility(0);
            textView2.setText(str3);
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: util.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26226d(IOneClickListener.this, baseDialog, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: util.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26202a(str, activity, view);
            }
        });
        if (i2 > 0) {
            button.setText(Html.fromHtml(str4 + "&#160;&#160;&#160;<font color=#2946E6>(" + str2 + "s)</font>"));
            button.setEnabled(false);
            button.setTextColor(Color.parseColor("#999999"));
            m26192a(activity, i2, button, str4);
        } else {
            button.setText(str4);
            button.setTextColor(Color.parseColor("#2946E6"));
        }
        return baseDialog;
    }

    /* renamed from: a */
    static /* synthetic */ void m26202a(String str, Activity activity, View view) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C7337y1.m26750a(activity, str);
    }

    /* renamed from: a */
    public static Dialog m26175a(Activity activity, IOneClickListener iOneClickListener) {
        return m26180a(activity, "诈骗预警功能开启", "诈骗预警功能需要开启悬浮窗、电话、短信权限，可用来识别诈骗来电、诈骗短信、诈骗APP", iOneClickListener);
    }

    /* renamed from: a */
    public static Dialog m26180a(Activity activity, String str, String str2, final IOneClickListener iOneClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.flow_primiss_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        textView.setText(str);
        textView2.setText(str2);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26201a(IOneClickListener.this, baseDialog, view);
            }
        });
        return baseDialog;
    }

    /* renamed from: a */
    static /* synthetic */ void m26201a(IOneClickListener iOneClickListener, BaseDialog baseDialog, View view) {
        if (iOneClickListener != null) {
            iOneClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: a */
    static /* synthetic */ void m26206a(BaseDialog baseDialog, IClickListener iClickListener, View view) {
        baseDialog.dismiss();
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
    }

    /* renamed from: a */
    public static void m26193a(Activity activity, String str) {
        m26203a(str, true, activity);
    }

    /* renamed from: a */
    public static void m26203a(String str, boolean z, Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                if (f25123a == null) {
                    f25123a = DialogC7241s.m26028a(activity);
                }
                f25123a.m26029a(str);
                f25123a.setCanceledOnTouchOutside(false);
                f25123a.setCancelable(z);
                f25123a.show();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m26191a() {
        try {
            if (f25123a != null) {
                if (f25123a.isShowing()) {
                    f25123a.dismiss();
                }
                f25123a = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public static Dialog m26179a(Activity activity, String str, String str2, final IEditClickListener iEditClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_edit_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        final EditText editText = (EditText) baseDialog.findViewById(C2113R.id.et_content);
        Button button = (Button) baseDialog.findViewById(C2113R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        C7268d1.m26315b(editText, 8);
        button.setText(str);
        button2.setText(str2);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26199a(IEditClickListener.this, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26198a(IEditClickListener.this, editText, baseDialog, view);
            }
        });
        return baseDialog;
    }

    /* renamed from: a */
    static /* synthetic */ void m26199a(IEditClickListener iEditClickListener, BaseDialog baseDialog, View view) {
        if (iEditClickListener != null) {
            iEditClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    /* renamed from: a */
    static /* synthetic */ void m26198a(IEditClickListener iEditClickListener, EditText editText, BaseDialog baseDialog, View view) {
        if (iEditClickListener != null) {
            iEditClickListener.clickOKBtn(editText.getText().toString());
        }
        baseDialog.dismiss();
    }

    /* renamed from: a */
    public static Dialog m26174a(Activity activity, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.verify_tips_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        Button button = (Button) baseDialog.findViewById(C2113R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        ImageView imageView = (ImageView) baseDialog.findViewById(C2113R.id.iv_colse);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26247v(IClickListener.this, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26248w(IClickListener.this, baseDialog, view);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: util.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseDialog.this.dismiss();
            }
        });
        return baseDialog;
    }

    /* renamed from: a */
    public static Dialog m26173a(Activity activity, NoteDlgBean noteDlgBean, final IOneClickListener iOneClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_note_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialogdp(-2.0f);
        baseDialog.setHeightDialogdp(-2.0f);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.title);
        final TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.content);
        Button button = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        textView.setText(Html.fromHtml(noteDlgBean.getTitle()));
        textView2.setText(Html.fromHtml(noteDlgBean.getContent()));
        textView2.setMovementMethod(new ScrollingMovementMethod());
        textView2.setOnTouchListener(new View.OnTouchListener() { // from class: util.k
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return C7257b1.m26207a(textView2, view, motionEvent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: util.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26216b(IOneClickListener.this, baseDialog, view);
            }
        });
        return baseDialog;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m26207a(TextView textView, View view, MotionEvent motionEvent) {
        textView.getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }

    /* renamed from: a */
    public static Dialog m26167a(int i2, final Activity activity, String str, String str2, String str3, String str4, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_bt_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(C2113R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(C2113R.id.customdialog_subtitle);
        ImageView imageView = (ImageView) baseDialog.findViewById(C2113R.id.iv_close);
        Button button = (Button) baseDialog.findViewById(C2113R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(C2113R.id.confirm_btn);
        imageView.setVisibility(0);
        textView.setText(str);
        textView2.setText(str2);
        textView2.setTextColor(Color.parseColor("#999999"));
        button.setText(str3);
        button2.setText(str4);
        button2.setTextColor(-14072090);
        button.setTextColor(-14072090);
        if (i2 <= 0) {
            button.setEnabled(false);
            button.setTextColor(Color.parseColor("#999999"));
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: util.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26204a(BaseDialog.this, activity, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: util.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26213b(IClickListener.this, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7257b1.m26220c(IClickListener.this, view);
            }
        });
        return baseDialog;
    }

    /* renamed from: a */
    static /* synthetic */ void m26204a(BaseDialog baseDialog, Activity activity, View view) {
        baseDialog.dismiss();
        activity.finish();
    }

    /* renamed from: a */
    public static Dialog m26168a(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, C2113R.style.base_dialog_style);
        baseDialog.setContentView(C2113R.layout.custom_wb_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        ((TextView) baseDialog.findViewById(C2113R.id.tv_done)).setOnClickListener(new View.OnClickListener() { // from class: util.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseDialog.this.dismiss();
            }
        });
        return baseDialog;
    }
}
