/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public Joystick driverPad = new Joystick(0);
  public Joystick opPad = new Joystick(1);

  private static final double STICK_DEADBAND = 0.6;

  public JoystickButton extendSol1 = new JoystickButton(driverPad, JoystickMap.A);
  public JoystickButton retractSol1 = new JoystickButton(driverPad, JoystickMap.B);
  public JoystickButton extendSol2 = new JoystickButton(driverPad, JoystickMap.X);
  public JoystickButton retractSol2 = new JoystickButton(driverPad, JoystickMap.Y);
  public JoystickButton extendBoth = new JoystickButton(driverPad, JoystickMap.LB);
  public JoystickButton retractBoth = new JoystickButton(driverPad, JoystickMap.RB);

  public OI(){
    extendSol1.whenPressed(new MoveSol1Cmd(true));
    retractSol1.whenPressed(new MoveSol1Cmd(false));

    extendSol2.whenPressed(new MoveSol2Cmd(true));
    retractSol2.whenPressed(new MoveSol2Cmd(false));

    extendBoth.whenPressed(new MoveBothSolCmd(true));
    retractBoth.whenPressed(new MoveBothSolCmd(false));
  
  }

  private static double stickDeadband(double value, double deadband, double center) {
      return (value < (center + deadband) && value > (center - deadband)) ? center : value;
  }
  public double getDriverLeftStickY() {
      return stickDeadband(this.driverPad.getRawAxis(JoystickMap.LEFT_Y), STICK_DEADBAND, 0.0);
  }
  public double getDriverLeftStickX() {
      return stickDeadband(this.driverPad.getRawAxis(JoystickMap.LEFT_X), STICK_DEADBAND, 0.0);
  }
  public double getDriverRightStickY() {
      return stickDeadband(this.driverPad.getRawAxis(JoystickMap.RIGHT_Y), STICK_DEADBAND, 0.0);
  }
  public double getDriverRightStickX() {
      return stickDeadband(this.driverPad.getRawAxis(JoystickMap.RIGHT_X), STICK_DEADBAND, 0.0);
  }
  public double getDriverTriggerSum() {
      return this.driverPad.getRawAxis(JoystickMap.RIGHT_TRIGGER) - this.driverPad.getRawAxis(JoystickMap.LEFT_TRIGGER);
  }
  public double getOpRightTrigger() {
      return this.opPad.getRawAxis(JoystickMap.RIGHT_TRIGGER);
  }
  public double getOpLeftStickX() {
      return stickDeadband(this.opPad.getRawAxis(JoystickMap.LEFT_X), STICK_DEADBAND, 0.0);
  }

}
