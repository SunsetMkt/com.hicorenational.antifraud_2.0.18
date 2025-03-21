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
public class IDVarfyFaceActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private IDVarfyFaceActivity f22410a;

    /* renamed from: b */
    private View f22411b;

    /* renamed from: c */
    private View f22412c;

    /* renamed from: ui.activity.IDVarfyFaceActivity_ViewBinding$a */
    class C6336a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ IDVarfyFaceActivity f22413a;

        C6336a(IDVarfyFaceActivity iDVarfyFaceActivity) {
            this.f22413a = iDVarfyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22413a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.IDVarfyFaceActivity_ViewBinding$b */
    class C6337b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ IDVarfyFaceActivity f22415a;

        C6337b(IDVarfyFaceActivity iDVarfyFaceActivity) {
            this.f22415a = iDVarfyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22415a.onViewClicked(view);
        }
    }

    @UiThread
    public IDVarfyFaceActivity_ViewBinding(IDVarfyFaceActivity iDVarfyFaceActivity) {
        this(iDVarfyFaceActivity, iDVarfyFaceActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        IDVarfyFaceActivity iDVarfyFaceActivity = this.f22410a;
        if (iDVarfyFaceActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22410a = null;
        iDVarfyFaceActivity.mIvBack = null;
        iDVarfyFaceActivity.mTvTitle = null;
        this.f22411b.setOnClickListener(null);
        this.f22411b = null;
        this.f22412c.setOnClickListener(null);
        this.f22412c = null;
    }

    @UiThread
    public IDVarfyFaceActivity_ViewBinding(IDVarfyFaceActivity iDVarfyFaceActivity, View view) {
        this.f22410a = iDVarfyFaceActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        iDVarfyFaceActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22411b = findRequiredView;
        findRequiredView.setOnClickListener(new C6336a(iDVarfyFaceActivity));
        iDVarfyFaceActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_firm, "method 'onViewClicked'");
        this.f22412c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6337b(iDVarfyFaceActivity));
    }
}
