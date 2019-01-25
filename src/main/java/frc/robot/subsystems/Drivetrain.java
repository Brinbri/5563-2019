/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  private VictorSPX leftDriveLeader = new VictorSPX(RobotMap.MOTOR_1);
  private VictorSPX leftDriveFollower = new VictorSPX(RobotMap.MOTOR_2);
  private VictorSPX rightDriveLeader = new VictorSPX(RobotMap.MOTOR_4);
  private VictorSPX rightDriveFollower = new VictorSPX(RobotMap.MOTOR_3);

  public Drivetrain(){
    this.leftDriveFollower.follow(leftDriveLeader);
    this.rightDriveFollower.follow(rightDriveLeader);

    this.leftDriveLeader.setInverted(false);
    this.leftDriveFollower.setInverted(false);
    this.rightDriveLeader.setInverted(true);
    this.rightDriveFollower.setInverted(true);

  }

  public void drive(double powLeft, double powRight){
    leftDriveLeader.set(ControlMode.PercentOutput, powLeft);
    rightDriveLeader.set(ControlMode.PercentOutput, powRight);
  }

  public void driveArcade(double throttle, double turn){
    drive(throttle + turn, turn - throttle);
  }

  @Override
  public void initDefaultCommand() {
  
  }
}
