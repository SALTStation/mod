package com.SaltStation.Main.Capabilities.FatigueCapability;

import java.util.concurrent.Callable;

public class FatigueFactory implements Callable<IFatigue> {
    @Override
    public IFatigue call() throws Exception {
        return new Fatigue();
    }
}