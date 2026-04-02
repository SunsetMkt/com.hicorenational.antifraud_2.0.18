package adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.DetailBean;
import com.hicorenational.antifraud.R;
import java.util.List;
import network.HistoryDetailInfo;

/* JADX INFO: loaded from: classes.dex */
public class ReportDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Typeface a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<HistoryDetailInfo> f1176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<List<DetailBean>> f1177d;

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f1178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f1179c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f1180d;

        public RecyclerViewHolder(View view, int i2) {
            super(view);
            this.a = i2;
            this.f1178b = (TextView) view.findViewById(R.id.group_report);
            this.f1179c = (TextView) view.findViewById(R.id.group_report_count);
            this.f1180d = view.findViewById(R.id.item_line);
        }
    }

    public ReportDetailsAdapter(Typeface typeface, Context context, List<HistoryDetailInfo> list, List<List<DetailBean>> list2) {
        this.f1175b = context;
        this.a = typeface;
        this.f1176c = list;
        this.f1177d = list2;
    }

    private void a(RecyclerViewHolder recyclerViewHolder, int i2) {
        recyclerViewHolder.f1180d.setVisibility(8);
        String title = this.f1176c.get(i2).getTitle();
        if (!TextUtils.isEmpty(title)) {
            recyclerViewHolder.f1178b.setText(title);
        }
        List<List<DetailBean>> list = this.f1177d;
        if (list == null || list.get(i2) == null) {
            recyclerViewHolder.f1179c.setText("0\u4e2a");
            return;
        }
        recyclerViewHolder.f1179c.setText(this.f1177d.get(i2).size() + "\u4e2a");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f1176c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        a((RecyclerViewHolder) viewHolder, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new RecyclerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_report_list, viewGroup, false), i2);
    }
}
