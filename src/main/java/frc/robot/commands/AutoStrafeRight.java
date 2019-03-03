package org.usfirst.frc.team1212.robot.commands;

import org.usfirst.frc.team1212.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class AutoStrafeRight extends TimedCommand{

	protected double gyroValue;
	private double initialGyroValue;

	public AutoStrafeRight() {
		this(0);
		// Change this value to change time
		setTimeout(3);
	}

	public AutoStrafeRight(double timeout) {
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
		gyroValue = Robot.driveTrain.getGyro();
		initialGyroValue = Robot.driveTrain.getGyro();
	}

	@Override
	protected void execute() {
			Robot.driveTrain.AutoMecDrive(0.5, 0, gyroTurn());
			gyroValue = Robot.driveTrain.getGyro();

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
