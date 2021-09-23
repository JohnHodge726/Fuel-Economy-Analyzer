package project1;
import java.util.Scanner;
/*
 * John Hodges
 * CS 160 Fall 2021
 * Project 1: CAFE Compliance Analyzer
 * Description: The purpose of this program is to calculate a vehicle's "footprint"
 * which is the total product of the vehicle's track width and wheelbase. Regulation of this footprint is determined by 
 * comparing the average fleet fuel economy to the required fuel economy level in a model's year. The
 * required fuel economy level is calculated using a manufacturer's actual production levels and the
 * category targets for each specific mpg
 * */
public class CafeComlianceAnalyzer {
	public static void main(String[] args) {
		//will display the welcome screen to user
		System.out.println("Welcome to the 2016 CAFE Compliance Analyzer for CS Motors");
		System.out.println("-------------------------------------------------------------");
		//will take in the footprint value from the user
		Scanner vehicleFootPrint = new Scanner(System.in);
		System.out.print("Enter vehicle footprint: ");
		double footPrint = vehicleFootPrint.nextDouble();
		//will take the input of model name, production and mpg rating and will be stored in a car1 variable
		Scanner car1 = new Scanner(System.in);
		System.out.print("Enter model name, production amount and mpg rating for model 1: ");
		String modelName1 = car1.next();
		double production1 = car1.nextDouble();
		double mpg1 = car1.nextDouble();
		//will take the input of model name, production and mpg rating and will be stored in a car2 variable
		Scanner car2 = new Scanner(System.in);
		System.out.print("Enter model name, production amount and mpg rating for model 2: ");
		String modelName2 = car2.next();
		double production2 = car2.nextDouble();
		double mpg2 = car2.nextDouble();
		//will take the input of model name, production and mpg rating and will be stored in a car3 variable
		Scanner car3 = new Scanner(System.in);
		System.out.print("Enter model name, production amount and mpg rating for model 3: ");
		String modelName3 = car3.next();
		double production3 = car3.nextDouble();
		double mpg3 = car3.nextDouble();
		// Constants used for the target_fuel_economy variable
		final double MAX_FUEL_ECONOMY = 30.42; // a
		final double MIN_FUEL_ECONOMY = 21.79; // b
		final double MIDWAY_FOOTPRINT = 47.74; // c
		final double RATE = 4.65; // d
		//----------------------------------
		// target_fuel_economy using the variable constants
		double target_fuel_economy = 1 / (1 / MAX_FUEL_ECONOMY + (1 / MIN_FUEL_ECONOMY - (1 / MAX_FUEL_ECONOMY)) * (Math.exp((footPrint - MIDWAY_FOOTPRINT) / RATE)) / (1 + Math.exp((footPrint - MIDWAY_FOOTPRINT) / RATE)));
		//These are the calculations for the fleet production
		double sumOfFleet = production1 + production2 + production3;
		double vehicleAverage = (production1 / mpg1) + (production2 /mpg2) + (production3 / mpg3);
		double fleetFuelEconomy = sumOfFleet / vehicleAverage;
		//below will output the data onto the screen
		System.out.println("\n2011 CAFE Compliance Analysis Report for CS Motors");
		System.out.println("-------------------------------------------------------");
		System.out.println("Vehicle Foot Print: " + footPrint);
		System.out.println("Target fuel economy: " + target_fuel_economy + " mpg.\n");
		System.out.println("Model\tProduction\tMPG");
		System.out.println("-----\t----------\t---");
		System.out.println(modelName1 + "\t" + production1 + "\t\t" + mpg1);
		System.out.println(modelName2 + "\t" + production2 + "\t\t" + mpg2);
		System.out.println(modelName3 + "\t" + production3 + "\t\t" + mpg3);
		System.out.println("Fleet Fuel Economy: " + fleetFuelEconomy + " mpg.");
	}
}

