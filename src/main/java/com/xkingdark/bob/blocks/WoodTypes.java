package com.xkingdark.bob.blocks;

import com.xkingdark.bob.Main;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.WoodType;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class WoodTypes {
    public static final WoodType CHORUS;
    public static final WoodType VACANT;
    public static final WoodType VOIDING;

    static {
        CHORUS = new WoodTypeBuilder().register(Identifier.of(Main.MOD_ID, "chorus"), BlockSetTypes.CHORUS);
        VACANT = new WoodTypeBuilder().register(Identifier.of(Main.MOD_ID, "vacant"), BlockSetTypes.VACANT);
        VOIDING = new WoodTypeBuilder().register(Identifier.of(Main.MOD_ID, "voiding"), BlockSetTypes.VOIDING);
    };

    public static AbstractBlock.Settings createWoodSettings() {
        return AbstractBlock.Settings.create()
            .mapColor(MapColor.OAK_TAN)
            .instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.WOOD)
            .strength(2.0F).burnable();
    };

    public static AbstractBlock.Settings createPlanksSettings() {
        return createWoodSettings().strength(2.0F, 3.0F);
    };

    public static AbstractBlock.Settings createDoorSettings(Block planks) {
        return AbstractBlock.Settings.create()
            .mapColor(planks.getDefaultMapColor()).nonOpaque()
            .instrument(NoteBlockInstrument.BASS)
            .strength(3.0F).burnable()
            .pistonBehavior(PistonBehavior.DESTROY);
    };

    public static AbstractBlock.Settings createPressurePlateSettings(Block planks) {
        return AbstractBlock.Settings.create()
            .mapColor(planks.getDefaultMapColor())
            .solid().noCollision().pistonBehavior(PistonBehavior.DESTROY)
            .instrument(NoteBlockInstrument.BASS)
            .strength(0.5F).burnable();
    };

    public static AbstractBlock.Settings createTrapdoorSettings() {
        return AbstractBlock.Settings.create()
            .mapColor(MapColor.OAK_TAN).nonOpaque()
            .instrument(NoteBlockInstrument.BASS)
            .strength(3.0F).burnable()
            .allowsSpawning(net.minecraft.block.Blocks::never);
    };

    public static AbstractBlock.Settings createSignSettings() {
        return AbstractBlock.Settings.create()
            .mapColor(MapColor.OAK_TAN)
            .solid().noCollision()
            .instrument(NoteBlockInstrument.BASS)
            .strength(1.0F).burnable();
    };

    public static AbstractBlock.Settings createFenceSettings(Block planks) {
        return AbstractBlock.Settings.create()
            .mapColor(planks.getDefaultMapColor())
            .solid()
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F, 3.0F).burnable();
    };
};