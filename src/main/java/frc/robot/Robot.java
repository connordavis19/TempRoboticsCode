/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 * 
 * This is a basic project to implement a Mecanum Drive Train using the Spark
 * MAX motor controllers (with brushless motors).
 * 
 * UPDATE 1: Added shifter code UPDATE 2: Linked Mecanum and arcade (although
 * this time it's just modified mecanum) to the shifter code. UPDATE 3: Added
 * configurable deadband and fixed ramprate. UPDATE 4: Added lifter, elevator,
 * and herder motors.
 */
public class Robot extends TimedRobot {
  public CANSparkMax fL, fR, rL, rR;
  public VictorSPX l1, l2, e, h1, h2, b, lD;
  public Joystick myJoy, myJoy2;
  public MecanumDrive myDrive;
  public DoubleSolenoid shifter;
  public boolean shiftToggle, debounce, debounce_two;
  public double joyX, joyY, joyZ;
  public double deadband;
  public boolean driveToggle;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    // initialize motors
    fL = new CANSparkMax(3, MotorType.kBrushless); // front left
    fR = new CANSparkMax(5, MotorType.kBrushless); // front right
    rL = new CANSparkMax(2, MotorType.kBrushless); // rear left
    rR = new CANSparkMax(4, MotorType.kBrushless); // rear right

    l1 = new VictorSPX(0); // front lifter
    l2 = new VictorSPX(0); // rear lifter

    e = new VictorSPX(10); // elevator nyoom

    h1 = new VictorSPX(0); // left herder
    h2 = new VictorSPX(0); // right herder

    b = new VictorSPX(0); // ball holder (rotate in and out)

    lD = new VictorSPX(0); // lift drive

    // set motor ramp rate
    fL.setOpenLoopRampRate(1);
    fR.setOpenLoopRampRate(1);
    rL.setOpenLoopRampRate(1);
    rR.setOpenLoopRampRate(1);
    fL.setClosedLoopRampRate(1);
    fR.setClosedLoopRampRate(1);
    rL.setClosedLoopRampRate(1);
    rR.setClosedLoopRampRate(1);

    // set deadband
    deadband = 0.01;

    // invert motors
    fL.setInverted(false);
    fR.setInverted(false);
    rL.setInverted(false);
    rR.setInverted(false);

    // initialize joysticks
    myJoy = new Joystick(0);
    myJoy2 = new Joystick(1);

    // initialize drivetrain
    myDrive = new MecanumDrive(fL, fR, rL, rR);

    // initialize DoubleSolenoid (and assosciated booleans)
    shifter = new DoubleSolenoid(0, 1);
    shiftToggle = true;
    debounce = false;

    // set driveToggle to default (mecanum/arcade)
    driveToggle = false;
    debounce_two = false;
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    /**
     * Logitech Controller ("Joystick") axis map:
     * 0 - Left stick X
     * 1 - Left stick Y
     * 2 - Left analog trigger
     * 3 - Right analog trigger
     * 4 - Right stick X
     * 5 - Right stick Y
     */

    // set up joystic axis values and adds deadband
    joyX = addDeadband(myJoy.getRawAxis(1));
    joyY = addDeadband(myJoy.getRawAxis(0));
    joyZ = addDeadband(myJoy.getRawAxis(4));

    // control lifter motors
    double l1Speed = 0;
    double l2Speed = 0;

    if (myJoy.getRawButton(10)) // front lifter up
      l1Speed += 0.25;

    if (myJoy.getRawButton(10)) // rear lifter up
      l2Speed += 0.25;

    if (myJoy.getRawButton(10)) { // both lifters up
      l1Speed += 0.25;
      l2Speed += 0.25;
    }

    if (myJoy.getRawButton(10)) // front lifter down
      l1Speed -= 0.25;

    if (myJoy.getRawButton(10)) // rear lifter down
      l2Speed -= 0.25;

    if (myJoy.getRawButton(10)) { // both lifters down
      l1Speed -= 0.25;
      l2Speed -= 0.25;
    }

    l1.set(ControlMode.PercentOutput, l1Speed);
    l2.set(ControlMode.PercentOutput, l2Speed);

    // control herders
    if (myJoy.getRawButton(10)) { // herders out
      h1.set(ControlMode.PercentOutput, 0.5);
      h2.set(ControlMode.PercentOutput, 0.5);
    } else if (myJoy.getRawButton(10)) { // herders in
      h1.set(ControlMode.PercentOutput, -0.5);
      h2.set(ControlMode.PercentOutput, -0.5);
    } else {
      h1.set(ControlMode.PercentOutput, 0);
      h2.set(ControlMode.PercentOutput, 0);
    }

    // control elevator
    if (myJoy.getRawButton(2)) // elevator up
      e.set(ControlMode.PercentOutput, 0.25);
    else if (myJoy.getRawButton(3)) // elevator down
      e.set(ControlMode.PercentOutput, -0.25);
    else
      e.set(ControlMode.PercentOutput, 0);

    // control ball holder
    if (myJoy.getRawButton(10)) // holder out
      b.set(ControlMode.PercentOutput, 0.25);
    else if (myJoy.getRawButton(10)) // holder in
      b.set(ControlMode.PercentOutput, -0.25);
    else
      b.set(ControlMode.PercentOutput, 0);

    // control drive toggle
    if (myJoy.getRawButton(10) && !debounce_two) { // drive toggle
      driveToggle = !driveToggle;
      debounce_two = true;
    } else
      debounce_two = false;

    // control robotDrive
    if (driveToggle) {
      lD.set(ControlMode.PercentOutput, joyY);
      if (myJoy.getRawButton(1)) // disable driveToggle on press (and shifts)
        driveToggle = false;
    } else {
      // toggles shifter
      if (myJoy.getRawButton(1)) {  // shifter (toggle)
        if (!debounce)
          shiftToggle = !shiftToggle;
        debounce = true;
      } else
        debounce = false;
      
      if (shiftToggle) {
        shifter.set(Value.kForward);
        myDrive.driveCartesian(-joyX, 0, joyZ); // arcade (mecanum without the Y)
      } else {
        shifter.set(Value.kReverse);
        myDrive.driveCartesian(-joyX, joyY, joyZ); // mecanum (with the Y)
      }
    }
  }

  /**
   * This method adds a deadband to any Joystick axis (set deadband in robotInit)
   */
  public double addDeadband(double x) {
    if (x >= deadband)
      return x;
    else if (x <= -deadband)
      return x;
    else
      return 0;
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    shifter.set(Value.kForward);
  }
}
