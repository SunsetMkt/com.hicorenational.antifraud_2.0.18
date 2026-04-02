package ui.fragment;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import com.hicorenational.antifraud.R;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import interfaces.IOneClickListener;
import interfaces.IVerifyListener;
import manager.BaseDialog;
import network.http.StatisticsHttp;
import ui.activity.AIVerifyActivity;
import ui.activity.CheckFraudActivity;
import ui.activity.VirusKillingActivity;
import ui.presenter.WelocmPresenter;
import util.c2;
import util.e2;
import util.f1;
import util.g2;
import util.h2;
import util.k2;
import util.o1;
import util.p1;
import util.r1;
import util.s1;

/* JADX INFO: loaded from: classes2.dex */
public class StandardView extends LinearLayout {
    private Activity a;

    /* JADX INFO: renamed from: b */
    private TextView f14196b;

    /* JADX INFO: renamed from: c */
    private ConstraintLayout f14197c;

    /* JADX INFO: renamed from: d */
    private ConstraintLayout f14198d;

    /* JADX INFO: renamed from: e */
    private TextView f14199e;

    /* JADX INFO: renamed from: f */
    private TextView f14200f;

    /* JADX INFO: renamed from: g */
    private TextView f14201g;

    /* JADX INFO: renamed from: h */
    private TextView f14202h;

    /* JADX INFO: renamed from: i */
    private ImageView f14203i;

    /* JADX INFO: renamed from: j */
    private ImageView f14204j;

    /* JADX INFO: renamed from: k */
    private ConstraintLayout f14205k;

    /* JADX INFO: renamed from: l */
    private ConstraintLayout f14206l;

    /* JADX INFO: renamed from: m */
    private ViewStub f14207m;

