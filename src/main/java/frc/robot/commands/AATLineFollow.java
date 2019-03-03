/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1212.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1212.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class AATLineFollow extends Command {
  public AATLineFollow() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Line auto-correction
		if (Robot.oi.getMidEye() == true) {
			Robot.driveTrain.AutoMecDrive(0, (Robot.oi.driveStick.getRawAxis(2)) / 2.0, 0);
		} else if (Robot.oi.getLeftEye() == false) {
			Robot.driveTrain.AutoMecDrive(0, Robot.oi.driveStick.getRawAxis(2), (Robot.oi.driveStick.getRawAxis(2)) / 2.0);
		} else if (Robot.oi.getRightEye() == false) {
			Robot.driveTrain.AutoMecDrive(0, Robot.oi.driveStick.getRawAxis(2), -(Robot.oi.driveStick.getRawAxis(2)) / 2.0);
		} else if (Robot.oi.getLeftEye() == false && Robot.oi.getMidEye() == true) {
			Robot.driveTrain.AutoMecDrive(0, Robot.oi.driveStick.getRawAxis(2), (Robot.oi.driveStick.getRawAxis(2)) / 3.0);
		} else if (Robot.oi.getRightEye() == false && Robot.oi.getMidEye() == true) {
			Robot.driveTrain.AutoMecDrive(0, Robot.oi.driveStick.getRawAxis(2), -(Robot.oi.driveStick.getRawAxis(2)) / 3.0);
		}
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.AutoMecDrive(0, 0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
