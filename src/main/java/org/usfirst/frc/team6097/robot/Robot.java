/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
	
package org.usfirst.frc.team6097.robot;

import org.usfirst.frc.team6097.robot.commands.AutoClawOpen;
import org.usfirst.frc.team6097.robot.commands.AutoDefault;
import org.usfirst.frc.team6097.robot.commands.AutoElevatorDown;
import org.usfirst.frc.team6097.robot.commands.AutoElevatorDownUpdated;
import org.usfirst.frc.team6097.robot.commands.AutoElevatorStop;
import org.usfirst.frc.team6097.robot.commands.AutoElevatorStopUpdated;
import org.usfirst.frc.team6097.robot.commands.AutoElevatorUp;
import org.usfirst.frc.team6097.robot.commands.AutoElevatorUpUpdated;
import org.usfirst.frc.team6097.robot.commands.AutoForward;
import org.usfirst.frc.team6097.robot.commands.AutoWinch;
import org.usfirst.frc.team6097.robot.commands.ClawClose;
import org.usfirst.frc.team6097.robot.commands.ClawOpen;
import org.usfirst.frc.team6097.robot.commands.ClawShiftL;
import org.usfirst.frc.team6097.robot.commands.ClawShiftR;
import org.usfirst.frc.team6097.robot.commands.Driving;
import org.usfirst.frc.team6097.robot.commands.ElevatorDown;
import org.usfirst.frc.team6097.robot.commands.ElevatorDownUpdated;	
import org.usfirst.frc.team6097.robot.commands.ElevatorHigh;
import org.usfirst.frc.team6097.robot.commands.ElevatorMed;
import org.usfirst.frc.team6097.robot.commands.ElevatorUp;
import org.usfirst.frc.team6097.robot.commands.ElevatorUpUpdated;
import org.usfirst.frc.team6097.robot.commands.FrontRetract;
import org.usfirst.frc.team6097.robot.commands.FrontDeploy;
//import org.usfirst.frc.team6097.robot.commands.HalfDriving;
import org.usfirst.frc.team6097.robot.commands.LauncherFire;
import org.usfirst.frc.team6097.robot.commands.LauncherGroup;
import org.usfirst.frc.team6097.robot.commands.StartOff;
import org.usfirst.frc.team6097.robot.commands.LauncherRetract;
import org.usfirst.frc.team6097.robot.commands.ClawWinchDown;
import org.usfirst.frc.team6097.robot.commands.ClawWinchUp;
import org.usfirst.frc.team6097.robot.commands.UpdatedWinchUp;
import org.usfirst.frc.team6097.robot.commands.UpdatedWinchDown;
//Subsystems
import org.usfirst.frc.team6097.robot.subsystems.ClawLeft;
import org.usfirst.frc.team6097.robot.subsystems.ClawRight;
import org.usfirst.frc.team6097.robot.subsystems.DriveTrains;
import org.usfirst.frc.team6097.robot.subsystems.ElevatorLeft;
import org.usfirst.frc.team6097.robot.subsystems.ElevatorRight;
import org.usfirst.frc.team6097.robot.subsystems.PneumaticFrontLeft;

import org.usfirst.frc.team6097.robot.subsystems.PneumaticBack;
//import org.usfirst.frc.team6097.robot.subsystems.HalfDrivingSub;
import org.usfirst.frc.team6097.robot.subsystems.PneumaticLauncher;
import org.usfirst.frc.team6097.robot.subsystems.ClawWinchS;

//Camera Server
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;

//WPILibJ

