package org.usfirst.frc.team6097.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StartOff extends CommandGroup {

    public StartOff() {

            addParallel(new AutoElevatorUp(0.9, 0.9, 1));
            addParallel(new AutoClawOpen(0.5, 0.5, 0.5));
            addParallel(new AutoDefault(0.5, 0.5, 3.00));
            addParallel(new UpdatedWinchDown(-1, 6.8));

        	
        }
       
    //
       
    }

