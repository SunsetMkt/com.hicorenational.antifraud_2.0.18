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
import com.hicorenational.antifraud.R;
import java.util.List;
import manager.AccountManager;
import manager.NotificationHelper;
import ui.Hicore;
import ui.activity.PromosWebDetActivity;
import util.g2;
import util.p1;

/* JADX INFO: loaded from: classes.dex */
public class HomeNewCaseAdapter extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f1129c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f1130d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f1131e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f1132f = 6;
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<HomeNewCaseBean.RowsBean> f1133b;

    class a extends RecyclerView.ViewHolder {
        public View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ImageView f1134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f1135c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TextView f1136d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f1137e;

        public a(View view) {
            super(view);
            this.a = view.findViewById(R.id.rl_type_topic);
            this.f1134b = (ImageView) view.findViewById(R.id.iv_topic_pic);
            this.f1135c = (TextView) view.findViewById(R.id.iv_topic_tit);
            this.f1136d = (TextView) view.findViewById(R.id.iv_topic_time);
            this.f1137e = view.findViewById(R.id.view_line);
        }
    }

    public HomeNewCaseAdapter(Context context, List<HomeNewCaseBean.RowsBean> list) {
        this.a = context;
        this.f1133b = list;
    }

    private void b(a aVar, int i2) {
        final HomeNewCaseBean.RowsBean rowsBean = this.f1133b.get(i2);
        aVar.f1135c.setText(rowsBean.getTitle());
        String strA = g2.a(rowsBean.getReleaseTime());
        if (TextUtils.isEmpty(rowsBean.getAuthor())) {
            aVar.f1136d.setText("\u56fd\u5bb6\u53cd\u8bc8\u4e2d\u5fc3  " + strA);
        } else {
            aVar.f1136d.setText(rowsBean.getAuthor() + "  " + strA);
        }
        aVar.f1134b.setVisibility(0);
        if (2 == rowsBean.getMterialType() || 3 == rowsBean.getMterialType() || 4 != rowsBean.getMterialType()) {
            k.d.a(rowsBean.getCdnCover(), aVar.f1134b);
        } else {
            aVar.f1134b.setVisibility(4);
        }
        if (TextUtils.isEmpty(rowsBean.getCdnCover())) {
            aVar.f1134b.setVisibility(4);
        }
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a(rowsBean, view);
            }
        });
    }

    public List<HomeNewCaseBean.RowsBean> a() {
        return this.f1133b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f1133b.size();
    }

    public void a(List<HomeNewCaseBean.RowsBean> list) {
        this.f1133b.clear();
        this.f1133b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home_new_case, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i2) {
        b(aVar, i2);
    }

    public /* synthetic */ void a(HomeNewCaseBean.RowsBean rowsBean, View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        Intent intent = new Intent(this.a, (Class<?>) PromosWebDetActivity.class);
        intent.putExtra(p1.P, NotificationHelper.CHANEL_NAME);
        intent.putExtra(p1.Q, rowsBean.getLocalFilePath() + AccountManager.getShareParam());
        intent.putExtra(p1.T, rowsBean.getId());
        intent.putExtra(p1.U, 2);
        this.a.startActivity(intent);
    }
}
