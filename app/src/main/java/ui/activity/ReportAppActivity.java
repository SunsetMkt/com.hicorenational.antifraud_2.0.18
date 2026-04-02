package ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.SurveyAppBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.ReportAppView;
import ui.presenter.ReportAppPresenter;
import ui.view.swip.SwipBackLayout;
import util.e2;

/* JADX INFO: compiled from: ReportAppActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010.\u001a\u00020/H\u0016J\u0006\u00100\u001a\u00020/J\u0010\u00101\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0007J\b\u00104\u001a\u00020/H\u0014J\u0010\u00105\u001a\u00020/2\u0006\u00106\u001a\u000207H\u0007J\b\u00108\u001a\u00020/H\u0016J\u0010\u00109\u001a\u00020/2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010:\u001a\u00020/H\u0014J \u0010;\u001a\u00020/2\u0006\u0010<\u001a\u00020\u000b2\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*\u00a8\u0006@"}, d2 = {"Lui/activity/ReportAppActivity;", "Lui/activity/BaseActivity;", "Lui/callview/ReportAppView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "itemPos", "", "getItemPos", "()I", "setItemPos", "(I)V", "mAppBeans", "Ljava/util/ArrayList;", "Lbean/SurveyAppBean;", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/ReportAppPresenter;", "getMPresenter", "()Lui/presenter/ReportAppPresenter;", "setMPresenter", "(Lui/presenter/ReportAppPresenter;)V", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvAdd", "Landroid/widget/TextView;", "getMTvAdd", "()Landroid/widget/TextView;", "setMTvAdd", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "initView", "onClick", "view", "Landroid/view/View;", "onDestroy", "onEventMainThread", "refreshUIEvent", "Lutil/event/RefreshUIEvent;", "onFailRequest", "onItemDelet", "onResume", "onSuccessHandle", "type", "list", "", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class ReportAppActivity extends BaseActivity implements ReportAppView {
    private int itemPos;

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @j.c.a.e
    private ReportAppPresenter mPresenter;

    @BindView(R.id.recyclerview)
    @j.c.a.d
    public RecyclerView mRecycleView;

    @BindView(R.id.tv_add)
    @j.c.a.d
    public TextView mTvAdd;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;

    @j.c.a.d
    private String caseInfoId = "";
    private ArrayList<SurveyAppBean> mAppBeans = new ArrayList<>();

    /* JADX INFO: compiled from: ReportAppActivity.kt */
    public static final class a implements IClickListener {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f13654b;

        a(int i2) {
            this.f13654b = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            ReportAppPresenter mPresenter = ReportAppActivity.this.getMPresenter();
            if (mPresenter != null) {
                ArrayList arrayList = ReportAppActivity.this.mAppBeans;
                SurveyAppBean surveyAppBean = arrayList != null ? (SurveyAppBean) arrayList.get(this.f13654b) : null;
                i.q2.t.i0.a((Object) surveyAppBean, "mAppBeans?.get(itemPos)");
                mPresenter.deleteCaseAppInfo(surveyAppBean.getId());
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

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
    public final ReportAppPresenter getMPresenter() {
        return this.mPresenter;
    }

    @j.c.a.d
    public final RecyclerView getMRecycleView() {
        RecyclerView recyclerView = this.mRecycleView;
        if (recyclerView == null) {
            i.q2.t.i0.k("mRecycleView");
        }
        return recyclerView;
    }

    @j.c.a.d
    public final TextView getMTvAdd() {
        TextView textView = this.mTvAdd;
        if (textView == null) {
            i.q2.t.i0.k("mTvAdd");
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
        org.greenrobot.eventbus.c.f().e(this);
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u6dfb\u52a0\u8bc8\u9a97APP");
        TextView textView2 = this.mTvAdd;
        if (textView2 == null) {
            i.q2.t.i0.k("mTvAdd");
        }
        if (textView2 == null) {
            i.q2.t.i0.f();
        }
        textView2.setText("\u6dfb\u52a0\u8bc8\u9a97APP\u5e94\u7528");
        initView();
    }

    public final void initView() {
        String stringExtra = getIntent().getStringExtra(util.p1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPresenter = new ReportAppPresenter(this.mActivity, this.caseInfoId, this);
        ReportAppPresenter reportAppPresenter = this.mPresenter;
        if (reportAppPresenter != null) {
            RecyclerView recyclerView = this.mRecycleView;
            if (recyclerView == null) {
                i.q2.t.i0.k("mRecycleView");
            }
            reportAppPresenter.initRecycleWeb(recyclerView);
        }
    }

    @OnClick({R.id.iv_back, R.id.ll_add})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_back) {
            a();
        } else {
            if (id != R.id.ll_add) {
                return;
            }
            Intent intent = new Intent(this.mActivity, (Class<?>) ReportAppAddActivity.class);
            intent.putExtra(util.p1.C0, this.caseInfoId);
            this.mActivity.startActivity(intent);
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@j.c.a.d util.n2.a aVar) {
        i.q2.t.i0.f(aVar, "refreshUIEvent");
    }

    @Override // ui.callview.ReportAppView
    public void onFailRequest() {
    }

    @Override // ui.callview.ReportAppView
    public void onItemDelet(int i2) {
        this.itemPos = i2;
        util.f1.a(this.mActivity, "\u5220\u9664\u5f53\u524dAPP\u5e94\u7528\u4fe1\u606f\uff1f", "", "\u786e\u5b9a", "\u53d6\u6d88", -1, -1, true, (IClickListener) new a(i2));
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ReportAppPresenter reportAppPresenter = this.mPresenter;
        if (reportAppPresenter != null) {
            reportAppPresenter.getSurveyAppList(this.caseInfoId);
        }
    }

    @Override // ui.callview.ReportAppView
    public void onSuccessHandle(int i2, @j.c.a.e List<SurveyAppBean> list) {
        if (i2 != 1) {
            if (i2 == 4) {
                e2.a("\u5220\u9664\u6210\u529f");
                this.mAppBeans.remove(this.itemPos);
                ReportAppPresenter reportAppPresenter = this.mPresenter;
                if (reportAppPresenter != null) {
                    reportAppPresenter.setListData(this.mAppBeans);
                    return;
                }
                return;
            }
            return;
        }
        ArrayList<SurveyAppBean> arrayList = this.mAppBeans;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<SurveyAppBean> arrayList2 = this.mAppBeans;
        if (arrayList2 != null) {
            if (list == null) {
                i.q2.t.i0.f();
            }
            arrayList2.addAll(list);
        }
        ReportAppPresenter reportAppPresenter2 = this.mPresenter;
        if (reportAppPresenter2 != null) {
            reportAppPresenter2.setListData(this.mAppBeans);
        }
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
        return R.layout.activity_report_app_list;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@j.c.a.e ReportAppPresenter reportAppPresenter) {
        this.mPresenter = reportAppPresenter;
    }

    public final void setMRecycleView(@j.c.a.d RecyclerView recyclerView) {
        i.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecycleView = recyclerView;
    }

    public final void setMTvAdd(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvAdd = textView;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
