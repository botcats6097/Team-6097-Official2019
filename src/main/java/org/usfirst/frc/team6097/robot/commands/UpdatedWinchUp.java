/*----------------------------------------------------------------------------*/
/* CopyWinchS (c) 2018 FIRST. All WinchSs Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6097.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6097.robot.Robot;
import edu.wpi.first.wpilibj.Timer;


public class UpdatedWinchUp extends Command {
  private double speed1, timeOUT;
  private Timer timer = new Timer();
  public UpdatedWinchUp (double speed1, double timeOUT) {
    requires(Robot.clawWinchS);
    
      this.speed1 = speed1;
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

    Robot.clawWinchS.RevClawWinchS(speed1);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return timer.get() > timeOUT;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {    
    Robot.clawWinchS.StopClawWinchS();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
