package org.usfirst.frc.team1212.robot.subsystems;

import org.usfirst.frc.team1212.robot.RobotMap;
import org.usfirst.frc.team1212.robot.commands.ExtendHerdersCom;
import org.usfirst.frc.team1212.robot.commands.RetractHerdersCom;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HerderSub extends Subsystem {
	
	//these instance variables are actually useless. Instead it is easier to
	//link to the robot map from the public methods below.
	
	
	private final DoubleSolenoid herderSol = RobotMap.herderSol;


	
	//Sets the default command to extend the herders at the beginning of teleop
	@Override
	protected void initDefaultCommand() {
		
		

	}
	
	//public methods for controlling the elevator subsystem
	
	 @Override
	    public void periodic() {

	    }
	 
	 public void RetractHerders() {
		 herderSol.set(DoubleSolenoid.Value.kForward);
	 }
	 
	 public void ExtendHerders() {
		 herderSol.set(DoubleSolenoid.Value.kReverse);
	 }
	 


	 

	 

	 

 

}
