package org.usfirst.frc.team6097.robot.subsystems;
 
import org.usfirst.frc.team6097.robot.RobotMap;
 
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
 
/**
 *
 */
public class ElevatorLeft extends Subsystem {
     Spark elevatormotor1 = new Spark(RobotMap.KElevatorL);
public void StartElevatorLeft(double speed) {
       
    elevatormotor1.set(speed);
       
    }
   
    public void StopElevatorLeft() {
       
        elevatormotor1.set(0.0);
    }
    public void RevElevatorLeft(double speed) {
       
        elevatormotor1.set(-speed);
       
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
 
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
 
 
}
