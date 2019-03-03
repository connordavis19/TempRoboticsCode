package org.usfirst.frc.team1212.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AAGroup extends CommandGroup {

    public AAGroup() {
    	//Sequential Commands (Runs in order)
    	//EXAMPLE: addSequential(new Command());
    	
        addSequential(new AAAuto(2, 1, 0, 0));
        addSequential(new AAAuto(1.5, 0, 0, 0.25));
        

    	//Parallel Commands (Runs at the same time)
    	//EXAMPLE: addParallel(new Command1());
    	//		   addSequential(new Command2());


        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
