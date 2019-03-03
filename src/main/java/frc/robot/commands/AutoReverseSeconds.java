package org.usfirst.frc.team1212.robot.commands;

import org.usfirst.frc.team1212.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class AutoReverseSeconds extends TimedCommand{
	
	protected double gyroValue;
	private double initialGyroValue;
	
	public AutoReverseSeconds() {
        this(0);
        
        setTimeout(3);
    }

    public AutoReverseSeconds(double timeout) {
        super(timeout);
        requires(Robot.driveTrain);

    }

	 private double gyroTurn() {
	    	while (isTimedOut() == false && gyroValue > initialGyroValue+3){
	    		return -0.25;
	    	}
	    	while (isTimedOut() == false && gyroValue < initialGyroValue-3){
	    		return 0.25;
	    	}
	    	return 0;
	    }
    
	@Override
	protected void initialize() {
		
		Robot.driveTrain.AutoMecDrive(0, 0.5, 0);
		gyroValue = Robot.driveTrain.getGyro();
		initialGyroValue = Robot.driveTrain.getGyro();
	}

	@Override
	protected void execute() {
		Robot.driveTrain.AutoMecDrive(0, -0.5, gyroTurn());
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		
		Robot.driveTrain.AutoMecDrive(0, 0, 0);
	}


	@Override
	protected void interrupted() {
		
		end();
	}
}
