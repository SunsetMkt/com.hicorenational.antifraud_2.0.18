package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.CallCriminalBean;
import bean.CriminalBean;
import bean.SocialCriminalBean;
import bean.UploadFileBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.presenter.GridViewPicPresenter;
import p388ui.presenter.RecyclerAudioPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;

/* compiled from: SignCriminalDetialActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010?\u001a\u00020@H\u0016J\u0006\u0010A\u001a\u00020@J\u0010\u0010B\u001a\u00020@2\u0006\u0010C\u001a\u00020%H\u0007J\b\u0010D\u001a\u00020@H\u0014J\b\u0010E\u001a\u00020FH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001e\u0010-\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u001e\u00100\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\u001e\u00103\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u00109\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\u001e\u0010<\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00106\"\u0004\b>\u00108¨\u0006G"}, m23546d2 = {"Lui/activity/SignCriminalDetialActivity;", "Lui/activity/BaseActivity;", "()V", "mBean", "Lbean/CriminalBean;", "getMBean", "()Lbean/CriminalBean;", "setMBean", "(Lbean/CriminalBean;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/GridViewPicPresenter;", "getMPresenter", "()Lui/presenter/GridViewPicPresenter;", "setMPresenter", "(Lui/presenter/GridViewPicPresenter;)V", "mPresenterAudio", "Lui/presenter/RecyclerAudioPresenter;", "getMPresenterAudio", "()Lui/presenter/RecyclerAudioPresenter;", "setMPresenterAudio", "(Lui/presenter/RecyclerAudioPresenter;)V", "mRecyView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mRecyclerAudio", "getMRecyclerAudio", "setMRecyclerAudio", "mRlAudioView", "Landroid/view/View;", "getMRlAudioView", "()Landroid/view/View;", "setMRlAudioView", "(Landroid/view/View;)V", "mRlPhoneView", "getMRlPhoneView", "setMRlPhoneView", "mRlPicView", "getMRlPicView", "setMRlPicView", "mRlSocityView", "getMRlSocityView", "setMRlSocityView", "mTvPhone", "Landroid/widget/TextView;", "getMTvPhone", "()Landroid/widget/TextView;", "setMTvPhone", "(Landroid/widget/TextView;)V", "mTvSocial", "getMTvSocial", "setMTvSocial", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "initView", "onClick", "view", "onPause", "setLayoutView", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignCriminalDetialActivity extends BaseActivity {

    /* renamed from: a */
    @InterfaceC5817e
    private RecyclerAudioPresenter f23120a;

    /* renamed from: b */
    @InterfaceC5817e
    private GridViewPicPresenter f23121b;

    /* renamed from: c */
    @InterfaceC5817e
    private CriminalBean f23122c;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRecyView;

    @BindView(C2113R.id.recyclerview_audio)
    @InterfaceC5816d
    public RecyclerView mRecyclerAudio;

    @BindView(C2113R.id.rl_audio_view)
    @InterfaceC5816d
    public View mRlAudioView;

    @BindView(C2113R.id.rl_phone_view)
    @InterfaceC5816d
    public View mRlPhoneView;

    @BindView(C2113R.id.rl_pic_view)
    @InterfaceC5816d
    public View mRlPicView;

    @BindView(C2113R.id.rl_socity_view)
    @InterfaceC5816d
    public View mRlSocityView;

    @BindView(C2113R.id.tv_phone_num)
    @InterfaceC5816d
    public TextView mTvPhone;

    @BindView(C2113R.id.tv_social_num)
    @InterfaceC5816d
    public TextView mTvSocial;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    /* renamed from: a */
    public final void m25341a(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvPhone = textView;
    }

    /* renamed from: b */
    public final void m25347b(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvSocial = textView;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final View m25348c() {
        View view = this.mRlAudioView;
        if (view == null) {
            C5544i0.m22554k("mRlAudioView");
        }
        return view;
    }

    @InterfaceC5816d
    /* renamed from: d */
    public final View m25349d() {
        View view = this.mRlPhoneView;
        if (view == null) {
            C5544i0.m22554k("mRlPhoneView");
        }
        return view;
    }

    @InterfaceC5816d
    /* renamed from: e */
    public final View m25350e() {
        View view = this.mRlPicView;
        if (view == null) {
            C5544i0.m22554k("mRlPicView");
        }
        return view;
    }

    @InterfaceC5816d
    /* renamed from: f */
    public final View m25351f() {
        View view = this.mRlSocityView;
        if (view == null) {
            C5544i0.m22554k("mRlSocityView");
        }
        return view;
    }

    @InterfaceC5816d
    /* renamed from: g */
    public final TextView m25352g() {
        TextView textView = this.mTvPhone;
        if (textView == null) {
            C5544i0.m22554k("mTvPhone");
        }
        return textView;
    }

    @InterfaceC5817e
    public final CriminalBean getMBean() {
        return this.f23122c;
    }

    @InterfaceC5816d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        return imageView;
    }

    @InterfaceC5817e
    public final GridViewPicPresenter getMPresenter() {
        return this.f23121b;
    }

    @InterfaceC5816d
    public final RecyclerView getMRecyView() {
        RecyclerView recyclerView = this.mRecyView;
        if (recyclerView == null) {
            C5544i0.m22554k("mRecyView");
        }
        return recyclerView;
    }

    @InterfaceC5816d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    @InterfaceC5816d
    /* renamed from: h */
    public final TextView m25353h() {
        TextView textView = this.mTvSocial;
        if (textView == null) {
            C5544i0.m22554k("mTvSocial");
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
        textView.setText("嫌疑人信息");
        initView();
    }

    public final void initView() {
        this.f23122c = (CriminalBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        this.f23120a = new RecyclerAudioPresenter(this.mActivity);
        RecyclerAudioPresenter recyclerAudioPresenter = this.f23120a;
        if (recyclerAudioPresenter != null) {
            RecyclerView recyclerView = this.mRecyclerAudio;
            if (recyclerView == null) {
                C5544i0.m22554k("mRecyclerAudio");
            }
            recyclerAudioPresenter.initRecycleWeb(recyclerView);
        }
        this.f23121b = new GridViewPicPresenter(this.mActivity);
        GridViewPicPresenter gridViewPicPresenter = this.f23121b;
        if (gridViewPicPresenter != null) {
            RecyclerView recyclerView2 = this.mRecyView;
            if (recyclerView2 == null) {
                C5544i0.m22554k("mRecyView");
            }
            gridViewPicPresenter.initRecycleWeb(recyclerView2);
        }
        if (this.f23122c != null) {
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            CriminalBean criminalBean = this.f23122c;
            List<CallCriminalBean> mobiles = criminalBean != null ? criminalBean.getMobiles() : null;
            CriminalBean criminalBean2 = this.f23122c;
            List<SocialCriminalBean> socialAccounts = criminalBean2 != null ? criminalBean2.getSocialAccounts() : null;
            CriminalBean criminalBean3 = this.f23122c;
            List<UploadFileBean> audios = criminalBean3 != null ? criminalBean3.getAudios() : null;
            CriminalBean criminalBean4 = this.f23122c;
            List<UploadFileBean> printscreens = criminalBean4 != null ? criminalBean4.getPrintscreens() : null;
            int i2 = 0;
            if (mobiles == null || mobiles.size() <= 0) {
                View view = this.mRlPhoneView;
                if (view == null) {
                    C5544i0.m22554k("mRlPhoneView");
                }
                view.setVisibility(8);
            } else {
                int size = mobiles.size();
                int i3 = 0;
                while (i3 < size) {
                    CallCriminalBean callCriminalBean = mobiles.get(i3);
                    C5544i0.m22521a((Object) callCriminalBean, "callBeans[index]");
                    stringBuffer.append(callCriminalBean.getAccount());
                    i3++;
                    if (mobiles == null || i3 != mobiles.size()) {
                        stringBuffer.append("\n");
                    }
                }
                TextView textView = this.mTvPhone;
                if (textView == null) {
                    C5544i0.m22554k("mTvPhone");
                }
                textView.setText(stringBuffer.toString());
            }
            if (socialAccounts == null || socialAccounts.size() <= 0) {
                View view2 = this.mRlSocityView;
                if (view2 == null) {
                    C5544i0.m22554k("mRlSocityView");
                }
                view2.setVisibility(8);
            } else {
                int size2 = socialAccounts.size();
                while (i2 < size2) {
                    SocialCriminalBean socialCriminalBean = socialAccounts.get(i2);
                    C5544i0.m22521a((Object) socialCriminalBean, "socialBeans[index]");
                    stringBuffer2.append(socialCriminalBean.getAccountTypeName());
                    stringBuffer2.append("  ");
                    SocialCriminalBean socialCriminalBean2 = socialAccounts.get(i2);
                    C5544i0.m22521a((Object) socialCriminalBean2, "socialBeans[index]");
                    stringBuffer2.append(socialCriminalBean2.getAccount());
                    i2++;
                    if (socialAccounts == null || i2 != socialAccounts.size()) {
                        stringBuffer2.append("\n");
                    }
                }
                TextView textView2 = this.mTvSocial;
                if (textView2 == null) {
                    C5544i0.m22554k("mTvSocial");
                }
                textView2.setText(stringBuffer2.toString());
            }
            if (audios == null || audios.size() <= 0) {
                View view3 = this.mRlAudioView;
                if (view3 == null) {
                    C5544i0.m22554k("mRlAudioView");
                }
                view3.setVisibility(8);
            } else {
                RecyclerAudioPresenter recyclerAudioPresenter2 = this.f23120a;
                if (recyclerAudioPresenter2 != null) {
                    recyclerAudioPresenter2.setListData(audios);
                }
            }
            if (printscreens == null || printscreens.size() <= 0) {
                View view4 = this.mRlPicView;
                if (view4 == null) {
                    C5544i0.m22554k("mRlPicView");
                }
                view4.setVisibility(8);
                return;
            }
            GridViewPicPresenter gridViewPicPresenter2 = this.f23121b;
            if (gridViewPicPresenter2 != null) {
                gridViewPicPresenter2.setListData(printscreens);
            }
        }
    }

    @OnClick({C2113R.id.iv_back})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        RecyclerAudioPresenter recyclerAudioPresenter = this.f23120a;
        if (recyclerAudioPresenter != null) {
            recyclerAudioPresenter.onPause();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_sign_criminal_detial;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMRecyView(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "<set-?>");
        this.mRecyView = recyclerView;
    }

    public final void setMRlAudioView(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mRlAudioView = view;
    }

    public final void setMRlPhoneView(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mRlPhoneView = view;
    }

    public final void setMRlPicView(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mRlPicView = view;
    }

    public final void setMRlSocityView(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mRlSocityView = view;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    /* renamed from: a */
    public final void m25342a(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "<set-?>");
        this.mRecyclerAudio = recyclerView;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public final RecyclerView m25346b() {
        RecyclerView recyclerView = this.mRecyclerAudio;
        if (recyclerView == null) {
            C5544i0.m22554k("mRecyclerAudio");
        }
        return recyclerView;
    }

    @InterfaceC5817e
    /* renamed from: a */
    public final RecyclerAudioPresenter m25340a() {
        return this.f23120a;
    }

    /* renamed from: a */
    public final void m25345a(@InterfaceC5817e RecyclerAudioPresenter recyclerAudioPresenter) {
        this.f23120a = recyclerAudioPresenter;
    }

    /* renamed from: a */
    public final void m25344a(@InterfaceC5817e GridViewPicPresenter gridViewPicPresenter) {
        this.f23121b = gridViewPicPresenter;
    }

    /* renamed from: a */
    public final void m25343a(@InterfaceC5817e CriminalBean criminalBean) {
        this.f23122c = criminalBean;
    }
}
