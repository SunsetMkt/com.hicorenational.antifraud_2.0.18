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
public class IDVarfyFaceActivity_ViewBinding implements Unbinder {
    private IDVarfyFaceActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13423c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ IDVarfyFaceActivity a;

        a(IDVarfyFaceActivity iDVarfyFaceActivity) {
            this.a = iDVarfyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ IDVarfyFaceActivity a;

        b(IDVarfyFaceActivity iDVarfyFaceActivity) {
            this.a = iDVarfyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public IDVarfyFaceActivity_ViewBinding(IDVarfyFaceActivity iDVarfyFaceActivity) {
        this(iDVarfyFaceActivity, iDVarfyFaceActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        IDVarfyFaceActivity iDVarfyFaceActivity = this.a;
        if (iDVarfyFaceActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        iDVarfyFaceActivity.mIvBack = null;
        iDVarfyFaceActivity.mTvTitle = null;
        this.f13422b.setOnClickListener(null);
        this.f13422b = null;
        this.f13423c.setOnClickListener(null);
        this.f13423c = null;
    }

    @UiThread
    public IDVarfyFaceActivity_ViewBinding(IDVarfyFaceActivity iDVarfyFaceActivity, View view) {
        this.a = iDVarfyFaceActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        iDVarfyFaceActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13422b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(iDVarfyFaceActivity));
        iDVarfyFaceActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_firm, "method 'onViewClicked'");
        this.f13423c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(iDVarfyFaceActivity));
    }
}
