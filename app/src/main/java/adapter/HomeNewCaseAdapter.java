package adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.HomeNewCaseBean;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import manager.AccountManager;
import manager.NotificationHelper;
import p357j.C5845d;
import p388ui.Hicore;
import p388ui.activity.PromosWebDetActivity;
import util.C7292k1;
import util.C7337y1;

/* loaded from: classes.dex */
public class HomeNewCaseAdapter extends RecyclerView.Adapter<C0066a> {

    /* renamed from: c */
    static final int f222c = 2;

    /* renamed from: d */
    static final int f223d = 3;

    /* renamed from: e */
    static final int f224e = 4;

    /* renamed from: f */
    static final int f225f = 6;

    /* renamed from: a */
    private Context f226a;

    /* renamed from: b */
    private List<HomeNewCaseBean.RowsBean> f227b;

    /* renamed from: adapter.HomeNewCaseAdapter$a */
    class C0066a extends RecyclerView.ViewHolder {

        /* renamed from: a */
        public View f228a;

        /* renamed from: b */
        public ImageView f229b;

        /* renamed from: c */
        public TextView f230c;

        /* renamed from: d */
        public TextView f231d;

        /* renamed from: e */
        public View f232e;

        public C0066a(View view) {
            super(view);
            this.f228a = view.findViewById(C2113R.id.rl_type_topic);
            this.f229b = (ImageView) view.findViewById(C2113R.id.iv_topic_pic);
            this.f230c = (TextView) view.findViewById(C2113R.id.iv_topic_tit);
            this.f231d = (TextView) view.findViewById(C2113R.id.iv_topic_time);
            this.f232e = view.findViewById(C2113R.id.view_line);
        }
    }

    public HomeNewCaseAdapter(Context context, List<HomeNewCaseBean.RowsBean> list) {
        this.f226a = context;
        this.f227b = list;
    }

    /* renamed from: b */
    private void m245b(C0066a c0066a, int i2) {
        final HomeNewCaseBean.RowsBean rowsBean = this.f227b.get(i2);
        c0066a.f230c.setText(rowsBean.getTitle());
        String m26738a = C7337y1.m26738a(rowsBean.getReleaseTime());
        if (TextUtils.isEmpty(rowsBean.getAuthor())) {
            c0066a.f231d.setText("国家反诈中心  " + m26738a);
        } else {
            c0066a.f231d.setText(rowsBean.getAuthor() + "  " + m26738a);
        }
        c0066a.f229b.setVisibility(0);
        if (2 == rowsBean.getMterialType()) {
            C5845d.m24609a(rowsBean.getCdnCover(), c0066a.f229b);
        } else if (3 == rowsBean.getMterialType()) {
            C5845d.m24609a(rowsBean.getCdnCover(), c0066a.f229b);
        } else if (4 == rowsBean.getMterialType()) {
            c0066a.f229b.setVisibility(4);
        } else {
            C5845d.m24609a(rowsBean.getCdnCover(), c0066a.f229b);
        }
        if (TextUtils.isEmpty(rowsBean.getCdnCover())) {
            c0066a.f229b.setVisibility(4);
        }
        c0066a.itemView.setOnClickListener(new View.OnClickListener() { // from class: adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeNewCaseAdapter.this.m248a(rowsBean, view);
            }
        });
    }

    /* renamed from: a */
    public List<HomeNewCaseBean.RowsBean> m246a() {
        return this.f227b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f227b.size();
    }

    /* renamed from: a */
    public void m249a(List<HomeNewCaseBean.RowsBean> list) {
        this.f227b.clear();
        this.f227b.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public C0066a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C0066a(LayoutInflater.from(viewGroup.getContext()).inflate(C2113R.layout.item_home_new_case, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C0066a c0066a, int i2) {
        m245b(c0066a, i2);
    }

    /* renamed from: a */
    public /* synthetic */ void m248a(HomeNewCaseBean.RowsBean rowsBean, View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        Intent intent = new Intent(this.f226a, (Class<?>) PromosWebDetActivity.class);
        intent.putExtra(C7292k1.f25363P, NotificationHelper.CHANEL_NAME);
        intent.putExtra(C7292k1.f25365Q, rowsBean.getLocalFilePath() + AccountManager.getShareParam());
        intent.putExtra(C7292k1.f25371T, rowsBean.getId());
        intent.putExtra(C7292k1.f25373U, 2);
        this.f226a.startActivity(intent);
    }
}
