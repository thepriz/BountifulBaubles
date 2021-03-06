package cursedflames.bountifulbaubles.common.integration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cursedflames.bountifulbaubles.common.BountifulBaubles;
import cursedflames.bountifulbaubles.common.effect.EffectFlight;
import cursedflames.bountifulbaubles.common.item.ModItems;
import cursedflames.bountifulbaubles.common.recipe.anvil.AnvilCrafting;
import cursedflames.bountifulbaubles.common.recipe.anvil.AnvilRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class JeiIntegration implements IModPlugin {
	private static final ResourceLocation uid = new ResourceLocation(BountifulBaubles.MODID, "jei_plugin");
	
	@Override
	public ResourceLocation getPluginUid() {
		return uid;
	}
	
	@Override
	public void registerRecipes(IRecipeRegistration r) {
		
		List<Object> anvilRecipes = new ArrayList<>();
		for (AnvilRecipe recipe : AnvilCrafting.recipes) {
			// TODO stop using only the first valid left item
			anvilRecipes.add(r.getVanillaRecipeFactory().createAnvilRecipe(
					recipe.left.getMatchingStacks()[0],
					Arrays.asList(recipe.right.getMatchingStacks()),
					Arrays.asList(recipe.result)));
		}
		// TODO figure out how to reorder recipes so ours show first?
		r.addRecipes(anvilRecipes, VanillaRecipeCategoryUid.ANVIL);
		// TODO add repair recipes?
		
		// for some reason some recipes don't show automatically, so we do this instead
		List<Object> brewingRecipes = new ArrayList<>();
		ItemStack potion = new ItemStack(Items.POTION);
		PotionUtils.addPotionToItemStack(potion, Potions.AWKWARD);
		ItemStack potion2 = new ItemStack(Items.POTION);
		PotionUtils.addPotionToItemStack(potion2, EffectFlight.flightPotion);
		brewingRecipes.add(r.getVanillaRecipeFactory()
				.createBrewingRecipe(Arrays.asList(new ItemStack(ModItems.shulker_heart)), potion, potion2));
		r.addRecipes(brewingRecipes, VanillaRecipeCategoryUid.BREWING);
	}
}
