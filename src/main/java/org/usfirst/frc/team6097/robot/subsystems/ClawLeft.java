package org.usfirst.frc.team6097.robot.subsystems;
 
import org.usfirst.frc.team6097.robot.RobotMap;
 
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
 
/**
 *
 */
public class ClawLeft extends Subsystem {
     Spark clawmotor1 = new Spark(RobotMap.KClawL);
public void StartClawLeft(double speed) {
       
    clawmotor1.set(-speed);
       
    }
   
    public void StopClawLeft() {
       
        clawmotor1.set(0.0);
    }
    public void RevClawLeft(double speed) {
       
        clawmotor1.set(speed);
       
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
 
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
 
 
}
