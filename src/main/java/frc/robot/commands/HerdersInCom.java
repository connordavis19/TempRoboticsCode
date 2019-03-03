package org.usfirst.frc.team1212.robot.commands;

import org.usfirst.frc.team1212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HerdersInCom extends Command {
	
    public HerdersInCom() {

    	  
        requires(Robot.elevatorSub);

    }

    @Override
    protected void initialize() {
    	
    	Robot.elevatorSub.HerdersIn();
    }

    @Override
    protected void execute() {
    	
    	Robot.elevatorSub.HerdersIn();
    }

    @Override
    protected boolean isFinished() {
        return false;
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