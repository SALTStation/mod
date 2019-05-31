package com.SaltStation.Main.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class TexturedButton extends GuiButton {

    int u = 0;
    int v = 0;
    GuiScreen gui;
    public TexturedButton(int id, int xPos, int yPos, int width, int height, GuiScreen gui ,int u, int v) {
        super(id, xPos, yPos, width, height, "");
        this.u = u;
        this.v = v;
        this.gui = gui;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partial) {
        if (this.visible)
        {
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            this.mouseDragged(mc, mouseX, mouseY);
            if (this.hovered)
            {
                gui.drawTexturedModalRect(x,y,u,v+height,width,height);
            }
            else {
                gui.drawTexturedModalRect(x,y,u,v,width,height);
            }
        }
    }

    public void changePosition(int u, int v) {
        this.u = u;
        this.v = v;
    }
}