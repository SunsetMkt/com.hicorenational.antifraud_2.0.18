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
public class ManualCheckActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ManualCheckActivity f22529a;

    /* renamed from: b */
    private View f22530b;

    /* renamed from: c */
    private View f22531c;

    /* renamed from: d */
    private View f22532d;

    /* renamed from: e */
    private View f22533e;

    /* renamed from: f */
    private View f22534f;

    /* renamed from: g */
    private View f22535g;

    /* renamed from: ui.activity.ManualCheckActivity_ViewBinding$a */
    class C6374a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ManualCheckActivity f22536a;

        C6374a(ManualCheckActivity manualCheckActivity) {
            this.f22536a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22536a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ManualCheckActivity_ViewBinding$b */
    class C6375b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ManualCheckActivity f22538a;

        C6375b(ManualCheckActivity manualCheckActivity) {
            this.f22538a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22538a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ManualCheckActivity_ViewBinding$c */
    class C6376c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ManualCheckActivity f22540a;

        C6376c(ManualCheckActivity manualCheckActivity) {
            this.f22540a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22540a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ManualCheckActivity_ViewBinding$d */
    class C6377d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ManualCheckActivity f22542a;

        C6377d(ManualCheckActivity manualCheckActivity) {
            this.f22542a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22542a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ManualCheckActivity_ViewBinding$e */
    class C6378e extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ManualCheckActivity f22544a;

        C6378e(ManualCheckActivity manualCheckActivity) {
            this.f22544a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22544a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ManualCheckActivity_ViewBinding$f */
    class C6379f extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ManualCheckActivity f22546a;

        C6379f(ManualCheckActivity manualCheckActivity) {
            this.f22546a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22546a.onViewClicked(view);
        }
    }

    @UiThread
    public ManualCheckActivity_ViewBinding(ManualCheckActivity manualCheckActivity) {
        this(manualCheckActivity, manualCheckActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ManualCheckActivity manualCheckActivity = this.f22529a;
        if (manualCheckActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22529a = null;
        manualCheckActivity.mTvTitle = null;
        manualCheckActivity.mTvTips = null;
        manualCheckActivity.mIvUploadPicZ = null;
        manualCheckActivity.mIvUploadPicF = null;
        manualCheckActivity.mIvConfirm = null;
        this.f22530b.setOnClickListener(null);
        this.f22530b = null;
        this.f22531c.setOnClickListener(null);
        this.f22531c = null;
        this.f22532d.setOnClickListener(null);
        this.f22532d = null;
        this.f22533e.setOnClickListener(null);
        this.f22533e = null;
        this.f22534f.setOnClickListener(null);
        this.f22534f = null;
        this.f22535g.setOnClickListener(null);
        this.f22535g = null;
    }

    @UiThread
    public ManualCheckActivity_ViewBinding(ManualCheckActivity manualCheckActivity, View view) {
        this.f22529a = manualCheckActivity;
        manualCheckActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        manualCheckActivity.mTvTips = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_tips, "field 'mTvTips'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_upload_pic_z, "field 'mIvUploadPicZ' and method 'onViewClicked'");
        manualCheckActivity.mIvUploadPicZ = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_upload_pic_z, "field 'mIvUploadPicZ'", ImageView.class);
        this.f22530b = findRequiredView;
        findRequiredView.setOnClickListener(new C6374a(manualCheckActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_upload_pic_f, "field 'mIvUploadPicF' and method 'onViewClicked'");
        manualCheckActivity.mIvUploadPicF = (ImageView) Utils.castView(findRequiredView2, C2113R.id.iv_upload_pic_f, "field 'mIvUploadPicF'", ImageView.class);
        this.f22531c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6375b(manualCheckActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mIvConfirm' and method 'onViewClicked'");
        manualCheckActivity.mIvConfirm = (TextView) Utils.castView(findRequiredView3, C2113R.id.confirm, "field 'mIvConfirm'", TextView.class);
        this.f22532d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6376c(manualCheckActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22533e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6377d(manualCheckActivity));
        View findRequiredView5 = Utils.findRequiredView(view, C2113R.id.fl_upload_pic_z, "method 'onViewClicked'");
        this.f22534f = findRequiredView5;
        findRequiredView5.setOnClickListener(new C6378e(manualCheckActivity));
        View findRequiredView6 = Utils.findRequiredView(view, C2113R.id.fl_upload_pic_f, "method 'onViewClicked'");
        this.f22535g = findRequiredView6;
        findRequiredView6.setOnClickListener(new C6379f(manualCheckActivity));
    }
}
