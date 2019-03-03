package org.usfirst.frc.team1212.robot.commands;


import org.usfirst.frc.team1212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoForwardUntilEye extends Command {

	protected double gyroValue;
	private double initialGyroValue;
	
public AutoForwardUntilEye() {
		
		requires(Robot.driveTrain);
	}

	public AutoForwardUntilEye(double timeout) {
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
		Robot.driveTrain.AutoMecDrive(0, 0.25, 0);
		gyroValue = Robot.driveTrain.getGyro();
		initialGyroValue = Robot.driveTrain.getGyro();
	}
	
	@Override
		protected void execute() {
		Robot.driveTrain.AutoMecDrive(0, 0.25, gyroTurn());
	}

	@Override
	protected boolean isFinished() {
		if (Robot.oi.getLeftEye() == true 
				|| Robot.oi.getRightEye()== true
				|| isTimedOut()== true) {
			return true;
	}
		else {
		return false;
	
	}
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

