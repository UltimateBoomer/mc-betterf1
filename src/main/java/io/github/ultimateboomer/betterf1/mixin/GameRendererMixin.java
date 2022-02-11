package io.github.ultimateboomer.betterf1.mixin;

import io.github.ultimateboomer.betterf1.BetterF1;
import io.github.ultimateboomer.betterf1.HUDState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Shadow
    @Final
    private MinecraftClient client;

    @Shadow
    private void renderHand(MatrixStack matrices, Camera camera, float tickDelta) {};

    // Doing it this way is for Optifine compatibility
    @Inject(method = "renderWorld", at = @At("HEAD"))
    private void onRenderHand1(CallbackInfo ci) {
        if (BetterF1.state.equals(HUDState.NO_HUD)) {
            client.options.hudHidden = false;
        }
    }

    @Inject(method = "renderWorld", at = @At("TAIL"))
    private void onRenderHand2(CallbackInfo ci) {
        if (BetterF1.state.equals(HUDState.NO_HUD)) {
            client.options.hudHidden = true;
        }
    }
}
