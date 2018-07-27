package com.wumple.util.adapter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.wumple.util.capability.CapabilityUtils;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;

public class TileEntityThing implements IThing
{
    public TileEntity owner = null;

    public TileEntityThing(TileEntity ownerIn)
    {
        owner = ownerIn;
    }

    public World getWorld()
    {
        return owner.getWorld();
    }
    
    public BlockPos getPos()
    {
        return owner.getPos();
    }

    public boolean isInvalid()
    {
        return owner.isInvalid();
    }

    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing)
    {
        return owner.hasCapability(capability, facing);
    }

    @Nullable
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing)
    {
        return owner.getCapability(capability, facing);
    }

    @Nullable
    public <T> T fetchCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing)
    {
        return CapabilityUtils.fetchCapability(owner, capability, facing);
    }

    public void markDirty()
    {
        owner.markDirty();
    }

    public void invalidate()
    {
        owner = null;
    }

    public boolean sameAs(IThing entity)
    {
        if (entity instanceof TileEntityThing)
        {
            return owner == ((TileEntityThing) entity).owner;
        }
        return false;
    }
}
