package com.adharsh.veilbound.items;

import com.adharsh.veilbound.Veilbound;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import java.util.function.Function;

public class ModItems {

    public static final Item SNAKE_FANG = registerItem("snake_fang", Item::new, new Item.Properties());

    public static <T extends Item> T registerItem(String name, Function<Item.Properties, T> itemFactory, Item.Properties setting) {

        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Veilbound.MOD_ID, name));

        T item = itemFactory.apply(setting.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void ModItemInitializer() {
        Veilbound.LOGGER.info("Loading ModItems...");
        Veilbound.LOGGER.info("Registered: " + BuiltInRegistries.ITEM.getKey(SNAKE_FANG));
    }
}
