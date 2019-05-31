package com.SaltStation.Main.handlers.partikel;

import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;

public enum CustomEnumParticleTypes {
    FLOWER("flower", 30, false),
    DARK_EMBER("CustomFire", 32, false);




    private final String particleName;
    private final int particleID;
    private final boolean shouldIgnoreRange;
    private final int argumentCount;
    private static final Map<Integer, CustomEnumParticleTypes> PARTICLES = Maps.<Integer, CustomEnumParticleTypes>newHashMap();
    private static final Map<String, CustomEnumParticleTypes> BY_NAME = Maps.<String, CustomEnumParticleTypes>newHashMap();

    private CustomEnumParticleTypes(String particleNameIn, int particleIDIn, boolean shouldIgnoreRangeIn, int argumentCountIn)
    {
        this.particleName = particleNameIn;
        this.particleID = particleIDIn;
        this.shouldIgnoreRange = shouldIgnoreRangeIn;
        this.argumentCount = argumentCountIn;
    }


    private CustomEnumParticleTypes(String particleNameIn, int particleIDIn, boolean shouldIgnoreRangeIn)
    {
        this(particleNameIn, particleIDIn, shouldIgnoreRangeIn, 0);
    }

    public static Set<String> getParticleNames()
    {
        return BY_NAME.keySet();
    }

    public String getParticleName()
    {
        return this.particleName;
    }

    public int getParticleID()
    {
        return this.particleID;
    }

    public int getArgumentCount()
    {
        return this.argumentCount;
    }

    public boolean getShouldIgnoreRange()
    {
        return this.shouldIgnoreRange;
    }

    /**
     * Gets the relative EnumParticleTypes by id.
     */
    @Nullable
    public static CustomEnumParticleTypes getParticleFromId(int particleId)
    {
        return PARTICLES.get(Integer.valueOf(particleId));
    }

    @Nullable
    public static CustomEnumParticleTypes getByName(String nameIn)
    {
        return BY_NAME.get(nameIn);
    }

    static
    {
        for (CustomEnumParticleTypes enumparticletypes : values())
        {
            PARTICLES.put(Integer.valueOf(enumparticletypes.getParticleID()), enumparticletypes);
            BY_NAME.put(enumparticletypes.getParticleName(), enumparticletypes);
        }
    }

}