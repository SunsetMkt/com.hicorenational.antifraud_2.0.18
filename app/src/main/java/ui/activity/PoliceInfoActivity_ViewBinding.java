package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PoliceInfoActivity_ViewBinding implements Unbinder {
    private PoliceInfoActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f13568f;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ PoliceInfoActivity a;

        a(PoliceInfoActivity policeInfoActivity) {
            this.a = policeInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ PoliceInfoActivity a;

        b(PoliceInfoActivity policeInfoActivity) {
            this.a = policeInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ PoliceInfoActivity a;

        c(PoliceInfoActivity policeInfoActivity) {
            this.a = policeInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ PoliceInfoActivity a;

        d(PoliceInfoActivity policeInfoActivity) {
            this.a = policeInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class e extends DebouncingOnClickListener {
        final /* synthetic */ PoliceInfoActivity a;

        e(PoliceInfoActivity policeInfoActivity) {
            this.a = policeInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public PoliceInfoActivity_ViewBinding(PoliceInfoActivity policeInfoActivity) {
        this(policeInfoActivity, policeInfoActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PoliceInfoActivity policeInfoActivity = this.a;
        if (policeInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        policeInfoActivity.mIvBack = null;
        policeInfoActivity.mTvTitle = null;
        policeInfoActivity.mIvRight = null;
        policeInfoActivity.mTvPhoneNum = null;
        policeInfoActivity.mTvInviteNum = null;
        policeInfoActivity.mTvDownApp = null;
        policeInfoActivity.mTvRegistNum = null;
        this.f13564b.setOnClickListener(null);
        this.f13564b = null;
        this.f13565c.setOnClickListener(null);
        this.f13565c = null;
        this.f13566d.setOnClickListener(null);
        this.f13566d = null;
        this.f13567e.setOnClickListener(null);
        this.f13567e = null;
        this.f13568f.setOnClickListener(null);
        this.f13568f = null;
    }

    @UiThread
    public PoliceInfoActivity_ViewBinding(PoliceInfoActivity policeInfoActivity, View view) {
        this.a = policeInfoActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        policeInfoActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13564b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(policeInfoActivity));
        policeInfoActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onClick'");
        policeInfoActivity.mIvRight = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f13565c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(policeInfoActivity));
        policeInfoActivity.mTvPhoneNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_phone_num, "field 'mTvPhoneNum'", TextView.class);
        policeInfoActivity.mTvInviteNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_invite_num, "field 'mTvInviteNum'", TextView.class);
        policeInfoActivity.mTvDownApp = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_doapp_num, "field 'mTvDownApp'", TextView.class);
        policeInfoActivity.mTvRegistNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_regist_num, "field 'mTvRegistNum'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_case_manger, "method 'onClick'");
        this.f13566d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(policeInfoActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_manual, "method 'onClick'");
        this.f13567e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(policeInfoActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.tv_invite_qrcode, "method 'onClick'");
        this.f13568f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(policeInfoActivity));
    }
}
