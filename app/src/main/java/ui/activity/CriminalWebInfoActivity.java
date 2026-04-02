package ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.WebInfoNumBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import ui.callview.WebInfoCallView;
import ui.presenter.CriminalWebInfoPresenter;
import ui.view.swip.SwipBackLayout;

/* JADX INFO: compiled from: CriminalWebInfoActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020/H\u0007J\b\u00100\u001a\u00020,H\u0014J\u0012\u00101\u001a\u00020,2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\u001d8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001e\u0010%\u001a\u00020\u001d8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001e\u0010(\u001a\u00020\u001d8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!\u00a8\u00065"}, d2 = {"Lui/activity/CriminalWebInfoActivity;", "Lui/activity/BaseActivity;", "Lui/callview/WebInfoCallView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "itemPos", "", "getItemPos", "()I", "setItemPos", "(I)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/CriminalWebInfoPresenter;", "getMPresenter", "()Lui/presenter/CriminalWebInfoPresenter;", "setMPresenter", "(Lui/presenter/CriminalWebInfoPresenter;)V", "mTvAppNum", "Landroid/widget/TextView;", "getMTvAppNum", "()Landroid/widget/TextView;", "setMTvAppNum", "(Landroid/widget/TextView;)V", "mTvSocialNum", "getMTvSocialNum", "setMTvSocialNum", "mTvTitle", "getMTvTitle", "setMTvTitle", "mTvWebsiteNum", "getMTvWebsiteNum", "setMTvWebsiteNum", "initPage", "", "onClick", "view", "Landroid/view/View;", "onResume", "onSuccess", "result", "Lbean/WebInfoNumBean;", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class CriminalWebInfoActivity extends BaseActivity implements WebInfoCallView {

    @j.c.a.d
    private String caseInfoId = "";
    private int itemPos;

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @j.c.a.e
    private CriminalWebInfoPresenter mPresenter;

    @BindView(R.id.tv_app_num)
    @j.c.a.d
    public TextView mTvAppNum;

    @BindView(R.id.tv_social_num)
    @j.c.a.d
    public TextView mTvSocialNum;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;

    @BindView(R.id.tv_website_num)
    @j.c.a.d
    public TextView mTvWebsiteNum;

    @j.c.a.d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    public final int getItemPos() {
        return this.itemPos;
    }

    @j.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            i.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @j.c.a.e
    public final CriminalWebInfoPresenter getMPresenter() {
        return this.mPresenter;
    }

    @j.c.a.d
    public final TextView getMTvAppNum() {
        TextView textView = this.mTvAppNum;
        if (textView == null) {
            i.q2.t.i0.k("mTvAppNum");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvSocialNum() {
        TextView textView = this.mTvSocialNum;
        if (textView == null) {
            i.q2.t.i0.k("mTvSocialNum");
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

    @j.c.a.d
    public final TextView getMTvWebsiteNum() {
        TextView textView = this.mTvWebsiteNum;
        if (textView == null) {
            i.q2.t.i0.k("mTvWebsiteNum");
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
        textView.setText("\u6dfb\u52a0\u5acc\u7591\u4eba\u4e92\u8054\u7f51\u4fe1\u606f");
        String stringExtra = getIntent().getStringExtra(util.p1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPresenter = new CriminalWebInfoPresenter(this.mActivity, this);
    }

    @OnClick({R.id.iv_back, R.id.cl_social, R.id.cl_app, R.id.cl_website})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.cl_app /* 2131296474 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) ReportAppActivity.class);
                intent.putExtra(util.p1.C0, this.caseInfoId);
                startActivity(intent);
                break;
            case R.id.cl_social /* 2131296486 */:
                Intent intent2 = new Intent(this.mActivity, (Class<?>) CriminalSocialActivity.class);
                intent2.putExtra(util.p1.C0, this.caseInfoId);
                startActivity(intent2);
                break;
            case R.id.cl_website /* 2131296489 */:
                Intent intent3 = new Intent(this.mActivity, (Class<?>) ReportWebsiteActivity.class);
                intent3.putExtra(util.p1.C0, this.caseInfoId);
                startActivity(intent3);
                break;
            case R.id.iv_back /* 2131296808 */:
                onBackPressed();
                break;
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        CriminalWebInfoPresenter criminalWebInfoPresenter = this.mPresenter;
        if (criminalWebInfoPresenter != null) {
            criminalWebInfoPresenter.getWebNum(this.caseInfoId);
        }
    }

    @Override // ui.callview.WebInfoCallView
    public void onSuccess(@j.c.a.e WebInfoNumBean webInfoNumBean) {
        if (webInfoNumBean == null) {
            i.q2.t.i0.f();
        }
        if (webInfoNumBean.getNetAccountCount() > 0) {
            TextView textView = this.mTvSocialNum;
            if (textView == null) {
                i.q2.t.i0.k("mTvSocialNum");
            }
            textView.setText(String.valueOf(webInfoNumBean.getNetAccountCount()));
        } else {
            TextView textView2 = this.mTvSocialNum;
            if (textView2 == null) {
                i.q2.t.i0.k("mTvSocialNum");
            }
            textView2.setText("");
        }
        if (webInfoNumBean.getAppCount() > 0) {
            TextView textView3 = this.mTvAppNum;
            if (textView3 == null) {
                i.q2.t.i0.k("mTvAppNum");
            }
            textView3.setText(String.valueOf(webInfoNumBean.getAppCount()));
        } else {
            TextView textView4 = this.mTvAppNum;
            if (textView4 == null) {
                i.q2.t.i0.k("mTvAppNum");
            }
            textView4.setText("");
        }
        if (webInfoNumBean.getUrlCount() > 0) {
            TextView textView5 = this.mTvWebsiteNum;
            if (textView5 == null) {
                i.q2.t.i0.k("mTvWebsiteNum");
            }
            textView5.setText(String.valueOf(webInfoNumBean.getUrlCount()));
            return;
        }
        TextView textView6 = this.mTvWebsiteNum;
        if (textView6 == null) {
            i.q2.t.i0.k("mTvWebsiteNum");
        }
        textView6.setText("");
    }

    public final void setCaseInfoId(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.caseInfoId = str;
    }

    public final void setItemPos(int i2) {
        this.itemPos = i2;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_criminal_web_info;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@j.c.a.e CriminalWebInfoPresenter criminalWebInfoPresenter) {
        this.mPresenter = criminalWebInfoPresenter;
    }

    public final void setMTvAppNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvAppNum = textView;
    }

    public final void setMTvSocialNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvSocialNum = textView;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setMTvWebsiteNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvWebsiteNum = textView;
    }
}
