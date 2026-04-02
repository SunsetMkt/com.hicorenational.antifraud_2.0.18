package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class CheckFraudActivity_ViewBinding implements Unbinder {
    private CheckFraudActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f13254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f13255g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f13256h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f13257i;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CheckFraudActivity a;

        a(CheckFraudActivity checkFraudActivity) {
            this.a = checkFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CheckFraudActivity a;

        b(CheckFraudActivity checkFraudActivity) {
            this.a = checkFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ CheckFraudActivity a;

        c(CheckFraudActivity checkFraudActivity) {
            this.a = checkFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ CheckFraudActivity a;

        d(CheckFraudActivity checkFraudActivity) {
            this.a = checkFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {
        final /* synthetic */ CheckFraudActivity a;

        e(CheckFraudActivity checkFraudActivity) {
            this.a = checkFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {
        final /* synthetic */ CheckFraudActivity a;

        f(CheckFraudActivity checkFraudActivity) {
            this.a = checkFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class g extends DebouncingOnClickListener {
        final /* synthetic */ CheckFraudActivity a;

        g(CheckFraudActivity checkFraudActivity) {
            this.a = checkFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class h extends DebouncingOnClickListener {
        final /* synthetic */ CheckFraudActivity a;

        h(CheckFraudActivity checkFraudActivity) {
            this.a = checkFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public CheckFraudActivity_ViewBinding(CheckFraudActivity checkFraudActivity) {
        this(checkFraudActivity, checkFraudActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CheckFraudActivity checkFraudActivity = this.a;
        if (checkFraudActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        checkFraudActivity.mIvBack = null;
        checkFraudActivity.mTvTitle = null;
        checkFraudActivity.mIvRight = null;
        checkFraudActivity.mEtContent = null;
        checkFraudActivity.mTvCount_tip = null;
        checkFraudActivity.mRbPay = null;
        checkFraudActivity.mRbUrl = null;
        checkFraudActivity.mRbChat = null;
        checkFraudActivity.mIvClear = null;
        checkFraudActivity.mTvScan = null;
        this.f13250b.setOnClickListener(null);
        this.f13250b = null;
        this.f13251c.setOnClickListener(null);
        this.f13251c = null;
        this.f13252d.setOnClickListener(null);
        this.f13252d = null;
        this.f13253e.setOnClickListener(null);
        this.f13253e = null;
        this.f13254f.setOnClickListener(null);
        this.f13254f = null;
        this.f13255g.setOnClickListener(null);
        this.f13255g = null;
        this.f13256h.setOnClickListener(null);
        this.f13256h = null;
        this.f13257i.setOnClickListener(null);
        this.f13257i = null;
    }

    @UiThread
    public CheckFraudActivity_ViewBinding(CheckFraudActivity checkFraudActivity, View view) {
        this.a = checkFraudActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        checkFraudActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13250b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(checkFraudActivity));
        checkFraudActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        checkFraudActivity.mIvRight = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f13251c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(checkFraudActivity));
        checkFraudActivity.mEtContent = (EditText) Utils.findRequiredViewAsType(view, R.id.et_content, "field 'mEtContent'", EditText.class);
        checkFraudActivity.mTvCount_tip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_count_tip, "field 'mTvCount_tip'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rb_pay, "field 'mRbPay' and method 'onViewClicked'");
        checkFraudActivity.mRbPay = (RadioButton) Utils.castView(viewFindRequiredView3, R.id.rb_pay, "field 'mRbPay'", RadioButton.class);
        this.f13252d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(checkFraudActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.rb_url, "field 'mRbUrl' and method 'onViewClicked'");
        checkFraudActivity.mRbUrl = (RadioButton) Utils.castView(viewFindRequiredView4, R.id.rb_url, "field 'mRbUrl'", RadioButton.class);
        this.f13253e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(checkFraudActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.rb_chat, "field 'mRbChat' and method 'onViewClicked'");
        checkFraudActivity.mRbChat = (RadioButton) Utils.castView(viewFindRequiredView5, R.id.rb_chat, "field 'mRbChat'", RadioButton.class);
        this.f13254f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(checkFraudActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClear' and method 'onViewClicked'");
        checkFraudActivity.mIvClear = (ImageView) Utils.castView(viewFindRequiredView6, R.id.iv_clear, "field 'mIvClear'", ImageView.class);
        this.f13255g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(checkFraudActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.ll_scan, "field 'mTvScan' and method 'onViewClicked'");
        checkFraudActivity.mTvScan = (LinearLayout) Utils.castView(viewFindRequiredView7, R.id.ll_scan, "field 'mTvScan'", LinearLayout.class);
        this.f13256h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(checkFraudActivity));
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.confirm, "method 'onViewClicked'");
        this.f13257i = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new h(checkFraudActivity));
    }
}
