package team1065.robot.frc2017.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team1065.robot.frc2017.Robot;

/**
 *
 */
public class AutoBoiler extends CommandGroup {

    public AutoBoiler() {
    	int allianceMultiplier = Robot.oi.isRedAlliance()? 1:-1;
    	//go score gear
    	addSequential(new DriveToDistance(0.4, 101, 15.0));
    	addSequential(new RotateToAngle(.4, -54.5 * allianceMultiplier, 15.0));
    	addSequential(new DriveToDistance(0.5, 11, 15.0));
    	addParallel(new PushGearForTime(1.0));
    	addSequential(new DriveForTime(0,0,0.1));
    	addSequential(new DriveToDistance(-0.5, 15, 15.0));
    	
    	//WORKING GEAR SCORE
    	/*
    	addSequential(new DriveToDistance(0.4, 99, 15.0));
    	addSequential(new RotateToAngle(.4, -60 * allianceMultiplier, 15.0));
    	addSequential(new DriveToDistance(0.5, 16, 15.0));
    	addParallel(new PushGearForTime(1.0));
    	addSequential(new DriveForTime(0,0,0.1));
    	addSequential(new DriveToDistance(-0.5, 16, 15.0));
    	*/
    	
    	//go shoot(1)
    	/*
    	addSequential(new RotateToAngle(.4, 145 * allianceMultiplier, 15.0));
    	addSequential(new SetShooterSpeed(1800));
    	addSequential(new DriveToDistance(0.4, 64.30, 15.0));
    	addSequential(new RotateToAngle(.4, 136 * allianceMultiplier, 15.0));
    	addSequential(new DriveToDistance(0.4, 32, 15.0));
    	addSequential(new DriveForTime(0.3,0.3,0.8));
    	addSequential(new DriveForTime(0,0,0.2));
    	addSequential(new ShootForTime(5.0));*/
    	//go shoot(2)
    	
    	addSequential(new RotateToAngle(.7, 141.5 * allianceMultiplier, 15.0));
    	addSequential(new SetShooterSpeed(1750));
    	addSequential(new DriveToDistance(0.7, 92.5, 15.0));
    	addSequential(new DriveForTime(0.4,0.4,0.4));
    	addSequential(new DriveForTime(0,0,0.01));
    	addSequential(new ShootForTime(5.0));
    }
}
