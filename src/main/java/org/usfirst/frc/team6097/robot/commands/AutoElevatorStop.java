/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6097.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import java.awt.geom.Line2D.Double;

import org.usfirst.frc.team6097.robot.Robot;

import edu.wpi.first.wpilibj.Timer;


public class AutoElevatorStop extends Command {
  private double speed1, speed2, timeOUT;
  private Timer timer = new Timer();

  public AutoElevatorStop(double speed1, double speed2, double timeOUT) {
    requires(Robot.elevatorLeft);
    requires(Robot.elevatorRight);
    
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

    Robot.elevatorRight.StopElevatorRight(); // both of these are referring to the subsystems used in this command
    Robot.elevatorLeft.StopElevatorLeft();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    

    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {    
    Robot.elevatorRight.StopElevatorRight();         //both of these are referring to the subsystems used in this command
    Robot.elevatorLeft.StopElevatorLeft();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
