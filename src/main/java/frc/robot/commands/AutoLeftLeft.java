package org.usfirst.frc.team1212.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLeftLeft extends CommandGroup {
	


	public AutoLeftLeft() {
		addSequential(new AutoElevatorUp(1));
		addParallel(new AutoHerdersIn(2));
//		addSequential(new AutoStrafeLeft(4));
		addSequential(new AutoForwardUntilEye(2));
		addSequential(new AutoGyroTurnRight());
		addSequential(new ExtendHerdersCom());
		addParallel(new AutoHerdersOut(3));
	}
}
