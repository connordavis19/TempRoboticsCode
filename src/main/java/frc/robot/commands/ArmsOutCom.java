package org.usfirst.frc.team1212.robot.commands;

import org.usfirst.frc.team1212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmsOutCom extends Command{
	

	   public ArmsOutCom() {

	    	  
	        requires(Robot.elevatorSub);

	    }

	    @Override
	    protected void initialize() {
	    }

	    @Override
	    protected void execute() {
	    	
	    	Robot.elevatorSub.ArmsOut(Robot.oi.elevatorStick);
	    }

	    @Override
	    protected boolean isFinished() {
	        return false;
	    }

	    @Override
	    protected void end() {
	    }

	  
	    @Override
	    protected void interrupted() {
	    	end();
	    }

}
