package p388ui.activity;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import bean.RelationBean;
import bean.RelationPlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.zhy.view.flowlayout.AbstractC4439b;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import manager.AccountManager;
import p286h.C5226e1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.callview.RelationView;
import p388ui.presenter.RelationPresenter;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;
import util.C7337y1;

/* compiled from: RelationAddActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J \u0010<\u001a\u00020;2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002010>2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020@H\u0004J\b\u0010B\u001a\u00020@H\u0002J\u0018\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020;2\u0006\u0010F\u001a\u00020GH\u0016J\u0016\u0010H\u001a\u00020@2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002010>H\u0016J\b\u0010I\u001a\u00020@H\u0016J\u0010\u0010J\u001a\u00020@2\u0006\u0010K\u001a\u00020\u0018H\u0007J\u0006\u0010L\u001a\u00020@J\b\u0010M\u001a\u00020@H\u0002J\b\u0010N\u001a\u00020;H\u0016J\u0006\u0010O\u001a\u00020@J\u0010\u0010P\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001e\u0010-\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020103X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u00104\u001a\u0002058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, m23546d2 = {"Lui/activity/RelationAddActivity;", "Lui/activity/BaseActivity;", "Lui/callview/RelationView;", "()V", "bean", "Lbean/RelationBean;", "caseInfoId", "", "mEtAccount", "Landroid/widget/EditText;", "getMEtAccount", "()Landroid/widget/EditText;", "setMEtAccount", "(Landroid/widget/EditText;)V", "mEtOtherName", "getMEtOtherName", "setMEtOtherName", "mFlowLayout", "Lcom/zhy/view/flowlayout/TagFlowLayout;", "getMFlowLayout", "()Lcom/zhy/view/flowlayout/TagFlowLayout;", "setMFlowLayout", "(Lcom/zhy/view/flowlayout/TagFlowLayout;)V", "mLlAccNorm", "Landroid/view/View;", "getMLlAccNorm", "()Landroid/view/View;", "setMLlAccNorm", "(Landroid/view/View;)V", "mLlAccOther", "getMLlAccOther", "setMLlAccOther", "mPresenter", "Lui/presenter/RelationPresenter;", "mTagAdapter", "Lcom/zhy/view/flowlayout/TagAdapter;", "mTvAccName", "Landroid/widget/TextView;", "getMTvAccName", "()Landroid/widget/TextView;", "setMTvAccName", "(Landroid/widget/TextView;)V", "mTvOtherTips", "getMTvOtherTips", "setMTvOtherTips", "mTvTitle", "getMTvTitle", "setMTvTitle", "platBean", "Lbean/RelationPlatBean;", "platBeans", "", "scrollView", "Landroidx/core/widget/NestedScrollView;", "getScrollView", "()Landroidx/core/widget/NestedScrollView;", "setScrollView", "(Landroidx/core/widget/NestedScrollView;)V", "selectIndex", "", "contains", "result", "", "initPage", "", "initTagAdapter", "intentData", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onSuccessPlatList", "onSuccessSave", "onViewClicked", "view", "onkeyback", "saveHttpApi", "setLayoutView", "showTagView", "subContains", "input", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class RelationAddActivity extends BaseActivity implements RelationView {

    /* renamed from: bean, reason: collision with root package name */
    private RelationBean f25902bean;

    @BindView(C2113R.id.et_account)
    @InterfaceC5816d
    public EditText mEtAccount;

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

    @BindView(C2113R.id.scrollView)
    @InterfaceC5816d
    public NestedScrollView scrollView;
    private int selectIndex;
    private final List<RelationPlatBean> platBeans = new ArrayList();
    private String caseInfoId = "";

    /* compiled from: RelationAddActivity.kt */
    /* renamed from: ui.activity.RelationAddActivity$a */
    public static final class C6481a extends AbstractC4439b<RelationPlatBean> {
        C6481a(List list) {
            super(list);
        }

        @Override // com.zhy.view.flowlayout.AbstractC4439b
        @InterfaceC5816d
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public View mo16383a(@InterfaceC5816d FlowLayout flowLayout, int i2, @InterfaceC5816d RelationPlatBean relationPlatBean) {
            C5544i0.m22546f(flowLayout, "parent");
            C5544i0.m22546f(relationPlatBean, "t");
            View inflate = LayoutInflater.from(RelationAddActivity.this.mActivity).inflate(C2113R.layout.tag_flow, (ViewGroup) RelationAddActivity.this.getMFlowLayout(), false);
            if (inflate == null) {
                throw new C5226e1("null cannot be cast to non-null type android.widget.TextView");
            }
            TextView textView = (TextView) inflate;
            textView.setText(((RelationPlatBean) RelationAddActivity.this.platBeans.get(i2)).getPlatformText());
            textView.setTextColor(RelationAddActivity.this.getResources().getColorStateList(C2113R.color.text_choose_one));
            return textView;
        }
    }

    /* compiled from: RelationAddActivity.kt */
    /* renamed from: ui.activity.RelationAddActivity$b */
    static final class C6482b implements TagFlowLayout.InterfaceC4437c {
        C6482b() {
        }

        @Override // com.zhy.view.flowlayout.TagFlowLayout.InterfaceC4437c
        /* renamed from: a */
        public final boolean mo16381a(@InterfaceC5816d View view, int i2, @InterfaceC5816d FlowLayout flowLayout) {
            C5544i0.m22546f(view, "view");
            C5544i0.m22546f(flowLayout, "parent");
            RelationAddActivity.this.selectIndex = i2;
            RelationAddActivity.this.showTagView();
            return true;
        }
    }

    /* compiled from: RelationAddActivity.kt */
    /* renamed from: ui.activity.RelationAddActivity$c */
    public static final class C6483c implements IClickListener {
        C6483c() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            RelationAddActivity.this.saveHttpApi();
        }
    }

    /* compiled from: RelationAddActivity.kt */
    /* renamed from: ui.activity.RelationAddActivity$d */
    public static final class C6484d implements IClickListener {
        C6484d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            RelationAddActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    private final int contains(List<? extends RelationPlatBean> list, RelationBean relationBean) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(list.get(i2).getPlatform(), relationBean != null ? relationBean.getPlatform() : null)) {
                return i2;
            }
        }
        return 0;
    }

    private final void intentData() {
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.f25902bean = (RelationBean) getIntent().getSerializableExtra(C7292k1.f25440w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveHttpApi() {
        RelationPresenter relationPresenter = this.mPresenter;
        if (relationPresenter == null) {
            C5544i0.m22545f();
        }
        relationPresenter.saveRelationTel(this.f25902bean);
    }

    private final String subContains(String str) {
        int size = this.platBeans.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.platBeans.get(i2).getEx() == 0) {
                String platformText = this.platBeans.get(i2).getPlatformText();
                C5544i0.m22521a((Object) platformText, "platBeans[i].platformText");
                if (platformText == null) {
                    throw new C5226e1("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = platformText.toLowerCase();
                C5544i0.m22521a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                if (str == null) {
                    throw new C5226e1("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase2 = str.toLowerCase();
                C5544i0.m22521a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                if (TextUtils.equals(lowerCase, lowerCase2)) {
                    String platform = this.platBeans.get(i2).getPlatform();
                    C5544i0.m22521a((Object) platform, "platBeans[i].platform");
                    return platform;
                }
            }
        }
        RelationPlatBean relationPlatBean = this.platBean;
        return String.valueOf(relationPlatBean != null ? relationPlatBean.getPlatform() : null);
    }

    @InterfaceC5816d
    public final EditText getMEtAccount() {
        EditText editText = this.mEtAccount;
        if (editText == null) {
            C5544i0.m22554k("mEtAccount");
        }
        return editText;
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

    @InterfaceC5816d
    public final NestedScrollView getScrollView() {
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            C5544i0.m22554k("scrollView");
        }
        return nestedScrollView;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("添加关联类嫌疑人电话");
        this.mPresenter = new RelationPresenter(this.mActivity, this);
        intentData();
        initTagAdapter();
        RelationPresenter relationPresenter = this.mPresenter;
        if (relationPresenter == null) {
            C5544i0.m22545f();
        }
        relationPresenter.getRelationPlatList();
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            C5544i0.m22554k("scrollView");
        }
        C7337y1.m26754a(nestedScrollView, this.mActivity);
    }

    protected final void initTagAdapter() {
        List<RelationPlatBean> list = this.platBeans;
        if (list == null) {
            throw new C5226e1("null cannot be cast to non-null type kotlin.collections.List<bean.RelationPlatBean>");
        }
        this.mTagAdapter = new C6481a(list);
        TagFlowLayout tagFlowLayout = this.mFlowLayout;
        if (tagFlowLayout == null) {
            C5544i0.m22554k("mFlowLayout");
        }
        if (tagFlowLayout == null) {
            C5544i0.m22545f();
        }
        tagFlowLayout.setAdapter(this.mTagAdapter);
        TagFlowLayout tagFlowLayout2 = this.mFlowLayout;
        if (tagFlowLayout2 == null) {
            C5544i0.m22554k("mFlowLayout");
        }
        if (tagFlowLayout2 == null) {
            C5544i0.m22545f();
        }
        tagFlowLayout2.setOnTagClickListener(new C6482b());
    }

    @Override // p388ui.callview.RelationView
    public void onItemDelet(int i2) {
        RelationView.C6817a.m25471a(this, i2);
    }

    @Override // p388ui.callview.RelationView
    public void onItemEdit() {
        RelationView.C6817a.m25470a(this);
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
            RelationBean relationBean = this.f25902bean;
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
            int contains = contains(list, relationBean);
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
            RelationBean relationBean2 = this.f25902bean;
            if (relationBean2 == null) {
                C5544i0.m22545f();
            }
            editText.setText(relationBean2.getPlatformText());
            EditText editText2 = this.mEtAccount;
            if (editText2 == null) {
                C5544i0.m22554k("mEtAccount");
            }
            if (editText2 == null) {
                C5544i0.m22545f();
            }
            RelationBean relationBean3 = this.f25902bean;
            if (relationBean3 == null) {
                C5544i0.m22545f();
            }
            editText2.setText(relationBean3.getSuspectMobile());
        }
    }

    @Override // p388ui.callview.RelationView
    public void onSuccessSave() {
        RelationBean relationBean = this.f25902bean;
        if (relationBean != null) {
            if (relationBean == null) {
                C5544i0.m22545f();
            }
            if (!TextUtils.isEmpty(relationBean.getLinkTelInfoID())) {
                C7331w1.m26688a("修改成功");
                finish();
            }
        }
        C7331w1.m26688a("添加成功");
        finish();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.btn_commit})
    public final void onViewClicked(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.btn_commit) {
            if (id != C2113R.id.iv_back) {
                return;
            }
            finish();
            return;
        }
        EditText editText = this.mEtOtherName;
        if (editText == null) {
            C5544i0.m22554k("mEtOtherName");
        }
        if (editText == null) {
            C5544i0.m22545f();
        }
        String obj = editText.getText().toString();
        EditText editText2 = this.mEtAccount;
        if (editText2 == null) {
            C5544i0.m22554k("mEtAccount");
        }
        if (editText2 == null) {
            C5544i0.m22545f();
        }
        String obj2 = editText2.getText().toString();
        RelationPlatBean relationPlatBean = this.platBean;
        if (relationPlatBean == null || relationPlatBean.getEx() != 2) {
            RelationPlatBean relationPlatBean2 = this.platBean;
            if (relationPlatBean2 != null && relationPlatBean2.getEx() == 1 && TextUtils.isEmpty(obj)) {
                C7331w1.m26688a("请输入平台名称");
                return;
            }
        } else if (TextUtils.isEmpty(obj)) {
            C7331w1.m26688a("请输入公众号/服务号名称");
            return;
        }
        if (TextUtils.isEmpty(obj2)) {
            C7331w1.m26688a("请输入嫌疑人手机号");
            return;
        }
        if (this.f25902bean == null) {
            this.f25902bean = new RelationBean();
        }
        RelationBean relationBean = this.f25902bean;
        if (relationBean != null) {
            relationBean.setCaseInfoID(this.caseInfoId);
        }
        RelationBean relationBean2 = this.f25902bean;
        if (relationBean2 != null) {
            relationBean2.setSuspectMobile(obj2);
        }
        RelationPlatBean relationPlatBean3 = this.platBean;
        if (relationPlatBean3 == null || relationPlatBean3.getEx() != 0) {
            RelationBean relationBean3 = this.f25902bean;
            if (relationBean3 != null) {
                relationBean3.setPlatformText(obj);
            }
            RelationBean relationBean4 = this.f25902bean;
            if (relationBean4 != null) {
                relationBean4.setPlatform(subContains(obj));
            }
        } else {
            RelationBean relationBean5 = this.f25902bean;
            if (relationBean5 != null) {
                RelationPlatBean relationPlatBean4 = this.platBean;
                relationBean5.setPlatform(relationPlatBean4 != null ? relationPlatBean4.getPlatform() : null);
            }
            RelationBean relationBean6 = this.f25902bean;
            if (relationBean6 != null) {
                RelationPlatBean relationPlatBean5 = this.platBean;
                relationBean6.setPlatformText(relationPlatBean5 != null ? relationPlatBean5.getPlatformText() : null);
            }
        }
        if (C5544i0.m22531a((Object) obj2, (Object) AccountManager.getVisiblePhone())) {
            C7257b1.m26183a(this.mActivity, "添加的嫌疑人手机号码是您的登录号码，确定添加个人号码为诈骗号码?", "", "取消", "确定", -1, -1, (IClickListener) new C6483c());
        } else {
            saveHttpApi();
        }
    }

    public final void onkeyback() {
        C7257b1.m26211b(this.mActivity, "放弃本次信息编辑？", "", "确定", "取消", new C6484d());
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_relation_acc_add;
    }

    public final void setMEtAccount(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtAccount = editText;
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

    public final void setScrollView(@InterfaceC5816d NestedScrollView nestedScrollView) {
        C5544i0.m22546f(nestedScrollView, "<set-?>");
        this.scrollView = nestedScrollView;
    }

    public final void showTagView() {
        this.platBean = this.platBeans.get(this.selectIndex);
        RelationPlatBean relationPlatBean = this.platBean;
        if (relationPlatBean != null && relationPlatBean.getEx() == 1) {
            View view = this.mLlAccOther;
            if (view == null) {
                C5544i0.m22554k("mLlAccOther");
            }
            if (view == null) {
                C5544i0.m22545f();
            }
            view.setVisibility(0);
            TextView textView = this.mTvOtherTips;
            if (textView == null) {
                C5544i0.m22554k("mTvOtherTips");
            }
            if (textView == null) {
                C5544i0.m22545f();
            }
            textView.setText("平台名称");
            EditText editText = this.mEtOtherName;
            if (editText == null) {
                C5544i0.m22554k("mEtOtherName");
            }
            if (editText == null) {
                C5544i0.m22545f();
            }
            editText.setHint("请输入平台名称");
            EditText editText2 = this.mEtOtherName;
            if (editText2 == null) {
                C5544i0.m22554k("mEtOtherName");
            }
            editText2.setText("");
            return;
        }
        RelationPlatBean relationPlatBean2 = this.platBean;
        if (relationPlatBean2 == null || relationPlatBean2.getEx() != 2) {
            View view2 = this.mLlAccOther;
            if (view2 == null) {
                C5544i0.m22554k("mLlAccOther");
            }
            if (view2 == null) {
                C5544i0.m22545f();
            }
            view2.setVisibility(8);
            View view3 = this.mLlAccNorm;
            if (view3 == null) {
                C5544i0.m22554k("mLlAccNorm");
            }
            if (view3 == null) {
                C5544i0.m22545f();
            }
            view3.setVisibility(0);
            EditText editText3 = this.mEtOtherName;
            if (editText3 == null) {
                C5544i0.m22554k("mEtOtherName");
            }
            editText3.setText("");
            return;
        }
        View view4 = this.mLlAccOther;
        if (view4 == null) {
            C5544i0.m22554k("mLlAccOther");
        }
        if (view4 == null) {
            C5544i0.m22545f();
        }
        view4.setVisibility(0);
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
        EditText editText5 = this.mEtOtherName;
        if (editText5 == null) {
            C5544i0.m22554k("mEtOtherName");
        }
        editText5.setText("");
    }
}
