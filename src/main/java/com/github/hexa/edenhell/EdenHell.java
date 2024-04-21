package com.github.hexa.edenhell;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EdenHell implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("voxelcache");
	public static EdenHell instance;
	public KeyBinding hotbarSwapKeybind;

	@Override
	public void onInitialize() {
		instance = this;
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		hotbarSwapKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.edenhell.swaphotbar", // The translation key of the keybinding's name
				InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
				GLFW.GLFW_KEY_LEFT_CONTROL, // The keycode of the key
				"category.edenhell" // The translation key of the keybinding's category.
		));
		LOGGER.info("Hello Fabric world!");
	}


	public static EdenHell getInstance() {
		return instance;
	}

}