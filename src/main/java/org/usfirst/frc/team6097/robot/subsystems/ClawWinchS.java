package org.usfirst.frc.team6097.robot.subsystems;
 
import org.usfirst.frc.team6097.robot.RobotMap;
 
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
 
/**
 *
 */
public class ClawWinchS extends Subsystem {
     Spark clawmotor3 = new Spark(RobotMap.KCLawWinch);
public void StartClawWinchS(double speed) {
       
    clawmotor3.set(-speed);
       
    }
   
    public void StopClawWinchS() {
       
        clawmotor3.set(0.0);
    }
    public void RevClawWinchS(double speed) {
       
        clawmotor3.set(-speed);
       
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
 
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
 
 
}
