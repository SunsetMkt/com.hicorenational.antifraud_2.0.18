package p388ui.activity;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReportIDInfoBean;
import bean.SignComitBean;
import bean.SurveyPeopleBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import java.util.List;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.VictimPeopleView;
import p388ui.presenter.ReportCaseInfoPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;
import util.p395c2.C7265a;

/* compiled from: ReportCaseInfoActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010I\u001a\u00020JH\u0016J\u0006\u0010K\u001a\u00020JJ\u0010\u0010L\u001a\u00020J2\u0006\u0010M\u001a\u00020\u0011H\u0007J\b\u0010N\u001a\u00020JH\u0014J\u0010\u0010O\u001a\u00020J2\u0006\u0010P\u001a\u00020QH\u0007J\u0018\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020)2\u0006\u0010U\u001a\u00020VH\u0016J\b\u0010W\u001a\u00020JH\u0014J\u0012\u0010X\u001a\u00020J2\b\u0010Y\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010Z\u001a\u00020JH\u0016J\u0016\u0010[\u001a\u00020J2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020^0]H\u0016J\u0006\u0010_\u001a\u00020JJ\b\u0010`\u001a\u00020)H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001e\u0010\u001f\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001e\u0010\"\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001e\u0010%\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0002058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u00020;8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001e\u0010@\u001a\u00020;8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006a"}, m23546d2 = {"Lui/activity/ReportCaseInfoActivity;", "Lui/activity/BaseActivity;", "Lui/callview/VictimPeopleView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "comitNumBean", "Lbean/SignComitBean;", "getComitNumBean", "()Lbean/SignComitBean;", "setComitNumBean", "(Lbean/SignComitBean;)V", "mFlBottomView", "Landroid/view/View;", "getMFlBottomView", "()Landroid/view/View;", "setMFlBottomView", "(Landroid/view/View;)V", "mInvolveAccTip", "Landroid/widget/ImageView;", "getMInvolveAccTip", "()Landroid/widget/ImageView;", "setMInvolveAccTip", "(Landroid/widget/ImageView;)V", "mIvBack", "getMIvBack", "setMIvBack", "mIvCallTip", "getMIvCallTip", "setMIvCallTip", "mIvSmsTip", "getMIvSmsTip", "setMIvSmsTip", "mIvWebNetTip", "getMIvWebNetTip", "setMIvWebNetTip", "mMaxNum", "", "getMMaxNum", "()I", "setMMaxNum", "(I)V", "mPresenter", "Lui/presenter/ReportCaseInfoPresenter;", "getMPresenter", "()Lui/presenter/ReportCaseInfoPresenter;", "setMPresenter", "(Lui/presenter/ReportCaseInfoPresenter;)V", "mRvList", "Landroidx/recyclerview/widget/RecyclerView;", "getMRvList", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRvList", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvAdd", "Landroid/widget/TextView;", "getMTvAdd", "()Landroid/widget/TextView;", "setMTvAdd", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "reportIDBean", "Lbean/ReportIDInfoBean;", "getReportIDBean", "()Lbean/ReportIDInfoBean;", "setReportIDBean", "(Lbean/ReportIDInfoBean;)V", "initPage", "", "initView", "onClick", "view", "onDestroy", "onEventMainThread", "refreshUIEvent", "Lutil/event/RefreshUIEvent;", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onResume", "onSuccessCaseNum", "bean", "onSuccessDelet", "onSuccessHandle", "list", "", "Lbean/SurveyPeopleBean;", "onkeyback", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ReportCaseInfoActivity extends BaseActivity implements VictimPeopleView {

    @InterfaceC5817e
    private SignComitBean comitNumBean;

    @BindView(C2113R.id.fl_bottom_view)
    @InterfaceC5816d
    public View mFlBottomView;

    @BindView(C2113R.id.involved_acc_tip)
    @InterfaceC5816d
    public ImageView mInvolveAccTip;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.iv_call_tip)
    @InterfaceC5816d
    public ImageView mIvCallTip;

    @BindView(C2113R.id.iv_sms_tip)
    @InterfaceC5816d
    public ImageView mIvSmsTip;

    @BindView(C2113R.id.iv_webnet_tip)
    @InterfaceC5816d
    public ImageView mIvWebNetTip;

    @InterfaceC5817e
    private ReportCaseInfoPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRvList;

    @BindView(C2113R.id.tv_add)
    @InterfaceC5816d
    public TextView mTvAdd;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    @InterfaceC5817e
    private ReportIDInfoBean reportIDBean;

    @InterfaceC5816d
    private String caseInfoId = "";
    private int mMaxNum = 10;

    /* compiled from: ReportCaseInfoActivity.kt */
    /* renamed from: ui.activity.ReportCaseInfoActivity$a */
    public static final class C6493a implements IClickListener {
        C6493a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            ReportCaseInfoActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    @InterfaceC5816d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    @InterfaceC5817e
    public final SignComitBean getComitNumBean() {
        return this.comitNumBean;
    }

    @InterfaceC5816d
    public final View getMFlBottomView() {
        View view = this.mFlBottomView;
        if (view == null) {
            C5544i0.m22554k("mFlBottomView");
        }
        return view;
    }

    @InterfaceC5816d
    public final ImageView getMInvolveAccTip() {
        ImageView imageView = this.mInvolveAccTip;
        if (imageView == null) {
            C5544i0.m22554k("mInvolveAccTip");
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
    public final ImageView getMIvCallTip() {
        ImageView imageView = this.mIvCallTip;
        if (imageView == null) {
            C5544i0.m22554k("mIvCallTip");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvSmsTip() {
        ImageView imageView = this.mIvSmsTip;
        if (imageView == null) {
            C5544i0.m22554k("mIvSmsTip");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvWebNetTip() {
        ImageView imageView = this.mIvWebNetTip;
        if (imageView == null) {
            C5544i0.m22554k("mIvWebNetTip");
        }
        return imageView;
    }

    public final int getMMaxNum() {
        return this.mMaxNum;
    }

    @InterfaceC5817e
    public final ReportCaseInfoPresenter getMPresenter() {
        return this.mPresenter;
    }

    @InterfaceC5816d
    public final RecyclerView getMRvList() {
        RecyclerView recyclerView = this.mRvList;
        if (recyclerView == null) {
            C5544i0.m22554k("mRvList");
        }
        return recyclerView;
    }

    @InterfaceC5816d
    public final TextView getMTvAdd() {
        TextView textView = this.mTvAdd;
        if (textView == null) {
            C5544i0.m22554k("mTvAdd");
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

    @InterfaceC5817e
    public final ReportIDInfoBean getReportIDBean() {
        return this.reportIDBean;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("填写报案信息");
        TextView textView2 = this.mTvAdd;
        if (textView2 == null) {
            C5544i0.m22554k("mTvAdd");
        }
        if (textView2 == null) {
            C5544i0.m22545f();
        }
        textView2.setText("添加事主信息");
        initView();
    }

    public final void initView() {
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.reportIDBean = (ReportIDInfoBean) getIntent().getSerializableExtra(C7292k1.f25388b);
        this.mPresenter = new ReportCaseInfoPresenter(this.mActivity, this.caseInfoId, this);
        ReportCaseInfoPresenter reportCaseInfoPresenter = this.mPresenter;
        if (reportCaseInfoPresenter != null) {
            RecyclerView recyclerView = this.mRvList;
            if (recyclerView == null) {
                C5544i0.m22554k("mRvList");
            }
            reportCaseInfoPresenter.initRecyclePeop(recyclerView);
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_add, C2113R.id.rl_involved_acc, C2113R.id.rl_crime_phone, C2113R.id.rl_sms_item, C2113R.id.rl_webnet_item, C2113R.id.btn_commit})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_commit /* 2131296395 */:
                SignComitBean signComitBean = this.comitNumBean;
                if (signComitBean != null) {
                    if (signComitBean != null && signComitBean.getVictimCount() == 0) {
                        C7331w1.m26688a("请填写事主信息");
                        break;
                    } else {
                        SignComitBean signComitBean2 = this.comitNumBean;
                        if (signComitBean2 != null && signComitBean2.getPaymentCount() == 0) {
                            C7331w1.m26688a("请填写涉案账户信息");
                            break;
                        } else {
                            ImageView imageView = this.mIvCallTip;
                            if (imageView == null) {
                                C5544i0.m22554k("mIvCallTip");
                            }
                            if (!imageView.isShown()) {
                                ImageView imageView2 = this.mIvSmsTip;
                                if (imageView2 == null) {
                                    C5544i0.m22554k("mIvSmsTip");
                                }
                                if (!imageView2.isShown()) {
                                    ImageView imageView3 = this.mIvWebNetTip;
                                    if (imageView3 == null) {
                                        C5544i0.m22554k("mIvWebNetTip");
                                    }
                                    if (!imageView3.isShown()) {
                                        C7331w1.m26688a("请完善报案信息");
                                        break;
                                    }
                                }
                            }
                            Intent intent = new Intent(this.mActivity, (Class<?>) ReportSignCommitActivity.class);
                            intent.putExtra(C7292k1.f25338C0, this.caseInfoId);
                            intent.putExtra(C7292k1.f25391c, this.comitNumBean);
                            intent.putExtra(C7292k1.f25388b, this.reportIDBean);
                            startActivity(intent);
                            break;
                        }
                    }
                }
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                onkeyback();
                break;
            case C2113R.id.ll_add /* 2131296914 */:
                RecyclerView recyclerView = this.mRvList;
                if (recyclerView == null) {
                    C5544i0.m22554k("mRvList");
                }
                if (recyclerView.getAdapter() != null) {
                    RecyclerView recyclerView2 = this.mRvList;
                    if (recyclerView2 == null) {
                        C5544i0.m22554k("mRvList");
                    }
                    RecyclerView.Adapter adapter2 = recyclerView2.getAdapter();
                    if (adapter2 == null) {
                        C5544i0.m22545f();
                    }
                    C5544i0.m22521a((Object) adapter2, "mRvList.adapter!!");
                    if (adapter2.getItemCount() >= this.mMaxNum) {
                        C7331w1.m26688a("最多添加" + String.valueOf(this.mMaxNum) + "组事主信息");
                        break;
                    }
                }
                Intent intent2 = new Intent(this.mActivity, (Class<?>) VictimActivity.class);
                intent2.putExtra(C7292k1.f25338C0, this.caseInfoId);
                startActivity(intent2);
                break;
            case C2113R.id.rl_crime_phone /* 2131297191 */:
                Intent intent3 = new Intent(this.mActivity, (Class<?>) AddCrimePhoneActivity.class);
                intent3.putExtra(C7292k1.f25338C0, this.caseInfoId);
                startActivity(intent3);
                break;
            case C2113R.id.rl_involved_acc /* 2131297193 */:
                Intent intent4 = new Intent(this.mActivity, (Class<?>) AccountListActivity.class);
                intent4.putExtra(C7292k1.f25338C0, this.caseInfoId);
                startActivity(intent4);
                break;
            case C2113R.id.rl_sms_item /* 2131297200 */:
                Intent intent5 = new Intent(this.mActivity, (Class<?>) CriminalSmsActivity.class);
                intent5.putExtra(C7292k1.f25338C0, this.caseInfoId);
                startActivity(intent5);
                break;
            case C2113R.id.rl_webnet_item /* 2131297209 */:
                Intent intent6 = new Intent(this.mActivity, (Class<?>) CriminalWebInfoActivity.class);
                intent6.putExtra(C7292k1.f25338C0, this.caseInfoId);
                startActivity(intent6);
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@InterfaceC5816d C7265a c7265a) {
        C5544i0.m22546f(c7265a, "refreshUIEvent");
        if (c7265a.m26297a() != 34) {
            return;
        }
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @InterfaceC5816d KeyEvent keyEvent) {
        C5544i0.m22546f(keyEvent, "event");
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onkeyback();
        return true;
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ReportCaseInfoPresenter reportCaseInfoPresenter = this.mPresenter;
        if (reportCaseInfoPresenter != null) {
            reportCaseInfoPresenter.getVictimList(this.caseInfoId);
        }
        ReportCaseInfoPresenter reportCaseInfoPresenter2 = this.mPresenter;
        if (reportCaseInfoPresenter2 != null) {
            reportCaseInfoPresenter2.getSubmitCaseInfo(this.caseInfoId);
        }
    }

    @Override // p388ui.callview.VictimPeopleView
    public void onSuccessCaseNum(@InterfaceC5817e SignComitBean signComitBean) {
        this.comitNumBean = signComitBean;
        Integer valueOf = signComitBean != null ? Integer.valueOf(signComitBean.getPaymentCount()) : null;
        if (valueOf == null) {
            C5544i0.m22545f();
        }
        if (valueOf.intValue() > 0) {
            ImageView imageView = this.mInvolveAccTip;
            if (imageView == null) {
                C5544i0.m22554k("mInvolveAccTip");
            }
            imageView.setImageResource(C2113R.drawable.iv_case_green);
        } else {
            ImageView imageView2 = this.mInvolveAccTip;
            if (imageView2 == null) {
                C5544i0.m22554k("mInvolveAccTip");
            }
            imageView2.setImageResource(C2113R.drawable.iv_case_red);
        }
        if ((signComitBean != null ? Integer.valueOf(signComitBean.getCallTelCount()) : null).intValue() + (signComitBean != null ? Integer.valueOf(signComitBean.getChargeTelCount()) : null).intValue() + (signComitBean != null ? Integer.valueOf(signComitBean.getLinkTelCount()) : null).intValue() + (signComitBean != null ? Integer.valueOf(signComitBean.getMailingTelCount()) : null).intValue() > 0) {
            ImageView imageView3 = this.mIvCallTip;
            if (imageView3 == null) {
                C5544i0.m22554k("mIvCallTip");
            }
            imageView3.setVisibility(0);
        } else {
            ImageView imageView4 = this.mIvCallTip;
            if (imageView4 == null) {
                C5544i0.m22554k("mIvCallTip");
            }
            imageView4.setVisibility(8);
        }
        if ((signComitBean != null ? Integer.valueOf(signComitBean.getSmsCount()) : null).intValue() > 0) {
            ImageView imageView5 = this.mIvSmsTip;
            if (imageView5 == null) {
                C5544i0.m22554k("mIvSmsTip");
            }
            imageView5.setVisibility(0);
        } else {
            ImageView imageView6 = this.mIvSmsTip;
            if (imageView6 == null) {
                C5544i0.m22554k("mIvSmsTip");
            }
            imageView6.setVisibility(8);
        }
        if ((signComitBean != null ? Integer.valueOf(signComitBean.getNetAccountCount()) : null).intValue() + (signComitBean != null ? Integer.valueOf(signComitBean.getAppCount()) : null).intValue() + (signComitBean != null ? Integer.valueOf(signComitBean.getUrlCount()) : null).intValue() > 0) {
            ImageView imageView7 = this.mIvWebNetTip;
            if (imageView7 == null) {
                C5544i0.m22554k("mIvWebNetTip");
            }
            imageView7.setVisibility(0);
            return;
        }
        ImageView imageView8 = this.mIvWebNetTip;
        if (imageView8 == null) {
            C5544i0.m22554k("mIvWebNetTip");
        }
        imageView8.setVisibility(8);
    }

    @Override // p388ui.callview.VictimPeopleView
    public void onSuccessDelet() {
        onResume();
    }

    @Override // p388ui.callview.VictimPeopleView
    public void onSuccessHandle(@InterfaceC5816d List<? extends SurveyPeopleBean> list) {
        C5544i0.m22546f(list, "list");
        ReportCaseInfoPresenter reportCaseInfoPresenter = this.mPresenter;
        if (reportCaseInfoPresenter != null) {
            reportCaseInfoPresenter.setListData(list);
        }
    }

    public final void onkeyback() {
        C7257b1.m26184a(this.mActivity, "放弃本次案件信息编辑？", "", "确定", "取消", -1, -1, true, (IClickListener) new C6493a());
    }

    public final void setCaseInfoId(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.caseInfoId = str;
    }

    public final void setComitNumBean(@InterfaceC5817e SignComitBean signComitBean) {
        this.comitNumBean = signComitBean;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_report_info;
    }

    public final void setMFlBottomView(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mFlBottomView = view;
    }

    public final void setMInvolveAccTip(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mInvolveAccTip = imageView;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMIvCallTip(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvCallTip = imageView;
    }

    public final void setMIvSmsTip(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvSmsTip = imageView;
    }

    public final void setMIvWebNetTip(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvWebNetTip = imageView;
    }

    public final void setMMaxNum(int i2) {
        this.mMaxNum = i2;
    }

    public final void setMPresenter(@InterfaceC5817e ReportCaseInfoPresenter reportCaseInfoPresenter) {
        this.mPresenter = reportCaseInfoPresenter;
    }

    public final void setMRvList(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "<set-?>");
        this.mRvList = recyclerView;
    }

    public final void setMTvAdd(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvAdd = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setReportIDBean(@InterfaceC5817e ReportIDInfoBean reportIDInfoBean) {
        this.reportIDBean = reportIDInfoBean;
    }
}
