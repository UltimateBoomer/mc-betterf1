package io.github.ultimateboomer.betterf1.mixin;

import io.github.ultimateboomer.betterf1.BetterF1;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.toast.ToastManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ToastManager.class)
public class ToastManagerMixin {
    /**
     * @reason Override vanilla F1 behavior
     */
    @Redirect(method = "draw", at = @At(value = "FIELD",
            target = "Lnet/minecraft/client/options/GameOptions;hudHidden:Z"))
    private boolean onDraw(GameOptions options) {
        return BetterF1.isHidden(options.hudHidden);
    }
}
