package org.usfirst.frc.team1212.robot.commands;

import org.usfirst.frc.team1212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RetractHerdersCom extends Command{

	   public RetractHerdersCom() {

		  	  
	        requires(Robot.herderSub);

	    }

	    @Override
	    protected void initialize() {
	    	
	    	Robot.herderSub.RetractHerders();
	    }

	    @Override
	    protected void execute() {
	    	
	    	Robot.herderSub.RetractHerders();
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
