package org.usfirst.frc.team6097.robot.subsystems;
 
import org.usfirst.frc.team6097.robot.RobotMap;
 
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
 
/**
 *
 */
public class ClawRight extends Subsystem {
     Spark clawmotor2 = new Spark(RobotMap.KClawR);
public void StartClawRight(double speed) {
       
    clawmotor2.set(-speed);
       
    }
   
    public void StopClawRight() {
       
        clawmotor2.set(0.0);
    }
    public void RevClawRight(double speed) {
       
        clawmotor2.set(speed);
       
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
 
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
 
 
}
