/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6097.robot;

import org.usfirst.frc.team6097.robot.commands.AutoWinch;
import org.usfirst.frc.team6097.robot.commands.BackDeploy;
import org.usfirst.frc.team6097.robot.commands.BackRetract;
//import org.usfirst.frc.team6097.robot.commands.CompressorControl;
import org.usfirst.frc.team6097.robot.commands.ClawClose;
import org.usfirst.frc.team6097.robot.commands.ClawOpen;
import org.usfirst.frc.team6097.robot.commands.ClawShiftL;
import org.usfirst.frc.team6097.robot.commands.ClawShiftR;
import org.usfirst.frc.team6097.robot.commands.ClawWinchDown;
import org.usfirst.frc.team6097.robot.commands.ClawWinchUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team6097.robot.commands.LauncherGroup;
import org.usfirst.frc.team6097.robot.commands.StartOff;
import org.usfirst.frc.team6097.robot.commands.UpdatedWinchDown;
import org.usfirst.frc.team6097.robot.commands.UpdatedWinchUp;

//Old
/*
import org.usfirst.frc.team6097.robot.commands.ElevatorUp;
import org.usfirst.frc.team6097.robot.commands.ElevatorMed;
import org.usfirst.frc.team6097.robot.commands.ElevatorHigh;
import org.usfirst.frc.team6097.robot.commands.ElevatorDown;
*/
//New

import org.usfirst.frc.team6097.robot.commands.ElevatorDownUpdated;
import org.usfirst.frc.team6097.robot.commands.ElevatorHighUpdated;
import org.usfirst.frc.team6097.robot.commands.ElevatorMedUpdated;
import org.usfirst.frc.team6097.robot.commands.ElevatorUpUpdated;
import org.usfirst.frc.team6097.robot.commands.FrontDeploy;
import org.usfirst.frc.team6097.robot.commands.FrontRetract;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

// Oi.java is where you assign all the different buttons and joysticks names,
// and dictate what commands they run.

public class OI {
	public static Joystick driverStick = new Joystick(RobotMap.KController);
	public static Joystick endgameStick = new Joystick(RobotMap.KLogitech);
	public static JoystickButton
			AButton = new JoystickButton(driverStick, 1), // A button
			BButton = new JoystickButton(driverStick, 2), // B button
			XButton = new JoystickButton(driverStick, 3), // X button
			YButton = new JoystickButton(driverStick, 4), // Y button
			LeftBumper = new JoystickButton(driverStick, 5), // Left Bumper
			RightBumper = new JoystickButton(driverStick, 6), // Right Bumper
			SelectButton = new JoystickButton(driverStick, 7), // Back
			StartButton = new JoystickButton(driverStick, 8), // Start
			L3 = new JoystickButton(driverStick, 9), // Left Stick Click
			R3 = new JoystickButton(driverStick, 10), // Right Stick Click
			// Logitech
			LogitechButton1 = new JoystickButton(endgameStick, 1),
			LogitechButton2 = new JoystickButton(endgameStick, 2),
			LogitechButton3 = new JoystickButton(endgameStick, 3),
			LogitechButton4 = new JoystickButton(endgameStick, 4),
			LogitechButton5 = new JoystickButton(endgameStick, 5),
			LogitechButton6 = new JoystickButton(endgameStick, 6),
			LogitechButton7 = new JoystickButton(endgameStick, 7),
			LogitechButton8 = new JoystickButton(endgameStick, 8),
			LogitechButton9 = new JoystickButton(endgameStick, 9),
			LogitechButton10 = new JoystickButton(endgameStick, 10),
			LogitechButton11 = new JoystickButton(endgameStick, 11),
			LogitechButton12 = new JoystickButton(endgameStick, 12);
	// driverstick 7 = back button
	// driverstick 8 = start button
	// driverstick 9 = left stick press
	// driverstick 10 = right stick press
	// need to name the controls for driving joystick and triggers
	public OI() {

		// OLD ELevator Motor

		/*
		 * driverButton1.whileHeld(new ClawOpen(.5, .5)); //A button
		 * driverButton2.whileHeld(new ClawClose(.5, .5)); //B button
		 * driverButton4.whenPressed(new LauncherGroup()); // Y button
		 * driverButton6.whileHeld(new ElevatorDown( 1, 1)); // left bumper
		 * driverButton5.whileHeld(new ElevatorUp(-1, -1)); // right bumper
		 * driverButton9.whenPressed(new ElevatorHigh()); // right stick click
		 * driverButton10.whenPressed(new ElevatorMed()); // left stick click
		 * driverButton7.whileHeld(new ClawShiftL(.7, .5)); driverButton8.whileHeld(new
		 * ClawShiftR(.5, .7));
		 */

		// NEW Elevtor Motor

		AButton.whileHeld(new ClawOpen(.5, .5)); 
		BButton.whileHeld(new ClawClose(.5, .5)); 
		XButton.whenPressed(new ElevatorHighUpdated());
		YButton.whenPressed(new LauncherGroup()); 
		LeftBumper.whileHeld(new ElevatorUpUpdated(-1, -1)); 
		RightBumper.whileHeld(new ElevatorDownUpdated(1, 1)); 
		SelectButton.whileHeld(new ClawShiftL(.5, .5)); 
		StartButton.whileHeld(new ClawShiftR(.5, .5)); 
		//L3.whileHeld(new ClawWinchUp(-1));
		//R3.whileHeld(new ClawWinchDown(1));
		L3.whenPressed(new UpdatedWinchUp(-1, 8));
		R3.whenPressed(new AutoWinch()); 
		
		LogitechButton2.whenPressed(new LauncherGroup());
		LogitechButton1.whileHeld(new ClawClose(.5, .5));
		LogitechButton7.whileHeld(new ElevatorDownUpdated(1, 1));
		LogitechButton8.whileHeld(new ElevatorUpUpdated(-1, -1));
		LogitechButton5.whenPressed(new FrontDeploy());
		LogitechButton6.whenPressed(new FrontRetract());
		LogitechButton4.whenPressed(new BackDeploy());
		LogitechButton3.whenPressed(new BackRetract());
		//LogitechButton.whenPressed(new ());
		LogitechButton10.whenPressed(new StartOff());
		LogitechButton11.whileHeld(new ClawWinchUp(-1));
		LogitechButton12.whileHeld(new ClawWinchDown(1));



	}
}