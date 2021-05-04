package org.usfirst.frc.team6097.robot.subsystems;
 
import org.usfirst.frc.team6097.robot.RobotMap;
 
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
 
/**
 *
 */
public class ElevatorRight extends Subsystem {
     Spark elevatormotor2 = new Spark(RobotMap.KElevatorR);
public void StartElevatorRight(double speed) {
       
    elevatormotor2.set(-speed);
       
    }
   
    public void StopElevatorRight() {
       
        elevatormotor2.set(0.0);
    }
    public void RevElevatorRight(double speed) {
       
        elevatormotor2.set(speed);
       
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
 
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
 
 
}
