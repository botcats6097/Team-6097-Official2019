/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6097.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

//RobotMap.java is where you assign motors to the different ports on the roboRio.

public class RobotMap {
public static final int KController = 0; // Xbox Controller
public static final int KLogitech = 1; // Logitech Flight Stick

	public static final int KMotor0 = 0; // Front Left
	public static final int KMotor1 = 1; // Back Left
	public static final int KMotor2 = 2; // Back Right
	public static final int KMotor3 = 3; // Front Right
	public static final int KClawR = 4; // Front Right sparks
	public static final int KClawL = 5; // Front Left sparks
	public static final int KElevatorL = 6; //
	public static final int KElevatorR = 7; //	
	public static final int KPneumatic = 8; //
	public static final int KCLawWinch = 9;
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;



	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;