package p388ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bean.SurveyAppBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p357j.C5844c;
import p357j.C5845d;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;

/* compiled from: SignAppDetailActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010N\u001a\u00020OH\u0016J\u0006\u0010P\u001a\u00020OJ\u0010\u0010Q\u001a\u00020O2\u0006\u0010R\u001a\u00020\u001cH\u0007J\b\u0010S\u001a\u00020TH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010$\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001e\u0010'\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001e\u00103\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R\u001e\u00106\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010-\"\u0004\b8\u0010/R\u001e\u00109\u001a\u00020:8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0012\"\u0004\bA\u0010\u0014R\u001e\u0010B\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0012\"\u0004\bD\u0010\u0014R\u001e\u0010E\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0012\"\u0004\bG\u0010\u0014R\u001e\u0010H\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0012\"\u0004\bJ\u0010\u0014R\u001e\u0010K\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0012\"\u0004\bM\u0010\u0014¨\u0006U"}, m23546d2 = {"Lui/activity/SignAppDetailActivity;", "Lui/activity/BaseActivity;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "mAppBean", "Lbean/SurveyAppBean;", "getMAppBean", "()Lbean/SurveyAppBean;", "setMAppBean", "(Lbean/SurveyAppBean;)V", "mEtInvitationCode", "Landroid/widget/TextView;", "getMEtInvitationCode", "()Landroid/widget/TextView;", "setMEtInvitationCode", "(Landroid/widget/TextView;)V", "mEtVictimAccount", "getMEtVictimAccount", "setMEtVictimAccount", "mEtVictimPwd", "getMEtVictimPwd", "setMEtVictimPwd", "mFlAppInfo", "Landroid/view/View;", "getMFlAppInfo", "()Landroid/view/View;", "setMFlAppInfo", "(Landroid/view/View;)V", "mFlAppLogo", "getMFlAppLogo", "setMFlAppLogo", "mFlAppMnInfo", "getMFlAppMnInfo", "setMFlAppMnInfo", "mFlAppZxing", "getMFlAppZxing", "setMFlAppZxing", "mIvAppIcon", "Landroid/widget/ImageView;", "getMIvAppIcon", "()Landroid/widget/ImageView;", "setMIvAppIcon", "(Landroid/widget/ImageView;)V", "mIvAppLogo", "getMIvAppLogo", "setMIvAppLogo", "mIvAppZxing", "getMIvAppZxing", "setMIvAppZxing", "mIvBack", "getMIvBack", "setMIvBack", "mLlInvitationCode", "Landroid/widget/LinearLayout;", "getMLlInvitationCode", "()Landroid/widget/LinearLayout;", "setMLlInvitationCode", "(Landroid/widget/LinearLayout;)V", "mTvAppName", "getMTvAppName", "setMTvAppName", "mTvAppNameMn", "getMTvAppNameMn", "setMTvAppNameMn", "mTvAppPkg", "getMTvAppPkg", "setMTvAppPkg", "mTvAppVers", "getMTvAppVers", "setMTvAppVers", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "initViewData", "onClick", "view", "setLayoutView", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignAppDetailActivity extends BaseActivity {

    /* renamed from: a */
    @InterfaceC5817e
    private SurveyAppBean f23080a;

    /* renamed from: b */
    @InterfaceC5816d
    private String f23081b = "";

    @BindView(C2113R.id.et_app_invitationCode)
    @InterfaceC5816d
    public TextView mEtInvitationCode;

    @BindView(C2113R.id.et_app_victimAccount)
    @InterfaceC5816d
    public TextView mEtVictimAccount;

    @BindView(C2113R.id.et_app_victimPwd)
    @InterfaceC5816d
    public TextView mEtVictimPwd;

    @BindView(C2113R.id.fl_app_view)
    @InterfaceC5816d
    public View mFlAppInfo;

    @BindView(C2113R.id.fl_app_logo)
    @InterfaceC5816d
    public View mFlAppLogo;

    @BindView(C2113R.id.fl_app_mini)
    @InterfaceC5816d
    public View mFlAppMnInfo;

    @BindView(C2113R.id.fl_app_zxing)
    @InterfaceC5816d
    public View mFlAppZxing;

    @BindView(C2113R.id.iv_app_icon)
    @InterfaceC5816d
    public ImageView mIvAppIcon;

    @BindView(C2113R.id.iv_app_logo)
    @InterfaceC5816d
    public ImageView mIvAppLogo;

    @BindView(C2113R.id.iv_zxing)
    @InterfaceC5816d
    public ImageView mIvAppZxing;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.ll_invitationCode)
    @InterfaceC5816d
    public LinearLayout mLlInvitationCode;

    @BindView(C2113R.id.tv_app_name)
    @InterfaceC5816d
    public TextView mTvAppName;

    @BindView(C2113R.id.tv_app_name_mini)
    @InterfaceC5816d
    public TextView mTvAppNameMn;

    @BindView(C2113R.id.tv_app_pkg)
    @InterfaceC5816d
    public TextView mTvAppPkg;

    @BindView(C2113R.id.tv_app_vers)
    @InterfaceC5816d
    public TextView mTvAppVers;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    /* renamed from: a */
    public final void m25330a(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvAppZxing = imageView;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public final View m25333b() {
        View view = this.mFlAppMnInfo;
        if (view == null) {
            C5544i0.m22554k("mFlAppMnInfo");
        }
        return view;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final ImageView m25335c() {
        ImageView imageView = this.mIvAppZxing;
        if (imageView == null) {
            C5544i0.m22554k("mIvAppZxing");
        }
        return imageView;
    }

    /* renamed from: d */
    public final void m25338d(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvAppNameMn = textView;
    }

    @InterfaceC5816d
    /* renamed from: e */
    public final TextView m25339e() {
        TextView textView = this.mTvAppNameMn;
        if (textView == null) {
            C5544i0.m22554k("mTvAppNameMn");
        }
        return textView;
    }

    @InterfaceC5816d
    public final String getCaseInfoId() {
        return this.f23081b;
    }

    @InterfaceC5817e
    public final SurveyAppBean getMAppBean() {
        return this.f23080a;
    }

    @InterfaceC5816d
    public final TextView getMEtInvitationCode() {
        TextView textView = this.mEtInvitationCode;
        if (textView == null) {
            C5544i0.m22554k("mEtInvitationCode");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMEtVictimAccount() {
        TextView textView = this.mEtVictimAccount;
        if (textView == null) {
            C5544i0.m22554k("mEtVictimAccount");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMEtVictimPwd() {
        TextView textView = this.mEtVictimPwd;
        if (textView == null) {
            C5544i0.m22554k("mEtVictimPwd");
        }
        return textView;
    }

    @InterfaceC5816d
    public final View getMFlAppInfo() {
        View view = this.mFlAppInfo;
        if (view == null) {
            C5544i0.m22554k("mFlAppInfo");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMFlAppZxing() {
        View view = this.mFlAppZxing;
        if (view == null) {
            C5544i0.m22554k("mFlAppZxing");
        }
        return view;
    }

    @InterfaceC5816d
    public final ImageView getMIvAppIcon() {
        ImageView imageView = this.mIvAppIcon;
        if (imageView == null) {
            C5544i0.m22554k("mIvAppIcon");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvAppLogo() {
        ImageView imageView = this.mIvAppLogo;
        if (imageView == null) {
            C5544i0.m22554k("mIvAppLogo");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final TextView getMTvAppName() {
        TextView textView = this.mTvAppName;
        if (textView == null) {
            C5544i0.m22554k("mTvAppName");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvAppPkg() {
        TextView textView = this.mTvAppPkg;
        if (textView == null) {
            C5544i0.m22554k("mTvAppPkg");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvAppVers() {
        TextView textView = this.mTvAppVers;
        if (textView == null) {
            C5544i0.m22554k("mTvAppVers");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("APP信息");
        initViewData();
    }

    public final void initViewData() {
        this.f23080a = (SurveyAppBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f23081b = stringExtra;
        SurveyAppBean surveyAppBean = this.f23080a;
        if (surveyAppBean != null) {
            if (TextUtils.isEmpty(surveyAppBean != null ? surveyAppBean.getPackageFileUrl() : null)) {
                View view = this.mFlAppInfo;
                if (view == null) {
                    C5544i0.m22554k("mFlAppInfo");
                }
                view.setVisibility(8);
                View view2 = this.mFlAppMnInfo;
                if (view2 == null) {
                    C5544i0.m22554k("mFlAppMnInfo");
                }
                view2.setVisibility(0);
                TextView textView = this.mTvAppNameMn;
                if (textView == null) {
                    C5544i0.m22554k("mTvAppNameMn");
                }
                SurveyAppBean surveyAppBean2 = this.f23080a;
                textView.setText(surveyAppBean2 != null ? surveyAppBean2.getAppName() : null);
            } else {
                View view3 = this.mFlAppInfo;
                if (view3 == null) {
                    C5544i0.m22554k("mFlAppInfo");
                }
                view3.setVisibility(0);
                View view4 = this.mFlAppMnInfo;
                if (view4 == null) {
                    C5544i0.m22554k("mFlAppMnInfo");
                }
                view4.setVisibility(8);
                TextView textView2 = this.mTvAppName;
                if (textView2 == null) {
                    C5544i0.m22554k("mTvAppName");
                }
                SurveyAppBean surveyAppBean3 = this.f23080a;
                textView2.setText(surveyAppBean3 != null ? surveyAppBean3.getAppName() : null);
                TextView textView3 = this.mTvAppVers;
                if (textView3 == null) {
                    C5544i0.m22554k("mTvAppVers");
                }
                SurveyAppBean surveyAppBean4 = this.f23080a;
                textView3.setText(surveyAppBean4 != null ? surveyAppBean4.getAppVersion() : null);
                TextView textView4 = this.mTvAppPkg;
                if (textView4 == null) {
                    C5544i0.m22554k("mTvAppPkg");
                }
                SurveyAppBean surveyAppBean5 = this.f23080a;
                textView4.setText(surveyAppBean5 != null ? surveyAppBean5.getPackageName() : null);
                SurveyAppBean surveyAppBean6 = this.f23080a;
                String appName = surveyAppBean6 != null ? surveyAppBean6.getAppName() : null;
                SurveyAppBean surveyAppBean7 = this.f23080a;
                Bitmap m24589a = C5844c.m24589a(appName, surveyAppBean7 != null ? surveyAppBean7.getAppVersion() : null, C5844c.f21117f);
                ImageView imageView = this.mIvAppIcon;
                if (imageView == null) {
                    C5544i0.m22554k("mIvAppIcon");
                }
                imageView.setImageBitmap(m24589a);
            }
            SurveyAppBean surveyAppBean8 = this.f23080a;
            if (TextUtils.isEmpty(surveyAppBean8 != null ? surveyAppBean8.getAppLogoFileUrl() : null)) {
                View view5 = this.mFlAppLogo;
                if (view5 == null) {
                    C5544i0.m22554k("mFlAppLogo");
                }
                view5.setVisibility(8);
            } else {
                View view6 = this.mFlAppLogo;
                if (view6 == null) {
                    C5544i0.m22554k("mFlAppLogo");
                }
                view6.setVisibility(0);
                ImageView imageView2 = this.mIvAppLogo;
                if (imageView2 == null) {
                    C5544i0.m22554k("mIvAppLogo");
                }
                SurveyAppBean surveyAppBean9 = this.f23080a;
                C5845d.m24613b(imageView2, surveyAppBean9 != null ? surveyAppBean9.getAppLogoFileUrl() : null);
            }
            SurveyAppBean surveyAppBean10 = this.f23080a;
            if (TextUtils.isEmpty(surveyAppBean10 != null ? surveyAppBean10.getQrCodeFileUrl() : null)) {
                View view7 = this.mFlAppZxing;
                if (view7 == null) {
                    C5544i0.m22554k("mFlAppZxing");
                }
                view7.setVisibility(8);
            } else {
                View view8 = this.mFlAppZxing;
                if (view8 == null) {
                    C5544i0.m22554k("mFlAppZxing");
                }
                view8.setVisibility(0);
                ImageView imageView3 = this.mIvAppZxing;
                if (imageView3 == null) {
                    C5544i0.m22554k("mIvAppZxing");
                }
                SurveyAppBean surveyAppBean11 = this.f23080a;
                C5845d.m24613b(imageView3, surveyAppBean11 != null ? surveyAppBean11.getQrCodeFileUrl() : null);
            }
            SurveyAppBean surveyAppBean12 = this.f23080a;
            if (!TextUtils.isEmpty(surveyAppBean12 != null ? surveyAppBean12.getVictimAccount() : null)) {
                TextView textView5 = this.mEtVictimAccount;
                if (textView5 == null) {
                    C5544i0.m22554k("mEtVictimAccount");
                }
                SurveyAppBean surveyAppBean13 = this.f23080a;
                textView5.setText(surveyAppBean13 != null ? surveyAppBean13.getVictimAccount() : null);
            }
            SurveyAppBean surveyAppBean14 = this.f23080a;
            if (!TextUtils.isEmpty(surveyAppBean14 != null ? surveyAppBean14.getVictimPwd() : null)) {
                TextView textView6 = this.mEtVictimPwd;
                if (textView6 == null) {
                    C5544i0.m22554k("mEtVictimPwd");
                }
                SurveyAppBean surveyAppBean15 = this.f23080a;
                textView6.setText(surveyAppBean15 != null ? surveyAppBean15.getVictimPwd() : null);
            }
            SurveyAppBean surveyAppBean16 = this.f23080a;
            if (!TextUtils.isEmpty(surveyAppBean16 != null ? surveyAppBean16.getInvitationCode() : null)) {
                TextView textView7 = this.mEtInvitationCode;
                if (textView7 == null) {
                    C5544i0.m22554k("mEtInvitationCode");
                }
                SurveyAppBean surveyAppBean17 = this.f23080a;
                textView7.setText(surveyAppBean17 != null ? surveyAppBean17.getInvitationCode() : null);
                return;
            }
            LinearLayout linearLayout = this.mLlInvitationCode;
            if (linearLayout == null) {
                C5544i0.m22554k("mLlInvitationCode");
            }
            linearLayout.setVisibility(8);
            TextView textView8 = this.mEtInvitationCode;
            if (textView8 == null) {
                C5544i0.m22554k("mEtInvitationCode");
            }
            textView8.setVisibility(8);
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.iv_zxing, C2113R.id.iv_app_logo})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.iv_app_logo) {
            Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
            SurveyAppBean surveyAppBean = this.f23080a;
            intent.putExtra(PreviewPictureActivity.f22714i, surveyAppBean != null ? surveyAppBean.getAppLogoFileUrl() : null);
            startActivity(intent);
            return;
        }
        if (id == C2113R.id.iv_back) {
            onBackPressed();
        } else {
            if (id != C2113R.id.iv_zxing) {
                return;
            }
            Intent intent2 = new Intent(this, (Class<?>) PreviewPictureActivity.class);
            SurveyAppBean surveyAppBean2 = this.f23080a;
            intent2.putExtra(PreviewPictureActivity.f22714i, surveyAppBean2 != null ? surveyAppBean2.getQrCodeFileUrl() : null);
            startActivity(intent2);
        }
    }

    public final void setCaseInfoId(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.f23081b = str;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_sign_app_detial;
    }

    public final void setMAppBean(@InterfaceC5817e SurveyAppBean surveyAppBean) {
        this.f23080a = surveyAppBean;
    }

    public final void setMFlAppInfo(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mFlAppInfo = view;
    }

    public final void setMFlAppLogo(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mFlAppLogo = view;
    }

    public final void setMFlAppMnInfo(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mFlAppMnInfo = view;
    }

    public final void setMFlAppZxing(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mFlAppZxing = view;
    }

    public final void setMIvAppIcon(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvAppIcon = imageView;
    }

    public final void setMIvAppLogo(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvAppLogo = imageView;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMTvAppName(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvAppName = textView;
    }

    public final void setMTvAppPkg(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvAppPkg = textView;
    }

    public final void setMTvAppVers(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvAppVers = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final View m25329a() {
        View view = this.mFlAppLogo;
        if (view == null) {
            C5544i0.m22554k("mFlAppLogo");
        }
        return view;
    }

    /* renamed from: b */
    public final void m25334b(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mEtVictimAccount = textView;
    }

    /* renamed from: c */
    public final void m25336c(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mEtVictimPwd = textView;
    }

    @InterfaceC5816d
    /* renamed from: d */
    public final LinearLayout m25337d() {
        LinearLayout linearLayout = this.mLlInvitationCode;
        if (linearLayout == null) {
            C5544i0.m22554k("mLlInvitationCode");
        }
        return linearLayout;
    }

    /* renamed from: a */
    public final void m25332a(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mEtInvitationCode = textView;
    }

    /* renamed from: a */
    public final void m25331a(@InterfaceC5816d LinearLayout linearLayout) {
        C5544i0.m22546f(linearLayout, "<set-?>");
        this.mLlInvitationCode = linearLayout;
    }
}
