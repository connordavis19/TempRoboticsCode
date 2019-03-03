package org.usfirst.frc.team1212.robot.commands;

import org.usfirst.frc.team1212.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class AutoHerdersOut extends TimedCommand{
	
	public AutoHerdersOut() {
        this(0);
        
        setTimeout(2);
    }

    public AutoHerdersOut(double timeout) {
        super(timeout);

    	  
        requires(Robot.elevatorSub);

    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	
    	Robot.elevatorSub.HerdersOut();
    }

    @Override
	protected boolean isFinished() {
		return isTimedOut();
	}

    @Override
    protected void end() {
    	Robot.elevatorSub.HerdersStop();
    }

  
    @Override
    protected void interrupted() {
    	end();
    }

}
