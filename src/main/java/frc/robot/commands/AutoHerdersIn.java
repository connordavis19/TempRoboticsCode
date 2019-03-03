package org.usfirst.frc.team1212.robot.commands;

import org.usfirst.frc.team1212.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class AutoHerdersIn extends TimedCommand {
	
	public AutoHerdersIn() {
        this(0);
        
        setTimeout(.5);
    }

    public AutoHerdersIn(double timeout) {
        super(timeout);

    	  
        requires(Robot.elevatorSub);

    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	
    	Robot.elevatorSub.HerdersIn();
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