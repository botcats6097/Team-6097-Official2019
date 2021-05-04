package org.usfirst.frc.team6097.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LauncherGroup extends CommandGroup {
    
    public  LauncherGroup() {
		//addSequential(new ClawFire(.5, .5, .1));
    	addSequential(new LauncherFire());
    	addSequential(new LauncherRetract());
    	//addParallel(new GateControllOFF());
    	//addParallel(new CompressorControl());
    	
    	
    	
    }
}
