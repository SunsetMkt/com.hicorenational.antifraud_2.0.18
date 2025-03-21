package p388ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AppInfoBean;
import com.hicorenational.antifraud.C2113R;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3397d;
import java.util.ArrayList;
import java.util.Iterator;
import p286h.C5226e1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5539g1;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5726c0;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.Hicore;
import p388ui.activity.SearchAppActivity;
import p388ui.basemvp.BaseView;
import p388ui.model.ModelPresent;

/* compiled from: AppSearchPresenter.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0018\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\u00122\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eJ\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\nR\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m23546d2 = {"Lui/presenter/AppSearchPresenter;", "Lui/model/ModelPresent;", "Lui/basemvp/BaseView;", "Landroid/widget/Filterable;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "itemAdapter", "Lui/presenter/AppSearchPresenter$RyListAdapte;", "mOnItemClickListener", "Lui/presenter/AppSearchPresenter$OnItemClickListener;", "phoneAllApps", "Ljava/util/ArrayList;", "Lbean/AppInfoBean;", "Lkotlin/collections/ArrayList;", "getFilter", "Landroid/widget/Filter;", "initRecycleCoins", "", "mViewRecycle", "Landroidx/recyclerview/widget/RecyclerView;", "setListData", "setOnItemClickListener", "onItemClickListener", "OnItemClickListener", "RyListAdapte", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class AppSearchPresenter extends ModelPresent<BaseView> implements Filterable {
    private RyListAdapte itemAdapter;
    private InterfaceC6926a mOnItemClickListener;
    private ArrayList<AppInfoBean> phoneAllApps;

    /* compiled from: AppSearchPresenter.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\f\u001a\u00020\bH\u0016J \u0010\r\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m23546d2 = {"Lui/presenter/AppSearchPresenter$RyListAdapte;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lui/presenter/AppSearchPresenter$RyListAdapte$ListHolder;", "Lui/presenter/AppSearchPresenter;", C3397d.f11892R, "Landroid/content/Context;", "(Lui/presenter/AppSearchPresenter;Landroid/content/Context;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ListHolder", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
    public final class RyListAdapte extends RecyclerView.Adapter<ListHolder> {

        /* renamed from: a */
        private final Context f23966a;

        /* renamed from: b */
        final /* synthetic */ AppSearchPresenter f23967b;

        /* compiled from: AppSearchPresenter.kt */
        @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\n¨\u0006\u001a"}, m23546d2 = {"Lui/presenter/AppSearchPresenter$RyListAdapte$ListHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lui/presenter/AppSearchPresenter$RyListAdapte;Landroid/view/View;)V", "appIv", "Landroid/widget/ImageView;", "getAppIv", "()Landroid/widget/ImageView;", "setAppIv", "(Landroid/widget/ImageView;)V", "appName", "Landroid/widget/TextView;", "getAppName", "()Landroid/widget/TextView;", "setAppName", "(Landroid/widget/TextView;)V", "appVersion", "getAppVersion", "setAppVersion", "checkImg", "getCheckImg", "setCheckImg", "checkImg2", "getCheckImg2", "setCheckImg2", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
        public final class ListHolder extends RecyclerView.ViewHolder {

            /* renamed from: a */
            @InterfaceC5816d
            private ImageView f23968a;

            /* renamed from: b */
            @InterfaceC5816d
            private TextView f23969b;

            /* renamed from: c */
            @InterfaceC5816d
            private TextView f23970c;

            /* renamed from: d */
            @InterfaceC5816d
            private ImageView f23971d;

            /* renamed from: e */
            @InterfaceC5816d
            private ImageView f23972e;

            /* renamed from: f */
            final /* synthetic */ RyListAdapte f23973f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ListHolder(@InterfaceC5816d RyListAdapte ryListAdapte, View view) {
                super(view);
                C5544i0.m22546f(view, "itemView");
                this.f23973f = ryListAdapte;
                View findViewById = view.findViewById(C2113R.id.app_icon);
                C5544i0.m22521a((Object) findViewById, "itemView.findViewById(R.id.app_icon)");
                this.f23968a = (ImageView) findViewById;
                View findViewById2 = view.findViewById(C2113R.id.tv_app_name);
                C5544i0.m22521a((Object) findViewById2, "itemView.findViewById(R.id.tv_app_name)");
                this.f23969b = (TextView) findViewById2;
                View findViewById3 = view.findViewById(C2113R.id.tv_app_version);
                C5544i0.m22521a((Object) findViewById3, "itemView.findViewById(R.id.tv_app_version)");
                this.f23970c = (TextView) findViewById3;
                View findViewById4 = view.findViewById(C2113R.id.iv_checkbox);
                C5544i0.m22521a((Object) findViewById4, "itemView.findViewById(R.id.iv_checkbox)");
                this.f23971d = (ImageView) findViewById4;
                View findViewById5 = view.findViewById(C2113R.id.iv_checkbox2);
                C5544i0.m22521a((Object) findViewById5, "itemView.findViewById(R.id.iv_checkbox2)");
                this.f23972e = (ImageView) findViewById5;
            }

            @InterfaceC5816d
            /* renamed from: a */
            public final ImageView m25615a() {
                return this.f23968a;
            }

            @InterfaceC5816d
            /* renamed from: b */
            public final TextView m25618b() {
                return this.f23969b;
            }

            @InterfaceC5816d
            /* renamed from: c */
            public final TextView m25621c() {
                return this.f23970c;
            }

            @InterfaceC5816d
            /* renamed from: d */
            public final ImageView m25623d() {
                return this.f23971d;
            }

            @InterfaceC5816d
            /* renamed from: e */
            public final ImageView m25624e() {
                return this.f23972e;
            }

            /* renamed from: a */
            public final void m25616a(@InterfaceC5816d ImageView imageView) {
                C5544i0.m22546f(imageView, "<set-?>");
                this.f23968a = imageView;
            }

            /* renamed from: b */
            public final void m25620b(@InterfaceC5816d TextView textView) {
                C5544i0.m22546f(textView, "<set-?>");
                this.f23970c = textView;
            }

            /* renamed from: c */
            public final void m25622c(@InterfaceC5816d ImageView imageView) {
                C5544i0.m22546f(imageView, "<set-?>");
                this.f23972e = imageView;
            }

            /* renamed from: a */
            public final void m25617a(@InterfaceC5816d TextView textView) {
                C5544i0.m22546f(textView, "<set-?>");
                this.f23969b = textView;
            }

            /* renamed from: b */
            public final void m25619b(@InterfaceC5816d ImageView imageView) {
                C5544i0.m22546f(imageView, "<set-?>");
                this.f23971d = imageView;
            }
        }

        /* compiled from: AppSearchPresenter.kt */
        /* renamed from: ui.presenter.AppSearchPresenter$RyListAdapte$a */
        static final class ViewOnClickListenerC6925a implements View.OnClickListener {

            /* renamed from: b */
            final /* synthetic */ C5539g1.h f23975b;

            ViewOnClickListenerC6925a(C5539g1.h hVar) {
                this.f23975b = hVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterfaceC6926a interfaceC6926a;
                if (RyListAdapte.this.f23967b.mOnItemClickListener == null || (interfaceC6926a = RyListAdapte.this.f23967b.mOnItemClickListener) == null) {
                    return;
                }
                interfaceC6926a.mo25323a((AppInfoBean) this.f23975b.element);
            }
        }

        public RyListAdapte(@InterfaceC5816d AppSearchPresenter appSearchPresenter, Context context) {
            C5544i0.m22546f(context, C3397d.f11892R);
            this.f23967b = appSearchPresenter;
            this.f23966a = context;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v2, types: [T, bean.AppInfoBean] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@InterfaceC5816d ListHolder listHolder, int i2) {
            C5544i0.m22546f(listHolder, "holder");
            if (this.f23967b.phoneAllApps.size() > 0) {
                C5539g1.h hVar = new C5539g1.h();
                Object obj = this.f23967b.phoneAllApps.get(i2);
                C5544i0.m22521a(obj, "phoneAllApps.get(position)");
                hVar.element = (AppInfoBean) obj;
                T t = hVar.element;
                if (((AppInfoBean) t) != null) {
                    Drawable appIcon = ((AppInfoBean) t).getAppIcon();
                    if (appIcon != null) {
                        listHolder.m25615a().setImageDrawable(appIcon);
                    }
                    listHolder.m25618b().setText(((AppInfoBean) hVar.element).getName());
                    String formatFileSize = Formatter.formatFileSize(Hicore.getApp(), ((AppInfoBean) hVar.element).getFileSize());
                    listHolder.m25621c().setText("版本:" + ((AppInfoBean) hVar.element).getVersionCode() + "  |  " + formatFileSize);
                    if (((AppInfoBean) hVar.element).getFileSize() > 209715200) {
                        listHolder.m25623d().setVisibility(8);
                        listHolder.m25624e().setVisibility(0);
                    } else if (((AppInfoBean) hVar.element).isSelect()) {
                        listHolder.m25623d().setImageResource(C2113R.mipmap.checkbox_checked);
                        listHolder.m25623d().setVisibility(0);
                        listHolder.m25624e().setVisibility(8);
                    } else {
                        listHolder.m25623d().setImageResource(C2113R.mipmap.checkbox_unchecked);
                        listHolder.m25623d().setVisibility(0);
                        listHolder.m25624e().setVisibility(8);
                    }
                    listHolder.itemView.setOnClickListener(new ViewOnClickListenerC6925a(hVar));
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f23967b.phoneAllApps.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @InterfaceC5816d
        public ListHolder onCreateViewHolder(@InterfaceC5816d ViewGroup viewGroup, int i2) {
            C5544i0.m22546f(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.f23966a).inflate(C2113R.layout.recyclerview_app_select, viewGroup, false);
            C5544i0.m22521a((Object) inflate, "LayoutInflater.from(cont…pp_select, parent, false)");
            return new ListHolder(this, inflate);
        }
    }

    /* compiled from: AppSearchPresenter.kt */
    /* renamed from: ui.presenter.AppSearchPresenter$a */
    public interface InterfaceC6926a {
        /* renamed from: a */
        void mo25323a(@InterfaceC5816d AppInfoBean appInfoBean);
    }

    /* compiled from: AppSearchPresenter.kt */
    /* renamed from: ui.presenter.AppSearchPresenter$b */
    public static final class C6927b extends Filter {
        C6927b() {
        }

        @Override // android.widget.Filter
        @InterfaceC5816d
        protected Filter.FilterResults performFiltering(@InterfaceC5816d CharSequence charSequence) {
            boolean m23774c;
            C5544i0.m22546f(charSequence, C3351bh.f11580aE);
            String obj = charSequence.toString();
            if (obj == null) {
                throw new C5226e1("null cannot be cast to non-null type java.lang.String");
            }
            String upperCase = obj.toUpperCase();
            C5544i0.m22521a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList arrayList = new ArrayList();
            if (SearchAppActivity.f23042f.m25324a() != null) {
                ArrayList<AppInfoBean> m25324a = SearchAppActivity.f23042f.m25324a();
                if ((m25324a != null ? Integer.valueOf(m25324a.size()) : null).intValue() > 0) {
                    Iterator<AppInfoBean> it = SearchAppActivity.f23042f.m25324a().iterator();
                    while (it.hasNext()) {
                        AppInfoBean next = it.next();
                        C5544i0.m22521a((Object) next, Constants.JumpUrlConstants.SRC_TYPE_APP);
                        String name = next.getName();
                        C5544i0.m22521a((Object) name, "app.name");
                        m23774c = C5726c0.m23774c((CharSequence) name, (CharSequence) upperCase, false, 2, (Object) null);
                        if (m23774c) {
                            arrayList.add(next);
                        }
                    }
                }
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d Filter.FilterResults filterResults) {
            C5544i0.m22546f(charSequence, "constraint");
            C5544i0.m22546f(filterResults, "results");
            try {
                AppSearchPresenter appSearchPresenter = AppSearchPresenter.this;
                Object obj = filterResults.values;
                if (obj == null) {
                    throw new C5226e1("null cannot be cast to non-null type kotlin.collections.ArrayList<bean.AppInfoBean> /* = java.util.ArrayList<bean.AppInfoBean> */");
                }
                appSearchPresenter.phoneAllApps = (ArrayList) obj;
                RyListAdapte ryListAdapte = AppSearchPresenter.this.itemAdapter;
                if (ryListAdapte != null) {
                    ryListAdapte.notifyDataSetChanged();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppSearchPresenter(@InterfaceC5816d Activity activity) {
        super(activity, (BaseView) null);
        C5544i0.m22546f(activity, "activity");
        this.phoneAllApps = new ArrayList<>();
    }

    @Override // android.widget.Filterable
    @InterfaceC5816d
    public Filter getFilter() {
        return new C6927b();
    }

    public final void initRecycleCoins(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "mViewRecycle");
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        Activity activity = this.mActivity;
        C5544i0.m22521a((Object) activity, "mActivity");
        this.itemAdapter = new RyListAdapte(this, activity);
        recyclerView.setAdapter(this.itemAdapter);
    }

    public final void setListData(@InterfaceC5816d ArrayList<AppInfoBean> arrayList) {
        C5544i0.m22546f(arrayList, "phoneAllApps");
        this.phoneAllApps = arrayList;
        RyListAdapte ryListAdapte = this.itemAdapter;
        if (ryListAdapte != null) {
            ryListAdapte.notifyDataSetChanged();
        }
    }

    public final void setOnItemClickListener(@InterfaceC5816d InterfaceC6926a interfaceC6926a) {
        C5544i0.m22546f(interfaceC6926a, "onItemClickListener");
        this.mOnItemClickListener = interfaceC6926a;
    }
}