    /* JADX INFO: renamed from: n */
    private ImageView f14208n;
    private ImageView o;
    private ImageView p;
    private ViewStub.OnInflateListener q;
    private BaseDialog r;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(WelocmPresenter.VIRAPPCHECK, "1")) {
                e2.a(WelocmPresenter.VIRSTMSG);
                return;
            }
            StandardView.this.f();
            g2.a((Context) StandardView.this.a, (Class<?>) VirusKillingActivity.class);
            StatisticsHttp.getInstance().trackPageClick("0");
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public /* synthetic */ void a() {
            RegionMudelBean regionMudelBeanJ = e.a.j();
            if (regionMudelBeanJ == null || TextUtils.isEmpty(regionMudelBeanJ.getRiskCheck())) {
                StandardView.this.a.startActivity(new Intent(StandardView.this.a, (Class<?>) CheckFraudActivity.class));
                return;
            }
            p1.a(StandardView.this.a, regionMudelBeanJ.getH5Url() + regionMudelBeanJ.getRiskCheck());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h2.a(StandardView.this.a).a(6, new IVerifyListener() { // from class: ui.fragment.l
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    this.a.a();
                }
            });
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StandardView.this.b();
        }
    }

    class d implements ViewStub.OnInflateListener {
        d() {
        }

        @Override // android.view.ViewStub.OnInflateListener
        public void onInflate(ViewStub viewStub, View view) {
            StandardView.this.o = (ImageView) view.findViewById(R.id.iv_animation_ing);
            StandardView.this.p = (ImageView) view.findViewById(R.id.iv_animation_scal);
        }
    }

    public StandardView(Context context) {
        super(context);
        d();
    }

    private void d() {
        this.a = (Activity) getContext();
        View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.view_standard, (ViewGroup) this, true);
        this.f14196b = (TextView) viewInflate.findViewById(R.id.tv_title);
        this.f14197c = (ConstraintLayout) viewInflate.findViewById(R.id.cl_virus_check);
        this.f14198d = (ConstraintLayout) viewInflate.findViewById(R.id.cl_fraud_check);
        this.f14199e = (TextView) viewInflate.findViewById(R.id.tv_fraud_title);
        this.f14200f = (TextView) viewInflate.findViewById(R.id.tv_fraud_desc);
        this.f14203i = (ImageView) viewInflate.findViewById(R.id.iv_fraud);
        this.f14205k = (ConstraintLayout) viewInflate.findViewById(R.id.cl_card_check);
        this.f14201g = (TextView) viewInflate.findViewById(R.id.tv_idcard_title);
        this.f14202h = (TextView) viewInflate.findViewById(R.id.tv_idcard_desc);
        this.f14204j = (ImageView) viewInflate.findViewById(R.id.iv_idcard);
        this.f14208n = (ImageView) viewInflate.findViewById(R.id.iv_img);
        this.f14207m = (ViewStub) viewInflate.findViewById(R.id.stub_animation);
        this.f14206l = (ConstraintLayout) viewInflate.findViewById(R.id.ai_check);
        this.f14197c.setOnClickListener(new a());
        e();
    }

    private void e() {
        this.f14206l.setOnClickListener(new View.OnClickListener() { // from class: ui.fragment.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a(view);
            }
        });
    }

    public void f() {
        ui.e.b.e().b();
        c2.b(c2.z0, true);
        a(false);
    }

    private void g() {
        ImageView imageView = this.f14208n;
        if (imageView != null) {
            imageView.setVisibility(8);
            b(true);
            ImageView imageView2 = this.o;
            if (imageView2 != null) {
                g2.a(this.a, R.anim.scan_app_home_anim, imageView2);
            }
        }
    }

    private void setIdcardClck(View view) {
        view.setOnClickListener(new c());
    }

    private void setViewClck(View view) {
        view.setOnClickListener(new b());
    }

    public void c() {
        a(c2.a(c2.B0, false));
    }

    public void setDataChange(RegionMudelBean regionMudelBean) {
        s1.a("hsc", "0000000mudelBean==" + regionMudelBean);
        if (regionMudelBean == null) {
            setVisibility(0);
            this.f14197c.setVisibility(0);
            this.f14198d.setVisibility(0);
            this.f14205k.setVisibility(8);
            setIdcardClck(this.f14198d);
            this.f14199e.setText("\u4e00\u8bc1\u901a\u67e5");
            this.f14200f.setText("\u4e2a\u4eba\u540d\u4e0b\u8d26\u6237\u6838\u67e5");
            this.f14203i.setImageResource(R.mipmap.iv_card_ck);
            this.f14206l.setVisibility(0);
            return;
        }
        s1.a("hsc", "11111==" + regionMudelBean.getStandard());
        if (regionMudelBean.getStandard() == null || regionMudelBean.getStandard().size() < 0) {
            setVisibility(8);
            return;
        }
        boolean zContains = regionMudelBean.getStandard().contains(ModuelConfig.MODEL_VIRUS_KILL);
        boolean zContains2 = regionMudelBean.getStandard().contains(ModuelConfig.MODEL_FRAUDCHECK);
        boolean zContains3 = regionMudelBean.getStandard().contains(ModuelConfig.MODEL_CARDCK);
        regionMudelBean.getStandard().contains(ModuelConfig.MODEL_AICK);
        s1.a("hsc", "virusCheck==" + zContains + "  fraudCheck==" + zContains2 + " fraudCard==" + zContains3);
        setVisibility(0);
        this.f14197c.setVisibility(0);
        if (!zContains2) {
            this.f14198d.setVisibility(0);
            this.f14205k.setVisibility(8);
            setIdcardClck(this.f14198d);
            this.f14199e.setText("\u4e00\u8bc1\u901a\u67e5");
            this.f14200f.setText("\u4e2a\u4eba\u540d\u4e0b\u8d26\u6237\u6838\u67e5");
            this.f14203i.setImageResource(R.mipmap.iv_card_ck);
        }
        if (zContains2) {
            this.f14198d.setVisibility(0);
            this.f14205k.setVisibility(0);
            setViewClck(this.f14198d);
            setIdcardClck(this.f14205k);
            this.f14199e.setText("\u98ce\u9669\u67e5\u8be2");
            this.f14200f.setText("\u652f\u4ed8\u793e\u4ea4\u8d26\u53f7\u6838\u9a8c");
            this.f14203i.setImageResource(R.drawable.iv_virus_check);
            this.f14201g.setText("\u4e00\u8bc1\u901a\u67e5");
            this.f14202h.setText("\u4e2a\u4eba\u540d\u4e0b\u8d26\u6237\u6838\u67e5");
            this.f14204j.setImageResource(R.mipmap.iv_card_ck);
        }
        this.f14206l.setVisibility(0);
    }

    public void setTypeface(Typeface typeface) {
        this.f14196b.setTypeface(typeface);
    }

    public StandardView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    private void b(boolean z) {
        ViewStub viewStub = this.f14207m;
        if (viewStub != null) {
            if (z) {
                if (this.q == null) {
                    this.q = new d();
                    this.f14207m.setOnInflateListener(this.q);
                }
                this.f14207m.setVisibility(0);
                return;
            }
            viewStub.setVisibility(8);
        }
    }

    public void a() {
        boolean zD = o1.d();
        boolean zA = c2.a(c2.z0, false);
        boolean zA2 = c2.a(c2.A0, false);
        if ((zD && !zA) || !zA2) {
            if (TextUtils.equals(WelocmPresenter.VIRAPPCHECK, "1")) {
                g();
                new k2(this.a, k2.f14934e);
                return;
            } else {
                c();
                return;
            }
        }
        c();
    }

    public /* synthetic */ void c(View view) {
        this.r.dismiss();
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(this.a, r1.u.r());
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = "gh_9f4553e6eccf";
        req.miniprogramType = 0;
        iwxapiCreateWXAPI.sendReq(req);
    }

    public void b() {
        BaseDialog baseDialog = this.r;
        if (baseDialog == null || !baseDialog.isShowing()) {
            this.r = new BaseDialog(this.a, R.style.base_dialog_style);
            this.r.setContentView(R.layout.card_dlg);
            this.r.setGravityLayout(2);
            this.r.setWidthDialog(-2.0d);
            this.r.setHeightDialogdp(-2.0f);
            this.r.setCancelable(false);
            this.r.setCanceledOnTouchOutside(false);
            this.r.initOnCreate();
            this.r.show();
            Button button = (Button) this.r.findViewById(R.id.btn_acc_phone);
            Button button2 = (Button) this.r.findViewById(R.id.btn_card);
            ((ImageView) this.r.findViewById(R.id.iv_close)).setOnClickListener(new View.OnClickListener() { // from class: ui.fragment.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.b(view);
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: ui.fragment.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.c(view);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: ui.fragment.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.d(view);
                }
            });
        }
    }

    private void a(boolean z) {
        if (this.o != null) {
            b(false);
            a(this.o);
        }
        ImageView imageView = this.f14208n;
        if (imageView != null) {
            imageView.setVisibility(0);
            if (z) {
                this.f14208n.setImageResource(R.drawable.iv_scan_afrad);
            } else {
                this.f14208n.setImageResource(R.drawable.iv_fraud_check);
            }
        }
    }

    private void a(ImageView imageView) {
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

    public /* synthetic */ void d(View view) {
        this.r.dismiss();
        Intent launchIntentForPackage = this.a.getPackageManager().getLaunchIntentForPackage("com.unionpay");
        if (launchIntentForPackage != null) {
            this.a.startActivity(launchIntentForPackage);
        } else {
            f1.a(this.a, "\u6e29\u99a8\u63d0\u793a", "\u8bf7\u60a8\u5148\u4ece\u5e94\u7528\u5546\u5e97\u4e0b\u8f7d\u4e91\u95ea\u4ed8APP\uff0c\u5b89\u88c5\u540e\u518d\u67e5\u8be2\uff01", "\u786e\u5b9a", (IOneClickListener) null);
        }
    }

    public /* synthetic */ void a(View view) {
        c2.b(c2.L0);
        Activity activity = this.a;
        activity.startActivity(new Intent(activity, (Class<?>) AIVerifyActivity.class));
    }

    public /* synthetic */ void b(View view) {
        this.r.dismiss();
    }
}