import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	// Below is all the subsystems
	public static final DriveTrains driveTrains = new DriveTrains();
	public static final ElevatorRight elevatorRight = new ElevatorRight();
	public static final ElevatorLeft elevatorLeft = new ElevatorLeft();
	public static final ClawRight clawRight = new ClawRight();
	public static final ClawLeft clawLeft = new ClawLeft();
	public static final PneumaticLauncher pneumaticLauncher = new PneumaticLauncher();
	public static final PneumaticFrontLeft pneumaticFrontLeft = new PneumaticFrontLeft();

	public static final PneumaticBack pneumaticBack = new PneumaticBack();
	public static final ClawWinchS clawWinchS = new ClawWinchS();
	// public static final HalfDrivingSub halfDrivingSub = new HalfDrivingSub();

	public static OI oi;

	Command drivingCommand;
	Command autoDefaultCommand;
	Command autoElevatorStop;
	Command autoForwardCommand;
	Command autoWinchCommand; 
	Command autobackwardCommand;
	Command elevatorHigh;
	Command elevatorMed;
	Command elevatorUp;
	Command elevatorC;
	Command clawC;
	Command clawOpen;
	Command clawClose;
	Command elevatorDown;
	Command autoElevatorUp;
	Command autoElevatorDown;
	Command LauncherRetract;
	Command LauncherFire;
	Command launcherGroup;
	Command clawShiftL;
	Command clawShiftR;
	Command clawFire;
	Command autoElevatorDownUpdated;
	Command autoElevatorStopUpdated;
	Command autoElevatorUpUpdated;
	Command elevatorDownUpdated;
	Command elevatorUpUpdated;
	Command FrontDeploy;
	Command FrontRetract;
	Command ClawWinchUp;
	Command ClawWinchDown;
	// Command halfDriving;
	Command autonomousCommand;
	Command updatedWinchUp; 
	Command updatedWinchDown;
	Command StartOff;
	Command AutoClawOpem;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		drivingCommand = new Driving();// manual
		elevatorUp = new ElevatorUp(.1, .1); // manual
		elevatorDown = new ElevatorDown(.1, .1); // manual
		clawClose = new ClawClose(0, 0); // manual
		clawOpen = new ClawOpen(0, 0); // manual
		elevatorMed = new ElevatorMed(); // auto
		autoDefaultCommand = new AutoDefault(0, 0, 0); // auto
		autoForwardCommand = new AutoForward(); // auto
		autoWinchCommand = new AutoWinch(); 
		autoElevatorDown = new AutoElevatorDown(0, 0, 0); // auto
		autoElevatorUp = new AutoElevatorUp(0, 0, 0); // auto
		elevatorHigh = new ElevatorHigh(); // auto
		autoElevatorStop = new AutoElevatorStop(0, 0, 0); // auto
		LauncherRetract = new LauncherRetract();
		LauncherFire = new LauncherFire();
		launcherGroup = new LauncherGroup();
		clawShiftL = new ClawShiftL(0, 0);
		clawShiftR = new ClawShiftR(0, 0);
		autoElevatorDownUpdated = new AutoElevatorDownUpdated(0, 0, 0);
		autoElevatorStopUpdated = new AutoElevatorStopUpdated(0, 0);
		autoElevatorUpUpdated = new AutoElevatorUpUpdated(0, 0);
		elevatorDownUpdated = new ElevatorDownUpdated(0, 0);
		elevatorUpUpdated = new ElevatorUpUpdated(0, 0);
		FrontDeploy = new FrontDeploy();
		FrontRetract = new FrontRetract();
		ClawWinchUp = new ClawWinchUp(0);
		ClawWinchDown = new ClawWinchDown(0);
		updatedWinchDown = new UpdatedWinchDown(1, 1);
		updatedWinchUp = new UpdatedWinchUp(0, 0);
		StartOff = new StartOff();
		AutoClawOpem = new AutoClawOpen(1, 1, 1);
		// halfDriving = new HalfDriving();
		 
		Compressor ourCompressor = new Compressor(0);
		ourCompressor.setClosedLoopControl(true);

		SmartDashboard.putData(Scheduler.getInstance());
		// This is where the Subsystems used in the auto commands are put
		SmartDashboard.putData(driveTrains);
		// SmartDashboard.putData(climber);

		// Here is where you name the different commands you want to show up on the
		// SmartDashboard.
		SmartDashboard.putData("Driving", drivingCommand);

		SmartDashboard.putData("Auto Forward", autoForwardCommand);
		chooser.setDefaultOption("Auto on Forward", new AutoForward());

		SmartDashboard.putData("Auto :", chooser);
		//Old Camera Code, keep in case new doesnt work:
		//CameraServer.getInstance().startAutomaticCapture();

		//New Camerca Code
		CameraServer.getInstance().startAutomaticCapture(0);
    	CameraServer.getInstance().startAutomaticCapture(1);	
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() { // DON'T DELETE THIS LINE
	//if (StartOff != null) {
			//StartOff.start(); 
		//}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() { 
		
		Scheduler.getInstance().run(); //DONT DELETE THIS LINE
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		//if (StartOff != null) {
			//StartOff.cancel();
		//}
		

	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}