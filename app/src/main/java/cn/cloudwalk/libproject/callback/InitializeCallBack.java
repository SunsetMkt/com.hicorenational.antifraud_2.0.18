package cn.cloudwalk.libproject.callback;

/* JADX INFO: loaded from: classes.dex */
public interface InitializeCallBack {
    void onInitializeFail(Throwable th);

    void onInitializeSuccess();
}
