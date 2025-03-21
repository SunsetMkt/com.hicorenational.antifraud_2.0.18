package p388ui.activity;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import bean.AppInfoBean;
import com.hicorenational.antifraud.C2113R;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import org.greenrobot.eventbus.C6049c;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.presenter.AppSearchPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7331w1;
import util.p395c2.C7265a;

/* compiled from: SearchAppActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m23546d2 = {"Lui/activity/SearchAppActivity;", "Lui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lui/presenter/AppSearchPresenter$OnItemClickListener;", "()V", "mEtSearch", "Landroid/widget/EditText;", "mIvBack", "Landroid/widget/ImageView;", "mPresenter", "Lui/presenter/AppSearchPresenter;", "mRvAppList", "Landroidx/recyclerview/widget/RecyclerView;", "doAppCompare", "", "initListener", "initPage", "initView", "onClick", "view", "Landroid/view/View;", "onItemClickListener", "bean", "Lbean/AppInfoBean;", "setLayoutView", "", "Companion", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SearchAppActivity extends BaseActivity implements View.OnClickListener, AppSearchPresenter.InterfaceC6926a {

    /* renamed from: e */
    @InterfaceC5816d
    public static ArrayList<AppInfoBean> f23041e;

    /* renamed from: f */
    public static final C6561a f23042f = new C6561a(null);

    /* renamed from: a */
    private ImageView f23043a;

    /* renamed from: b */
    private EditText f23044b;

    /* renamed from: c */
    private RecyclerView f23045c;

    /* renamed from: d */
    private AppSearchPresenter f23046d;

    /* compiled from: SearchAppActivity.kt */
    /* renamed from: ui.activity.SearchAppActivity$a */
    public static final class C6561a {
        private C6561a() {
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final ArrayList<AppInfoBean> m25324a() {
            ArrayList<AppInfoBean> arrayList = SearchAppActivity.f23041e;
            if (arrayList == null) {
                C5544i0.m22554k("phoneAllApps");
            }
            return arrayList;
        }

        public /* synthetic */ C6561a(C5586v c5586v) {
            this();
        }

        /* renamed from: a */
        public final void m25325a(@InterfaceC5816d ArrayList<AppInfoBean> arrayList) {
            C5544i0.m22546f(arrayList, "<set-?>");
            SearchAppActivity.f23041e = arrayList;
        }
    }

    /* compiled from: SearchAppActivity.kt */
    /* renamed from: ui.activity.SearchAppActivity$b */
    static final class C6562b<T> implements Comparator<AppInfoBean> {

        /* renamed from: a */
        final /* synthetic */ Collator f23047a;

        C6562b(Collator collator) {
            this.f23047a = collator;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(AppInfoBean appInfoBean, AppInfoBean appInfoBean2) {
            Collator collator = this.f23047a;
            C5544i0.m22521a((Object) appInfoBean, "o1");
            String name = appInfoBean.getName();
            C5544i0.m22521a((Object) appInfoBean2, "o2");
            return collator.compare(name, appInfoBean2.getName());
        }
    }

    /* compiled from: SearchAppActivity.kt */
    /* renamed from: ui.activity.SearchAppActivity$c */
    public static final class C6563c implements TextWatcher {
        C6563c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@InterfaceC5817e Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@InterfaceC5817e CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@InterfaceC5817e CharSequence charSequence, int i2, int i3, int i4) {
            Filter filter;
            AppSearchPresenter appSearchPresenter = SearchAppActivity.this.f23046d;
            if (appSearchPresenter == null || (filter = appSearchPresenter.getFilter()) == null) {
                return;
            }
            filter.filter(String.valueOf(charSequence));
        }
    }

    public final void initListener() {
        ImageView imageView = this.f23043a;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        if (imageView == null) {
            C5544i0.m22545f();
        }
        imageView.setOnClickListener(this);
        AppSearchPresenter appSearchPresenter = this.f23046d;
        if (appSearchPresenter != null) {
            appSearchPresenter.setOnItemClickListener(this);
        }
        EditText editText = this.f23044b;
        if (editText == null) {
            C5544i0.m22554k("mEtSearch");
        }
        editText.addTextChangedListener(new C6563c());
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C7161b.m25698a((Activity) this, true, true);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        initView();
        initListener();
    }

    public final void initView() {
        View findViewById = findViewById(C2113R.id.iv_back);
        C5544i0.m22521a((Object) findViewById, "findViewById(R.id.iv_back)");
        this.f23043a = (ImageView) findViewById;
        View findViewById2 = findViewById(C2113R.id.et_search);
        C5544i0.m22521a((Object) findViewById2, "findViewById(R.id.et_search)");
        this.f23044b = (EditText) findViewById2;
        View findViewById3 = findViewById(C2113R.id.rv_appList);
        C5544i0.m22521a((Object) findViewById3, "findViewById(R.id.rv_appList)");
        this.f23045c = (RecyclerView) findViewById3;
        Activity activity = this.mActivity;
        C5544i0.m22521a((Object) activity, "mActivity");
        this.f23046d = new AppSearchPresenter(activity);
        AppSearchPresenter appSearchPresenter = this.f23046d;
        if (appSearchPresenter != null) {
            RecyclerView recyclerView = this.f23045c;
            if (recyclerView == null) {
                C5544i0.m22554k("mRvAppList");
            }
            appSearchPresenter.initRecycleCoins(recyclerView);
        }
        AppSearchPresenter appSearchPresenter2 = this.f23046d;
        if (appSearchPresenter2 != null) {
            ArrayList<AppInfoBean> arrayList = f23041e;
            if (arrayList == null) {
                C5544i0.m22554k("phoneAllApps");
            }
            appSearchPresenter2.setListData(arrayList);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_app_search;
    }

    /* renamed from: a */
    public final void m25322a() {
        ArrayList<AppInfoBean> arrayList = new ArrayList<>();
        ArrayList<AppInfoBean> arrayList2 = f23041e;
        if (arrayList2 == null) {
            C5544i0.m22554k("phoneAllApps");
        }
        if (arrayList2.size() > 0) {
            ArrayList<AppInfoBean> arrayList3 = f23041e;
            if (arrayList3 == null) {
                C5544i0.m22554k("phoneAllApps");
            }
            int size = arrayList3.size();
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList<AppInfoBean> arrayList4 = f23041e;
                if (arrayList4 == null) {
                    C5544i0.m22554k("phoneAllApps");
                }
                AppInfoBean appInfoBean = arrayList4.get(i2);
                C5544i0.m22521a((Object) appInfoBean, "phoneAllApps.get(index)");
                AppInfoBean appInfoBean2 = appInfoBean;
                if (appInfoBean2.getFileSize() <= 209715200) {
                    arrayList.add(appInfoBean2);
                }
            }
        }
        Collections.sort(arrayList, new C6562b(Collator.getInstance(Locale.CHINA)));
        AppSearchPresenter appSearchPresenter = this.f23046d;
        if (appSearchPresenter != null) {
            appSearchPresenter.setListData(arrayList);
        }
    }

    @Override // p388ui.presenter.AppSearchPresenter.InterfaceC6926a
    /* renamed from: a */
    public void mo25323a(@InterfaceC5816d AppInfoBean appInfoBean) {
        C5544i0.m22546f(appInfoBean, "bean");
        if (appInfoBean.getFileSize() > 209715200) {
            C7331w1.m26688a("200M以上文件不可选择");
            return;
        }
        C6049c.m24987f().m25000d(new C7265a(35, null));
        C6049c.m24987f().m25000d(new C7265a(30, appInfoBean));
        finish();
    }
}
