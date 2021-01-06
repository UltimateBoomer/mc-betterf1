package io.github.ultimateboomer.betterf1;

import net.fabricmc.api.ClientModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BetterF1 implements ClientModInitializer {
	public static final String MOD_ID = "betterf1";
	public static final String MOD_NAME = "BetterF1";

	public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

	public static HUDState state = HUDState.ALL_VISIBLE;

	@Override
	public void onInitializeClient() {
		LOGGER.debug(MOD_NAME + " initialized");
	}

	public static boolean isHidden(boolean hudHidden) {
		return hudHidden && !state.equals(HUDState.NO_HUD);
	}
}
