package ui.activity;

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
import com.hicorenational.antifraud.R;
import ui.view.swip.SwipBackLayout;

/* JADX INFO: compiled from: SignAppDetailActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010N\u001a\u00020OH\u0016J\u0006\u0010P\u001a\u00020OJ\u0010\u0010Q\u001a\u00020O2\u0006\u0010R\u001a\u00020\u001cH\u0007J\b\u0010S\u001a\u00020TH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010$\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001e\u0010'\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u00020+8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001e\u00103\u001a\u00020+8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R\u001e\u00106\u001a\u00020+8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010-\"\u0004\b8\u0010/R\u001e\u00109\u001a\u00020:8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0012\"\u0004\bA\u0010\u0014R\u001e\u0010B\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0012\"\u0004\bD\u0010\u0014R\u001e\u0010E\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0012\"\u0004\bG\u0010\u0014R\u001e\u0010H\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0012\"\u0004\bJ\u0010\u0014R\u001e\u0010K\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0012\"\u0004\bM\u0010\u0014\u00a8\u0006U"}, d2 = {"Lui/activity/SignAppDetailActivity;", "Lui/activity/BaseActivity;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "mAppBean", "Lbean/SurveyAppBean;", "getMAppBean", "()Lbean/SurveyAppBean;", "setMAppBean", "(Lbean/SurveyAppBean;)V", "mEtInvitationCode", "Landroid/widget/TextView;", "getMEtInvitationCode", "()Landroid/widget/TextView;", "setMEtInvitationCode", "(Landroid/widget/TextView;)V", "mEtVictimAccount", "getMEtVictimAccount", "setMEtVictimAccount", "mEtVictimPwd", "getMEtVictimPwd", "setMEtVictimPwd", "mFlAppInfo", "Landroid/view/View;", "getMFlAppInfo", "()Landroid/view/View;", "setMFlAppInfo", "(Landroid/view/View;)V", "mFlAppLogo", "getMFlAppLogo", "setMFlAppLogo", "mFlAppMnInfo", "getMFlAppMnInfo", "setMFlAppMnInfo", "mFlAppZxing", "getMFlAppZxing", "setMFlAppZxing", "mIvAppIcon", "Landroid/widget/ImageView;", "getMIvAppIcon", "()Landroid/widget/ImageView;", "setMIvAppIcon", "(Landroid/widget/ImageView;)V", "mIvAppLogo", "getMIvAppLogo", "setMIvAppLogo", "mIvAppZxing", "getMIvAppZxing", "setMIvAppZxing", "mIvBack", "getMIvBack", "setMIvBack", "mLlInvitationCode", "Landroid/widget/LinearLayout;", "getMLlInvitationCode", "()Landroid/widget/LinearLayout;", "setMLlInvitationCode", "(Landroid/widget/LinearLayout;)V", "mTvAppName", "getMTvAppName", "setMTvAppName", "mTvAppNameMn", "getMTvAppNameMn", "setMTvAppNameMn", "mTvAppPkg", "getMTvAppPkg", "setMTvAppPkg", "mTvAppVers", "getMTvAppVers", "setMTvAppVers", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "initViewData", "onClick", "view", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class SignAppDetailActivity extends BaseActivity {

    @j.c.a.e
    private SurveyAppBean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @j.c.a.d
    private String f13790b = "";

    @BindView(R.id.et_app_invitationCode)
    @j.c.a.d
    public TextView mEtInvitationCode;

    @BindView(R.id.et_app_victimAccount)
    @j.c.a.d
    public TextView mEtVictimAccount;

    @BindView(R.id.et_app_victimPwd)
    @j.c.a.d
    public TextView mEtVictimPwd;

    @BindView(R.id.fl_app_view)
    @j.c.a.d
    public View mFlAppInfo;

    @BindView(R.id.fl_app_logo)
    @j.c.a.d
    public View mFlAppLogo;

    @BindView(R.id.fl_app_mini)
    @j.c.a.d
    public View mFlAppMnInfo;

    @BindView(R.id.fl_app_zxing)
    @j.c.a.d
    public View mFlAppZxing;

    @BindView(R.id.iv_app_icon)
    @j.c.a.d
    public ImageView mIvAppIcon;

    @BindView(R.id.iv_app_logo)
    @j.c.a.d
    public ImageView mIvAppLogo;

    @BindView(R.id.iv_zxing)
    @j.c.a.d
    public ImageView mIvAppZxing;

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.ll_invitationCode)
    @j.c.a.d
    public LinearLayout mLlInvitationCode;

    @BindView(R.id.tv_app_name)
    @j.c.a.d
    public TextView mTvAppName;

    @BindView(R.id.tv_app_name_mini)
    @j.c.a.d
    public TextView mTvAppNameMn;

    @BindView(R.id.tv_app_pkg)
    @j.c.a.d
    public TextView mTvAppPkg;

    @BindView(R.id.tv_app_vers)
    @j.c.a.d
    public TextView mTvAppVers;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;

    public final void a(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvAppZxing = imageView;
    }

    @j.c.a.d
    public final View b() {
        View view = this.mFlAppMnInfo;
        if (view == null) {
            i.q2.t.i0.k("mFlAppMnInfo");
        }
        return view;
    }

    @j.c.a.d
    public final ImageView c() {
        ImageView imageView = this.mIvAppZxing;
        if (imageView == null) {
            i.q2.t.i0.k("mIvAppZxing");
        }
        return imageView;
    }

    public final void d(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvAppNameMn = textView;
    }

    @j.c.a.d
    public final TextView e() {
        TextView textView = this.mTvAppNameMn;
        if (textView == null) {
            i.q2.t.i0.k("mTvAppNameMn");
        }
        return textView;
    }

    @j.c.a.d
    public final String getCaseInfoId() {
        return this.f13790b;
    }

    @j.c.a.e
    public final SurveyAppBean getMAppBean() {
        return this.a;
    }

    @j.c.a.d
    public final TextView getMEtInvitationCode() {
        TextView textView = this.mEtInvitationCode;
        if (textView == null) {
            i.q2.t.i0.k("mEtInvitationCode");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMEtVictimAccount() {
        TextView textView = this.mEtVictimAccount;
        if (textView == null) {
            i.q2.t.i0.k("mEtVictimAccount");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMEtVictimPwd() {
        TextView textView = this.mEtVictimPwd;
        if (textView == null) {
            i.q2.t.i0.k("mEtVictimPwd");
        }
        return textView;
    }

    @j.c.a.d
    public final View getMFlAppInfo() {
        View view = this.mFlAppInfo;
        if (view == null) {
            i.q2.t.i0.k("mFlAppInfo");
        }
        return view;
    }

    @j.c.a.d
    public final View getMFlAppZxing() {
        View view = this.mFlAppZxing;
        if (view == null) {
            i.q2.t.i0.k("mFlAppZxing");
        }
        return view;
    }

    @j.c.a.d
    public final ImageView getMIvAppIcon() {
        ImageView imageView = this.mIvAppIcon;
        if (imageView == null) {
            i.q2.t.i0.k("mIvAppIcon");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvAppLogo() {
        ImageView imageView = this.mIvAppLogo;
        if (imageView == null) {
            i.q2.t.i0.k("mIvAppLogo");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            i.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @j.c.a.d
    public final TextView getMTvAppName() {
        TextView textView = this.mTvAppName;
        if (textView == null) {
            i.q2.t.i0.k("mTvAppName");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvAppPkg() {
        TextView textView = this.mTvAppPkg;
        if (textView == null) {
            i.q2.t.i0.k("mTvAppPkg");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvAppVers() {
        TextView textView = this.mTvAppVers;
        if (textView == null) {
            i.q2.t.i0.k("mTvAppVers");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("APP\u4fe1\u606f");
        initViewData();
    }

    public final void initViewData() {
        this.a = (SurveyAppBean) getIntent().getSerializableExtra(util.p1.f15011c);
        String stringExtra = getIntent().getStringExtra(util.p1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f13790b = stringExtra;
        SurveyAppBean surveyAppBean = this.a;
        if (surveyAppBean != null) {
            if (TextUtils.isEmpty(surveyAppBean != null ? surveyAppBean.getPackageFileUrl() : null)) {
                View view = this.mFlAppInfo;
                if (view == null) {
                    i.q2.t.i0.k("mFlAppInfo");
                }
                view.setVisibility(8);
                View view2 = this.mFlAppMnInfo;
                if (view2 == null) {
                    i.q2.t.i0.k("mFlAppMnInfo");
                }
                view2.setVisibility(0);
                TextView textView = this.mTvAppNameMn;
                if (textView == null) {
                    i.q2.t.i0.k("mTvAppNameMn");
                }
                SurveyAppBean surveyAppBean2 = this.a;
                textView.setText(surveyAppBean2 != null ? surveyAppBean2.getAppName() : null);
            } else {
                View view3 = this.mFlAppInfo;
                if (view3 == null) {
                    i.q2.t.i0.k("mFlAppInfo");
                }
                view3.setVisibility(0);
                View view4 = this.mFlAppMnInfo;
                if (view4 == null) {
                    i.q2.t.i0.k("mFlAppMnInfo");
                }
                view4.setVisibility(8);
                TextView textView2 = this.mTvAppName;
                if (textView2 == null) {
                    i.q2.t.i0.k("mTvAppName");
                }
                SurveyAppBean surveyAppBean3 = this.a;
                textView2.setText(surveyAppBean3 != null ? surveyAppBean3.getAppName() : null);
                TextView textView3 = this.mTvAppVers;
                if (textView3 == null) {
                    i.q2.t.i0.k("mTvAppVers");
                }
                SurveyAppBean surveyAppBean4 = this.a;
                textView3.setText(surveyAppBean4 != null ? surveyAppBean4.getAppVersion() : null);
                TextView textView4 = this.mTvAppPkg;
                if (textView4 == null) {
                    i.q2.t.i0.k("mTvAppPkg");
                }
                SurveyAppBean surveyAppBean5 = this.a;
                textView4.setText(surveyAppBean5 != null ? surveyAppBean5.getPackageName() : null);
                SurveyAppBean surveyAppBean6 = this.a;
                String appName = surveyAppBean6 != null ? surveyAppBean6.getAppName() : null;
                SurveyAppBean surveyAppBean7 = this.a;
                Bitmap bitmapA = k.c.a(appName, surveyAppBean7 != null ? surveyAppBean7.getAppVersion() : null, k.c.f12653f);
                ImageView imageView = this.mIvAppIcon;
                if (imageView == null) {
                    i.q2.t.i0.k("mIvAppIcon");
                }
                imageView.setImageBitmap(bitmapA);
            }
            SurveyAppBean surveyAppBean8 = this.a;
            if (TextUtils.isEmpty(surveyAppBean8 != null ? surveyAppBean8.getAppLogoFileUrl() : null)) {
                View view5 = this.mFlAppLogo;
                if (view5 == null) {
                    i.q2.t.i0.k("mFlAppLogo");
                }
                view5.setVisibility(8);
            } else {
                View view6 = this.mFlAppLogo;
                if (view6 == null) {
                    i.q2.t.i0.k("mFlAppLogo");
                }
                view6.setVisibility(0);
                ImageView imageView2 = this.mIvAppLogo;
                if (imageView2 == null) {
                    i.q2.t.i0.k("mIvAppLogo");
                }
                SurveyAppBean surveyAppBean9 = this.a;
                k.d.b(imageView2, surveyAppBean9 != null ? surveyAppBean9.getAppLogoFileUrl() : null);
            }
            SurveyAppBean surveyAppBean10 = this.a;
            if (TextUtils.isEmpty(surveyAppBean10 != null ? surveyAppBean10.getQrCodeFileUrl() : null)) {
                View view7 = this.mFlAppZxing;
                if (view7 == null) {
                    i.q2.t.i0.k("mFlAppZxing");
                }
                view7.setVisibility(8);
            } else {
                View view8 = this.mFlAppZxing;
                if (view8 == null) {
                    i.q2.t.i0.k("mFlAppZxing");
                }
                view8.setVisibility(0);
                ImageView imageView3 = this.mIvAppZxing;
                if (imageView3 == null) {
                    i.q2.t.i0.k("mIvAppZxing");
                }
                SurveyAppBean surveyAppBean11 = this.a;
                k.d.b(imageView3, surveyAppBean11 != null ? surveyAppBean11.getQrCodeFileUrl() : null);
            }
            SurveyAppBean surveyAppBean12 = this.a;
            if (!TextUtils.isEmpty(surveyAppBean12 != null ? surveyAppBean12.getVictimAccount() : null)) {
                TextView textView5 = this.mEtVictimAccount;
                if (textView5 == null) {
                    i.q2.t.i0.k("mEtVictimAccount");
                }
                SurveyAppBean surveyAppBean13 = this.a;
                textView5.setText(surveyAppBean13 != null ? surveyAppBean13.getVictimAccount() : null);
            }
            SurveyAppBean surveyAppBean14 = this.a;
            if (!TextUtils.isEmpty(surveyAppBean14 != null ? surveyAppBean14.getVictimPwd() : null)) {
                TextView textView6 = this.mEtVictimPwd;
                if (textView6 == null) {
                    i.q2.t.i0.k("mEtVictimPwd");
                }
                SurveyAppBean surveyAppBean15 = this.a;
                textView6.setText(surveyAppBean15 != null ? surveyAppBean15.getVictimPwd() : null);
            }
            SurveyAppBean surveyAppBean16 = this.a;
            if (!TextUtils.isEmpty(surveyAppBean16 != null ? surveyAppBean16.getInvitationCode() : null)) {
                TextView textView7 = this.mEtInvitationCode;
                if (textView7 == null) {
                    i.q2.t.i0.k("mEtInvitationCode");
                }
                SurveyAppBean surveyAppBean17 = this.a;
                textView7.setText(surveyAppBean17 != null ? surveyAppBean17.getInvitationCode() : null);
                return;
            }
            LinearLayout linearLayout = this.mLlInvitationCode;
            if (linearLayout == null) {
                i.q2.t.i0.k("mLlInvitationCode");
            }
            linearLayout.setVisibility(8);
            TextView textView8 = this.mEtInvitationCode;
            if (textView8 == null) {
                i.q2.t.i0.k("mEtInvitationCode");
            }
            textView8.setVisibility(8);
        }
    }

    @OnClick({R.id.iv_back, R.id.iv_zxing, R.id.iv_app_logo})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_app_logo) {
            Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
            SurveyAppBean surveyAppBean = this.a;
            intent.putExtra(PreviewPictureActivity.f13588i, surveyAppBean != null ? surveyAppBean.getAppLogoFileUrl() : null);
            startActivity(intent);
            return;
        }
        if (id == R.id.iv_back) {
            onBackPressed();
        } else {
            if (id != R.id.iv_zxing) {
                return;
            }
            Intent intent2 = new Intent(this, (Class<?>) PreviewPictureActivity.class);
            SurveyAppBean surveyAppBean2 = this.a;
            intent2.putExtra(PreviewPictureActivity.f13588i, surveyAppBean2 != null ? surveyAppBean2.getQrCodeFileUrl() : null);
            startActivity(intent2);
        }
    }

    public final void setCaseInfoId(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.f13790b = str;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_sign_app_detial;
    }

    public final void setMAppBean(@j.c.a.e SurveyAppBean surveyAppBean) {
        this.a = surveyAppBean;
    }

    public final void setMFlAppInfo(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mFlAppInfo = view;
    }

    public final void setMFlAppLogo(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mFlAppLogo = view;
    }

    public final void setMFlAppMnInfo(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mFlAppMnInfo = view;
    }

    public final void setMFlAppZxing(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mFlAppZxing = view;
    }

    public final void setMIvAppIcon(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvAppIcon = imageView;
    }

    public final void setMIvAppLogo(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvAppLogo = imageView;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMTvAppName(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvAppName = textView;
    }

    public final void setMTvAppPkg(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvAppPkg = textView;
    }

    public final void setMTvAppVers(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvAppVers = textView;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    @j.c.a.d
    public final View a() {
        View view = this.mFlAppLogo;
        if (view == null) {
            i.q2.t.i0.k("mFlAppLogo");
        }
        return view;
    }

    public final void b(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mEtVictimAccount = textView;
    }

    public final void c(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mEtVictimPwd = textView;
    }

    @j.c.a.d
    public final LinearLayout d() {
        LinearLayout linearLayout = this.mLlInvitationCode;
        if (linearLayout == null) {
            i.q2.t.i0.k("mLlInvitationCode");
        }
        return linearLayout;
    }

    public final void a(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mEtInvitationCode = textView;
    }

    public final void a(@j.c.a.d LinearLayout linearLayout) {
        i.q2.t.i0.f(linearLayout, "<set-?>");
        this.mLlInvitationCode = linearLayout;
    }
}
