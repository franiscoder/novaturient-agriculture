package io.github.franiscoder.novaturient.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * An item that's only used for rendering kludges. YOU SHOULD NOT HAVE THIS ITEM!!!
 */
public class YouShouldNotHaveThisItem extends Item {
    public YouShouldNotHaveThisItem() {
        super(new Item.Settings());
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        stack.setCount(0);
    }
}
