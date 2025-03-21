package p388ui.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.InDustryBean;
import bean.UserInfoBean;
import com.hicorenational.antifraud.C2113R;
import com.umeng.analytics.pro.C3397d;
import java.util.ArrayList;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.IndustryAddView;
import p388ui.presenter.IndustrysPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;
import util.C7307p1;

/* compiled from: IndustryListActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00011B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020$H\u0016J\u000e\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u0014J\u0006\u0010(\u001a\u00020$J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020$2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020$H\u0016J\b\u00100\u001a\u00020\u001bH\u0016R\u0014\u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00062"}, m23546d2 = {"Lui/activity/IndustryListActivity;", "Lui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lui/callview/IndustryAddView;", "()V", "dayAdapter", "Lui/activity/IndustryListActivity$IndustrysAdapte;", "industrys", "Ljava/util/ArrayList;", "Lbean/InDustryBean;", "Lkotlin/collections/ArrayList;", "mIvBack", "Landroid/widget/ImageView;", "mPresenter", "Lui/presenter/IndustrysPresenter;", "getMPresenter", "()Lui/presenter/IndustrysPresenter;", "setMPresenter", "(Lui/presenter/IndustrysPresenter;)V", "mRvList", "Landroidx/recyclerview/widget/RecyclerView;", "mTvRight", "Landroid/widget/TextView;", "mTvTitle", "selectName", "", "selected", "", "Ljava/lang/Integer;", "userInfo", "Lbean/UserInfoBean;", "getUserInfo", "()Lbean/UserInfoBean;", "setUserInfo", "(Lbean/UserInfoBean;)V", "initListener", "", "initPage", "initRVIndustrys", "mViewRecycle", "initView", "onClick", "view", "Landroid/view/View;", "onSuccIndustryRequest", "bean", "", "onSuccUpdateRequest", "setLayoutView", "IndustrysAdapte", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class IndustryListActivity extends BaseActivity implements View.OnClickListener, IndustryAddView {
    private IndustrysAdapte dayAdapter;
    private ImageView mIvBack;

    @InterfaceC5817e
    private IndustrysPresenter mPresenter;
    private RecyclerView mRvList;
    private TextView mTvRight;
    private TextView mTvTitle;

    @InterfaceC5817e
    private UserInfoBean userInfo;
    private ArrayList<InDustryBean> industrys = new ArrayList<>();
    private Integer selected = 0;
    private String selectName = "";

    /* compiled from: IndustryListActivity.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\f\u001a\u00020\bH\u0016J \u0010\r\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m23546d2 = {"Lui/activity/IndustryListActivity$IndustrysAdapte;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lui/activity/IndustryListActivity$IndustrysAdapte$ListHolder;", "Lui/activity/IndustryListActivity;", C3397d.f11892R, "Landroid/content/Context;", "(Lui/activity/IndustryListActivity;Landroid/content/Context;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ListHolder", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
    public final class IndustrysAdapte extends RecyclerView.Adapter<ListHolder> {

        /* renamed from: a */
        private final Context f22429a;

        /* renamed from: b */
        final /* synthetic */ IndustryListActivity f22430b;

        /* compiled from: IndustryListActivity.kt */
        @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m23546d2 = {"Lui/activity/IndustryListActivity$IndustrysAdapte$ListHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lui/activity/IndustryListActivity$IndustrysAdapte;Landroid/view/View;)V", "mIvSelect", "Landroid/widget/ImageView;", "getMIvSelect", "()Landroid/widget/ImageView;", "setMIvSelect", "(Landroid/widget/ImageView;)V", "mTvCont", "Landroid/widget/TextView;", "getMTvCont", "()Landroid/widget/TextView;", "setMTvCont", "(Landroid/widget/TextView;)V", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
        public final class ListHolder extends RecyclerView.ViewHolder {

            /* renamed from: a */
            @InterfaceC5816d
            private TextView f22431a;

            /* renamed from: b */
            @InterfaceC5816d
            private ImageView f22432b;

            /* renamed from: c */
            final /* synthetic */ IndustrysAdapte f22433c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ListHolder(@InterfaceC5816d IndustrysAdapte industrysAdapte, View view) {
                super(view);
                C5544i0.m22546f(view, "itemView");
                this.f22433c = industrysAdapte;
                View findViewById = view.findViewById(C2113R.id.content);
                C5544i0.m22521a((Object) findViewById, "itemView.findViewById(R.id.content)");
                this.f22431a = (TextView) findViewById;
                View findViewById2 = view.findViewById(C2113R.id.iv_select);
                C5544i0.m22521a((Object) findViewById2, "itemView.findViewById(R.id.iv_select)");
                this.f22432b = (ImageView) findViewById2;
            }

            /* renamed from: a */
            public final void m25262a(@InterfaceC5816d TextView textView) {
                C5544i0.m22546f(textView, "<set-?>");
                this.f22431a = textView;
            }

            @InterfaceC5816d
            /* renamed from: b */
            public final TextView m25263b() {
                return this.f22431a;
            }

            @InterfaceC5816d
            /* renamed from: a */
            public final ImageView m25260a() {
                return this.f22432b;
            }

            /* renamed from: a */
            public final void m25261a(@InterfaceC5816d ImageView imageView) {
                C5544i0.m22546f(imageView, "<set-?>");
                this.f22432b = imageView;
            }
        }

        /* compiled from: IndustryListActivity.kt */
        /* renamed from: ui.activity.IndustryListActivity$IndustrysAdapte$a */
        static final class ViewOnClickListenerC6341a implements View.OnClickListener {

            /* renamed from: b */
            final /* synthetic */ int f22435b;

            ViewOnClickListenerC6341a(int i2) {
                this.f22435b = i2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IndustryListActivity industryListActivity = IndustrysAdapte.this.f22430b;
                Object obj = industryListActivity.industrys.get(this.f22435b);
                C5544i0.m22521a(obj, "industrys.get(position)");
                industryListActivity.selected = Integer.valueOf(((InDustryBean) obj).getPositionId());
                IndustryListActivity industryListActivity2 = IndustrysAdapte.this.f22430b;
                Object obj2 = industryListActivity2.industrys.get(this.f22435b);
                C5544i0.m22521a(obj2, "industrys.get(position)");
                industryListActivity2.selectName = ((InDustryBean) obj2).getPositionName();
                IndustrysAdapte.this.notifyDataSetChanged();
                IndustrysPresenter mPresenter = IndustrysAdapte.this.f22430b.getMPresenter();
                if (mPresenter != null) {
                    Integer num = IndustrysAdapte.this.f22430b.selected;
                    if (num == null) {
                        C5544i0.m22545f();
                    }
                    mPresenter.updateUserIndustry(String.valueOf(num.intValue()));
                }
            }
        }

        public IndustrysAdapte(@InterfaceC5816d IndustryListActivity industryListActivity, Context context) {
            C5544i0.m22546f(context, C3397d.f11892R);
            this.f22430b = industryListActivity;
            this.f22429a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@InterfaceC5816d ListHolder listHolder, int i2) {
            C5544i0.m22546f(listHolder, "holder");
            TextView m25263b = listHolder.m25263b();
            if (m25263b != null) {
                Object obj = this.f22430b.industrys.get(i2);
                C5544i0.m22521a(obj, "industrys.get(position)");
                m25263b.setText(((InDustryBean) obj).getPositionName());
            }
            Object obj2 = this.f22430b.industrys.get(i2);
            C5544i0.m22521a(obj2, "industrys.get(position)");
            int positionId = ((InDustryBean) obj2).getPositionId();
            Integer num = this.f22430b.selected;
            if (num != null && positionId == num.intValue()) {
                TextView m25263b2 = listHolder.m25263b();
                if (m25263b2 != null) {
                    m25263b2.setTextColor(Color.parseColor("#2B4CFF"));
                }
                ImageView m25260a = listHolder.m25260a();
                if (m25260a == null) {
                    C5544i0.m22545f();
                }
                m25260a.setVisibility(0);
            } else {
                TextView m25263b3 = listHolder.m25263b();
                if (m25263b3 != null) {
                    m25263b3.setTextColor(Color.parseColor("#000000"));
                }
                ImageView m25260a2 = listHolder.m25260a();
                if (m25260a2 == null) {
                    C5544i0.m22545f();
                }
                m25260a2.setVisibility(8);
            }
            listHolder.itemView.setOnClickListener(new ViewOnClickListenerC6341a(i2));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f22430b.industrys.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @InterfaceC5816d
        public ListHolder onCreateViewHolder(@InterfaceC5816d ViewGroup viewGroup, int i2) {
            C5544i0.m22546f(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.f22429a).inflate(C2113R.layout.item_industry, viewGroup, false);
            C5544i0.m22521a((Object) inflate, "LayoutInflater.from(cont…_industry, parent, false)");
            return new ListHolder(this, inflate);
        }
    }

    @InterfaceC5817e
    public final IndustrysPresenter getMPresenter() {
        return this.mPresenter;
    }

    @InterfaceC5817e
    public final UserInfoBean getUserInfo() {
        return this.userInfo;
    }

    public final void initListener() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        if (imageView == null) {
            C5544i0.m22545f();
        }
        imageView.setOnClickListener(this);
        TextView textView = this.mTvRight;
        if (textView == null) {
            C5544i0.m22554k("mTvRight");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setOnClickListener(this);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C7161b.m25698a((Activity) this, true, true);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mPresenter = new IndustrysPresenter(this.mActivity, this);
        initView();
        initListener();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("行业");
        RecyclerView recyclerView = this.mRvList;
        if (recyclerView == null) {
            C5544i0.m22554k("mRvList");
        }
        initRVIndustrys(recyclerView);
        IndustrysPresenter industrysPresenter = this.mPresenter;
        if (industrysPresenter != null) {
            industrysPresenter.getIndustry();
        }
    }

    public final void initRVIndustrys(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "mViewRecycle");
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        Activity activity = this.mActivity;
        C5544i0.m22521a((Object) activity, "mActivity");
        this.dayAdapter = new IndustrysAdapte(this, activity);
        recyclerView.setAdapter(this.dayAdapter);
    }

    public final void initView() {
        String position;
        View findViewById = findViewById(C2113R.id.iv_back);
        C5544i0.m22521a((Object) findViewById, "findViewById(R.id.iv_back)");
        this.mIvBack = (ImageView) findViewById;
        View findViewById2 = findViewById(C2113R.id.tv_title);
        C5544i0.m22521a((Object) findViewById2, "findViewById(R.id.tv_title)");
        this.mTvTitle = (TextView) findViewById2;
        View findViewById3 = findViewById(C2113R.id.tv_right);
        C5544i0.m22521a((Object) findViewById3, "findViewById(R.id.tv_right)");
        this.mTvRight = (TextView) findViewById3;
        View findViewById4 = findViewById(C2113R.id.rv_List);
        C5544i0.m22521a((Object) findViewById4, "findViewById(R.id.rv_List)");
        this.mRvList = (RecyclerView) findViewById4;
        this.userInfo = (UserInfoBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        UserInfoBean userInfoBean = this.userInfo;
        this.selected = (userInfoBean == null || (position = userInfoBean.getPosition()) == null) ? null : Integer.valueOf(Integer.parseInt(position));
        UserInfoBean userInfoBean2 = this.userInfo;
        this.selectName = userInfoBean2 != null ? userInfoBean2.getProfessionName() : null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            m8092a();
        }
    }

    @Override // p388ui.callview.IndustryAddView
    public void onSuccIndustryRequest(@InterfaceC5817e List<? extends InDustryBean> list) {
        if (list != null) {
            this.industrys = (ArrayList) list;
            IndustrysAdapte industrysAdapte = this.dayAdapter;
            if (industrysAdapte != null) {
                industrysAdapte.notifyDataSetChanged();
            }
        }
    }

    @Override // p388ui.callview.IndustryAddView
    public void onSuccUpdateRequest() {
        UserInfoBean userInfoBean = (UserInfoBean) C7307p1.m26476a(C7307p1.f25503l, UserInfoBean.class);
        C5544i0.m22521a((Object) userInfoBean, "userInfoBean");
        Integer num = this.selected;
        if (num == null) {
            C5544i0.m22545f();
        }
        userInfoBean.setPosition(String.valueOf(num.intValue()));
        userInfoBean.setProfessionName(this.selectName);
        C7307p1.m26478a(C7307p1.f25503l, userInfoBean);
        finish();
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_industry_list;
    }

    public final void setMPresenter(@InterfaceC5817e IndustrysPresenter industrysPresenter) {
        this.mPresenter = industrysPresenter;
    }

    public final void setUserInfo(@InterfaceC5817e UserInfoBean userInfoBean) {
        this.userInfo = userInfoBean;
    }
}
