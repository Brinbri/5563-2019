/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class TestPnumaticSubsystem extends Subsystem {
  private Solenoid testSolenoid1 = new Solenoid(RobotMap.SOLENOID_1);
  private Solenoid testSolenoid2 = new Solenoid(RobotMap.SOLENOID_2);

  public TestPnumaticSubsystem(){

  }

  public void extendSol1(boolean value){
    testSolenoid1.set(value);
  }

  public void extendSol2(boolean value){
    testSolenoid2.set(value);
  }


  public void extendBoth(boolean value){
    testSolenoid1.set(value);
    testSolenoid2.set(value);
  }

  @Override
  public void initDefaultCommand() {

  }
}
