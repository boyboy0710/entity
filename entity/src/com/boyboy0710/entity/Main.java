package com.boyboy0710.entity;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class Main extends JavaPlugin implements Listener{

	public void onEnable() {
		System.out.println("----------------------------------------------------");
		System.out.println("    entity 를러그인을 성공적으로 불러왔습니다");
		System.out.println("        플러그인 제작자ㅣ:boyboy0710");
		System.out.println("----------------------------------------------------");
		
		
	}
	@Override
	public void onDisable() {
		System.out.println("entity 플러그인이 비활성화 되었습니다");
	}
	
	public boolean zombie = false;
	public boolean skeleton = false;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("spawn")) {
			if(args.length == 0) {
				sender.sendMessage("커맨드를 끝까지 쳐주세요");
			} 
			
			else if(args[0].equalsIgnoreCase("king_zombie")) {
			Player player = (Player) sender;
		    setZombieStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE));
		    zombie = true;
		    World world = player.getWorld();
			   world.setStorm(true);
			   world.setThundering(true);
			}
		
			else if(args[0].equalsIgnoreCase("king_skeleton")) {
				Player player = (Player) sender;
				setZombieStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.SKELETON));
				skeleton = true;
				World world = player.getWorld();
				world.setStorm(true);
				world.setThundering(true);
			}
		}
		return false;
	}
	
	 public void setZombieStats(LivingEntity entity) {
	  entity.setCustomName("king_zombie");
	  entity.setMaxHealth(1000.0);//최대 체력 설정
	  entity.setHealth(1000.0);//현재 체력 설정
	  entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,1000000, 10));
	  entity.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,1000000, 10));
	  entity.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,1000000, 300));
	  entity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,1000000, 1));
	  entity.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
	  entity.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
	  entity.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
	  entity.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
	  entity.getEquipment().setItemInHand(new ItemStack(Material.NETHERITE_SWORD));
	 }
	 
	 public void setSkeletonStats(LivingEntity entity) {
		  entity.setCustomName("king_skeleton");
		  entity.setMaxHealth(1000.0);//최대 체력 설정
		  entity.setHealth(1000.0);//현재 체력 설정
		  entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,1000000, 10));
		  entity.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,1000000, 10));
		  entity.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,1000000, 100));
		  entity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,1000000, 1));
		  entity.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
		  entity.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
		  entity.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
		  entity.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
		  entity.getEquipment().setItemInHand(new ItemStack(Material.BOW));
		 }
	 
	 @EventHandler
	 public void getZombieDead(EntityDeathEvent event) {
	  if(event.getEntity().getCustomName() == "king_zombie") {
	   event.getEntity().getWorld().dropItem(event.getEntity().getLocation(),new ItemStack(Material.NETHERITE_BLOCK, 100));
	   event.getEntity().getWorld().dropItem(event.getEntity().getLocation(),new ItemStack(Material.NETHERITE_HELMET, 100));
	   event.getEntity().getWorld().dropItem(event.getEntity().getLocation(),new ItemStack(Material.NETHERITE_LEGGINGS, 100));
	   event.getEntity().getWorld().dropItem(event.getEntity().getLocation(),new ItemStack(Material.NETHERITE_BOOTS, 100));
	   event.getEntity().getWorld().dropItem(event.getEntity().getLocation(),new ItemStack(Material.NETHERITE_SWORD, 100));
	   ((Entity) event).getWorld().createExplosion(((Entity) event).getLocation(), 10);
	   zombie = false;
	   if(!zombie) {
		   if(!skeleton) {
			   World world = ((Entity) event).getWorld();
			   world.setStorm(false);
			   world.setThundering(false);
		   }
	   }
	 }
	  if(event.getEntity().getCustomName() == "king_skeleton") {
		   event.getEntity().getWorld().dropItem(event.getEntity().getLocation(),new ItemStack(Material.NETHERITE_BLOCK, 100));
		   event.getEntity().getWorld().dropItem(event.getEntity().getLocation(),new ItemStack(Material.NETHERITE_HELMET, 100));
		   event.getEntity().getWorld().dropItem(event.getEntity().getLocation(),new ItemStack(Material.NETHERITE_LEGGINGS, 100));
		   event.getEntity().getWorld().dropItem(event.getEntity().getLocation(),new ItemStack(Material.NETHERITE_BOOTS, 100));
		   event.getEntity().getWorld().dropItem(event.getEntity().getLocation(),new ItemStack(Material.NETHERITE_SWORD, 100));
		   ((Entity) event).getWorld().createExplosion(((Entity) event).getLocation(), 10);
		   zombie = false;
		   if(!zombie) {
			   if(!skeleton) {
				   World world = ((Entity) event).getWorld();
				   world.setStorm(false);
				   world.setThundering(false);
			   }
		   }
		 }
}
	 
	
}
