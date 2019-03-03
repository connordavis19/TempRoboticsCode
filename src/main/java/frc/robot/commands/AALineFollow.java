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

public class AALineFollow extends Command {
  public AALineFollow() {
    this(0);

    setTimeout(1000);
  }
  
  public AALineFollow(double timeout) {
    super(timeout);
    requires(Robot.driveTrain);
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
			Robot.driveTrain.AutoMecDrive(0, 0.20, 0);
		} else if (Robot.oi.getLeftEye() == true) {
			Robot.driveTrain.AutoMecDrive(0, 0.20, -0.22);
		} else if (Robot.oi.getRightEye() == true) {
			Robot.driveTrain.AutoMecDrive(0, 0.20, 0.22);
		} else if (Robot.oi.getLeftEye() == true && Robot.oi.getMidEye() == true) {
			Robot.driveTrain.AutoMecDrive(0, 0.20, -0.15);
		} else if (Robot.oi.getRightEye() == true && Robot.oi.getMidEye() == true) {
			Robot.driveTrain.AutoMecDrive(0, 0.20, 0.15);
		} else {
      Robot.driveTrain.AutoMecDrive(0, 0.10, 0);
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
