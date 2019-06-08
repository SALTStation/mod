package com.SaltStation.Main.Capabilities.KnowledgeCapability;

import jdk.internal.dynalink.linker.LinkerServices;

import java.util.concurrent.Callable;

public class KnowledgeFactory implements Callable<IKnowledge> {
    @Override
    public IKnowledge call() throws Exception {
        return new Knowledge();
    }
}
