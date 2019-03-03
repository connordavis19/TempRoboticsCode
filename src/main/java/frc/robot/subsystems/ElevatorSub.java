package org.usfirst.frc.team1212.robot.subsystems;

import org.usfirst.frc.team1212.robot.Robot;
import org.usfirst.frc.team1212.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorSub extends Subsystem {
	
	//these instance variables are actually useless. Instead it is easier to
	//link to the robot map from the public methods below.
	
	private final WPI_TalonSRX rightArm = RobotMap.rightArm;
	private final WPI_TalonSRX leftArm = RobotMap.leftArm;
	
	private final WPI_TalonSRX rightElevator = RobotMap.rightElevator;
	private final WPI_TalonSRX leftElevator = RobotMap.leftElevator;
	
	private final WPI_VictorSPX rightHerder = RobotMap.rightHerder;
	private final WPI_VictorSPX leftHerder = RobotMap.leftHerder;
	
	private final DigitalInput topLimit = RobotMap.topLimit;
	private final DigitalInput bottomLimit = RobotMap.bottomLimit;
	



	
	//Sets the default command to extend the herders at the beginning of teleop
	@Override
	protected void initDefaultCommand() {
		

	}
	
	//public methods for controlling the elevator subsystem
	
	 @Override
	    public void periodic() {

	    }
	 

	 
	 public boolean getTopLimit() {
		 return !topLimit.get();
	 }
	 
	 public boolean getBottomLimit() {
		 return !bottomLimit.get();
	 }
	 
	 public void ElevatorUp() {
		 
		 rightElevator.set(-1);
		 leftElevator.set(1);
		 
	 }
	 
	 public void ElevatorDown() {
		 
		 rightElevator.set(1);
		 leftElevator.set(-1);
		 
	 }
	 
	 public void ElevatorStop() {
		 
		 rightElevator.set(0);
		 leftElevator.set(0);
		 
	 }
	 
	 public void HerdersOut() {
		 
		 rightHerder.set(1);
		 leftHerder.set(-1);
		 
	 }
	 
	 public void HerdersIn() {
		 
		 rightHerder.set(-1);
		 leftHerder.set(1);
		 
	 }
	 
	 public void HerdersStop() {
		 
		 rightHerder.set(0);
		 leftHerder.set(0);
		 
	 }
	 
	 public void ArmsIn(Joystick elevatorStick) {
		 
		 rightArm.set(Robot.oi.armsInValue);
		 leftArm.set(Robot.oi.armsOutValue);
		 
	 }
	 
	 public void ArmsOut(Joystick elevatorStick) {
		 
		 rightArm.set(-Robot.oi.armsInValue);
		 leftArm.set(-Robot.oi.armsOutValue);
		 
	 }
 
	 public void ArmsStop() {
	 
		 rightArm.set(0);
		 leftArm.set(0);
	 
 }

}
