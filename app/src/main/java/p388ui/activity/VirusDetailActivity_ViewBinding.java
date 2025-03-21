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
public class VirusDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private VirusDetailActivity f23396a;

    /* renamed from: b */
    private View f23397b;

    /* renamed from: c */
    private View f23398c;

    /* renamed from: d */
    private View f23399d;

    /* renamed from: ui.activity.VirusDetailActivity_ViewBinding$a */
    class C6667a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VirusDetailActivity f23400a;

        C6667a(VirusDetailActivity virusDetailActivity) {
            this.f23400a = virusDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23400a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.VirusDetailActivity_ViewBinding$b */
    class C6668b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VirusDetailActivity f23402a;

        C6668b(VirusDetailActivity virusDetailActivity) {
            this.f23402a = virusDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23402a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.VirusDetailActivity_ViewBinding$c */
    class C6669c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VirusDetailActivity f23404a;

        C6669c(VirusDetailActivity virusDetailActivity) {
            this.f23404a = virusDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23404a.onViewClicked(view);
        }
    }

    @UiThread
    public VirusDetailActivity_ViewBinding(VirusDetailActivity virusDetailActivity) {
        this(virusDetailActivity, virusDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VirusDetailActivity virusDetailActivity = this.f23396a;
        if (virusDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23396a = null;
        virusDetailActivity.mTvTitle = null;
        virusDetailActivity.mImageview = null;
        virusDetailActivity.mTvAppName = null;
        virusDetailActivity.mTvAppVersion = null;
        virusDetailActivity.mTvRiskFlag = null;
        virusDetailActivity.mTvVirusName = null;
        virusDetailActivity.mTvDescribe = null;
        virusDetailActivity.mTvDelete = null;
        this.f23397b.setOnClickListener(null);
        this.f23397b = null;
        this.f23398c.setOnClickListener(null);
        this.f23398c = null;
        this.f23399d.setOnClickListener(null);
        this.f23399d = null;
    }

    @UiThread
    public VirusDetailActivity_ViewBinding(VirusDetailActivity virusDetailActivity, View view) {
        this.f23396a = virusDetailActivity;
        virusDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        virusDetailActivity.mImageview = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.imageview, "field 'mImageview'", ImageView.class);
        virusDetailActivity.mTvAppName = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_app_name, "field 'mTvAppName'", TextView.class);
        virusDetailActivity.mTvAppVersion = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_app_version, "field 'mTvAppVersion'", TextView.class);
        virusDetailActivity.mTvRiskFlag = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_risk_flag, "field 'mTvRiskFlag'", TextView.class);
        virusDetailActivity.mTvVirusName = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_name, "field 'mTvVirusName'", TextView.class);
        virusDetailActivity.mTvDescribe = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_describe, "field 'mTvDescribe'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.tv_delete, "field 'mTvDelete' and method 'onViewClicked'");
        virusDetailActivity.mTvDelete = (TextView) Utils.castView(findRequiredView, C2113R.id.tv_delete, "field 'mTvDelete'", TextView.class);
        this.f23397b = findRequiredView;
        findRequiredView.setOnClickListener(new C6667a(virusDetailActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23398c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6668b(virusDetailActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_appeal, "method 'onViewClicked'");
        this.f23399d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6669c(virusDetailActivity));
    }
}
