package p388ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import com.hicorenational.antifraud.C2113R;
import interfaces.IVerifyListener;
import network.http.StatisticsHttp;
import p245d.C4440a;
import p388ui.activity.CheckFraudActivity;
import p388ui.activity.VirusKillingActivity;
import p388ui.fragment.StandardView;
import p388ui.p390e.C6823b;
import p388ui.presenter.WelocmPresenter;
import util.C7254a2;
import util.C7289j1;
import util.C7292k1;
import util.C7325u1;
import util.C7331w1;
import util.C7337y1;
import util.C7340z1;

/* loaded from: classes2.dex */
public class StandardView extends LinearLayout {

    /* renamed from: a */
    private Activity f23849a;

    /* renamed from: b */
    private TextView f23850b;

    /* renamed from: c */
    private ConstraintLayout f23851c;

    /* renamed from: d */
    private ConstraintLayout f23852d;

    /* renamed from: e */
    private ViewStub f23853e;

    /* renamed from: f */
    private ImageView f23854f;

    /* renamed from: g */
    private ImageView f23855g;

    /* renamed from: h */
    private ImageView f23856h;

    /* renamed from: i */
    private ViewStub.OnInflateListener f23857i;

    /* renamed from: ui.fragment.StandardView$a */
    class ViewOnClickListenerC6874a implements View.OnClickListener {
        ViewOnClickListenerC6874a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(WelocmPresenter.VIRAPPCHECK, "1")) {
                C7331w1.m26688a(WelocmPresenter.VIRSTMSG);
                return;
            }
            StandardView.this.m25586d();
            C7337y1.m26748a((Context) StandardView.this.f23849a, (Class<?>) VirusKillingActivity.class);
            StatisticsHttp.getInstance().trackPageClick("0");
        }
    }

    /* renamed from: ui.fragment.StandardView$b */
    class ViewOnClickListenerC6875b implements View.OnClickListener {
        ViewOnClickListenerC6875b() {
        }

        /* renamed from: a */
        public /* synthetic */ void m25590a() {
            RegionMudelBean m16408j = C4440a.m16408j();
            if (m16408j == null || TextUtils.isEmpty(m16408j.getRiskCheck())) {
                StandardView.this.f23849a.startActivity(new Intent(StandardView.this.f23849a, (Class<?>) CheckFraudActivity.class));
                return;
            }
            C7292k1.m26393a(StandardView.this.f23849a, m16408j.getH5Url() + m16408j.getRiskCheck());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C7340z1.m26805a(StandardView.this.f23849a).m26811a(6, new IVerifyListener() { // from class: ui.fragment.p
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    StandardView.ViewOnClickListenerC6875b.this.m25590a();
                }
            });
        }
    }

    /* renamed from: ui.fragment.StandardView$c */
    class ViewStubOnInflateListenerC6876c implements ViewStub.OnInflateListener {
        ViewStubOnInflateListenerC6876c() {
        }

        @Override // android.view.ViewStub.OnInflateListener
        public void onInflate(ViewStub viewStub, View view) {
            StandardView.this.f23855g = (ImageView) view.findViewById(C2113R.id.iv_animation_ing);
            StandardView.this.f23856h = (ImageView) view.findViewById(C2113R.id.iv_animation_scal);
        }
    }

    public StandardView(Context context) {
        super(context);
        m25585c();
    }

    /* renamed from: c */
    private void m25585c() {
        this.f23849a = (Activity) getContext();
        View inflate = LayoutInflater.from(this.f23849a).inflate(C2113R.layout.view_standard, (ViewGroup) this, true);
        this.f23850b = (TextView) inflate.findViewById(C2113R.id.tv_title);
        this.f23851c = (ConstraintLayout) inflate.findViewById(C2113R.id.cl_virus_check);
        this.f23852d = (ConstraintLayout) inflate.findViewById(C2113R.id.cl_fraud_check);
        this.f23854f = (ImageView) inflate.findViewById(C2113R.id.iv_img);
        this.f23853e = (ViewStub) inflate.findViewById(C2113R.id.stub_animation);
        this.f23851c.setOnClickListener(new ViewOnClickListenerC6874a());
        this.f23852d.setOnClickListener(new ViewOnClickListenerC6875b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m25586d() {
        C6823b.m25505e().m25517b();
        C7325u1.m26631b(C7325u1.f25711z0, true);
        m25581a(false);
    }

    /* renamed from: e */
    private void m25587e() {
        ImageView imageView = this.f23854f;
        if (imageView != null) {
            imageView.setVisibility(8);
            m25584b(true);
            ImageView imageView2 = this.f23855g;
            if (imageView2 != null) {
                C7337y1.m26747a(this.f23849a, C2113R.anim.scan_app_home_anim, imageView2);
            }
        }
    }

    public void setDataChange(RegionMudelBean regionMudelBean) {
        if (regionMudelBean == null) {
            setVisibility(0);
            this.f23851c.setVisibility(0);
            this.f23852d.setVisibility(8);
        } else {
            if (regionMudelBean.getStandard() == null || regionMudelBean.getStandard().size() <= 0) {
                setVisibility(8);
                return;
            }
            boolean contains = regionMudelBean.getStandard().contains(ModuelConfig.MODEL_VIRUS_KILL);
            boolean contains2 = regionMudelBean.getStandard().contains(ModuelConfig.MODEL_FRAUDCHECK);
            if (!contains && !contains2) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f23851c.setVisibility(contains ? 0 : 8);
            this.f23852d.setVisibility(contains2 ? 0 : 8);
        }
    }

    public void setTypeface(Typeface typeface) {
        this.f23850b.setTypeface(typeface);
    }

    public StandardView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m25585c();
    }

    /* renamed from: b */
    private void m25584b(boolean z) {
        ViewStub viewStub = this.f23853e;
        if (viewStub != null) {
            if (z) {
                if (this.f23857i == null) {
                    this.f23857i = new ViewStubOnInflateListenerC6876c();
                    this.f23853e.setOnInflateListener(this.f23857i);
                }
                this.f23853e.setVisibility(0);
                return;
            }
            viewStub.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void m25588a() {
        boolean m26388d = C7289j1.m26388d();
        boolean m26623a = C7325u1.m26623a(C7325u1.f25711z0, false);
        boolean m26623a2 = C7325u1.m26623a(C7325u1.f25624A0, false);
        if ((m26388d && !m26623a) || !m26623a2) {
            if (TextUtils.equals(WelocmPresenter.VIRAPPCHECK, "1")) {
                m25587e();
                new C7254a2(this.f23849a, C7254a2.f25104e);
                return;
            } else {
                m25589b();
                return;
            }
        }
        m25589b();
    }

    /* renamed from: b */
    public void m25589b() {
        m25581a(C7325u1.m26623a(C7325u1.f25626B0, false));
    }

    /* renamed from: a */
    private void m25581a(boolean z) {
        if (this.f23855g != null) {
            m25584b(false);
            m25579a(this.f23855g);
        }
        ImageView imageView = this.f23854f;
        if (imageView != null) {
            imageView.setVisibility(0);
            if (z) {
                this.f23854f.setImageResource(C2113R.drawable.iv_scan_afrad);
            } else {
                this.f23854f.setImageResource(C2113R.drawable.iv_fraud_check);
            }
        }
    }

    /* renamed from: a */
    private void m25579a(ImageView imageView) {
        if (imageView != null) {
            try {
                if (imageView.getDrawable() != null) {
                    imageView.clearAnimation();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
