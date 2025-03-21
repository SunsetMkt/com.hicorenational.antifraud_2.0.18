package androidx.camera.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.Config;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface ThreadConfig {
    public static final Config.Option<Executor> OPTION_BACKGROUND_EXECUTOR = Config.Option.create("camerax.core.thread.backgroundExecutor", Executor.class);

    public interface Builder<B> {
        @NonNull
        B setBackgroundExecutor(@NonNull Executor executor);
    }

    @NonNull
    Executor getBackgroundExecutor();

    @Nullable
    Executor getBackgroundExecutor(@Nullable Executor executor);
}
