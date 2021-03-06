package cursedflames.bountifulbaubles.common.item;

import java.util.List;

import javax.annotation.Nullable;

import cursedflames.bountifulbaubles.common.BountifulBaubles;
import cursedflames.bountifulbaubles.common.misc.Tooltips;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BBItem extends Item {
//	public BBItem(String name) {
//		this(name, null);
//	}

	public BBItem(String name, Item.Properties props) {
		super(props);
		setRegistryName(new ResourceLocation(BountifulBaubles.MODID, name));
//		setUnlocalizedName(BountifulBaubles.MODID+"."+name);
//		if (tab!=null) {
//			setCreativeTab(tab);
//		}
	}
	
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip,
			ITooltipFlag flagIn) {
		Tooltips.addTooltip(this, stack, worldIn, tooltip, flagIn);
	}
}
