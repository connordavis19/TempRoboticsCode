package org.usfirst.frc.team1212.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRightRight extends CommandGroup {
	


	public AutoRightRight() {

		addSequential(new AutoElevatorUp(1));
		addParallel(new AutoHerdersIn(2));
//		addSequential(new AutoStrafeLeft(4));
		addParallel(new AutoForwardUntilEye(2));
		addSequential(new AutoGyroTurnLeft());
		addSequential(new ExtendHerdersCom());
		addParallel(new AutoHerdersOut(3));
	}
}
