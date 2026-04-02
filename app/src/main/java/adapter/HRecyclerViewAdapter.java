package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hicorenational.antifraud.R;
import util.g1;

/* JADX INFO: loaded from: classes.dex */
public class HRecyclerViewAdapter extends RecyclerView.Adapter<HImageHolder> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String[] f1117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int[] f1118g;
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f1120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1122e = R.drawable.iv_share_download;

    public class HImageHolder extends RecyclerView.ViewHolder {
        public FrameLayout a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ImageView f1123b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f1124c;

        public HImageHolder(View view) {
            super(view);
            this.a = (FrameLayout) view.findViewById(R.id.fl_share_item);
            this.f1123b = (ImageView) view.findViewById(R.id.image);
            this.f1124c = (TextView) view.findViewById(R.id.tv_name);
            if (HRecyclerViewAdapter.this.f1119b == 5) {
                HRecyclerViewAdapter.this.a(this.a);
            }
        }
    }

    public interface a {
        void a(int i2, String str);
    }

    public HRecyclerViewAdapter(Context context, int i2) {
        this.f1121d = context.getResources().getDisplayMetrics().widthPixels;
        this.a = context;
        this.f1119b = i2;
        if (this.f1119b == 5) {
            f1117f = new String[]{"\u5fae\u4fe1\u597d\u53cb", "QQ\u597d\u53cb", "\u9489\u9489", "\u590d\u5236\u94fe\u63a5"};
            f1118g = new int[]{R.drawable.iv_share_wx, R.drawable.iv_login_qq, R.drawable.iv_share_dding, R.drawable.iv_share_copy};
        } else {
            f1117f = new String[]{"\u5fae\u4fe1\u597d\u53cb", "\u670b\u53cb\u5708", "QQ\u597d\u53cb", "QQ\u7a7a\u95f4", "\u5fae\u535a", "\u9489\u9489", "\u590d\u5236\u94fe\u63a5"};
            f1118g = new int[]{R.drawable.iv_share_wx, R.drawable.iv_share_wxcicle, R.drawable.iv_login_qq, R.drawable.iv_share_qzone, R.drawable.iv_share_sina, R.drawable.iv_share_dding, R.drawable.iv_share_copy};
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return f1117f.length;
    }

    public void setOnItemClickListener(a aVar) {
        this.f1120c = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public HImageHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new HImageHolder(LayoutInflater.from(this.a).inflate(R.layout.item_hrecyclerview, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final HImageHolder hImageHolder, final int i2) {
        hImageHolder.f1124c.setText(f1117f[i2]);
        hImageHolder.f1123b.setImageResource(f1118g[i2]);
        if (this.f1119b == 1 && i2 == f1117f.length - 1) {
            hImageHolder.f1124c.setText("\u751f\u6210\u6d77\u62a5");
            hImageHolder.f1123b.setImageResource(this.f1122e);
        }
        if (this.f1120c != null) {
            hImageHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: adapter.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.a(hImageHolder, i2, view);
                }
            });
        }
    }

    public /* synthetic */ void a(HImageHolder hImageHolder, int i2, View view) {
        this.f1120c.a(hImageHolder.getLayoutPosition(), f1117f[i2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FrameLayout frameLayout) {
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.width = (this.f1121d - g1.a(this.a, 16.0f)) / f1117f.length;
        frameLayout.setLayoutParams(layoutParams);
    }
}
