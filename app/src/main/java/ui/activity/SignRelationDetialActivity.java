package ui.activity;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import bean.RelationBean;
import bean.RelationPlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.List;
import ui.callview.RelationView;
import ui.presenter.RelationPresenter;
import ui.view.swip.SwipBackLayout;

/* JADX INFO: compiled from: SignRelationDetialActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001e\u0010<\u001a\u00020;2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002070>2\u0006\u0010?\u001a\u00020\u0005H\u0002J\b\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020AH\u0004J\b\u0010C\u001a\u00020AH\u0002J\u0016\u0010D\u001a\u00020A2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002070>H\u0016J\u0010\u0010E\u001a\u00020A2\u0006\u0010F\u001a\u00020!H\u0007J\b\u0010G\u001a\u00020;H\u0016J\u0006\u0010H\u001a\u00020AR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020!8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0002\b\u0003\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0011\"\u0004\b/\u0010\u0013R\u001e\u00100\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u0010\u0013R\u001e\u00103\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0011\"\u0004\b5\u0010\u0013R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020709X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lui/activity/SignRelationDetialActivity;", "Lui/activity/BaseActivity;", "Lui/callview/RelationView;", "()V", "FINATYPE", "", "bean", "Lbean/RelationBean;", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mEtAccount", "Landroid/widget/TextView;", "getMEtAccount", "()Landroid/widget/TextView;", "setMEtAccount", "(Landroid/widget/TextView;)V", "mEtOtherName", "Landroid/widget/EditText;", "getMEtOtherName", "()Landroid/widget/EditText;", "setMEtOtherName", "(Landroid/widget/EditText;)V", "mFlowLayout", "Lcom/zhy/view/flowlayout/TagFlowLayout;", "getMFlowLayout", "()Lcom/zhy/view/flowlayout/TagFlowLayout;", "setMFlowLayout", "(Lcom/zhy/view/flowlayout/TagFlowLayout;)V", "mLlAccNorm", "Landroid/view/View;", "getMLlAccNorm", "()Landroid/view/View;", "setMLlAccNorm", "(Landroid/view/View;)V", "mLlAccOther", "getMLlAccOther", "setMLlAccOther", "mPresenter", "Lui/presenter/RelationPresenter;", "mTagAdapter", "Lcom/zhy/view/flowlayout/TagAdapter;", "mTvAccName", "getMTvAccName", "setMTvAccName", "mTvOtherTips", "getMTvOtherTips", "setMTvOtherTips", "mTvTitle", "getMTvTitle", "setMTvTitle", "platBean", "Lbean/RelationPlatBean;", "platBeans", "", "selectIndex", "", "contains", "result", "", "code", "initPage", "", "initTagAdapter", "intentData", "onSuccessPlatList", "onViewClicked", "view", "setLayoutView", "showTagView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class SignRelationDetialActivity extends BaseActivity implements RelationView {

    /* JADX INFO: renamed from: bean, reason: collision with root package name */
    private RelationBean f13828bean;

    @BindView(R.id.btn_commit)
    @j.c.a.d
    public Button mBtnConfirm;

    @BindView(R.id.et_account)
    @j.c.a.d
    public TextView mEtAccount;

    @BindView(R.id.et_other_name)
    @j.c.a.d
    public EditText mEtOtherName;

    @BindView(R.id.flow_layout)
    @j.c.a.d
    public TagFlowLayout mFlowLayout;

    @BindView(R.id.ll_acc_nomar)
    @j.c.a.d
    public View mLlAccNorm;

    @BindView(R.id.ll_acc_other)
    @j.c.a.d
    public View mLlAccOther;
    private RelationPresenter mPresenter;
    private com.zhy.view.flowlayout.b<?> mTagAdapter;

    @BindView(R.id.tv_acc_name)
    @j.c.a.d
    public TextView mTvAccName;

    @BindView(R.id.tv_other_name)
    @j.c.a.d
    public TextView mTvOtherTips;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;
    private RelationPlatBean platBean;
    private int selectIndex;
    private final String FINATYPE = "\u5176\u4ed6\u516c\u4f17\u53f7";
    private final List<RelationPlatBean> platBeans = new ArrayList();

    /* JADX INFO: compiled from: SignRelationDetialActivity.kt */
    public static final class a extends com.zhy.view.flowlayout.b<RelationPlatBean> {
        a(List list) {
            super(list);
        }

        @Override // com.zhy.view.flowlayout.b
        @j.c.a.d
        public View a(@j.c.a.d FlowLayout flowLayout, int i2, @j.c.a.d RelationPlatBean relationPlatBean) {
            i.q2.t.i0.f(flowLayout, "parent");
            i.q2.t.i0.f(relationPlatBean, "t");
            View viewInflate = LayoutInflater.from(SignRelationDetialActivity.this.mActivity).inflate(R.layout.tag_flow, (ViewGroup) SignRelationDetialActivity.this.getMFlowLayout(), false);
            if (viewInflate == null) {
                throw new i.e1("null cannot be cast to non-null type android.widget.TextView");
            }
            TextView textView = (TextView) viewInflate;
            textView.setText(((RelationPlatBean) SignRelationDetialActivity.this.platBeans.get(i2)).getPlatformText());
            textView.setTextColor(SignRelationDetialActivity.this.getResources().getColorStateList(R.color.text_choose_one));
            return textView;
        }
    }

    /* JADX INFO: compiled from: SignRelationDetialActivity.kt */
    static final class b implements TagFlowLayout.c {
        b() {
        }

        @Override // com.zhy.view.flowlayout.TagFlowLayout.c
        public final boolean a(@j.c.a.d View view, int i2, @j.c.a.d FlowLayout flowLayout) {
            i.q2.t.i0.f(view, "view");
            i.q2.t.i0.f(flowLayout, "parent");
            com.zhy.view.flowlayout.b bVar = SignRelationDetialActivity.this.mTagAdapter;
            if (bVar == null) {
                i.q2.t.i0.f();
            }
            bVar.a(SignRelationDetialActivity.this.selectIndex);
            return true;
        }
    }

    private final int contains(List<? extends RelationPlatBean> list, String str) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(list.get(i2).getPlatform(), str)) {
                return i2;
            }
        }
        return 0;
    }

    private final void intentData() {
        this.f13828bean = (RelationBean) getIntent().getSerializableExtra(util.p1.w);
        Button button = this.mBtnConfirm;
        if (button == null) {
            i.q2.t.i0.k("mBtnConfirm");
        }
        if (button == null) {
            i.q2.t.i0.f();
        }
        button.setVisibility(4);
        TextView textView = this.mEtAccount;
        if (textView == null) {
            i.q2.t.i0.k("mEtAccount");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setEnabled(false);
        EditText editText = this.mEtOtherName;
        if (editText == null) {
            i.q2.t.i0.k("mEtOtherName");
        }
        if (editText == null) {
            i.q2.t.i0.f();
        }
        editText.setEnabled(false);
    }

    @j.c.a.d
    public final Button getMBtnConfirm() {
        Button button = this.mBtnConfirm;
        if (button == null) {
            i.q2.t.i0.k("mBtnConfirm");
        }
        return button;
    }

    @j.c.a.d
    public final TextView getMEtAccount() {
        TextView textView = this.mEtAccount;
        if (textView == null) {
            i.q2.t.i0.k("mEtAccount");
        }
        return textView;
    }

    @j.c.a.d
    public final EditText getMEtOtherName() {
        EditText editText = this.mEtOtherName;
        if (editText == null) {
            i.q2.t.i0.k("mEtOtherName");
        }
        return editText;
    }

    @j.c.a.d
    public final TagFlowLayout getMFlowLayout() {
        TagFlowLayout tagFlowLayout = this.mFlowLayout;
        if (tagFlowLayout == null) {
            i.q2.t.i0.k("mFlowLayout");
        }
        return tagFlowLayout;
    }

    @j.c.a.d
    public final View getMLlAccNorm() {
        View view = this.mLlAccNorm;
        if (view == null) {
            i.q2.t.i0.k("mLlAccNorm");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlAccOther() {
        View view = this.mLlAccOther;
        if (view == null) {
            i.q2.t.i0.k("mLlAccOther");
        }
        return view;
    }

    @j.c.a.d
    public final TextView getMTvAccName() {
        TextView textView = this.mTvAccName;
        if (textView == null) {
            i.q2.t.i0.k("mTvAccName");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvOtherTips() {
        TextView textView = this.mTvOtherTips;
        if (textView == null) {
            i.q2.t.i0.k("mTvOtherTips");
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
        textView.setText("\u5173\u8054\u7c7b\u5acc\u7591\u4eba\u7535\u8bdd\u8be6\u60c5");
        this.mPresenter = new RelationPresenter(this.mActivity, this);
        intentData();
        initTagAdapter();
        RelationPresenter relationPresenter = this.mPresenter;
        if (relationPresenter == null) {
            i.q2.t.i0.f();
        }
        relationPresenter.getRelationPlatList();
    }

    protected final void initTagAdapter() {
        List<RelationPlatBean> list = this.platBeans;
        if (list == null) {
            throw new i.e1("null cannot be cast to non-null type kotlin.collections.List<bean.RelationPlatBean>");
        }
        this.mTagAdapter = new a(list);
        TagFlowLayout tagFlowLayout = this.mFlowLayout;
        if (tagFlowLayout == null) {
            i.q2.t.i0.k("mFlowLayout");
        }
        if (tagFlowLayout == null) {
            i.q2.t.i0.f();
        }
        tagFlowLayout.setEnabled(false);
        TagFlowLayout tagFlowLayout2 = this.mFlowLayout;
        if (tagFlowLayout2 == null) {
            i.q2.t.i0.k("mFlowLayout");
        }
        if (tagFlowLayout2 == null) {
            i.q2.t.i0.f();
        }
        tagFlowLayout2.setAdapter(this.mTagAdapter);
        TagFlowLayout tagFlowLayout3 = this.mFlowLayout;
        if (tagFlowLayout3 == null) {
            i.q2.t.i0.k("mFlowLayout");
        }
        if (tagFlowLayout3 == null) {
            i.q2.t.i0.f();
        }
        tagFlowLayout3.setOnTagClickListener(new b());
    }

    @Override // ui.callview.RelationView
    public void onItemDelet(int i2) {
        RelationView.a.a(this, i2);
    }

    @Override // ui.callview.RelationView
    public void onItemEdit() {
        RelationView.a.a(this);
    }

    @Override // ui.callview.RelationView
    public void onSuccessList(@j.c.a.d List<? extends RelationBean> list) {
        i.q2.t.i0.f(list, "list");
        RelationView.a.a(this, list);
    }

    @Override // ui.callview.RelationView
    public void onSuccessPlatList(@j.c.a.d List<? extends RelationPlatBean> list) {
        i.q2.t.i0.f(list, "result");
        RelationView.a.b(this, list);
        if (!list.isEmpty()) {
            this.platBeans.clear();
            this.platBeans.addAll(list);
            com.zhy.view.flowlayout.b<?> bVar = this.mTagAdapter;
            if (bVar == null) {
                i.q2.t.i0.f();
            }
            bVar.c();
            RelationBean relationBean = this.f13828bean;
            if (relationBean == null) {
                com.zhy.view.flowlayout.b<?> bVar2 = this.mTagAdapter;
                if (bVar2 == null) {
                    i.q2.t.i0.f();
                }
                bVar2.a(0);
                this.selectIndex = 0;
                showTagView();
                return;
            }
            if (relationBean == null) {
                i.q2.t.i0.f();
            }
            String platform = relationBean.getPlatform();
            i.q2.t.i0.a((Object) platform, "bean!!.platform");
            int iContains = contains(list, platform);
            com.zhy.view.flowlayout.b<?> bVar3 = this.mTagAdapter;
            if (bVar3 == null) {
                i.q2.t.i0.f();
            }
            bVar3.a(iContains);
            this.selectIndex = iContains;
            showTagView();
            EditText editText = this.mEtOtherName;
            if (editText == null) {
                i.q2.t.i0.k("mEtOtherName");
            }
            if (editText == null) {
                i.q2.t.i0.f();
            }
            RelationBean relationBean2 = this.f13828bean;
            if (relationBean2 == null) {
                i.q2.t.i0.f();
            }
            editText.setText(relationBean2.getPlatformText());
            TextView textView = this.mEtAccount;
            if (textView == null) {
                i.q2.t.i0.k("mEtAccount");
            }
            if (textView == null) {
                i.q2.t.i0.f();
            }
            RelationBean relationBean3 = this.f13828bean;
            if (relationBean3 == null) {
                i.q2.t.i0.f();
            }
            textView.setText(relationBean3.getSuspectMobile());
        }
    }

    @Override // ui.callview.RelationView
    public void onSuccessSave() {
        RelationView.a.b(this);
    }

    @OnClick({R.id.iv_back})
    public final void onViewClicked(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_relation_acc_add;
    }

    public final void setMBtnConfirm(@j.c.a.d Button button) {
        i.q2.t.i0.f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMEtAccount(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mEtAccount = textView;
    }

    public final void setMEtOtherName(@j.c.a.d EditText editText) {
        i.q2.t.i0.f(editText, "<set-?>");
        this.mEtOtherName = editText;
    }

    public final void setMFlowLayout(@j.c.a.d TagFlowLayout tagFlowLayout) {
        i.q2.t.i0.f(tagFlowLayout, "<set-?>");
        this.mFlowLayout = tagFlowLayout;
    }

    public final void setMLlAccNorm(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlAccNorm = view;
    }

    public final void setMLlAccOther(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlAccOther = view;
    }

    public final void setMTvAccName(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvAccName = textView;
    }

    public final void setMTvOtherTips(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvOtherTips = textView;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void showTagView() {
        this.platBean = this.platBeans.get(this.selectIndex);
        RelationPlatBean relationPlatBean = this.platBean;
        if (relationPlatBean == null || relationPlatBean.getEx() != 1) {
            View view = this.mLlAccOther;
            if (view == null) {
                i.q2.t.i0.k("mLlAccOther");
            }
            if (view == null) {
                i.q2.t.i0.f();
            }
            view.setVisibility(8);
            View view2 = this.mLlAccNorm;
            if (view2 == null) {
                i.q2.t.i0.k("mLlAccNorm");
            }
            if (view2 == null) {
                i.q2.t.i0.f();
            }
            view2.setVisibility(0);
            EditText editText = this.mEtOtherName;
            if (editText == null) {
                i.q2.t.i0.k("mEtOtherName");
            }
            editText.setText("");
            return;
        }
        View view3 = this.mLlAccOther;
        if (view3 == null) {
            i.q2.t.i0.k("mLlAccOther");
        }
        if (view3 == null) {
            i.q2.t.i0.f();
        }
        view3.setVisibility(0);
        TextView textView = this.mTvOtherTips;
        if (textView == null) {
            i.q2.t.i0.k("mTvOtherTips");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u5e73\u53f0\u540d\u79f0");
        EditText editText2 = this.mEtOtherName;
        if (editText2 == null) {
            i.q2.t.i0.k("mEtOtherName");
        }
        if (editText2 == null) {
            i.q2.t.i0.f();
        }
        editText2.setHint("\u8bf7\u8f93\u5165\u5e73\u53f0\u540d\u79f0");
        EditText editText3 = this.mEtOtherName;
        if (editText3 == null) {
            i.q2.t.i0.k("mEtOtherName");
        }
        editText3.setText("");
        RelationPlatBean relationPlatBean2 = this.platBean;
        String platformText = relationPlatBean2 != null ? relationPlatBean2.getPlatformText() : null;
        if (platformText == null) {
            i.q2.t.i0.f();
        }
        if (i.z2.c0.c((CharSequence) platformText, (CharSequence) this.FINATYPE, false, 2, (Object) null)) {
            TextView textView2 = this.mTvOtherTips;
            if (textView2 == null) {
                i.q2.t.i0.k("mTvOtherTips");
            }
            if (textView2 == null) {
                i.q2.t.i0.f();
            }
            textView2.setText("\u516c\u53f7\u540d\u79f0");
            EditText editText4 = this.mEtOtherName;
            if (editText4 == null) {
                i.q2.t.i0.k("mEtOtherName");
            }
            if (editText4 == null) {
                i.q2.t.i0.f();
            }
            editText4.setHint("\u8bf7\u8f93\u5165\u516c\u4f17\u53f7/\u670d\u52a1\u53f7\u540d\u79f0");
        }
    }
}
