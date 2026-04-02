package ui.activity;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import bean.AppInfoBean;
import com.hicorenational.antifraud.R;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import ui.presenter.AppSearchPresenter;
import ui.view.swip.SwipBackLayout;
import util.e2;

/* JADX INFO: compiled from: SearchAppActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lui/activity/SearchAppActivity;", "Lui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lui/presenter/AppSearchPresenter$OnItemClickListener;", "()V", "mEtSearch", "Landroid/widget/EditText;", "mIvBack", "Landroid/widget/ImageView;", "mPresenter", "Lui/presenter/AppSearchPresenter;", "mRvAppList", "Landroidx/recyclerview/widget/RecyclerView;", "doAppCompare", "", "initListener", "initPage", "initView", "onClick", "view", "Landroid/view/View;", "onItemClickListener", "bean", "Lbean/AppInfoBean;", "setLayoutView", "", "Companion", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class SearchAppActivity extends BaseActivity implements View.OnClickListener, AppSearchPresenter.a {

    /* JADX INFO: renamed from: e */
    @j.c.a.d
    public static ArrayList<AppInfoBean> f13767e;

    /* JADX INFO: renamed from: f */
    public static final a f13768f = new a(null);
    private ImageView a;

    /* JADX INFO: renamed from: b */
    private EditText f13769b;

    /* JADX INFO: renamed from: c */
    private RecyclerView f13770c;

    /* JADX INFO: renamed from: d */
    private AppSearchPresenter f13771d;

    /* JADX INFO: compiled from: SearchAppActivity.kt */
    public static final class a {
        private a() {
        }

        @j.c.a.d
        public final ArrayList<AppInfoBean> a() {
            ArrayList<AppInfoBean> arrayList = SearchAppActivity.f13767e;
            if (arrayList == null) {
                i.q2.t.i0.k("phoneAllApps");
            }
            return arrayList;
        }

        public /* synthetic */ a(i.q2.t.v vVar) {
            this();
        }

        public final void a(@j.c.a.d ArrayList<AppInfoBean> arrayList) {
            i.q2.t.i0.f(arrayList, "<set-?>");
            SearchAppActivity.f13767e = arrayList;
        }
    }

    /* JADX INFO: compiled from: SearchAppActivity.kt */
    static final class b<T> implements Comparator<AppInfoBean> {
        final /* synthetic */ Collator a;

        b(Collator collator) {
            this.a = collator;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a */
        public final int compare(AppInfoBean appInfoBean, AppInfoBean appInfoBean2) {
            Collator collator = this.a;
            i.q2.t.i0.a((Object) appInfoBean, "o1");
            String name = appInfoBean.getName();
            i.q2.t.i0.a((Object) appInfoBean2, "o2");
            return collator.compare(name, appInfoBean2.getName());
        }
    }

    /* JADX INFO: compiled from: SearchAppActivity.kt */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@j.c.a.e Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@j.c.a.e CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@j.c.a.e CharSequence charSequence, int i2, int i3, int i4) {
            Filter filter;
            AppSearchPresenter appSearchPresenter = SearchAppActivity.this.f13771d;
            if (appSearchPresenter == null || (filter = appSearchPresenter.getFilter()) == null) {
                return;
            }
            filter.filter(String.valueOf(charSequence));
        }
    }

    public final void initListener() {
        ImageView imageView = this.a;
        if (imageView == null) {
            i.q2.t.i0.k("mIvBack");
        }
        if (imageView == null) {
            i.q2.t.i0.f();
        }
        imageView.setOnClickListener(this);
        AppSearchPresenter appSearchPresenter = this.f13771d;
        if (appSearchPresenter != null) {
            appSearchPresenter.setOnItemClickListener(this);
        }
        EditText editText = this.f13769b;
        if (editText == null) {
            i.q2.t.i0.k("mEtSearch");
        }
        editText.addTextChangedListener(new c());
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        SwipBackLayout.a(this.mActivity).a();
        initView();
        initListener();
    }

    public final void initView() {
        View viewFindViewById = findViewById(R.id.iv_back);
        i.q2.t.i0.a((Object) viewFindViewById, "findViewById(R.id.iv_back)");
        this.a = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.et_search);
        i.q2.t.i0.a((Object) viewFindViewById2, "findViewById(R.id.et_search)");
        this.f13769b = (EditText) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.rv_appList);
        i.q2.t.i0.a((Object) viewFindViewById3, "findViewById(R.id.rv_appList)");
        this.f13770c = (RecyclerView) viewFindViewById3;
        Activity activity = this.mActivity;
        i.q2.t.i0.a((Object) activity, "mActivity");
        this.f13771d = new AppSearchPresenter(activity);
        AppSearchPresenter appSearchPresenter = this.f13771d;
        if (appSearchPresenter != null) {
            RecyclerView recyclerView = this.f13770c;
            if (recyclerView == null) {
                i.q2.t.i0.k("mRvAppList");
            }
            appSearchPresenter.initRecycleCoins(recyclerView);
        }
        AppSearchPresenter appSearchPresenter2 = this.f13771d;
        if (appSearchPresenter2 != null) {
            ArrayList<AppInfoBean> arrayList = f13767e;
            if (arrayList == null) {
                i.q2.t.i0.k("phoneAllApps");
            }
            appSearchPresenter2.setListData(arrayList);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            a();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_app_search;
    }

    public final void a() {
        ArrayList<AppInfoBean> arrayList = new ArrayList<>();
        ArrayList<AppInfoBean> arrayList2 = f13767e;
        if (arrayList2 == null) {
            i.q2.t.i0.k("phoneAllApps");
        }
        if (arrayList2.size() > 0) {
            ArrayList<AppInfoBean> arrayList3 = f13767e;
            if (arrayList3 == null) {
                i.q2.t.i0.k("phoneAllApps");
            }
            int size = arrayList3.size();
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList<AppInfoBean> arrayList4 = f13767e;
                if (arrayList4 == null) {
                    i.q2.t.i0.k("phoneAllApps");
                }
                AppInfoBean appInfoBean = arrayList4.get(i2);
                i.q2.t.i0.a((Object) appInfoBean, "phoneAllApps.get(index)");
                AppInfoBean appInfoBean2 = appInfoBean;
                if (appInfoBean2.getFileSize() <= 209715200) {
                    arrayList.add(appInfoBean2);
                }
            }
        }
        Collections.sort(arrayList, new b(Collator.getInstance(Locale.CHINA)));
        AppSearchPresenter appSearchPresenter = this.f13771d;
        if (appSearchPresenter != null) {
            appSearchPresenter.setListData(arrayList);
        }
    }

    @Override // ui.presenter.AppSearchPresenter.a
    public void a(@j.c.a.d AppInfoBean appInfoBean) {
        i.q2.t.i0.f(appInfoBean, "bean");
        if (appInfoBean.getFileSize() > 209715200) {
            e2.a("200M\u4ee5\u4e0a\u6587\u4ef6\u4e0d\u53ef\u9009\u62e9");
            return;
        }
        org.greenrobot.eventbus.c.f().d(new util.n2.a(35, null));
        org.greenrobot.eventbus.c.f().d(new util.n2.a(30, appInfoBean));
        finish();
    }
}
