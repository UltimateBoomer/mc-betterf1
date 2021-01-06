package io.github.ultimateboomer.betterf1.mixin;

import io.github.ultimateboomer.betterf1.BetterF1;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.options.GameOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    /**
     * @reason Override vanilla F1 behavior
     */
    @Redirect(method = "render", at = @At(value = "FIELD",
            target = "Lnet/minecraft/client/options/GameOptions;hudHidden:Z"))
    private boolean onRender(GameOptions options) {
        return BetterF1.isHidden(options.hudHidden);
    }
}
