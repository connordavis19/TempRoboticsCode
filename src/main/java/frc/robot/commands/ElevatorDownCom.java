package org.usfirst.frc.team1212.robot.commands;

import org.usfirst.frc.team1212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorDownCom extends Command{
	
	  
    public ElevatorDownCom() {

  
        requires(Robot.elevatorSub);

    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	
    	Robot.elevatorSub.ElevatorDown();
    }

    @Override
    protected boolean isFinished() {
        return Robot.elevatorSub.getBottomLimit();
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
