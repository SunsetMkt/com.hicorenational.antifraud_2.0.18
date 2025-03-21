package cn.jzvd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class JzvdStd extends Jzvd {

    /* renamed from: f1 */
    public static long f2784f1 = 0;

    /* renamed from: g1 */
    public static int f2785g1 = 70;

    /* renamed from: h1 */
    protected static Timer f2786h1;

    /* renamed from: A0 */
    public ImageView f2787A0;

    /* renamed from: B0 */
    public ProgressBar f2788B0;

    /* renamed from: C0 */
    public ProgressBar f2789C0;

    /* renamed from: D0 */
    public TextView f2790D0;

    /* renamed from: E0 */
    public ImageView f2791E0;

    /* renamed from: F0 */
    public ImageView f2792F0;

    /* renamed from: G0 */
    public LinearLayout f2793G0;

    /* renamed from: H0 */
    public ImageView f2794H0;

    /* renamed from: I0 */
    public TextView f2795I0;

    /* renamed from: J0 */
    public TextView f2796J0;

    /* renamed from: K0 */
    public TextView f2797K0;

    /* renamed from: L0 */
    public PopupWindow f2798L0;

    /* renamed from: M0 */
    public TextView f2799M0;

    /* renamed from: N0 */
    public LinearLayout f2800N0;

    /* renamed from: O0 */
    protected C1257b f2801O0;

    /* renamed from: P0 */
    protected Dialog f2802P0;

    /* renamed from: Q0 */
    protected ProgressBar f2803Q0;

    /* renamed from: R0 */
    protected TextView f2804R0;

    /* renamed from: S0 */
    protected TextView f2805S0;

    /* renamed from: T0 */
    protected ImageView f2806T0;

    /* renamed from: U0 */
    protected Dialog f2807U0;

    /* renamed from: V0 */
    protected ProgressBar f2808V0;

    /* renamed from: W0 */
    protected TextView f2809W0;

    /* renamed from: X0 */
    protected ImageView f2810X0;

    /* renamed from: Y0 */
    protected Dialog f2811Y0;

    /* renamed from: Z0 */
    protected ProgressBar f2812Z0;

    /* renamed from: a1 */
    protected TextView f2813a1;

    /* renamed from: b1 */
    private long f2814b1;

    /* renamed from: c1 */
    private long f2815c1;

    /* renamed from: d1 */
    private ArrayDeque<Runnable> f2816d1;

    /* renamed from: e1 */
    private BroadcastReceiver f2817e1;

    /* renamed from: cn.jzvd.JzvdStd$a */
    class C1256a extends BroadcastReceiver {
        C1256a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                JzvdStd.f2785g1 = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
                JzvdStd.this.m2507U();
                try {
                    JzvdStd.this.getContext().unregisterReceiver(JzvdStd.this.f2817e1);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: cn.jzvd.JzvdStd$b */
    public class C1257b extends TimerTask {
        public C1257b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            JzvdStd.this.m2502P();
        }
    }

    public JzvdStd(Context context) {
        super(context);
        this.f2814b1 = 0L;
        this.f2815c1 = 200L;
        this.f2816d1 = new ArrayDeque<>();
        this.f2817e1 = new C1256a();
    }

    /* renamed from: G */
    public void m2493G() {
        Timer timer = f2786h1;
        if (timer != null) {
            timer.cancel();
        }
        C1257b c1257b = this.f2801O0;
        if (c1257b != null) {
            c1257b.cancel();
        }
    }

    /* renamed from: H */
    public void m2494H() {
        int i2 = this.f2758b;
        if (i2 == 0) {
            m2512a(0, 4, 0, 4, 0, 4, 4);
            m2510X();
        } else {
            if (i2 != 1) {
                return;
            }
            m2512a(0, 4, 0, 4, 0, 4, 4);
            m2510X();
        }
    }

    /* renamed from: I */
    public void m2495I() {
        int i2 = this.f2758b;
        if (i2 == 0) {
            m2512a(4, 4, 0, 4, 4, 4, 0);
            m2510X();
        } else {
            if (i2 != 1) {
                return;
            }
            m2512a(0, 4, 0, 4, 4, 4, 0);
            m2510X();
        }
    }

    /* renamed from: J */
    public void m2496J() {
        int i2 = this.f2758b;
        if (i2 == 0) {
            m2512a(0, 4, 0, 4, 0, 4, 4);
            m2510X();
        } else {
            if (i2 != 1) {
                return;
            }
            m2512a(0, 4, 0, 4, 0, 4, 4);
            m2510X();
        }
    }

    /* renamed from: K */
    public void m2497K() {
        int i2 = this.f2758b;
        if (i2 == 0) {
            m2512a(4, 4, 4, 4, 4, 0, 4);
        } else {
            if (i2 != 1) {
                return;
            }
            m2512a(4, 4, 4, 4, 4, 0, 4);
        }
    }

    /* renamed from: L */
    public void m2498L() {
        int i2 = this.f2758b;
        if (i2 == 0) {
            m2512a(0, 0, 0, 4, 4, 4, 4);
            m2510X();
        } else {
            if (i2 != 1) {
                return;
            }
            m2512a(0, 0, 0, 4, 4, 4, 4);
            m2510X();
        }
    }

    /* renamed from: M */
    public void m2499M() {
        int i2 = this.f2758b;
        if (i2 == 0) {
            m2512a(4, 4, 4, 4, 4, 0, 4);
        } else {
            if (i2 != 1) {
                return;
            }
            m2512a(4, 4, 4, 4, 4, 0, 4);
        }
    }

    /* renamed from: N */
    public void m2500N() {
        int i2 = this.f2758b;
        if (i2 == 0) {
            m2512a(0, 0, 0, 4, 4, 4, 4);
            m2510X();
        } else {
            if (i2 != 1) {
                return;
            }
            m2512a(0, 0, 0, 4, 4, 4, 4);
            m2510X();
        }
    }

    /* renamed from: O */
    public void m2501O() {
        int i2 = this.f2758b;
        if (i2 == 0 || i2 == 1) {
            m2512a(4, 4, 4, 0, 0, 4, 4);
            m2510X();
        }
    }

    /* renamed from: P */
    public void m2502P() {
        int i2 = this.f2757a;
        if (i2 == 0 || i2 == 7 || i2 == 6) {
            return;
        }
        post(new Runnable() { // from class: cn.jzvd.s
            @Override // java.lang.Runnable
            public final void run() {
                JzvdStd.this.m2503Q();
            }
        });
    }

    /* renamed from: Q */
    public /* synthetic */ void m2503Q() {
        this.f2776t.setVisibility(4);
        this.f2775s.setVisibility(4);
        this.f2769m.setVisibility(4);
        PopupWindow popupWindow = this.f2798L0;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        if (this.f2758b != 2) {
            this.f2788B0.setVisibility(0);
        }
    }

    /* renamed from: R */
    public /* synthetic */ void m2504R() {
        if (this.f2750E || this.f2749D) {
            return;
        }
        m2506T();
    }

    /* renamed from: S */
    public void m2505S() {
        int i2 = this.f2757a;
        if (i2 == 1) {
            if (this.f2776t.getVisibility() == 0) {
                m2501O();
            }
        } else if (i2 == 4) {
            if (this.f2776t.getVisibility() == 0) {
                m2499M();
            }
        } else if (i2 == 5) {
            if (this.f2776t.getVisibility() == 0) {
                m2497K();
            }
        } else if (i2 == 6 && this.f2776t.getVisibility() == 0) {
            m2494H();
        }
    }

    /* renamed from: T */
    public void m2506T() {
        if (this.f2776t.getVisibility() != 0) {
            m2508V();
            this.f2797K0.setText(this.f2759c.m2520b().toString());
        }
        int i2 = this.f2757a;
        if (i2 == 1) {
            m2501O();
            if (this.f2776t.getVisibility() == 0) {
                return;
            }
            m2508V();
            return;
        }
        if (i2 == 4) {
            if (this.f2776t.getVisibility() == 0) {
                m2499M();
                return;
            } else {
                m2500N();
                return;
            }
        }
        if (i2 == 5) {
            if (this.f2776t.getVisibility() == 0) {
                m2497K();
            } else {
                m2498L();
            }
        }
    }

    /* renamed from: U */
    public void m2507U() {
        int i2 = f2785g1;
        if (i2 < 15) {
            this.f2794H0.setBackgroundResource(C1258R.drawable.jz_battery_level_10);
            return;
        }
        if (i2 >= 15 && i2 < 40) {
            this.f2794H0.setBackgroundResource(C1258R.drawable.jz_battery_level_30);
            return;
        }
        if (i2 >= 40 && i2 < 60) {
            this.f2794H0.setBackgroundResource(C1258R.drawable.jz_battery_level_50);
            return;
        }
        if (i2 >= 60 && i2 < 80) {
            this.f2794H0.setBackgroundResource(C1258R.drawable.jz_battery_level_70);
            return;
        }
        if (i2 >= 80 && i2 < 95) {
            this.f2794H0.setBackgroundResource(C1258R.drawable.jz_battery_level_90);
        } else {
            if (i2 < 95 || i2 > 100) {
                return;
            }
            this.f2794H0.setBackgroundResource(C1258R.drawable.jz_battery_level_100);
        }
    }

    /* renamed from: V */
    public void m2508V() {
        this.f2795I0.setText(new SimpleDateFormat("HH:mm").format(new Date()));
        if (System.currentTimeMillis() - f2784f1 <= 30000) {
            m2507U();
        } else {
            f2784f1 = System.currentTimeMillis();
            getContext().registerReceiver(this.f2817e1, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }
    }

    /* renamed from: W */
    public void m2509W() {
        m2493G();
        f2786h1 = new Timer();
        this.f2801O0 = new C1257b();
        f2786h1.schedule(this.f2801O0, 2500L);
    }

    /* renamed from: X */
    public void m2510X() {
        int i2 = this.f2757a;
        if (i2 == 4) {
            this.f2769m.setVisibility(0);
            this.f2769m.setImageResource(C1258R.drawable.jz_click_pause_selector);
            this.f2796J0.setVisibility(8);
        } else if (i2 == 7) {
            this.f2769m.setVisibility(4);
            this.f2796J0.setVisibility(8);
        } else if (i2 != 6) {
            this.f2769m.setImageResource(C1258R.drawable.jz_click_play_selector);
            this.f2796J0.setVisibility(8);
        } else {
            this.f2769m.setVisibility(0);
            this.f2769m.setImageResource(C1258R.drawable.jz_click_replay_selector);
            this.f2796J0.setVisibility(0);
        }
    }

    /* renamed from: b */
    public void m2515b(int i2) {
        ViewGroup.LayoutParams layoutParams = this.f2769m.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i2;
        ViewGroup.LayoutParams layoutParams2 = this.f2789C0.getLayoutParams();
        layoutParams2.height = i2;
        layoutParams2.width = i2;
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: e */
    public void mo2469e() {
        super.mo2469e();
        Dialog dialog = this.f2811Y0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: f */
    public void mo2470f() {
        super.mo2470f();
        Dialog dialog = this.f2802P0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: g */
    public void mo2471g() {
        super.mo2471g();
        Dialog dialog = this.f2807U0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public int getLayoutId() {
        return C1258R.layout.jz_layout_std;
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: j */
    public void mo2474j() {
        super.mo2474j();
        m2493G();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: m */
    public void mo2477m() {
        super.mo2477m();
        m2494H();
        m2493G();
        this.f2788B0.setProgress(100);
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: n */
    public void mo2478n() {
        super.mo2478n();
        m2495I();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: o */
    public void mo2479o() {
        super.mo2479o();
        m2496J();
    }

    @Override // cn.jzvd.Jzvd, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == C1258R.id.thumb) {
            C1280v c1280v = this.f2759c;
            if (c1280v == null || c1280v.f2861b.isEmpty() || this.f2759c.m2522c() == null) {
                Toast.makeText(getContext(), getResources().getString(C1258R.string.no_url), 0).show();
                return;
            }
            int i2 = this.f2757a;
            if (i2 != 0) {
                if (i2 == 6) {
                    m2506T();
                    return;
                }
                return;
            } else if (this.f2759c.m2522c().toString().startsWith("file") || this.f2759c.m2522c().toString().startsWith("/") || C1283y.m2557e(getContext()) || Jzvd.f2740u0) {
                m2444A();
                return;
            } else {
                mo2488x();
                return;
            }
        }
        if (id == C1258R.id.surface_container) {
            m2509W();
            return;
        }
        if (id == C1258R.id.back) {
            Jzvd.m2437C();
            return;
        }
        if (id == C1258R.id.back_tiny) {
            m2468d();
            return;
        }
        if (id != C1258R.id.clarity) {
            if (id == C1258R.id.retry_btn) {
                if (this.f2759c.f2861b.isEmpty() || this.f2759c.m2522c() == null) {
                    Toast.makeText(getContext(), getResources().getString(C1258R.string.no_url), 0).show();
                    return;
                }
                if (!this.f2759c.m2522c().toString().startsWith("file") && !this.f2759c.m2522c().toString().startsWith("/") && !C1283y.m2557e(getContext()) && !Jzvd.f2740u0) {
                    mo2488x();
                    return;
                } else {
                    m2446a();
                    mo2482r();
                    return;
                }
            }
            return;
        }
        final LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C1258R.layout.jz_layout_clarity, (ViewGroup) null);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: cn.jzvd.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                JzvdStd.this.m2514a(linearLayout, view2);
            }
        };
        for (int i3 = 0; i3 < this.f2759c.f2861b.size(); i3++) {
            String m2518a = this.f2759c.m2518a(i3);
            TextView textView = (TextView) View.inflate(getContext(), C1258R.layout.jz_layout_clarity_item, null);
            textView.setText(m2518a);
            textView.setTag(Integer.valueOf(i3));
            linearLayout.addView(textView, i3);
            textView.setOnClickListener(onClickListener);
            if (i3 == this.f2759c.f2860a) {
                textView.setTextColor(Color.parseColor("#fff85959"));
            }
        }
        this.f2798L0 = new PopupWindow((View) linearLayout, -2, -2, true);
        this.f2798L0.setContentView(linearLayout);
        this.f2798L0.showAsDropDown(this.f2797K0);
        linearLayout.measure(0, 0);
        this.f2798L0.update(this.f2797K0, -(this.f2797K0.getMeasuredWidth() / 3), -(this.f2797K0.getMeasuredHeight() / 3), Math.round(linearLayout.getMeasuredWidth() * 2), linearLayout.getMeasuredHeight());
    }

    @Override // cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        m2493G();
    }

    @Override // cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        m2509W();
    }

    @Override // cn.jzvd.Jzvd, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        if (id == C1258R.id.surface_container) {
            int action = motionEvent.getAction();
            if (action != 0 && action == 1) {
                m2509W();
                if (this.f2750E) {
                    long duration = getDuration();
                    long j2 = this.f2755J * 100;
                    if (duration == 0) {
                        duration = 1;
                    }
                    this.f2788B0.setProgress((int) (j2 / duration));
                }
                Runnable runnable = new Runnable() { // from class: cn.jzvd.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        JzvdStd.this.m2504R();
                    }
                };
                view.postDelayed(runnable, this.f2815c1 + 20);
                this.f2816d1.add(runnable);
                while (this.f2816d1.size() > 2) {
                    this.f2816d1.pollFirst();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f2814b1 < this.f2815c1) {
                    Iterator<Runnable> it = this.f2816d1.iterator();
                    while (it.hasNext()) {
                        view.removeCallbacks(it.next());
                    }
                    int i2 = this.f2757a;
                    if (i2 == 4 || i2 == 5) {
                        String str = "doublClick [" + hashCode() + "] ";
                        this.f2769m.performClick();
                    }
                }
                this.f2814b1 = currentTimeMillis;
            }
        } else if (id == C1258R.id.bottom_seek_progress) {
            int action2 = motionEvent.getAction();
            if (action2 == 0) {
                m2493G();
            } else if (action2 == 1) {
                m2509W();
            }
        }
        return super.onTouch(view, motionEvent);
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: p */
    public void mo2480p() {
        super.mo2480p();
        m2498L();
        m2493G();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: q */
    public void mo2481q() {
        super.mo2481q();
        m2499M();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: r */
    public void mo2482r() {
        super.mo2482r();
        m2501O();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: s */
    public void mo2483s() {
        super.mo2483s();
        m2493G();
        PopupWindow popupWindow = this.f2798L0;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void setBufferProgress(int i2) {
        super.setBufferProgress(i2);
        if (i2 != 0) {
            this.f2788B0.setSecondaryProgress(i2);
        }
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: t */
    public void mo2484t() {
        super.mo2484t();
        this.f2788B0.setProgress(0);
        this.f2788B0.setSecondaryProgress(0);
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: u */
    public void mo2485u() {
        super.mo2485u();
        this.f2771o.setImageResource(C1258R.drawable.jz_shrink);
        this.f2787A0.setVisibility(0);
        this.f2792F0.setVisibility(4);
        this.f2793G0.setVisibility(0);
        if (this.f2759c.f2861b.size() == 1) {
            this.f2797K0.setVisibility(8);
        } else {
            this.f2797K0.setText(this.f2759c.m2520b().toString());
            this.f2797K0.setVisibility(0);
        }
        m2515b((int) getResources().getDimension(C1258R.dimen.jz_start_button_w_h_fullscreen));
        m2508V();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: v */
    public void mo2486v() {
        super.mo2486v();
        this.f2771o.setImageResource(C1258R.drawable.jz_enlarge);
        this.f2787A0.setVisibility(8);
        this.f2792F0.setVisibility(4);
        m2515b((int) getResources().getDimension(C1258R.dimen.jz_start_button_w_h_normal));
        this.f2793G0.setVisibility(8);
        this.f2797K0.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: w */
    public void mo2487w() {
        super.mo2487w();
        this.f2792F0.setVisibility(0);
        m2512a(4, 4, 4, 4, 4, 4, 4);
        this.f2793G0.setVisibility(8);
        this.f2797K0.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: x */
    public void mo2488x() {
        super.mo2488x();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(getResources().getString(C1258R.string.tips_not_wifi));
        builder.setPositiveButton(getResources().getString(C1258R.string.tips_not_wifi_confirm), new DialogInterface.OnClickListener() { // from class: cn.jzvd.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                JzvdStd.this.m2513a(dialogInterface, i2);
            }
        });
        builder.setNegativeButton(getResources().getString(C1258R.string.tips_not_wifi_cancel), new DialogInterface.OnClickListener() { // from class: cn.jzvd.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                JzvdStd.this.m2516b(dialogInterface, i2);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cn.jzvd.t
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2455a(Context context) {
        super.mo2455a(context);
        this.f2793G0 = (LinearLayout) findViewById(C1258R.id.battery_time_layout);
        this.f2788B0 = (ProgressBar) findViewById(C1258R.id.bottom_progress);
        this.f2790D0 = (TextView) findViewById(C1258R.id.title);
        this.f2787A0 = (ImageView) findViewById(C1258R.id.back);
        this.f2791E0 = (ImageView) findViewById(C1258R.id.thumb);
        this.f2789C0 = (ProgressBar) findViewById(C1258R.id.loading);
        this.f2792F0 = (ImageView) findViewById(C1258R.id.back_tiny);
        this.f2794H0 = (ImageView) findViewById(C1258R.id.battery_level);
        this.f2795I0 = (TextView) findViewById(C1258R.id.video_current_time);
        this.f2796J0 = (TextView) findViewById(C1258R.id.replay_text);
        this.f2797K0 = (TextView) findViewById(C1258R.id.clarity);
        this.f2799M0 = (TextView) findViewById(C1258R.id.retry_btn);
        this.f2800N0 = (LinearLayout) findViewById(C1258R.id.retry_layout);
        this.f2791E0.setOnClickListener(this);
        this.f2787A0.setOnClickListener(this);
        this.f2792F0.setOnClickListener(this);
        this.f2797K0.setOnClickListener(this);
        this.f2799M0.setOnClickListener(this);
    }

    public JzvdStd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2814b1 = 0L;
        this.f2815c1 = 200L;
        this.f2816d1 = new ArrayDeque<>();
        this.f2817e1 = new C1256a();
    }

    /* renamed from: b */
    public /* synthetic */ void m2516b(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        m2468d();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2458a(C1280v c1280v, int i2, Class cls) {
        super.mo2458a(c1280v, i2, cls);
        this.f2790D0.setText(c1280v.f2862c);
        setScreen(i2);
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2453a(int i2, long j2) {
        super.mo2453a(i2, j2);
        this.f2769m.setVisibility(4);
        this.f2796J0.setVisibility(8);
        this.f2800N0.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2459a(C1280v c1280v, long j2) {
        super.mo2459a(c1280v, j2);
        this.f2790D0.setText(c1280v.f2862c);
        this.f2769m.setVisibility(4);
        this.f2796J0.setVisibility(8);
        this.f2800N0.setVisibility(8);
    }

    /* renamed from: a */
    public /* synthetic */ void m2514a(LinearLayout linearLayout, View view) {
        mo2453a(((Integer) view.getTag()).intValue(), getCurrentPositionWhenPlaying());
        this.f2797K0.setText(this.f2759c.m2520b().toString());
        for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
            if (i2 == this.f2759c.f2860a) {
                ((TextView) linearLayout.getChildAt(i2)).setTextColor(Color.parseColor("#fff85959"));
            } else {
                ((TextView) linearLayout.getChildAt(i2)).setTextColor(Color.parseColor("#ffffff"));
            }
        }
        PopupWindow popupWindow = this.f2798L0;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m2513a(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        m2444A();
        Jzvd.f2740u0 = true;
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2454a(int i2, long j2, long j3) {
        super.mo2454a(i2, j2, j3);
        if (i2 != 0) {
            this.f2788B0.setProgress(i2);
        }
    }

    /* renamed from: a */
    public void m2512a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f2775s.setVisibility(i2);
        this.f2776t.setVisibility(i3);
        this.f2769m.setVisibility(i4);
        this.f2789C0.setVisibility(i5);
        this.f2791E0.setVisibility(i6);
        this.f2788B0.setVisibility(i7);
        this.f2800N0.setVisibility(i8);
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2449a(float f2, String str, long j2, String str2, long j3) {
        super.mo2449a(f2, str, j2, str2, j3);
        if (this.f2802P0 == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(C1258R.layout.jz_dialog_progress, (ViewGroup) null);
            this.f2803Q0 = (ProgressBar) inflate.findViewById(C1258R.id.duration_progressbar);
            this.f2804R0 = (TextView) inflate.findViewById(C1258R.id.tv_current);
            this.f2805S0 = (TextView) inflate.findViewById(C1258R.id.tv_duration);
            this.f2806T0 = (ImageView) inflate.findViewById(C1258R.id.duration_image_tip);
            this.f2802P0 = m2511a(inflate);
        }
        if (!this.f2802P0.isShowing()) {
            this.f2802P0.show();
        }
        this.f2804R0.setText(str);
        this.f2805S0.setText(" / " + str2);
        this.f2803Q0.setProgress(j3 <= 0 ? 0 : (int) ((j2 * 100) / j3));
        if (f2 > 0.0f) {
            this.f2806T0.setBackgroundResource(C1258R.drawable.jz_forward_icon);
        } else {
            this.f2806T0.setBackgroundResource(C1258R.drawable.jz_backward_icon);
        }
        m2505S();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2448a(float f2, int i2) {
        super.mo2448a(f2, i2);
        if (this.f2807U0 == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(C1258R.layout.jz_dialog_volume, (ViewGroup) null);
            this.f2810X0 = (ImageView) inflate.findViewById(C1258R.id.volume_image_tip);
            this.f2809W0 = (TextView) inflate.findViewById(C1258R.id.tv_volume);
            this.f2808V0 = (ProgressBar) inflate.findViewById(C1258R.id.volume_progressbar);
            this.f2807U0 = m2511a(inflate);
        }
        if (!this.f2807U0.isShowing()) {
            this.f2807U0.show();
        }
        if (i2 <= 0) {
            this.f2810X0.setBackgroundResource(C1258R.drawable.jz_close_volume);
        } else {
            this.f2810X0.setBackgroundResource(C1258R.drawable.jz_add_volume);
        }
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.f2809W0.setText(i2 + "%");
        this.f2808V0.setProgress(i2);
        m2505S();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2450a(int i2) {
        super.mo2450a(i2);
        if (this.f2811Y0 == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(C1258R.layout.jz_dialog_brightness, (ViewGroup) null);
            this.f2813a1 = (TextView) inflate.findViewById(C1258R.id.tv_brightness);
            this.f2812Z0 = (ProgressBar) inflate.findViewById(C1258R.id.brightness_progressbar);
            this.f2811Y0 = m2511a(inflate);
        }
        if (!this.f2811Y0.isShowing()) {
            this.f2811Y0.show();
        }
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.f2813a1.setText(i2 + "%");
        this.f2812Z0.setProgress(i2);
        m2505S();
    }

    /* renamed from: a */
    public Dialog m2511a(View view) {
        Dialog dialog = new Dialog(getContext(), C1258R.style.jz_style_dialog_progress);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.addFlags(8);
        window.addFlags(32);
        window.addFlags(16);
        window.setLayout(-2, -2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        window.setAttributes(attributes);
        return dialog;
    }
}
