package p388ui.activity;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class MinePersonalActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private MinePersonalActivity f22571a;

    /* renamed from: b */
    private View f22572b;

    /* renamed from: c */
    private View f22573c;

    /* renamed from: d */
    private View f22574d;

    /* renamed from: e */
    private View f22575e;

    /* renamed from: ui.activity.MinePersonalActivity_ViewBinding$a */
    class C6391a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ MinePersonalActivity f22576a;

        C6391a(MinePersonalActivity minePersonalActivity) {
            this.f22576a = minePersonalActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22576a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.MinePersonalActivity_ViewBinding$b */
    class C6392b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ MinePersonalActivity f22578a;

        C6392b(MinePersonalActivity minePersonalActivity) {
            this.f22578a = minePersonalActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22578a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.MinePersonalActivity_ViewBinding$c */
    class C6393c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ MinePersonalActivity f22580a;

        C6393c(MinePersonalActivity minePersonalActivity) {
            this.f22580a = minePersonalActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22580a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.MinePersonalActivity_ViewBinding$d */
    class C6394d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ MinePersonalActivity f22582a;

        C6394d(MinePersonalActivity minePersonalActivity) {
            this.f22582a = minePersonalActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22582a.onViewClicked(view);
        }
    }

    @UiThread
    public MinePersonalActivity_ViewBinding(MinePersonalActivity minePersonalActivity) {
        this(minePersonalActivity, minePersonalActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MinePersonalActivity minePersonalActivity = this.f22571a;
        if (minePersonalActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22571a = null;
        minePersonalActivity.mTvTitle = null;
        minePersonalActivity.mTvIdFineVar = null;
        minePersonalActivity.mUserName = null;
        minePersonalActivity.mLlIdFineVar = null;
        minePersonalActivity.mIdentityCardNum = null;
        minePersonalActivity.mArea = null;
        minePersonalActivity.mAreaDetail = null;
        minePersonalActivity.mTvRegArea = null;
        minePersonalActivity.mTvProgress = null;
        minePersonalActivity.mProgress = null;
        minePersonalActivity.mTopCoinTip = null;
        minePersonalActivity.mTvNameLable = null;
        minePersonalActivity.mTvIdLable = null;
        minePersonalActivity.mTvAreaLable = null;
        this.f22572b.setOnClickListener(null);
        this.f22572b = null;
        this.f22573c.setOnClickListener(null);
        this.f22573c = null;
        this.f22574d.setOnClickListener(null);
        this.f22574d = null;
        this.f22575e.setOnClickListener(null);
        this.f22575e = null;
    }

    @UiThread
    public MinePersonalActivity_ViewBinding(MinePersonalActivity minePersonalActivity, View view) {
        this.f22571a = minePersonalActivity;
        minePersonalActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.tv_idfine_var, "field 'mTvIdFineVar' and method 'onViewClicked'");
        minePersonalActivity.mTvIdFineVar = (TextView) Utils.castView(findRequiredView, C2113R.id.tv_idfine_var, "field 'mTvIdFineVar'", TextView.class);
        this.f22572b = findRequiredView;
        findRequiredView.setOnClickListener(new C6391a(minePersonalActivity));
        minePersonalActivity.mUserName = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.user_name, "field 'mUserName'", TextView.class);
        minePersonalActivity.mLlIdFineVar = Utils.findRequiredView(view, C2113R.id.ll_idfine_var, "field 'mLlIdFineVar'");
        minePersonalActivity.mIdentityCardNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.user_ID, "field 'mIdentityCardNum'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.area, "field 'mArea' and method 'onViewClicked'");
        minePersonalActivity.mArea = (TextView) Utils.castView(findRequiredView2, C2113R.id.area, "field 'mArea'", TextView.class);
        this.f22573c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6392b(minePersonalActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.area_detail, "field 'mAreaDetail' and method 'onViewClicked'");
        minePersonalActivity.mAreaDetail = (TextView) Utils.castView(findRequiredView3, C2113R.id.area_detail, "field 'mAreaDetail'", TextView.class);
        this.f22574d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6393c(minePersonalActivity));
        minePersonalActivity.mTvRegArea = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.reg_area, "field 'mTvRegArea'", TextView.class);
        minePersonalActivity.mTvProgress = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_progress, "field 'mTvProgress'", TextView.class);
        minePersonalActivity.mProgress = (ProgressBar) Utils.findRequiredViewAsType(view, C2113R.id.pb_progress, "field 'mProgress'", ProgressBar.class);
        minePersonalActivity.mTopCoinTip = Utils.findRequiredView(view, C2113R.id.ll_top_cointips, "field 'mTopCoinTip'");
        minePersonalActivity.mTvNameLable = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.name_label, "field 'mTvNameLable'", TextView.class);
        minePersonalActivity.mTvIdLable = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.ID_label, "field 'mTvIdLable'", TextView.class);
        minePersonalActivity.mTvAreaLable = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.area_label, "field 'mTvAreaLable'", TextView.class);
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22575e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6394d(minePersonalActivity));
    }
}
