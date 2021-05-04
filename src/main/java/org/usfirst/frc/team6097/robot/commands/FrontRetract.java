package org.usfirst.frc.team6097.robot.commands;

import org.usfirst.frc.team6097.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

//Used to be LauncherOpen.java

/**
 *
 */
public class FrontRetract extends Command {

    public FrontRetract() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.pneumaticFrontLeft);


    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.pneumaticFrontLeft.OpenGate();
        Timer.delay(0.5);
 
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
    	return true;
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	

    	Robot.pneumaticFrontLeft.OffGate();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
