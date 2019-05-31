package com.SaltStation.Main.Capabilities.KnowledgeCapability;

public interface IKnowledge {



    public String getSpell();
    public void setSpell(String Spell);
    public void removeKnowledge(String rune);
    public void addKnowledge(String rune);
    public Boolean getKnowledge(String rune);
    public void setKnowledge(String rune,boolean value);


}
