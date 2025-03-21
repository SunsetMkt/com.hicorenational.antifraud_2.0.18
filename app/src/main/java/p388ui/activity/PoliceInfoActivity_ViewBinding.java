package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class PoliceInfoActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PoliceInfoActivity f22678a;

    /* renamed from: b */
    private View f22679b;

    /* renamed from: c */
    private View f22680c;

    /* renamed from: d */
    private View f22681d;

    /* renamed from: e */
    private View f22682e;

    /* renamed from: f */
    private View f22683f;

    /* renamed from: ui.activity.PoliceInfoActivity_ViewBinding$a */
    class C6430a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PoliceInfoActivity f22684a;

        C6430a(PoliceInfoActivity policeInfoActivity) {
            this.f22684a = policeInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22684a.onClick(view);
        }
    }

    /* renamed from: ui.activity.PoliceInfoActivity_ViewBinding$b */
    class C6431b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PoliceInfoActivity f22686a;

        C6431b(PoliceInfoActivity policeInfoActivity) {
            this.f22686a = policeInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22686a.onClick(view);
        }
    }

    /* renamed from: ui.activity.PoliceInfoActivity_ViewBinding$c */
    class C6432c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PoliceInfoActivity f22688a;

        C6432c(PoliceInfoActivity policeInfoActivity) {
            this.f22688a = policeInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22688a.onClick(view);
        }
    }

    /* renamed from: ui.activity.PoliceInfoActivity_ViewBinding$d */
    class C6433d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PoliceInfoActivity f22690a;

        C6433d(PoliceInfoActivity policeInfoActivity) {
            this.f22690a = policeInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22690a.onClick(view);
        }
    }

    /* renamed from: ui.activity.PoliceInfoActivity_ViewBinding$e */
    class C6434e extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PoliceInfoActivity f22692a;

        C6434e(PoliceInfoActivity policeInfoActivity) {
            this.f22692a = policeInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22692a.onClick(view);
        }
    }

    @UiThread
    public PoliceInfoActivity_ViewBinding(PoliceInfoActivity policeInfoActivity) {
        this(policeInfoActivity, policeInfoActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PoliceInfoActivity policeInfoActivity = this.f22678a;
        if (policeInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22678a = null;
        policeInfoActivity.mIvBack = null;
        policeInfoActivity.mTvTitle = null;
        policeInfoActivity.mIvRight = null;
        policeInfoActivity.mTvPhoneNum = null;
        policeInfoActivity.mTvInviteNum = null;
        policeInfoActivity.mTvDownApp = null;
        policeInfoActivity.mTvRegistNum = null;
        this.f22679b.setOnClickListener(null);
        this.f22679b = null;
        this.f22680c.setOnClickListener(null);
        this.f22680c = null;
        this.f22681d.setOnClickListener(null);
        this.f22681d = null;
        this.f22682e.setOnClickListener(null);
        this.f22682e = null;
        this.f22683f.setOnClickListener(null);
        this.f22683f = null;
    }

    @UiThread
    public PoliceInfoActivity_ViewBinding(PoliceInfoActivity policeInfoActivity, View view) {
        this.f22678a = policeInfoActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        policeInfoActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22679b = findRequiredView;
        findRequiredView.setOnClickListener(new C6430a(policeInfoActivity));
        policeInfoActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_right, "field 'mIvRight' and method 'onClick'");
        policeInfoActivity.mIvRight = (ImageView) Utils.castView(findRequiredView2, C2113R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f22680c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6431b(policeInfoActivity));
        policeInfoActivity.mTvPhoneNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_phone_num, "field 'mTvPhoneNum'", TextView.class);
        policeInfoActivity.mTvInviteNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_invite_num, "field 'mTvInviteNum'", TextView.class);
        policeInfoActivity.mTvDownApp = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_doapp_num, "field 'mTvDownApp'", TextView.class);
        policeInfoActivity.mTvRegistNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_regist_num, "field 'mTvRegistNum'", TextView.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_case_manger, "method 'onClick'");
        this.f22681d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6432c(policeInfoActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.tv_manual, "method 'onClick'");
        this.f22682e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6433d(policeInfoActivity));
        View findRequiredView5 = Utils.findRequiredView(view, C2113R.id.tv_invite_qrcode, "method 'onClick'");
        this.f22683f = findRequiredView5;
        findRequiredView5.setOnClickListener(new C6434e(policeInfoActivity));
    }
}
