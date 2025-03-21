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
public class IDVarfySuccessActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private IDVarfySuccessActivity f22422a;

    /* renamed from: b */
    private View f22423b;

    /* renamed from: c */
    private View f22424c;

    /* renamed from: ui.activity.IDVarfySuccessActivity_ViewBinding$a */
    class C6339a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ IDVarfySuccessActivity f22425a;

        C6339a(IDVarfySuccessActivity iDVarfySuccessActivity) {
            this.f22425a = iDVarfySuccessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22425a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.IDVarfySuccessActivity_ViewBinding$b */
    class C6340b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ IDVarfySuccessActivity f22427a;

        C6340b(IDVarfySuccessActivity iDVarfySuccessActivity) {
            this.f22427a = iDVarfySuccessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22427a.onViewClicked(view);
        }
    }

    @UiThread
    public IDVarfySuccessActivity_ViewBinding(IDVarfySuccessActivity iDVarfySuccessActivity) {
        this(iDVarfySuccessActivity, iDVarfySuccessActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        IDVarfySuccessActivity iDVarfySuccessActivity = this.f22422a;
        if (iDVarfySuccessActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22422a = null;
        iDVarfySuccessActivity.mIvBack = null;
        iDVarfySuccessActivity.mTvTitle = null;
        iDVarfySuccessActivity.mTvTips = null;
        this.f22423b.setOnClickListener(null);
        this.f22423b = null;
        this.f22424c.setOnClickListener(null);
        this.f22424c = null;
    }

    @UiThread
    public IDVarfySuccessActivity_ViewBinding(IDVarfySuccessActivity iDVarfySuccessActivity, View view) {
        this.f22422a = iDVarfySuccessActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        iDVarfySuccessActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22423b = findRequiredView;
        findRequiredView.setOnClickListener(new C6339a(iDVarfySuccessActivity));
        iDVarfySuccessActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        iDVarfySuccessActivity.mTvTips = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_tips, "field 'mTvTips'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.btn_idvrfy_start, "method 'onViewClicked'");
        this.f22424c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6340b(iDVarfySuccessActivity));
    }
}
