package com.xkingdark.bob.blocks.crops;

import com.xkingdark.bob.items.Items;
import net.minecraft.item.Item;

public class GrapeBushBlock extends BushBlock {
    public GrapeBushBlock(Settings settings) {
        super(settings);
    }

    @Override
    public Item getDrop() {
        return Items.GRAPES;
    }
}