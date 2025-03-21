package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class CheckFraudResultActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CheckFraudResultActivity f22125a;

    /* renamed from: b */
    private View f22126b;

    /* renamed from: c */
    private View f22127c;

    /* renamed from: d */
    private View f22128d;

    /* renamed from: e */
    private View f22129e;

    /* renamed from: ui.activity.CheckFraudResultActivity_ViewBinding$a */
    class C6230a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CheckFraudResultActivity f22130a;

        C6230a(CheckFraudResultActivity checkFraudResultActivity) {
            this.f22130a = checkFraudResultActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22130a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CheckFraudResultActivity_ViewBinding$b */
    class C6231b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CheckFraudResultActivity f22132a;

        C6231b(CheckFraudResultActivity checkFraudResultActivity) {
            this.f22132a = checkFraudResultActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22132a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CheckFraudResultActivity_ViewBinding$c */
    class C6232c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CheckFraudResultActivity f22134a;

        C6232c(CheckFraudResultActivity checkFraudResultActivity) {
            this.f22134a = checkFraudResultActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22134a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CheckFraudResultActivity_ViewBinding$d */
    class C6233d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CheckFraudResultActivity f22136a;

        C6233d(CheckFraudResultActivity checkFraudResultActivity) {
            this.f22136a = checkFraudResultActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22136a.onViewClicked(view);
        }
    }

    @UiThread
    public CheckFraudResultActivity_ViewBinding(CheckFraudResultActivity checkFraudResultActivity) {
        this(checkFraudResultActivity, checkFraudResultActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CheckFraudResultActivity checkFraudResultActivity = this.f22125a;
        if (checkFraudResultActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22125a = null;
        checkFraudResultActivity.mIvBack = null;
        checkFraudResultActivity.mTvTitle = null;
        checkFraudResultActivity.mIvRight = null;
        checkFraudResultActivity.mIvPicture = null;
        checkFraudResultActivity.mCheckResult = null;
        checkFraudResultActivity.mTvCotent = null;
        checkFraudResultActivity.mWarnTxt = null;
        checkFraudResultActivity.mTvAppeal = null;
        checkFraudResultActivity.mTvType = null;
        this.f22126b.setOnClickListener(null);
        this.f22126b = null;
        this.f22127c.setOnClickListener(null);
        this.f22127c = null;
        this.f22128d.setOnClickListener(null);
        this.f22128d = null;
        this.f22129e.setOnClickListener(null);
        this.f22129e = null;
    }

    @UiThread
    public CheckFraudResultActivity_ViewBinding(CheckFraudResultActivity checkFraudResultActivity, View view) {
        this.f22125a = checkFraudResultActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        checkFraudResultActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22126b = findRequiredView;
        findRequiredView.setOnClickListener(new C6230a(checkFraudResultActivity));
        checkFraudResultActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        checkFraudResultActivity.mIvRight = (ImageView) Utils.castView(findRequiredView2, C2113R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f22127c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6231b(checkFraudResultActivity));
        checkFraudResultActivity.mIvPicture = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_picture, "field 'mIvPicture'", ImageView.class);
        checkFraudResultActivity.mCheckResult = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_check_result, "field 'mCheckResult'", TextView.class);
        checkFraudResultActivity.mTvCotent = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_cotent, "field 'mTvCotent'", TextView.class);
        checkFraudResultActivity.mWarnTxt = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.warn_txt, "field 'mWarnTxt'", TextView.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_appeal, "field 'mTvAppeal' and method 'onViewClicked'");
        checkFraudResultActivity.mTvAppeal = (TextView) Utils.castView(findRequiredView3, C2113R.id.tv_appeal, "field 'mTvAppeal'", TextView.class);
        this.f22128d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6232c(checkFraudResultActivity));
        checkFraudResultActivity.mTvType = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_type, "field 'mTvType'", TextView.class);
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.tv_report, "method 'onViewClicked'");
        this.f22129e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6233d(checkFraudResultActivity));
    }
}
