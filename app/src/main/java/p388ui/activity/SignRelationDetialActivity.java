package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;
import com.zhy.view.flowlayout.AbstractC4439b;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.List;
import p286h.C5226e1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5726c0;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.callview.RelationView;
import p388ui.presenter.RelationPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;

/* compiled from: SignRelationDetialActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010<\u001a\u00020;2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002070>2\u0006\u0010?\u001a\u00020\u0005H\u0002J\b\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020AH\u0004J\b\u0010C\u001a\u00020AH\u0002J\u0016\u0010D\u001a\u00020A2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002070>H\u0016J\u0010\u0010E\u001a\u00020A2\u0006\u0010F\u001a\u00020!H\u0007J\b\u0010G\u001a\u00020;H\u0016J\u0006\u0010H\u001a\u00020AR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0002\b\u0003\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0011\"\u0004\b/\u0010\u0013R\u001e\u00100\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u0010\u0013R\u001e\u00103\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0011\"\u0004\b5\u0010\u0013R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020709X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, m23546d2 = {"Lui/activity/SignRelationDetialActivity;", "Lui/activity/BaseActivity;", "Lui/callview/RelationView;", "()V", "FINATYPE", "", "bean", "Lbean/RelationBean;", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mEtAccount", "Landroid/widget/TextView;", "getMEtAccount", "()Landroid/widget/TextView;", "setMEtAccount", "(Landroid/widget/TextView;)V", "mEtOtherName", "Landroid/widget/EditText;", "getMEtOtherName", "()Landroid/widget/EditText;", "setMEtOtherName", "(Landroid/widget/EditText;)V", "mFlowLayout", "Lcom/zhy/view/flowlayout/TagFlowLayout;", "getMFlowLayout", "()Lcom/zhy/view/flowlayout/TagFlowLayout;", "setMFlowLayout", "(Lcom/zhy/view/flowlayout/TagFlowLayout;)V", "mLlAccNorm", "Landroid/view/View;", "getMLlAccNorm", "()Landroid/view/View;", "setMLlAccNorm", "(Landroid/view/View;)V", "mLlAccOther", "getMLlAccOther", "setMLlAccOther", "mPresenter", "Lui/presenter/RelationPresenter;", "mTagAdapter", "Lcom/zhy/view/flowlayout/TagAdapter;", "mTvAccName", "getMTvAccName", "setMTvAccName", "mTvOtherTips", "getMTvOtherTips", "setMTvOtherTips", "mTvTitle", "getMTvTitle", "setMTvTitle", "platBean", "Lbean/RelationPlatBean;", "platBeans", "", "selectIndex", "", "contains", "result", "", "code", "initPage", "", "initTagAdapter", "intentData", "onSuccessPlatList", "onViewClicked", "view", "setLayoutView", "showTagView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignRelationDetialActivity extends BaseActivity implements RelationView {

    /* renamed from: bean, reason: collision with root package name */
    private RelationBean f25903bean;

    @BindView(C2113R.id.btn_commit)
    @InterfaceC5816d
    public Button mBtnConfirm;

    @BindView(C2113R.id.et_account)
    @InterfaceC5816d
    public TextView mEtAccount;

    @BindView(C2113R.id.et_other_name)
    @InterfaceC5816d
    public EditText mEtOtherName;

    @BindView(C2113R.id.flow_layout)
    @InterfaceC5816d
    public TagFlowLayout mFlowLayout;

    @BindView(C2113R.id.ll_acc_nomar)
    @InterfaceC5816d
    public View mLlAccNorm;

    @BindView(C2113R.id.ll_acc_other)
    @InterfaceC5816d
    public View mLlAccOther;
    private RelationPresenter mPresenter;
    private AbstractC4439b<?> mTagAdapter;

    @BindView(C2113R.id.tv_acc_name)
    @InterfaceC5816d
    public TextView mTvAccName;

    @BindView(C2113R.id.tv_other_name)
    @InterfaceC5816d
    public TextView mTvOtherTips;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;
    private RelationPlatBean platBean;
    private int selectIndex;
    private final String FINATYPE = "其他公众号";
    private final List<RelationPlatBean> platBeans = new ArrayList();

    /* compiled from: SignRelationDetialActivity.kt */
    /* renamed from: ui.activity.SignRelationDetialActivity$a */
    public static final class C6591a extends AbstractC4439b<RelationPlatBean> {
        C6591a(List list) {
            super(list);
        }

        @Override // com.zhy.view.flowlayout.AbstractC4439b
        @InterfaceC5816d
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public View mo16383a(@InterfaceC5816d FlowLayout flowLayout, int i2, @InterfaceC5816d RelationPlatBean relationPlatBean) {
            C5544i0.m22546f(flowLayout, "parent");
            C5544i0.m22546f(relationPlatBean, "t");
            View inflate = LayoutInflater.from(SignRelationDetialActivity.this.mActivity).inflate(C2113R.layout.tag_flow, (ViewGroup) SignRelationDetialActivity.this.getMFlowLayout(), false);
            if (inflate == null) {
                throw new C5226e1("null cannot be cast to non-null type android.widget.TextView");
            }
            TextView textView = (TextView) inflate;
            textView.setText(((RelationPlatBean) SignRelationDetialActivity.this.platBeans.get(i2)).getPlatformText());
            textView.setTextColor(SignRelationDetialActivity.this.getResources().getColorStateList(C2113R.color.text_choose_one));
            return textView;
        }
    }

    /* compiled from: SignRelationDetialActivity.kt */
    /* renamed from: ui.activity.SignRelationDetialActivity$b */
    static final class C6592b implements TagFlowLayout.InterfaceC4437c {
        C6592b() {
        }

        @Override // com.zhy.view.flowlayout.TagFlowLayout.InterfaceC4437c
        /* renamed from: a */
        public final boolean mo16381a(@InterfaceC5816d View view, int i2, @InterfaceC5816d FlowLayout flowLayout) {
            C5544i0.m22546f(view, "view");
            C5544i0.m22546f(flowLayout, "parent");
            AbstractC4439b abstractC4439b = SignRelationDetialActivity.this.mTagAdapter;
            if (abstractC4439b == null) {
                C5544i0.m22545f();
            }
            abstractC4439b.m16387a(SignRelationDetialActivity.this.selectIndex);
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
        this.f25903bean = (RelationBean) getIntent().getSerializableExtra(C7292k1.f25440w);
        Button button = this.mBtnConfirm;
        if (button == null) {
            C5544i0.m22554k("mBtnConfirm");
        }
        if (button == null) {
            C5544i0.m22545f();
        }
        button.setVisibility(4);
        TextView textView = this.mEtAccount;
        if (textView == null) {
            C5544i0.m22554k("mEtAccount");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setEnabled(false);
        EditText editText = this.mEtOtherName;
        if (editText == null) {
            C5544i0.m22554k("mEtOtherName");
        }
        if (editText == null) {
            C5544i0.m22545f();
        }
        editText.setEnabled(false);
    }

    @InterfaceC5816d
    public final Button getMBtnConfirm() {
        Button button = this.mBtnConfirm;
        if (button == null) {
            C5544i0.m22554k("mBtnConfirm");
        }
        return button;
    }

    @InterfaceC5816d
    public final TextView getMEtAccount() {
        TextView textView = this.mEtAccount;
        if (textView == null) {
            C5544i0.m22554k("mEtAccount");
        }
        return textView;
    }

    @InterfaceC5816d
    public final EditText getMEtOtherName() {
        EditText editText = this.mEtOtherName;
        if (editText == null) {
            C5544i0.m22554k("mEtOtherName");
        }
        return editText;
    }

    @InterfaceC5816d
    public final TagFlowLayout getMFlowLayout() {
        TagFlowLayout tagFlowLayout = this.mFlowLayout;
        if (tagFlowLayout == null) {
            C5544i0.m22554k("mFlowLayout");
        }
        return tagFlowLayout;
    }

    @InterfaceC5816d
    public final View getMLlAccNorm() {
        View view = this.mLlAccNorm;
        if (view == null) {
            C5544i0.m22554k("mLlAccNorm");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlAccOther() {
        View view = this.mLlAccOther;
        if (view == null) {
            C5544i0.m22554k("mLlAccOther");
        }
        return view;
    }

    @InterfaceC5816d
    public final TextView getMTvAccName() {
        TextView textView = this.mTvAccName;
        if (textView == null) {
            C5544i0.m22554k("mTvAccName");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvOtherTips() {
        TextView textView = this.mTvOtherTips;
        if (textView == null) {
            C5544i0.m22554k("mTvOtherTips");
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
        textView.setText("关联类嫌疑人电话详情");
        this.mPresenter = new RelationPresenter(this.mActivity, this);
        intentData();
        initTagAdapter();
        RelationPresenter relationPresenter = this.mPresenter;
        if (relationPresenter == null) {
            C5544i0.m22545f();
        }
        relationPresenter.getRelationPlatList();
    }

    protected final void initTagAdapter() {
        List<RelationPlatBean> list = this.platBeans;
        if (list == null) {
            throw new C5226e1("null cannot be cast to non-null type kotlin.collections.List<bean.RelationPlatBean>");
        }
        this.mTagAdapter = new C6591a(list);
        TagFlowLayout tagFlowLayout = this.mFlowLayout;
        if (tagFlowLayout == null) {
            C5544i0.m22554k("mFlowLayout");
        }
        if (tagFlowLayout == null) {
            C5544i0.m22545f();
        }
        tagFlowLayout.setEnabled(false);
        TagFlowLayout tagFlowLayout2 = this.mFlowLayout;
        if (tagFlowLayout2 == null) {
            C5544i0.m22554k("mFlowLayout");
        }
        if (tagFlowLayout2 == null) {
            C5544i0.m22545f();
        }
        tagFlowLayout2.setAdapter(this.mTagAdapter);
        TagFlowLayout tagFlowLayout3 = this.mFlowLayout;
        if (tagFlowLayout3 == null) {
            C5544i0.m22554k("mFlowLayout");
        }
        if (tagFlowLayout3 == null) {
            C5544i0.m22545f();
        }
        tagFlowLayout3.setOnTagClickListener(new C6592b());
    }

    @Override // p388ui.callview.RelationView
    public void onItemDelet(int i2) {
        RelationView.C6817a.m25471a(this, i2);
    }

    @Override // p388ui.callview.RelationView
    public void onItemEdit() {
        RelationView.C6817a.m25470a(this);
    }

    @Override // p388ui.callview.RelationView
    public void onSuccessList(@InterfaceC5816d List<? extends RelationBean> list) {
        C5544i0.m22546f(list, "list");
        RelationView.C6817a.m25472a(this, list);
    }

    @Override // p388ui.callview.RelationView
    public void onSuccessPlatList(@InterfaceC5816d List<? extends RelationPlatBean> list) {
        C5544i0.m22546f(list, "result");
        RelationView.C6817a.m25474b(this, list);
        if (!list.isEmpty()) {
            this.platBeans.clear();
            this.platBeans.addAll(list);
            AbstractC4439b<?> abstractC4439b = this.mTagAdapter;
            if (abstractC4439b == null) {
                C5544i0.m22545f();
            }
            abstractC4439b.m16391c();
            RelationBean relationBean = this.f25903bean;
            if (relationBean == null) {
                AbstractC4439b<?> abstractC4439b2 = this.mTagAdapter;
                if (abstractC4439b2 == null) {
                    C5544i0.m22545f();
                }
                abstractC4439b2.m16387a(0);
                this.selectIndex = 0;
                showTagView();
                return;
            }
            if (relationBean == null) {
                C5544i0.m22545f();
            }
            String platform = relationBean.getPlatform();
            C5544i0.m22521a((Object) platform, "bean!!.platform");
            int contains = contains(list, platform);
            AbstractC4439b<?> abstractC4439b3 = this.mTagAdapter;
            if (abstractC4439b3 == null) {
                C5544i0.m22545f();
            }
            abstractC4439b3.m16387a(contains);
            this.selectIndex = contains;
            showTagView();
            EditText editText = this.mEtOtherName;
            if (editText == null) {
                C5544i0.m22554k("mEtOtherName");
            }
            if (editText == null) {
                C5544i0.m22545f();
            }
            RelationBean relationBean2 = this.f25903bean;
            if (relationBean2 == null) {
                C5544i0.m22545f();
            }
            editText.setText(relationBean2.getPlatformText());
            TextView textView = this.mEtAccount;
            if (textView == null) {
                C5544i0.m22554k("mEtAccount");
            }
            if (textView == null) {
                C5544i0.m22545f();
            }
            RelationBean relationBean3 = this.f25903bean;
            if (relationBean3 == null) {
                C5544i0.m22545f();
            }
            textView.setText(relationBean3.getSuspectMobile());
        }
    }

    @Override // p388ui.callview.RelationView
    public void onSuccessSave() {
        RelationView.C6817a.m25473b(this);
    }

    @OnClick({C2113R.id.iv_back})
    public final void onViewClicked(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_relation_acc_add;
    }

    public final void setMBtnConfirm(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMEtAccount(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mEtAccount = textView;
    }

    public final void setMEtOtherName(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtOtherName = editText;
    }

    public final void setMFlowLayout(@InterfaceC5816d TagFlowLayout tagFlowLayout) {
        C5544i0.m22546f(tagFlowLayout, "<set-?>");
        this.mFlowLayout = tagFlowLayout;
    }

    public final void setMLlAccNorm(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlAccNorm = view;
    }

    public final void setMLlAccOther(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlAccOther = view;
    }

    public final void setMTvAccName(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvAccName = textView;
    }

    public final void setMTvOtherTips(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvOtherTips = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void showTagView() {
        boolean m23774c;
        this.platBean = this.platBeans.get(this.selectIndex);
        RelationPlatBean relationPlatBean = this.platBean;
        if (relationPlatBean == null || relationPlatBean.getEx() != 1) {
            View view = this.mLlAccOther;
            if (view == null) {
                C5544i0.m22554k("mLlAccOther");
            }
            if (view == null) {
                C5544i0.m22545f();
            }
            view.setVisibility(8);
            View view2 = this.mLlAccNorm;
            if (view2 == null) {
                C5544i0.m22554k("mLlAccNorm");
            }
            if (view2 == null) {
                C5544i0.m22545f();
            }
            view2.setVisibility(0);
            EditText editText = this.mEtOtherName;
            if (editText == null) {
                C5544i0.m22554k("mEtOtherName");
            }
            editText.setText("");
            return;
        }
        View view3 = this.mLlAccOther;
        if (view3 == null) {
            C5544i0.m22554k("mLlAccOther");
        }
        if (view3 == null) {
            C5544i0.m22545f();
        }
        view3.setVisibility(0);
        TextView textView = this.mTvOtherTips;
        if (textView == null) {
            C5544i0.m22554k("mTvOtherTips");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("平台名称");
        EditText editText2 = this.mEtOtherName;
        if (editText2 == null) {
            C5544i0.m22554k("mEtOtherName");
        }
        if (editText2 == null) {
            C5544i0.m22545f();
        }
        editText2.setHint("请输入平台名称");
        EditText editText3 = this.mEtOtherName;
        if (editText3 == null) {
            C5544i0.m22554k("mEtOtherName");
        }
        editText3.setText("");
        RelationPlatBean relationPlatBean2 = this.platBean;
        String platformText = relationPlatBean2 != null ? relationPlatBean2.getPlatformText() : null;
        if (platformText == null) {
            C5544i0.m22545f();
        }
        m23774c = C5726c0.m23774c((CharSequence) platformText, (CharSequence) this.FINATYPE, false, 2, (Object) null);
        if (m23774c) {
            TextView textView2 = this.mTvOtherTips;
            if (textView2 == null) {
                C5544i0.m22554k("mTvOtherTips");
            }
            if (textView2 == null) {
                C5544i0.m22545f();
            }
            textView2.setText("公号名称");
            EditText editText4 = this.mEtOtherName;
            if (editText4 == null) {
                C5544i0.m22554k("mEtOtherName");
            }
            if (editText4 == null) {
                C5544i0.m22545f();
            }
            editText4.setHint("请输入公众号/服务号名称");
        }
    }
}
