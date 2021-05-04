package org.usfirst.frc.team6097.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoForward extends CommandGroup {

    public AutoForward() {
   
            
        	addSequential(new AutoDefault(0.47, 0.52, 3.00));

        	
        }
       
    //
       
    }

