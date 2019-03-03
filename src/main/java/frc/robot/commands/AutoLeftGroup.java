package org.usfirst.frc.team1212.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class AutoLeftGroup extends ConditionalCommand{
	
	private String gameData;
	
	public AutoLeftGroup(){
		super(new AutoLeftLeft(),new AutoLeftRight());
		
	}
	
	@Override 
	protected boolean condition() {
		
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
			if (gameData.length() > 0) {
				if (gameData.charAt(0) == 'L')
					return true;
				else
					return false;
			}
		return false;
	}
}
