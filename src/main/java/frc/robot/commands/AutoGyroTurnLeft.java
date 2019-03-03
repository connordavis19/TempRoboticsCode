package org.usfirst.frc.team1212.robot.commands;

import org.usfirst.frc.team1212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoGyroTurnLeft extends Command {

	protected double gyroValue;
	private double initialGyroValue;

	public AutoGyroTurnLeft() {

		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
		initialGyroValue = Robot.driveTrain.getGyro();
		Robot.driveTrain.AutoMecDrive(0, 0, -.25);
		gyroValue = Robot.driveTrain.getGyro();
	}

	@Override
	protected void execute() {
		Robot.driveTrain.AutoMecDrive(0, 0, -.25);
		gyroValue = Robot.driveTrain.getGyro();
	}

	@Override
	protected boolean isFinished() {
		if (gyroValue > initialGyroValue || gyroValue >= initialGyroValue-85) {
			return false;
		}
		else
		return true;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

		end();
	}
}
