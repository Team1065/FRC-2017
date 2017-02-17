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
    	addSequential(new DriveToDistance(0.4, 59, 15.0));
    	addSequential(new DriveForTime(0,0,0.5));
    	addSequential(new RotateToAngle(.4, -60 * allianceMultiplier, 15.0));
    	addSequential(new DriveForTime(0,0,0.5));
    	addSequential(new DriveToDistance(0.4, 85, 15.0));
    	addSequential(new PushGearForTime(1.0));
    	//go shoot
    	addSequential(new DriveToDistance(-0.4, 20, 15.0));
    	addSequential(new DriveForTime(0,0,0.5));
    	addSequential(new RotateToAngle(.4, 150 * allianceMultiplier, 15.0));
    	addSequential(new DriveForTime(0,0,0.3));
    	addSequential(new SetShooterSpeed(1800));
    	addSequential(new DriveToDistance(0.4, 85, 15.0));
    	addSequential(new DriveForTime(0.3,0.3,1.0));
    	addSequential(new ShootForTime(5.0));
    }
}
