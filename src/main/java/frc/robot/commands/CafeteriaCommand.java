package org.usfirst.frc.team1212.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CafeteriaCommand extends CommandGroup {
	
	public CafeteriaCommand() {
		addSequential(new AALineFollow());
		addSequential(new AutoGyroTurnRight());
		addSequential(new AALineFollow());
		addSequential(new AutoGyroTurnLeft());
		addSequential(new AALineFollow());
		addSequential(new AutoGyroTurnRight());
		addSequential(new AALineFollow());
}
}
