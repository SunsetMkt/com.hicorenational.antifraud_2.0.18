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
public class ManualCheckActivity_ViewBinding implements Unbinder {
    private ManualCheckActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f13490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f13491g;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ ManualCheckActivity a;

        a(ManualCheckActivity manualCheckActivity) {
            this.a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ ManualCheckActivity a;

        b(ManualCheckActivity manualCheckActivity) {
            this.a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ ManualCheckActivity a;

        c(ManualCheckActivity manualCheckActivity) {
            this.a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ ManualCheckActivity a;

        d(ManualCheckActivity manualCheckActivity) {
            this.a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {
        final /* synthetic */ ManualCheckActivity a;

        e(ManualCheckActivity manualCheckActivity) {
            this.a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {
        final /* synthetic */ ManualCheckActivity a;

        f(ManualCheckActivity manualCheckActivity) {
            this.a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public ManualCheckActivity_ViewBinding(ManualCheckActivity manualCheckActivity) {
        this(manualCheckActivity, manualCheckActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ManualCheckActivity manualCheckActivity = this.a;
        if (manualCheckActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        manualCheckActivity.mTvTitle = null;
        manualCheckActivity.mTvTips = null;
        manualCheckActivity.mIvUploadPicZ = null;
        manualCheckActivity.mIvUploadPicF = null;
        manualCheckActivity.mIvConfirm = null;
        this.f13486b.setOnClickListener(null);
        this.f13486b = null;
        this.f13487c.setOnClickListener(null);
        this.f13487c = null;
        this.f13488d.setOnClickListener(null);
        this.f13488d = null;
        this.f13489e.setOnClickListener(null);
        this.f13489e = null;
        this.f13490f.setOnClickListener(null);
        this.f13490f = null;
        this.f13491g.setOnClickListener(null);
        this.f13491g = null;
    }

    @UiThread
    public ManualCheckActivity_ViewBinding(ManualCheckActivity manualCheckActivity, View view) {
        this.a = manualCheckActivity;
        manualCheckActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        manualCheckActivity.mTvTips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tips, "field 'mTvTips'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_upload_pic_z, "field 'mIvUploadPicZ' and method 'onViewClicked'");
        manualCheckActivity.mIvUploadPicZ = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_upload_pic_z, "field 'mIvUploadPicZ'", ImageView.class);
        this.f13486b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(manualCheckActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_upload_pic_f, "field 'mIvUploadPicF' and method 'onViewClicked'");
        manualCheckActivity.mIvUploadPicF = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_upload_pic_f, "field 'mIvUploadPicF'", ImageView.class);
        this.f13487c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(manualCheckActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.confirm, "field 'mIvConfirm' and method 'onViewClicked'");
        manualCheckActivity.mIvConfirm = (TextView) Utils.castView(viewFindRequiredView3, R.id.confirm, "field 'mIvConfirm'", TextView.class);
        this.f13488d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(manualCheckActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13489e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(manualCheckActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.fl_upload_pic_z, "method 'onViewClicked'");
        this.f13490f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(manualCheckActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.fl_upload_pic_f, "method 'onViewClicked'");
        this.f13491g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(manualCheckActivity));
    }
}
