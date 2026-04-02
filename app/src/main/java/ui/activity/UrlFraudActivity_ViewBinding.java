package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class UrlFraudActivity_ViewBinding implements Unbinder {
    private UrlFraudActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13941e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ UrlFraudActivity a;

        a(UrlFraudActivity urlFraudActivity) {
            this.a = urlFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ UrlFraudActivity a;

        b(UrlFraudActivity urlFraudActivity) {
            this.a = urlFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ UrlFraudActivity a;

        c(UrlFraudActivity urlFraudActivity) {
            this.a = urlFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ UrlFraudActivity a;

        d(UrlFraudActivity urlFraudActivity) {
            this.a = urlFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public UrlFraudActivity_ViewBinding(UrlFraudActivity urlFraudActivity) {
        this(urlFraudActivity, urlFraudActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        UrlFraudActivity urlFraudActivity = this.a;
        if (urlFraudActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        urlFraudActivity.mTvTitle = null;
        urlFraudActivity.mFraudNum = null;
        urlFraudActivity.mRegion = null;
        urlFraudActivity.mTvDuperyType = null;
        urlFraudActivity.mEtCaseDescribe = null;
        this.f13938b.setOnClickListener(null);
        this.f13938b = null;
        this.f13939c.setOnClickListener(null);
        this.f13939c = null;
        this.f13940d.setOnClickListener(null);
        this.f13940d = null;
        this.f13941e.setOnClickListener(null);
        this.f13941e = null;
    }

    @UiThread
    public UrlFraudActivity_ViewBinding(UrlFraudActivity urlFraudActivity, View view) {
        this.a = urlFraudActivity;
        urlFraudActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        urlFraudActivity.mFraudNum = (TextView) Utils.findRequiredViewAsType(view, R.id.fraud_num, "field 'mFraudNum'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.region, "field 'mRegion' and method 'onViewClicked'");
        urlFraudActivity.mRegion = (TextView) Utils.castView(viewFindRequiredView, R.id.region, "field 'mRegion'", TextView.class);
        this.f13938b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(urlFraudActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_dupery_type, "field 'mTvDuperyType' and method 'onViewClicked'");
        urlFraudActivity.mTvDuperyType = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_dupery_type, "field 'mTvDuperyType'", TextView.class);
        this.f13939c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(urlFraudActivity));
        urlFraudActivity.mEtCaseDescribe = (EditText) Utils.findRequiredViewAsType(view, R.id.et_case_describe, "field 'mEtCaseDescribe'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13940d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(urlFraudActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn_commit, "method 'onViewClicked'");
        this.f13941e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(urlFraudActivity));
    }
}
