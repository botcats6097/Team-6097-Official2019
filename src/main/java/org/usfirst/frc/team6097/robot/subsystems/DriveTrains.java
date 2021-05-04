package org.usfirst.frc.team6097.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;

import org.usfirst.frc.team6097.robot.OI;
import org.usfirst.frc.team6097.robot.RobotMap;
import org.usfirst.frc.team6097.robot.commands.Driving;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
/**
 *
 */
public class DriveTrains extends Subsystem {
	
	public static DifferentialDrive driveSystem;
	    

	 public static SpeedController motor1, motor2, motor3, motor4; 
	    
	    public DriveTrains() {
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
				double leftInput = -OI.driverStick.getRawAxis(1)*.95;
				double rightInput = -OI.driverStick.getRawAxis(5);
	        	driveSystem.tankDrive(leftInput, rightInput);
	        	
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
	            setDefaultCommand(new Driving());
	        }
}
