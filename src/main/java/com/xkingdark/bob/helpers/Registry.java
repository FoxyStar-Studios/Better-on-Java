package com.xkingdark.bob.helpers;

public class Registry {
    /*public static ItemGroup registerItemGroup(Text displayName, ItemStack icon, ItemStack[] items, Identifier identifier) {
        RegistryKey<ItemGroup> groupKey = RegistryKey.of(RegistryKeys.ITEM_GROUP, identifier);
        ItemGroup itemGroup = FabricItemGroup.builder()
                .icon(() -> icon)
                .displayName(displayName)
                .entries((displayContext, entries) -> {
                    for (ItemStack itemStack : items) {
                        entries.add(itemStack);
                    };
                })
                .build();

        net.minecraft.registry.Registry.register(Registries.ITEM_GROUP, identifier, itemGroup);
        return itemGroup;
    }

    public static Item registerItem(Item item, Identifier identifier) {
        return net.minecraft.registry.Registry.register(Registries.ITEM, identifier, item);
    }

    public static Block registerBlock(Block block, RegistryKey<Block> key, boolean shouldRegisterItem) {
        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, key.getValue());
            Item.Settings settings = new Item.Settings().useBlockPrefixedTranslationKey().registryKey(itemKey);

            BlockItem blockItem = new BlockItem(block, settings);
            net.minecraft.registry.Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return net.minecraft.registry.Registry.register(Registries.BLOCK, key, block);
    }

    public static void initialize() {
        Identifier WaystoneIdentifier = Identifier.of(Main.MOD_ID, "waystone");
        ItemStack WaystoneItem = Registry.registerBlock(new WaystoneBlock(
                AbstractBlock.Settings.create()
                        .registryKey(RegistryKey.of(RegistryKeys.BLOCK, WaystoneIdentifier))
                        .hardness(2.52f)
                        .requiresTool()
                        .nonOpaque()
        ), WaystoneIdentifier, true).asItem().getDefaultStack();

        Identifier CorstiniteHelmetIdentifier = Identifier.of(Main.MOD_ID, "corstinite_helmet");
        Item CorstiniteHelmet = Registry.registerItem(new ArmorItem(
                ArmorMaterials.CORSTINITE,
                EquipmentType.HELMET,
                new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, CorstiniteHelmetIdentifier))
        ), CorstiniteHelmetIdentifier);


        ItemStack[] itemStacks = { WaystoneItem, CorstiniteHelmet.getDefaultStack() };
        Registry.registerItemGroup(
                Text.translatable("itemGroup.better_on_bedrock"),
                WaystoneItem, itemStacks, Identifier.of(Main.MOD_ID, "better_on_bedrock"));
    }*/
}