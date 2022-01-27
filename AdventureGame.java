//Joshua Walchle 2021 do not steal plz

import java.util.Random;
import java.util.Scanner;

public class AdventureGame {
	public static void main (String [] args) {
		
		//System objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		//Game variables
		String[] enemies = {"Jimmy", "Feral Dentist", "Ancient Black Dragon", "Gregly" };
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;
		
		//Player Variables
		int health = 100;
		int attackDamage = 50;
		int numHealthPots = 3;
		int healthPotHealAmount = 30;
		int healthPotDropChance = 50; //Percentage
		
		boolean running = true;
		
		System.out.println("Welcome to the Dungeon of Evil and Bad Things!");
		
		
		GAME:
		while (running) {
			System.out.println("-------------------------------------------------------------");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# A wild " + enemy + " appeared! #\n");
			
			while (enemyHealth > 0) {
				System.out.println("\tYour HP: " + health);
				//System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1: Attack");
				System.out.println("\t2: Drink health potion");
				System.out.println("\t3: Flee");
				
				String input = in.nextLine();
				
				if(input.equals("1")) {
					int damageDealt = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t>You strike the " + enemy + " for " + damageDealt + " damage!");
					System.out.println("\t>The " + enemy + " attacks, dealing " + damageTaken + " damage!");
					
					if (health <= 0) {
						System.out.println("\t>You have died. RIP");
						break;
					}
					
				}else if (input.equals("2")) {
					
					if (numHealthPots > 0) {
						health += healthPotHealAmount;
						numHealthPots--;
						System.out.println("\t>You consume a health potion, healing yourself for " + healthPotHealAmount + "."
								+ "\n\t>You now have " + health + " HP." 
								+ "\n\t>You have " + numHealthPots + " health potions remaining in your inventory.");
					} else {
						System.out.println("\t>You have no health potions remaining, fool. Defeat enemies for a chance to receive one.");
					}
					
				}else if (input.equals("3")) {
					System.out.println("\t>You run away from the " + enemy + "!");
					continue GAME;
				}else {
					System.out.println("\tInvalid command.");
				}
			}
			if (health <= 0) {
				System.out.println("\t>Dang, that really sucks that you died back there."); 
				break;
			}
			
			System.out.println("-------------------------------------------------------------");
			System.out.println(" # " + enemy + " was defeated! #");
			System.out.println(" # You have " + health + " HP left.");
			if(rand.nextInt(100) < healthPotDropChance) {
				numHealthPots++;
				System.out.println(" # The " + enemy + " dropped a health potion! #");
				System.out.println(" # You now have " + numHealthPots + " potion[s]! #");
			}
			
			System.out.println("-------------------------------------------------------------");
			System.out.println("What would you like to do?");
			System.out.println("\t1: Continue fighting");
			System.out.println("\t2: Exit the Dungeon");
			
			String input = in.nextLine();
			while (!input.equals("1") && !input.equals("2")) {
				System.out.println("Whoa, hold your horses there, buddy! That's an invalid command.");
				input=in.nextLine();
			}
			
			if(input.equals("1")) {
				System.out.println("You continue on your adventure!");
					} else if (input.equals("2")) {
					System.out.println("You exit the dungeon, having successfully vanquished your foes.");
					break;}
			}
		
			System.out.println("##################################################");
			System.out.println("# Thanks for playing the dungeon, brave warrior! #");
			System.out.println("##################################################");
	}
}
