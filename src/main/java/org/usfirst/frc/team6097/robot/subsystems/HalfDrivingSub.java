/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6097.robot.subsystems;

import org.usfirst.frc.team6097.robot.OI;
import org.usfirst.frc.team6097.robot.RobotMap;
import org.usfirst.frc.team6097.robot.commands.HalfDriving;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Add your docs here.
 */
public class HalfDrivingSub extends Subsystem {
  public static DifferentialDrive driveSystem;
  public static SpeedController motor1, motor2, motor3, motor4;
  public HalfDrivingSub() {
    SpeedControllerGroup leftDrive;
      SpeedControllerGroup rightDrive;	    	
    
    motor1 = new Victor(RobotMap.KMotor0);
    motor2 = new Victor(RobotMap.KMotor1);
    motor3 = new Victor(RobotMap.KMotor2);
    motor4 = new Victor(RobotMap.KMotor3);
    
      leftDrive = new SpeedControllerGroup(motor1, motor2);
      rightDrive = new SpeedControllerGroup(motor4, motor3);    	
    
    driveSystem = new DifferentialDrive(leftDrive, rightDrive);
    
    driveSystem.setSafetyEnabled(false);
  }
      public void TeleopDrive() {
        
        driveSystem.tankDrive(-OI.driverStick.getRawAxis(2), -OI.driverStick.getRawAxis(3));
        
      }
      public void FAutoDrive(double speed1, double speed2) {
	        	
        driveSystem.tankDrive(-speed1, -speed2);
      
        
      }
      
      public void BAutoDrive(double speed1, double speed2) {
        
        driveSystem.tankDrive(speed1, speed2);

        
      }
      
      public void RAutoDrive(double speed1, double speed2) {
        
        driveSystem.tankDrive(speed1, -speed2);
        
        
      }
      
      public void LAutoDrive(double speed1, double speed2) {
        
        driveSystem.tankDrive(-speed1, speed2);
      
        
      }
      
      public void StopDrive() {
        
        driveSystem.tankDrive(0, 0);
        
      }

      public void initDefaultCommand() {
          // Set the default command for a subsystem here.
          setDefaultCommand(new HalfDriving());
      }
}

