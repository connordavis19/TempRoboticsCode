package org.usfirst.frc.team1212.robot.commands;

import org.usfirst.frc.team1212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorUpCom extends Command{
	
	   public ElevatorUpCom() {

		   
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
	        return Robot.elevatorSub.getTopLimit();
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
