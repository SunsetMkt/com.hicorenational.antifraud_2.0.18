package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class AddCrimePhoneActivity_ViewBinding implements Unbinder {
    private AddCrimePhoneActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f13073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f13074g;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AddCrimePhoneActivity a;

        a(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ AddCrimePhoneActivity a;

        b(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ AddCrimePhoneActivity a;

        c(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ AddCrimePhoneActivity a;

        d(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class e extends DebouncingOnClickListener {
        final /* synthetic */ AddCrimePhoneActivity a;

        e(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class f extends DebouncingOnClickListener {
        final /* synthetic */ AddCrimePhoneActivity a;

        f(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public AddCrimePhoneActivity_ViewBinding(AddCrimePhoneActivity addCrimePhoneActivity) {
        this(addCrimePhoneActivity, addCrimePhoneActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AddCrimePhoneActivity addCrimePhoneActivity = this.a;
        if (addCrimePhoneActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        addCrimePhoneActivity.mIvBack = null;
        addCrimePhoneActivity.mTvTitle = null;
        addCrimePhoneActivity.mCallNum = null;
        addCrimePhoneActivity.mRecharge = null;
        addCrimePhoneActivity.mRelation = null;
        addCrimePhoneActivity.mDelivery = null;
        this.f13069b.setOnClickListener(null);
        this.f13069b = null;
        this.f13070c.setOnClickListener(null);
        this.f13070c = null;
        this.f13071d.setOnClickListener(null);
        this.f13071d = null;
        this.f13072e.setOnClickListener(null);
        this.f13072e = null;
        this.f13073f.setOnClickListener(null);
        this.f13073f = null;
        this.f13074g.setOnClickListener(null);
        this.f13074g = null;
    }

    @UiThread
    public AddCrimePhoneActivity_ViewBinding(AddCrimePhoneActivity addCrimePhoneActivity, View view) {
        this.a = addCrimePhoneActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        addCrimePhoneActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13069b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(addCrimePhoneActivity));
        addCrimePhoneActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        addCrimePhoneActivity.mCallNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_call_num, "field 'mCallNum'", TextView.class);
        addCrimePhoneActivity.mRecharge = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_recharge_num, "field 'mRecharge'", TextView.class);
        addCrimePhoneActivity.mRelation = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_relation_num, "field 'mRelation'", TextView.class);
        addCrimePhoneActivity.mDelivery = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_delivery_num, "field 'mDelivery'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rl_type_phone, "method 'onClick'");
        this.f13070c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(addCrimePhoneActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rl_type_recharge, "method 'onClick'");
        this.f13071d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(addCrimePhoneActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.rl_type_relation, "method 'onClick'");
        this.f13072e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(addCrimePhoneActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.rl_type_delivery, "method 'onClick'");
        this.f13073f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(addCrimePhoneActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.btn_commit, "method 'onClick'");
        this.f13074g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(addCrimePhoneActivity));
    }
}
