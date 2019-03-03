package org.usfirst.frc.team1212.robot.commands;

import org.usfirst.frc.team1212.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class AutoElevatorUp extends TimedCommand{
	
	public AutoElevatorUp() {
        this(0);
        
        setTimeout(1);
    }

    public AutoElevatorUp(double timeout) {
        super(timeout);

    	  
        requires(Robot.elevatorSub);

    }

	    @Override
	    protected void initialize() {
	    	Robot.elevatorSub.ElevatorUp();
	    }

	    @Override
	    protected void execute() {
	    	
	    	Robot.elevatorSub.ElevatorUp();
	    }

	    @Override
	    protected boolean isFinished() {
	        return Robot.elevatorSub.getTopLimit() || isTimedOut();
	    }

	    @Override
	    protected void end() {
	    	Robot.elevatorSub.ElevatorStop();
	    }

	  
	    @Override
	    protected void interrupted() {
	    	
	    	end();
	    }


}
