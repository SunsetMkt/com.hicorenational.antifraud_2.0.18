package ui.activity;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class MinePersonalActivity_ViewBinding implements Unbinder {
    private MinePersonalActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13511e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ MinePersonalActivity a;

        a(MinePersonalActivity minePersonalActivity) {
            this.a = minePersonalActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ MinePersonalActivity a;

        b(MinePersonalActivity minePersonalActivity) {
            this.a = minePersonalActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ MinePersonalActivity a;

        c(MinePersonalActivity minePersonalActivity) {
            this.a = minePersonalActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ MinePersonalActivity a;

        d(MinePersonalActivity minePersonalActivity) {
            this.a = minePersonalActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public MinePersonalActivity_ViewBinding(MinePersonalActivity minePersonalActivity) {
        this(minePersonalActivity, minePersonalActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MinePersonalActivity minePersonalActivity = this.a;
        if (minePersonalActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
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
        this.f13508b.setOnClickListener(null);
        this.f13508b = null;
        this.f13509c.setOnClickListener(null);
        this.f13509c = null;
        this.f13510d.setOnClickListener(null);
        this.f13510d = null;
        this.f13511e.setOnClickListener(null);
        this.f13511e = null;
    }

    @UiThread
    public MinePersonalActivity_ViewBinding(MinePersonalActivity minePersonalActivity, View view) {
        this.a = minePersonalActivity;
        minePersonalActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_idfine_var, "field 'mTvIdFineVar' and method 'onViewClicked'");
        minePersonalActivity.mTvIdFineVar = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_idfine_var, "field 'mTvIdFineVar'", TextView.class);
        this.f13508b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(minePersonalActivity));
        minePersonalActivity.mUserName = (TextView) Utils.findRequiredViewAsType(view, R.id.user_name, "field 'mUserName'", TextView.class);
        minePersonalActivity.mLlIdFineVar = Utils.findRequiredView(view, R.id.ll_idfine_var, "field 'mLlIdFineVar'");
        minePersonalActivity.mIdentityCardNum = (TextView) Utils.findRequiredViewAsType(view, R.id.user_ID, "field 'mIdentityCardNum'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.area, "field 'mArea' and method 'onViewClicked'");
        minePersonalActivity.mArea = (TextView) Utils.castView(viewFindRequiredView2, R.id.area, "field 'mArea'", TextView.class);
        this.f13509c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(minePersonalActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.area_detail, "field 'mAreaDetail' and method 'onViewClicked'");
        minePersonalActivity.mAreaDetail = (TextView) Utils.castView(viewFindRequiredView3, R.id.area_detail, "field 'mAreaDetail'", TextView.class);
        this.f13510d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(minePersonalActivity));
        minePersonalActivity.mTvRegArea = (TextView) Utils.findRequiredViewAsType(view, R.id.reg_area, "field 'mTvRegArea'", TextView.class);
        minePersonalActivity.mTvProgress = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_progress, "field 'mTvProgress'", TextView.class);
        minePersonalActivity.mProgress = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_progress, "field 'mProgress'", ProgressBar.class);
        minePersonalActivity.mTopCoinTip = Utils.findRequiredView(view, R.id.ll_top_cointips, "field 'mTopCoinTip'");
        minePersonalActivity.mTvNameLable = (TextView) Utils.findRequiredViewAsType(view, R.id.name_label, "field 'mTvNameLable'", TextView.class);
        minePersonalActivity.mTvIdLable = (TextView) Utils.findRequiredViewAsType(view, R.id.ID_label, "field 'mTvIdLable'", TextView.class);
        minePersonalActivity.mTvAreaLable = (TextView) Utils.findRequiredViewAsType(view, R.id.area_label, "field 'mTvAreaLable'", TextView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13511e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(minePersonalActivity));
    }
}
