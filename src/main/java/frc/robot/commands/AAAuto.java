package org.usfirst.frc.team1212.robot.commands;

import org.usfirst.frc.team1212.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class AAAuto extends TimedCommand{
	
	public double forwardVal;
	public double strafeVal;
	public double turnVal;
	
	

    public AAAuto(double timeout, double fVal, double sVal, double tVal) {
    	//Test Git Comment
  
       super(timeout);

       strafeVal = sVal;
       forwardVal = fVal;
       turnVal = tVal;
    	  
        requires(Robot.driveTrain);

    }

	@Override
	protected void initialize() {
		
		
	}

	@Override
	protected void execute() {
		
	
		Robot.driveTrain.AutoMecDrive(forwardVal, strafeVal, turnVal);
		
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}


	@Override
	protected void end() {
		
	}


	@Override
	protected void interrupted() {
		
		end();
	}
}
