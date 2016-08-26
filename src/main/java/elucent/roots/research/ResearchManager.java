package elucent.roots.research;

import elucent.roots.RegistryManager;
import elucent.roots.component.ComponentManager;
import elucent.roots.ritual.RitualManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class ResearchManager {
	public static ArrayList<ResearchGroup> globalResearches = new ArrayList<ResearchGroup>();
	
	public static void init(){
		globalResearches.add(new ResearchGroup("nature","Natural Arts")
							 .addResearch(new ResearchBase("barkharvesting",new ItemStack(RegistryManager.druidKnife))
									 					   .addPage(new ResearchPage()
									                    		   	.addCraftingRecipe(null, new ItemStack(Blocks.SAPLING), new ItemStack(Blocks.SAPLING), new ItemStack(Blocks.SAPLING), new ItemStack(Blocks.PLANKS), new ItemStack(Blocks.SAPLING), new ItemStack(Items.STICK), new ItemStack(Blocks.SAPLING), null, new ItemStack(RegistryManager.druidKnife))
									 							    )
									 			 			)
							 .addResearch(new ResearchBase("magicalmaterials",new ItemStack(RegistryManager.oldRoot))
				 					   .addPage(new ResearchPage()
				 							    )
				 					    .addPage(new ResearchPage()
				 					    		.addDisplayItem(new ItemStack(RegistryManager.oldRoot))
				 					    		)
				 					    .addPage(new ResearchPage()
				 					    		.addDisplayItem(new ItemStack(RegistryManager.verdantSprig))
				 					    		)
				 					    .addPage(new ResearchPage()
				 					    		.addDisplayItem(new ItemStack(RegistryManager.infernalStem))
				 					    		)
				 					    .addPage(new ResearchPage()
				 					    		.addDisplayItem(new ItemStack(RegistryManager.dragonsEye))
				 					    		)
				 			 			)
							 .addResearch(new ResearchBase("grassseeds",new ItemStack(RegistryManager.growthSalve))
				 					   .addPage(new ResearchPage()
				                    		   	.addCraftingRecipe(new ItemStack(RegistryManager.pestle), new ItemStack(Blocks.TALLGRASS,1,1), null, new ItemStack(Items.WHEAT_SEEDS), new ItemStack(Items.REDSTONE), null, null, null, null, new ItemStack(RegistryManager.growthSalve,4))
				 							    )
				 			 			)
							 .addResearch(new ResearchBase("stew", new ItemStack(RegistryManager.rootyStew))
									 	.addPage(new ResearchPage()
									 			.addCraftingRecipe(new ItemStack(Items.BOWL), new ItemStack(Items.WHEAT), null, new ItemStack(RegistryManager.oldRoot), null, null, null, null, null, new ItemStack(RegistryManager.rootyStew))
									 			)
									 	)
							 .addResearch(new ResearchBase("poultice", new ItemStack(RegistryManager.healingPoultice))
									 	.addPage(new ResearchPage()
									 			.addCraftingRecipe(new ItemStack(RegistryManager.pestle), new ItemStack(Items.DYE,1,1), null, new ItemStack(RegistryManager.verdantSprig), new ItemStack(Items.PAPER), null, null, null, null, new ItemStack(RegistryManager.healingPoultice,2))
									 			)
									 	)
				);
		globalResearches.add(new ResearchGroup("spells","Spellcraft")
							 .addResearch(new ResearchBase("mortar",new ItemStack(RegistryManager.mortar))
									                       .addPage(new ResearchPage()	
									                    		   	.addCraftingRecipe(new ItemStack(Blocks.STONE), null, new ItemStack(Blocks.STONE), new ItemStack(Blocks.STONE), null, new ItemStack(Blocks.STONE), null, new ItemStack(Blocks.STONE), null, new ItemStack(RegistryManager.mortar))
									                    		   	)
									                       .addPage(new ResearchPage()	
									                    		   	.addCraftingRecipe(new ItemStack(Blocks.STONE,1,3), null, null, null, new ItemStack(Blocks.STONE,1,3), new ItemStack(Blocks.STONE,1,3), null, new ItemStack(Blocks.STONE,1,3), new ItemStack(Blocks.STONE,1,3), new ItemStack(RegistryManager.pestle))
									                    		   	)
									                       .addPage(new ResearchPage()
									                    		   	)
									                       )
							 .addResearch(new ResearchBase("imbuer",new ItemStack(RegistryManager.imbuer))
				                       .addPage(new ResearchPage()	
				                    		    .addCraftingRecipe(null, null, null, new ItemStack(Items.STICK), null, new ItemStack(Items.STICK), new ItemStack(Blocks.LOG), new ItemStack(Blocks.STONEBRICK,1,3), new ItemStack(Blocks.LOG), new ItemStack(RegistryManager.imbuer))
				                    		   	)
				                       .addPage(new ResearchPage()
		                    		   	)
				                       )
							 .addResearch(new ResearchBase("modifiers",new ItemStack(Items.GLOWSTONE_DUST))
				                       .addPage(new ResearchPage()	
				                    		   	)
				                       .addPage(new ResearchPage()
				                    		    )
				                       )
							 .addResearch(new ResearchBase("mana",new ItemStack(RegistryManager.manaResearchIcon))
									   .addPage(new ResearchPage()
											    )
									   )
							 .addResearch(new ResearchBase("poppy",new ItemStack(Blocks.RED_FLOWER,1,0))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("poppy"))
				                       )
				                  )
							 .addResearch(new ResearchBase("blueorchid",new ItemStack(Blocks.RED_FLOWER,1,1))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("blueorchid"))
				                    		    )
				                       )
							 .addResearch(new ResearchBase("allium",new ItemStack(Blocks.RED_FLOWER,1,2))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("allium"))
				                    		    )
				                       )
							 .addResearch(new ResearchBase("azurebluet",new ItemStack(Blocks.RED_FLOWER,1,3))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("azurebluet"))
				                    		   	)
				                       )
							 .addResearch(new ResearchBase("redtulip",new ItemStack(Blocks.RED_FLOWER,1,4))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("redtulip"))
				                    		   	)
				                       )
							 .addResearch(new ResearchBase("orangetulip",new ItemStack(Blocks.RED_FLOWER,1,5))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("orangetulip"))
				                    		   	)
				                       )
							 .addResearch(new ResearchBase("whitetulip",new ItemStack(Blocks.RED_FLOWER,1,6))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("whitetulip"))
				                    		   	)
				                       )
							 .addResearch(new ResearchBase("pinktulip",new ItemStack(Blocks.RED_FLOWER,1,7))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("pinktulip"))
				                    		   	)
				                       )
							 .addResearch(new ResearchBase("oxeyedaisy",new ItemStack(Blocks.RED_FLOWER,1,8))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("oxeyedaisy"))
				                    		   	)
				                       )
							 .addResearch(new ResearchBase("dandelion",new ItemStack(Blocks.YELLOW_FLOWER))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("dandelion"))
				                    		   	)
				                       )
							 .addResearch(new ResearchBase("sunflower",new ItemStack(Blocks.DOUBLE_PLANT,1,0))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("sunflower"))
				                    		   	)
				                       )
							 .addResearch(new ResearchBase("lilac",new ItemStack(Blocks.DOUBLE_PLANT,1,1))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("lilac"))
				                    		   	)
				                       )
							 .addResearch(new ResearchBase("rosebush",new ItemStack(Blocks.DOUBLE_PLANT,1,4))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("rosebush"))
				                    		   	)
				                       )
							 .addResearch(new ResearchBase("peony",new ItemStack(Blocks.DOUBLE_PLANT,1,5))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("peony"))
				                    		   	)
				                       )
							 .addResearch(new ResearchBase("apple",new ItemStack(Items.APPLE))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("apple"))
				                    		   	)
				                       )
							 .addResearch(new ResearchBase("lilypad",new ItemStack(Blocks.WATERLILY))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("lilypad"))
				                    		   	)
				                       )
							 .addResearch(new ResearchBase("poisonouspotato",new ItemStack(Items.POISONOUS_POTATO))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("poisonouspotato"))
				                    		   	)
				                       )
							 .addResearch(new ResearchBase("netherwart",new ItemStack(Items.NETHER_WART))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("netherwart"))
				                    		   	)
				                       )
							 .addResearch(new ResearchBase("chorus",new ItemStack(Items.CHORUS_FRUIT))
				                       .addPage(new ResearchPage()
				                    		    .addMortarRecipe(ComponentManager.getRecipe("chorus"))
				                    		   	)
				                       )
							 .addResearch(new ResearchBase("cobweb", new ItemStack(Blocks.WEB))
							         .addPage(new ResearchPage()
											 .addDisplayItem(new ItemStack(Blocks.WEB))
											 .addMortarRecipe(ComponentManager.getRecipe("cobweb"))
									 )
							 )
							 .addResearch(new ResearchBase("charms", new ItemStack(RegistryManager.itemCharmRestoration))
							 		 .addPage(new ResearchPage()
									 		  .addDisplayItem(new ItemStack(RegistryManager.itemCharmRestoration))
									 		  .addMortarRecipe(ComponentManager.getRecipe("restoration"))
									 )
									 .addPage(new ResearchPage()
											 .addDisplayItem(new ItemStack(RegistryManager.itemCharmEvocation))
											 .addMortarRecipe(ComponentManager.getRecipe("evocation"))
									 )
									 .addPage(new ResearchPage()
											 .addDisplayItem(new ItemStack(RegistryManager.itemCharmConjuration))
											 .addMortarRecipe(ComponentManager.getRecipe("conjuration"))
									 )
									 .addPage(new ResearchPage()
											 .addDisplayItem(new ItemStack(RegistryManager.itemCharmIllusion))
											 .addMortarRecipe(ComponentManager.getRecipe("illusion"))
									 )
							 )

        );
		globalResearches.add(new ResearchGroup("ritual","Rituals")
				 .addResearch(new ResearchBase("ritual",new ItemStack(RegistryManager.altar))
						   .addPage(new ResearchPage()
								    .addCraftingRecipe(new ItemStack(RegistryManager.verdantSprig), new ItemStack(Blocks.RED_FLOWER), new ItemStack(RegistryManager.verdantSprig), new ItemStack(Blocks.STONE), new ItemStack(Blocks.GOLD_BLOCK), new ItemStack(Blocks.STONE), null, new ItemStack(Blocks.STONEBRICK,1,3), null, new ItemStack(RegistryManager.altar))
	                    		    )
						   .addPage(new ResearchPage()
								    .addCraftingRecipe(new ItemStack(Items.IRON_INGOT), new ItemStack(Items.STRING), new ItemStack(Items.IRON_INGOT), new ItemStack(Items.IRON_INGOT), new ItemStack(Items.CAULDRON), new ItemStack(Items.IRON_INGOT), new ItemStack(Items.IRON_INGOT), null, new ItemStack(Items.IRON_INGOT), new ItemStack(RegistryManager.brazier))
	                    		    )
						   .addPage(new ResearchPage()
								    )
	                       )
				 .addResearch(new ResearchBase("livingtools",new ItemStack(RegistryManager.livingSword))
						   .addPage(new ResearchPage()
								    )
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("livingPickaxeCrafting"))
								    )
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("livingAxeCrafting"))
								    )
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("livingShovelCrafting"))
								    )
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("livingSwordCrafting"))
								    )
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("livingHoeCrafting"))
								    )
						 )
				 .addResearch(new ResearchBase("standingstones",new ItemStack(RegistryManager.standingStoneT1))
						   .addPage(new ResearchPage()
								    .addCraftingRecipe(new ItemStack(Blocks.STONE), new ItemStack(Blocks.STONEBRICK), new ItemStack(Blocks.STONE), new ItemStack(Blocks.STONEBRICK), new ItemStack(Blocks.LAPIS_BLOCK), new ItemStack(Blocks.STONEBRICK), new ItemStack(Blocks.STONE), new ItemStack(Blocks.STONEBRICK,1), new ItemStack(Blocks.STONE), new ItemStack(RegistryManager.standingStoneT1))
	                    		    )
	                       )
				 .addResearch(new ResearchBase("animalsummoning",new ItemStack(Items.PORKCHOP))
						   .addPage(new ResearchPage()
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("pigSummoning"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("cowSummoning"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("sheepSummoning"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("chickenSummoning"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("rabbitSummoning"))
	                    		    )
	                       )
				 .addResearch(new ResearchBase("crystalstaff",new ItemStack(RegistryManager.crystalStaff))
						   .addPage(new ResearchPage()
								    .addDisplayItem(new ItemStack(RegistryManager.crystalStaff))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("staffCrafting"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("imbuer"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    )
	                       )
				 .addResearch(new ResearchBase("rainrituals",new ItemStack(Items.WATER_BUCKET))
						   .addPage(new ResearchPage()
								    )
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("causerain"))
								    )
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("banishrain"))
								    )
	                       )
				 .addResearch(new ResearchBase("standingstones2",new ItemStack(RegistryManager.standingStoneT2))
						   .addPage(new ResearchPage()
								    .addCraftingRecipe(new ItemStack(Blocks.STONE), new ItemStack(Items.NETHERBRICK), new ItemStack(Blocks.STONE), new ItemStack(Items.NETHERBRICK), new ItemStack(Items.DIAMOND), new ItemStack(Items.NETHERBRICK), new ItemStack(Blocks.STONE), new ItemStack(Items.NETHERBRICK,1), new ItemStack(Blocks.STONE), new ItemStack(RegistryManager.standingStoneT2))
	                    		    )
	                       )
				 .addResearch(new ResearchBase("monstersummoning",new ItemStack(Items.ROTTEN_FLESH))
						   .addPage(new ResearchPage()
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("zombieSummoning"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("skeletonSummoning"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("spiderSummoning"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("creeperSummoning"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("caveSpiderSummoning"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("slimeSummoning"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("endermanSummoning"))
	                    		    )
	                       )
				 .addResearch(new ResearchBase("sylvanarmor",new ItemStack(RegistryManager.druidRobesHead))
						   .addPage(new ResearchPage()
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("sylvanHoodCrafting"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("sylvanChestCrafting"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("sylvanLegsCrafting"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("sylvanBootsCrafting"))
	                    		    )
	                       )
				 .addResearch(new ResearchBase("wildwoodarmor",new ItemStack(RegistryManager.druidArmorHead))
						   .addPage(new ResearchPage()
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("wildwoodHeadCrafting"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("wildwoodChestCrafting"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("wildwoodLegsCrafting"))
	                    		    )
						   .addPage(new ResearchPage()
	                    		    .addAltarRecipe(RitualManager.getRitualFromName("wildwoodBootsCrafting"))
	                    		    )
	                       )
				 .addResearch(new ResearchBase("poweredstones",new ItemStack(RegistryManager.standingStoneAccelerator))
						   .addPage(new ResearchPage()
								    )					
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("acceleratorStoneCrafting"))
								    )
						   .addPage(new ResearchPage()
								    .addDisplayItem(new ItemStack(RegistryManager.standingStoneAccelerator))
								    )
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("entanglerStoneCrafting"))
								    )
						   .addPage(new ResearchPage()
								    .addDisplayItem(new ItemStack(RegistryManager.standingStoneEntangler))
								    )
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("growerStoneCrafting"))
								    )
						   .addPage(new ResearchPage()
								    .addDisplayItem(new ItemStack(RegistryManager.standingStoneGrower))
								    )
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("healerStoneCrafting"))
								    )
						   .addPage(new ResearchPage()
								    .addDisplayItem(new ItemStack(RegistryManager.standingStoneHealer))
								    )
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("igniterStoneCrafting"))
								    )
						   .addPage(new ResearchPage()
								    .addDisplayItem(new ItemStack(RegistryManager.standingStoneIgniter))
								    )
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("repulsorStoneCrafting"))
								    )
						   .addPage(new ResearchPage()
								    .addDisplayItem(new ItemStack(RegistryManager.standingStoneRepulsor))
								    )
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("vacuumStoneCrafting"))
								    )
						   .addPage(new ResearchPage()
								    .addDisplayItem(new ItemStack(RegistryManager.standingStoneVacuum))
								    )
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("aestheticStoneCrafting"))
								    )
						   .addPage(new ResearchPage()
								    .addDisplayItem(new ItemStack(RegistryManager.standingStoneAesthetic))
								    )
	                       )
				 .addResearch(new ResearchBase("sacrifice", new ItemStack(Items.IRON_SWORD))
						   .addPage(new ResearchPage()
								    )
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("sacrifice"))
								    )
	                       )
				 .addResearch(new ResearchBase("timeshift", new ItemStack(Items.CLOCK))
						   .addPage(new ResearchPage()
								    )
						   .addPage(new ResearchPage()
								    .addAltarRecipe(RitualManager.getRitualFromName("timeshift"))
								    )
	                       )
			  );
	}
	public static ResearchBase getResearch(String groupName, String researchName){
		for (int i = 0; i < globalResearches.size(); i ++){
			if (globalResearches.get(i).name == groupName){
				for (int j = 0; j < globalResearches.get(i).researches.size(); j ++){
					if (globalResearches.get(i).researches.get(j).name == researchName){
						return globalResearches.get(i).researches.get(j);
					}
				}
			}
		}
		return null;
	}
	public static ResearchGroup getResearchGroup(String groupName){
		for (int i = 0; i < globalResearches.size(); i ++){
			if (globalResearches.get(i).name == groupName){
				return globalResearches.get(i);
			}
		}
		return null;
	}
}
