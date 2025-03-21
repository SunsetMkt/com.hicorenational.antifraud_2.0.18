package adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import bean.AppInfoBean;
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import java.util.List;
import p388ui.Hicore;

/* compiled from: AppExSelectedAdapter.java */
/* renamed from: adapter.f */
/* loaded from: classes.dex */
public class C0082f extends BaseExpandableListAdapter {

    /* renamed from: a */
    private Context f347a;

    /* renamed from: b */
    private List<String> f348b;

    /* renamed from: c */
    private List<List<AppInfoBean>> f349c;

    /* renamed from: d */
    private LayoutInflater f350d;

    /* compiled from: AppExSelectedAdapter.java */
    /* renamed from: adapter.f$a */
    private class a {

        /* renamed from: a */
        ImageView f351a;

        /* renamed from: b */
        TextView f352b;

        /* renamed from: c */
        TextView f353c;

        /* renamed from: d */
        ImageView f354d;

        /* renamed from: e */
        ImageView f355e;

        public a(View view) {
            this.f351a = (ImageView) view.findViewById(C2113R.id.app_icon);
            this.f352b = (TextView) view.findViewById(C2113R.id.tv_app_name);
            this.f353c = (TextView) view.findViewById(C2113R.id.tv_app_version);
            this.f354d = (ImageView) view.findViewById(C2113R.id.iv_checkbox);
            this.f355e = (ImageView) view.findViewById(C2113R.id.iv_checkbox2);
        }
    }

    public C0082f(Context context, List<String> list, ArrayList<List<AppInfoBean>> arrayList) {
        this.f347a = context;
        this.f348b = list;
        this.f349c = arrayList;
        this.f350d = LayoutInflater.from(context);
    }

    /* renamed from: a */
    public void m292a(List<String> list, List<List<AppInfoBean>> list2) {
        this.f348b = list;
        this.f349c = list2;
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i2, int i3) {
        return this.f349c.get(i2).get(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i2, int i3) {
        return i3;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i2, int i3, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        AppInfoBean appInfoBean = this.f349c.get(i2).get(i3);
        if (view == null) {
            view = this.f350d.inflate(C2113R.layout.recyclerview_app_select, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Drawable appIcon = appInfoBean.getAppIcon();
        if (appIcon != null) {
            aVar.f351a.setImageDrawable(appIcon);
        }
        aVar.f352b.setText(appInfoBean.getName());
        String formatFileSize = Formatter.formatFileSize(Hicore.getApp(), appInfoBean.getFileSize());
        aVar.f353c.setText("版本:" + appInfoBean.getVersionCode() + "  |  " + formatFileSize);
        if (appInfoBean.getFileSize() > 209715200) {
            aVar.f354d.setVisibility(8);
            aVar.f355e.setVisibility(0);
        } else if (appInfoBean.isSelect()) {
            aVar.f354d.setImageResource(C2113R.mipmap.checkbox_checked);
            aVar.f354d.setVisibility(0);
            aVar.f355e.setVisibility(8);
        } else {
            aVar.f354d.setImageResource(C2113R.mipmap.checkbox_unchecked);
            aVar.f354d.setVisibility(0);
            aVar.f355e.setVisibility(8);
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i2) {
        return this.f349c.get(i2).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i2) {
        return this.f348b.get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f348b.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i2, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f350d.inflate(C2113R.layout.app_select_tip, viewGroup, false);
        }
        ((TextView) view.findViewById(C2113R.id.tv_lable)).setText(this.f348b.get(i2));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i2, int i3) {
        return true;
    }
}
