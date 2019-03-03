// RobotBuilder Version: 2.0
//

package frc.robot;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

public class OI {

	// declare all instance variables for Joysticks, buttons, and axis

    public Joystick driveStick;
	public JoystickButton shiftBbutton;
	public double xValue;
	public double yValue;
	public double twistValue;
	public double autoForwardVal;

	public Joystick elevatorStick;
	public JoystickButton elevatorUpButton;
	public JoystickButton elevatorDownButton;

	public JoystickButton herdersInButton;
	public JoystickButton herdersOutButton;
	public JoystickButton retractHerdersButton;
	public JoystickButton activateAuto;

	public double armsInValue;
	public double armsOutValue;
	
    private static DigitalInput rightEye;
    private static DigitalInput midEye;
    private static DigitalInput leftEye;

	// OI constructor method
	public OI() {

		// Create objects for all buttons and controllers and assign them to commands

		driveStick = new Joystick(0);
		shiftBbutton = new JoystickButton(driveStick, 9);
		shiftBbutton.toggleWhenActive(new ArcadeDriveCom());
		xValue = driveStick.getRawAxis(0);
		yValue = driveStick.getRawAxis(1);
		twistValue = driveStick.getRawAxis(4);
		autoForwardVal = driveStick.getRawAxis(2);

		elevatorStick = new Joystick(1);
		elevatorUpButton = new JoystickButton(elevatorStick, 4);
		elevatorDownButton = new JoystickButton(elevatorStick, 2);
		elevatorUpButton.whileHeld(new ElevatorUpCom());
		elevatorDownButton.whileHeld(new ElevatorDownCom());
		herdersInButton = new JoystickButton(elevatorStick, 1);
		herdersOutButton = new JoystickButton(elevatorStick, 3);
		herdersInButton.whileHeld(new HerdersInCom());
		herdersOutButton.whileHeld(new HerdersOutCom());
		armsInValue = elevatorStick.getRawAxis(2);
		armsOutValue = -elevatorStick.getRawAxis(3);
		retractHerdersButton = new JoystickButton(elevatorStick, 9);
		retractHerdersButton.toggleWhenActive(new ExtendHerdersCom());
		activateAuto = new JoystickButton(driveStick, 6);
		activateAuto.whileHeld(new AATLineFollow());
		rightEye = new DigitalInput(3);
        leftEye = new DigitalInput(4);
        midEye = new DigitalInput(2);

		// Add commands to the SmartDashboard

		SmartDashboard.putData("MecanumDrive", new MecanumDriveCom());
		SmartDashboard.putData("ArcadeDrive", new ArcadeDriveCom());
		SmartDashboard.putData("AutoForwardUntilEye", new AutoForwardUntilEye());
		SmartDashboard.putData("AutoStrafeLeft", new AutoStrafeLeft());
		SmartDashboard.putData("AutoStrafeRight", new AutoStrafeRight());
		SmartDashboard.putData("AutoElevatorUp", new AutoElevatorUp());
		SmartDashboard.putData("AALineFollow", new AALineFollow());
		SmartDashboard.putData("AAGroup", new AAGroup());
		SmartDashboard.putData("AutoGyroTurnLeft", new AutoGyroTurnLeft());
		SmartDashboard.putData("AutoGyroTurnRight", new AutoGyroTurnRight());
		SmartDashboard.putData("AutoHerdersIn", new AutoHerdersIn());
		SmartDashboard.putData("AutoHerdersOut", new AutoHerdersOut());
		SmartDashboard.putData("AutonomousLeft", new AutoLeftGroup());
		SmartDashboard.putData("AutonomousRight", new AutoRightGroup());
		SmartDashboard.putData("AutonomousCenter", new AutoCenterGroup());
		SmartDashboard.putData("Herders Up", new RetractHerdersCom());
		SmartDashboard.putData("Herders Down", new ExtendHerdersCom());       
        SmartDashboard.putData(leftEye);
        SmartDashboard.putData(rightEye);
        SmartDashboard.putData(midEye);
	}

	// public methods for getting axis and joysticks

	public Joystick getdriveStick() {
		return driveStick;
	}

	public Joystick getelevatorStick() {
		return driveStick;
	}

	public double getXValue() {
		return 1 * -driveStick.getRawAxis(1);
	}

	public double getYValue() {
		return 1 * driveStick.getRawAxis(0);
	}

	public double getTwistValue() {
		return 0.25 * driveStick.getRawAxis(4);
	}

	public double getArmsInValue() {
		return elevatorStick.getRawAxis(2);
	}

	public double getArmsOutValue() {
		return -elevatorStick.getRawAxis(3);
	}

	public boolean getMidEye() {
		return midEye.get();
	}

	public boolean getLeftEye() {
		return leftEye.get();
	}

	public boolean getRightEye() {
		return rightEye.get();
	}

}
