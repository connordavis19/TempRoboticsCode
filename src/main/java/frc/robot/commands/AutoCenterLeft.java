package org.usfirst.frc.team1212.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCenterLeft extends CommandGroup {
	


	public AutoCenterLeft() {
		addSequential(new AutoElevatorUp(1));
		addParallel(new AutoHerdersIn(2));
		addSequential(new AutoStrafeLeft(4));
		addSequential(new AutoForwardUntilEye(2));
		addSequential(new ExtendHerdersCom());
		addSequential(new AutoHerdersOut(3));
	}
}
