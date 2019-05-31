package com.SaltStation.Main.Capabilities.KnowledgeCapability;

import java.util.HashMap;

public class Knowledge implements IKnowledge {

    private String currentspell;
    private HashMap<String,Boolean> KMap = new HashMap<>();



    @Override
    public String getSpell() {
        if(currentspell==null){
            return "testopesto";
        }
        else {
            return currentspell;
        }
    }

    @Override
    public void setSpell(String Spell) {
            currentspell=Spell;


    }

    @Override
    public void removeKnowledge(String rune) {
        if(KMap.containsKey(rune)){
            KMap.replace(rune,false);
        }
        else{
            KMap.put(rune,false);
        }



    }

    @Override
    public void addKnowledge(String rune) {
        if(KMap.containsKey(rune)){
            KMap.replace(rune,true);
        }
        else{
            KMap.put(rune,true);
        }


    }

    @Override
    public Boolean getKnowledge(String rune) {
        if(KMap.containsKey(rune)){
            return KMap.get(rune);
        }
        else{
            return false;
        }

    }

    @Override
    public void setKnowledge(String rune,boolean value) {
        if(KMap.containsKey(rune)){
            KMap.replace(rune,value);
        }
        else{
            KMap.put(rune,false);
        }

    }
}
