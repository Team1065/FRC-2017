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
    	//go shoot
    	addSequential(new RotateToAngle(.7, 141.5 * allianceMultiplier, 15.0));
    	addSequential(new SetShooterSpeed(1750));
    	addSequential(new DriveToDistance(0.7, 92.5, 15.0));
    	addSequential(new DriveForTime(0.4,0.4,0.4));
    	addSequential(new DriveForTime(0,0,0.01));
    	addSequential(new ShootForTime(5.0));
    }
}
