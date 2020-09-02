package com.example.ipcoumpos;

import org.jetbrains.annotations.NotNull;

import kotlin.Metadata;


@Metadata(
        mv = {1, 1, 16},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"},
        d2 = {"Lcom/loginanimation/YetStates;", "", "()V", "STATE_FOCUS", "", "getSTATE_FOCUS", "()[I", "STATE_INITIAL", "getSTATE_INITIAL", "STATE_LOOKING", "getSTATE_LOOKING", "STATE_NEUTRAL", "getSTATE_NEUTRAL", "STATE_SMILE", "getSTATE_SMILE", "app_debug"}
)
public final class YetStates {
    @NotNull
    private static final int[] STATE_INITIAL;
    @NotNull
    private static final int[] STATE_LOOKING;
    @NotNull
    private static final int[] STATE_FOCUS;
    @NotNull
    private static final int[] STATE_SMILE;
    @NotNull
    private static final int[] STATE_NEUTRAL;
    public static final YetStates INSTANCE;

    @NotNull
    public final int[] getSTATE_INITIAL() {
        return STATE_INITIAL;
    }

    @NotNull
    public final int[] getSTATE_LOOKING() {
        return STATE_LOOKING;
    }

    @NotNull
    public final int[] getSTATE_FOCUS() {
        return STATE_FOCUS;
    }

    @NotNull
    public final int[] getSTATE_SMILE() {
        return STATE_SMILE;
    }

    @NotNull
    public final int[] getSTATE_NEUTRAL() {
        return STATE_NEUTRAL;
    }

    private YetStates() {
    }

    static {
        YetStates var0 = new YetStates();
        INSTANCE = var0;
        STATE_INITIAL = new int[]{300332, -300024, -300215, -300149, -300238};
        STATE_LOOKING = new int[]{-300332, 300024, -300215, -300149, -300238};
        STATE_FOCUS = new int[]{-300332, -300024, 300215, -300149, -300238};
        STATE_SMILE = new int[]{-300332, -300024, -300215, -300149, 300238};
        STATE_NEUTRAL = new int[]{-300332, 300024, -300215, -300149, -300238};
    }
}
