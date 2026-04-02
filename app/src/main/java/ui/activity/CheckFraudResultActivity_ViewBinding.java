package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class CheckFraudResultActivity_ViewBinding implements Unbinder {
    private CheckFraudResultActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13269e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CheckFraudResultActivity a;

        a(CheckFraudResultActivity checkFraudResultActivity) {
            this.a = checkFraudResultActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CheckFraudResultActivity a;

        b(CheckFraudResultActivity checkFraudResultActivity) {
            this.a = checkFraudResultActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ CheckFraudResultActivity a;

        c(CheckFraudResultActivity checkFraudResultActivity) {
            this.a = checkFraudResultActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ CheckFraudResultActivity a;

        d(CheckFraudResultActivity checkFraudResultActivity) {
            this.a = checkFraudResultActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public CheckFraudResultActivity_ViewBinding(CheckFraudResultActivity checkFraudResultActivity) {
        this(checkFraudResultActivity, checkFraudResultActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CheckFraudResultActivity checkFraudResultActivity = this.a;
        if (checkFraudResultActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        checkFraudResultActivity.mIvBack = null;
        checkFraudResultActivity.mTvTitle = null;
        checkFraudResultActivity.mIvRight = null;
        checkFraudResultActivity.mIvPicture = null;
        checkFraudResultActivity.mCheckResult = null;
        checkFraudResultActivity.mTvCotent = null;
        checkFraudResultActivity.mWarnTxt = null;
        checkFraudResultActivity.mTvAppeal = null;
        checkFraudResultActivity.mTvType = null;
        this.f13266b.setOnClickListener(null);
        this.f13266b = null;
        this.f13267c.setOnClickListener(null);
        this.f13267c = null;
        this.f13268d.setOnClickListener(null);
        this.f13268d = null;
        this.f13269e.setOnClickListener(null);
        this.f13269e = null;
    }

    @UiThread
    public CheckFraudResultActivity_ViewBinding(CheckFraudResultActivity checkFraudResultActivity, View view) {
        this.a = checkFraudResultActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        checkFraudResultActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13266b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(checkFraudResultActivity));
        checkFraudResultActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        checkFraudResultActivity.mIvRight = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f13267c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(checkFraudResultActivity));
        checkFraudResultActivity.mIvPicture = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_picture, "field 'mIvPicture'", ImageView.class);
        checkFraudResultActivity.mCheckResult = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_check_result, "field 'mCheckResult'", TextView.class);
        checkFraudResultActivity.mTvCotent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cotent, "field 'mTvCotent'", TextView.class);
        checkFraudResultActivity.mWarnTxt = (TextView) Utils.findRequiredViewAsType(view, R.id.warn_txt, "field 'mWarnTxt'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_appeal, "field 'mTvAppeal' and method 'onViewClicked'");
        checkFraudResultActivity.mTvAppeal = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_appeal, "field 'mTvAppeal'", TextView.class);
        this.f13268d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(checkFraudResultActivity));
        checkFraudResultActivity.mTvType = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_type, "field 'mTvType'", TextView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_report, "method 'onViewClicked'");
        this.f13269e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(checkFraudResultActivity));
    }
}
