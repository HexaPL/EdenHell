package com.github.hexa.edenhell.mixin;

import com.github.hexa.edenhell.EdenHell;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Inject(method = "handleInputEvents", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/player/PlayerInventory;selectedSlot:I"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void test(CallbackInfo ci, int i) {
        if (EdenHell.getInstance().hotbarSwapKeybind.wasPressed()) {
            PlayerEntity player = MinecraftClient.getInstance().player;
            int hotbarSlot = i + 36;
            int inventorySlot = hotbarSlot - 9;
            MinecraftClient.getInstance().interactionManager.clickSlot(player.playerScreenHandler.syncId, inventorySlot, i, SlotActionType.SWAP, player);
        }
    }

}
