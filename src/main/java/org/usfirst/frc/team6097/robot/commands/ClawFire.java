/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6097.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6097.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import java.awt.geom.Line2D.Double;


public class ClawFire extends Command {
  private double speed1, speed2, timeOUT;
  private Timer timer = new Timer();
  public ClawFire(double speed1, double speed2, double timeOUT) {
    requires(Robot.clawLeft);
    requires(Robot.clawRight);
    
      this.speed1 = speed1;
      this.speed2 = speed2;
      this.timeOUT = timeOUT;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer.reset();
    timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.clawRight.StartClawRight(speed1);         //both of these are referring to the subsystems used in this command
    Robot.clawLeft.StartClawLeft(speed2);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    

    return timer.get() > timeOUT;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {    
    Robot.clawRight.StopClawRight();         //both of these are referring to the subsystems used in this command
    Robot.clawLeft.StopClawLeft();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
