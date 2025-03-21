package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class AddCrimePhoneActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AddCrimePhoneActivity f21779a;

    /* renamed from: b */
    private View f21780b;

    /* renamed from: c */
    private View f21781c;

    /* renamed from: d */
    private View f21782d;

    /* renamed from: e */
    private View f21783e;

    /* renamed from: f */
    private View f21784f;

    /* renamed from: g */
    private View f21785g;

    /* renamed from: ui.activity.AddCrimePhoneActivity_ViewBinding$a */
    class C6111a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AddCrimePhoneActivity f21786a;

        C6111a(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.f21786a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21786a.onClick(view);
        }
    }

    /* renamed from: ui.activity.AddCrimePhoneActivity_ViewBinding$b */
    class C6112b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AddCrimePhoneActivity f21788a;

        C6112b(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.f21788a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21788a.onClick(view);
        }
    }

    /* renamed from: ui.activity.AddCrimePhoneActivity_ViewBinding$c */
    class C6113c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AddCrimePhoneActivity f21790a;

        C6113c(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.f21790a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21790a.onClick(view);
        }
    }

    /* renamed from: ui.activity.AddCrimePhoneActivity_ViewBinding$d */
    class C6114d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AddCrimePhoneActivity f21792a;

        C6114d(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.f21792a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21792a.onClick(view);
        }
    }

    /* renamed from: ui.activity.AddCrimePhoneActivity_ViewBinding$e */
    class C6115e extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AddCrimePhoneActivity f21794a;

        C6115e(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.f21794a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21794a.onClick(view);
        }
    }

    /* renamed from: ui.activity.AddCrimePhoneActivity_ViewBinding$f */
    class C6116f extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AddCrimePhoneActivity f21796a;

        C6116f(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.f21796a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21796a.onClick(view);
        }
    }

    @UiThread
    public AddCrimePhoneActivity_ViewBinding(AddCrimePhoneActivity addCrimePhoneActivity) {
        this(addCrimePhoneActivity, addCrimePhoneActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AddCrimePhoneActivity addCrimePhoneActivity = this.f21779a;
        if (addCrimePhoneActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21779a = null;
        addCrimePhoneActivity.mIvBack = null;
        addCrimePhoneActivity.mTvTitle = null;
        addCrimePhoneActivity.mCallNum = null;
        addCrimePhoneActivity.mRecharge = null;
        addCrimePhoneActivity.mRelation = null;
        addCrimePhoneActivity.mDelivery = null;
        this.f21780b.setOnClickListener(null);
        this.f21780b = null;
        this.f21781c.setOnClickListener(null);
        this.f21781c = null;
        this.f21782d.setOnClickListener(null);
        this.f21782d = null;
        this.f21783e.setOnClickListener(null);
        this.f21783e = null;
        this.f21784f.setOnClickListener(null);
        this.f21784f = null;
        this.f21785g.setOnClickListener(null);
        this.f21785g = null;
    }

    @UiThread
    public AddCrimePhoneActivity_ViewBinding(AddCrimePhoneActivity addCrimePhoneActivity, View view) {
        this.f21779a = addCrimePhoneActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        addCrimePhoneActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f21780b = findRequiredView;
        findRequiredView.setOnClickListener(new C6111a(addCrimePhoneActivity));
        addCrimePhoneActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        addCrimePhoneActivity.mCallNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_call_num, "field 'mCallNum'", TextView.class);
        addCrimePhoneActivity.mRecharge = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_recharge_num, "field 'mRecharge'", TextView.class);
        addCrimePhoneActivity.mRelation = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_relation_num, "field 'mRelation'", TextView.class);
        addCrimePhoneActivity.mDelivery = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_delivery_num, "field 'mDelivery'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.rl_type_phone, "method 'onClick'");
        this.f21781c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6112b(addCrimePhoneActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.rl_type_recharge, "method 'onClick'");
        this.f21782d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6113c(addCrimePhoneActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.rl_type_relation, "method 'onClick'");
        this.f21783e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6114d(addCrimePhoneActivity));
        View findRequiredView5 = Utils.findRequiredView(view, C2113R.id.rl_type_delivery, "method 'onClick'");
        this.f21784f = findRequiredView5;
        findRequiredView5.setOnClickListener(new C6115e(addCrimePhoneActivity));
        View findRequiredView6 = Utils.findRequiredView(view, C2113R.id.btn_commit, "method 'onClick'");
        this.f21785g = findRequiredView6;
        findRequiredView6.setOnClickListener(new C6116f(addCrimePhoneActivity));
    }
}
