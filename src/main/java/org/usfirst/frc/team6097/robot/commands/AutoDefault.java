package org.usfirst.frc.team6097.robot.commands;

import org.usfirst.frc.team6097.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDefault extends Command {
	private double speed1, speed2, timeOUT;
	
	private Timer timer = new Timer();

    public AutoDefault(double speed1, double speed2, double timeOUT) {
        requires(Robot.driveTrains);

        this.speed1 = speed1;
        this.speed2 = speed2;
        this.timeOUT = timeOUT;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrains.BAutoDrive(speed1, speed2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > timeOUT;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrains.StopDrive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}