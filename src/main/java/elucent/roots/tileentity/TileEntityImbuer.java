package elucent.roots.tileentity;

import java.util.ArrayList;
import java.util.Random;

import elucent.roots.Roots;
import elucent.roots.RegistryManager;
import elucent.roots.Util;
import elucent.roots.component.ComponentBase;
import elucent.roots.component.ComponentManager;
import elucent.roots.item.DustPetal;
import elucent.roots.item.IImbuable;
import elucent.roots.item.ItemCastingBase;
import elucent.roots.item.ItemStaff;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class TileEntityImbuer extends TEBase implements ITickable {
	public ItemStack stick = null;
	public ItemStack dust = null;
	public int progress = 0;
	public int spin = 0;
	Random random = new Random();
	
	public TileEntityImbuer(){
		super();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag){
		super.readFromNBT(tag);
		if (tag.hasKey("stick")){
			stick = ItemStack.loadItemStackFromNBT(tag.getCompoundTag("stick"));
		}
		if (tag.hasKey("dust")){
			dust = ItemStack.loadItemStackFromNBT(tag.getCompoundTag("dust"));
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag){
		super.writeToNBT(tag);
		if (stick != null){
			tag.setTag("stick",stick.writeToNBT(new NBTTagCompound()));
		}
		if (dust != null){
			tag.setTag("dust",dust.writeToNBT(new NBTTagCompound()));
		}
		return tag;
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state, EntityPlayer player){
		if (stick != null){
			if (!world.isRemote){
				world.spawnEntityInWorld(new EntityItem(world,pos.getX()+0.5,pos.getY()+0.5,pos.getZ()+0.5,stick));
			}
		}
		if (dust != null){
			if (!world.isRemote){
				world.spawnEntityInWorld(new EntityItem(world,pos.getX()+0.5,pos.getY()+0.5,pos.getZ()+0.5,dust));
			}
		}
		this.invalidate();
	}
	
	public boolean activate(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if (progress == 0){
			if (heldItem == null){
				if (stick != null){
					if (!world.isRemote){
						world.spawnEntityInWorld(new EntityItem(world,pos.getX()+0.5,pos.getY()+1.0,pos.getZ()+0.5,stick));
					}
					stick = null;
					markDirty();
					this.getWorld().notifyBlockUpdate(getPos(), state, world.getBlockState(pos), 3);
					return true;
				}
				else if (dust != null){
					if (!world.isRemote){
						world.spawnEntityInWorld(new EntityItem(world,pos.getX()+0.5,pos.getY()+1.0,pos.getZ()+0.5,dust));
					}
					dust = null;
					markDirty();
					this.getWorld().notifyBlockUpdate(getPos(), state, world.getBlockState(pos), 3);
					return true;
				}
				return false;
			}
			else if (heldItem.getItem() == Items.STICK){
				if (stick == null){
					stick = new ItemStack(Items.STICK,1);
					heldItem.stackSize --;
					markDirty();
					this.getWorld().notifyBlockUpdate(getPos(), state, world.getBlockState(pos), 3);
					return true;
				}
				return false;
			}
			else if (heldItem.getItem() instanceof IImbuable){
				if (dust == null){
					NBTTagCompound tag = new NBTTagCompound();
					heldItem.writeToNBT(tag);
					dust = ItemStack.loadItemStackFromNBT(tag);
					heldItem.stackSize --;
					markDirty();
					this.getWorld().notifyBlockUpdate(getPos(), state, world.getBlockState(pos), 3);
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}

	@Override
	public void update() {
		if (progress == 0){
			spin += 4;
		}
		else {
			spin += 12;
		}
		if (dust != null && stick != null){
			if (progress == 0){
				getWorld().playSound(getPos().getX()+0.5, getPos().getY()+0.5, getPos().getZ()+0.5, new SoundEvent(new ResourceLocation("roots:charging")), SoundCategory.BLOCKS, 1.0f, 1.0f, false);
			}
			progress ++;
		}
		if (progress != 0 && progress % 1 == 0){
			int chance = random.nextInt(4);
			ComponentBase comp = null;
			if (dust.getItem() instanceof IImbuable){
				comp = ComponentManager.getComponentFromName(((IImbuable)dust.getItem()).getEffect(dust));
			}
			if (comp != null && getWorld().isRemote){
				if (getWorld().provider.getDimension() == Minecraft.getMinecraft().thePlayer.getEntityWorld().provider.getDimension()){
					if (chance == 0){
						if (random.nextBoolean()){
							Roots.proxy.spawnParticleMagicLineFX(getWorld(), getPos().getX()+0.125, getPos().getY()+0.125, getPos().getZ()+0.125, getPos().getX()+0.5, getPos().getY()+0.625, getPos().getZ()+0.5, comp.primaryColor.xCoord, comp.primaryColor.yCoord, comp.primaryColor.zCoord);
						}
						else {
							Roots.proxy.spawnParticleMagicLineFX(getWorld(), getPos().getX()+0.125, getPos().getY()+0.125, getPos().getZ()+0.125, getPos().getX()+0.5, getPos().getY()+0.625, getPos().getZ()+0.5, comp.secondaryColor.xCoord, comp.secondaryColor.yCoord, comp.secondaryColor.zCoord);
						}
					}
					if (chance == 1){
						if (random.nextBoolean()){
							Roots.proxy.spawnParticleMagicLineFX(getWorld(), getPos().getX()+0.875, getPos().getY()+0.125, getPos().getZ()+0.125, getPos().getX()+0.5, getPos().getY()+0.625, getPos().getZ()+0.5, comp.primaryColor.xCoord, comp.primaryColor.yCoord, comp.primaryColor.zCoord);
						}
						else {
							Roots.proxy.spawnParticleMagicLineFX(getWorld(), getPos().getX()+0.875, getPos().getY()+0.125, getPos().getZ()+0.125, getPos().getX()+0.5, getPos().getY()+0.625, getPos().getZ()+0.5, comp.secondaryColor.xCoord, comp.secondaryColor.yCoord, comp.secondaryColor.zCoord);
						}
					}
					if (chance == 2){
						if (random.nextBoolean()){
							Roots.proxy.spawnParticleMagicLineFX(getWorld(), getPos().getX()+0.875, getPos().getY()+0.125, getPos().getZ()+0.875, getPos().getX()+0.5, getPos().getY()+0.625, getPos().getZ()+0.5, comp.primaryColor.xCoord, comp.primaryColor.yCoord, comp.primaryColor.zCoord);
						}
						else {
							Roots.proxy.spawnParticleMagicLineFX(getWorld(), getPos().getX()+0.875, getPos().getY()+0.125, getPos().getZ()+0.875, getPos().getX()+0.5, getPos().getY()+0.625, getPos().getZ()+0.5, comp.secondaryColor.xCoord, comp.secondaryColor.yCoord, comp.secondaryColor.zCoord);
						}
					}
					if (chance == 3){
						if (random.nextBoolean()){
							Roots.proxy.spawnParticleMagicLineFX(getWorld(), getPos().getX()+0.125, getPos().getY()+0.125, getPos().getZ()+0.875, getPos().getX()+0.5, getPos().getY()+0.625, getPos().getZ()+0.5, comp.primaryColor.xCoord, comp.primaryColor.yCoord, comp.primaryColor.zCoord);
						}
						else {
							Roots.proxy.spawnParticleMagicLineFX(getWorld(), getPos().getX()+0.125, getPos().getY()+0.125, getPos().getZ()+0.875, getPos().getX()+0.5, getPos().getY()+0.625, getPos().getZ()+0.5, comp.secondaryColor.xCoord, comp.secondaryColor.yCoord, comp.secondaryColor.zCoord);
						}
					}
				}
			}
		}
		if (progress > 40){
			progress = 0;
			if (dust != null && stick != null){
				ItemStack staff = new ItemStack(RegistryManager.staff,1,1);
				String effectName = ((IImbuable)dust.getItem()).getEffect(dust);
				int potency = ((IImbuable)dust.getItem()).getPotency(dust);
				int duration = ((IImbuable)dust.getItem()).getEfficiency(dust);
				int size = ((IImbuable)dust.getItem()).getSize(dust);
				ItemCastingBase.createData(staff,1);
				((ItemCastingBase)staff.getItem()).setEffectInSlot(staff, 1, effectName, potency, duration, size);

				if (!getWorld().isRemote){
					getWorld().spawnEntityInWorld(new EntityItem(getWorld(),getPos().getX()+0.5,getPos().getY()+1.0,getPos().getZ()+0.5,staff));
				}
				stick = null;
				dust = null;
				markDirty();
				this.getWorld().notifyBlockUpdate(getPos(), getWorld().getBlockState(getPos()), getWorld().getBlockState(getPos()), 3);
			}
		}
	}
}
