package org.usfirst.frc.team6097.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticLauncher extends Subsystem {
	
	public static DoubleSolenoid pGate = new DoubleSolenoid(6, 7); 
    
    public void OpenGate() {
    	
    	pGate.set(DoubleSolenoid.Value.kForward);
    	
    }
    
    public void CloseGate() {
    	
    	pGate.set(DoubleSolenoid.Value.kReverse);
    	
    }
    
    public void OffGate() {
    	
    	pGate.set(DoubleSolenoid.Value.kOff);
    	
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
