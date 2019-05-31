package com.SaltStation.Main.Gui;

import com.SaltStation.Main.Capabilities.KnowledgeCapability.IKnowledge;
import com.SaltStation.Main.Capabilities.KnowledgeCapability.KnowledgeProvider;
import com.SaltStation.Main.items.Catalyst;
import com.SaltStation.Main.misc.Reference;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiSpellSelect extends GuiScreen {

    private final int ImageHeight = 192;
    private final int ImageWidth = 192;
    private static ResourceLocation Textures = new ResourceLocation(Reference.MOD_ID + ":textures/gui/demo_background.png");
    private GuiButton button;
    private GuiButton test;


    @Override
    public void initGui() {
        buttonList.clear();
        Keyboard.enableRepeatEvents(true);

        button = new GuiButton(0, width / 2 + 2, 4 + ImageHeight, 98, 20, I18n.format("gui.done", new Object[0]));
        test = new GuiButton(1, 80, 50, 50, 20, I18n.format("test", new Object[1]));

        buttonList.add(button);
        buttonList.add(test);
        int offsetFromScreenLeft = (width - ImageWidth) / 2;

    }

    @Override
    public void updateScreen()
    {

    }

    @Override
    public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

            mc.getTextureManager().bindTexture(Textures);

        int offsetFromScreenLeft = (width - ImageWidth ) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, ImageWidth,

                ImageHeight);
        super.drawScreen(parWidth, parHeight, p_73863_3_);

    }

    @Override
    protected void mouseClickMove(int parMouseX, int parMouseY, int parLastButtonClicked, long parTimeSinceMouseClick)
    {

    }

    @Override
    protected void actionPerformed(GuiButton parButton)
    {
        if (parButton == button)
        {

            mc.displayGuiScreen((GuiScreen)null);
        }
        else if(parButton == test){
            IKnowledge knowledge = mc.player.getCapability(KnowledgeProvider.KNOWLEDGE_CAPABILITY,null);
            knowledge.setSpell("bett");
            System.out.println(knowledge.getSpell());
            if(knowledge.getKnowledge("guro")==true){
                knowledge.setSpell("bett");
            }

            


        }
    }

    @Override
    public void onGuiClosed()
    {

    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }





}