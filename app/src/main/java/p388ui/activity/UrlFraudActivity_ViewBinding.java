package p388ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class UrlFraudActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private UrlFraudActivity f23322a;

    /* renamed from: b */
    private View f23323b;

    /* renamed from: c */
    private View f23324c;

    /* renamed from: d */
    private View f23325d;

    /* renamed from: e */
    private View f23326e;

    /* renamed from: ui.activity.UrlFraudActivity_ViewBinding$a */
    class C6638a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ UrlFraudActivity f23327a;

        C6638a(UrlFraudActivity urlFraudActivity) {
            this.f23327a = urlFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23327a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.UrlFraudActivity_ViewBinding$b */
    class C6639b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ UrlFraudActivity f23329a;

        C6639b(UrlFraudActivity urlFraudActivity) {
            this.f23329a = urlFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23329a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.UrlFraudActivity_ViewBinding$c */
    class C6640c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ UrlFraudActivity f23331a;

        C6640c(UrlFraudActivity urlFraudActivity) {
            this.f23331a = urlFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23331a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.UrlFraudActivity_ViewBinding$d */
    class C6641d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ UrlFraudActivity f23333a;

        C6641d(UrlFraudActivity urlFraudActivity) {
            this.f23333a = urlFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23333a.onViewClicked(view);
        }
    }

    @UiThread
    public UrlFraudActivity_ViewBinding(UrlFraudActivity urlFraudActivity) {
        this(urlFraudActivity, urlFraudActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        UrlFraudActivity urlFraudActivity = this.f23322a;
        if (urlFraudActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23322a = null;
        urlFraudActivity.mTvTitle = null;
        urlFraudActivity.mFraudNum = null;
        urlFraudActivity.mRegion = null;
        urlFraudActivity.mTvDuperyType = null;
        urlFraudActivity.mEtCaseDescribe = null;
        this.f23323b.setOnClickListener(null);
        this.f23323b = null;
        this.f23324c.setOnClickListener(null);
        this.f23324c = null;
        this.f23325d.setOnClickListener(null);
        this.f23325d = null;
        this.f23326e.setOnClickListener(null);
        this.f23326e = null;
    }

    @UiThread
    public UrlFraudActivity_ViewBinding(UrlFraudActivity urlFraudActivity, View view) {
        this.f23322a = urlFraudActivity;
        urlFraudActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        urlFraudActivity.mFraudNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.fraud_num, "field 'mFraudNum'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.region, "field 'mRegion' and method 'onViewClicked'");
        urlFraudActivity.mRegion = (TextView) Utils.castView(findRequiredView, C2113R.id.region, "field 'mRegion'", TextView.class);
        this.f23323b = findRequiredView;
        findRequiredView.setOnClickListener(new C6638a(urlFraudActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_dupery_type, "field 'mTvDuperyType' and method 'onViewClicked'");
        urlFraudActivity.mTvDuperyType = (TextView) Utils.castView(findRequiredView2, C2113R.id.tv_dupery_type, "field 'mTvDuperyType'", TextView.class);
        this.f23324c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6639b(urlFraudActivity));
        urlFraudActivity.mEtCaseDescribe = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_case_describe, "field 'mEtCaseDescribe'", EditText.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23325d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6640c(urlFraudActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.btn_commit, "method 'onViewClicked'");
        this.f23326e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6641d(urlFraudActivity));
    }
}
